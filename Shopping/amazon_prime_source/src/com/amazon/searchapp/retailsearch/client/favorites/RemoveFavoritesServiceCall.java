// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.favorites;

import com.amazon.searchapp.retailsearch.client.RefTagUtil;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCall;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceException;
import com.amazon.searchapp.retailsearch.model.RemoveFavoritesResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.favorites:
//            RemoveFavoritesRequest, FavoritesUtil

public class RemoveFavoritesServiceCall extends ServiceCall
{

    private final RemoveFavoritesRequest request;

    public RemoveFavoritesServiceCall(RetailSearchClient retailsearchclient, RemoveFavoritesRequest removefavoritesrequest, ServiceCallListener servicecalllistener)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.POST.getName(), "/mn/favorites/remove", com/amazon/searchapp/retailsearch/model/RemoveFavoritesResult);
        request = removefavoritesrequest;
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        FavoritesUtil.setParameters(collectionmap, request.getConfiguration(), request.getItems(), request.getRequestToken());
    }

    protected String buildPath()
        throws ServiceException
    {
        return RefTagUtil.addRefTag(getDefaultPath(), request.getRefTag());
    }
}
