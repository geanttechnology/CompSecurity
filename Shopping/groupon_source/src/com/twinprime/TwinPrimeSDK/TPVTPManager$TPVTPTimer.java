// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import java.util.TimerTask;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPVTPManager, TwinPrimeSDKPvt, TPVTP

class tpvtp extends TimerTask
{

    final TPVTPManager this$0;
    TPVTP tpvtp;

    private void privRun()
    {
        removeVtp(tpvtp);
    }

    public void run()
    {
        try
        {
            privRun();
            return;
        }
        catch (Throwable throwable)
        {
            TwinPrimeSDKPvt.disableSDK();
        }
    }

    (TPVTP tpvtp1)
    {
        this$0 = TPVTPManager.this;
        super();
        tpvtp = tpvtp1;
    }
}
