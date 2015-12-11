// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class be extends AbstractSet
    implements Serializable, Set
{

    transient WeakHashMap a;

    public be()
    {
        this(new WeakHashMap());
    }

    private be(WeakHashMap weakhashmap)
    {
        a = weakhashmap;
    }

    public final boolean add(Object obj)
    {
        return a.put(obj, this) == null;
    }

    public final void clear()
    {
        a.clear();
    }

    public final Object clone()
    {
        be be1;
        try
        {
            be1 = (be)super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new AssertionError(clonenotsupportedexception);
        }
        return be1;
    }

    public final boolean contains(Object obj)
    {
        return a.containsKey(obj);
    }

    public final boolean isEmpty()
    {
        return a.isEmpty();
    }

    public final Iterator iterator()
    {
        return a.keySet().iterator();
    }

    public final boolean remove(Object obj)
    {
        return a.remove(obj) != null;
    }

    public final int size()
    {
        return a.size();
    }
}
