package com.agh.pz.jpk.header;

import com.agh.pz.jpk.adapter.LocalDateAdapter;
import com.agh.pz.jpk.adapter.LocalDateTimeAdapter;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * POJO Class for header
 */
@XmlRootElement(name = "Naglowek")
public class Header {

    @XmlElement(name = "KodFormularza", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private FormCode formCode;

    @XmlElement(name = "WariantFormularza", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private String formType;

    @XmlElement(name = "CelZlozenia", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    private String aimOfHandingIn;

    @XmlElement(name = "DataWytworzeniaJPK", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    private LocalDateTime dateOfCreation;

    @XmlElement(name = "DataOd", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateFrom;

    @XmlElement(name = "DataDo", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateTo;

    @XmlElement(name = "KodUrzedu", namespace = "http://jpk.mf.gov.pl/wzor/2019/09/27/09271/")
    int resortCode;

    public Header() {}

    public Header(FormCode formCode, String formType, String aimOfHandingIn, LocalDateTime dateOfCreation,
                  LocalDate dateFrom, LocalDate dateTo, int resortCode) {
        this.formCode = formCode;
        this.formType = formType;
        this.aimOfHandingIn = aimOfHandingIn;
        this.dateOfCreation = dateOfCreation;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.resortCode = resortCode;
    }
}
