// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.widget.Toast;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.message
    implements Runnable
{

    final SupersonicWebView this$0;
    final String val$message;
    final String val$methodName;

    public void run()
    {
        if (getDebugMode() == com.supersonicads.sdk.data.ODE_3.etValue())
        {
            Toast.makeText(SupersonicWebView.access$1500(SupersonicWebView.this), (new StringBuilder()).append(val$methodName).append(" : ").append(val$message).toString(), 1).show();
        }
    }

    ()
    {
        this$0 = final_supersonicwebview;
        val$methodName = s;
        val$message = String.this;
        super();
    }
}
