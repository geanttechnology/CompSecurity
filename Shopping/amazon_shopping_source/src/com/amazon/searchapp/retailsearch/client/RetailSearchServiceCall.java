// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.ServiceCall;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceClient;
import com.amazon.searchapp.retailsearch.client.web.WebRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchClient, SearchParameterName, RandomStringUtil, SearchRealm, 
//            SearchHeaderName, WeblabUtil

public abstract class RetailSearchServiceCall extends ServiceCall
{

    private Map weblabs;

    protected RetailSearchServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener, String s, String s1, Class class1)
    {
        super(retailsearchclient, servicecalllistener, s, s1, class1);
        weblabs = new HashMap();
    }

    protected final void addApiParameters(CollectionMap collectionmap)
    {
        RetailSearchClient retailsearchclient = getClient();
        if (retailsearchclient.getApiVersion() != null)
        {
            collectionmap.add(SearchParameterName.API_VERSION.getName(), retailsearchclient.getApiVersion());
        }
        if (retailsearchclient.getClientId() != null)
        {
            collectionmap.add(SearchParameterName.CLIENT_ID.getName(), retailsearchclient.getClientId());
        }
        if (retailsearchclient.getResponseFormat() != null)
        {
            collectionmap.add(SearchParameterName.RESPONSE_FORMAT.getName(), retailsearchclient.getResponseFormat());
        }
        collectionmap.set(SearchParameterName.CLIENT_REQUEST_ID.getName(), RandomStringUtil.generate(16));
    }

    protected final void addEncodingParameters(CollectionMap collectionmap)
    {
        RetailSearchClient retailsearchclient = getClient();
        if (retailsearchclient.getRealm() != null)
        {
            if (retailsearchclient.getRealm().getEncodingParam() != null)
            {
                collectionmap.set(retailsearchclient.getRealm().getEncodingParam(), retailsearchclient.getRealm().getEncodingValue());
            }
            if (retailsearchclient.getRealm().getInputEncoding() != null)
            {
                collectionmap.set(SearchParameterName.IE.getName(), retailsearchclient.getRealm().getInputEncoding());
                return;
            }
        }
    }

    protected void buildHeaders(CollectionMap collectionmap)
    {
        super.buildHeaders(collectionmap);
        if (getClient().getClientId() != null)
        {
            collectionmap.set(SearchHeaderName.CLIENT_ID.getName(), getClient().getClientId());
        }
        if (getClient().getAppId() != null)
        {
            collectionmap.set(SearchHeaderName.APP_ID.getName(), getClient().getAppId());
        }
        if (getClient().getPlatform() != null)
        {
            collectionmap.set(SearchHeaderName.PLATFORM.getName(), getClient().getPlatform());
        }
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        addEncodingParameters(collectionmap);
        addApiParameters(collectionmap);
    }

    protected void buildServiceCall()
        throws IOException
    {
        super.buildServiceCall();
        HashMap hashmap = new HashMap();
        if (getClient().getWeblabs() != null)
        {
            hashmap.putAll(getClient().getWeblabs());
        }
        HashMap hashmap1 = new HashMap();
        buildWeblabs(hashmap1);
        hashmap.putAll(hashmap1);
        hashmap.putAll(weblabs);
        weblabs = hashmap;
    }

    protected WebRequest buildWebRequest()
        throws IOException
    {
        if (!weblabs.isEmpty() && !getCookies().containsKey(WeblabUtil.getWeblabCookieName()))
        {
            getCookies().set(WeblabUtil.getWeblabCookieName(), WeblabUtil.createWeblabCookie(weblabs));
        }
        return super.buildWebRequest();
    }

    protected void buildWeblabs(Map map)
    {
        if (getClient().getSecure())
        {
            map.put("SEARCH_27665", "T1");
        }
    }

    protected RetailSearchClient getClient()
    {
        return (RetailSearchClient)super.getClient();
    }

    protected volatile ServiceClient getClient()
    {
        return getClient();
    }
}
