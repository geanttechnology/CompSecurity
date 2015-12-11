// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import com.ebay.common.net.api.search.SearchParameters;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

public static final class  extends SearchResultFragmentActivity
{

    protected boolean onNewSearchParametersDelivered(SearchParameters searchparameters)
    {
        boolean flag;
        if (searchparameters.keywords != null && searchparameters.keywords.startsWith("seller:"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return !flag && searchParameters.sellerId.equals(searchparameters.sellerId);
    }

    public ()
    {
    }
}
