// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzjn extends zze
{

    private final Map zzvS = new HashMap();

    public zzjn()
    {
    }

    private String zzaT(String s)
    {
        zzx.zzcr(s);
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.startsWith("&"))
            {
                s1 = s.substring(1);
            }
        }
        zzx.zzh(s1, "Name can not be empty or \"&\"");
        return s1;
    }

    public void set(String s, String s1)
    {
        s = zzaT(s);
        zzvS.put(s, s1);
    }

    public String toString()
    {
        return zzB(zzvS);
    }

    public void zza(zzjn zzjn1)
    {
        zzx.zzw(zzjn1);
        zzjn1.zzvS.putAll(zzvS);
    }

    public volatile void zza(zze zze1)
    {
        zza((zzjn)zze1);
    }

    public Map zzhZ()
    {
        return Collections.unmodifiableMap(zzvS);
    }
}
