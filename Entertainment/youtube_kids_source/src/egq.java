// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

final class egq extends egm
    implements SortedSet
{

    private egi c;

    egq(egi egi, SortedMap sortedmap)
    {
        c = egi;
        super(egi, sortedmap);
    }

    public final Comparator comparator()
    {
        return ((SortedMap)a).comparator();
    }

    public final Object first()
    {
        return ((SortedMap)a).firstKey();
    }

    public final SortedSet headSet(Object obj)
    {
        return new egq(c, ((SortedMap)a).headMap(obj));
    }

    public final Object last()
    {
        return ((SortedMap)a).lastKey();
    }

    public final SortedSet subSet(Object obj, Object obj1)
    {
        return new egq(c, ((SortedMap)a).subMap(obj, obj1));
    }

    public final SortedSet tailSet(Object obj)
    {
        return new egq(c, ((SortedMap)a).tailMap(obj));
    }
}
