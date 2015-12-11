// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import java.util.concurrent.Executors;
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
    private String zzaCH;
    private final String zzaCk;
    private zzbf zzaEG;
    private zzs zzaEH;
    private final ScheduledExecutorService zzaEJ;
    private final zza zzaEK;
    private ScheduledFuture zzaEL;

    public zzcm(Context context, String s, zzs zzs)
    {
        this(context, s, zzs, null, null);
    }

    zzcm(Context context, String s, zzs zzs, zzb zzb1, zza zza1)
    {
        zzaEH = zzs;
        mContext = context;
        zzaCk = s;
        context = zzb1;
        if (zzb1 == null)
        {
            context = new zzb() {

                final zzcm zzaEM;

                public ScheduledExecutorService zzxs()
                {
                    return Executors.newSingleThreadScheduledExecutor();
                }

            
            {
                zzaEM = zzcm.this;
                super();
            }
            };
        }
        zzaEJ = context.zzxs();
        if (zza1 == null)
        {
            zzaEK = new zza() {

                final zzcm zzaEM;

                public zzcl zza(zzs zzs1)
                {
                    return new zzcl(zzcm.zza(zzaEM), zzcm.zzb(zzaEM), zzs1);
                }

            
            {
                zzaEM = zzcm.this;
                super();
            }
            };
            return;
        } else
        {
            zzaEK = zza1;
            return;
        }
    }

    static Context zza(zzcm zzcm1)
    {
        return zzcm1.mContext;
    }

    static String zzb(zzcm zzcm1)
    {
        return zzcm1.zzaCk;
    }

    private zzcl zzdU(String s)
    {
        zzcl zzcl1 = zzaEK.zza(zzaEH);
        zzcl1.zza(zzaEG);
        zzcl1.zzdE(zzaCH);
        zzcl1.zzdT(s);
        return zzcl1;
    }

    private void zzxr()
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

    public void release()
    {
        this;
        JVM INSTR monitorenter ;
        zzxr();
        if (zzaEL != null)
        {
            zzaEL.cancel(false);
        }
        zzaEJ.shutdown();
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
        zzxr();
        zzaEG = zzbf;
        this;
        JVM INSTR monitorexit ;
        return;
        zzbf;
        throw zzbf;
    }

    public void zzdE(String s)
    {
        this;
        JVM INSTR monitorenter ;
        zzxr();
        zzaCH = s;
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
        zzbg.zzam((new StringBuilder()).append("loadAfterDelay: containerId=").append(zzaCk).append(" delay=").append(l).toString());
        zzxr();
        if (zzaEG == null)
        {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        break MISSING_BLOCK_LABEL_62;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (zzaEL != null)
        {
            zzaEL.cancel(false);
        }
        zzaEL = zzaEJ.schedule(zzdU(s), l, TimeUnit.MILLISECONDS);
        this;
        JVM INSTR monitorexit ;
    }

    private class zzb
    {

        public abstract ScheduledExecutorService zzxs();
    }


    private class zza
    {

        public abstract zzcl zza(zzs zzs);
    }

}
