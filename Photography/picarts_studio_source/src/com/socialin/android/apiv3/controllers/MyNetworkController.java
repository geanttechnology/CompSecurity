// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.content.Context;
import android.content.res.Resources;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.ItemsResponse;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.GetItemsParams;
import com.socialin.android.apiv3.request.ParamWithPageLimit;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class MyNetworkController extends BaseSocialinApiRequestController
{

    private Context context;
    private final String defaultSearchTagList[];
    private int offset;
    int requestId;
    private String tag;

    public MyNetworkController(Context context1)
    {
        requestId = -1;
        offset = 0;
        params = new ParamWithPageLimit();
        defaultSearchTagList = context1.getResources().getStringArray(0x7f090002);
        context = context1;
    }

    private void sendRequest()
    {
        if (!SocialinV3.getInstance().isRegistered())
        {
            Object obj = SocialinV3.getInstance().getAppProps().getMyNetworkTags();
            GetItemsParams getitemsparams = new GetItemsParams();
            getitemsparams.offset = ((ParamWithPageLimit)params).offset;
            getitemsparams.limit = ((ParamWithPageLimit)params).limit;
            if (obj == null || ((List) (obj)).isEmpty())
            {
                obj = defaultSearchTagList[(new Random()).nextInt(defaultSearchTagList.length)];
            } else
            {
                obj = (String)((List) (obj)).get((new Random()).nextInt(((List) (obj)).size()));
            }
            getitemsparams.searchTag = ((String) (obj));
            requestId = SocialinApiV3.getInstance().searchItems(getitemsparams, tag, this, cacheConfig);
            return;
        } else
        {
            requestId = SocialinApiV3.getInstance().getNetworkPhotos(((ParamWithPageLimit)params).offset, ((ParamWithPageLimit)params).limit, -1L, tag, this, cacheConfig);
            return;
        }
    }

    public void doRequest(String s, ParamWithPageLimit paramwithpagelimit)
    {
        params = paramwithpagelimit;
        tag = s;
        if (status == 0)
        {
            return;
        }
        status = 0;
        offset = paramwithpagelimit.offset;
        if (paramwithpagelimit.offset != 0)
        {
            cacheConfig = 5;
        }
        sendRequest();
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
            ((ParamWithPageLimit)params).offset = 0;
            ((ParamWithPageLimit)params).lastId = 0L;
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
        if (!SocialinV3.getInstance().isRegistered() && offset == 0 && itemsresponse != null)
        {
            if (itemsresponse.items == null)
            {
                itemsresponse.items = new ArrayList();
                ExceptionReportService.reportString(context, (new StringBuilder("Response items are null : ")).append(request.a).toString(), "1");
            }
            if (itemsresponse.items.size() > 0)
            {
                itemsresponse.items.set(0, null);
            } else
            {
                itemsresponse.items.add(0, null);
            }
        }
        super.onSuccess(itemsresponse, request);
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
