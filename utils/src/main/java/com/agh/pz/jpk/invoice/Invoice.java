package com.agh.pz.jpk.invoice;

import com.agh.pz.jpk.adapter.FloatAdapter;
import com.agh.pz.jpk.adapter.LocalDateAdapter;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.util.Objects;


/**
 * POJO Class for invoice
 */
@XmlRootElement(name = "Faktura")
@XmlAccessorType(XmlAccessType.FIELD)
public class Invoice {
    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name = "KodWaluty")
    private String currencyCode = "PLN";

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_1")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @CsvBindByName(column = "Data wystawienia")
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate p1;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_2A")
    @CsvBindByName(column = "Nr faktury")
    private String p2a;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_3A")
    @CsvBindByName(column = "Nazwa odbiorcy")
    private String p3a;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_3B")
    private String p3b;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_3C")
    private String p3c;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_3D")
    private String p3d;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_4A")
    private String p4a = "PL";

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_4B")
    private String p4b;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_5B")
    @CsvBindByName(column = "NIP odbiorcy")
    private String p5b;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_6")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    @CsvBindByName(column = "Data sprzedaży")
    @CsvDate(value = "yyyy-MM-dd")
    private LocalDate p6;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_13_1")
    @CsvBindByName(column = "Cena netto faktury łącznie")
    private String p131;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_14_1")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    private Float p141;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_15")
    @CsvBindByName(column = "Cena brutto faktury łącznie")
    private String p15;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_16")
    private Boolean p16 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_17")
    private Boolean p17 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_18")
    private Boolean p18 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_18A")
    private Boolean p18a = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_19")
    private Boolean p19 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_20")
    private Boolean p20 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_21")
    private Boolean p21 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_22")
    private Boolean p22 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_23")
    private Boolean p23 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_106E_2")
    private Boolean p106e2 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="P_106E_3")
    private Boolean p106e3 = false;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="RodzajFaktury")
    private String invoiceType = "VAT";

    public Invoice() {}

    public Invoice(String currencyCode, LocalDate p1, String p2a, String p3a, String p3b, String p3c, String p3d,
                   String p4a, String p4b, String p5b, LocalDate p6, String p131, Float p141, String p15, Boolean p16,
                   Boolean p17, Boolean p18, Boolean p18a, Boolean p19, Boolean p20, Boolean p21, Boolean p22,
                   Boolean p23, Boolean p106e2, Boolean p106e3, String invoiceType) {
        this.currencyCode = currencyCode;
        this.p1 = p1;
        this.p2a = p2a;
        this.p3a = p3a;
        this.p3b = p3b;
        this.p3c = p3c;
        this.p3d = p3d;
        this.p4a = p4a;
        this.p4b = p4b;
        this.p5b = p5b;
        this.p6 = p6;
        this.p131 = p131;
        this.p141 = p141;
        this.p15 = p15;
        this.p16 = p16;
        this.p17 = p17;
        this.p18 = p18;
        this.p18a = p18a;
        this.p19 = p19;
        this.p20 = p20;
        this.p21 = p21;
        this.p22 = p22;
        this.p23 = p23;
        this.p106e2 = p106e2;
        this.p106e3 = p106e3;
        this.invoiceType = invoiceType;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "currencyCode='" + currencyCode + '\'' +
                ", p1=" + p1 +
                ", p2a='" + p2a + '\'' +
                ", p3a='" + p3a + '\'' +
                ", p3b='" + p3b + '\'' +
                ", p3c='" + p3c + '\'' +
                ", p3d='" + p3d + '\'' +
                ", p4a='" + p4a + '\'' +
                ", p4b='" + p4b + '\'' +
                ", p5b='" + p5b + '\'' +
                ", p6=" + p6 +
                ", p131=" + p131 +
                ", p141=" + p141 +
                ", p15=" + p15 +
                ", p16=" + p16 +
                ", p17=" + p17 +
                ", p18=" + p18 +
                ", p18a=" + p18a +
                ", p19=" + p19 +
                ", p20=" + p20 +
                ", p21=" + p21 +
                ", p22=" + p22 +
                ", p23=" + p23 +
                ", p106e2=" + p106e2 +
                ", p106e3=" + p106e3 +
                ", invoiceType='" + invoiceType + '\'' +
                '}';
    }

    public void setP131(String p131) {
        this.p131 = p131;
    }

    public void setP141(Float p141) {
        this.p141 = p141;
    }

    public void setP15(String p15) {
        this.p15 = p15;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public LocalDate getP1() {
        return p1;
    }

    public void setP1(LocalDate p1) {
        this.p1 = p1;
    }

    public String getP2a() {
        return p2a;
    }

    public void setP2a(String p2a) {
        this.p2a = p2a;
    }

    public String getP3c() {
        return p3c;
    }

    public void setP3c(String p3c) {
        this.p3c = p3c;
    }

    public String getP3d() {
        return p3d;
    }

    public void setP3d(String p3d) {
        this.p3d = p3d;
    }

    public String getP4a() {
        return p4a;
    }

    public void setP4a(String p4a) {
        this.p4a = p4a;
    }

    public String getP4b() {
        return p4b;
    }

    public void setP4b(String p4b) {
        this.p4b = p4b;
    }

    public String getP5b() {
        return p5b;
    }

    public void setP5b(String p5b) {
        this.p5b = p5b;
    }

    public LocalDate getP6() {
        return p6;
    }

    public void setP6(LocalDate p6) {
        this.p6 = p6;
    }

    public Float getP141() {
        return p141;
    }

    public Boolean getP16() {
        return p16;
    }

    public void setP16(Boolean p16) {
        this.p16 = p16;
    }

    public Boolean getP17() {
        return p17;
    }

    public void setP17(Boolean p17) {
        this.p17 = p17;
    }

    public Boolean getP18() {
        return p18;
    }

    public void setP18(Boolean p18) {
        this.p18 = p18;
    }

    public Boolean getP18a() {
        return p18a;
    }

    public void setP18a(Boolean p18a) {
        this.p18a = p18a;
    }

    public Boolean getP19() {
        return p19;
    }

    public void setP19(Boolean p19) {
        this.p19 = p19;
    }

    public Boolean getP20() {
        return p20;
    }

    public void setP20(Boolean p20) {
        this.p20 = p20;
    }

    public Boolean getP21() {
        return p21;
    }

    public void setP21(Boolean p21) {
        this.p21 = p21;
    }

    public Boolean getP22() {
        return p22;
    }

    public void setP22(Boolean p22) {
        this.p22 = p22;
    }

    public Boolean getP23() {
        return p23;
    }

    public void setP23(Boolean p23) {
        this.p23 = p23;
    }

    public Boolean getP106e2() {
        return p106e2;
    }

    public void setP106e2(Boolean p106e2) {
        this.p106e2 = p106e2;
    }

    public Boolean getP106e3() {
        return p106e3;
    }

    public void setP106e3(Boolean p106e3) {
        this.p106e3 = p106e3;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getP3a() {
        return p3a;
    }

    public void setP3a(String p3a) {
        this.p3a = p3a;
    }

    public String getP3b() {
        return p3b;
    }

    public void setP3b(String p3b) {
        this.p3b = p3b;
    }

    public String getP131() {
        return p131;
    }

    public String getP15() {
        return p15;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var invoice = (Invoice) o;
        return Objects.equals(p2a, invoice.p2a) && Objects.equals(p3a, invoice.p3a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p2a, p3a);
    }
}
