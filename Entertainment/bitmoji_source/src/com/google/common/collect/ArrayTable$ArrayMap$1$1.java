// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            AbstractMapEntry, ArrayTable, AbstractIndexedListIterator

class val.index extends AbstractMapEntry
{

    final val.index this$1;
    final int val$index;

    public Object getKey()
    {
        return ey(val$index);
    }

    public Object getValue()
    {
        return alue(val$index);
    }

    public Object setValue(Object obj)
    {
        return alue(val$index, obj);
    }

    tor()
    {
        this$1 = final_tor;
        val$index = I.this;
        super();
    }

    // Unreferenced inner class com/google/common/collect/ArrayTable$ArrayMap$1

/* anonymous class */
    class ArrayTable.ArrayMap._cls1 extends AbstractIndexedListIterator
    {

        final ArrayTable.ArrayMap this$0;

        protected volatile Object get(int i)
        {
            return get(i);
        }

        protected java.util.Map.Entry get(int i)
        {
            return i. new ArrayTable.ArrayMap._cls1._cls1();
        }

            
            {
                this$0 = ArrayTable.ArrayMap.this;
                super(i);
            }
    }

}
