// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            AbstractIterator, Sets, Iterators

class terator extends AbstractIterator
{

    final endOfData this$0;
    final Iterator val$itr1;
    final Iterator val$itr2;

    public Object computeNext()
    {
        while (val$itr1.hasNext()) 
        {
            Object obj = val$itr1.next();
            if (!set2.contains(obj))
            {
                return obj;
            }
        }
        while (val$itr2.hasNext()) 
        {
            Object obj1 = val$itr2.next();
            if (!set1.contains(obj1))
            {
                return obj1;
            }
        }
        return endOfData();
    }

    iew()
    {
        this$0 = final_iew;
        val$itr1 = iterator;
        val$itr2 = Iterator.this;
        super();
    }

    // Unreferenced inner class com/google/common/collect/Sets$4

/* anonymous class */
    static final class Sets._cls4 extends Sets.SetView
    {

        final Set val$set1;
        final Set val$set2;

        public boolean contains(Object obj)
        {
            return set1.contains(obj) ^ set2.contains(obj);
        }

        public boolean isEmpty()
        {
            return set1.equals(set2);
        }

        public Iterator iterator()
        {
            return set2.iterator(). new Sets._cls4._cls1();
        }

        public int size()
        {
            return Iterators.size(iterator());
        }

            
            {
                set1 = set;
                set2 = set3;
                super(null);
            }
    }

}
