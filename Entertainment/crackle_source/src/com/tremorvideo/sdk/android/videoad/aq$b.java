// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aq, ad

protected class <init> extends <init>
{

    final aq b;

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        ad.d("SSL Error");
        sslerrorhandler.proceed();
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
    }

    protected (aq aq1)
    {
        b = aq1;
        super(aq1);
    }
}
