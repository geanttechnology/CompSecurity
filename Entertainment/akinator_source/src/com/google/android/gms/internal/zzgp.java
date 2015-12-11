// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zza;
import com.google.android.gms.ads.internal.formats.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.internal:
//            zzgm, zzmi

public class zzgp
    implements zzgm.zza
{

    private final boolean zzEa;

    public zzgp(boolean flag)
    {
        zzEa = flag;
    }

    private void zza(zzgm zzgm1, JSONObject jsonobject, zzmi zzmi1)
        throws JSONException
    {
        zzmi1.put(jsonobject.getString("name"), zzgm1.zza(jsonobject, "image_value", zzEa));
    }

    private void zza(JSONObject jsonobject, zzmi zzmi1)
        throws JSONException
    {
        zzmi1.put(jsonobject.getString("name"), jsonobject.getString("string_value"));
    }

    private zzmi zzc(zzmi zzmi1)
        throws InterruptedException, ExecutionException
    {
        zzmi zzmi2 = new zzmi();
        for (int i = 0; i < zzmi1.size(); i++)
        {
            zzmi2.put(zzmi1.keyAt(i), ((Future)zzmi1.valueAt(i)).get());
        }

        return zzmi2;
    }

    public com.google.android.gms.ads.internal.formats.zzh.zza zza(zzgm zzgm1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        return zzd(zzgm1, jsonobject);
    }

    public zzf zzd(zzgm zzgm1, JSONObject jsonobject)
        throws JSONException, InterruptedException, ExecutionException
    {
        zzmi zzmi1 = new zzmi();
        zzmi zzmi2 = new zzmi();
        zziq zziq = zzgm1.zze(jsonobject);
        JSONArray jsonarray = jsonobject.getJSONArray("custom_assets");
        int i = 0;
        while (i < jsonarray.length()) 
        {
            JSONObject jsonobject1 = jsonarray.getJSONObject(i);
            String s = jsonobject1.getString("type");
            if ("string".equals(s))
            {
                zza(jsonobject1, zzmi2);
            } else
            if ("image".equals(s))
            {
                zza(zzgm1, jsonobject1, zzmi1);
            } else
            {
                zzb.zzaH((new StringBuilder()).append("Unknown custom asset type: ").append(s).toString());
            }
            i++;
        }
        return new zzf(jsonobject.getString("custom_template_id"), zzc(zzmi1), zzmi2, (zza)zziq.get());
    }
}
