// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;


// Referenced classes of package com.amazon.searchapp.retailsearch.client.suggestions:
//            SearchSuggestionsRequest, SearchSuggestionsServiceCall, SearchSuggestionsListener

public interface SearchSuggestionsClientApi
{

    public abstract SearchSuggestionsServiceCall searchSuggestions(SearchSuggestionsRequest searchsuggestionsrequest);

    public abstract SearchSuggestionsServiceCall searchSuggestions(SearchSuggestionsRequest searchsuggestionsrequest, SearchSuggestionsListener searchsuggestionslistener);

    public abstract SearchSuggestionsServiceCall searchSuggestions(String s);

    public abstract SearchSuggestionsServiceCall searchSuggestions(String s, SearchSuggestionsListener searchsuggestionslistener);

    public abstract SearchSuggestionsServiceCall searchSuggestions(String s, String s1, SearchSuggestionsListener searchsuggestionslistener);
}
