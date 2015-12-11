// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.airstream;

import com.amazon.searchapp.retailsearch.client.RefTagUtil;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.RetailSearchServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchListener;
import com.amazon.searchapp.retailsearch.client.SearchResponseParser;
import com.amazon.searchapp.retailsearch.client.SearchResponseParserFactory;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceException;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.airstream:
//            AirstreamFavoritesRequest, AirstreamParameter

public class AirstreamFavoritesServiceCall extends RetailSearchServiceCall
{

    private final AirstreamFavoritesRequest request;

    public AirstreamFavoritesServiceCall(RetailSearchClient retailsearchclient, AirstreamFavoritesRequest airstreamfavoritesrequest, SearchListener searchlistener)
    {
        super(retailsearchclient, searchlistener, HttpMethod.GET.getName(), "/stream/favorites", com/amazon/searchapp/retailsearch/model/SearchResult);
        request = airstreamfavoritesrequest;
    }

    protected void buildParameters(CollectionMap collectionmap)
        throws ServiceException
    {
        if (request.getStart() != 0)
        {
            collectionmap.set(AirstreamParameter.START.getName(), String.valueOf(request.getStart()));
        }
        if (request.getCount() != 0)
        {
            collectionmap.set(AirstreamParameter.COUNT.getName(), String.valueOf(request.getCount()));
        }
        super.buildParameters(collectionmap);
    }

    protected String buildPath()
        throws ServiceException
    {
        return RefTagUtil.addRefTag(getDefaultPath(), request.getRefTag());
    }

    protected SearchListener getListener()
    {
        return (SearchListener)super.getListener();
    }

    protected volatile ServiceCallListener getListener()
    {
        return getListener();
    }

    protected SearchResult readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            return SearchResponseParserFactory.getParser(getClient().getValidateObjects()).parse(inputstream, getListener());
        }
    }

    protected volatile Object readResponse(int i, String s, InputStream inputstream)
        throws IOException
    {
        return readResponse(i, s, inputstream);
    }
}
