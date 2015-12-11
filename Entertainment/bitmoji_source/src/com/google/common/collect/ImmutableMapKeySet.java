// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.Serializable;
import java.util.Iterator;

// Referenced classes of package com.google.common.collect:
//            ImmutableMap, ImmutableSet, ImmutableList, UnmodifiableIterator

final class ImmutableMapKeySet extends ImmutableSet.Indexed
{
    private static class KeySetSerializedForm
        implements Serializable
    {

        private static final long serialVersionUID = 0L;
        final ImmutableMap map;

        Object readResolve()
        {
            return map.keySet();
        }

        KeySetSerializedForm(ImmutableMap immutablemap)
        {
            map = immutablemap;
        }
    }


    private final ImmutableMap map;

    ImmutableMapKeySet(ImmutableMap immutablemap)
    {
        map = immutablemap;
    }

    public boolean contains(Object obj)
    {
        return map.containsKey(obj);
    }

    Object get(int i)
    {
        return ((java.util.Map.Entry)map.entrySet().asList().get(i)).getKey();
    }

    boolean isPartialView()
    {
        return true;
    }

    public UnmodifiableIterator iterator()
    {
        return map.keyIterator();
    }

    public volatile Iterator iterator()
    {
        return iterator();
    }

    public int size()
    {
        return map.size();
    }

    Object writeReplace()
    {
        return new KeySetSerializedForm(map);
    }
}
