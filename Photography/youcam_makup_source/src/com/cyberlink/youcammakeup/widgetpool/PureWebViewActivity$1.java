// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool:
//            PureWebViewActivity

class a extends WebViewClient
{

    final PureWebViewActivity a;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview.loadUrl(s);
        return true;
    }

    A(PureWebViewActivity purewebviewactivity)
    {
        a = purewebviewactivity;
        super();
    }
}
