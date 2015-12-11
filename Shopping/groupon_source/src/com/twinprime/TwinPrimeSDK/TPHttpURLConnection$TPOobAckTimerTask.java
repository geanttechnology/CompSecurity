// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.util.TimerTask;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPHttpURLConnection, TPLog, TPHttpConnectionCore, TPCFHttp, 
//            TwinPrimeSDKPvt

class this._cls0 extends TimerTask
{

    final TPHttpURLConnection this$0;

    private void privRun()
    {
        if (TPLog.LOG13.isLoggable("TPHttpURLConnection"))
        {
            Log.d("TPHttpURLConnection", (new StringBuilder()).append("TPOobAckTimer - ").append(tpConnCore.tpcfHttp.originAddress).toString());
        }
        sendOutOfBandAck();
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

    ()
    {
        this$0 = TPHttpURLConnection.this;
        super();
    }
}
