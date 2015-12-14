// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.Context;
import android.webkit.WebView;

public class FotoAdJSStrategyExcuter
{

    private FotoAdJSStrategyExcuterCallback callback;
    private WebView webView;

    public FotoAdJSStrategyExcuter()
    {
    }

    public void excuteStrategyJavaScript(Context context, String s, String s1, String s2, FotoAdJSStrategyExcuterCallback fotoadjsstrategyexcutercallback)
    {
        try
        {
            callback = fotoadjsstrategyexcutercallback;
            webView = new WebView(context);
            context = String.format(s, new Object[] {
                s1, s2
            });
            webView.addJavascriptInterface(this, "android");
            webView.loadUrl((new StringBuilder()).append("javascript:android.onData(").append(context).append(" )").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        finally
        {
            throw context;
        }
    }

    public void onData(String s)
    {
        if (callback != null)
        {
            callback.onReturned(s);
        }
    }

    private class FotoAdJSStrategyExcuterCallback
    {

        public abstract void onReturned(String s);
    }

}
