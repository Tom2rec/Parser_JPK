package com.agh.pz.parser;

import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.invoice.Invoice;
import com.agh.pz.jpk.invoice.InvoiceControl;
import com.agh.pz.jpk.invoiceRow.InvoiceRow;
import com.agh.pz.jpk.invoiceRow.InvoiceRowControl;

import java.util.ArrayList;
import java.util.List;

/**
 * Parser for jpk
 */
public abstract class Parser {
    private List<Invoice> invoices = new ArrayList<>();
    private InvoiceControl invoiceControl;
    private List<InvoiceRow> invoiceRows = new ArrayList<>();
    private InvoiceRowControl invoiceRowControl;
    private String path;
    private Entity entity;
    private float invoiceSumValue;
    private float invoiceRowSumValue;

    protected Parser(String path, Entity entity) {
        this.path = path;
        this.entity = entity;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public InvoiceControl getInvoiceControl() {
        return invoiceControl;
    }

    public void setInvoiceControl(InvoiceControl invoiceControl) {
        this.invoiceControl = invoiceControl;
    }

    public List<InvoiceRow> getInvoiceRows() {
        return invoiceRows;
    }

    public void setInvoiceRows(List<InvoiceRow> invoiceRows) {
        this.invoiceRows = invoiceRows;
    }

    public InvoiceRowControl getInvoiceRowControl() {
        return invoiceRowControl;
    }

    public void setInvoiceRowControl(InvoiceRowControl invoiceRowControl) {
        this.invoiceRowControl = invoiceRowControl;
    }

    public String getPath() {
        return path;
    }

    public abstract void parse();

    public Entity getEntity() {
        return entity;
    }

    /**
     * Converts different types of number strings to specifi format ex. 123.45
     * @param text connected number values
     * @return text in money format
     */
    public String toMoneyFormat(String text) {
        if(text == null) return null;
        text = text.replace(",", ".")
                .replaceAll("\u00A0", "")
                .replace("zł", "")
                .replaceAll(" ","");
        return text;
    }

    public float getInvoiceSumValue() {
        return invoiceSumValue;
    }


    public float getInvoiceRowSumValue() {
        return invoiceRowSumValue;
    }

    /**
     * Adding and modifying values, which cannot be read from document
     * @param invoices
     * @return invoices prepared to xml conversion
     */
    public List<Invoice> prepareInvoice(List<Invoice> invoices) {
        for (Invoice invoice : invoices) {
            invoice.setP15(toMoneyFormat(invoice.getP15()));
            invoice.setP131(toMoneyFormat(invoice.getP131()));
            invoice.setP3b(invoice.getP3a() + "-ADDRESS");
            invoice.setP141(Float.parseFloat(invoice.getP15()) - Float.parseFloat(invoice.getP131()));
            invoice.setP3c(getEntity().getEntityId().getFullName());

            var address = getEntity().getAddress();

            invoice.setP3d(address.getStreet() + " " + address.getHouseNumber() + "/" + address.getLocalNumber() + ", " +
                    address.getPostCode() + " " + address.getCity());
            invoice.setP4b(getEntity().getEntityId().getNip());
            invoiceSumValue += Float.parseFloat(invoice.getP15());
        }
        return invoices;
    }

    /**
     * Adding and modifying values, which cannot be read from document
     * @param invoiceRows row of invoices
     * @return invoices row prepared to xml conversion
     */
    public List<InvoiceRow> prepareInvoiceRow(List<InvoiceRow> invoiceRows) {
        for (InvoiceRow invoiceRow : invoiceRows) {
            invoiceRow.setP9a(toMoneyFormat(invoiceRow.getP9a()));
            invoiceRow.setP11(toMoneyFormat(invoiceRow.getP11()));
            invoiceRow.setP8b(toMoneyFormat(invoiceRow.getP8b()));

            invoiceRow.setP9b(Float.parseFloat(invoiceRow.getP9a()) * (100 + invoiceRow.getP12()) / 100);
            invoiceRowSumValue += Float.parseFloat(invoiceRow.getP11());
        }
        return invoiceRows;
    }
}
