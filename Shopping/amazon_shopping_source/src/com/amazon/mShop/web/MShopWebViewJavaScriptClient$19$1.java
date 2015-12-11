// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer

class this._cls1
    implements android.content._cls19._cls1
{

    final l.callbackId this$1;

    public void onCancel(DialogInterface dialoginterface)
    {
        if (MShopWebViewJavaScriptClient.access$100(_fld0, callbackId))
        {
            allback.execFailCallback(MShopWebViewJavaScriptClient.access$200(_fld0), callbackId, null, false);
        }
    }

    l.dialogTitle()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/web/MShopWebViewJavaScriptClient$19

/* anonymous class */
    class MShopWebViewJavaScriptClient._cls19
        implements Runnable
    {

        final MShopWebViewJavaScriptClient this$0;
        final String val$callbackId;
        final String val$dialogTitle;

        public void run()
        {
            MShopWebViewJavaScriptClient._cls19._cls1 _lcls1 = new MShopWebViewJavaScriptClient._cls19._cls1();
            MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).showAmazonProgressDialog(dialogTitle, _lcls1);
        }

            
            {
                this$0 = final_mshopwebviewjavascriptclient;
                callbackId = s;
                dialogTitle = String.this;
                super();
            }
    }

}
