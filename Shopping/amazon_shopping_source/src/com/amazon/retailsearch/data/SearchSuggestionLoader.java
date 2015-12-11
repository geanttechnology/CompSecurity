// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data;

import android.text.TextUtils;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.suggestions.AbstractSearchSuggestionsListener;
import com.amazon.searchapp.retailsearch.client.suggestions.SearchSuggestionsClient;
import com.amazon.searchapp.retailsearch.client.suggestions.SearchSuggestionsServiceCall;
import com.amazon.searchapp.retailsearch.client.web.apache40.ApacheWebClient;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import java.io.IOException;

public class SearchSuggestionLoader
{
    private class RequestListener extends AbstractSearchSuggestionsListener
    {

        final SearchSuggestionLoader this$0;

        public void error(Exception exception)
        {
            SearchSuggestionLoader.log.error("Search suggestion request error", exception);
        }

        private RequestListener()
        {
            this$0 = SearchSuggestionLoader.this;
            super();
        }

    }


    private static final String UNKNOWN_CLIENT_ID = "unknown";
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/data/SearchSuggestionLoader);
    private String clientID;
    private String query;
    private String searchAlias;

    public SearchSuggestionLoader()
    {
    }

    public String getClientID()
    {
        return clientID;
    }

    public String getQuery()
    {
        return query;
    }

    public String getSearchAlias()
    {
        return searchAlias;
    }

    public SearchSuggestions getSearchSuggestions()
    {
        if (TextUtils.isEmpty(query))
        {
            return null;
        }
        com.amazon.searchapp.retailsearch.client.suggestions.SearchSuggestionsClient.Builder builder = (new com.amazon.searchapp.retailsearch.client.suggestions.SearchSuggestionsClient.Builder()).setWebClient(new ApacheWebClient());
        Object obj;
        if (clientID == null)
        {
            obj = "unknown";
        } else
        {
            obj = clientID;
        }
        obj = builder.setClientId(((String) (obj))).build().searchSuggestions(searchAlias, query, new RequestListener());
        try
        {
            obj = (SearchSuggestions)((SearchSuggestionsServiceCall) (obj)).execute();
        }
        catch (IOException ioexception)
        {
            return null;
        }
        return ((SearchSuggestions) (obj));
    }

    public SearchSuggestionLoader setClientID(String s)
    {
        clientID = s;
        return this;
    }

    public SearchSuggestionLoader setQuery(String s)
    {
        query = s;
        return this;
    }

    public SearchSuggestionLoader setSearchAlias(String s)
    {
        searchAlias = s;
        return this;
    }


}
