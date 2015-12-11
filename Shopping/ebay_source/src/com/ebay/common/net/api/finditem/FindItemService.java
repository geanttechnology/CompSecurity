// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import com.ebay.nautilus.domain.EbaySite;

public final class FindItemService
{

    public static final String SERVICE_DOMAIN = "http://www.ebay.com/marketplace/search/v1/services";
    public final EbaySite site;

    public FindItemService(EbaySite ebaysite)
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
