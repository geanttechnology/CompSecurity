// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            zzef, zzep

public final class zzeg extends zzeo.zza
{

    private final Object zzpd = new Object();
    private zzei.zza zzzh;
    private zzef zzzi;

    public zzeg()
    {
    }

    public final void onAdClicked()
    {
        synchronized (zzpd)
        {
            if (zzzi != null)
            {
                zzzi.zzaX();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onAdClosed()
    {
        synchronized (zzpd)
        {
            if (zzzi != null)
            {
                zzzi.zzaY();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onAdFailedToLoad(int i)
    {
        Object obj = zzpd;
        obj;
        JVM INSTR monitorenter ;
        if (zzzh == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        Exception exception;
        if (i == 3)
        {
            i = 1;
        } else
        {
            i = 2;
        }
        zzzh.zzq(i);
        zzzh = null;
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onAdLeftApplication()
    {
        synchronized (zzpd)
        {
            if (zzzi != null)
            {
                zzzi.zzaZ();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onAdLoaded()
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzzh == null)
                {
                    break label0;
                }
                zzzh.zzq(0);
                zzzh = null;
            }
            return;
        }
        if (zzzi != null)
        {
            zzzi.zzbb();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onAdOpened()
    {
        synchronized (zzpd)
        {
            if (zzzi != null)
            {
                zzzi.zzba();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void zza(zzef zzef1)
    {
        synchronized (zzpd)
        {
            zzzi = zzef1;
        }
        return;
        zzef1;
        obj;
        JVM INSTR monitorexit ;
        throw zzef1;
    }

    public final void zza(zzei.zza zza1)
    {
        synchronized (zzpd)
        {
            zzzh = zza1;
        }
        return;
        zza1;
        obj;
        JVM INSTR monitorexit ;
        throw zza1;
    }

    public final void zza(zzep zzep)
    {
label0:
        {
            synchronized (zzpd)
            {
                if (zzzh == null)
                {
                    break label0;
                }
                zzzh.zza(0, zzep);
                zzzh = null;
            }
            return;
        }
        if (zzzi != null)
        {
            zzzi.zzbb();
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        zzep;
        obj;
        JVM INSTR monitorexit ;
        throw zzep;
    }
}
