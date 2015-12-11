// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.NavigableMap;

// Referenced classes of package com.google.common.collect:
//            TreeRangeMap, Range

private final class entryIterable extends ap
{

    final Iterable entryIterable;
    final TreeRangeMap this$0;

    public boolean containsKey(Object obj)
    {
        return get(obj) != null;
    }

    Iterator entryIterator()
    {
        return entryIterable.iterator();
    }

    public Object get(Object obj)
    {
        if (obj instanceof Range)
        {
            obj = (Range)obj;
            entryIterable entryiterable = (entryIterable)TreeRangeMap.access$000(TreeRangeMap.this).get(((Range) (obj)).lowerBound);
            if (entryiterable != null && entryiterable.getKey().equals(obj))
            {
                return entryiterable.getValue();
            }
        }
        return null;
    }

    public int size()
    {
        return TreeRangeMap.access$000(TreeRangeMap.this).size();
    }

    ap(Iterable iterable)
    {
        this$0 = TreeRangeMap.this;
        super();
        entryIterable = iterable;
    }
}
