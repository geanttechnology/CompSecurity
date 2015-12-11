// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.webkit.WebView;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAndroidWebViewHelper

static final class val.url
    implements Runnable
{

    final String val$url;
    final WebView val$webView;

    public void run()
    {
        val$webView.loadUrl(val$url);
    }

    (WebView webview, String s)
    {
        val$webView = webview;
        val$url = s;
        super();
    }
}
