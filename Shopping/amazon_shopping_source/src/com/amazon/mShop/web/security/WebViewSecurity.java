// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web.security;

import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ClientMetric;
import com.amazon.rio.j2me.client.services.mShop.ClientMetrics;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PostMetricsResponseListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class WebViewSecurity
{

    private static final boolean DEBUG = DebugSettings.isDebugEnabled();

    public WebViewSecurity()
    {
    }

    public static boolean isHTTPUrl(String s)
    {
        return !Util.isEmpty(s) && s.toLowerCase(AppLocale.getInstance().getCurrentLocale()).startsWith("http://");
    }

    public static void logMetricsForHTTPRequest(String s, String s1, boolean flag)
    {
        ClientMetrics clientmetrics = new ClientMetrics();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("referrer", Uri.encode(s));
            jsonobject.put("url", Uri.encode(s1));
            jsonobject.put("blocked", flag);
            if (DEBUG)
            {
                Log.i("WebViewSecurity", (new StringBuilder()).append("info: ").append(jsonobject.toString()).toString());
            }
            s = new ClientMetric();
            s.setName("BlockedHTTPPage");
            s.setInfo(jsonobject.toString());
            s1 = new ArrayList();
            s1.add(s);
            clientmetrics.setMetrics(s1);
            postMetrics(clientmetrics);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("WebViewSecurity", "", s);
        }
    }

    private static void postMetrics(ClientMetrics clientmetrics)
    {
        PostMetricsResponseListener postmetricsresponselistener = new PostMetricsResponseListener() {

            public void cancelled(ServiceCall servicecall)
            {
                if (WebViewSecurity.DEBUG)
                {
                    Log.i("WebViewSecurity", "post metrics cancelled");
                }
            }

            public void completed(Null null1, ServiceCall servicecall)
            {
                if (WebViewSecurity.DEBUG)
                {
                    Log.i("WebViewSecurity", "post metrics completed");
                }
            }

            public void error(Exception exception, ServiceCall servicecall)
            {
                if (WebViewSecurity.DEBUG)
                {
                    Log.w("WebViewSecurity", (new StringBuilder()).append("post metrics failed: ").append(exception).toString());
                }
            }

        };
        ServiceController.getMShopService().postMetrics(clientmetrics, postmetricsresponselistener);
    }

    public static boolean shouldBlockWebViewLoading(WebView webview, String s)
    {
        return isHTTPUrl(s) && ActivityUtils.isBlockHttpEnabled();
    }


}
