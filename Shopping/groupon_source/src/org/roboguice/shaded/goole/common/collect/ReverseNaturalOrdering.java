// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Ordering, NaturalOrdering

final class ReverseNaturalOrdering extends Ordering
    implements Serializable
{

    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();

    private ReverseNaturalOrdering()
    {
    }

    public int compare(Comparable comparable, Comparable comparable1)
    {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable1)
        {
            return 0;
        } else
        {
            return comparable1.compareTo(comparable);
        }
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Comparable)obj, (Comparable)obj1);
    }

    public Comparable max(Comparable comparable, Comparable comparable1)
    {
        return (Comparable)NaturalOrdering.INSTANCE.min(comparable, comparable1);
    }

    public transient Comparable max(Comparable comparable, Comparable comparable1, Comparable comparable2, Comparable acomparable[])
    {
        return (Comparable)NaturalOrdering.INSTANCE.min(comparable, comparable1, comparable2, acomparable);
    }

    public Comparable max(Iterable iterable)
    {
        return (Comparable)NaturalOrdering.INSTANCE.min(iterable);
    }

    public Comparable max(Iterator iterator)
    {
        return (Comparable)NaturalOrdering.INSTANCE.min(iterator);
    }

    public volatile Object max(Iterable iterable)
    {
        return max(iterable);
    }

    public volatile Object max(Object obj, Object obj1)
    {
        return max((Comparable)obj, (Comparable)obj1);
    }

    public volatile Object max(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        return max((Comparable)obj, (Comparable)obj1, (Comparable)obj2, (Comparable[])aobj);
    }

    public volatile Object max(Iterator iterator)
    {
        return max(iterator);
    }

    public Comparable min(Comparable comparable, Comparable comparable1)
    {
        return (Comparable)NaturalOrdering.INSTANCE.max(comparable, comparable1);
    }

    public transient Comparable min(Comparable comparable, Comparable comparable1, Comparable comparable2, Comparable acomparable[])
    {
        return (Comparable)NaturalOrdering.INSTANCE.max(comparable, comparable1, comparable2, acomparable);
    }

    public Comparable min(Iterable iterable)
    {
        return (Comparable)NaturalOrdering.INSTANCE.max(iterable);
    }

    public Comparable min(Iterator iterator)
    {
        return (Comparable)NaturalOrdering.INSTANCE.max(iterator);
    }

    public volatile Object min(Iterable iterable)
    {
        return min(iterable);
    }

    public volatile Object min(Object obj, Object obj1)
    {
        return min((Comparable)obj, (Comparable)obj1);
    }

    public volatile Object min(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        return min((Comparable)obj, (Comparable)obj1, (Comparable)obj2, (Comparable[])aobj);
    }

    public volatile Object min(Iterator iterator)
    {
        return min(iterator);
    }

    public Ordering reverse()
    {
        return Ordering.natural();
    }

    public String toString()
    {
        return "Ordering.natural().reverse()";
    }

}
