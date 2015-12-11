// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.internal:
//            de, cv, dd, da, 
//            ab, db

public final class dg extends de
{

    public dg(dd dd1, boolean flag)
    {
        super(dd1, flag);
    }

    private static WebResourceResponse d(Context context, String s, String s1)
        throws IOException
    {
        s1 = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(s1)).openConnection());
        cv.a(context, s, true, s1);
        s1.connect();
        context = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(cv.a(new InputStreamReader(s1.getInputStream())).getBytes("UTF-8")));
        s1.disconnect();
        return context;
        context;
        s1.disconnect();
        throw context;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        Object obj;
        try
        {
            if (!"mraid.js".equalsIgnoreCase((new File(s)).getName()))
            {
                return super.shouldInterceptRequest(webview, s);
            }
            if (!(webview instanceof dd))
            {
                da.w("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webview, s);
            }
            obj = (dd)webview;
            ((dd) (obj)).bb().ar();
            if (((dd) (obj)).Q().lo)
            {
                da.v("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return d(((dd) (obj)).getContext(), ng.bd().pU, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            }
            if (((dd) (obj)).be())
            {
                da.v("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return d(((dd) (obj)).getContext(), ng.bd().pU, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            }
            da.v("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
            obj = d(((dd) (obj)).getContext(), ng.bd().pU, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        }
        catch (IOException ioexception)
        {
            da.w((new StringBuilder()).append("Could not fetching MRAID JS. ").append(ioexception.getMessage()).toString());
            return super.shouldInterceptRequest(webview, s);
        }
        return ((WebResourceResponse) (obj));
    }
}
