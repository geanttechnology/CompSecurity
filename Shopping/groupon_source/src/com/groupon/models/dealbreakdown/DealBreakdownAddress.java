// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.dealbreakdown;

import java.io.Serializable;
import java.util.Locale;
import roboguice.util.Strings;

public class DealBreakdownAddress
    implements Serializable
{

    public String additionalInformation;
    public String address1;
    public String address2;
    public String city;
    public String cityName;
    public String companyName;
    public String country;
    public String district;
    public String email;
    public String firstName;
    public String id;
    public String is_master;
    public String lastName;
    public String lat;
    public String lng;
    public String locationString;
    public String mei;
    public String name;
    public String personalIdentificationNumber;
    public String phoneNumber;
    public String postalCode;
    public int pref;
    public String sei;
    public String shippingAddress1;
    public String shippingAddress2;
    public String shippingCity;
    public String shippingCountry;
    public String shippingPostalCode;
    public String shippingState;
    public String shipping_additional_information;
    public String shipping_address1;
    public String shipping_apartment;
    public String shipping_cellphone;
    public String shipping_district;
    public String shipping_name;
    public String shipping_personal_identification_number;
    public String shipping_postal_code;
    public String shipping_state;
    public String shipping_street_number;
    public int shipping_street_type;
    public String shipping_telephone;
    public String shipping_township;
    public String state;
    public String streetAddress1;
    public String streetAddress2;
    public String streetNumber;
    public String taxIdentificationNumber;
    public String tel;
    public String title;
    public String user_id;
    public String zip;

    public DealBreakdownAddress()
    {
    }

    public DealBreakdownAddress(String s, String s1, String s2, String s3, String s4, int i, String s5, 
            String s6, String s7, String s8, String s9)
    {
        id = s;
        user_id = s1;
        sei = s2;
        mei = s3;
        zip = s4;
        pref = i;
        city = s5;
        address1 = s6;
        address2 = s7;
        tel = s8;
        is_master = s9;
    }

    public DealBreakdownAddress(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        name = s;
        streetAddress1 = s1;
        streetAddress2 = s2;
        city = s3;
        state = s4;
        country = s6;
        postalCode = s5;
    }

    public DealBreakdownAddress(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, int i, String s9, String s10, String s11, String s12)
    {
        id = s;
        shipping_name = s1;
        shipping_personal_identification_number = s2;
        shipping_postal_code = s3;
        shipping_telephone = s5;
        shipping_cellphone = s4;
        postalCode = s6;
        shipping_district = s7;
        shipping_state = s8;
        shipping_street_type = i;
        shipping_address1 = s9;
        shipping_street_number = s10;
        shipping_apartment = s11;
        shipping_additional_information = s12;
    }

    public DealBreakdownAddress(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13, 
            String s14, String s15, String s16)
    {
        title = s;
        firstName = s1;
        lastName = s2;
        streetAddress1 = s3;
        streetNumber = s4;
        state = s5;
        city = s6;
        cityName = s7;
        district = s8;
        country = s9;
        postalCode = s10;
        phoneNumber = s11;
        additionalInformation = s12;
        companyName = s13;
        personalIdentificationNumber = s14;
        taxIdentificationNumber = s15;
        email = s16;
    }

    public boolean isMaster()
    {
        return Strings.equals(is_master.toLowerCase(Locale.ENGLISH), "yes");
    }
}
