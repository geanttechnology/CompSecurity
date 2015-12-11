// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.domain.EbaySite;

public class EcasApiContext
{

    public static final String CAS_VERSION_300 = "3.00";
    public static final String CAS_VERSION_301 = "3.01";
    public static final String CHECKOUT_FLOW_IDENTIFIER = "EbayServiceBasedCheckout";
    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/checkout/v1/services";
    public static final String SOA_SHOPPING_CART_SERVICE_NAME = "CartApplicationService";
    public final String iafToken;
    public final EbaySite site;
    public final boolean useBopis;

    public EcasApiContext(EbaySite ebaysite, String s, boolean flag)
    {
        site = ebaysite;
        iafToken = s;
        useBopis = flag;
    }

    public String getRequestVersion()
    {
        return "3.01";
    }
}
