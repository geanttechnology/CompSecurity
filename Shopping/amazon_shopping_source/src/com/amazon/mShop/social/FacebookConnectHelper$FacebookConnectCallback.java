// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.social;

import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.web.MShopWebView;

// Referenced classes of package com.amazon.mShop.social:
//            FacebookConnectHelper

public class jsFailureCallback
{

    private String jsFailureCallback;
    private String jsSuccessCallback;
    final FacebookConnectHelper this$0;
    private MShopWebView webView;

    private void callBackWebView(final String callbackUrl)
    {
        com.amazon.mShop.platform.FailureCallback().invokeLater(new Runnable() {

            final FacebookConnectHelper.FacebookConnectCallback this$1;
            final String val$callbackUrl;

            public void run()
            {
                webView.loadUrl(callbackUrl);
            }

            
            {
                this$1 = FacebookConnectHelper.FacebookConnectCallback.this;
                callbackUrl = s;
                super();
            }
        });
    }

    public void executeFailureCallback(String s)
    {
        callBackWebView((new StringBuilder()).append(jsFailureCallback).append("('").append(s).append("')").toString());
    }

    public void executeSuccessCallback(String s)
    {
        callBackWebView((new StringBuilder()).append(jsSuccessCallback).append("('").append(s).append("')").toString());
    }


    public _cls1.val.callbackUrl(MShopWebView mshopwebview, String s, String s1)
    {
        this$0 = FacebookConnectHelper.this;
        super();
        webView = mshopwebview;
        jsSuccessCallback = (new StringBuilder()).append("javascript:").append(s).toString();
        jsFailureCallback = (new StringBuilder()).append("javascript:").append(s1).toString();
    }
}
