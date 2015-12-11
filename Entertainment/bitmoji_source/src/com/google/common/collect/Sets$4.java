// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Sets, Iterators, AbstractIterator

static final class tView extends tView
{

    final Set val$set1;
    final Set val$set2;

    public boolean contains(Object obj)
    {
        return val$set1.contains(obj) ^ val$set2.contains(obj);
    }

    public boolean isEmpty()
    {
        return val$set1.equals(val$set2);
    }

    public Iterator iterator()
    {
        return new AbstractIterator() {

            final Sets._cls4 this$0;
            final Iterator val$itr1;
            final Iterator val$itr2;

            public Object computeNext()
            {
                while (itr1.hasNext()) 
                {
                    Object obj = itr1.next();
                    if (!set2.contains(obj))
                    {
                        return obj;
                    }
                }
                while (itr2.hasNext()) 
                {
                    Object obj1 = itr2.next();
                    if (!set1.contains(obj1))
                    {
                        return obj1;
                    }
                }
                return endOfData();
            }

            
            {
                this$0 = Sets._cls4.this;
                itr1 = iterator1;
                itr2 = iterator2;
                super();
            }
        };
    }

    public int size()
    {
        return Iterators.size(iterator());
    }

    tIterator(Set set, Set set3)
    {
        val$set1 = set;
        val$set2 = set3;
        super(null);
    }
}
