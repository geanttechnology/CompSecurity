// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.measurement.AppMeasurementReceiver;
import com.google.android.gms.measurement.AppMeasurementService;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzy, zzv, zzp, zzn, 
//            zzab, zzag, zzu, zzs, 
//            zzc

public class zzad extends zzy
{

    private boolean zzOc;
    private final AlarmManager zzOd = (AlarmManager)getContext().getSystemService("alarm");

    protected zzad(zzv zzv)
    {
        super(zzv);
    }

    private PendingIntent zzkm()
    {
        Intent intent = new Intent(getContext(), com/google/android/gms/measurement/AppMeasurementReceiver);
        intent.setAction("com.google.android.gms.measurement.UPLOAD");
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel()
    {
        zziE();
        zzOc = false;
        zzOd.cancel(zzkm());
    }

    public volatile Context getContext()
    {
        return super.getContext();
    }

    protected void zzhR()
    {
        zzOd.cancel(zzkm());
    }

    public volatile void zzir()
    {
        super.zzir();
    }

    public volatile void zzis()
    {
        super.zzis();
    }

    public volatile zzmn zzit()
    {
        return super.zzit();
    }

    public void zzt(long l)
    {
        zziE();
        long l1;
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzaa(flag);
        zzx.zza(AppMeasurementReceiver.zzV(getContext()), "Receiver not registered/enabled");
        zzx.zza(AppMeasurementService.zzW(getContext()), "Service not registered/enabled");
        cancel();
        l1 = zzit().elapsedRealtime();
        zzOc = true;
        zzOd.setInexactRepeating(2, l1 + l, 0x5265c00L, zzkm());
    }

    public volatile zzp zzyd()
    {
        return super.zzyd();
    }

    public volatile void zzzn()
    {
        super.zzzn();
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

    public volatile zzc zzzt()
    {
        return super.zzzt();
    }
}
