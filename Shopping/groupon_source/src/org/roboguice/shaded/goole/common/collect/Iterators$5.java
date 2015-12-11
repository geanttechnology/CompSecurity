// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Iterators, CollectPreconditions

static final class ptyIterator
    implements Iterator
{

    Iterator current;
    Iterator removeFrom;
    final Iterator val$inputs;

    public boolean hasNext()
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

    public Object next()
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

    public void remove()
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

    nditions(Iterator iterator)
    {
        val$inputs = iterator;
        super();
        current = Iterators.emptyIterator();
    }
}
