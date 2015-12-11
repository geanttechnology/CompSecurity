// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPCFHttp, TPEventLog

class TPHttpConnectionCore
{

    String bypass_reason;
    TPEventLog tpEvLog;
    TPCFHttp tpcfHttp;
    boolean will_accelerate;

    TPHttpConnectionCore(TPCFHttp tpcfhttp)
    {
        boolean flag = true;
        super();
        tpcfHttp = tpcfhttp;
        tpEvLog = tpcfhttp.tpEventLog;
        if (tpcfhttp.tpEventLog.is_accelerated != 1)
        {
            flag = false;
        }
        will_accelerate = flag;
        bypass_reason = tpcfhttp.tpEventLog.bypass_reason;
    }

    void finishEventLog()
    {
        TPEventLog tpeventlog = tpEvLog;
        int i;
        if (will_accelerate)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        tpeventlog.is_accelerated = i;
        tpEvLog.bypass_reason = bypass_reason;
        tpEvLog.endLoggingEvent();
    }
}
