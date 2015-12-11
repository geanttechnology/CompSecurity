// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;

// Referenced classes of package com.ebay.mobile.search:
//            RefinementLocks

static final class it> extends it>
{

    void apply(SearchParameters searchparameters, String s)
    {
        searchparameters.searchLocalCountryOnly = Boolean.parseBoolean(s);
    }

    boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
    {
        return searchparameters.searchLocalCountryOnly == searchparameters1.searchLocalCountryOnly;
    }

    (String s, int i)
    {
        super(s, i, null);
    }
}
