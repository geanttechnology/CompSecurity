// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.soundcloud.java.collections;

import com.soundcloud.java.checks.Preconditions;
import java.util.Iterator;
import java.util.NoSuchElementException;

// Referenced classes of package com.soundcloud.java.collections:
//            Iterators, CollectPreconditions

final class ptyIterator
    implements Iterator
{

    Iterator current;
    Iterator removeFrom;
    final Iterator val$inputs;

    public final boolean hasNext()
    {
        do
        {
            boolean flag = ((Iterator)Preconditions.checkNotNull(current)).hasNext();
            if (!flag && val$inputs.hasNext())
            {
                current = (Iterator)val$inputs.next();
            } else
            {
                return flag;
            }
        } while (true);
    }

    public final Object next()
    {
        if (!hasNext())
        {
            throw new NoSuchElementException();
        } else
        {
            removeFrom = current;
            return current.next();
        }
    }

    public final void remove()
    {
        boolean flag;
        if (removeFrom != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        CollectPreconditions.checkRemove(flag);
        removeFrom.remove();
        removeFrom = null;
    }

    nditions()
    {
        val$inputs = iterator;
        super();
        current = Iterators.emptyIterator();
    }
}
