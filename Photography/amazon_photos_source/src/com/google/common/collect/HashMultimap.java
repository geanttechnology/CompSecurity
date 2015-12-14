// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            AbstractSetMultimap, Sets

public final class HashMultimap extends AbstractSetMultimap
{

    transient int expectedValuesPerKey;

    private HashMultimap()
    {
        super(new HashMap());
        expectedValuesPerKey = 2;
    }

    public static HashMultimap create()
    {
        return new HashMultimap();
    }

    public volatile Map asMap()
    {
        return super.asMap();
    }

    public volatile void clear()
    {
        super.clear();
    }

    public volatile boolean containsKey(Object obj)
    {
        return super.containsKey(obj);
    }

    volatile Collection createCollection()
    {
        return createCollection();
    }

    Set createCollection()
    {
        return Sets.newHashSetWithExpectedSize(expectedValuesPerKey);
    }

    public volatile boolean equals(Object obj)
    {
        return super.equals(obj);
    }

    public volatile Set get(Object obj)
    {
        return super.get(obj);
    }

    public volatile int hashCode()
    {
        return super.hashCode();
    }

    public volatile Set keySet()
    {
        return super.keySet();
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return super.put(obj, obj1);
    }

    public volatile String toString()
    {
        return super.toString();
    }
}
