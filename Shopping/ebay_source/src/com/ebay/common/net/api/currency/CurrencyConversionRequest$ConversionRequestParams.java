// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.datamapping.ImmutableDataMapped;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionRequest

public static final class historicalDate extends ImmutableDataMapped
{

    public final String fromCurr;
    public final Date historicalDate;
    private final String iafToken;
    public final EbaySite site;
    public final String toCurr;

    public String getHistoricalDate()
    {
        if (historicalDate == null)
        {
            return null;
        } else
        {
            return EbayDateFormat.format(historicalDate);
        }
    }

    public boolean isHistorical()
    {
        return historicalDate != null;
    }


    public (String s, String s1, EbaySite ebaysite, String s2, Date date)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("Currencies must not be null");
        }
        if (ebaysite == null)
        {
            throw new IllegalArgumentException("Site must not be null");
        } else
        {
            fromCurr = s;
            toCurr = s1;
            site = ebaysite;
            iafToken = s2;
            historicalDate = date;
            return;
        }
    }
}
