// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableBiMap, ImmutableSet

final class EmptyImmutableBiMap extends ImmutableBiMap
{

    static final EmptyImmutableBiMap INSTANCE = new EmptyImmutableBiMap();

    private EmptyImmutableBiMap()
    {
    }

    ImmutableSet createEntrySet()
    {
        throw new AssertionError("should never be called");
    }

    public ImmutableSet entrySet()
    {
        return ImmutableSet.of();
    }

    public volatile Set entrySet()
    {
        return entrySet();
    }

    public Object get(Object obj)
    {
        return null;
    }

    public ImmutableBiMap inverse()
    {
        return this;
    }

    public boolean isEmpty()
    {
        return true;
    }

    boolean isPartialView()
    {
        return false;
    }

    public ImmutableSet keySet()
    {
        return ImmutableSet.of();
    }

    public volatile Set keySet()
    {
        return keySet();
    }

    public int size()
    {
        return 0;
    }

}
