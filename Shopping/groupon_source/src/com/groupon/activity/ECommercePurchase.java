// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.groupon.http.NameValuePair;
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.order.Order;
import com.groupon.util.HttpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public abstract class ECommercePurchase extends GrouponActivity
{
    public class ECommerceWebViewClient extends WebViewClient
    {

        final ECommercePurchase this$0;

        public void onPageFinished(WebView webview, String s)
        {
            doOnPageFinishedLogging(s);
            super.onPageFinished(webview, s);
            spinner.dismiss();
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            doOnPageStartedLogging(s);
            String s1 = getResUrl();
            if (Strings.notEmpty(s1) && s.startsWith(s1) && doExtraValidation(s))
            {
                webview = getIntent();
                webview.putExtra("payment_res", s);
                setResult(-1, webview);
                spinner.dismiss();
                finish();
                return;
            }
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

        public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
        {
            sslerrorhandler.proceed();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            doShouldOverrideUrlLoadingLogging(s);
            webview = getResUrl();
            if (Strings.notEmpty(webview) && s.startsWith(webview) && doExtraValidation(s))
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

        public ECommerceWebViewClient()
        {
            this$0 = ECommercePurchase.this;
            super();
        }
    }


    String LOADING;
    protected List nameValuePairs;
    public Order order;
    protected WebView paymentWebView;
    protected ProgressDialog spinner;
    protected String termUrl3dsecure;

    public ECommercePurchase()
    {
    }

    protected void destroyPaymentWebView(WebView webview)
    {
        ((ViewGroup)webview.getParent()).removeView(webview);
        webview.removeAllViews();
        webview.destroy();
    }

    protected boolean doExtraValidation(String s)
    {
        return true;
    }

    protected void doOnPageFinishedLogging(String s)
    {
        Ln.d("%s WebView onPageFinished %s", new Object[] {
            getClass().getSimpleName(), s
        });
    }

    protected void doOnPageStartedLogging(String s)
    {
        Ln.d("%s WebView onPageStarted %s", new Object[] {
            getClass().getSimpleName(), s
        });
    }

    protected void doShouldOverrideUrlLoadingLogging(String s)
    {
        Ln.d("%s WebView shouldOverrideUrlLoading %s", new Object[] {
            getClass().getSimpleName(), s
        });
    }

    protected int getCustomLayoutName()
    {
        return 0x7f0301b6;
    }

    protected List getNameValuePairs(HashMap hashmap)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = hashmap.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)iterator.next();
            String s1 = (String)hashmap.get(s);
            if (Strings.notEmpty(s1))
            {
                arraylist.add(new NameValuePair(s, s1));
            }
        } while (true);
        return arraylist;
    }

    protected WebViewClient getNewWebViewClient()
    {
        return new ECommerceWebViewClient();
    }

    protected String getResUrl()
    {
        String s = (String)order.billingRecord.formParameters.get("resURL");
        if (s != null)
        {
            return s;
        } else
        {
            return "";
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(getCustomLayoutName());
        spinner = new ProgressDialog(this);
        spinner.setInverseBackgroundForced(true);
        spinner.setMessage(LOADING);
        spinner.requestWindowFeature(1);
        setBasicWebViewSettings(paymentWebView);
        paymentWebView.setWebViewClient(getNewWebViewClient());
        setUrlAndLoad();
    }

    public void onDestroy()
    {
        destroyPaymentWebView(paymentWebView);
        paymentWebView = null;
        super.onDestroy();
    }

    public void onStop()
    {
        super.onStop();
        spinner.dismiss();
    }

    protected void setBasicWebViewSettings(WebView webview)
    {
        webview.setVerticalScrollBarEnabled(false);
        webview.setHorizontalScrollBarEnabled(false);
        webview.setInitialScale(1);
        webview = webview.getSettings();
        webview.setLoadWithOverviewMode(true);
        webview.setUseWideViewPort(true);
        webview.setSupportZoom(true);
        webview.setBuiltInZoomControls(true);
        webview.setJavaScriptEnabled(true);
    }

    protected void setCookies(String s)
    {
    }

    protected void setResUrl()
    {
    }

    protected void setUrlAndLoad()
    {
        String s = order.billingRecord.formUrl;
        Object obj = order.billingRecord.formParameters;
        setResUrl();
        nameValuePairs = getNameValuePairs(((HashMap) (obj)));
        obj = HttpUtil.urlEncode(nameValuePairs);
        setCookies(s);
        paymentWebView.postUrl(s, HttpUtil.convertToBytes(((String) (obj))));
    }
}
