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

public final class zzjl extends zze
{

    private Map zzMg;

    public zzjl()
    {
        zzMg = new HashMap(4);
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = zzMg.entrySet().iterator(); iterator.hasNext(); hashmap.put((new StringBuilder()).append("dimension").append(entry.getKey()).toString(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        return zzB(hashmap);
    }

    public void zza(zzjl zzjl1)
    {
        zzjl1.zzMg.putAll(zzMg);
    }

    public volatile void zza(zze zze1)
    {
        zza((zzjl)zze1);
    }

    public Map zzhX()
    {
        return Collections.unmodifiableMap(zzMg);
    }
}
