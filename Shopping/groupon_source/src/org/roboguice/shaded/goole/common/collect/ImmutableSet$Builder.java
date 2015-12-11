// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableSet

public static class rrayBasedBuilder extends rrayBasedBuilder
{

    public volatile rrayBasedBuilder add(Object obj)
    {
        return add(obj);
    }

    public volatile uilder add(Object obj)
    {
        return add(obj);
    }

    public add add(Object obj)
    {
        super.add(obj);
        return this;
    }

    public volatile uilder addAll(Iterable iterable)
    {
        return addAll(iterable);
    }

    public volatile uilder addAll(Iterator iterator)
    {
        return addAll(iterator);
    }

    public addAll addAll(Iterable iterable)
    {
        super.addAll(iterable);
        return this;
    }

    public rrayBasedBuilder.addAll addAll(Iterator iterator)
    {
        super.addAll(iterator);
        return this;
    }

    public ImmutableSet build()
    {
        ImmutableSet immutableset = ImmutableSet.access$000(size, contents);
        size = immutableset.size();
        return immutableset;
    }

    public uilder()
    {
        this(4);
    }

    <init>(int i)
    {
        super(i);
    }
}
