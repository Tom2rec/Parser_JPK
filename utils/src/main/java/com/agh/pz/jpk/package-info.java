@XmlSchema(
        elementFormDefault=XmlNsForm.QUALIFIED,
        namespace="http://www.example.com/FOO",
        xmlns={
                @XmlNs(prefix="tns", namespaceURI="http://jpk.mf.gov.pl/wzor/2019/09/27/09271/"),
                @XmlNs(prefix="xsi", namespaceURI="http://www.w3.org/2001/XMLSchema-instance"),
                @XmlNs(prefix="etd", namespaceURI="http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2018/08/24/eD/DefinicjeTypy/"),
                @XmlNs(prefix="kck", namespaceURI="http://crd.gov.pl/xml/schematy/dziedzinowe/mf/2013/05/23/eD/KodyCECHKRAJOW/"),

                @XmlNs(prefix="xsd", namespaceURI="http://www.w3.org/2001/XMLSchema"),
                @XmlNs(prefix="msxsl", namespaceURI="urn:schemas-microsoft-com:xslt"),
                @XmlNs(prefix="usr", namespaceURI="urn:the-xml-files:xslt"),
        }
        )
package com.agh.pz.jpk;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
import jakarta.xml.bind.annotation.XmlSchema;

