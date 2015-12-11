// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;


// Referenced classes of package com.google.common.collect:
//            DenseImmutableTable, ImmutableMap, ImmutableSet, ImmutableList, 
//            UnmodifiableIterator, AbstractIterator, Maps

private static abstract class size extends 
{

    private final int size;

    private boolean isFull()
    {
        return size == keyToIndex().size();
    }

    ImmutableSet createKeySet()
    {
        if (isFull())
        {
            return keyToIndex().keySet();
        } else
        {
            return super.createKeySet();
        }
    }

    UnmodifiableIterator entryIterator()
    {
        return new AbstractIterator() {

            private int index;
            private final int maxIndex;
            final DenseImmutableTable.ImmutableArrayMap this$0;

            protected volatile Object computeNext()
            {
                return computeNext();
            }

            protected java.util.Map.Entry computeNext()
            {
                for (index = index + 1; index < maxIndex; index = index + 1)
                {
                    Object obj = getValue(index);
                    if (obj != null)
                    {
                        return Maps.immutableEntry(getKey(index), obj);
                    }
                }

                return (java.util.Map.Entry)endOfData();
            }

            
            {
                this$0 = DenseImmutableTable.ImmutableArrayMap.this;
                super();
                index = -1;
                maxIndex = keyToIndex().size();
            }
        };
    }

    public Object get(Object obj)
    {
        obj = (Integer)keyToIndex().get(obj);
        if (obj == null)
        {
            return null;
        } else
        {
            return getValue(((Integer) (obj)).intValue());
        }
    }

    Object getKey(int i)
    {
        return keyToIndex().keySet().asList().get(i);
    }

    abstract Object getValue(int i);

    abstract ImmutableMap keyToIndex();

    public int size()
    {
        return size;
    }

    keyToIndex(int i)
    {
        size = i;
    }
}
