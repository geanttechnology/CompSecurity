// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.activity;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.rdio.android.sdk.activity:
//            OAuth2WebViewActivity

private class <init> extends WebViewClient
{

    final OAuth2WebViewActivity this$0;

    private boolean equalUrls(String s, String s1)
    {
        s = Uri.parse(s);
        for (s1 = Uri.parse(s1); !s.getScheme().equals(s1.getScheme()) || !s.getHost().equals(s1.getHost()) || !s.getPath().equals(s1.getPath());)
        {
            return false;
        }

        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (equalUrls(s, OAuth2WebViewActivity.access$100(OAuth2WebViewActivity.this)))
        {
            webview.loadUrl("about:blank");
            webview = new Intent();
            webview.putExtra("authResultUrl", s);
            setResult(-1, webview);
            finish();
        } else
        {
            webview.loadUrl(s);
        }
        return false;
    }

    private ()
    {
        this$0 = OAuth2WebViewActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
