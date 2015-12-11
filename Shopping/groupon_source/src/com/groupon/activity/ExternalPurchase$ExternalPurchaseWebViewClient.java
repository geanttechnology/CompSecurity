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
import java.net.URI;
import java.net.URISyntaxException;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ExternalPurchase

public class this._cls0 extends WebViewClient
{

    final ExternalPurchase this$0;

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

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        boolean flag1;
        flag1 = false;
        doShouldOverrideUrlLoadingLogging(s);
        webview = null;
        s = new URI(s);
        webview = s;
_L1:
        boolean flag = flag1;
        if (webview != null)
        {
            flag = flag1;
            if (Strings.equals(webview.getScheme().toLowerCase(), "grpru"))
            {
                ExternalPurchase.access$102(ExternalPurchase.this, ExternalPurchase.access$200(ExternalPurchase.this, webview));
                if (Strings.equals(ExternalPurchase.access$100(ExternalPurchase.this), "lock"))
                {
                    spinner.show();
                } else
                if (Strings.equals(ExternalPurchase.access$100(ExternalPurchase.this), "unlock"))
                {
                    spinner.dismiss();
                } else
                if (Strings.equals(ExternalPurchase.access$100(ExternalPurchase.this), "True"))
                {
                    setResult(-1);
                    spinner.dismiss();
                    finish();
                } else
                if (Strings.equals(ExternalPurchase.access$100(ExternalPurchase.this), "False"))
                {
                    setResult(0, getIntent().putExtra("payment_res", "result=False"));
                    spinner.dismiss();
                    finish();
                }
                flag = true;
            }
        }
        return flag;
        s;
        Ln.e(s);
          goto _L1
    }

    public I()
    {
        this$0 = ExternalPurchase.this;
        super();
    }
}
