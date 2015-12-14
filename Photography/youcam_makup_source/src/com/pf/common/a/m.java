// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.util.LongSparseArray;
import com.pf.common.utility.r;

class m
{

    private final LongSparseArray a = new LongSparseArray();
    private final r b = new r();

    m()
    {
    }

    public long a(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        long l;
        l = b.a(obj);
        a.put(l, obj1);
        this;
        JVM INSTR monitorexit ;
        return l;
        obj;
        throw obj;
    }

    public Object a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        obj = a.get(l);
        a.remove(l);
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }
}
