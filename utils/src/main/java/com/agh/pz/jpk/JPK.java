package com.agh.pz.jpk;

import com.agh.pz.jpk.invoice.Invoice;
import com.agh.pz.jpk.invoice.InvoiceControl;
import com.agh.pz.jpk.invoiceRow.InvoiceRow;
import com.agh.pz.jpk.invoiceRow.InvoiceRowControl;
import com.agh.pz.jpk.entity.Entity;
import com.agh.pz.jpk.header.Header;
import com.agh.pz.parser.Parser;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

/**
 * POJO Class for JPK document
 */
@XmlRootElement(name = "JPK", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
public class JPK {
    @XmlElement(name = "Naglowek", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private Header header;

    @XmlElement(name = "Podmiot1", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private Entity entity;

    @XmlElement(name = "Faktura", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private List<Invoice> invoices;

    @XmlElement(name = "FakturaCtrl", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private InvoiceControl invoiceControl;

    @XmlElement(name = "FakturaWiersz", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private List<InvoiceRow> invoiceRows;

    @XmlElement(name = "FakturaWierszCtrl", namespace="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private InvoiceRowControl invoiceRowControl;

    public JPK() {}


    public JPK(Header header, Entity entity, Parser parser) {
        this.header = header;
        this.entity = entity;
        if (parser != null){
            this.invoices = parser.getInvoices();
            this.invoiceControl = parser.getInvoiceControl();
            this.invoiceRows = parser.getInvoiceRows();
            this.invoiceRowControl = parser.getInvoiceRowControl();
        }
    }
}
