// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;
import org.roboguice.shaded.goole.common.base.Preconditions;

abstract class TransformedIterator
    implements Iterator
{

    final Iterator backingIterator;

    TransformedIterator(Iterator iterator)
    {
        backingIterator = (Iterator)Preconditions.checkNotNull(iterator);
    }

    public final boolean hasNext()
    {
        return backingIterator.hasNext();
    }

    public final Object next()
    {
        return transform(backingIterator.next());
    }

    public final void remove()
    {
        backingIterator.remove();
    }

    abstract Object transform(Object obj);
}
