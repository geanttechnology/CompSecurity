// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzu, zzk, zza, zzn, 
//            zzan, zzaf, zzr, zzl, 
//            zzag, zzb, zzj, zzah, 
//            zzi, zzv, zzai, zzf

public class zzg
{

    private final Context zzMX;
    private final Context zzqZ;

    public zzg(Context context)
    {
        zzx.zzw(context);
        context = context.getApplicationContext();
        zzx.zzb(context, "Application context can't be null");
        zzqZ = context;
        zzMX = context;
    }

    public Context getApplicationContext()
    {
        return zzqZ;
    }

    protected com.google.android.gms.measurement.zzg zzY(Context context)
    {
        return com.google.android.gms.measurement.zzg.zzaJ(context);
    }

    protected zzu zza(zzf zzf1)
    {
        return new zzu(zzf1);
    }

    protected zzk zzb(zzf zzf1)
    {
        return new zzk(zzf1);
    }

    protected zza zzc(zzf zzf1)
    {
        return new zza(zzf1);
    }

    protected zzn zzd(zzf zzf1)
    {
        return new zzn(zzf1);
    }

    protected zzan zze(zzf zzf1)
    {
        return new zzan(zzf1);
    }

    protected zzaf zzf(zzf zzf1)
    {
        return new zzaf(zzf1);
    }

    protected zzr zzg(zzf zzf1)
    {
        return new zzr(zzf1);
    }

    protected zzmn zzh(zzf zzf1)
    {
        return zzmp.zzqt();
    }

    protected GoogleAnalytics zzi(zzf zzf1)
    {
        return new GoogleAnalytics(zzf1);
    }

    public Context zziG()
    {
        return zzMX;
    }

    zzl zzj(zzf zzf1)
    {
        return new zzl(zzf1, this);
    }

    zzag zzk(zzf zzf1)
    {
        return new zzag(zzf1);
    }

    protected zzb zzl(zzf zzf1)
    {
        return new zzb(zzf1, this);
    }

    public zzj zzm(zzf zzf1)
    {
        return new zzj(zzf1);
    }

    public zzah zzn(zzf zzf1)
    {
        return new zzah(zzf1);
    }

    public zzi zzo(zzf zzf1)
    {
        return new zzi(zzf1);
    }

    public zzv zzp(zzf zzf1)
    {
        return new zzv(zzf1);
    }

    public zzai zzq(zzf zzf1)
    {
        return new zzai(zzf1);
    }
}
