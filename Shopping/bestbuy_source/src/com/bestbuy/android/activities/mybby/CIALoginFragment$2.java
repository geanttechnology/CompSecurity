// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            CIALoginFragment

class a extends WebChromeClient
{

    final CIALoginFragment a;

    public void onCloseWindow(WebView webview)
    {
        super.onCloseWindow(webview);
        webview.goBack();
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
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

    (CIALoginFragment cialoginfragment)
    {
        a = cialoginfragment;
        super();
    }
}
