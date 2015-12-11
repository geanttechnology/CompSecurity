// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.mash;

import android.text.TextUtils;
import android.webkit.WebView;

public class MASHCallbackExecutor
{

    public static final String JS_FAIL_CALLBACK = "javascript:mashCallbackMgt.callbackError";
    public static final String JS_SUCCESS_CALLBACK = "javascript:mashCallbackMgt.callbackSuccess";
    public static final int MASH_API_ERROR_NOT_SUPPORTED = 1003;

    public MASHCallbackExecutor()
    {
    }

    public static void execFailCallback(WebView webview, String s, int i)
    {
        String s1 = (new StringBuilder()).append("{message:{code:").append(i).append("}, keepCallback:false}").toString();
        webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackError(").append(s).append(",").append(s1).append(");").toString());
    }

    public static void execFailCallback(WebView webview, String s, String s1, boolean flag)
    {
        if (TextUtils.isEmpty(s1))
        {
            s1 = (new StringBuilder()).append("{keepCallback:").append(flag).append("}").toString();
        } else
        {
            s1 = (new StringBuilder()).append("{message:\"").append(s1).append("\",keepCallback:").append(flag).append("}").toString();
        }
        webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackError(").append(s).append(",").append(s1).append(");").toString());
    }

    public static void execSuccessCallback(WebView webview, String s, String s1, boolean flag)
    {
        if (TextUtils.isEmpty(s1))
        {
            s1 = (new StringBuilder()).append("{keepCallback:").append(flag).append("}").toString();
        } else
        {
            s1 = (new StringBuilder()).append("{message:").append(s1).append(",keepCallback:").append(flag).append("}").toString();
        }
        webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackSuccess(").append(s).append(",").append(s1).append(");").toString());
    }
}
