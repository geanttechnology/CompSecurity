// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.search:
//            SearchApi

public class Response
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private SearchApi searchApi;

    public Response()
    {
    }

    public SearchApi getSearchApi()
    {
        return searchApi;
    }

    public void setSearchApi(SearchApi searchapi)
    {
        searchApi = searchapi;
    }
}
