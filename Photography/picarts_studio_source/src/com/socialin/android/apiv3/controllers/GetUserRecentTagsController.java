// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.RecentTagsResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.ParamWithUserData;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetUserRecentTagsController extends BaseSocialinApiRequestController
{

    private int requestId;

    public GetUserRecentTagsController()
    {
        requestId = -1;
    }

    public void doRequest(String s, ParamWithUserData paramwithuserdata)
    {
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getUserRecentTags(paramwithuserdata.userId, s, this, cacheConfig);
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

    public void onSuccess(RecentTagsResponse recenttagsresponse, Request request)
    {
        super.onSuccess(recenttagsresponse, request);
        while (recenttagsresponse == null || "error".equals(recenttagsresponse.status) || request.g.a != 2 || !"success".equals(recenttagsresponse.status)) 
        {
            return;
        }
        SocialinApiV3.getInstance().getUserRecentTags(((ParamWithUserData)params).userId, null, null, 3);
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((RecentTagsResponse)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((RecentTagsResponse)obj, request);
    }
}
