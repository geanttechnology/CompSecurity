// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class 
{

    private final Set zzaYC = new HashSet();
    private final Map zzaYN = new HashMap();
    private final Map zzaYO = new HashMap();
    private final Map zzaYP = new HashMap();
    private final Map zzaYQ = new HashMap();
    private com.google.android.gms.internal.c.zzaYQ zzaYR;

    public Set zzDA()
    {
        return zzaYC;
    }

    public Map zzDB()
    {
        return zzaYN;
    }

    public Map zzDC()
    {
        return zzaYP;
    }

    public Map zzDD()
    {
        return zzaYQ;
    }

    public Map zzDE()
    {
        return zzaYO;
    }

    public com.google.android.gms.internal.c zzDF()
    {
        return zzaYR;
    }

    public void zza(com.google.android.gms.internal.c c)
    {
        zzaYC.add(c);
    }

    public void zza(com.google.android.gms.internal.c c, com.google.android.gms.internal.c c1)
    {
        List list = (List)zzaYN.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaYN.put(c, obj);
        }
        ((List) (obj)).add(c1);
    }

    public void zza(com.google.android.gms.internal.c c, String s)
    {
        List list = (List)zzaYP.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaYP.put(c, obj);
        }
        ((List) (obj)).add(s);
    }

    public void zzb(com.google.android.gms.internal.c c)
    {
        zzaYR = c;
    }

    public void zzb(com.google.android.gms.internal.c c, com.google.android.gms.internal.c c1)
    {
        List list = (List)zzaYO.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaYO.put(c, obj);
        }
        ((List) (obj)).add(c1);
    }

    public void zzb(com.google.android.gms.internal.c c, String s)
    {
        List list = (List)zzaYQ.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaYQ.put(c, obj);
        }
        ((List) (obj)).add(s);
    }

    public ()
    {
    }
}
