// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.socialin.android.d;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            WebViewActivity

final class r extends WebViewClient
{

    private String a;
    private WebViewActivity b;

    public r(WebViewActivity webviewactivity, String s)
    {
        b = webviewactivity;
        super();
        a = s;
    }

    public final void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (s.equals(a))
        {
            webview.setVisibility(0);
            b.findViewById(0x7f100adb).setVisibility(4);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        d.b("WebViewActivity", new Object[] {
            (new StringBuilder("shouldOverrideUrlLoading: url= ")).append(s).toString()
        });
        webview = s.toLowerCase();
        if (webview.contains("picsart.com/i/".toLowerCase()))
        {
            webview = s.substring(webview.lastIndexOf("picsart.com/i/".toLowerCase()) + 14, webview.length());
            if (!TextUtils.isEmpty(webview))
            {
                WebViewActivity.a(b, Long.parseLong(webview));
                return true;
            }
        } else
        if (webview.contains("picsart.com/#".toLowerCase()))
        {
            webview = s.substring(webview.lastIndexOf("picsart.com/#".toLowerCase()) + 13, webview.length());
            if (!TextUtils.isEmpty(webview))
            {
                WebViewActivity.b(b, Long.parseLong(webview));
                return true;
            }
        } else
        if (!webview.contains("picsart"))
        {
            b.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
        }
        return false;
    }
}
