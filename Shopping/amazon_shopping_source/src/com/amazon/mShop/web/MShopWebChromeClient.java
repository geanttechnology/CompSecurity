// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.util.Log;
import android.webkit.WebView;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.util.Util;
import org.apache.cordova.CordovaChromeClient;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewContainer

class MShopWebChromeClient extends CordovaChromeClient
{

    protected static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private final MShopWebViewContainer mWebViewContainer;

    public MShopWebChromeClient(MShopWebViewContainer mshopwebviewcontainer, CordovaInterface cordovainterface, CordovaWebView cordovawebview)
    {
        super(cordovainterface, cordovawebview);
        mWebViewContainer = mshopwebviewcontainer;
    }

    public void onExceededDatabaseQuota(String s, String s1, long l, long l1, long l2, android.webkit.WebStorage.QuotaUpdater quotaupdater)
    {
        if (DEBUG)
        {
            Log.d("MShopWebChromeClient", (new StringBuilder()).append("onExceededDatabaseQuota estimatedSize: ").append(l1).append("  currentQuota: ").append(l).append("  totalUsedQuota: ").append(l2).toString());
        }
        if (l1 < 0x500000L)
        {
            quotaupdater.updateQuota(l1);
            return;
        } else
        {
            quotaupdater.updateQuota(l);
            return;
        }
    }

    public void onProgressChanged(WebView webview, int i)
    {
        super.onProgressChanged(webview, i);
        mWebViewContainer.onProgressChanged(i);
    }

    public void onReceivedTitle(WebView webview, String s)
    {
        super.onReceivedTitle(webview, s);
        if (!Util.isEmpty(s))
        {
            mWebViewContainer.setTitle(s);
        }
        if (DEBUG)
        {
            Log.i("MShopWebChromeClient", (new StringBuilder()).append("onReceivedTitle, title = ").append(s).toString());
        }
    }

}
