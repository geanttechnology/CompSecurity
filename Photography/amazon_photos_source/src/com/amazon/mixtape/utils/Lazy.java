// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;


public abstract class Lazy
{

    private Object mItem;

    public Lazy()
    {
    }

    public final Object get()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (mItem == null)
        {
            mItem = instantiateItem();
        }
        obj = mItem;
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    protected abstract Object instantiateItem();
}
