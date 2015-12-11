// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

// Referenced classes of package com.google.a.c:
//            c

private final class <init> extends <init>
    implements SortedSet
{

    final c b;

    public final Comparator comparator()
    {
        return ((SortedMap)super.c).comparator();
    }

    public final Object first()
    {
        return ((SortedMap)super.c).firstKey();
    }

    public final SortedSet headSet(Object obj)
    {
        return new <init>(b, ((SortedMap)super.c).headMap(obj));
    }

    public final Object last()
    {
        return ((SortedMap)super.c).lastKey();
    }

    public final SortedSet subSet(Object obj, Object obj1)
    {
        return new <init>(b, ((SortedMap)super.c).subMap(obj, obj1));
    }

    public final SortedSet tailSet(Object obj)
    {
        return new <init>(b, ((SortedMap)super.c).tailMap(obj));
    }

    (c c1, SortedMap sortedmap)
    {
        b = c1;
        super(c1, sortedmap);
    }
}
