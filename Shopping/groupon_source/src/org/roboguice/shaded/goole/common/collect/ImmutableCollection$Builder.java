// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            ImmutableCollection

public static abstract class 
{

    static int expandedCapacity(int i, int j)
    {
        if (j < 0)
        {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int k = (i >> 1) + i + 1;
        i = k;
        if (k < j)
        {
            i = Integer.highestOneBit(j - 1) << 1;
        }
        j = i;
        if (i < 0)
        {
            j = 0x7fffffff;
        }
        return j;
    }

    public abstract  add(Object obj);

    public  addAll(Iterable iterable)
    {
        for (iterable = iterable.iterator(); iterable.hasNext(); add(iterable.next())) { }
        return this;
    }

    public add addAll(Iterator iterator)
    {
        for (; iterator.hasNext(); add(iterator.next())) { }
        return this;
    }

    ()
    {
    }
}
