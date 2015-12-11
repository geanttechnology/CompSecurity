// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.groupon.util.WebViewHelper;

// Referenced classes of package com.groupon.activity:
//            IPay88Purchase

class this._cls1 extends WebChromeClient
{

    final Container this$1;

    public void onCloseWindow(WebView webview)
    {
        super.onCloseWindow(webview);
        destroyPaymentWebView(paymentWebViewMaybank);
        paymentWebViewMaybank = null;
        paymentWebView.setVisibility(0);
    }

    public boolean onCreateWindow(final WebView childWebView, boolean flag, boolean flag1, Message message)
    {
        maybankChildWebViewsContainer.removeAllViews();
        childWebView = new WebView(_fld0);
        childWebView.getSettings().setJavaScriptEnabled(true);
        childWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        childWebView.setWebChromeClient(new WebChromeClient() {

            final IPay88Purchase.IPayWebViewClient._cls1 this$2;
            final WebView val$childWebView;

            public void onCloseWindow(WebView webview)
            {
                super.onCloseWindow(webview);
                maybankChildWebViewsContainer.removeAllViews();
                childWebView.destroy();
                paymentWebViewMaybank.setVisibility(0);
            }

            
            {
                this$2 = IPay88Purchase.IPayWebViewClient._cls1.this;
                childWebView = webview;
                super();
            }
        });
        childWebView.setWebViewClient(new WebViewClient() {

            final IPay88Purchase.IPayWebViewClient._cls1 this$2;

            public void onPageFinished(WebView webview, String s)
            {
                doOnPageFinishedLogging(s);
                super.onPageFinished(webview, s);
                spinner.dismiss();
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                doOnPageStartedLogging(s);
                try
                {
                    super.onPageStarted(webview, s, bitmap);
                    spinner.show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    spinner.dismiss();
                }
            }

            
            {
                this$2 = IPay88Purchase.IPayWebViewClient._cls1.this;
                super();
            }
        });
        WebViewHelper.addInAppUserAgent(childWebView);
        maybankChildWebViewsContainer.addView(childWebView);
        ((android.webkit.bViewsContainer)message.obj).(childWebView);
        message.sendToTarget();
        paymentWebViewMaybank.setVisibility(8);
        maybankChildWebViewsContainer.setVisibility(0);
        return true;
    }

    _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
