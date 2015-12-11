// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzjm extends zze
{

    private Map zzMh;

    public zzjm()
    {
        zzMh = new HashMap(4);
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = zzMh.entrySet().iterator(); iterator.hasNext(); hashmap.put((new StringBuilder()).append("metric").append(entry.getKey()).toString(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return zzB(hashmap);
    }

    public void zza(zzjm zzjm1)
    {
        zzjm1.zzMh.putAll(zzMh);
    }

    public volatile void zza(zze zze1)
    {
        zza((zzjm)zze1);
    }

    public Map zzhY()
    {
        return Collections.unmodifiableMap(zzMh);
    }
}
