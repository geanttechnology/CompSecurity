// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.c;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public final class a
{

    public static void a(WebView webview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webview.onResume();
            return;
        }
        try
        {
            webview = new com.mopub.common.d.i.a(webview, "onResume");
            webview.a = true;
            webview.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
    }

    public static void a(WebView webview, boolean flag)
    {
        if (flag)
        {
            webview.stopLoading();
            webview.loadUrl("");
        }
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webview.onPause();
            return;
        }
        try
        {
            webview = new com.mopub.common.d.i.a(webview, "onPause");
            webview.a = true;
            webview.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
    }

    // Unreferenced inner class com/mopub/mobileads/c/a$1

/* anonymous class */
    public static final class _cls1 extends WebChromeClient
    {

        public final boolean onJsAlert(WebView webview, String s, String s1, JsResult jsresult)
        {
            com.mopub.common.c.a.b(s1);
            jsresult.confirm();
            return true;
        }

        public final boolean onJsBeforeUnload(WebView webview, String s, String s1, JsResult jsresult)
        {
            com.mopub.common.c.a.b(s1);
            jsresult.confirm();
            return true;
        }

        public final boolean onJsConfirm(WebView webview, String s, String s1, JsResult jsresult)
        {
            com.mopub.common.c.a.b(s1);
            jsresult.confirm();
            return true;
        }

        public final boolean onJsPrompt(WebView webview, String s, String s1, String s2, JsPromptResult jspromptresult)
        {
            com.mopub.common.c.a.b(s1);
            jspromptresult.confirm();
            return true;
        }

    }

}
