// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;


public class LazyInitializer
{
    public static interface LazyFactory
    {

        public transient abstract Object createInstance(Object aobj[]);
    }


    private LazyFactory mFactory;
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
        Object obj1;
        obj1 = mInstance;
        obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        Object obj2 = mInstanceLock;
        obj2;
        JVM INSTR monitorenter ;
        obj1 = mInstance;
        obj = obj1;
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        if (mFactory == null)
        {
            throw new IllegalStateException("LazyInitializer tried to use a factory twice!");
        }
        break MISSING_BLOCK_LABEL_54;
        aobj;
        obj2;
        JVM INSTR monitorexit ;
        throw aobj;
        aobj = ((Object []) (mFactory.createInstance(aobj)));
        mInstance = ((Object) (aobj));
        obj = ((Object) (aobj));
        if (mInstance == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        mFactory = null;
        obj = ((Object) (aobj));
        obj2;
        JVM INSTR monitorexit ;
_L2:
        return obj;
    }

    public LazyFactory reset(LazyFactory lazyfactory)
    {
        if (lazyfactory == null)
        {
            throw new IllegalArgumentException("Cannot reset with a null factory.");
        }
        Object obj = mInstanceLock;
        obj;
        JVM INSTR monitorenter ;
        if (mFactory == null)
        {
            throw new IllegalStateException("The initializer cannot be reset after get was called.");
        }
        break MISSING_BLOCK_LABEL_43;
        lazyfactory;
        obj;
        JVM INSTR monitorexit ;
        throw lazyfactory;
        LazyFactory lazyfactory1;
        lazyfactory1 = mFactory;
        mFactory = lazyfactory;
        obj;
        JVM INSTR monitorexit ;
        return lazyfactory1;
    }
}
