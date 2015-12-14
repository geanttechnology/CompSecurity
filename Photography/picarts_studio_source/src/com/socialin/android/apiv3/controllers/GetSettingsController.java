// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetSettingsController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 0x6ddd00L;
    private final boolean isOnAppStartup;
    int requestId;
    private final String type;

    public GetSettingsController(String s, boolean flag)
    {
        requestId = -1;
        type = s;
        isOnAppStartup = flag;
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
            requestId = SocialinApiV3.getInstance().settings("com.picsart.studio", SocialinV3.market, type, s, this, cacheConfig, validPeriod, isOnAppStartup);
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

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((Settings)response, request);
    }

    public void onSuccess(Settings settings, Request request)
    {
        while (settings == null || "error".equals(settings.status) || !"success".equals(settings.status)) 
        {
            return;
        }
        SocialinV3.getInstance().setSettings(settings);
        if (request.g.a == 2 && !request.g.e)
        {
            SocialinApiV3.getInstance().settings("com.picsart.studio", SocialinV3.market, type, null, this, 3, validPeriod, isOnAppStartup);
        }
        super.onSuccess(settings, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((Settings)obj, request);
    }

}
