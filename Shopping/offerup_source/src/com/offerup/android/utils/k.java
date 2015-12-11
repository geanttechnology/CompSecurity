// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.b.a.a.g;
import com.offerup.android.activities.OfferUpWebViewActivity;
import com.offerup.android.activities.UserDetailActivity;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.utils:
//            as

public abstract class k extends WebViewClient
{

    private Context a;

    public k(Context context)
    {
        a = context;
    }

    private static void a(WebView webview)
    {
        webview.loadData("<html></html>", "text/html", null);
    }

    public abstract void a();

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        a();
        try
        {
            webview.setBackgroundColor(0);
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                webview.setLayerType(1, null);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            g.a(this, webview);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        a();
        a(webview);
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        a();
        a(webview);
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        g.a(a.getClass().getSimpleName(), (new StringBuilder("shouldOverrideUrlLoading ")).append(s).toString());
        if (StringUtils.isNotEmpty(s))
        {
            try
            {
                webview = new Intent(a, com/offerup/android/activities/OfferUpWebViewActivity);
                webview.putExtra("uri", as.a(s));
                webview.putExtra("hideMenuOptions", true);
                a.startActivity(webview);
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                g.a(com/offerup/android/activities/UserDetailActivity.getSimpleName(), webview);
                return true;
            }
        }
        return true;
    }
}
