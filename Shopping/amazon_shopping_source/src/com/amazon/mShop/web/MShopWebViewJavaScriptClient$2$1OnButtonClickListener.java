// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.app.AlertDialog;
import android.content.DialogInterface;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class mButtonIndex
    implements android.content.ener
{

    private int mButtonIndex;
    final mButtonIndex this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        allback(MShopWebViewJavaScriptClient.access$200(allback), allback, String.valueOf(mButtonIndex), false);
    }

    (int i)
    {
        this$1 = this._cls1.this;
        super();
        mButtonIndex = i;
    }

    // Unreferenced inner class com/amazon/mShop/web/MShopWebViewJavaScriptClient$2

/* anonymous class */
    class MShopWebViewJavaScriptClient._cls2
        implements Runnable
    {

        final MShopWebViewJavaScriptClient this$0;
        final String val$buttonTitles[];
        final String val$callbackId;
        final String val$cancelButtonTitle;
        final String val$message;
        final String val$title;

        public void run()
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this));
            if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, title))
            {
                builder.setTitle(title);
            }
            if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, message))
            {
                builder.setMessage(message);
            }
            if (!Util.isEmpty(buttonTitles) && buttonTitles.length >= 1)
            {
                builder.setPositiveButton(buttonTitles[0], new MShopWebViewJavaScriptClient._cls2._cls1OnButtonClickListener(0));
                if (buttonTitles.length >= 2)
                {
                    builder.setNeutralButton(buttonTitles[1], new MShopWebViewJavaScriptClient._cls2._cls1OnButtonClickListener(1));
                }
            }
            if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, cancelButtonTitle))
            {
                int i;
                if (buttonTitles != null)
                {
                    i = buttonTitles.length;
                } else
                {
                    i = 0;
                }
                builder.setNegativeButton(cancelButtonTitle, new MShopWebViewJavaScriptClient._cls2._cls1OnButtonClickListener(i));
            }
            builder.setIcon(0);
            builder.create().show();
        }

            
            {
                this$0 = final_mshopwebviewjavascriptclient;
                title = s;
                message = s1;
                callbackId = s2;
                buttonTitles = as;
                cancelButtonTitle = String.this;
                super();
            }
    }

}
