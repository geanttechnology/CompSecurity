// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.webkit.WebView;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

public static class 
{

    public static void execFailCallback(WebView webview, String s, int i)
    {
        String s1 = (new StringBuilder()).append("{message:{code:").append(i).append("}, keepCallback:false}").toString();
        webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackError(").append(s).append(",").append(s1).append(");").toString());
    }

    public static void execFailCallback(WebView webview, String s, String s1, boolean flag)
    {
        if (Util.isEmpty(s1))
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
        if (Util.isEmpty(s1))
        {
            s1 = (new StringBuilder()).append("{keepCallback:").append(flag).append("}").toString();
        } else
        {
            s1 = (new StringBuilder()).append("{message:").append(s1).append(",keepCallback:").append(flag).append("}").toString();
        }
        webview.loadUrl((new StringBuilder()).append("javascript:mashCallbackMgt.callbackSuccess(").append(s).append(",").append(s1).append(");").toString());
    }

    public ()
    {
    }
}
