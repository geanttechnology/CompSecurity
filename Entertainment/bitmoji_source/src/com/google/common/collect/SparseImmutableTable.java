// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            RegularImmutableTable, Maps, ImmutableSet, ImmutableList, 
//            ImmutableMap, ImmutableCollection

final class SparseImmutableTable extends RegularImmutableTable
{

    private final ImmutableMap columnMap;
    private final int iterationOrderColumn[];
    private final int iterationOrderRow[];
    private final ImmutableMap rowMap;

    SparseImmutableTable(ImmutableList immutablelist, ImmutableSet immutableset, ImmutableSet immutableset1)
    {
        ImmutableMap immutablemap = Maps.indexMap(immutableset);
        Object obj = Maps.newLinkedHashMap();
        for (immutableset = immutableset.iterator(); immutableset.hasNext(); ((Map) (obj)).put(immutableset.next(), new LinkedHashMap())) { }
        immutableset = Maps.newLinkedHashMap();
        for (immutableset1 = immutableset1.iterator(); immutableset1.hasNext(); immutableset.put(immutableset1.next(), new LinkedHashMap())) { }
        int ai[] = new int[immutablelist.size()];
        int ai1[] = new int[immutablelist.size()];
        for (int i = 0; i < immutablelist.size(); i++)
        {
            Object obj1 = (Table.Cell)immutablelist.get(i);
            Object obj3 = ((Table.Cell) (obj1)).getRowKey();
            immutableset1 = ((ImmutableSet) (((Table.Cell) (obj1)).getColumnKey()));
            obj1 = ((Table.Cell) (obj1)).getValue();
            ai[i] = ((Integer)immutablemap.get(obj3)).intValue();
            Object obj2 = (Map)((Map) (obj)).get(obj3);
            ai1[i] = ((Map) (obj2)).size();
            obj2 = ((Map) (obj2)).put(immutableset1, obj1);
            if (obj2 != null)
            {
                immutablelist = String.valueOf(obj3);
                immutableset = String.valueOf(immutableset1);
                immutableset1 = String.valueOf(obj1);
                obj = String.valueOf(obj2);
                throw new IllegalArgumentException((new StringBuilder(String.valueOf(immutablelist).length() + 37 + String.valueOf(immutableset).length() + String.valueOf(immutableset1).length() + String.valueOf(obj).length())).append("Duplicate value for row=").append(immutablelist).append(", column=").append(immutableset).append(": ").append(immutableset1).append(", ").append(((String) (obj))).toString());
            }
            ((Map)immutableset.get(immutableset1)).put(obj3, obj1);
        }

        iterationOrderRow = ai;
        iterationOrderColumn = ai1;
        immutablelist = new ImmutableMap.Builder(((Map) (obj)).size());
        for (immutableset1 = ((Map) (obj)).entrySet().iterator(); immutableset1.hasNext(); immutablelist.put(((java.util.Map.Entry) (obj)).getKey(), ImmutableMap.copyOf((Map)((java.util.Map.Entry) (obj)).getValue())))
        {
            obj = (java.util.Map.Entry)immutableset1.next();
        }

        rowMap = immutablelist.build();
        immutablelist = new ImmutableMap.Builder(immutableset.size());
        for (immutableset = immutableset.entrySet().iterator(); immutableset.hasNext(); immutablelist.put(immutableset1.getKey(), ImmutableMap.copyOf((Map)immutableset1.getValue())))
        {
            immutableset1 = (java.util.Map.Entry)immutableset.next();
        }

        columnMap = immutablelist.build();
    }

    public ImmutableMap columnMap()
    {
        return columnMap;
    }

    public volatile Map columnMap()
    {
        return columnMap();
    }

    Table.Cell getCell(int i)
    {
        int j = iterationOrderRow[i];
        java.util.Map.Entry entry = (java.util.Map.Entry)rowMap.entrySet().asList().get(j);
        Object obj = (ImmutableMap)entry.getValue();
        i = iterationOrderColumn[i];
        obj = (java.util.Map.Entry)((ImmutableMap) (obj)).entrySet().asList().get(i);
        return cellOf(entry.getKey(), ((java.util.Map.Entry) (obj)).getKey(), ((java.util.Map.Entry) (obj)).getValue());
    }

    Object getValue(int i)
    {
        int j = iterationOrderRow[i];
        ImmutableMap immutablemap = (ImmutableMap)rowMap.values().asList().get(j);
        i = iterationOrderColumn[i];
        return immutablemap.values().asList().get(i);
    }

    public ImmutableMap rowMap()
    {
        return rowMap;
    }

    public volatile Map rowMap()
    {
        return rowMap();
    }

    public int size()
    {
        return iterationOrderRow.length;
    }
}
