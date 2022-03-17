package com.agh.pz.jpk.adapter;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalDateTimeAdapterTest {

    LocalDateTimeAdapter localDateTimeAdapter = new LocalDateTimeAdapter();

    @Test
    public void marshalNullTest() throws Exception {
        localDateTimeAdapter.marshal(null);
        Assert.assertNull(localDateTimeAdapter.marshal(null));
    }

    @Test
    public void marshalTestDate() {
        LocalDateTime localDateTime = LocalDateTime.parse("2020-02-02T12:12:12");
        String expected = "2020-02-02T12:12:12";
        Assert.assertEquals(expected, localDateTimeAdapter.marshal(localDateTime));
    }

    @Test
    public void unmarshalTest(){
        LocalDateTime localDate = LocalDateTime.parse("2020-02-02T12:12:12");
        Assert.assertEquals(localDate, localDateTimeAdapter.unmarshal("2020-02-02T12:12:12"));
    }
}
