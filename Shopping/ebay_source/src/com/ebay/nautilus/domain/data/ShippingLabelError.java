// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;


public class ShippingLabelError
{

    public static final String SUBDOMAIN_CARRIER_SVC = "CARRIER_SVC";
    public static final String SUBDOMAIN_PACKAGE_DETAILS = "PACKAGE_DETAILS";
    public static final String SUBDOMAIN_PACKAGE_DETAILS_ADDN_OPT = "PACKAGE_DETAILS_ADDN_OPT";
    public static final String SUBDOMAIN_PSL = "PSL";
    public static final String SUBDOMAIN_SHIP_FROM = "SHIP_FROM";
    public static final String SUBDOMAIN_SHIP_TO = "SHIP_TO";
    public String category;
    public String domain;
    public int errorId;
    public String errorName;
    public String longMessage;
    public String message;
    public String parameters[];
    public String severity;

    public ShippingLabelError()
    {
    }
}
