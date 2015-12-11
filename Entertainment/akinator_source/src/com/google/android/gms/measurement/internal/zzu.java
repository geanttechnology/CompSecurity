// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzt, zzv, zzp, 
//            zzn, zzab, zzag, zzs, 
//            zzc

public class zzu extends zzy
{
    private final class zza extends FutureTask
    {

        private final String zzaNH;
        final zzu zzaNI;

        protected void setException(Throwable throwable)
        {
            zzaNI.zzyd().zzzK().zzj(zzaNH, throwable);
            super.setException(throwable);
        }

        zza(Runnable runnable, String s)
        {
            zzaNI = zzu.this;
            super(runnable, null);
            zzx.zzw(s);
            zzaNH = s;
        }
    }

    private final class zzb
        implements Thread.UncaughtExceptionHandler
    {

        private final String zzaNH;
        final zzu zzaNI;

        public void uncaughtException(Thread thread, Throwable throwable)
        {
            this;
            JVM INSTR monitorenter ;
            zzaNI.zzyd().zzzK().zzj(zzaNH, throwable);
            this;
            JVM INSTR monitorexit ;
            return;
            thread;
            throw thread;
        }

        public zzb(String s)
        {
            zzaNI = zzu.this;
            super();
            zzx.zzw(s);
            zzaNH = s;
        }
    }

    private final class zzc extends Thread
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

        public zzc(String s)
        {
            zzaNI = zzu.this;
            super();
            zzx.zzw(s);
            setName(s);
        }
    }


    private volatile boolean zzLA;
    private final zzc zzaND = new zzc("Measurement Worker");
    private final zzc zzaNE = new zzc("Measurement Network");
    private final zzt zzaNF;
    private volatile boolean zzaNG;

    zzu(zzv zzv)
    {
        super(zzv);
        zzaND.setUncaughtExceptionHandler(new zzb("Thread death: Uncaught exception on worker thread"));
        zzaNE.setUncaughtExceptionHandler(new zzb("Thread death: Uncaught exception on network thread"));
        zzv = new HashSet();
        zzv.add(Long.valueOf(zzaND.getId()));
        zzv.add(Long.valueOf(zzaNE.getId()));
        zzaNF = new zzt(zzv);
    }

    private void zza(Runnable runnable, zzc zzc1, String s)
        throws IllegalStateException
    {
        zziE();
        zzx.zzw(runnable);
        zzc1.zza(new zza(runnable, s));
    }

    static boolean zza(zzu zzu1)
    {
        return zzu1.zzLA;
    }

    static zzt zzb(zzu zzu1)
    {
        return zzu1.zzaNF;
    }

    static boolean zzc(zzu zzu1)
    {
        return zzu1.zzaNG;
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    public void zzh(Runnable runnable)
        throws IllegalStateException
    {
        zza(runnable, zzaND, "Task exception on worker thread");
    }

    protected void zzhR()
    {
        zzaND.start();
        zzaNE.start();
    }

    public void zzi(Runnable runnable)
        throws IllegalStateException
    {
        zza(runnable, zzaNE, "Task exception on network thread");
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public void zzis()
    {
        if (Thread.currentThread() != zzaND)
        {
            throw new IllegalStateException("Call expected from worker thread");
        } else
        {
            return;
        }
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    public void zzzn()
    {
        if (Thread.currentThread() != zzaNE)
        {
            throw new IllegalStateException("Call expected from network thread");
        } else
        {
            return;
        }
    }

    public volatile zzn zzzo()
    {
        return super.zzzo();
    }

    public volatile zzab zzzp()
    {
        return super.zzzp();
    }

    public volatile zzag zzzq()
    {
        return super.zzzq();
    }

    public volatile zzu zzzr()
    {
        return super.zzzr();
    }

    public volatile zzs zzzs()
    {
        return super.zzzs();
    }

    public volatile com.google.android.gms.measurement.internal.zzc zzzt()
    {
        return super.zzzt();
    }
}
