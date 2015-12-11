// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class val.cancelButtonTitle
    implements Runnable
{
    class _cls1OnButtonClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        private int mButtonIndex;
        final MShopWebViewJavaScriptClient._cls2 this$1;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            MShopWebViewJavaScriptClient.MASHcallback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, String.valueOf(mButtonIndex), false);
        }

        _cls1OnButtonClickListener(int i)
        {
            this$1 = MShopWebViewJavaScriptClient._cls2.this;
            super();
            mButtonIndex = i;
        }
    }


    final MShopWebViewJavaScriptClient this$0;
    final String val$buttonTitles[];
    final String val$callbackId;
    final String val$cancelButtonTitle;
    final String val$message;
    final String val$title;

    public void run()
    {
        android.app.Client client = new android.app.ener(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this));
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$title))
        {
            client.title(val$title);
        }
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$message))
        {
            client.message(val$message);
        }
        if (!Util.isEmpty(val$buttonTitles) && val$buttonTitles.length >= 1)
        {
            client.Button(val$buttonTitles[0], new _cls1OnButtonClickListener(0));
            if (val$buttonTitles.length >= 2)
            {
                client.utton(val$buttonTitles[1], new _cls1OnButtonClickListener(1));
            }
        }
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$cancelButtonTitle))
        {
            int i;
            if (val$buttonTitles != null)
            {
                i = val$buttonTitles.length;
            } else
            {
                i = 0;
            }
            client.Button(val$cancelButtonTitle, new _cls1OnButtonClickListener(i));
        }
        client._mth2(0);
        client._mth2().show();
    }

    _cls1OnButtonClickListener.mButtonIndex()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$title = s;
        val$message = s1;
        val$callbackId = s2;
        val$buttonTitles = as;
        val$cancelButtonTitle = String.this;
        super();
    }
}
