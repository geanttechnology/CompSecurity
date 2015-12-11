// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.content.DialogInterface;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient, MShopWebViewContainer

class val.dialogTitle
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$callbackId;
    final String val$dialogTitle;

    public void run()
    {
        android.content.  = new android.content.DialogInterface.OnCancelListener() {

            final MShopWebViewJavaScriptClient._cls19 this$1;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (MShopWebViewJavaScriptClient.access$100(this$0, callbackId))
                {
                    MShopWebViewJavaScriptClient.MASHcallback.execFailCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, null, false);
                }
            }

            
            {
                this$1 = MShopWebViewJavaScriptClient._cls19.this;
                super();
            }
        };
        MShopWebViewJavaScriptClient.access$400(MShopWebViewJavaScriptClient.this).showAmazonProgressDialog(val$dialogTitle, );
    }

    _cls1.this._cls1()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$callbackId = s;
        val$dialogTitle = String.this;
        super();
    }
}
