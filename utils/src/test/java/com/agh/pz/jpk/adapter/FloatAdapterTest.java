package com.agh.pz.jpk.adapter;

import org.junit.Assert;
import org.junit.Test;

public class FloatAdapterTest {

    FloatAdapter floatAdapter = new FloatAdapter();

    @Test
    public void marshalNullTest() throws Exception {
        floatAdapter.marshal(null);
        Assert.assertEquals(null, floatAdapter.marshal(null));
    }

    @Test
    public void marshalTestNumberType1() throws Exception {
        Float number = 8.0f;
        String expected = "8.00";
        Assert.assertEquals(expected,floatAdapter.marshal(number));
    }

    @Test
    public void marshalTestNumberType2() throws Exception {
        Float number = 8.234f;
        String expected = "8.23";
        Assert.assertEquals(expected,floatAdapter.marshal(number));
    }

    @Test
    public void marshalTestNumberType3() throws Exception {
        Float number = 8.236f;
        String expected = "8.24";
        Assert.assertEquals(expected,floatAdapter.marshal(number));
    }

    @Test
    public void unmarshalTest() throws Exception {
        Assert.assertEquals(null, floatAdapter.unmarshal("tets"));
    }
}
