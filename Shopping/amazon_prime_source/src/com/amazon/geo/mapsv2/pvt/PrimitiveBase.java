// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

public class PrimitiveBase
    implements IObjectDelegate
{

    private final Object mWrapper;

    public PrimitiveBase(Object obj)
    {
        mWrapper = obj;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!getClass().isInstance(obj))
        {
            return false;
        } else
        {
            obj = (PrimitiveBase)obj;
            return get().equals(((PrimitiveBase) (obj)).get());
        }
    }

    public Object get()
    {
        return mWrapper;
    }

    public Object getWrapper()
    {
        return get();
    }

    public int hashCode()
    {
        return get().hashCode();
    }

    public void setWrapper(Object obj)
    {
        throw new IllegalStateException("Wrapper should be passed in, not set.");
    }

    public String toString()
    {
        return get().toString();
    }
}
