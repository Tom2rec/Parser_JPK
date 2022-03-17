package com.agh.pz.jpk.invoice;

import com.agh.pz.jpk.adapter.FloatAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * POJO Class for invoice control
 */
@XmlRootElement(name = "FakturaCtrl")
public class InvoiceControl {

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="LiczbaFaktur")
    private int number;

    @XmlElement(namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/", name ="WartoscFaktur")
    @XmlJavaTypeAdapter(FloatAdapter.class)
    private Float value;

    public InvoiceControl() {}
    public InvoiceControl(int number, Float value) {
        this.number = number;
        this.value = value;
    }
}
