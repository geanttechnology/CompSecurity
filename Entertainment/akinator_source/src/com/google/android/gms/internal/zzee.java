// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzed, zzej

public final class zzee
{

    public final List zzyW;
    public final long zzyX;
    public final List zzyY;
    public final List zzyZ;
    public final List zzza;
    public final String zzzb;
    public final long zzzc;
    public final String zzzd;
    public final int zzze;
    public int zzzf;
    public int zzzg;

    public zzee(String s)
        throws JSONException
    {
        s = new JSONObject(s);
        if (zzb.zzN(2))
        {
            zzb.v((new StringBuilder()).append("Mediation Response JSON: ").append(s.toString(2)).toString());
        }
        JSONArray jsonarray = s.getJSONArray("ad_networks");
        ArrayList arraylist = new ArrayList(jsonarray.length());
        int j = -1;
        for (int i = 0; i < jsonarray.length();)
        {
            zzed zzed1 = new zzed(jsonarray.getJSONObject(i));
            arraylist.add(zzed1);
            int k = j;
            if (j < 0)
            {
                k = j;
                if (zza(zzed1))
                {
                    k = i;
                }
            }
            i++;
            j = k;
        }

        zzzf = j;
        zzzg = jsonarray.length();
        zzyW = Collections.unmodifiableList(arraylist);
        zzzb = s.getString("qdata");
        s = s.optJSONObject("settings");
        if (s != null)
        {
            zzyX = s.optLong("ad_network_timeout_millis", -1L);
            zzyY = zzp.zzbH().zza(s, "click_urls");
            zzyZ = zzp.zzbH().zza(s, "imp_urls");
            zzza = zzp.zzbH().zza(s, "nofill_urls");
            long l = s.optLong("refresh", -1L);
            if (l > 0L)
            {
                l *= 1000L;
            } else
            {
                l = -1L;
            }
            zzzc = l;
            s = s.optJSONArray("rewards");
            if (s == null || s.length() == 0)
            {
                zzzd = null;
                zzze = 0;
                return;
            } else
            {
                zzzd = s.getJSONObject(0).optString("rb_type");
                zzze = s.getJSONObject(0).optInt("rb_amount");
                return;
            }
        } else
        {
            zzyX = -1L;
            zzyY = null;
            zzyZ = null;
            zzza = null;
            zzzc = -1L;
            zzzd = null;
            zzze = 0;
            return;
        }
    }

    private boolean zza(zzed zzed1)
    {
        for (zzed1 = zzed1.zzyO.iterator(); zzed1.hasNext();)
        {
            if (((String)zzed1.next()).equals("com.google.ads.mediation.admob.AdMobAdapter"))
            {
                return true;
            }
        }

        return false;
    }
}
