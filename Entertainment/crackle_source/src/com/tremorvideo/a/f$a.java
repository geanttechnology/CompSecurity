// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.a;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.a:
//            f, a

private class <init> extends <init>
{

    final f b;

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        b.d.a(new a("An SSL Error Occured.", -1, ""));
        super.a();
        webview.clearView();
        webview.loadUrl("about:blank");
    }

    private ror(f f1)
    {
        b = f1;
        super(f1);
    }

    <init>(f f1, <init> <init>1)
    {
        this(f1);
    }
}
