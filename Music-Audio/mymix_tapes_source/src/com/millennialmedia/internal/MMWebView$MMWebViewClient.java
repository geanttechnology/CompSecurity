// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.millennialmedia.internal.utils.Utils;

// Referenced classes of package com.millennialmedia.internal:
//            MMWebView

class this._cls0 extends WebViewClient
{

    final MMWebView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        if (!MMWebView.access$000(MMWebView.this, s))
        {
            MMWebView.access$102(MMWebView.this, true);
            MMWebView.access$200(MMWebView.this);
        }
        super.onPageFinished(webview, s);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        MMWebView.access$300(MMWebView.this).onFailed();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        while (MMWebView.access$000((MMWebView)webview, s) || !Utils.startActivityFromUrl(s)) 
        {
            return true;
        }
        MMWebView.access$300(MMWebView.this).onAdLeftApplication();
        return true;
    }

    r()
    {
        this$0 = MMWebView.this;
        super();
    }
}
