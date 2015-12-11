// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;


// Referenced classes of package com.ebay.common.net.api.search:
//            SearchResult, SearchParameters

public static final class searchParameters
{

    private final SearchParameters searchParameters;

    public String getKeywords()
    {
        return searchParameters.keywords;
    }

    public SearchParameters getSearchParameters()
    {
        return searchParameters;
    }

    public I(SearchParameters searchparameters)
    {
        searchParameters = searchparameters;
    }
}
