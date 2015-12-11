// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experience.deals;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.app.Authentication;

public class DealsApiContext
{

    public final transient Authentication authentication;
    public final transient EbayCountry country;
    public boolean useHub;

    public DealsApiContext(Authentication authentication1, EbayCountry ebaycountry)
    {
        authentication = authentication1;
        country = ebaycountry;
    }
}
