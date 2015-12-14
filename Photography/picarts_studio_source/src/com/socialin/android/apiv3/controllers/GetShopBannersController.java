// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.ShopBannersResponse;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetShopBannersController extends BaseSocialinApiRequestController
{

    int requestId;

    public GetShopBannersController()
    {
        requestId = -1;
    }

    public void doRequest(String s, ParamWithUserData paramwithuserdata)
    {
        params = paramwithuserdata;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getShopBanners(s, this, 5, SocialinV3.market);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ParamWithUserData)requestparams);
    }

    public int getRequestId()
    {
        return requestId;
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((ShopBannersResponse)response, request);
    }

    public void onSuccess(ShopBannersResponse shopbannersresponse, Request request)
    {
        super.onSuccess(shopbannersresponse, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((ShopBannersResponse)obj, request);
    }
}
