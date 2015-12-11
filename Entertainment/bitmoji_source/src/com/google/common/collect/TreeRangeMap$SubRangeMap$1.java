// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;

// Referenced classes of package com.google.common.collect:
//            TreeRangeMap, Range, Iterators, AbstractIterator, 
//            Cut, Maps

class bRangeMapAsMap extends bRangeMapAsMap
{

    final _cls1.endOfData this$1;

    Iterator entryIterator()
    {
        if (cess._mth200(this._cls1.this).isEmpty())
        {
            return Iterators.emptyIterator();
        } else
        {
            return new AbstractIterator() {

                final TreeRangeMap.SubRangeMap._cls1 this$2;
                final Iterator val$backingItr;

                protected volatile Object computeNext()
                {
                    return computeNext();
                }

                protected java.util.Map.Entry computeNext()
                {
                    if (backingItr.hasNext())
                    {
                        TreeRangeMap.RangeMapEntry rangemapentry = (TreeRangeMap.RangeMapEntry)backingItr.next();
                        if (rangemapentry.getUpperBound().compareTo(TreeRangeMap.SubRangeMap.access$200(this$1).lowerBound) <= 0)
                        {
                            return (java.util.Map.Entry)endOfData();
                        } else
                        {
                            return Maps.immutableEntry(rangemapentry.getKey().intersection(TreeRangeMap.SubRangeMap.access$200(this$1)), rangemapentry.getValue());
                        }
                    } else
                    {
                        return (java.util.Map.Entry)endOfData();
                    }
                }

            
            {
                this$2 = TreeRangeMap.SubRangeMap._cls1.this;
                backingItr = iterator;
                super();
            }
            };
        }
    }

    _cls1.val.backingItr()
    {
        this$1 = this._cls1.this;
        super(bRangeMapAsMap.this);
    }
}
