// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.pipcamera.activity:
//            FWebViewActivity

class a extends WebViewClient
{

    final FWebViewActivity a;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview.loadUrl(s);
        return true;
    }

    (FWebViewActivity fwebviewactivity)
    {
        a = fwebviewactivity;
        super();
    }
}
