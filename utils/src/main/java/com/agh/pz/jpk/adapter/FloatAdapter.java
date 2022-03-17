package com.agh.pz.jpk.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.DecimalFormat;

/**
 * Adapter for float element
 */
public class FloatAdapter extends XmlAdapter<String, Float> {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    public Float unmarshal(String s) throws Exception {
        return null;
    }

    @Override
    public String marshal(Float number) throws Exception {
        if (number == null) return null;
        if (number.toString().substring(number.toString().indexOf(".")).length() > 3) {
            return df.format(Float.parseFloat(number.toString()));
        }
        if (number.toString().substring(number.toString().indexOf(".")).length() == 2) {
            return number.toString() + "0";
        }
        return number.toString();
    }
}