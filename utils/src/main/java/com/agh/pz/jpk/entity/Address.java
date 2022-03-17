package com.agh.pz.jpk.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * POJO Class for entity address
 */
@XmlRootElement(name = "adresPodmiotu")
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "KodKraju")
    private String countryCode;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "Wojewodztwo")
    private String voivodship;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "Powiat")
    private String county;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "Gmina")
    private String parish;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "Ulica")
    private String street;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "NrDomu" )
    private int houseNumber;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "NrLokalu")
    private int localNumber;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "Miejscowosc")
    private String city;

    @XmlElement(namespace = "http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/", name = "KodPocztowy")
    private String postCode;

    public Address() {}

    public Address(String countryCode, String voivodship, String county, String parish, String street, int houseNumber, int localNumber, String city, String postCode) {
        this.countryCode = countryCode;
        this.voivodship = voivodship;
        this.county = county;
        this.parish = parish;
        this.street = street;
        this.houseNumber = houseNumber;
        this.localNumber = localNumber;
        this.city = city;
        this.postCode = postCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getVoivodship() {
        return voivodship;
    }

    public void setVoivodship(String voivodship) {
        this.voivodship = voivodship;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getParish() {
        return parish;
    }

    public void setParish(String parish) {
        this.parish = parish;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(int localNumber) {
        this.localNumber = localNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}
