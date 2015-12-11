// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.poshmark.utils.ExternalAppUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            MappPageFragment

class this._cls0 extends WebViewClient
{

    final MappPageFragment this$0;

    public void onPageFinished(WebView webview, String s)
    {
        loadComplete(webview);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        if (i != 302);
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview, String s)
    {
        return null;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.startsWith("market://"))
        {
            webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
            return true;
        }
        if (s.startsWith("mailto:"))
        {
            ExternalAppUtils.showEmailClientForURL(getActivity(), s);
            return true;
        } else
        {
            webview.addJavascriptInterface(new Interface(MappPageFragment.this, getActivity()), "AndroidInterface");
            return false;
        }
    }

    Interface()
    {
        this$0 = MappPageFragment.this;
        super();
    }
}
