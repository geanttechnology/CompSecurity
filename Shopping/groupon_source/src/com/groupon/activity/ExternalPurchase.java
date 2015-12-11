// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.CookieManager;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.groupon.service.LoginService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class ExternalPurchase extends ECommercePurchase
{
    public class ExternalPurchaseWebViewClient extends WebViewClient
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
                    result = getResult(webview);
                    if (Strings.equals(result, "lock"))
                    {
                        spinner.show();
                    } else
                    if (Strings.equals(result, "unlock"))
                    {
                        spinner.dismiss();
                    } else
                    if (Strings.equals(result, "True"))
                    {
                        setResult(-1);
                        spinner.dismiss();
                        finish();
                    } else
                    if (Strings.equals(result, "False"))
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

        public ExternalPurchaseWebViewClient()
        {
            this$0 = ExternalPurchase.this;
            super();
        }
    }


    private static final String FALSE = "False";
    private static final String GRPRU = "grpru";
    private static final String LOCK = "lock";
    public static final int REQUEST_CODE = 10139;
    private static final String RESULT = "result";
    private static final String TRUE = "True";
    private static final String UNLOCK = "unlock";
    private AlertDialog confirmPaymentDialog;
    String dealId;
    String dealOptionId;
    LoginService loginService;
    private SharedPreferences prefs;
    String quantity;
    private String result;

    public ExternalPurchase()
    {
        result = "";
    }

    private String getResult(URI uri)
    {
        if (uri != null)
        {
            uri = uri.getQuery();
            if (Strings.notEmpty(uri))
            {
                uri = uri.split("&");
            } else
            {
                uri = null;
            }
            if (uri != null)
            {
                int j = uri.length;
                for (int i = 0; i < j; i++)
                {
                    String s = uri[i];
                    if (!Strings.notEmpty(s))
                    {
                        continue;
                    }
                    String as[] = s.split("=");
                    String s1 = as[0];
                    if (as.length == 1 && (Strings.equals(s1, "lock") || Strings.equals(s1, "unlock")))
                    {
                        return s1;
                    }
                    if (as.length == 2 && Strings.equals(s1, "result"))
                    {
                        return as[1];
                    }
                }

            }
        }
        return "";
    }

    protected WebViewClient getNewWebViewClient()
    {
        return new ExternalPurchaseWebViewClient();
    }

    public void onDestroy()
    {
        if (confirmPaymentDialog != null && confirmPaymentDialog.isShowing())
        {
            confirmPaymentDialog.dismiss();
        }
        super.onDestroy();
    }

    protected void setUrlAndLoad()
    {
        String s = String.format("%1$s/mobile_app_payment/deals/%2$s/%3$s/buy/%4$s", new Object[] {
            prefs.getString("base_payment_url_ru", getString(0x7f080500)), dealId, dealOptionId, quantity
        });
        HashMap hashmap = new HashMap(1);
        hashmap.put("Authorization", String.format("OAuth %s", new Object[] {
            loginService.getAccessToken()
        }));
        paymentWebView.getSettings().setDomStorageEnabled(true);
        paymentWebView.setWebChromeClient(new WebChromeClient() {

            final ExternalPurchase this$0;

            public boolean onJsConfirm(WebView webview, String s1, String s2, JsResult jsresult)
            {
                confirmPaymentDialog = (new com.groupon.util.GrouponAlertDialog.Builder(ExternalPurchase.this)).setTitle(s1).setMessage(s2).setPositiveButton(0x104000a, jsresult. new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;
                    final JsResult val$result;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        result.confirm();
                    }

            
            {
                this$1 = final__pcls1;
                result = JsResult.this;
                super();
            }
                }).setNegativeButton(0x1040000, jsresult. new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;
                    final JsResult val$result;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        result.cancel();
                    }

            
            {
                this$1 = final__pcls1;
                result = JsResult.this;
                super();
            }
                }).create();
                confirmPaymentDialog.setOnDismissListener(jsresult. new android.content.DialogInterface.OnDismissListener() {

                    final _cls1 this$1;
                    final JsResult val$result;

                    public void onDismiss(DialogInterface dialoginterface)
                    {
                        result.cancel();
                    }

            
            {
                this$1 = final__pcls1;
                result = JsResult.this;
                super();
            }
                });
                confirmPaymentDialog.show();
                return true;
            }

            
            {
                this$0 = ExternalPurchase.this;
                super();
            }
        });
        CookieManager.getInstance().removeAllCookie();
        paymentWebView.loadUrl(s, hashmap);
    }



/*
    static AlertDialog access$002(ExternalPurchase externalpurchase, AlertDialog alertdialog)
    {
        externalpurchase.confirmPaymentDialog = alertdialog;
        return alertdialog;
    }

*/



/*
    static String access$102(ExternalPurchase externalpurchase, String s)
    {
        externalpurchase.result = s;
        return s;
    }

*/

}
