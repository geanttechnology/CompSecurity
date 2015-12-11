// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;

public class <init>
{

    private final HashMap zzadA;
    private boolean zzadB;
    private String zzadC;
    private final String zzadp[];
    private final ArrayList zzady;
    private final String zzadz;

    static String[] zza(<init> <init>1)
    {
        return <init>1.zzadp;
    }

    static ArrayList zzb(zzadp zzadp1)
    {
        return zzadp1.zzady;
    }

    private (String as[], String s)
    {
        zzadp = (String[])zzx.zzw(as);
        zzady = new ArrayList();
        zzadz = s;
        zzadA = new HashMap();
        zzadB = false;
        zzadC = null;
    }

    zzadC(String as[], String s, zzadC zzadc)
    {
        this(as, s);
    }
}
