// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.identity.auth.device.utils.MAPArgContracts;

// Referenced classes of package com.amazon.identity.auth.device.api:
//            MAPAndroidWebViewHelper

public class MAPAndroidWebViewClient extends WebViewClient
{

    private static final String TAG = com/amazon/identity/auth/device/api/MAPAndroidWebViewClient.getName();
    private final MAPAndroidWebViewHelper mWebViewHelper;

    public MAPAndroidWebViewClient(Activity activity)
    {
        MAPArgContracts.throwIfNull(activity, "Activity");
        mWebViewHelper = new MAPAndroidWebViewHelper(activity);
    }

    public MAPAndroidWebViewClient(MAPAndroidWebViewHelper mapandroidwebviewhelper)
    {
        MAPArgContracts.throwIfNull(mapandroidwebviewhelper, "MAPAndroidWebViewHelper");
        mWebViewHelper = mapandroidwebviewhelper;
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        String s1 = TAG;
        if (mWebViewHelper.handleAuthentication(webview, s))
        {
            return;
        } else
        {
            super.onPageStarted(webview, s, bitmap);
            return;
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        String s = TAG;
        (new StringBuilder("Got an SSL error:")).append(sslerror.toString()).toString();
        if (android.os.Build.VERSION.SDK_INT < 8)
        {
            mWebViewHelper.handleSSLError(sslerror);
            return;
        } else
        {
            super.onReceivedSslError(webview, sslerrorhandler, sslerror);
            return;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        String s1 = TAG;
        return mWebViewHelper.handleAuthentication(webview, s);
    }

}
