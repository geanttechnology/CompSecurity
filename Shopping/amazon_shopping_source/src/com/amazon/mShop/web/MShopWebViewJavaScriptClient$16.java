// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.net.Uri;
import com.amazon.mShop.util.WebUtils;
import com.amazon.mShop.web.security.WebViewSecurity;
import com.amazon.mobile.mash.nav.MASHNavDelegate;
import com.amazon.mobile.mash.util.MASHUtil;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer, MShopWebView

class val.callbackId
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$callbackId;
    final String val$transitionEffect;
    final String val$url;

    public void run()
    {
        boolean flag;
        boolean flag1 = true;
        flag = flag1;
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$transitionEffect))
        {
            flag = flag1;
            if ("none".equals(val$transitionEffect))
            {
                flag = false;
            }
        }
        if (!MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$url)) goto _L2; else goto _L1
_L1:
        String s;
        Uri uri;
        s = MASHUtil.canonicalizeIfRelativeUrl(val$url, MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this));
        uri = Uri.parse(s);
        if (MShopWebViewJavaScriptClient.access$500(MShopWebViewJavaScriptClient.this).navigate(s, MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this))) goto _L4; else goto _L3
_L3:
        boolean flag2 = WebViewSecurity.shouldBlockWebViewLoading(MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this), s);
        if (!flag2) goto _L6; else goto _L5
_L5:
        MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).showSslError(5);
        WebViewSecurity.logMetricsForHTTPRequest(MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this).getUrl(), s, flag2);
_L11:
        return;
_L6:
        if (flag && MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).getTransitionManager() != null)
        {
            MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).navigateForward(null);
        }
        MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this).loadUrl(s);
_L9:
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$callbackId))
        {
            Hcallback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(MShopWebViewJavaScriptClient.this), val$callbackId, null, false);
            return;
        }
          goto _L7
_L4:
        WebUtils.logRefMarkerForWebPage(uri);
        return;
_L2:
        if (flag && MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).getTransitionManager() != null)
        {
            MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).navigateForward(null);
        }
        if (true) goto _L9; else goto _L8
_L8:
_L7:
        if (true) goto _L11; else goto _L10
_L10:
    }

    Hcallback()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$transitionEffect = s;
        val$url = s1;
        val$callbackId = String.this;
        super();
    }
}
