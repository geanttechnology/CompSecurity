// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.SslErrorHandler;
import com.amazon.android.webkit.AmazonSslErrorHandler;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewClient

class val.sslErrorHandler extends AmazonSslErrorHandler
{

    final AndroidWebViewClient this$0;
    final SslErrorHandler val$sslErrorHandler;

    public void cancel()
    {
        val$sslErrorHandler.cancel();
    }

    public void proceed()
    {
        val$sslErrorHandler.proceed();
    }

    ()
    {
        this$0 = final_androidwebviewclient;
        val$sslErrorHandler = SslErrorHandler.this;
        super();
    }
}
