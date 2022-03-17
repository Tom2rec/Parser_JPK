package com.agh.pz.parser;

import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.invoice.Invoice;
import com.agh.pz.jpk.invoice.InvoiceControl;
import com.agh.pz.jpk.invoiceRow.InvoiceRow;
import com.agh.pz.jpk.invoiceRow.InvoiceRowControl;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parser xlsx document
 */
public class ParserXLSX  extends Parser{
    public ParserXLSX(String path, Entity entity) {
        super(path, entity);
    }

    /**
     * main method to parse xlsx document to pojo
     */
    @Override
    public void parse() {
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File(getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Workbook workbook = new XSSFWorkbook(file);
            var sheet = workbook.getSheetAt(0);
            sheet.shiftRows(1, sheet.getLastRowNum(), -1);

            List<Invoice> invoices = new ArrayList<>();
            List<InvoiceRow> invoiceRows = new ArrayList<>();

            for (Row row : sheet) {

                var invoice = new Invoice();
                invoice.setP1(LocalDate.parse(row.getCell(3).getStringCellValue()));
                invoice.setP2a(row.getCell(5).getStringCellValue());
                invoice.setP3a(row.getCell(0).getStringCellValue());
                invoice.setP5b(row.getCell(2).getStringCellValue());
                invoice.setP6(LocalDate.parse(row.getCell(4).getStringCellValue()));
                invoice.setP131(row.getCell(13).getStringCellValue());
                invoice.setP15(row.getCell(14).getStringCellValue());
                invoices.add(invoice);

                var invoiceRow = new InvoiceRow();
                invoiceRow.setP2b(row.getCell(5).getStringCellValue());
                switch (row.getCell(7).getCellType()) {
                    case NUMERIC -> invoiceRow.setP8b(String.valueOf(row.getCell(7).getNumericCellValue()));
                    case STRING -> invoiceRow.setP8b(String.valueOf(row.getCell(7).getStringCellValue()));
                    default -> invoiceRow.setP8b("");
                }
                invoiceRow.setP8b("");
                invoiceRow.setP9a(row.getCell(8).getStringCellValue());
                invoiceRow.setP11(row.getCell(11).getStringCellValue());
                invoiceRow.setP12((int) row.getCell(9).getNumericCellValue());
                invoiceRows.add(invoiceRow);
            }

            invoices = invoices.stream()
                    .distinct()
                    .collect(Collectors.toList());

            setInvoices(prepareInvoice(invoices));
            setInvoiceControl(new InvoiceControl(invoices.size(),getInvoiceSumValue()));
            setInvoiceRows(prepareInvoiceRow(invoiceRows));
            setInvoiceRowControl(new InvoiceRowControl(invoiceRows.size(), getInvoiceRowSumValue()));

            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
