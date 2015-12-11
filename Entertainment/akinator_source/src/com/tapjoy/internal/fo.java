// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.tapjoy.internal:
//            ew

class fo extends WebChromeClient
{

    private final ew a;
    private final String b = com/tapjoy/internal/fo.getName();

    public fo(ew ew1)
    {
        a = ew1;
    }

    public boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        webview = b;
        (new StringBuilder("onJsAlert() -")).append(s1);
        a.getString(s1);
        jsresult.confirm();
        return true;
    }
}
