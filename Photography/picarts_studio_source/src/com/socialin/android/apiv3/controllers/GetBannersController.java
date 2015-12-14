// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.BannersResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetBannersController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 0x36ee80L;
    int requestId;

    public GetBannersController()
    {
        requestId = -1;
    }

    public void doRequest(String s, RequestParams requestparams)
    {
        params = requestparams;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().banners("com.picsart.studio", SocialinV3.market, s, this, cacheConfig, validPeriod);
            return;
        }
    }

    public int getRequestId()
    {
        return requestId;
    }

    public void onFailure(Exception exception, Request request)
    {
        if (request.g.a == 2)
        {
            status = -1;
            cacheConfig = 3;
            doRequest();
            cacheConfig = 2;
            return;
        } else
        {
            super.onFailure(exception, request);
            return;
        }
    }

    public void onSuccess(BannersResponse bannersresponse, Request request)
    {
        super.onSuccess(bannersresponse, request);
        while (bannersresponse == null || "error".equals(bannersresponse.status) || !"success".equals(bannersresponse.status) || request.g.a != 2 || request.g.e) 
        {
            return;
        }
        SocialinApiV3.getInstance().banners("com.picsart.studio", SocialinV3.market, null, null, 3, validPeriod);
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((BannersResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((BannersResponse)obj, request);
    }

}
