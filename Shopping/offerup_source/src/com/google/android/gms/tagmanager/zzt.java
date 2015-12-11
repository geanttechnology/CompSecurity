// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            zzak, zzdf, zzbg

class zzt extends zzak
{

    private static final String ID;
    private static final String zzaVJ;
    private static final String zzaWt;
    private final zza zzaWu;

    public zzt(zza zza)
    {
        super(ID, new String[] {
            zzaWt
        });
        zzaWu = zza;
    }

    public boolean zzCo()
    {
        return false;
    }

    public com.google.android.gms.internal.zzag.zza zzI(Map map)
    {
        String s = zzdf.zzg((com.google.android.gms.internal.zzag.zza)map.get(zzaWt));
        HashMap hashmap = new HashMap();
        map = (com.google.android.gms.internal.zzag.zza)map.get(zzaVJ);
        if (map != null)
        {
            map = ((Map) (zzdf.zzl(map)));
            if (!(map instanceof Map))
            {
                zzbg.zzaH("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzdf.zzDX();
            }
            java.util.Map.Entry entry;
            for (map = ((Map)map).entrySet().iterator(); map.hasNext(); hashmap.put(entry.getKey().toString(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        try
        {
            map = zzdf.zzQ(zzaWu.zzc(s, hashmap));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            zzbg.zzaH((new StringBuilder("Custom macro/tag ")).append(s).append(" threw exception ").append(map.getMessage()).toString());
            return zzdf.zzDX();
        }
        return map;
    }

    static 
    {
        ID = zzad.zzbw.toString();
        zzaWt = zzae.zzfk.toString();
        zzaVJ = zzae.zzdn.toString();
    }

    private class zza
    {

        public abstract Object zzc(String s, Map map);
    }

}
