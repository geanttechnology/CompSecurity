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

class val.result
    implements android.content.ckListener
{

    final val.result this$1;
    final JsResult val$result;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$result.cancel();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$result = JsResult.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/ExternalPurchase$1

/* anonymous class */
    class ExternalPurchase._cls1 extends WebChromeClient
    {

        final ExternalPurchase this$0;

        public boolean onJsConfirm(WebView webview, String s, String s1, final JsResult result)
        {
            ExternalPurchase.access$002(ExternalPurchase.this, (new com.groupon.util.GrouponAlertDialog.Builder(ExternalPurchase.this)).setTitle(s).setMessage(s1).setPositiveButton(0x104000a, new ExternalPurchase._cls1._cls2()).setNegativeButton(0x1040000, result. new ExternalPurchase._cls1._cls1()).create());
            ExternalPurchase.access$000(ExternalPurchase.this).setOnDismissListener(new ExternalPurchase._cls1._cls3());
            ExternalPurchase.access$000(ExternalPurchase.this).show();
            return true;
        }

            
            {
                this$0 = ExternalPurchase.this;
                super();
            }

        // Unreferenced inner class com/groupon/activity/ExternalPurchase$1$2

/* anonymous class */
        class ExternalPurchase._cls1._cls2
            implements android.content.DialogInterface.OnClickListener
        {

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
        }


        // Unreferenced inner class com/groupon/activity/ExternalPurchase$1$3

/* anonymous class */
        class ExternalPurchase._cls1._cls3
            implements android.content.DialogInterface.OnDismissListener
        {

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
        }

    }

}
