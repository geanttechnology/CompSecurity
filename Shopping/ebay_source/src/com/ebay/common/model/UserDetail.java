// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import java.io.Serializable;

public final class UserDetail
    implements Serializable
{
    public static final class Address
        implements Serializable
    {

        public String cityName;
        public String companyName;
        public String country;
        public String countryName;
        public String name;
        public String phone;
        public String postalCode;
        public String stateOrProvince;
        public String street;
        public String street1;
        public String street2;

        public Address()
        {
        }
    }

    public static final class SellerInfo
        implements Serializable
    {

        public String paymentMethod;
        public String sellerBusinessType;
        public Address sellerPaymentAddress;

        public SellerInfo()
        {
        }
    }


    public String email;
    public String feedbackRatingStar;
    public boolean isPpa;
    public String msuuid;
    public String payPalAccountLevel;
    public String payPalAccountStatus;
    public String payPalAccountType;
    public Address registrationAddress;
    public SellerInfo sellerInfo;
    public String site;
    public String status;
    public String userId;

    public UserDetail()
    {
        sellerInfo = null;
        msuuid = null;
        feedbackRatingStar = null;
        payPalAccountLevel = null;
        payPalAccountStatus = null;
        payPalAccountType = null;
        isPpa = true;
    }
}
