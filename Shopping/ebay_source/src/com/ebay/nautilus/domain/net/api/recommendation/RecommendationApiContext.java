// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.recommendation;

import android.location.Location;
import com.ebay.nautilus.domain.EbayCountry;
import java.util.Locale;

public class RecommendationApiContext
{

    public final EbayCountry country;
    public final String iafToken;
    public final boolean isValid;
    public final Location location;
    public final Locale userLocale;

    public RecommendationApiContext(String s, EbayCountry ebaycountry, Locale locale, Location location1)
    {
        iafToken = s;
        country = ebaycountry;
        userLocale = locale;
        location = location1;
        boolean flag;
        if (ebaycountry != null && ebaycountry.site != null && locale != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isValid = flag;
    }
}
