// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.amazon.android.webkit.AmazonHttpAuthHandler;
import com.amazon.android.webkit.AmazonSslErrorHandler;
import com.amazon.android.webkit.AmazonWebResourceResponse;
import com.amazon.android.webkit.AmazonWebView;
import com.amazon.android.webkit.AmazonWebViewClient;

public class AndroidWebViewClient extends WebViewClient
{

    private final AmazonWebViewClient client;
    private final AmazonWebView webview;

    public AndroidWebViewClient(AmazonWebView amazonwebview, AmazonWebViewClient amazonwebviewclient)
    {
        webview = amazonwebview;
        client = amazonwebviewclient;
    }

    public void doUpdateVisitedHistory(WebView webview1, String s, boolean flag)
    {
        client.doUpdateVisitedHistory(webview, s, flag);
    }

    public void onFormResubmission(WebView webview1, Message message, Message message1)
    {
        client.onFormResubmission(webview, message, message1);
    }

    public void onLoadResource(WebView webview1, String s)
    {
        client.onLoadResource(webview, s);
    }

    public void onPageFinished(WebView webview1, String s)
    {
        client.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview1, String s, Bitmap bitmap)
    {
        client.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview1, int i, String s, String s1)
    {
        client.onReceivedError(webview, i, s, s1);
    }

    public void onReceivedHttpAuthRequest(WebView webview1, final HttpAuthHandler handler, String s, String s1)
    {
        webview1 = new AmazonHttpAuthHandler() {

            final AndroidWebViewClient this$0;
            final HttpAuthHandler val$handler;

            public void cancel()
            {
                handler.cancel();
            }

            public void proceed(String s2, String s3)
            {
                handler.proceed(s2, s3);
            }

            public boolean useHttpAuthUsernamePassword()
            {
                return handler.useHttpAuthUsernamePassword();
            }

            
            {
                this$0 = AndroidWebViewClient.this;
                handler = httpauthhandler;
                super();
            }
        };
        client.onReceivedHttpAuthRequest(webview, webview1, s, s1);
    }

    public void onReceivedSslError(WebView webview1, final SslErrorHandler sslErrorHandler, SslError sslerror)
    {
        webview1 = new AmazonSslErrorHandler() {

            final AndroidWebViewClient this$0;
            final SslErrorHandler val$sslErrorHandler;

            public void cancel()
            {
                sslErrorHandler.cancel();
            }

            public void proceed()
            {
                sslErrorHandler.proceed();
            }

            
            {
                this$0 = AndroidWebViewClient.this;
                sslErrorHandler = sslerrorhandler;
                super();
            }
        };
        client.onReceivedSslError(webview, webview1, sslerror);
    }

    public void onScaleChanged(WebView webview1, float f, float f1)
    {
        client.onScaleChanged(webview, f, f1);
    }

    public void onTooManyRedirects(WebView webview1, Message message, Message message1)
    {
        client.onTooManyRedirects(webview, message, message1);
    }

    public void onUnhandledKeyEvent(WebView webview1, KeyEvent keyevent)
    {
        client.onUnhandledKeyEvent(webview, keyevent);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webview1, String s)
    {
        webview1 = client.shouldInterceptRequest(webview, s);
        if (webview1 == null)
        {
            return null;
        } else
        {
            return new WebResourceResponse(webview1.getMimeType(), webview1.getEncoding(), webview1.getData());
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webview1, KeyEvent keyevent)
    {
        return client.shouldOverrideKeyEvent(webview, keyevent);
    }

    public boolean shouldOverrideUrlLoading(WebView webview1, String s)
    {
        return client.shouldOverrideUrlLoading(webview, s);
    }
}
