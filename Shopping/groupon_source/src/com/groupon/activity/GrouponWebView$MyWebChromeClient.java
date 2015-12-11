// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponWebView

private class <init> extends WebChromeClient
{

    final GrouponWebView this$0;

    public void onReceivedTitle(WebView webview, String s)
    {
        super.onReceivedTitle(webview, s);
        GrouponWebView grouponwebview = GrouponWebView.this;
        webview = s;
        if (Strings.equals(s, "about:blank"))
        {
            webview = "";
        }
        grouponwebview.setActionBarTitle(webview);
    }

    private ()
    {
        this$0 = GrouponWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
