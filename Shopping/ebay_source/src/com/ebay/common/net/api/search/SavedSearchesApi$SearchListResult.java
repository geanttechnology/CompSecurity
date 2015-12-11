// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.net.AsyncList;
import com.ebay.nautilus.domain.net.EbayResponseError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

public static class <init> extends <init>
{

    public final EbayAspectHistogram aspects;
    public final EbayCategoryHistogram categories;
    public final ArrayList itemIds;
    public String keywordsRecommendation;
    public final String searchUrl;
    public final int totalCountWithDupes;
    public final List warnings;

    public boolean hasWarning(String s)
    {
        if (warnings != null)
        {
            Iterator iterator = warnings.iterator();
            while (iterator.hasNext()) 
            {
                if (s.equals(((EbayResponseError)iterator.next()).code))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public (int i, int j, AsyncList asynclist, EbayCategoryHistogram ebaycategoryhistogram, EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist)
    {
        this(i, j, asynclist, ebaycategoryhistogram, ebayaspecthistogram, s, arraylist, null);
    }

    public <init>(int i, int j, AsyncList asynclist, EbayCategoryHistogram ebaycategoryhistogram, EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist, 
            List list)
    {
        super(i, asynclist);
        categories = ebaycategoryhistogram;
        aspects = ebayaspecthistogram;
        searchUrl = s;
        itemIds = arraylist;
        warnings = list;
        totalCountWithDupes = j;
    }

    public totalCountWithDupes(int i, AsyncList asynclist, EbayCategoryHistogram ebaycategoryhistogram, EbayAspectHistogram ebayaspecthistogram, String s, ArrayList arraylist)
    {
        this(i, i, asynclist, ebaycategoryhistogram, ebayaspecthistogram, s, arraylist, null);
    }
}
