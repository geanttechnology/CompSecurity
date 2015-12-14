// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

class n extends WebChromeClient
{

    private final AppLovinLogger a;

    public n(AppLovinSdk applovinsdk)
    {
        a = applovinsdk.getLogger();
    }

    public void onConsoleMessage(String s, int i, String s1)
    {
        a.w("AdWebView", (new StringBuilder()).append("console.log[").append(i).append("] :").append(s).toString());
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        consolemessage = (new StringBuilder()).append(consolemessage.sourceId()).append(": ").append(consolemessage.lineNumber()).append(": ").append(consolemessage.message()).toString();
        a.d("AdWebView", consolemessage);
        return true;
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        a.w("AdWebView", (new StringBuilder()).append("Alert attempted: ").append(s1).toString());
        return true;
    }

    public boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
    {
        a.w("AdWebView", (new StringBuilder()).append("JS onBeforeUnload attempted: ").append(s1).toString());
        return true;
    }

    public boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
    {
        a.w("AdWebView", (new StringBuilder()).append("JS confirm attempted: ").append(s1).toString());
        return true;
    }
}
