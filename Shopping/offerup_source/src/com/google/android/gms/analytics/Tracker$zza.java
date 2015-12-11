// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.internal.zzmn;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            Tracker, GoogleAnalytics

class zzMd extends zzd
    implements ics.zza
{

    final Tracker zzMa;
    private boolean zzMb;
    private int zzMc;
    private long zzMd;
    private boolean zzMe;
    private long zzMf;

    private void zzhV()
    {
        if (zzMd >= 0L || zzMb)
        {
            zzhK().zza(Tracker.zza(zzMa));
            return;
        } else
        {
            zzhK().zzb(Tracker.zza(zzMa));
            return;
        }
    }

    public void enableAutoActivityTracking(boolean flag)
    {
        zzMb = flag;
        zzhV();
    }

    public void setSessionTimeout(long l)
    {
        zzMd = l;
        zzhV();
    }

    protected void zzhR()
    {
    }

    public boolean zzhU()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = zzMe;
        zzMe = false;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    boolean zzhW()
    {
        return zzit().elapsedRealtime() >= zzMf + Math.max(1000L, zzMd);
    }

    public void zzn(Activity activity)
    {
        if (zzMc == 0 && zzhW())
        {
            zzMe = true;
        }
        zzMc = zzMc + 1;
        if (zzMb)
        {
            Object obj = activity.getIntent();
            if (obj != null)
            {
                zzMa.setCampaignParamsOnNextHit(((Intent) (obj)).getData());
            }
            HashMap hashmap = new HashMap();
            hashmap.put("&t", "screenview");
            Tracker tracker = zzMa;
            if (Tracker.zzk(zzMa) != null)
            {
                obj = Tracker.zzk(zzMa).zzq(activity);
            } else
            {
                obj = activity.getClass().getCanonicalName();
            }
            tracker.set("&cd", ((String) (obj)));
            if (TextUtils.isEmpty((CharSequence)hashmap.get("&dr")))
            {
                activity = Tracker.zzp(activity);
                if (!TextUtils.isEmpty(activity))
                {
                    hashmap.put("&dr", activity);
                }
            }
            zzMa.send(hashmap);
        }
    }

    public void zzo(Activity activity)
    {
        zzMc = zzMc - 1;
        zzMc = Math.max(0, zzMc);
        if (zzMc == 0)
        {
            zzMf = zzit().elapsedRealtime();
        }
    }

    protected (Tracker tracker, zzf zzf)
    {
        zzMa = tracker;
        super(zzf);
        zzMd = -1L;
    }
}
