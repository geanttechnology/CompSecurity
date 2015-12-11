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
//            ao, c, al, af

abstract class ap extends WebViewClient
{
    static abstract class a
    {

        void a()
        {
        }

        void a(String s)
        {
        }

        a()
        {
        }
    }


    a a;
    x.a b;
    boolean c;
    private ExecutorService d;

    ap(a a1, x.a a2)
    {
        d = Executors.newCachedThreadPool();
        a = a1;
        b = a2;
    }

    abstract void a(ao ao1);

    public void onPageFinished(WebView webview, String s)
    {
        ao ao1 = (ao)webview;
        if (!ao1.a(s))
        {
            a.a(s);
            org.json.JSONObject jsonobject = (new c(ao1.getContext())).a(ao1);
            ao1.loadUrl((new StringBuilder("javascript:MMJS.sdk.setAdProperties(")).append(jsonobject).append(");").toString());
            a(ao1);
            (new StringBuilder("onPageFinished webview: ")).append(ao1.toString()).append("url is ").append(s);
            al.b();
        }
        super.onPageFinished(webview, s);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        String.format("onPageStarted: %s", new Object[] {
            s
        });
        al.b();
        a.a();
        ao ao1 = (ao)webview;
        ao1.c = "loading";
        ao1.g = false;
        super.onPageStarted(webview, s, bitmap);
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        al.a("MMWebViewClient", String.format("Error: %s %s %s", new Object[] {
            Integer.valueOf(i), s, s1
        }));
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        ao ao1;
        boolean flag;
        flag = false;
        ao1 = (ao)webview;
        if (ao1.a(s))
        {
            break MISSING_BLOCK_LABEL_189;
        }
        (new StringBuilder("@@@@@@@@@@SHOULDOVERRIDELOADING@@@@@@@@@@@@@ Url is ")).append(s).append(" for ").append(webview);
        al.a();
        if (!s.substring(0, 6).equalsIgnoreCase("mmsdk:")) goto _L2; else goto _L1
_L1:
        al.a();
        webview = new af((ao)webview, s);
        if (((af) (webview)).a != null)
        {
            flag = "resize".equals(((af) (webview)).a);
        } else
        {
            flag = false;
        }
        c = flag;
        d.execute(webview);
        flag = true;
_L4:
        return flag;
_L2:
        if (b.a()) goto _L4; else goto _L3
_L3:
        b.a = s;
        b.b = new WeakReference(webview.getContext());
        b.e = ao1.a;
        webview = b;
        if (webview != null && ((x.a) (webview)).a != null && ((x.a) (webview)).b != null)
        {
            au.c.a(new x._cls1(new WeakReference(webview)));
        }
        return true;
    }
}
