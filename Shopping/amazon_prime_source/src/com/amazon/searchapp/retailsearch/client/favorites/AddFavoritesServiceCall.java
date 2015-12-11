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
import com.amazon.searchapp.retailsearch.model.AddFavoritesResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.client.favorites:
//            AddFavoritesRequest, FavoritesUtil

public class AddFavoritesServiceCall extends ServiceCall
{

    private final AddFavoritesRequest request;

    public AddFavoritesServiceCall(RetailSearchClient retailsearchclient, AddFavoritesRequest addfavoritesrequest, ServiceCallListener servicecalllistener)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.POST.getName(), "/mn/favorites/add", com/amazon/searchapp/retailsearch/model/AddFavoritesResult);
        request = addfavoritesrequest;
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
