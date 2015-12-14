// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            WebViewActivity

final class a extends WebChromeClient
{

    private WebViewActivity a;

    public final void onProgressChanged(WebView webview, int i)
    {
        webview = (Activity)WebViewActivity.a(a).getContext();
        webview.setTitle(0x7f0802f5);
        webview.setProgress(i * 100);
        if (i == 100)
        {
            webview.setTitle(0x7f0808af);
        }
    }

    (WebViewActivity webviewactivity)
    {
        a = webviewactivity;
        super();
    }
}
