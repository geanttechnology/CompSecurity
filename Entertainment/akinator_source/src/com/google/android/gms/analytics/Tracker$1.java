// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zza;
import com.google.android.gms.analytics.internal.zzab;
import com.google.android.gms.analytics.internal.zzad;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zze;
import com.google.android.gms.analytics.internal.zzh;
import com.google.android.gms.analytics.internal.zzk;
import com.google.android.gms.analytics.internal.zzu;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            Tracker, GoogleAnalytics

class zzLZ
    implements Runnable
{

    final Map zzLT;
    final boolean zzLU;
    final String zzLV;
    final long zzLW;
    final boolean zzLX;
    final boolean zzLY;
    final String zzLZ;
    final Tracker zzMa;

    public void run()
    {
        boolean flag1 = true;
        if (com.google.android.gms.analytics.Tracker.zza(zzMa).zzhU())
        {
            zzLT.put("sc", "start");
        }
        zzam.zzd(zzLT, "cid", zzMa.zzhK().getClientId());
        Object obj = (String)zzLT.get("sf");
        if (obj != null)
        {
            double d = zzam.zza(((String) (obj)), 100D);
            if (zzam.zza(d, (String)zzLT.get("cid")))
            {
                zzMa.zzb("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d));
                return;
            }
        }
        obj = com.google.android.gms.analytics.Tracker.zzb(zzMa);
        boolean flag;
        if (zzLU)
        {
            zzam.zzb(zzLT, "ate", ((zza) (obj)).zzic());
            zzam.zzc(zzLT, "adid", ((zza) (obj)).zzig());
        } else
        {
            zzLT.remove("ate");
            zzLT.remove("adid");
        }
        obj = Tracker.zzc(zzMa).zzjb();
        zzam.zzc(zzLT, "an", ((zzpb) (obj)).zzkp());
        zzam.zzc(zzLT, "av", ((zzpb) (obj)).zzkr());
        zzam.zzc(zzLT, "aid", ((zzpb) (obj)).zzuM());
        zzam.zzc(zzLT, "aiid", ((zzpb) (obj)).zzyt());
        zzLT.put("v", "1");
        zzLT.put("_v", zze.zzMH);
        zzam.zzc(zzLT, "ul", Tracker.zzd(zzMa).zzki().getLanguage());
        zzam.zzc(zzLT, "sr", com.google.android.gms.analytics.Tracker.zze(zzMa).zzkj());
        if (zzLV.equals("transaction") || zzLV.equals("item"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && !Tracker.zzf(zzMa).zzkF())
        {
            Tracker.zzg(zzMa).zzh(zzLT, "Too many hits sent too quickly, rate limiting invoked");
            return;
        }
        long l1 = zzam.zzbq((String)zzLT.get("ht"));
        long l = l1;
        if (l1 == 0L)
        {
            l = zzLW;
        }
        if (zzLX)
        {
            obj = new zzab(zzMa, zzLT, l, zzLY);
            com.google.android.gms.analytics.Tracker.zzh(zzMa).zzc("Dry run enabled. Would have sent hit", obj);
            return;
        }
        obj = (String)zzLT.get("cid");
        HashMap hashmap = new HashMap();
        zzam.zza(hashmap, "uid", zzLT);
        zzam.zza(hashmap, "an", zzLT);
        zzam.zza(hashmap, "aid", zzLT);
        zzam.zza(hashmap, "av", zzLT);
        zzam.zza(hashmap, "aiid", zzLT);
        String s = zzLZ;
        if (TextUtils.isEmpty((CharSequence)zzLT.get("adid")))
        {
            flag1 = false;
        }
        obj = new zzh(0L, ((String) (obj)), s, flag1, 0L, hashmap);
        l1 = Tracker.zzi(zzMa).zza(((zzh) (obj)));
        zzLT.put("_s", String.valueOf(l1));
        obj = new zzab(zzMa, zzLT, l, zzLY);
        Tracker.zzj(zzMa).zza(((zzab) (obj)));
    }

    zb(Tracker tracker, Map map, boolean flag, String s, long l, boolean flag1, 
            boolean flag2, String s1)
    {
        zzMa = tracker;
        zzLT = map;
        zzLU = flag;
        zzLV = s;
        zzLW = l;
        zzLX = flag1;
        zzLY = flag2;
        zzLZ = s1;
        super();
    }
}
