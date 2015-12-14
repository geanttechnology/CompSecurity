// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.ItemsResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetRecentItemsController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 60000L;
    private int requestId;

    public GetRecentItemsController()
    {
        requestId = -1;
        params = new GetItemsParams();
        setCode(3);
    }

    public void doRequest(String s, GetItemsParams getitemsparams)
    {
        if (status == 0)
        {
            return;
        }
        status = 0;
        params = getitemsparams;
        if (getitemsparams.offset != 0)
        {
            cacheConfig = 5;
        }
        requestId = SocialinApiV3.getInstance().getRecentItems(getitemsparams.offset, getitemsparams.limit, getitemsparams.contentRating, getitemsparams.lastId, s, this, cacheConfig, validPeriod);
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (GetItemsParams)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public boolean isUpdateCache(ItemsResponse itemsresponse, Request request)
    {
        return request.g.a == 2 && !request.g.e && "success".equals(itemsresponse.status);
    }

    public void onFailure(Exception exception, Request request)
    {
        if (request.g.a == 2)
        {
            status = -1;
            cacheConfig = 3;
            ((GetItemsParams)params).offset = 0;
            ((GetItemsParams)params).lastId = 0L;
            doRequest();
            cacheConfig = 2;
            return;
        } else
        {
            super.onFailure(exception, request);
            return;
        }
    }

    public void onSuccess(ItemsResponse itemsresponse, Request request)
    {
        super.onSuccess(itemsresponse, request);
        while (itemsresponse == null || "error".equals(itemsresponse.status) || !isUpdateCache(itemsresponse, request)) 
        {
            return;
        }
        cacheConfig = 3;
        ((GetItemsParams)params).offset = 0;
        ((GetItemsParams)params).lastId = 0L;
        doRequest();
        cacheConfig = 2;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((ItemsResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ItemsResponse)obj, request);
    }

}
