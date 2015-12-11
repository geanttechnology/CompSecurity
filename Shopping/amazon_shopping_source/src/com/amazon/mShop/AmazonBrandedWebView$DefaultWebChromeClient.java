// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.amazon.mShop:
//            AmazonBrandedWebView, AmazonActivity

private class <init> extends WebChromeClient
{

    final AmazonBrandedWebView this$0;

    public void onReceivedTitle(WebView webview, String s)
    {
        if (AmazonBrandedWebView.access$500(AmazonBrandedWebView.this))
        {
            AmazonBrandedWebView.access$502(AmazonBrandedWebView.this, false);
        } else
        {
            AmazonBrandedWebView.access$602(AmazonBrandedWebView.this, s);
            webview = webview.getContext();
            if (webview instanceof AmazonActivity)
            {
                ((AmazonActivity)webview).updateTitle(AmazonBrandedWebView.this);
                return;
            }
        }
    }

    private ()
    {
        this$0 = AmazonBrandedWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
