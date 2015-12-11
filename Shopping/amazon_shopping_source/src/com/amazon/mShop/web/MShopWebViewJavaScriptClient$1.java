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

class val.cancelButtonTitle
    implements Runnable
{

    final MShopWebViewJavaScriptClient this$0;
    final String val$buttonTitles[];
    final String val$callbackId;
    final String val$cancelButtonTitle;
    final String val$title;

    public void run()
    {
        android.app.Client client = new android.app.ener(MShopWebViewJavaScriptClient.access$000(MShopWebViewJavaScriptClient.this));
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$title))
        {
            client.title(val$title);
        }
        if (!Util.isEmpty(val$buttonTitles))
        {
            String as[] = new String[val$buttonTitles.length];
            for (int i = 0; i < val$buttonTitles.length; i++)
            {
                as[i] = Html.fromHtml(val$buttonTitles[i]).toString();
            }

            client.buttonTitles(as, new android.content.DialogInterface.OnClickListener() {

                final MShopWebViewJavaScriptClient._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    MShopWebViewJavaScriptClient.MASHcallback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, String.valueOf(j), false);
                }

            
            {
                this$1 = MShopWebViewJavaScriptClient._cls1.this;
                super();
            }
            });
        }
        if (MShopWebViewJavaScriptClient.access$100(MShopWebViewJavaScriptClient.this, val$cancelButtonTitle))
        {
            final int buttonsLength;
            if (val$buttonTitles != null)
            {
                buttonsLength = val$buttonTitles.length;
            } else
            {
                buttonsLength = 0;
            }
            client.Button(val$cancelButtonTitle, new android.content.DialogInterface.OnClickListener() {

                final MShopWebViewJavaScriptClient._cls1 this$1;
                final int val$buttonsLength;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    MShopWebViewJavaScriptClient.MASHcallback.execSuccessCallback(MShopWebViewJavaScriptClient.access$200(this$0), callbackId, String.valueOf(buttonsLength), false);
                }

            
            {
                this$1 = MShopWebViewJavaScriptClient._cls1.this;
                buttonsLength = i;
                super();
            }
            });
        }
        client._mth1(0);
        client._mth1().show();
    }

    _cls2.val.buttonsLength()
    {
        this$0 = final_mshopwebviewjavascriptclient;
        val$title = s;
        val$buttonTitles = as;
        val$callbackId = s1;
        val$cancelButtonTitle = String.this;
        super();
    }
}
