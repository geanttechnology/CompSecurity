// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Ordering, ImmutableMap

final class ExplicitOrdering extends Ordering
    implements Serializable
{

    final ImmutableMap rankMap;

    ExplicitOrdering(List list)
    {
        this(buildRankMap(list));
    }

    ExplicitOrdering(ImmutableMap immutablemap)
    {
        rankMap = immutablemap;
    }

    private static ImmutableMap buildRankMap(List list)
    {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        int i = 0;
        for (list = list.iterator(); list.hasNext();)
        {
            builder.put(list.next(), Integer.valueOf(i));
            i++;
        }

        return builder.build();
    }

    private int rank(Object obj)
    {
        Integer integer = (Integer)rankMap.get(obj);
        if (integer == null)
        {
            throw new Ordering.IncomparableValueException(obj);
        } else
        {
            return integer.intValue();
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return rank(obj) - rank(obj1);
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof ExplicitOrdering)
        {
            obj = (ExplicitOrdering)obj;
            return rankMap.equals(((ExplicitOrdering) (obj)).rankMap);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return rankMap.hashCode();
    }

    public String toString()
    {
        return (new StringBuilder()).append("Ordering.explicit(").append(rankMap.keySet()).append(")").toString();
    }
}
