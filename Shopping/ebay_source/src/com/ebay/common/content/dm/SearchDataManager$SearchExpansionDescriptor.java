// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.net.api.search.KnownSearchExpansion;
import com.ebay.common.net.api.search.SearchExpansion;
import com.ebay.common.net.api.search.SearchParameters;
import java.util.List;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

public static class <init>
{

    public final SearchExpansion expansion;
    public final SearchParameters expansionSearchParameters;
    public final KnownSearchExpansion expansionType;

    public long getAbridgedMatchCount()
    {
        return expansion.expansionResult.hCount;
    }

    public List getItems()
    {
        java.util.ArrayList arraylist = expansion.expansionResult.s;
        Object obj = arraylist;
        if (expansionType == KnownSearchExpansion.CROSS_BORDER)
        {
            obj = arraylist;
            if (arraylist.size() > 10)
            {
                obj = arraylist.subList(0, 10);
            }
        }
        return ((List) (obj));
    }

    public long getMatchCount()
    {
        return expansion.expansionResult.nsion;
    }

    public boolean isDisplayedOnTop()
    {
        return expansionType.isDisplayedOnTop;
    }

    private (KnownSearchExpansion knownsearchexpansion, SearchExpansion searchexpansion, SearchParameters searchparameters)
    {
        expansionType = knownsearchexpansion;
        expansionSearchParameters = searchparameters;
        expansion = searchexpansion;
    }

    expansion(KnownSearchExpansion knownsearchexpansion, SearchExpansion searchexpansion, SearchParameters searchparameters, expansion expansion1)
    {
        this(knownsearchexpansion, searchexpansion, searchparameters);
    }
}
