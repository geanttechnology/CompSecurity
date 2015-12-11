// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            ArrayTable, ImmutableMap, ImmutableSet, ImmutableList, 
//            AbstractIndexedListIterator, AbstractMapEntry

private static abstract class <init> extends stractMap
{

    private final ImmutableMap keyIndex;

    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(Object obj)
    {
        return keyIndex.containsKey(obj);
    }

    Iterator entryIterator()
    {
        return new AbstractIndexedListIterator(size()) {

            final ArrayTable.ArrayMap this$0;

            protected volatile Object get(int i)
            {
                return get(i);
            }

            protected java.util.Map.Entry get(int i)
            {
                return i. new AbstractMapEntry() {

                    final _cls1 this$1;
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
                this$1 = final__pcls1;
                index = I.this;
                super();
            }
                };
            }

            
            {
                this$0 = ArrayTable.ArrayMap.this;
                super(i);
            }
        };
    }

    public Object get(Object obj)
    {
        obj = (Integer)keyIndex.get(obj);
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
        return keyIndex.keySet().asList().get(i);
    }

    abstract String getKeyRole();

    abstract Object getValue(int i);

    public boolean isEmpty()
    {
        return keyIndex.isEmpty();
    }

    public Set keySet()
    {
        return keyIndex.keySet();
    }

    public Object put(Object obj, Object obj1)
    {
        Object obj2 = (Integer)keyIndex.get(obj);
        if (obj2 == null)
        {
            obj1 = getKeyRole();
            obj = String.valueOf(obj);
            obj2 = String.valueOf(keyIndex.keySet());
            throw new IllegalArgumentException((new StringBuilder(String.valueOf(obj1).length() + 9 + String.valueOf(obj).length() + String.valueOf(obj2).length())).append(((String) (obj1))).append(" ").append(((String) (obj))).append(" not in ").append(((String) (obj2))).toString());
        } else
        {
            return setValue(((Integer) (obj2)).intValue(), obj1);
        }
    }

    public Object remove(Object obj)
    {
        throw new UnsupportedOperationException();
    }

    abstract Object setValue(int i, Object obj);

    public int size()
    {
        return keyIndex.size();
    }

    private terator(ImmutableMap immutablemap)
    {
        keyIndex = immutablemap;
    }

    keyIndex(ImmutableMap immutablemap, keyIndex keyindex)
    {
        this(immutablemap);
    }
}
