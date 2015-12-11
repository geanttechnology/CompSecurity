// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Ordering, ReverseNaturalOrdering

final class NaturalOrdering extends Ordering
    implements Serializable
{

    static final NaturalOrdering INSTANCE = new NaturalOrdering();

    private NaturalOrdering()
    {
    }

    public int compare(Comparable comparable, Comparable comparable1)
    {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable1);
        return comparable.compareTo(comparable1);
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((Comparable)obj, (Comparable)obj1);
    }

    public Ordering reverse()
    {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString()
    {
        return "Ordering.natural()";
    }

}
