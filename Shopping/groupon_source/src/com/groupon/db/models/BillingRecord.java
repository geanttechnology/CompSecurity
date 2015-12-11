// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


public class BillingRecord
{

    public String billingRecordId;
    public String cardNumber;
    public String cardType;
    public String city;
    public String country;
    public int expirationMonth;
    public int expirationYear;
    public String firstName;
    public boolean isDefault;
    public boolean isShippingAddressRequired;
    public String lastName;
    public String name;
    public String paymentType;
    public String postalCode;
    public Long primaryKey;
    public String remoteId;
    public boolean requireCVV;
    public String state;
    public String streetAddress1;
    public String uuid;

    public BillingRecord()
    {
        cardNumber = "";
        paymentType = "";
        postalCode = "";
        country = "";
        uuid = "";
        cardType = "";
        city = "";
        expirationMonth = 0;
        firstName = "";
        state = "";
        isDefault = false;
        isShippingAddressRequired = false;
        streetAddress1 = "";
        expirationYear = 0;
        lastName = "";
        requireCVV = false;
        billingRecordId = "";
        name = "";
    }
}
