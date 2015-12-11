// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class <init>
{

    private final String zzYk;
    private final List zzbao;
    private final Map zzbap;
    private final int zzbaq;

    public static <init> zzEc()
    {
        return new <init>(null);
    }

    public String getVersion()
    {
        return zzYk;
    }

    public String toString()
    {
        return (new StringBuilder("Rules: ")).append(zzEd()).append("  Macros: ").append(zzbap).toString();
    }

    public List zzEd()
    {
        return zzbao;
    }

    public Map zzEe()
    {
        return zzbap;
    }

    private (List list, Map map, String s, int i)
    {
        zzbao = Collections.unmodifiableList(list);
        zzbap = Collections.unmodifiableMap(map);
        zzYk = s;
        zzbaq = i;
    }

    zzbaq(List list, Map map, String s, int i, zzbaq zzbaq1)
    {
        this(list, map, s, i);
    }
}
