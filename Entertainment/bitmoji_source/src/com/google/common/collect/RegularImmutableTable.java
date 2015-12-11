// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ImmutableTable, ImmutableList, ImmutableSet, DenseImmutableTable, 
//            Ordering, SparseImmutableTable, ImmutableCollection

abstract class RegularImmutableTable extends ImmutableTable
{
    private final class CellSet extends ImmutableSet.Indexed
    {

        final RegularImmutableTable this$0;

        public boolean contains(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof Table.Cell)
            {
                obj = (Table.Cell)obj;
                Object obj1 = RegularImmutableTable.this.get(((Table.Cell) (obj)).getRowKey(), ((Table.Cell) (obj)).getColumnKey());
                flag = flag1;
                if (obj1 != null)
                {
                    flag = flag1;
                    if (obj1.equals(((Table.Cell) (obj)).getValue()))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        Table.Cell get(int i)
        {
            return getCell(i);
        }

        volatile Object get(int i)
        {
            return get(i);
        }

        boolean isPartialView()
        {
            return false;
        }

        public int size()
        {
            return RegularImmutableTable.this.size();
        }

        private CellSet()
        {
            this$0 = RegularImmutableTable.this;
            super();
        }

    }

    private final class Values extends ImmutableList
    {

        final RegularImmutableTable this$0;

        public Object get(int i)
        {
            return getValue(i);
        }

        boolean isPartialView()
        {
            return true;
        }

        public int size()
        {
            return RegularImmutableTable.this.size();
        }

        private Values()
        {
            this$0 = RegularImmutableTable.this;
            super();
        }

    }


    RegularImmutableTable()
    {
    }

    static RegularImmutableTable forCells(Iterable iterable)
    {
        return forCellsInternal(iterable, null, null);
    }

    static RegularImmutableTable forCells(List list, Comparator comparator, Comparator comparator1)
    {
        Preconditions.checkNotNull(list);
        if (comparator != null || comparator1 != null)
        {
            Collections.sort(list, new Comparator(comparator, comparator1) {

                final Comparator val$columnComparator;
                final Comparator val$rowComparator;

                public int compare(Table.Cell cell, Table.Cell cell1)
                {
                    boolean flag = false;
                    int i;
                    if (rowComparator == null)
                    {
                        i = 0;
                    } else
                    {
                        i = rowComparator.compare(cell.getRowKey(), cell1.getRowKey());
                    }
                    if (i != 0)
                    {
                        return i;
                    }
                    if (columnComparator == null)
                    {
                        i = ((flag) ? 1 : 0);
                    } else
                    {
                        i = columnComparator.compare(cell.getColumnKey(), cell1.getColumnKey());
                    }
                    return i;
                }

                public volatile int compare(Object obj, Object obj1)
                {
                    return compare((Table.Cell)obj, (Table.Cell)obj1);
                }

            
            {
                rowComparator = comparator;
                columnComparator = comparator1;
                super();
            }
            });
        }
        return forCellsInternal(list, comparator, comparator1);
    }

    private static final RegularImmutableTable forCellsInternal(Iterable iterable, Comparator comparator, Comparator comparator1)
    {
        LinkedHashSet linkedhashset1 = new LinkedHashSet();
        LinkedHashSet linkedhashset = new LinkedHashSet();
        ImmutableList immutablelist = ImmutableList.copyOf(iterable);
        Table.Cell cell;
        for (iterable = iterable.iterator(); iterable.hasNext(); linkedhashset.add(cell.getColumnKey()))
        {
            cell = (Table.Cell)iterable.next();
            linkedhashset1.add(cell.getRowKey());
        }

        if (comparator == null)
        {
            iterable = ImmutableSet.copyOf(linkedhashset1);
        } else
        {
            iterable = ImmutableSet.copyOf(Ordering.from(comparator).immutableSortedCopy(linkedhashset1));
        }
        if (comparator1 == null)
        {
            comparator = ImmutableSet.copyOf(linkedhashset);
        } else
        {
            comparator = ImmutableSet.copyOf(Ordering.from(comparator1).immutableSortedCopy(linkedhashset));
        }
        if ((long)immutablelist.size() > ((long)iterable.size() * (long)comparator.size()) / 2L)
        {
            return new DenseImmutableTable(immutablelist, iterable, comparator);
        } else
        {
            return new SparseImmutableTable(immutablelist, iterable, comparator);
        }
    }

    final ImmutableSet createCellSet()
    {
        if (isEmpty())
        {
            return ImmutableSet.of();
        } else
        {
            return new CellSet();
        }
    }

    volatile Set createCellSet()
    {
        return createCellSet();
    }

    final ImmutableCollection createValues()
    {
        if (isEmpty())
        {
            return ImmutableList.of();
        } else
        {
            return new Values();
        }
    }

    volatile Collection createValues()
    {
        return createValues();
    }

    abstract Table.Cell getCell(int i);

    abstract Object getValue(int i);
}
