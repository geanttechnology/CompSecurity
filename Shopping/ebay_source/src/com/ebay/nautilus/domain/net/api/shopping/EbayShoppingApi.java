// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.EbaySite;

public final class EbayShoppingApi
{

    public static final String ServiceDomain = "urn:ebay:apis:eBLBaseComponents";
    public final EbaySite site;

    public EbayShoppingApi(EbaySite ebaysite)
    {
        site = ebaysite;
        if (ebaysite == null)
        {
            throw new NullPointerException("site");
        } else
        {
            return;
        }
    }
}
