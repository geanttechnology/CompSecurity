// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

final class egp extends egj
    implements SortedMap
{

    private SortedSet c;
    private egi d;

    egp(egi egi, SortedMap sortedmap)
    {
        d = egi;
        super(egi, sortedmap);
    }

    public final Comparator comparator()
    {
        return ((SortedMap)a).comparator();
    }

    public final Object firstKey()
    {
        return ((SortedMap)a).firstKey();
    }

    public final SortedMap headMap(Object obj)
    {
        return new egp(d, ((SortedMap)a).headMap(obj));
    }

    public final Set keySet()
    {
        SortedSet sortedset = c;
        Object obj = sortedset;
        if (sortedset == null)
        {
            obj = new egq(d, (SortedMap)a);
            c = ((SortedSet) (obj));
        }
        return ((Set) (obj));
    }

    public final Object lastKey()
    {
        return ((SortedMap)a).lastKey();
    }

    public final SortedMap subMap(Object obj, Object obj1)
    {
        return new egp(d, ((SortedMap)a).subMap(obj, obj1));
    }

    public final SortedMap tailMap(Object obj)
    {
        return new egp(d, ((SortedMap)a).tailMap(obj));
    }
}
