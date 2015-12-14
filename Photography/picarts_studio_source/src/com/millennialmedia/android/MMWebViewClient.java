// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.millennialmedia.android:
//            MMWebView, AdProperties, MMLog, MMCommand, 
//            HttpRedirection

abstract class MMWebViewClient extends WebViewClient
{

    private MMWebViewClientListener a;
    private HttpRedirection.RedirectionListenerImpl b;
    private ExecutorService c;

    MMWebViewClient(MMWebViewClientListener mmwebviewclientlistener, HttpRedirection.RedirectionListenerImpl redirectionlistenerimpl)
    {
        c = Executors.newCachedThreadPool();
        a = mmwebviewclientlistener;
        b = redirectionlistenerimpl;
    }

    abstract void a(MMWebView mmwebview);

    public void onPageFinished(WebView webview, String s)
    {
        MMWebView mmwebview = (MMWebView)webview;
        if (!mmwebview.a(s))
        {
            a.onPageFinished(s);
            org.json.JSONObject jsonobject = (new AdProperties(mmwebview.getContext())).getAdProperties(mmwebview);
            mmwebview.loadUrl((new StringBuilder("javascript:MMJS.sdk.setAdProperties(")).append(jsonobject).append(");").toString());
            a(mmwebview);
            MMLog.b("MMWebViewClient", (new StringBuilder("onPageFinished webview: ")).append(mmwebview.toString()).append("url is ").append(s).toString());
        }
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        MMLog.b("MMWebViewClient", String.format("onPageStarted: %s", new Object[] {
            s
        }));
        a.a();
        MMWebView mmwebview = (MMWebView)webview;
        mmwebview.c = "loading";
        mmwebview.e = false;
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        MMLog.e("MMWebViewClient", String.format("Error: %s %s %s", new Object[] {
            Integer.valueOf(i), s, s1
        }));
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        MMWebView mmwebview = (MMWebView)webview;
        if (!mmwebview.a(s))
        {
            MMLog.a("MMWebViewClient", (new StringBuilder("@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is ")).append(s).append(" for ").append(webview).toString());
            if (s.substring(0, 6).equalsIgnoreCase("mmsdk:"))
            {
                MMLog.a("MMWebViewClient", (new StringBuilder("Running JS bridge command: ")).append(s).toString());
                webview = new MMCommand((MMWebView)webview, s);
                if (((MMCommand) (webview)).a != null)
                {
                    "resize".equals(((MMCommand) (webview)).a);
                }
                c.execute(webview);
                return true;
            }
            if (b.isExpandingToUrl())
            {
                return false;
            }
            b.a = s;
            b.b = new WeakReference(webview.getContext());
            b.e = mmwebview.a;
            HttpRedirection.a(b);
        }
        return true;
    }

    private class MMWebViewClientListener
    {

        void a()
        {
        }

        void onPageFinished(String s)
        {
        }

        MMWebViewClientListener()
        {
        }
    }

}
