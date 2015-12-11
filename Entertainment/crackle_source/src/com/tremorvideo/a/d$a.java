// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

// Referenced classes of package com.tremorvideo.a:
//            d, a, g, c

protected class Client extends WebViewClient
{

    final d a;

    protected void a()
    {
        d.b(a, false);
        if (a.isShowing())
        {
            a.dismiss();
        }
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (d.b(a) && !d.c(a))
        {
            d.b(a, false);
            a.getWindow().setFlags(1024, 1024);
            a.show();
            s = d.d(a).getTitle();
            if (s != null && s.length() > 0)
            {
                d.e(a).setText(s);
            }
            webview.forceLayout();
        }
        if (d.a(a) != null && d.a(a).isShowing())
        {
            d.a(a).dismiss();
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        Log.d("Facebook-WebView", (new StringBuilder()).append("Webview loading URL: ").append(s).toString());
        super.onPageStarted(webview, s, bitmap);
        if (!d.a(a).isShowing())
        {
            d.a(a).show();
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        a.d.a(new a(s, i, s1));
        a();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Log.d("Facebook-WebView", (new StringBuilder()).append("Redirect URL: ").append(s).toString());
        if (s.startsWith("fbconnect://success"))
        {
            Bundle bundle = g.b(s);
            s = bundle.getString("error");
            webview = s;
            if (s == null)
            {
                webview = bundle.getString("error_type");
            }
            if (webview == null)
            {
                a.d.a(bundle);
            } else
            if (webview.equals("access_denied") || webview.equals("OAuthAccessDeniedException"))
            {
                a.d.a();
            } else
            {
                a.d.a(new c(webview));
            }
            d.a(a, true);
            a.dismiss();
            return true;
        }
        if (s.startsWith("fbconnect://cancel"))
        {
            a.d.a();
            a.dismiss();
            return true;
        }
        if (s.contains("touch"))
        {
            return false;
        } else
        {
            a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
        }
    }

    protected (d d1)
    {
        a = d1;
        super();
    }
}
