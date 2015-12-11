// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Maps, Iterators

static class transformer extends ap
{

    final Map fromMap;
    final fromMap transformer;

    public void clear()
    {
        fromMap.clear();
    }

    public boolean containsKey(Object obj)
    {
        return fromMap.containsKey(obj);
    }

    Iterator entryIterator()
    {
        return Iterators.transform(fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(transformer));
    }

    public Object get(Object obj)
    {
        Object obj1 = fromMap.get(obj);
        if (obj1 != null || fromMap.containsKey(obj))
        {
            return transformer.formEntry(obj, obj1);
        } else
        {
            return null;
        }
    }

    public Set keySet()
    {
        return fromMap.keySet();
    }

    public Object remove(Object obj)
    {
        if (fromMap.containsKey(obj))
        {
            return transformer.formEntry(obj, fromMap.remove(obj));
        } else
        {
            return null;
        }
    }

    public int size()
    {
        return fromMap.size();
    }

    public Collection values()
    {
        return new fromMap(this);
    }

    ap(Map map, ap ap)
    {
        fromMap = (Map)Preconditions.checkNotNull(map);
        transformer = (transformer)Preconditions.checkNotNull(ap);
    }
}
