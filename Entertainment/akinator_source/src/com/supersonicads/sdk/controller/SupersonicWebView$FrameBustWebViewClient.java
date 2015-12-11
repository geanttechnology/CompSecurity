// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView, OpenUrlActivity

private class <init> extends WebViewClient
{

    final SupersonicWebView this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Intent intent = new Intent(webview.getContext(), com/supersonicads/sdk/controller/OpenUrlActivity);
        intent.putExtra(SupersonicWebView.EXTERNAL_URL, s);
        intent.putExtra(SupersonicWebView.SECONDARY_WEB_VIEW, false);
        webview.getContext().startActivity(intent);
        return true;
    }

    private ()
    {
        this$0 = SupersonicWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
