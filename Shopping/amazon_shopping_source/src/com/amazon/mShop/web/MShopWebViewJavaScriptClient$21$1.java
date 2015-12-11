// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class this._cls1
    implements com.amazon.mShop.model.auth.ackId
{

    final l.callbackId this$1;

    public void userCancelledSignIn()
    {
        allback.execFailCallback(MShopWebViewJavaScriptClient.access$200(_fld0), callbackId, "CANCELED", false);
    }

    public void userSuccessfullySignedIn()
    {
        allback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(_fld0), callbackId, null, false);
    }

    l.callbackId()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/web/MShopWebViewJavaScriptClient$21

/* anonymous class */
    class MShopWebViewJavaScriptClient._cls21
        implements Runnable
    {

        final MShopWebViewJavaScriptClient this$0;
        final String val$callbackId;

        public void run()
        {
            ((AmazonActivity)MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this)).authenticateUser(new MShopWebViewJavaScriptClient._cls21._cls1(), null);
        }

            
            {
                this$0 = final_mshopwebviewjavascriptclient;
                callbackId = String.this;
                super();
            }
    }

}
