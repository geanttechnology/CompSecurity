// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.app.AlertDialog;
import android.webkit.JsResult;

// Referenced classes of package com.video.adsdk.internal:
//            ADActivity

class val.result
    implements Runnable
{

    final ADActivity this$0;
    final String val$message;
    final JsResult val$result;

    public void run()
    {
    /* block-local class not found */
    class _cls1 {}

        (new android.app.uilder(ADActivity.this)).setTitle("javaScript dialog").setMessage(val$message).setPositiveButton(0x104000a, new _cls1()).setCancelable(false).create().show();
    }

    _cls1()
    {
        this$0 = final_adactivity;
        val$message = s;
        val$result = JsResult.this;
        super();
    }
}
