// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.arellomobile.android.push:
//            PushWebview

private class <init> extends WebViewClient
{

    final PushWebview this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        finish();
        webview = new Intent("android.intent.action.VIEW", Uri.parse(s));
        startActivity(webview);
        return false;
    }

    private ()
    {
        this$0 = PushWebview.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
