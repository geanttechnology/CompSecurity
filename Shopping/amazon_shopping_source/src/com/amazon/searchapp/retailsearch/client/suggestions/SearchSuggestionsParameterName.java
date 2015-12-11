// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;


public final class SearchSuggestionsParameterName extends Enum
{

    private static final SearchSuggestionsParameterName $VALUES[];
    public static final SearchSuggestionsParameterName CLIENT_ID;
    public static final SearchSuggestionsParameterName CONFIDENCE;
    public static final SearchSuggestionsParameterName MARKETPLACE_ID;
    public static final SearchSuggestionsParameterName METHOD;
    public static final SearchSuggestionsParameterName QUERY_PREFIX;
    public static final SearchSuggestionsParameterName SEARCH_ALIAS;
    private final String name;

    private SearchSuggestionsParameterName(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static SearchSuggestionsParameterName valueOf(String s)
    {
        return (SearchSuggestionsParameterName)Enum.valueOf(com/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsParameterName, s);
    }

    public static SearchSuggestionsParameterName[] values()
    {
        return (SearchSuggestionsParameterName[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        METHOD = new SearchSuggestionsParameterName("METHOD", 0, "method");
        QUERY_PREFIX = new SearchSuggestionsParameterName("QUERY_PREFIX", 1, "q");
        SEARCH_ALIAS = new SearchSuggestionsParameterName("SEARCH_ALIAS", 2, "search-alias");
        CLIENT_ID = new SearchSuggestionsParameterName("CLIENT_ID", 3, "client-id");
        CONFIDENCE = new SearchSuggestionsParameterName("CONFIDENCE", 4, "conf");
        MARKETPLACE_ID = new SearchSuggestionsParameterName("MARKETPLACE_ID", 5, "mkt");
        $VALUES = (new SearchSuggestionsParameterName[] {
            METHOD, QUERY_PREFIX, SEARCH_ALIAS, CLIENT_ID, CONFIDENCE, MARKETPLACE_ID
        });
    }
}
