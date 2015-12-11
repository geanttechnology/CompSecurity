// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.opl.web;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.web.MShopWebViewClient;
import com.amazon.mShop.web.MShopWebViewContainer;
import com.amazon.mShop.web.MShopWebViewNotification;
import com.amazon.mShop.web.NativeAppNotification;
import org.apache.cordova.CordovaInterface;

// Referenced classes of package com.amazon.mShop.opl.web:
//            WebPurchaseActivity

class this._cls0 extends MShopWebViewClient
{

    final WebPurchaseActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        WebPurchaseActivity.access$102(WebPurchaseActivity.this, false);
        if (WebPurchaseActivity.access$000(WebPurchaseActivity.this, s) && !getWebViewContainer().isWebViewReceivedError())
        {
            WebPurchaseActivity.access$200(WebPurchaseActivity.this);
            if (getIntent().getBooleanExtra("isCartPurchase", false))
            {
                MShopWebViewNotification.notifyCartCountChanged(0);
                NativeAppNotification.notifyNativeCartChanged(0);
            }
            webview.clearHistory();
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if (WebPurchaseActivity.access$000(WebPurchaseActivity.this, s))
        {
            WebPurchaseActivity.access$102(WebPurchaseActivity.this, true);
            com.amazon.mShop.platform.stance().invokeLater(new Runnable() {

                final WebPurchaseActivity._cls1 this$1;

                public void run()
                {
                    WebPurchaseActivity.access$102(this$0, false);
                }

            
            {
                this$1 = WebPurchaseActivity._cls1.this;
                super();
            }
            }, 30000L);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        WebPurchaseActivity.access$102(WebPurchaseActivity.this, false);
        if (isOneClick())
        {
            WebPurchaseActivity.access$200(WebPurchaseActivity.this);
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        super.onReceivedSslError(webview, sslerrorhandler, sslerror);
        WebPurchaseActivity.access$102(WebPurchaseActivity.this, false);
        if (isOneClick())
        {
            WebPurchaseActivity.access$200(WebPurchaseActivity.this);
        }
    }

    _cls1.this._cls1(CordovaInterface cordovainterface)
    {
        this$0 = WebPurchaseActivity.this;
        super(cordovainterface);
    }
}
