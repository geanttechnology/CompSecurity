// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.ads;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class e extends WebChromeClient
{

    e()
    {
    }

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        jsresult.confirm();
        return true;
    }
}
