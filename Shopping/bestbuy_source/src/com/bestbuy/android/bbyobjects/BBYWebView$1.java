// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.bbyobjects;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.bestbuy.android.bbyobjects:
//            BBYWebView

class a extends WebChromeClient
{

    final BBYWebView a;

    public void onCloseWindow(WebView webview)
    {
        super.onCloseWindow(webview);
        webview.goBack();
    }

    public void onGeolocationPermissionsShowPrompt(String s, android.webkit.rmissions.Callback callback)
    {
        super.onGeolocationPermissionsShowPrompt(s, callback);
        a.a = callback;
        callback.invoke(s, true, false);
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        (new android.app.uilder(BBYWebView.a(a))).setTitle("BestBuy").setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener(jsresult) {

            final JsResult a;
            final BBYWebView._cls1 b;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                a.confirm();
            }

            
            {
                b = BBYWebView._cls1.this;
                a = jsresult;
                super();
            }
        }).setCancelable(false).create().show();
        return true;
    }

    public void onProgressChanged(WebView webview, int i)
    {
        super.onProgressChanged(webview, i);
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        super.onReceivedTitle(webview, s);
    }

    _cls1.a(BBYWebView bbywebview)
    {
        a = bbywebview;
        super();
    }
}
