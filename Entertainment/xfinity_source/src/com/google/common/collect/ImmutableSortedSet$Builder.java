// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;

// Referenced classes of package com.google.common.collect:
//            ImmutableSortedSet

public static final class comparator extends comparator
{

    private final Comparator comparator;

    public volatile  add(Object obj)
    {
        return add(obj);
    }

    public volatile  add(Object aobj[])
    {
        return add(aobj);
    }

    public volatile add add(Object obj)
    {
        return add(obj);
    }

    public volatile add add(Object aobj[])
    {
        return add(aobj);
    }

    public add add(Object obj)
    {
        super.add(obj);
        return this;
    }

    public transient add add(Object aobj[])
    {
        super.add(aobj);
        return this;
    }

    public ImmutableSortedSet build()
    {
        return ImmutableSortedSet.access$000(comparator, contents.iterator());
    }

    public (Comparator comparator1)
    {
        comparator = (Comparator)Preconditions.checkNotNull(comparator1);
    }
}
