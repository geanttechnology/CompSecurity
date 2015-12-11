// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.web;

import android.graphics.Bitmap;
import android.webkit.WebView;
import com.amazon.mobile.mash.MASHWebView;
import com.amazon.mobile.mash.interception.MASHUrlIntercepter;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.now.web:
//            NowWebViewClient, NowWebFragment, WebViewSubscriber

protected static class mWebFragment extends NowWebViewClient
{

    private final NowWebFragment mWebFragment;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        if (mWebFragment.getSubscriber() != null)
        {
            mWebFragment.getSubscriber().onPageFinished();
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if (mWebFragment.getSubscriber() != null)
        {
            mWebFragment.getSubscriber().onPageStarted();
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        if (mWebFragment.getSubscriber() != null)
        {
            mWebFragment.getSubscriber().onPageError();
        }
    }

    public (NowWebFragment nowwebfragment, CordovaInterface cordovainterface, MASHWebView mashwebview, MASHNavDelegate mashnavdelegate, MASHUrlIntercepter mashurlintercepter)
    {
        super(cordovainterface, mashwebview, mashnavdelegate, mashurlintercepter);
        mWebFragment = nowwebfragment;
    }
}
