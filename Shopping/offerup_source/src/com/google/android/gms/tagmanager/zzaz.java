// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzdf, zzn

class zzaz
{

    private static com.google.android.gms.internal.zzag.zza zzJ(Object obj)
    {
        return zzdf.zzQ(zzK(obj));
    }

    static Object zzK(Object obj)
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
            for (Iterator iterator = ((JSONObject) (obj)).keys(); iterator.hasNext(); ((Map) (obj1)).put(s, zzK(((JSONObject) (obj)).get(s))))
            {
                s = (String)iterator.next();
            }

        }
        return obj1;
    }

    public static com.google.android.gms.internal.zzrb.zzc zzeT(String s)
    {
        s = zzJ(new JSONObject(s));
        com.google.android.gms.internal.zzrb.zzd zzd = com.google.android.gms.internal.zzrb.zzc.zzEc();
        for (int i = 0; i < ((com.google.android.gms.internal.zzag.zza) (s)).zziW.length; i++)
        {
            zzd.zzc(com.google.android.gms.internal.zzrb.zza.zzDZ().zzb(zzae.zzfu.toString(), ((com.google.android.gms.internal.zzag.zza) (s)).zziW[i]).zzb(zzae.zzfj.toString(), zzdf.zzfe(zzn.zzCr())).zzb(zzn.zzCs(), ((com.google.android.gms.internal.zzag.zza) (s)).zziX[i]).zzEb());
        }

        return zzd.zzEf();
    }
}
