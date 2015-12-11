// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import com.groupon.util.WebViewHelper;
import java.net.URI;
import java.net.URISyntaxException;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            IPay88Purchase

public class wClient extends wClient
{

    final IPay88Purchase this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        doShouldOverrideUrlLoadingLogging(s);
        webview = null;
        Object obj = new URI(s);
        webview = ((WebView) (obj));
_L2:
        obj = getResUrl();
        if (webview != null && Strings.equalsIgnoreCase(webview.getAuthority(), "www.maybank2u.com.my"))
        {
            setBasicWebViewSettings(paymentWebViewMaybank);
            paymentWebViewMaybank.setWebViewClient(getECommerceWebViewClient());
            paymentWebViewMaybank.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            paymentWebViewMaybank.getSettings().setSupportMultipleWindows(true);
            paymentWebViewMaybank.setWebChromeClient(new WebChromeClient() {

                final IPay88Purchase.IPayWebViewClient this$1;

                public void onCloseWindow(WebView webview1)
                {
                    super.onCloseWindow(webview1);
                    destroyPaymentWebView(paymentWebViewMaybank);
                    paymentWebViewMaybank = null;
                    paymentWebView.setVisibility(0);
                }

                public boolean onCreateWindow(WebView webview1, boolean flag, boolean flag1, Message message)
                {
                    maybankChildWebViewsContainer.removeAllViews();
                    webview1 = new WebView(this$0);
                    webview1.getSettings().setJavaScriptEnabled(true);
                    webview1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                    webview1.setWebChromeClient(webview1. new WebChromeClient() {

                        final _cls1 this$2;
                        final WebView val$childWebView;

                        public void onCloseWindow(WebView webview)
                        {
                            super.onCloseWindow(webview);
                            maybankChildWebViewsContainer.removeAllViews();
                            childWebView.destroy();
                            paymentWebViewMaybank.setVisibility(0);
                        }

            
            {
                this$2 = final__pcls1;
                childWebView = WebView.this;
                super();
            }
                    });
                    webview1.setWebViewClient(new WebViewClient() {

                        final _cls1 this$2;

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
                this$2 = _cls1.this;
                super();
            }
                    });
                    WebViewHelper.addInAppUserAgent(webview1);
                    maybankChildWebViewsContainer.addView(webview1);
                    ((android.webkit.WebView.WebViewTransport)message.obj).setWebView(webview1);
                    message.sendToTarget();
                    paymentWebViewMaybank.setVisibility(8);
                    maybankChildWebViewsContainer.setVisibility(0);
                    return true;
                }

            
            {
                this$1 = IPay88Purchase.IPayWebViewClient.this;
                super();
            }
            });
            paymentWebView.setVisibility(8);
            paymentWebViewMaybank.loadUrl(s);
            paymentWebViewMaybank.setVisibility(0);
            return true;
        }
        break; /* Loop/switch isn't completed */
        obj;
        Ln.e(((Throwable) (obj)));
        if (true) goto _L2; else goto _L1
_L1:
        if (Strings.notEmpty(obj) && s.startsWith(((String) (obj))))
        {
            webview = getIntent();
            webview.putExtra("payment_res", s);
            setResult(-1, webview);
            spinner.dismiss();
            finish();
            return true;
        } else
        {
            return false;
        }
    }

    public _cls1.this._cls1()
    {
        this$0 = IPay88Purchase.this;
        super(IPay88Purchase.this);
    }
}
