// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;


public class SingleValueCache
{

    private Object key;
    private Object value;

    public SingleValueCache()
    {
    }

    public void clear()
    {
        key = null;
        value = null;
    }

    public Object get(Object obj)
    {
        if (key != null && key.equals(obj))
        {
            return value;
        } else
        {
            return null;
        }
    }

    public void put(Object obj, Object obj1)
    {
        if (obj == null)
        {
            throw new IllegalArgumentException("Key must not be null");
        } else
        {
            key = obj;
            value = obj1;
            return;
        }
    }

    public Object remove(Object obj)
    {
        if (key != null && key.equals(obj))
        {
            clear();
        }
        return null;
    }
}
