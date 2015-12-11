// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.amazon.device.ads:
//            dw, cn

private final class <init> extends WebChromeClient
{

    final dw a;

    public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
    {
        dw.a(a).b(s1, null);
        return false;
    }

    private ent(dw dw1)
    {
        a = dw1;
        super();
    }

    ent(dw dw1, byte byte0)
    {
        this(dw1);
    }
}
