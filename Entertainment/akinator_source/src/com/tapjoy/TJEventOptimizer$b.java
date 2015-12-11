// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.tapjoy:
//            TJEventOptimizer, TapjoyLog

final class <init> extends WebViewClient
{

    final TJEventOptimizer a;

    public final void onPageFinished(WebView webview, String s)
    {
        TapjoyLog.d(TJEventOptimizer.b(), "boostrap html loaded successfully");
    }

    public final void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        TapjoyLog.e(TJEventOptimizer.b(), (new StringBuilder("error:")).append(s).toString());
    }

    private (TJEventOptimizer tjeventoptimizer)
    {
        a = tjeventoptimizer;
        super();
    }

    init>(TJEventOptimizer tjeventoptimizer, byte byte0)
    {
        this(tjeventoptimizer);
    }
}
