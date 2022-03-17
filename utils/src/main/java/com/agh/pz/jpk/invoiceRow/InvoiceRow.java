package com.agh.pz.jpk.invoiceRow;

import com.agh.pz.jpk.adapter.FloatAdapter;
import com.opencsv.bean.CsvBindByName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * POJO Class for invoice row
 */
@XmlRootElement(name = "FakturaWiersz")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceRow {

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_2B")
    @CsvBindByName(column = "Nr faktury")
    private String p2b;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_7")
    private String p7 = "Sprzedaż usług krajowych";

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_8A")
    private String p8a = "szt";

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_8B")
    @CsvBindByName(column = "Liczba sztuk")
    private String p8b;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_9A")
    @CsvBindByName(column = "Cena jednostkowa")
    private String p9a;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_9B")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    private Float p9b;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_11")
    @CsvBindByName(column = "Cena netto pozycji")
    private String p11;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_12")
    @CsvBindByName(column = "Stawka podatku %")
    private int p12;

    public InvoiceRow() {}

    public InvoiceRow(String p2b, String p7, String p8a, String p8b, String p9a, Float p9b, String p11, int p12) {
        this.p2b = p2b;
        this.p7 = p7;
        this.p8a = p8a;
        this.p8b = p8b;
        this.p9a = p9a;
        this.p9b = p9b;
        this.p11 = p11;
        this.p12 = p12;
    }

    public String getP2b() {
        return p2b;
    }

    public void setP2b(String p2b) {
        this.p2b = p2b;
    }

    public String getP7() {
        return p7;
    }

    public void setP7(String p7) {
        this.p7 = p7;
    }

    public String getP8a() {
        return p8a;
    }

    public void setP8a(String p8a) {
        this.p8a = p8a;
    }

    public String getP8b() {
        return p8b;
    }

    public void setP8b(String p8b) {
        this.p8b = p8b;
    }

    public String getP9a() {
        return p9a;
    }

    public void setP9a(String p9a) {
        this.p9a = p9a;
    }

    public Float getP9b() {
        return p9b;
    }

    public void setP9b(Float p9b) {
        this.p9b = p9b;
    }

    public String getP11() {
        return p11;
    }

    public void setP11(String p11) {
        this.p11 = p11;
    }

    public int getP12() {
        return p12;
    }

    public void setP12(int p12) {
        this.p12 = p12;
    }
}
