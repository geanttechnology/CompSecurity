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

class val.childWebView extends WebChromeClient
{

    final val.childWebView this$2;
    final WebView val$childWebView;

    public void onCloseWindow(WebView webview)
    {
        super.onCloseWindow(webview);
        maybankChildWebViewsContainer.removeAllViews();
        val$childWebView.destroy();
        paymentWebViewMaybank.setVisibility(0);
    }

    is._cls1()
    {
        this$2 = final__pcls1;
        val$childWebView = WebView.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/IPay88Purchase$IPayWebViewClient$1

/* anonymous class */
    class IPay88Purchase.IPayWebViewClient._cls1 extends WebChromeClient
    {

        final IPay88Purchase.IPayWebViewClient this$1;

        public void onCloseWindow(WebView webview)
        {
            super.onCloseWindow(webview);
            destroyPaymentWebView(paymentWebViewMaybank);
            paymentWebViewMaybank = null;
            paymentWebView.setVisibility(0);
        }

        public boolean onCreateWindow(WebView webview, boolean flag, boolean flag1, Message message)
        {
            maybankChildWebViewsContainer.removeAllViews();
            webview = new WebView(this$0);
            webview.getSettings().setJavaScriptEnabled(true);
            webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            webview.setWebChromeClient(webview. new IPay88Purchase.IPayWebViewClient._cls1._cls1());
            webview.setWebViewClient(new IPay88Purchase.IPayWebViewClient._cls1._cls2());
            WebViewHelper.addInAppUserAgent(webview);
            maybankChildWebViewsContainer.addView(webview);
            ((android.webkit.WebView.WebViewTransport)message.obj).setWebView(webview);
            message.sendToTarget();
            paymentWebViewMaybank.setVisibility(8);
            maybankChildWebViewsContainer.setVisibility(0);
            return true;
        }

            
            {
                this$1 = IPay88Purchase.IPayWebViewClient.this;
                super();
            }

        // Unreferenced inner class com/groupon/activity/IPay88Purchase$IPayWebViewClient$1$2

/* anonymous class */
        class IPay88Purchase.IPayWebViewClient._cls1._cls2 extends WebViewClient
        {

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
        }

    }

}
