// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.nautilus.domain.datamapping.ImmutableDataMapped;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionDataManager

public static final class bypassCache extends ImmutableDataMapped
{

    public final boolean bypassCache;
    public final String fromCurr;
    public final String toCurr;

    public (String s, String s1, boolean flag)
    {
        if (s == null || s1 == null)
        {
            throw new IllegalArgumentException("Currencies must not be null");
        } else
        {
            fromCurr = s;
            toCurr = s1;
            bypassCache = flag;
            return;
        }
    }
}
