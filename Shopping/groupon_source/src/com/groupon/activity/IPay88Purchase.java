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
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.order.Order;
import com.groupon.util.WebViewHelper;
import java.net.URI;
import java.net.URISyntaxException;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class IPay88Purchase extends ECommercePurchase
{
    public class IPayWebViewClient extends ECommercePurchase.ECommerceWebViewClient
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

                    final IPayWebViewClient this$1;

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
                        webview = new WebView(_fld0);
                        webview.getSettings().setJavaScriptEnabled(true);
                        webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
                        webview.setWebChromeClient(webview. new WebChromeClient() {

                            final IPayWebViewClient._cls1 this$2;
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
                        webview.setWebViewClient(new WebViewClient() {

                            final IPayWebViewClient._cls1 this$2;

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
                this$2 = IPayWebViewClient._cls1.this;
                super();
            }
                        });
                        WebViewHelper.addInAppUserAgent(webview);
                        maybankChildWebViewsContainer.addView(webview);
                        ((android.webkit.WebView.WebViewTransport)message.obj).setWebView(webview);
                        message.sendToTarget();
                        paymentWebViewMaybank.setVisibility(8);
                        maybankChildWebViewsContainer.setVisibility(0);
                        return true;
                    }

            
            {
                this$1 = IPayWebViewClient.this;
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

        public IPayWebViewClient()
        {
            this$0 = IPay88Purchase.this;
            super(IPay88Purchase.this);
        }
    }


    public static final String IPAY_M2U_MAYBANK2U_BASE_URL = "www.maybank2u.com.my";
    public static final int REQUEST_CODE = 10133;
    LinearLayout maybankChildWebViewsContainer;
    WebView paymentWebViewMaybank;

    public IPay88Purchase()
    {
    }

    protected int getCustomLayoutName()
    {
        return 0x7f0301b7;
    }

    protected WebViewClient getECommerceWebViewClient()
    {
        return super.getNewWebViewClient();
    }

    protected WebViewClient getNewWebViewClient()
    {
        return new IPayWebViewClient();
    }

    protected String getResUrl()
    {
        return order.billingRecord.termUrl;
    }

    public void onDestroy()
    {
        if (paymentWebViewMaybank != null)
        {
            destroyPaymentWebView(paymentWebViewMaybank);
            paymentWebViewMaybank = null;
        }
        if (maybankChildWebViewsContainer.getChildCount() > 0)
        {
            WebView webview = (WebView)maybankChildWebViewsContainer.getChildAt(0);
            maybankChildWebViewsContainer.removeAllViews();
            webview.removeAllViews();
            webview.destroy();
        }
        super.onDestroy();
    }
}
