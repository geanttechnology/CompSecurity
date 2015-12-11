// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.support;


public class SupportInfo
{
    public static class Contents
    {

        public String cookiePolicy;
        public CustomerSupport customerSupport;
        public String faq;
        public String finePrint;
        public CustomerSupport getawayBookingsCustomerSupport;
        public LegalDisclosure legalDisclosure;
        public String privacyPolicy;
        public String termsOfService;

        public Contents()
        {
            finePrint = "";
            getawayBookingsCustomerSupport = new CustomerSupport();
            customerSupport = new CustomerSupport();
            termsOfService = "";
            privacyPolicy = "";
            cookiePolicy = "";
            legalDisclosure = new LegalDisclosure();
            faq = "";
        }
    }

    public static class CustomerSupport
    {

        public String afterHoursPhoneNumber;
        public String callCharges;
        public String email;
        public String operatingHours;
        public String phoneNumber;
        public String reservation;

        public CustomerSupport()
        {
            operatingHours = "";
            afterHoursPhoneNumber = "";
            reservation = "";
            phoneNumber = "";
            callCharges = "";
            email = "";
        }
    }

    public static class LegalDisclosure
    {

        public String checkout;
        public String signUp;

        public LegalDisclosure()
        {
            signUp = "";
            checkout = "";
        }
    }


    public Contents contents;

    public SupportInfo()
    {
        contents = new Contents();
    }
}
