// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzu, zzp, zzt

private final class setName extends Thread
{

    final zzu zzaNI;
    private final BlockingQueue zzaNJ = new LinkedBlockingQueue();

    private void zza(InterruptedException interruptedexception)
    {
        zzaNI.zzyd().zzzL().zzj((new StringBuilder()).append(getName()).append(" was interrupted").toString(), interruptedexception);
    }

    public void run()
    {
        boolean flag = false;
_L3:
        if (zzu.zzc(zzaNI) && flag)
        {
            break; /* Loop/switch isn't completed */
        }
_L1:
        FutureTask futuretask = (FutureTask)zzaNJ.poll(0L, TimeUnit.MICROSECONDS);
        if (futuretask == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        futuretask.run();
          goto _L1
        InterruptedException interruptedexception;
        interruptedexception;
        zza(interruptedexception);
        boolean flag1 = zzu.zzb(zzaNI).zzzY();
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        interruptedexception;
        zza(interruptedexception);
        if (true) goto _L3; else goto _L2
_L2:
        zzaNI.zzyd().zzzP().zzec("Scheduler thread exiting");
        return;
    }

    public void zza(FutureTask futuretask)
        throws IllegalStateException
    {
        zzx.zzw(futuretask);
        if (zzu.zza(zzaNI))
        {
            throw new IllegalStateException("Cannot schedule task; thread was already shut down.");
        }
        try
        {
            zzaNJ.put(futuretask);
            zzu.zzb(zzaNI).zzb(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (FutureTask futuretask)
        {
            zza(((InterruptedException) (futuretask)));
        }
    }

    public _cls9(zzu zzu1, String s)
    {
        zzaNI = zzu1;
        super();
        zzx.zzw(s);
        setName(s);
    }
}
