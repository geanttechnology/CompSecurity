// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.primeupsell;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.amazon.mShop.web.MShopWebViewClient;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.primeupsell:
//            PrimeUpsellActivity, PrimeUpsellHelper

private class it> extends MShopWebViewClient
{

    final PrimeUpsellActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        PrimeUpsellHelper.primePageFinishLoading();
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        PrimeUpsellHelper.primePageFinishLoading();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        PrimeUpsellHelper.primePageFinishLoading();
    }

    public I(CordovaInterface cordovainterface)
    {
        this$0 = PrimeUpsellActivity.this;
        super(cordovainterface, new it>(PrimeUpsellActivity.this, null));
    }
}
