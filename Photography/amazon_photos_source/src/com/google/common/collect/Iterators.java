// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.google.common.collect:
//            UnmodifiableListIterator

public final class Iterators
{

    static final UnmodifiableListIterator EMPTY_LIST_ITERATOR = new UnmodifiableListIterator() {

        public boolean hasNext()
        {
            return false;
        }

        public boolean hasPrevious()
        {
            return false;
        }

        public Object next()
        {
            throw new NoSuchElementException();
        }

        public int nextIndex()
        {
            return 0;
        }

        public Object previous()
        {
            throw new NoSuchElementException();
        }

        public int previousIndex()
        {
            return -1;
        }

    };
    private static final Iterator EMPTY_MODIFIABLE_ITERATOR = new Iterator() {

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
            throw new IllegalStateException();
        }

    };

    static void checkRemove(boolean flag)
    {
        Preconditions.checkState(flag, "no calls to next() since the last call to remove()");
    }

    static void clear(Iterator iterator)
    {
        Preconditions.checkNotNull(iterator);
        for (; iterator.hasNext(); iterator.remove())
        {
            iterator.next();
        }

    }

}
