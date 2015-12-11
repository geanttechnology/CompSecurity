// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.google.android.gms.internal:
//            zzrb

public static class <init>
{

    private final zzban zzaYM;
    private final Map zzban;

    public static <init> zzDZ()
    {
        return new <init>(null);
    }

    public String toString()
    {
        return (new StringBuilder()).append("Properties: ").append(zzEa()).append(" pushAfterEvaluate: ").append(zzaYM).toString();
    }

    public zzaYM zzDz()
    {
        return zzaYM;
    }

    public Map zzEa()
    {
        return Collections.unmodifiableMap(zzban);
    }

    public void zza(String s, zzban zzban1)
    {
        zzban.put(s, zzban1);
    }

    private (Map map,  )
    {
        zzban = map;
        zzaYM = ;
    }

    zzaYM(Map map, zzaYM zzaym, zzaYM zzaym1)
    {
        this(map, zzaym);
    }
}
