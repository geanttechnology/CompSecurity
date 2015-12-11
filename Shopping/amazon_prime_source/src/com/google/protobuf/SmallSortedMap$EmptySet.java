// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.protobuf:
//            SmallSortedMap

private static class _cls2
{

    private static final Iterable ITERABLE = new Iterable() {

        public Iterator iterator()
        {
            return SmallSortedMap.EmptySet.ITERATOR;
        }

    };
    private static final Iterator ITERATOR = new Iterator() {

        public boolean hasNext()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

    };

    static Iterable iterable()
    {
        return ITERABLE;
    }



    private _cls2()
    {
    }
}
