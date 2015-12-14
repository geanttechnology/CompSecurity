// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.TagsResponse;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetTagsGroupedController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 0x36ee80L;
    private int requestId;
    private String tag;

    public GetTagsGroupedController()
    {
        requestId = -1;
        tag = null;
        params = new GetItemsParams();
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
            requestId = SocialinApiV3.getInstance().getTagsGrouped(getitemsparams.type, getitemsparams.offset, getitemsparams.limit, s, this, cacheConfig, validPeriod);
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

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((TagsResponse)response, request);
    }

    public void onSuccess(TagsResponse tagsresponse, Request request)
    {
        super.onSuccess(tagsresponse, request);
        while (tagsresponse == null || "error".equals(tagsresponse.status) || request.g.a != 2 || request.g.e || !"success".equals(tagsresponse.status)) 
        {
            return;
        }
        cacheConfig = 3;
        doRequest(tag);
        cacheConfig = 2;
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((TagsResponse)obj, request);
    }

}
