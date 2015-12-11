// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.boldchat.sdk:
//            BoldChatWebHistory

private class <init> extends WebViewClient
{

    final BoldChatWebHistory this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        webview = new Intent("android.intent.action.VIEW");
        webview.setFlags(0x4000000);
        webview.setData(Uri.parse(s));
        getContext().startActivity(webview);
        return true;
    }

    private ()
    {
        this$0 = BoldChatWebHistory.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
