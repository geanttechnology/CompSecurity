// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.net.http.SslError;
import com.amazon.android.webkit.AmazonCookieSyncManager;
import com.amazon.android.webkit.AmazonSslErrorHandler;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.android.webkit.AmazonWebViewClient;

public abstract class AbstractMAPWebViewClient extends AmazonWebViewClient
{

    private static final String LOG_TAG = com/amazon/identity/auth/device/api/AbstractMAPWebViewClient.getName();

    public AbstractMAPWebViewClient()
    {
    }

    public abstract void handleSSLError(SslError sslerror);

    public void onPageFinished(AmazonWebView amazonwebview, String s)
    {
        String s1 = LOG_TAG;
        super.onPageFinished(amazonwebview, s);
        AmazonCookieSyncManager.getInstance().sync();
    }

    public void onReceivedSslError(AmazonWebView amazonwebview, AmazonSslErrorHandler amazonsslerrorhandler, SslError sslerror)
    {
        String s = LOG_TAG;
        (new StringBuilder("Got an SSL error:")).append(sslerror.toString()).toString();
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            handleSSLError(sslerror);
            return;
        } else
        {
            super.onReceivedSslError(amazonwebview, amazonsslerrorhandler, sslerror);
            return;
        }
    }

}
