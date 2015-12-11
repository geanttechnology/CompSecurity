// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzc, zzf

public abstract class zzd extends zzc
{

    private boolean zzMF;
    private boolean zzMG;

    protected zzd(zzf zzf)
    {
        super(zzf);
    }

    public boolean isInitialized()
    {
        return zzMF && !zzMG;
    }

    public void zza()
    {
        zzhR();
        zzMF = true;
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
