// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzgh, zzic

public abstract class zzhz
    implements zzgh
{

    private volatile Thread zzIl;
    private boolean zzIm;
    private final Runnable zzx;

    public zzhz()
    {
        zzx = new _cls1();
        zzIm = false;
    }

    public zzhz(boolean flag)
    {
        zzx = new _cls1();
        zzIm = flag;
    }

    static Thread zza(zzhz zzhz1, Thread thread)
    {
        zzhz1.zzIl = thread;
        return thread;
    }

    public final void cancel()
    {
        onStop();
        if (zzIl != null)
        {
            zzIl.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzbn();

    public Object zzfu()
    {
        return zzgz();
    }

    public final Future zzgz()
    {
        if (zzIm)
        {
            return zzic.zza(1, zzx);
        } else
        {
            return zzic.zza(zzx);
        }
    }

    private class _cls1
        implements Runnable
    {

        final zzhz zzIn;

        public final void run()
        {
            zzhz.zza(zzIn, Thread.currentThread());
            zzIn.zzbn();
        }

        _cls1()
        {
            zzIn = zzhz.this;
            super();
        }
    }

}
