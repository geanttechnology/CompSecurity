// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.util;


public class LazyInitializer
{
    public static interface LazyFactory
    {

        public transient abstract Object createInstance(Object aobj[]);
    }


    private final LazyFactory mFactory;
    private volatile Object mInstance;
    private final Object mInstanceLock = new Object();

    public LazyInitializer(LazyFactory lazyfactory)
    {
        if (lazyfactory == null)
        {
            throw new IllegalArgumentException("factory cannot be null");
        } else
        {
            mFactory = lazyfactory;
            return;
        }
    }

    public Object get()
    {
        return get(new Object[0]);
    }

    public transient Object get(Object aobj[])
    {
        Object obj;
        obj = mInstance;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Object obj2 = mInstanceLock;
        obj2;
        JVM INSTR monitorenter ;
        Object obj1 = mInstance;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj = mFactory.createInstance(aobj);
        mInstance = obj;
        obj2;
        JVM INSTR monitorexit ;
        return obj;
        aobj;
        obj2;
        JVM INSTR monitorexit ;
        throw aobj;
        return obj;
    }
}
