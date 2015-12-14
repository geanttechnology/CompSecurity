// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;


public abstract class LazyWithParam
{

    private Object item;

    public LazyWithParam()
    {
    }

    public final Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (item == null)
        {
            item = instantiateItem(obj);
        }
        obj = item;
        this;
        JVM INSTR monitorexit ;
        return obj;
        obj;
        throw obj;
    }

    protected abstract Object instantiateItem(Object obj);
}
