// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzn, zzdf

class zzaz
{

    public static com.google.android.gms.internal.zzmq.zzc zzdQ(String s)
    {
        s = zzx(new JSONObject(s));
        com.google.android.gms.internal.zzmq.zzd zzd = com.google.android.gms.internal.zzmq.zzc.zzyv();
        for (int i = 0; i < ((com.google.android.gms.internal.zzd.zza) (s)).zzhm.length; i++)
        {
            zzd.zzc(com.google.android.gms.internal.zzmq.zza.zzys().zzb(zzb.zzdJ.toString(), ((com.google.android.gms.internal.zzd.zza) (s)).zzhm[i]).zzb(zzb.zzdy.toString(), zzdf.zzeb(zzn.zzwq())).zzb(zzn.zzwr(), ((com.google.android.gms.internal.zzd.zza) (s)).zzhn[i]).zzyu());
        }

        return zzd.zzyy();
    }

    private static com.google.android.gms.internal.zzd.zza zzx(Object obj)
    {
        return zzdf.zzE(zzy(obj));
    }

    static Object zzy(Object obj)
    {
        if (obj instanceof JSONArray)
        {
            throw new RuntimeException("JSONArrays are not supported");
        }
        if (JSONObject.NULL.equals(obj))
        {
            throw new RuntimeException("JSON nulls are not supported");
        }
        Object obj1 = obj;
        if (obj instanceof JSONObject)
        {
            obj = (JSONObject)obj;
            obj1 = new HashMap();
            String s;
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); ((Map) (obj1)).put(s, zzy(((JSONObject) (obj)).get(s))))
            {
                s = (String)iterator.next();
            }

        }
        return obj1;
    }
}
