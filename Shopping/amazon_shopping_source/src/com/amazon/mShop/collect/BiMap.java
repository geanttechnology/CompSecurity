// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BiMap extends HashMap
    implements Map
{

    private BiMap inverse;

    public BiMap()
    {
        inverse = new BiMap(this);
    }

    private BiMap(BiMap bimap)
    {
        inverse = bimap;
    }

    private Object putEntry(Object obj, Object obj1)
    {
        return super.put(obj, obj1);
    }

    private void removeEntries()
    {
        super.clear();
    }

    public void clear()
    {
        removeEntries();
        inverse.removeEntries();
    }

    public Set entrySet()
    {
        return new AbstractSet() {

            final BiMap this$0;

            public boolean contains(Object obj)
            {
                return entrySet().contains(obj);
            }

            public boolean containsAll(Collection collection)
            {
                return entrySet().containsAll(collection);
            }

            public Iterator iterator()
            {
                return new Iterator() {

                    Iterator it;
                    final _cls1 this$1;

                    public boolean hasNext()
                    {
                        return it.hasNext();
                    }

                    public volatile Object next()
                    {
                        return next();
                    }

                    public java.util.Map.Entry next()
                    {
                        return (java.util.Map.Entry)it.next();
                    }

                    public void remove()
                    {
                        throw new UnsupportedOperationException();
                    }

            
            {
                this$1 = _cls1.this;
                super();
                it = entrySet().iterator();
            }
                };
            }

            public int size()
            {
                return entrySet().size();
            }

            
            {
                this$0 = BiMap.this;
                super();
            }
        };
    }

    public BiMap inverse()
    {
        return inverse;
    }

    public Object put(Object obj, Object obj1)
    {
        if (containsKey(obj) && inverse.containsKey(obj1) || !containsKey(obj) && !inverse.containsKey(obj1))
        {
            inverse.putEntry(obj1, obj);
            return putEntry(obj, obj1);
        } else
        {
            throw new IllegalArgumentException(String.format("Non-unique key or value used: %s=%s", new Object[] {
                obj, obj1
            }));
        }
    }

    public void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public Object remove(Object obj)
    {
        obj = super.remove(obj);
        inverse.remove(obj);
        return obj;
    }




}
