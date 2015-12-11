// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;

import android.util.Log;
import java.util.Vector;

// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPCFHttp, TPLog

private static class LOG_TAG
{

    private String LOG_TAG;
    private Vector availablePorts;
    private Vector inUsePorts;
    int type;

    int getNextAvailablePort(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (flag) goto _L2; else goto _L1
_L1:
        if (availablePorts.size() <= 0) goto _L2; else goto _L3
_L3:
        int j;
        j = ((Integer)availablePorts.get(0)).intValue();
        availablePorts.remove(0);
        inUsePorts.add(Integer.valueOf(j));
        int i = j;
        if (!TPLog.LOG13.isLoggable(LOG_TAG))
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Log.d(LOG_TAG, (new StringBuilder()).append("Reusing port: ").append(j).toString());
        i = j;
_L5:
        this;
        JVM INSTR monitorexit ;
        return i;
_L2:
        j = TPCFHttp.getHTTPRandomPort();
        inUsePorts.add(Integer.valueOf(j));
        i = j;
        if (!TPLog.LOG13.isLoggable(LOG_TAG))
        {
            continue; /* Loop/switch isn't completed */
        }
        Log.d(LOG_TAG, (new StringBuilder()).append("Getting new random port: ").append(j).toString());
        i = j;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    void releasePort(int i, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (inUsePorts.contains(Integer.valueOf(i)))
        {
            inUsePorts.remove(Integer.valueOf(i));
            if (TPLog.LOG13.isLoggable(LOG_TAG))
            {
                Log.d(LOG_TAG, (new StringBuilder()).append("Found the port in inuse, removing it from there: ").append(i).toString());
            }
        }
        if (availablePorts.contains(Integer.valueOf(i)) || !flag)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        availablePorts.add(Integer.valueOf(i));
        if (TPLog.LOG13.isLoggable(LOG_TAG))
        {
            Log.d(LOG_TAG, (new StringBuilder()).append("Adding newly available port to availablePorts : ").append(i).toString());
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    (int i)
    {
        availablePorts = new Vector();
        inUsePorts = new Vector();
        type = i;
        switch (i)
        {
        default:
            LOG_TAG = "TPCFHttp - Default";
            return;

        case 1: // '\001'
            LOG_TAG = "TPCFHttp - OkHttp";
            return;

        case 0: // '\0'
            LOG_TAG = "TPCFHttp - Java.net";
            return;
        }
    }
}
