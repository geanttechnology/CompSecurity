// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            RangeMap, TreeRangeMap, Range, Maps, 
//            Cut, Lists, Iterators, AbstractIterator

private class subRange
    implements RangeMap
{
    class SubRangeMapAsMap extends AbstractMap
    {

        final TreeRangeMap.SubRangeMap this$1;

        private boolean removeEntryIf(Predicate predicate)
        {
            java.util.ArrayList arraylist = Lists.newArrayList();
            Iterator iterator = entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                if (predicate.apply(entry))
                {
                    arraylist.add(entry.getKey());
                }
            } while (true);
            Range range;
            for (predicate = arraylist.iterator(); predicate.hasNext(); TreeRangeMap.this.remove(range))
            {
                range = (Range)predicate.next();
            }

            return !arraylist.isEmpty();
        }

        public void clear()
        {
            TreeRangeMap.SubRangeMap.this.clear();
        }

        public boolean containsKey(Object obj)
        {
            return get(obj) != null;
        }

        Iterator entryIterator()
        {
            if (subRange.isEmpty())
            {
                return Iterators.emptyIterator();
            } else
            {
                Cut cut = (Cut)MoreObjects.firstNonNull(TreeRangeMap.access$000(this$0).floorKey(subRange.lowerBound), subRange.lowerBound);
                return TreeRangeMap.access$000(this$0).tailMap(cut, true).values().iterator(). new AbstractIterator() {

                    final SubRangeMapAsMap this$2;
                    final Iterator val$backingItr;

                    protected volatile Object computeNext()
                    {
                        return computeNext();
                    }

                    protected java.util.Map.Entry computeNext()
                    {
                        while (backingItr.hasNext()) 
                        {
                            TreeRangeMap.RangeMapEntry rangemapentry = (TreeRangeMap.RangeMapEntry)backingItr.next();
                            if (rangemapentry.getLowerBound().compareTo(subRange.upperBound) >= 0)
                            {
                                return (java.util.Map.Entry)endOfData();
                            }
                            if (rangemapentry.getUpperBound().compareTo(subRange.lowerBound) > 0)
                            {
                                return Maps.immutableEntry(rangemapentry.getKey().intersection(subRange), rangemapentry.getValue());
                            }
                        }
                        return (java.util.Map.Entry)endOfData();
                    }

            
            {
                this$2 = final_subrangemapasmap;
                backingItr = Iterator.this;
                super();
            }
                };
            }
        }

        public Set entrySet()
        {
            return new Maps.EntrySet() {

                final SubRangeMapAsMap this$2;

                public boolean isEmpty()
                {
                    return !iterator().hasNext();
                }

                public Iterator iterator()
                {
      