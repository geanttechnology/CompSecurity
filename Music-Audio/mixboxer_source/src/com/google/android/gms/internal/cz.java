// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.google.android.gms.internal:
//            cx, co, cw, ct, 
//            x, cu

public final class cz extends cx
{

    public cz(cw cw1, boolean flag)
    {
        super(cw1, flag);
    }

    private static WebResourceResponse d(Context context, String s, String s1)
        throws IOException
    {
        s1 = (HttpURLConnection)Instrumentation.openConnection((new URL(s1)).openConnection());
        co.a(context, s, true, s1);
        s1.connect();
        context = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(co.a(new InputStreamReader(s1.getInputStream())).getBytes("UTF-8")));
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
            if (!(webview instanceof cw))
            {
                ct.v("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webview, s);
            }
            obj = (cw)webview;
            ((cw) (obj)).aC().Y();
            if (((cw) (obj)).y().eG)
            {
                ct.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_interstitial.js)");
                return d(((cw) (obj)).getContext(), gv.aE().iJ, "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");
            }
            if (((cw) (obj)).aF())
            {
                ct.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js)");
                return d(((cw) (obj)).getContext(), gv.aE().iJ, "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");
            }
            ct.u("shouldInterceptRequest(http://media.admob.com/mraid/v1/mraid_app_banner.js)");
            obj = d(((cw) (obj)).getContext(), gv.aE().iJ, "http://media.admob.com/mraid/v1/mraid_app_banner.js");
        }
        catch (IOException ioexception)
        {
            ct.v((new StringBuilder()).append("Could not fetching MRAID JS. ").append(ioexception.getMessage()).toString());
            return super.shouldInterceptRequest(webview, s);
        }
        return ((WebResourceResponse) (obj));
    }
}
