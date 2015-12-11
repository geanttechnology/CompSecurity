// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mShop.web.security.WebViewSecurity;

// Referenced classes of package com.amazon.mShop:
//            AmazonBrandedWebView, AmazonActivity, AmazonProgressDialog

private class <init> extends WebViewClient
{

    final AmazonBrandedWebView this$0;

    public void onPageFinished(WebView webview, String s)
    {
        if (isAttachedToWindow())
        {
            com.amazon.mShop.platform.().invokeLater(new <init>(AmazonBrandedWebView.this, null), 350L);
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        boolean flag = WebViewSecurity.shouldBlockWebViewLoading(webview, s);
        if (WebViewSecurity.isHTTPUrl(s))
        {
            WebViewSecurity.logMetricsForHTTPRequest(webview.getUrl(), s, flag);
        }
        if (flag)
        {
            webview.stopLoading();
            AmazonErrorUtils.reportErrorWithGeneralErrorMessageAndGoToAmazonHome((AmazonActivity)webview.getContext(), 5);
        } else
        if (isAttachedToWindow())
        {
            int _tmp = AmazonBrandedWebView.access$204(AmazonBrandedWebView.this);
            if (!AmazonBrandedWebView.access$300(AmazonBrandedWebView.this).isShowing())
            {
                try
                {
                    AmazonBrandedWebView.access$300(AmazonBrandedWebView.this).show();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (WebView webview)
                {
                    Log.e("ProgressDialog", webview.getMessage());
                }
                return;
            }
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        super.onReceivedError(webview, i, s, s1);
        AmazonBrandedWebView.access$502(AmazonBrandedWebView.this, true);
        s = webview.getContext();
        if (s instanceof AmazonActivity)
        {
            s = (AmazonActivity)s;
            AmazonErrorUtils.reportWebViewClientError(s, webview, s.getCurrentView());
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        if (WebUtils.handleMailtoLink(webview.getContext(), s))
        {
            return true;
        }
        if (WebViewSecurity.shouldBlockWebViewLoading(webview, s))
        {
            AmazonErrorUtils.reportErrorWithGeneralErrorMessageAndGoToAmazonHome((AmazonActivity)webview.getContext(), 5);
            WebViewSecurity.logMetricsForHTTPRequest(webview.getUrl(), s, true);
            return true;
        } else
        {
            return false;
        }
    }

    private ()
    {
        this$0 = AmazonBrandedWebView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
