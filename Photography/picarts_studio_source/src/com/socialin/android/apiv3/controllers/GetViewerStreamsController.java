// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.StreamsResponse;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetViewerStreamsController extends BaseSocialinApiRequestController
{

    int requestId;

    public GetViewerStreamsController()
    {
        requestId = -1;
        params = new ParamWithPageLimit();
    }

    public void doRequest(String s, ParamWithPageLimit paramwithpagelimit)
    {
        params = paramwithpagelimit;
        if (status == 0)
        {
            return;
        } else
        {
            status = 0;
            requestId = SocialinApiV3.getInstance().getViewerStreams(paramwithpagelimit.userId, s, this, 5);
            return;
        }
    }

    public volatile void doRequest(String s, RequestParams requestparams)
    {
        doRequest(s, (ParamWithPageLimit)requestparams);
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

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((StreamsResponse)response, request);
    }

    public void onSuccess(StreamsResponse streamsresponse, Request request)
    {
        super.onSuccess(streamsresponse, request);
        while (streamsresponse == null || "error".equals(streamsresponse.status) || request.g.a != 2 || !"success".equals(streamsresponse.status)) 
        {
            return;
        }
        SocialinApiV3.getInstance().getViewerStreams(((ParamWithPageLimit)params).userId, null, null, 3);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((StreamsResponse)obj, request);
    }
}
