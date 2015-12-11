// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzcl, zzbg, zzbf, zzs

class zzcm
    implements zzp.zze
{

    private boolean mClosed;
    private final Context mContext;
    private final String zzaVQ;
    private String zzaWn;
    private zzbf zzaYk;
    private zzs zzaYl;
    private final ScheduledExecutorService zzaYn;
    private final zza zzaYo;
    private ScheduledFuture zzaYp;

    public zzcm(Context context, String s, zzs zzs)
    {
        this(context, s, zzs, null, null);
    }

    zzcm(Context context, String s, zzs zzs, zzb zzb1, zza zza1)
    {
        zzaYl = zzs;
        mContext = context;
        zzaVQ = s;
        context = zzb1;
        if (zzb1 == null)
        {
            context = new _cls1();
        }
        zzaYn = context.zzDt();
        if (zza1 == null)
        {
            zzaYo = new _cls2();
            return;
        } else
        {
            zzaYo = zza1;
            return;
        }
    }

    private void zzDs()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed)
        {
            throw new IllegalStateException("called method after closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    static Context zza(zzcm zzcm1)
    {
        return zzcm1.mContext;
    }

    static String zzb(zzcm zzcm1)
    {
        return zzcm1.zzaVQ;
    }

    private zzcl zzeX(String s)
    {
        zzcl zzcl1 = zzaYo.zza(zzaYl);
        zzcl1.zza(zzaYk);
        zzcl1.zzeH(zzaWn);
        zzcl1.zzeW(s);
        return zzcl1;
    }

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        zzDs();
        if (zzaYp != null)
        {
            zzaYp.cancel(false);
        }
        zzaYn.shutdown();
        mClosed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void zza(zzbf zzbf)
    {
        this;
        JVM INSTR monitorenter ;
        zzDs();
        zzaYk = zzbf;
        this;
        JVM INSTR monitorexit ;
        return;
        zzbf;
        throw zzbf;
    }

    public void zzeH(String s)
    {
        this;
        JVM INSTR monitorenter ;
        zzDs();
        zzaWn = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void zzf(long l, String s)
    {
        this;
        JVM INSTR monitorenter ;
        zzbg.v((new StringBuilder("loadAfterDelay: containerId=")).append(zzaVQ).append(" delay=").append(l).toString());
        zzDs();
        if (zzaYk == null)
        {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        break MISSING_BLOCK_LABEL_59;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (zzaYp != null)
        {
            zzaYp.cancel(false);
        }
        zzaYp = zzaYn.schedule(zzeX(s), l, TimeUnit.MILLISECONDS);
        this;
        JVM INSTR monitorexit ;
    }

    private class _cls1
        implements zzb
    {

        final zzcm zzaYq;

        public ScheduledExecutorService zzDt()
        {
            return Executors.newSingleThreadScheduledExecutor();
        }

        _cls1()
        {
            zzaYq = zzcm.this;
            super();
        }
    }


    private class zzb
    {

        public abstract ScheduledExecutorService zzDt();
    }


    private class _cls2
        implements zza
    {

        final zzcm zzaYq;

        public zzcl zza(zzs zzs)
        {
            return new zzcl(zzcm.zza(zzaYq), zzcm.zzb(zzaYq), zzs);
        }

        _cls2()
        {
            zzaYq = zzcm.this;
            super();
        }
    }


    private class zza
    {

        public abstract zzcl zza(zzs zzs);
    }

}
