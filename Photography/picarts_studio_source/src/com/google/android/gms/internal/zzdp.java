// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzdk, zzin, zziz

public class zzdp
    implements zzdk
{

    final HashMap zzxP = new HashMap();

    public zzdp()
    {
    }

    public Future zzY(String s)
    {
        zzin zzin1 = new zzin();
        zzxP.put(s, zzin1);
        return zzin1;
    }

    public void zzZ(String s)
    {
        zzin zzin1 = (zzin)zzxP.get(s);
        if (zzin1 == null)
        {
            zzb.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        if (!zzin1.isDone())
        {
            zzin1.cancel(true);
        }
        zzxP.remove(s);
    }

    public void zza(zziz zziz, Map map)
    {
        zzf((String)map.get("request_id"), (String)map.get("fetched_ad"));
    }

    public void zzf(String s, String s1)
    {
        zzin zzin1;
        zzb.zzaF("Received ad from the cache.");
        zzin1 = (zzin)zzxP.get(s);
        if (zzin1 == null)
        {
            zzb.e("Could not find the ad request for the corresponding ad response.");
            return;
        }
        zzin1.zzf(new JSONObject(s1));
        zzxP.remove(s);
        return;
        s1;
        zzb.zzb("Failed constructing JSON object from value passed from javascript", s1);
        zzin1.zzf(null);
        zzxP.remove(s);
        return;
        s1;
        zzxP.remove(s);
        throw s1;
    }
}
