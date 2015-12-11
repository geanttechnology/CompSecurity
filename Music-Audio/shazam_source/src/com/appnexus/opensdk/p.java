// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.appnexus.opensdk.b.b;

class p extends WebChromeClient
{

    p()
    {
    }

    public boolean onConsoleMessage(ConsoleMessage consolemessage)
    {
        b.a(b.h, b.a(an.d.console_message, consolemessage.message(), consolemessage.lineNumber(), consolemessage.sourceId()));
        return true;
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        b.a(b.h, b.a(an.d.js_alert, s1, s));
        jsresult.confirm();
        return true;
    }
}
