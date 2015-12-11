// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.product;

import com.ebay.nautilus.domain.EbaySite;

public final class EbayProductApi
{

    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/marketplacecatalog/v1/services";
    public final EbaySite site;

    public EbayProductApi(EbaySite ebaysite)
    {
        site = ebaysite;
    }
}
