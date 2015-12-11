// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.UrlMaker;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, RetailSearchClient

public class RefinementsServiceCall extends RetailSearchServiceCall
{

    private CollectionMap collection;
    private boolean isPathNull;
    private String ref;

    public RefinementsServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener, String s)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/browse", com/amazon/searchapp/retailsearch/model/SearchResult);
        if (s == null) goto _L2; else goto _L1
_L1:
        retailsearchclient = new URI(s);
        collection = UrlMaker.parseQuery(retailsearchclient.getQuery());
        if (!retailsearchclient.getPath().contains("=")) goto _L4; else goto _L3
_L3:
        ref = retailsearchclient.getPath().split("=")[1];
_L5:
        isPathNull = false;
        return;
_L4:
        try
        {
            ref = null;
        }
        // Misplaced declaration of an exception variable
        catch (RetailSearchClient retailsearchclient)
        {
            retailsearchclient.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (RetailSearchClient retailsearchclient)
        {
            retailsearchclient.printStackTrace();
        }
        if (true) goto _L5; else goto _L2
_L2:
        isPathNull = true;
        return;
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        if (!isPathNull)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = collection.entrySet().iterator(); iterator.hasNext(); collectionmap.set(entry.getKey(), (List)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            if (ref != null)
            {
                collectionmap.set("ref", ref);
            }
        }
        super.buildParameters(collectionmap);
    }
}
