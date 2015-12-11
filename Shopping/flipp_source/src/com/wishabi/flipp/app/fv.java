// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.content.res.Resources;
import android.net.Uri;
import android.view.ViewPropertyAnimator;
import android.webkit.HttpAuthHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

// Referenced classes of package com.wishabi.flipp.app:
//            fu, fw

final class fv extends WebViewClient
{

    final fu a;

    fv(fu fu1)
    {
        a = fu1;
        super();
    }

    public final void onPageFinished(WebView webview, String s)
    {
        if (a.getActivity() == null)
        {
            return;
        } else
        {
            a.b(webview.getTitle());
            int i = a.getResources().getInteger(0x10e0000);
            fu.a(a).setVisibility(0);
            fu.a(a).animate().alpha(1.0F).setDuration(i);
            fu.b(a).animate().alpha(0.0F).setDuration(i).setListener(new fw(this));
            return;
        }
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        webview.loadUrl("file:///android_asset/webview_error.html");
    }

    public final void onReceivedHttpAuthRequest(WebView webview, HttpAuthHandler httpauthhandler, String s, String s1)
    {
        while (a.getActivity() == null || httpauthhandler == null || !s.split(":")[0].equals(fu.c().getHost())) 
        {
            return;
        }
        webview = "".split(":");
        httpauthhandler.proceed(webview[0], webview[1]);
    }
}
