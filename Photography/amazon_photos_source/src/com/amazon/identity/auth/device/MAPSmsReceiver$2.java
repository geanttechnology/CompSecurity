// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device;

import android.webkit.WebView;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.identity.auth.device:
//            MAPSmsReceiver

class val.url
    implements Runnable
{

    final MAPSmsReceiver this$0;
    final String val$url;

    public void run()
    {
        if (MAPSmsReceiver.access$300(MAPSmsReceiver.this).get())
        {
            MAPLog.i(MAPSmsReceiver.access$000(), "Start loading phone verification url from SMS");
            MAPSmsReceiver.access$402(MAPSmsReceiver.this, Boolean.valueOf(true));
            MAPSmsReceiver.access$500(MAPSmsReceiver.this).loadUrl(val$url);
        }
    }

    ()
    {
        this$0 = final_mapsmsreceiver;
        val$url = String.this;
        super();
    }
}
