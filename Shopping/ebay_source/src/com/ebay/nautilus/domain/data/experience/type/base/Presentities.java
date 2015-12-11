// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.experience.type.base;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.experience.type.listing.ListingSummary;
import java.util.List;

public class Presentities
{

    public List listings;
    public List orders;

    public Presentities()
    {
    }

    public ListingSummary findListingSummary(String s)
    {
        ListingSummary listingsummary;
        Object obj;
        obj = null;
        listingsummary = obj;
        if (listings == null) goto _L2; else goto _L1
_L1:
        listingsummary = obj;
        if (TextUtils.isEmpty(s)) goto _L2; else goto _L3
_L3:
        int i = 0;
_L7:
        listingsummary = obj;
        if (i >= listings.size()) goto _L2; else goto _L4
_L4:
        listingsummary = (ListingSummary)listings.get(i);
        if (listingsummary == null || !s.equals(listingsummary.id)) goto _L5; else goto _L2
_L2:
        return listingsummary;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }
}
