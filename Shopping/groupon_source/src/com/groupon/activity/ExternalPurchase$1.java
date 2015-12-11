// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.groupon.activity:
//            ExternalPurchase

class this._cls0 extends WebChromeClient
{

    final ExternalPurchase this$0;

    public boolean onJsConfirm(WebView webview, String s, String s1, final JsResult result)
    {
        ExternalPurchase.access$002(ExternalPurchase.this, (new com.groupon.util.Builder(ExternalPurchase.this)).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new android.content.DialogInterface.OnClickListener() {

            final ExternalPurchase._cls1 this$1;
            final JsResult val$result;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                result.confirm();
            }

            
            {
                this$1 = ExternalPurchase._cls1.this;
                result = jsresult;
                super();
            }
        }).setNegativeButton(0x1040000, new android.content.DialogInterface.OnClickListener() {

            final ExternalPurchase._cls1 this$1;
            final JsResult val$result;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                result.cancel();
            }

            
            {
                this$1 = ExternalPurchase._cls1.this;
                result = jsresult;
                super();
            }
        }).create());
        ExternalPurchase.access$000(ExternalPurchase.this).setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

            final ExternalPurchase._cls1 this$1;
            final JsResult val$result;

            public void onDismiss(DialogInterface dialoginterface)
            {
                result.cancel();
            }

            
            {
                this$1 = ExternalPurchase._cls1.this;
                result = jsresult;
                super();
            }
        });
        ExternalPurchase.access$000(ExternalPurchase.this).show();
        return true;
    }

    _cls3.val.result()
    {
        this$0 = ExternalPurchase.this;
        super();
    }
}
