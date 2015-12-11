// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.mybby;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cm;
import io;
import nb;

// Referenced classes of package com.bestbuy.android.activities.mybby:
//            CIALoginFragment

class a extends WebViewClient
{

    final CIALoginFragment a;

    public void onFormResubmission(WebView webview, Message message, Message message1)
    {
        message1.sendToTarget();
    }

    public void onPageFinished(WebView webview, String s)
    {
        if (a.isAdded() && s.contains("bestbuy.com/cart"))
        {
            CIALoginFragment.b(a).updateCartCount(s);
        }
        if (a.isAdded() && s.contains(a.getString(0x7f08012d)))
        {
            CIALoginFragment.b(a).executeMainCSS();
        }
        if (a.isAdded() && s.contains("tokenInfo?authenticationDataToken="))
        {
            webview.loadUrl("javascript:window.CIAJavaScriptInterface.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
            return;
        }
        if (a.isAdded() && s.contains("bestbuy.com/cart"))
        {
            CIALoginFragment.a(a).setVisibility(0);
            return;
        } else
        {
            CIALoginFragment.a(a).setVisibility(8);
            return;
        }
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        CIALoginFragment.a(a).setVisibility(0);
        if (s.equals("http://www.bestbuy.com/"))
        {
            if (!a.f.F())
            {
                CIALoginFragment.a(a, CIALoginFragment.b(a).a(".bestbuy.com", "ut"));
                if (CIALoginFragment.c(a) != null && !CIALoginFragment.c(a).isEmpty())
                {
                    CIALoginFragment.b(a, CIALoginFragment.b(a).a("https://www-ssl.bestbuy.com", "at"));
                }
            }
            if (CIALoginFragment.d(a) != null && !CIALoginFragment.d(a).isEmpty())
            {
                a.f.d(true);
                (new io(a.d, a, CIALoginFragment.a(a), CIALoginFragment.c(a), CIALoginFragment.d(a))).executeOnExecutor(nb.h, new Void[0]);
            }
        }
        if (s.contains(a.d.getString(0x7f08016c)) || s.contains(a.d.getString(0x7f080288)) || s.contains(a.d.getString(0x7f08012d)) || s.contains(a.d.getString(0x7f080179)) || s.contains(a.d.getString(0x7f0800b7)) || s.contains(a.d.getString(0x7f08035e)) || s.contains(a.d.getString(0x7f080295)) || s.contains(a.d.getString(0x7f080316)) || s.contains(a.d.getString(0x7f080202)) || s.contains(a.d.getString(0x7f080319)) || s.contains(a.d.getString(0x7f0801b9)) || s.contains(a.d.getString(0x7f080355)) || s.contains(a.d.getString(0x7f080257)))
        {
            webview.getSettings().setLoadWithOverviewMode(true);
            webview.getSettings().setUseWideViewPort(true);
            webview.getSettings().setBuiltInZoomControls(true);
            webview.getSettings().setSupportZoom(true);
            webview.setInitialScale(50);
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        if (i == -6 || i == -2 || i == -7)
        {
            CIALoginFragment.a(a).setVisibility(8);
        }
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.proceed();
    }

    (CIALoginFragment cialoginfragment)
    {
        a = cialoginfragment;
        super();
    }
}
