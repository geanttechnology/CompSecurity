// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.net.Uri;
import android.webkit.WebView;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer

class val.animationTargetUrl
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$animationTargetUrl;

    public void run()
    {
        WebView webview;
        if (MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this) != null && MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).getWebView() != null)
        {
            webview = MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).getWebView();
        } else
        {
            webview = null;
        }
        if (webview != null && !Util.isEmpty(webview.getUrl()) && Uri.decode(webview.getUrl()).equals(val$animationTargetUrl))
        {
            MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).webviewAnimated();
        }
    }

    ()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$animationTargetUrl = String.this;
        super();
    }
}
