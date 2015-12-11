// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceException;
import com.amazon.searchapp.retailsearch.client.web.UrlMaker;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, RefTagUtil, RetailSearchClient

public class RefinementsServiceCall extends RetailSearchServiceCall
{

    private final String url;

    public RefinementsServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener, String s)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/browse", com/amazon/searchapp/retailsearch/model/SearchResult);
        url = s;
    }

    protected void buildParameters(CollectionMap collectionmap)
        throws ServiceException
    {
        if (url != null)
        {
            try
            {
                Object obj = new UrlMaker(url);
                if (((UrlMaker) (obj)).getQuery() != null)
                {
                    obj = ((UrlMaker) (obj)).getQuery().entrySet().iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                        if (entry.getKey() != null)
                        {
                            collectionmap.set(entry.getKey(), (List)entry.getValue());
                        }
                    } while (true);
                }
            }
            // Misplaced declaration of an exception variable
            catch (CollectionMap collectionmap)
            {
                throw new ServiceException(collectionmap);
            }
            // Misplaced declaration of an exception variable
            catch (CollectionMap collectionmap)
            {
                throw new ServiceException(collectionmap);
            }
        }
        super.buildParameters(collectionmap);
    }

    protected String buildPath()
        throws ServiceException
    {
        return RefTagUtil.addRefTag(getDefaultPath(), RefTagUtil.getRefTag(url));
    }
}
