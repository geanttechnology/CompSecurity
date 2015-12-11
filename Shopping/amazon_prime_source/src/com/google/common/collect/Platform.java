// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.NavigableMap;
import java.util.SortedMap;

// Referenced classes of package com.google.common.collect:
//            Maps

final class Platform
{

    private Platform()
    {
    }

    static SortedMap mapsTransformEntriesSortedMap(SortedMap sortedmap, Maps.EntryTransformer entrytransformer)
    {
        if (sortedmap instanceof NavigableMap)
        {
            return Maps.transformEntries((NavigableMap)sortedmap, entrytransformer);
        } else
        {
            return Maps.transformEntriesIgnoreNavigable(sortedmap, entrytransformer);
        }
    }

    static Object[] newArray(Object aobj[], int i)
    {
        return (Object[])(Object[])Array.newInstance(((Object) (aobj)).getClass().getComponentType(), i);
    }
}
