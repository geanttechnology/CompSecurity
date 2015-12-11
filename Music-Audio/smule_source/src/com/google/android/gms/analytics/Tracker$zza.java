// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzd;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.internal.zzht;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            Tracker, GoogleAnalytics

class zzFa extends zzd
    implements ics.zza
{

    final Tracker zzEX;
    private boolean zzEY;
    private int zzEZ;
    private long zzFa;
    private boolean zzFb;
    private long zzFc;

    private void zzgf()
    {
        if (zzFa >= 0L || zzEY)
        {
            zzfT().zza(Tracker.zza(zzEX));
            return;
        } else
        {
            zzfT().zzb(Tracker.zza(zzEX));
            return;
        }
    }

    public void enableAutoActivityTracking(boolean flag)
    {
        zzEY = flag;
        zzgf();
    }

    public void setSessionTimeout(long l)
    {
        zzFa = l;
        zzgf();
    }

    protected void zzgb()
    {
    }

    public boolean zzge()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = zzFb;
        zzFb = false;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    boolean zzgg()
    {
        return zzgG().elapsedRealtime() >= zzFc + Math.max(1000L, zzFa);
    }

    public void zzn(Activity activity)
    {
        if (zzEZ == 0 && zzgg())
        {
            zzFb = true;
        }
        zzEZ = zzEZ + 1;
        if (zzEY)
        {
            Object obj = activity.getIntent();
            if (obj != null)
            {
                zzEX.setCampaignParamsOnNextHit(((Intent) (obj)).getData());
            }
            HashMap hashmap = new HashMap();
            hashmap.put("&t", "screenview");
            Tracker tracker = zzEX;
            if (Tracker.zzk(zzEX) != null)
            {
                obj = Tracker.zzk(zzEX).zzq(activity);
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
            zzEX.send(hashmap);
        }
    }

    public void zzo(Activity activity)
    {
        zzEZ = zzEZ - 1;
        zzEZ = Math.max(0, zzEZ);
        if (zzEZ == 0)
        {
            zzFc = zzgG().elapsedRealtime();
        }
    }

    protected (Tracker tracker, zze zze)
    {
        zzEX = tracker;
        super(zze);
        zzFa = -1L;
    }
}
