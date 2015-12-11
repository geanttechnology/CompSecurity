// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzw;

public class count
{

    public final int count;
    public final String name;
    public final double zzIT;
    public final double zzIU;
    public final double zzIV;

    public boolean equals(Object obj)
    {
        if (obj instanceof count)
        {
            if (zzw.equal(name, ((name) (obj = (name)obj)).name) && zzIT == ((zzIT) (obj)).zzIT && zzIU == ((zzIU) (obj)).zzIU && count == ((count) (obj)).count && Double.compare(zzIV, ((zzIV) (obj)).zzIV) == 0)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            name, Double.valueOf(zzIT), Double.valueOf(zzIU), Double.valueOf(zzIV), Integer.valueOf(count)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zg("name", name).zg("minBound", Double.valueOf(zzIU)).zg("maxBound", Double.valueOf(zzIT)).zg("percent", Double.valueOf(zzIV)).zg("count", Integer.valueOf(count)).oString();
    }

    public w.zza(String s, double d, double d1, double d2, 
            int i)
    {
        name = s;
        zzIU = d;
        zzIT = d1;
        zzIV = d2;
        count = i;
    }
}
