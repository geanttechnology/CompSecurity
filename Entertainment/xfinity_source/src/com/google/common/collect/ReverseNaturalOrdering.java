// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

// Referenced classes of package com.google.common.collect:
//            Ordering

final class ReverseNaturalOrdering extends Ordering
    implements Serializable
{

    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();

    private ReverseNaturalOrdering()
    {
    }

    private Object readResolve()
    {
        return INSTANCE;
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

    public Ordering reverse()
    {
        return Ordering.natural();
    }

    public String toString()
    {
        return "Ordering.natural().reverse()";
    }

}
