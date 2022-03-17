package com.agh.pz.jpk.invoiceRow;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * POJO Class for invoice row control
 */
@XmlRootElement(name = "FakturaWierszCtrl")
@XmlAccessorType(XmlAccessType.FIELD)
public class InvoiceRowControl {

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="LiczbaWierszyFaktur")
    private int number;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="WartoscWierszyFaktur")
    private Float value;

    public InvoiceRowControl() {}

    public InvoiceRowControl(int number, Float value) {
        this.number = number;
        this.value = value;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}