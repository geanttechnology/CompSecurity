// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.suggestions;

import com.amazon.searchapp.retailsearch.client.SearchRealm;
import com.amazon.searchapp.retailsearch.client.util.ClassUtil;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCall;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceClient;
import com.amazon.searchapp.retailsearch.model.SearchSuggestions;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.suggestions:
//            SearchSuggestionsRequest, SearchSuggestionsParameterName, SearchSuggestionsClient, SearchSuggestionsListener

public class SearchSuggestionsServiceCall extends ServiceCall
{
    public static interface ResponseParser
    {

        public abstract SearchSuggestions parse(InputStream inputstream, SearchSuggestionsListener searchsuggestionslistener)
            throws IOException;
    }


    private static String PARSER_CLASS = (new StringBuilder()).append(com/amazon/searchapp/retailsearch/client/suggestions/SearchSuggestionsServiceCall.getPackage().getName()).append(".jackson.SearchSuggestionsParser").toString();
    private static ResponseParser defaultParser;
    private final ResponseParser parser;
    private final SearchSuggestionsRequest request;

    public SearchSuggestionsServiceCall(SearchSuggestionsClient searchsuggestionsclient, SearchSuggestionsRequest searchsuggestionsrequest, SearchSuggestionsListener searchsuggestionslistener, ResponseParser responseparser)
    {
        super(searchsuggestionsclient, searchsuggestionslistener, HttpMethod.GET.getName(), "/search/complete", com/amazon/searchapp/retailsearch/model/SearchSuggestions);
        request = searchsuggestionsrequest;
        parser = responseparser;
    }

    private ResponseParser getDefaultParser()
    {
        this;
        JVM INSTR monitorenter ;
        ResponseParser responseparser;
        if (defaultParser == null)
        {
            defaultParser = (ResponseParser)ClassUtil.createInstance(PARSER_CLASS);
        }
        responseparser = defaultParser;
        this;
        JVM INSTR monitorexit ;
        return responseparser;
        Exception exception;
        exception;
        throw exception;
    }

    private ResponseParser getParser()
    {
        if (parser != null)
        {
            return parser;
        } else
        {
            return getDefaultParser();
        }
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        if (request.getMethod() != null)
        {
            collectionmap.set(SearchSuggestionsParameterName.METHOD.getName(), request.getMethod());
        }
        if (request.getQueryPrefix() != null)
        {
            collectionmap.set(SearchSuggestionsParameterName.QUERY_PREFIX.getName(), request.getQueryPrefix());
        }
        if (request.getSearchAlias() != null)
        {
            collectionmap.set(SearchSuggestionsParameterName.SEARCH_ALIAS.getName(), request.getSearchAlias());
        }
        if (request.getConfidence() != null)
        {
            collectionmap.set(SearchSuggestionsParameterName.CONFIDENCE.getName(), request.getConfidence());
        }
        collectionmap.set(SearchSuggestionsParameterName.MARKETPLACE_ID.getName(), String.valueOf(getClient().getRealm().getMarketplaceId()));
        String s = getClient().getClientId();
        if (s != null)
        {
            collectionmap.set(SearchSuggestionsParameterName.CLIENT_ID.getName(), s);
        }
    }

    protected SearchSuggestionsClient getClient()
    {
        return (SearchSuggestionsClient)super.getClient();
    }

    protected volatile ServiceClient getClient()
    {
        return getClient();
    }

    protected SearchSuggestionsListener getListener()
    {
        return (SearchSuggestionsListener)super.getListener();
    }

    protected volatile ServiceCallListener getListener()
    {
        return getListener();
    }

    protected SearchSuggestions readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        if (inputstream != null)
        {
            return getParser().parse(inputstream, getListener());
        } else
        {
            return null;
        }
    }

    protected volatile Object readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        return readResponse(i, s, inputstream);
    }

}
