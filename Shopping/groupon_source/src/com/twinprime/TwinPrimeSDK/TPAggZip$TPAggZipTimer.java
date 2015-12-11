// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPAggZip, TPLog

class started extends Handler
{

    boolean started;
    final TPAggZip this$0;

    public void handleMessage(Message message)
    {
        if (message.what == 201)
        {
            if (TPLog.LOG13.isLoggable("TPAggZip"))
            {
                Log.d("TPAggZip", (new StringBuilder()).append(desc).append(" - Timer is off, time to send xcp msg!").toString());
            }
            started = false;
            send();
        }
    }

    ()
    {
        this$0 = TPAggZip.this;
        super();
        started = false;
    }
}
