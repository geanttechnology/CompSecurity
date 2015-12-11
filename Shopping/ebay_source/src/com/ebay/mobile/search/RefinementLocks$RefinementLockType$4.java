// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.data.ItemCurrency;

// Referenced classes of package com.ebay.mobile.search:
//            RefinementLocks

static final class nit> extends nit>
{

    void apply(SearchParameters searchparameters)
    {
        searchparameters.minPrice = constructCurrencyFromPrefs();
    }

    boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
    {
        if (searchparameters1.minPrice != null)
        {
            return searchparameters1.minPrice.equals(searchparameters.minPrice);
        }
        return searchparameters.minPrice == null;
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
