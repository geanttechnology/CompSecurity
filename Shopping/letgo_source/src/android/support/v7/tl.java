// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.Future;

// Referenced classes of package android.support.v7:
//            to

public abstract class tl
{

    private volatile Thread zzHt;
    private final Runnable zzx = new Runnable() {

        final tl a;

        public final void run()
        {
            tl.zza(a, Thread.currentThread());
            a.zzdG();
        }

            
            {
                a = tl.this;
                super();
            }
    };

    public tl()
    {
    }

    static Thread zza(tl tl1, Thread thread)
    {
        tl1.zzHt = thread;
        return thread;
    }

    public final void cancel()
    {
        onStop();
        if (zzHt != null)
        {
            zzHt.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzdG();

    public final Future zzgn()
    {
        return to.a(zzx);
    }

    public final void zzgo()
    {
        to.a(1, zzx);
    }
}
