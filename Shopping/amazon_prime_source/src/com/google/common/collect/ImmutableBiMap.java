// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;

// Referenced classes of package com.google.common.collect:
//            ImmutableMap, BiMap, EmptyImmutableBiMap, SingletonImmutableBiMap, 
//            ImmutableCollection, ImmutableSet

public abstract class ImmutableBiMap extends ImmutableMap
    implements BiMap
{

    private static final java.util.Map.Entry EMPTY_ENTRY_ARRAY[] = new java.util.Map.Entry[0];

    ImmutableBiMap()
    {
    }

    public static ImmutableBiMap of()
    {
        return EmptyImmutableBiMap.INSTANCE;
    }

    public static ImmutableBiMap of(Object obj, Object obj1)
    {
        return new SingletonImmutableBiMap(obj, obj1);
    }

    public abstract ImmutableBiMap inverse();

    public volatile ImmutableCollection values()
    {
        return values();
    }

    public ImmutableSet values()
    {
        return inverse().keySet();
    }

    public volatile Collection values()
    {
        return values();
    }

}
