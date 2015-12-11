// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzhg, zzem

public class zzhf extends com.google.android.gms.ads.internal.reward.client.zzb.zza
{

    private final Context mContext;
    private final zzhg zzGW;
    private final VersionInfoParcel zzpb;
    private final Object zzpd = new Object();

    public zzhf(Context context, zzem zzem, VersionInfoParcel versioninfoparcel)
    {
        mContext = context;
        zzpb = versioninfoparcel;
        zzGW = new zzhg(context, AdSizeParcel.zzcC(), zzem, versioninfoparcel);
    }

    public void destroy()
    {
        synchronized (zzpd)
        {
            zzGW.destroy();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean isLoaded()
    {
        boolean flag;
        synchronized (zzpd)
        {
            flag = zzGW.isLoaded();
        }
        return flag;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void pause()
    {
        synchronized (zzpd)
        {
            zzGW.pause();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void resume()
    {
        synchronized (zzpd)
        {
            zzGW.resume();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setUserId(String s)
    {
        synchronized (zzpd)
        {
            zzGW.setUserId(s);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void show()
    {
        synchronized (zzpd)
        {
            zzGW.zzga();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void zza(RewardedVideoAdRequestParcel rewardedvideoadrequestparcel)
    {
        synchronized (zzpd)
        {
            zzGW.zza(rewardedvideoadrequestparcel);
        }
        return;
        rewardedvideoadrequestparcel;
        obj;
        JVM INSTR monitorexit ;
        throw rewardedvideoadrequestparcel;
    }

    public void zza(zzd zzd)
    {
        synchronized (zzpd)
        {
            zzGW.zza(zzd);
        }
        return;
        zzd;
        obj;
        JVM INSTR monitorexit ;
        throw zzd;
    }
}
