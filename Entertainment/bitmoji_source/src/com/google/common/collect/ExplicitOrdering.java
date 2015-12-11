// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.io.Serializable;
import java.util.List;

// Referenced classes of package com.google.common.collect:
//            Ordering, Maps, ImmutableMap

final class ExplicitOrdering extends Ordering
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    final ImmutableMap rankMap;

    ExplicitOrdering(ImmutableMap immutablemap)
    {
        rankMap = immutablemap;
    }

    ExplicitOrdering(List list)
    {
        this(Maps.indexMap(list));
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
        String s = String.valueOf(rankMap.keySet());
        return (new StringBuilder(String.valueOf(s).length() + 19)).append("Ordering.explicit(").append(s).append(")").toString();
    }
}
