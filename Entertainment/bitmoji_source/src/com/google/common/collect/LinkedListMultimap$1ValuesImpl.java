// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.AbstractSequentialList;
import java.util.ListIterator;

// Referenced classes of package com.google.common.collect:
//            LinkedListMultimap, TransformedListIterator

class this._cls0 extends AbstractSequentialList
{

    final LinkedListMultimap this$0;

    public ListIterator listIterator(int i)
    {
        final  final_listiterator = new (LinkedListMultimap.this, i);
        return new TransformedListIterator(final_listiterator) {

            final LinkedListMultimap._cls1ValuesImpl this$1;
            final LinkedListMultimap.NodeIterator val$nodeItr;

            public void set(Object obj)
            {
                nodeItr.setValue(obj);
            }

            volatile Object transform(Object obj)
            {
                return transform((java.util.Map.Entry)obj);
            }

            Object transform(java.util.Map.Entry entry)
            {
                return entry.getValue();
            }

            
            {
                this$1 = LinkedListMultimap._cls1ValuesImpl.this;
                nodeItr = nodeiterator;
                super(final_listiterator);
            }
        };
    }

    public int size()
    {
        return LinkedListMultimap.access$900(LinkedListMultimap.this);
    }

    _cls1.val.nodeItr()
    {
        this$0 = LinkedListMultimap.this;
        super();
    }
}
