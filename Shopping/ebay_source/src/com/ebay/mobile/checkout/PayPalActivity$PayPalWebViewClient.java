// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ScrollView;
import com.ebay.common.view.util.DialogManager;

// Referenced classes of package com.ebay.mobile.checkout:
//            PayPalActivity, CheckoutError

private class scrollView extends WebViewClient
{

    ScrollView scrollView;
    final PayPalActivity this$0;

    public void onPageFinished(WebView webview, String s)
    {
        if (isFinishing())
        {
            return;
        }
        if (CheckoutError.logCheckout.lView)
        {
            CheckoutError.logCheckout.lView("page finished");
        }
        if (loadingDialog != null && loadingDialog.isShowing())
        {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
        scrollView.scrollTo(0, 0);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        if (isFinishing())
        {
            return;
        }
        if (CheckoutError.logCheckout.lView)
        {
            CheckoutError.logCheckout.lView((new StringBuilder()).append("page start: ").append(s).toString());
        }
        boolean flag2 = true;
        boolean flag1 = false;
        byte byte0 = flag2;
        boolean flag = flag1;
        if (s != null)
        {
            if (s.contains("wap.ebay.com/returnurl?"))
            {
                if (guestXO)
                {
                    byte0 = 4;
                    flag = flag1;
                } else
                {
                    byte0 = 3;
                    flag = flag1;
                }
            } else
            if (s.contains("wap.ebay.com/cancelurl?") || s.contains("&cancel.x") || s.contains("_wapapp-logout") || s.contains("ebay.com"))
            {
                byte0 = 0;
                flag = flag1;
            } else
            if (s.contains("&logout_json=true"))
            {
                flag = true;
                byte0 = 2;
                PayPalActivity.access$100(PayPalActivity.this);
            } else
            {
                byte0 = flag2;
                flag = flag1;
                if (s.contains("&op=prepjson"))
                {
                    flag = true;
                    PayPalActivity paypalactivity = PayPalActivity.this;
                    boolean flag3;
                    if (s.contains("&guest_xo="))
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    paypalactivity.guestXO = flag3;
                    if (guestXO)
                    {
                        byte0 = 4;
                    } else
                    {
                        byte0 = 3;
                    }
                }
            }
        }
        if (flag)
        {
            webView.stopLoading();
        }
        if (byte0 != 1)
        {
            PayPalActivity.access$200(PayPalActivity.this, byte0, s);
            return;
        } else
        {
            super.onPageStarted(webview, s, bitmap);
            return;
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        Log.e("PayPalActivity", (new StringBuilder()).append((new Exception()).getStackTrace()[0].getMethodName()).append(": errorCode = <").append(i).append(">").append(": description = <").append(s).append(">").append(": failingUrl = <").append(s1).append(">").toString());
        dialogManager.showDynamicAlertDialog(null, s, true);
        PayPalActivity.access$200(PayPalActivity.this, 0, null);
    }

    A()
    {
        this$0 = PayPalActivity.this;
        super();
        scrollView = (ScrollView)findViewById(0x7f1004ac);
    }
}
