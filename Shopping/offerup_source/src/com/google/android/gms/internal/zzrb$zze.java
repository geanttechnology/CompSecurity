// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.List;

public class <init>
{

    private final List zzbaA;
    private final List zzbar;
    private final List zzbas;
    private final List zzbat;
    private final List zzbau;
    private final List zzbav;
    private final List zzbaw;
    private final List zzbax;
    private final List zzbay;
    private final List zzbaz;

    public static <init> zzEg()
    {
        return new <init>(null);
    }

    public String toString()
    {
        return (new StringBuilder("Positive predicates: ")).append(zzEh()).append("  Negative predicates: ").append(zzEi()).append("  Add tags: ").append(zzEj()).append("  Remove tags: ").append(zzEk()).append("  Add macros: ").append(zzEl()).append("  Remove macros: ").append(zzEq()).toString();
    }

    public List zzEh()
    {
        return zzbar;
    }

    public List zzEi()
    {
        return zzbas;
    }

    public List zzEj()
    {
        return zzbat;
    }

    public List zzEk()
    {
        return zzbau;
    }

    public List zzEl()
    {
        return zzbav;
    }

    public List zzEm()
    {
        return zzbax;
    }

    public List zzEn()
    {
        return zzbay;
    }

    public List zzEo()
    {
        return zzbaz;
    }

    public List zzEp()
    {
        return zzbaA;
    }

    public List zzEq()
    {
        return zzbaw;
    }

    private (List list, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9)
    {
        zzbar = Collections.unmodifiableList(list);
        zzbas = Collections.unmodifiableList(list1);
        zzbat = Collections.unmodifiableList(list2);
        zzbau = Collections.unmodifiableList(list3);
        zzbav = Collections.unmodifiableList(list4);
        zzbaw = Collections.unmodifiableList(list5);
        zzbax = Collections.unmodifiableList(list6);
        zzbay = Collections.unmodifiableList(list7);
        zzbaz = Collections.unmodifiableList(list8);
        zzbaA = Collections.unmodifiableList(list9);
    }

    zzbaA(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
            List list7, List list8, List list9, zzbaA zzbaa)
    {
        this(list, list1, list2, list3, list4, list5, list6, list7, list8, list9);
    }
}
