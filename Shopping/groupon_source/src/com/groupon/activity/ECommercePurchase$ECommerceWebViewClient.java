// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class this._cls0 extends WebViewClient
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

    public ()
    {
        this$0 = ECommercePurchase.this;
        super();
    }
}
