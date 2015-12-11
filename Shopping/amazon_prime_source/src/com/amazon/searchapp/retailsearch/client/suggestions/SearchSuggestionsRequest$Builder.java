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

    public String getConfidence()
    {
        return confidence;
    }

    public String getMethod()
    {
        return method;
    }

    public String getQueryPrefix()
    {
        return queryPrefix;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public searchAlias setConfidence(String s)
    {
        confidence = s;
        return this;
    }

    public confidence setMethod(String s)
    {
        method = s;
        return this;
    }

    public method setQueryPrefix(String s)
    {
        queryPrefix = s;
        return this;
    }

    public queryPrefix setSearchAlias(String s)
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
