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

    private final Set zzaEY = new HashSet();
    private final Map zzaFj = new HashMap();
    private final Map zzaFk = new HashMap();
    private final Map zzaFl = new HashMap();
    private final Map zzaFm = new HashMap();
    private com.google.android.gms.internal.c.zzaEY zzaFn;

    public void zza(com.google.android.gms.internal.c c)
    {
        zzaEY.add(c);
    }

    public void zza(com.google.android.gms.internal.c c, com.google.android.gms.internal.c c1)
    {
        List list = (List)zzaFj.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaFj.put(c, obj);
        }
        ((List) (obj)).add(c1);
    }

    public void zza(com.google.android.gms.internal.c c, String s)
    {
        List list = (List)zzaFl.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaFl.put(c, obj);
        }
        ((List) (obj)).add(s);
    }

    public void zzb(com.google.android.gms.internal.c c)
    {
        zzaFn = c;
    }

    public void zzb(com.google.android.gms.internal.c c, com.google.android.gms.internal.c c1)
    {
        List list = (List)zzaFk.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaFk.put(c, obj);
        }
        ((List) (obj)).add(c1);
    }

    public void zzb(com.google.android.gms.internal.c c, String s)
    {
        List list = (List)zzaFm.get(c);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            zzaFm.put(c, obj);
        }
        ((List) (obj)).add(s);
    }

    public Map zzxA()
    {
        return zzaFj;
    }

    public Map zzxB()
    {
        return zzaFl;
    }

    public Map zzxC()
    {
        return zzaFm;
    }

    public Map zzxD()
    {
        return zzaFk;
    }

    public com.google.android.gms.internal.c zzxE()
    {
        return zzaFn;
    }

    public Set zzxz()
    {
        return zzaEY;
    }

    public ()
    {
    }
}
