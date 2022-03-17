package com.agh.pz.jpk.adapter;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LocalDateAdapterTest {

    LocalDateAdapter localDateAdapter = new LocalDateAdapter();

    @Test
    public void marshalNullTest() throws Exception {
        localDateAdapter.marshal(null);
        Assert.assertEquals(null, localDateAdapter.marshal(null));
    }

    @Test
    public void marshalTestDate() {
        LocalDate localDate = LocalDate.parse("2020-02-02");
        String expected = "2020-02-02";
        Assert.assertEquals(expected, localDateAdapter.marshal(localDate));
    }

    @Test
    public void unmarshalTest(){
        LocalDate localDate = LocalDate.parse("2020-02-02");
        Assert.assertEquals(localDate,localDateAdapter.unmarshal("2020-02-02"));
    }


}
