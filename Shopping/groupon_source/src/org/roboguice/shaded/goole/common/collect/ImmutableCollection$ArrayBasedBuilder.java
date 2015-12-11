// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableCollection, CollectPreconditions, ObjectArrays

static abstract class size extends size
{

    Object contents[];
    int size;

    private void ensureCapacity(int i)
    {
        if (contents.length < i)
        {
            contents = ObjectArrays.arraysCopyOf(contents, expandedCapacity(contents.length, i));
        }
    }

    public contents add(Object obj)
    {
        Preconditions.checkNotNull(obj);
        ensureCapacity(size + 1);
        Object aobj[] = contents;
        int i = size;
        size = i + 1;
        aobj[i] = obj;
        return this;
    }

    public volatile size add(Object obj)
    {
        return add(obj);
    }

    public add addAll(Iterable iterable)
    {
        if (iterable instanceof Collection)
        {
            Collection collection = (Collection)iterable;
            ensureCapacity(size + collection.size());
        }
        super.size(iterable);
        return this;
    }

    (int i)
    {
        CollectPreconditions.checkNonnegative(i, "initialCapacity");
        contents = new Object[i];
        size = 0;
    }
}
