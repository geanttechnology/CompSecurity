// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            AbstractIndexedListIterator, ArrayTable, AbstractMapEntry

class rator extends AbstractIndexedListIterator
{

    final _cls1.val.index this$0;

    protected volatile Object get(int i)
    {
        return get(i);
    }

    protected java.util.able.ArrayMap._cls1 get(final int index)
    {
        return new AbstractMapEntry() {

            final ArrayTable.ArrayMap._cls1 this$1;
            final int val$index;

            public Object getKey()
            {
                return ArrayTable.ArrayMap.this.getKey(index);
            }

            public Object getValue()
            {
                return ArrayTable.ArrayMap.this.getValue(index);
            }

            public Object setValue(Object obj)
            {
                return ArrayTable.ArrayMap.this.setValue(index, obj);
            }

            
            {
                this$1 = ArrayTable.ArrayMap._cls1.this;
                index = i;
                super();
            }
        };
    }

    >(int i)
    {
        this$0 = this._cls0.this;
        super(i);
    }
}
