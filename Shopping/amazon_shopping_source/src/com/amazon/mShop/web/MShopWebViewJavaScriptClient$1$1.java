// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.Html;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebViewJavaScriptClient

class this._cls1
    implements android.content.._cls1._cls1
{

    final l.callbackId this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        callback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(_fld0), callbackId, String.valueOf(i), false);
    }

    l.cancelButtonTitle()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/web/MShopWebViewJavaScriptClient$1

/* anonymous class */
    class MShopWebViewJavaScriptClient._cls1
        implements Runnable
    {

        final MShopWebViewJavaScriptClient this$0;
        final String val$buttonTitles[];
        final String val$callbackId;
        final String val$cancelButtonTitle;
        final String val$title;

        public void run()
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this));
            if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, title))
            {
                builder.setTitle(title);
            }
            if (!Util.isEmpty(buttonTitles))
            {
                String as[] = new String[buttonTitles.length];
                for (int i = 0; i < buttonTitles.length; i++)
                {
                    as[i] = Html.fromHtml(buttonTitles[i]).toString();
                }

                builder.setItems(as, new MShopWebViewJavaScriptClient._cls1._cls1());
            }
            if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, cancelButtonTitle))
            {
                final int buttonsLength;
                if (buttonTitles != null)
                {
                    buttonsLength = buttonTitles.length;
                } else
                {
                    buttonsLength = 0;
                }
                builder.setNegativeButton(cancelButtonTitle, new MShopWebViewJavaScriptClient._cls1._cls2());
            }
            builder.setIcon(0);
            builder.create().show();
        }

            
            {
                this$0 = final_mshopwebviewjavascriptclient;
                title = s;
                buttonTitles = as;
                callbackId = s1;
                cancelButtonTitle = String.this;
                super();
            }

        // Unreferenced inner class com/amazon/mShop/web/MShopWebViewJavaScriptClient$1$2

/* anonymous class */
        class MShopWebViewJavaScriptClient._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final MShopWebViewJavaScriptClient._cls1 this$1;
            final int val$buttonsLength;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                MShopWebViewJavaScriptClient.MASHcallback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, String.valueOf(buttonsLength), false);
            }

                    
                    {
                        this$1 = MShopWebViewJavaScriptClient._cls1.this;
                        buttonsLength = i;
                        super();
                    }
        }

    }

}
