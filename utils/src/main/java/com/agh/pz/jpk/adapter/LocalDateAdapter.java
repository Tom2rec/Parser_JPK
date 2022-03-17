package com.agh.pz.jpk.adapter;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalDate;

/**
 * adapter for local date element
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public String marshal(LocalDate date) {
        if (date == null) return null;
        return date.toString();
    }

    @Override
    public LocalDate unmarshal(String string) {
        return LocalDate.parse(string);
    }
}