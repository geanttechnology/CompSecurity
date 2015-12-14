// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.CardCollectionResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;
import java.util.List;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetExploreCardController extends BaseSocialinApiRequestController
{

    private boolean loadDataForTabletLandscape;
    private int requestId;
    private String tag;

    public GetExploreCardController()
    {
        requestId = -1;
        tag = null;
        loadDataForTabletLandscape = false;
        params = new GetItemsParams();
        ((GetItemsParams)params).limit = 10;
    }

    public void doRequest(String s, GetItemsParams getitemsparams)
    {
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            tag = s;
            params = getitemsparams;
            requestId = SocialinApiV3.getInstance().getExploreCards(getitemsparams, s, this, cacheConfig, loadDataForTabletLandscape);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (GetItemsParams)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    protected boolean isValidSuccessResult(CardCollectionResponse cardcollectionresponse)
    {
        return cardcollectionresponse != null && !"error".equals(cardcollectionresponse.status) && cardcollectionresponse.items != null && !cardcollectionresponse.items.isEmpty();
    }

    public void onFailure(Exception exception, Request request)
    {
        if (request.g.a == 2)
        {
            status = -1;
            cacheConfig = 3;
            doRequest(tag);
            cacheConfig = 2;
            return;
        } else
        {
            super.onFailure(exception, request);
            return;
        }
    }

    public void onSuccess(CardCollectionResponse cardcollectionresponse, Request request)
    {
        super.onSuccess(cardcollectionresponse, request);
        while (!isValidSuccessResult(cardcollectionresponse) || request.g.a != 2 || request.g.e || !"success".equals(cardcollectionresponse.status)) 
        {
            return;
        }
        cacheConfig = 3;
        doRequest(tag);
        cacheConfig = 2;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((CardCollectionResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((CardCollectionResponse)obj, request);
    }

    public void setLoadDataForTabletLandscape(boolean flag)
    {
        loadDataForTabletLandscape = flag;
    }
}
