// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.webkit.WebView;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient

class this._cls0 extends Handler
{

    final SPBrandEngageClient this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR lookupswitch 2: default 32
    //                   123: 40
    //                   522: 95;
           goto _L1 _L2 _L3
_L1:
        SponsorPayLogger.e("SPBrandEngageClient", "Unknow message what field");
_L5:
        return;
_L2:
        if (SPBrandEngageClient.access$4(SPBrandEngageClient.this) == null) goto _L5; else goto _L4
_L4:
        message = message.obj.toString();
        SPBrandEngageClient.access$4(SPBrandEngageClient.this).loadUrl(message);
        if (!message.equals("about:blank")) goto _L5; else goto _L6
_L6:
        SPBrandEngageClient.access$5(SPBrandEngageClient.this, null);
        SPBrandEngageClient.access$6(SPBrandEngageClient.this, null);
        return;
_L3:
        SPBrandEngageClient.access$7(SPBrandEngageClient.this);
        return;
    }

    (Looper looper)
    {
        this$0 = SPBrandEngageClient.this;
        super(looper);
    }
}
