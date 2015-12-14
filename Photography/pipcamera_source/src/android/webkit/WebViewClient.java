// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.webkit;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;

// Referenced classes of package android.webkit:
//            HttpAuthHandler, SslErrorHandler, WebView

public class WebViewClient
{

    public WebViewClient()
    {
    }

    public void doUpdateVisitedHistory(WebView webview, String s, boolean flag)
    {
    }

    public void onFormResubmission(WebView webview, Message message, Message message1)
    {
        message.sendToTarget();
    }

    public void onLoadResource(WebView webview, String s)
    {
    }

    public void onPageFinished(WebView webview, String s)
    {
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
    }

    public void onReceivedHttpAuthRequest(WebView webview, HttpAuthHandler httpauthhandler, String s, String s1)
    {
        httpauthhandler.cancel();
    }

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        sslerrorhandler.cancel();
    }

    public void onScaleChanged(WebView webview, float f, float f1)
    {
    }

    public void onTooManyRedirects(WebView webview, Message message, Message message1)
    {
        message.sendToTarget();
    }

    public void onUnhandledKeyEvent(WebView webview, KeyEvent keyevent)
    {
    }

    public boolean shouldOverrideKeyEvent(WebView webview, KeyEvent keyevent)
    {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return false;
    }
}
