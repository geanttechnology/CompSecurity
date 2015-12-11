// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gs;
import com.google.android.gms.internal.gu;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ach extends ace
{

    public ach(gu gu1, boolean flag)
    {
        super(gu1, flag);
    }

    protected WebResourceResponse a(Context context, String s, String s1)
    {
        s1 = (HttpURLConnection)(new URL(s1)).openConnection();
        abq.a(context, s, true, s1, true);
        s1.addRequestProperty("Cache-Control", "max-stale=3600");
        p.a(s1);
        s1.connect();
        p.b(s1);
        context = new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(abq.a(new InputStreamReader(p.d(s1))).getBytes("UTF-8")));
        s1.disconnect();
        return context;
        context;
        p.a(s1, context);
        throw context;
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
            if (!(webview instanceof gu))
            {
                acb.e("Tried to intercept request from a WebView that wasn't an AdWebView.");
                return super.shouldInterceptRequest(webview, s);
            }
            obj = (gu)webview;
            ((gu) (obj)).f().e();
            if (((gu) (obj)).e().e)
            {
                acb.d("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js)");
                return a(((gu) (obj)).getContext(), a.i().b, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
            }
            if (((gu) (obj)).j())
            {
                acb.d("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js)");
                return a(((gu) (obj)).getContext(), a.i().b, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
            }
            acb.d("shouldInterceptRequest(https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js)");
            obj = a(((gu) (obj)).getContext(), a.i().b, "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
        }
        catch (IOException ioexception)
        {
            acb.e((new StringBuilder()).append("Could not fetch MRAID JS. ").append(ioexception.getMessage()).toString());
            return super.shouldInterceptRequest(webview, s);
        }
        return ((WebResourceResponse) (obj));
    }
}
