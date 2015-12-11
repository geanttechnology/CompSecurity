// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads.util;

import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.mopub.common.logging.MoPubLog;

public class WebViews
{

    public WebViews()
    {
    }

    public static void onPause(WebView webview, boolean flag)
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
            (new com.mopub.common.util.Reflection.MethodBuilder(webview, "onPause")).setAccessible().execute();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
    }

    public static void onResume(WebView webview)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            webview.onResume();
            return;
        }
        try
        {
            (new com.mopub.common.util.Reflection.MethodBuilder(webview, "onResume")).setAccessible().execute();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
    }

    public static void setDisableJSChromeClient(WebView webview)
    {
        webview.setWebChromeClient(new WebChromeClient() {

            public boolean onJsAlert(WebView webview1, String s, String s1, JsResult jsresult)
            {
                MoPubLog.d(s1);
                jsresult.confirm();
                return true;
            }

            public boolean onJsBeforeUnload(WebView webview1, String s, String s1, JsResult jsresult)
            {
                MoPubLog.d(s1);
                jsresult.confirm();
                return true;
            }

            public boolean onJsConfirm(WebView webview1, String s, String s1, JsResult jsresult)
            {
                MoPubLog.d(s1);
                jsresult.confirm();
                return true;
            }

            public boolean onJsPrompt(WebView webview1, String s, String s1, String s2, JsPromptResult jspromptresult)
            {
                MoPubLog.d(s1);
                jspromptresult.confirm();
                return true;
            }

        });
    }
}
