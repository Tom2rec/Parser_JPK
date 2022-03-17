package com.agh.pz.parser;

import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.invoice.Invoice;
import com.agh.pz.jpk.invoice.InvoiceControl;
import com.agh.pz.jpk.invoiceRow.InvoiceRow;
import com.agh.pz.jpk.invoiceRow.InvoiceRowControl;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Parser csv document
 */
public class ParserCSV extends Parser {
    public ParserCSV(String path, Entity entity) {
        super(path, entity);
    }

    /**
     * main method to parse csv document to pojo
     */
    @Override
    public void parse() {
        try {
            List<Invoice> readInvoices = new CsvToBeanBuilder<Invoice>(new FileReader(getPath()))
                    .withType(Invoice.class)
                    .withSeparator('\t')
                    .build()
                    .parse();

            readInvoices = readInvoices.stream()
                    .distinct()
                    .collect(Collectors.toList());


            setInvoices(prepareInvoice(readInvoices));
            setInvoiceControl(new InvoiceControl(readInvoices.size(), getInvoiceSumValue()));

            List<InvoiceRow> readInvoicesRow = new CsvToBeanBuilder<InvoiceRow>(new FileReader(getPath()))
                    .withType(InvoiceRow.class)
                    .withSeparator('\t')
                    .build()
                    .parse();


            setInvoiceRows(prepareInvoiceRow(readInvoicesRow));
            setInvoiceRowControl(new InvoiceRowControl(readInvoicesRow.size(), getInvoiceRowSumValue()));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
