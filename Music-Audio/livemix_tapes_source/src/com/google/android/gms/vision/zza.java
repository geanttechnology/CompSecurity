// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;

import android.util.SparseArray;

public class zza
{

    private static int zzaVg = 0;
    private static final Object zzpm = new Object();
    private SparseArray zzaVh;
    private SparseArray zzaVi;

    public zza()
    {
        zzaVh = new SparseArray();
        zzaVi = new SparseArray();
    }

    public int zzjo(int i)
    {
        Object obj = zzpm;
        obj;
        JVM INSTR monitorenter ;
        Integer integer = (Integer)zzaVh.get(i);
        if (integer == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        i = integer.intValue();
        obj;
        JVM INSTR monitorexit ;
        return i;
        int j;
        j = zzaVg;
        zzaVg++;
        zzaVh.append(i, Integer.valueOf(j));
        zzaVi.append(j, Integer.valueOf(i));
        obj;
        JVM INSTR monitorexit ;
        return j;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public int zzjp(int i)
    {
        synchronized (zzpm)
        {
            i = ((Integer)zzaVi.get(i)).intValue();
        }
        return i;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
