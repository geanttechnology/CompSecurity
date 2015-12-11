// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.b.a.a.g;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.activities:
//            OfferUpWebViewActivity, a

final class en extends WebViewClient
{

    private OfferUpWebViewActivity a;

    en(OfferUpWebViewActivity offerupwebviewactivity)
    {
        a = offerupwebviewactivity;
        super();
    }

    private static void a(WebView webview)
    {
        webview.loadData("<html></html>", "text/html", null);
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        OfferUpWebViewActivity.b(a);
        try
        {
            webview.setBackgroundColor(0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                OfferUpWebViewActivity.a(a, webview);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            g.c("OfferUpWebViewActivity", Log.getStackTraceString(webview));
        }
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        OfferUpWebViewActivity.b(a);
        a(webview);
    }

    public final void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        OfferUpWebViewActivity.b(a);
        a(webview);
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        String s1;
        g.a(com/offerup/android/activities/OfferUpWebViewActivity.getSimpleName(), (new StringBuilder("shouldOverrideUrlLoading ")).append(s).toString());
        s1 = null;
        if (StringUtils.isEmpty(s))
        {
            return true;
        }
        String s2 = (new URL(s)).getHost();
        s1 = s2;
_L2:
        if (s.contains("/accounts/block/"))
        {
            a.b = false;
            OfferUpWebViewActivity.a(a);
            webview.loadUrl(s);
            return false;
        }
        break MISSING_BLOCK_LABEL_94;
        Object obj;
        obj;
        g.a("OfferUpWebViewActivity", ((Exception) (obj)));
        continue; /* Loop/switch isn't completed */
        if (s.startsWith("ouapp"))
        {
            if (s.contains("CloseWebView"))
            {
                a.finish();
            }
            return true;
        }
        if (s.contains("?open=webview"))
        {
            a.f.a("OfferUp", s.substring(0, s.indexOf('?')));
            return true;
        }
        if (a.c != null && s1 != null && s1.endsWith(a.c) || s1.endsWith("zendesk.com"))
        {
            OfferUpWebViewActivity.a(a);
            webview.loadUrl(s);
            return false;
        } else
        {
            return OfferUpWebViewActivity.a(a, webview, s);
        }
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
