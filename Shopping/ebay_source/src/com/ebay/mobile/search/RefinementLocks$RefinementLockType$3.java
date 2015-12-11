// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;

// Referenced classes of package com.ebay.mobile.search:
//            RefinementLocks

static final class nit> extends nit>
{

    void apply(SearchParameters searchparameters, String s)
    {
        searchparameters.condition = s;
    }

    boolean isDefault(SearchParameters searchparameters, SearchParameters searchparameters1)
    {
        if (searchparameters1.condition != null)
        {
            return searchparameters1.condition.equals(searchparameters.condition);
        }
        return searchparameters.condition == null;
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
