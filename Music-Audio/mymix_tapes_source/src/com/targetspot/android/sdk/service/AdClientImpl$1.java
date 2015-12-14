// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.targetspot.android.sdk.service:
//            AdClientImpl

class this._cls0 extends Handler
{

    final AdClientImpl this$0;

    public void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 5 8: default 36
    //                   5 37
    //                   6 99
    //                   7 53
    //                   8 45;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        sendAdAvailable();
        return;
_L5:
        sendAdRefreshing();
        return;
_L4:
        if (AdClientImpl.access$000(AdClientImpl.this) == 1)
        {
            AdClientImpl.access$100(AdClientImpl.this);
            AdClientImpl.access$002(AdClientImpl.this, 0);
        }
        sendPlaybackError(message.arg1, (Exception)message.obj);
        return;
_L3:
        if (AdClientImpl.access$000(AdClientImpl.this) == 1)
        {
            Log.d("AdClient", "Starting preroll playback");
            AdClientImpl.access$002(AdClientImpl.this, 2);
            if (AdClientImpl.access$200(AdClientImpl.this) != null)
            {
                AdClientImpl.access$200(AdClientImpl.this).dismiss();
            }
            startAd();
            return;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    ()
    {
        this$0 = AdClientImpl.this;
        super();
    }
}
