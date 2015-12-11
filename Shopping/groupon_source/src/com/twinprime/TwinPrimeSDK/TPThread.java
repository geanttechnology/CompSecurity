// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.TwinPrimeSDK;


// Referenced classes of package com.twinprime.TwinPrimeSDK:
//            TPRunnable, TwinPrimeSDKPvt

public class TPThread extends Thread
{

    private TPRunnable tpRunnable;

    public TPThread(TPRunnable tprunnable)
    {
        super(tprunnable);
        tpRunnable = tprunnable;
    }

    public void run()
    {
        try
        {
            for (; tpRunnable.isAlive(); tpRunnable.run()) { }
        }
        catch (Throwable throwable)
        {
            TwinPrimeSDKPvt.disableSDK();
        }
    }
}
