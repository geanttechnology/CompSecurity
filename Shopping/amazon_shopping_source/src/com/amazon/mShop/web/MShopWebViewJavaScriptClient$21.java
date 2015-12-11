// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.callbackId
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$callbackId;

    public void run()
    {
        ((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this)).authenticateUser(new com.amazon.mShop.model.auth.UserSubscriber.Callback() {

            final MShopWebViewJavaScriptClient._cls21 this$1;

            public void userCancelledSignIn()
            {
                MShopWebViewJavaScriptClient.MASHcallback.execFailCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, "CANCELED", false);
            }

            public void userSuccessfullySignedIn()
            {
                MShopWebViewJavaScriptClient.MASHcallback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, null, false);
            }

            
            {
                this$1 = MShopWebViewJavaScriptClient._cls21.this;
                super();
            }
        }, null);
    }

    _cls1.this._cls1()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$callbackId = String.this;
        super();
    }
}
