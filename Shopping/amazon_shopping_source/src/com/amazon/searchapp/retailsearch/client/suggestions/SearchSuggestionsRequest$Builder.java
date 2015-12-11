// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;


// Referenced classes of package com.amazon.searchapp.retailsearch.client.suggestions:
//            SearchSuggestionsRequest

public static class confidence
{

    private String confidence;
    private String method;
    private String queryPrefix;
    private String searchAlias;

    public SearchSuggestionsRequest build()
    {
        return new SearchSuggestionsRequest(method, searchAlias, queryPrefix, confidence, null);
    }

    public confidence setSearchAlias(String s)
    {
        searchAlias = s;
        return this;
    }

    public (String s)
    {
        method = "complete";
        searchAlias = "aps";
        queryPrefix = s;
        confidence = "1";
    }
}
