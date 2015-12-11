// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzak
{

    private final Set zzaWY;
    private final String zzaWZ;

    public transient zzak(String s, String as[])
    {
        zzaWZ = s;
        zzaWY = new HashSet(as.length);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s = as[i];
            zzaWY.add(s);
        }

    }

    public String zzCT()
    {
        return zzaWZ;
    }

    public Set zzCU()
    {
        return zzaWY;
    }

    public abstract boolean zzCo();

    public abstract com.google.android.gms.internal.zzag.zza zzI(Map map);

    boolean zzf(Set set)
    {
        return set.containsAll(zzaWY);
    }
}
