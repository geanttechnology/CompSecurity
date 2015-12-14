// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.controllers;

import android.content.Context;
import android.content.SharedPreferences;
import com.socialin.android.apiv3.PicsartAnalytics;
import com.socialin.android.apiv3.SocialinApiV3;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Response;
import com.socialin.android.apiv3.request.RequestParams;
import com.socialin.android.apiv3.util.AnalyticUtils;
import com.socialin.android.d;
import com.socialin.android.util.Utils;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.cache.a;

// Referenced classes of package com.socialin.android.apiv3.controllers:
//            BaseSocialinApiRequestController

public class GetAppPropsController extends BaseSocialinApiRequestController
{

    private static long validPeriod = 0x6ddd00L;
    private boolean isOnAppStartup;
    int requestId;
    private String type;

    public GetAppPropsController(String s, boolean flag)
    {
        requestId = -1;
        isOnAppStartup = false;
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
            requestId = SocialinApiV3.getInstance().apps("com.picsart.studio", SocialinV3.market, type, s, this, cacheConfig, validPeriod, isOnAppStartup);
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

    public void onSuccess(AppProps appprops, Request request)
    {
        if (appprops == null || "error".equals(appprops.status))
        {
            return;
        }
        if (!"success".equals(appprops.status)) goto _L2; else goto _L1
_L1:
        SocialinV3.getInstance().setAppProps(appprops);
        if (appprops.getData() != null && appprops.getData().api != null)
        {
            if (appprops.getData().api.baseUrl != null)
            {
                SocialinApiV3.getInstance().setApiBaseUrl(appprops.getData().api.baseUrl);
            }
            if (appprops.getData().api.retryUrl != null)
            {
                SocialinApiV3.getInstance().setApiBackupUrl(appprops.getData().api.retryUrl);
            }
            if (appprops.getData().api.uploadUrl != null)
            {
                SocialinApiV3.getInstance().setUploadUrl(appprops.getData().api.uploadUrl);
            }
            if (appprops.getData().api.notificationUrl != null)
            {
                SocialinApiV3.getInstance().setNotificationUrl(appprops.getData().api.notificationUrl);
            }
            if (appprops.getData().api.fourSquareUrl != null)
            {
                SocialinApiV3.getInstance().setFourSquareUrl(appprops.getData().api.fourSquareUrl);
            }
            if (appprops.getData().api.analyticsUrl != null)
            {
                PicsartAnalytics.serverUrl = appprops.getData().api.analyticsUrl;
            }
        }
        android.app.Application application;
        Exception exception;
        SharedPreferences sharedpreferences;
        android.content.SharedPreferences.Editor editor;
        if (request.g.a == 3)
        {
            try
            {
                d.b("socialin-request", new Object[] {
                    "AppProps refreshed - AD_PROVIDER:", appprops.getData().adProvider
                });
            }
            catch (Exception exception1) { }
        }
        if (request.g.a == 2 && !request.g.e)
        {
            SocialinApiV3.getInstance().apps("com.picsart.studio", SocialinV3.market, type, null, this, 3, validPeriod, isOnAppStartup);
        }
        application = SocialinV3.getInstance().getContext();
        sharedpreferences = application.getSharedPreferences("appState", 4);
        editor = sharedpreferences.edit();
        if (!sharedpreferences.getBoolean("FRESH_INSTALL", true)) goto _L4; else goto _L3
_L3:
        editor.putBoolean("FRESH_INSTALL", false);
        editor.apply();
        AnalyticUtils.getInstance(application).track(new com.socialin.android.apiv3.events.EventsFactory.UserAttributeEvent(application));
        Utils.l(application);
_L2:
        super.onSuccess(appprops, request);
        return;
_L4:
        try
        {
            if (sharedpreferences.getBoolean("UPDATE_INSTALL", false))
            {
                AnalyticUtils.getInstance(application).track(new com.socialin.android.apiv3.events.EventsFactory.AppUpdateEvent());
                editor.putBoolean("UPDATE_INSTALL", false);
                editor.apply();
                AnalyticUtils.getInstance(application).track(new com.socialin.android.apiv3.events.EventsFactory.UserAttributeEvent(application));
            }
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public volatile void onSuccess(Response response, Request request)
    {
        onSuccess((AppProps)response, request);
    }

    public volatile void onSuccess(Object obj, Request request)
    {
        onSuccess((AppProps)obj, request);
    }

}
