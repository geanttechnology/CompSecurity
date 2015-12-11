// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            kl

final class ko extends Thread
{

    public ko()
    {
        super("Okio Watchdog");
        setDaemon(true);
    }

    public final void run()
    {
        do
        {
            kl kl1;
            do
            {
                kl1 = kl.a_();
            } while (kl1 == null);
            try
            {
                kl1.a();
            }
            catch (InterruptedException interruptedexception) { }
        } while (true);
    }
}
