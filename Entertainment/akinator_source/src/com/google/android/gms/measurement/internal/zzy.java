// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;


// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzx, zzv

abstract class zzy extends zzx
{

    private boolean zzMF;
    private boolean zzMG;
    private boolean zzaOk;

    zzy(zzv zzv1)
    {
        super(zzv1);
        zzaKG.zzb(this);
    }

    boolean isInitialized()
    {
        return zzMF && !zzMG;
    }

    boolean zzAp()
    {
        return zzaOk;
    }

    public final void zza()
    {
        if (zzMF)
        {
            throw new IllegalStateException("Can't initialize twice");
        } else
        {
            zzhR();
            zzaKG.zzAo();
            zzMF = true;
            return;
        }
    }

    protected abstract void zzhR();

    protected void zziE()
    {
        if (!isInitialized())
        {
            throw new IllegalStateException("Not initialized");
        } else
        {
            return;
        }
    }
}
