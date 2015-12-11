// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzr, zzf

public class zzv extends zzd
{

    private boolean zzOb;
    private boolean zzOc;
    private AlarmManager zzOd;

    protected zzv(zzf zzf)
    {
        super(zzf);
        zzOd = (AlarmManager)getContext().getSystemService("alarm");
    }

    private PendingIntent zzkm()
    {
        Intent intent = new Intent(getContext(), com/google/android/gms/analytics/AnalyticsReceiver);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(getContext(), 0, intent, 0);
    }

    public void cancel()
    {
        zziE();
        zzOc = false;
        zzOd.cancel(zzkm());
    }

    public boolean zzbp()
    {
        return zzOc;
    }

    protected void zzhR()
    {
        ActivityInfo activityinfo;
        try
        {
            zzOd.cancel(zzkm());
            if (zziv().zzjJ() <= 0L)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            activityinfo = getContext().getPackageManager().getReceiverInfo(new ComponentName(getContext(), com/google/android/gms/analytics/AnalyticsReceiver), 2);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return;
        }
        if (activityinfo == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (activityinfo.enabled)
        {
            zzba("Receiver registered. Using alarm for local dispatch.");
            zzOb = true;
        }
    }

    public boolean zzkk()
    {
        return zzOb;
    }

    public void zzkl()
    {
        zziE();
        zzx.zza(zzkk(), "Receiver not registered");
        long l = zziv().zzjJ();
        if (l > 0L)
        {
            cancel();
            long l1 = zzit().elapsedRealtime();
            zzOc = true;
            zzOd.setInexactRepeating(2, l1 + l, 0L, zzkm());
        }
    }
}
