// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.supersonicads.sdk.utils.Logger;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

private class <init> extends WebChromeClient
{

    final SupersonicWebView this$0;

    public View getVideoLoadingProgressView()
    {
        FrameLayout framelayout = new FrameLayout(SupersonicWebView.access$1500(SupersonicWebView.this));
        framelayout.setLayoutParams(new android.widget.(-1, -1));
        return framelayout;
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        Logger.i("MyApplication", (new StringBuilder()).append(consolemessage.message()).append(" -- From line ").append(consolemessage.lineNumber()).append(" of ").append(consolemessage.sourceId()).toString());
        return true;
    }

    public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
    {
        webview = new WebView(webview.getContext());
        webview.setWebChromeClient(this);
        webview.setWebViewClient(new iewClient(SupersonicWebView.this, null));
        ((android.webkit.View._cls1)message.obj).View(webview);
        message.sendToTarget();
        Logger.i("onCreateWindow", "onCreateWindow");
        return true;
    }

    public void onHideCustomView()
    {
        Logger.i("Test", "onHideCustomView");
        if (SupersonicWebView.access$1200(SupersonicWebView.this) == null)
        {
            return;
        } else
        {
            SupersonicWebView.access$1200(SupersonicWebView.this).setVisibility(8);
            SupersonicWebView.access$1300(SupersonicWebView.this).removeView(SupersonicWebView.access$1200(SupersonicWebView.this));
            SupersonicWebView.access$1202(SupersonicWebView.this, null);
            SupersonicWebView.access$1300(SupersonicWebView.this).setVisibility(8);
            SupersonicWebView.access$1400(SupersonicWebView.this).onCustomViewHidden();
            setVisibility(0);
            return;
        }
    }

    public void onShowCustomView(View view, android.webkit.ack ack)
    {
        Logger.i("Test", "onShowCustomView");
        setVisibility(8);
        if (SupersonicWebView.access$1200(SupersonicWebView.this) != null)
        {
            Logger.i("Test", "mCustomView != null");
            ack.onCustomViewHidden();
            return;
        } else
        {
            Logger.i("Test", "mCustomView == null");
            SupersonicWebView.access$1300(SupersonicWebView.this).addView(view);
            SupersonicWebView.access$1202(SupersonicWebView.this, view);
            SupersonicWebView.access$1402(SupersonicWebView.this, ack);
            SupersonicWebView.access$1300(SupersonicWebView.this).setVisibility(0);
            return;
        }
    }

    private iewClient()
    {
        this$0 = SupersonicWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
