// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class dz
    implements Map
{

    final Map a;
    final boolean b;

    public dz()
    {
        this(true);
    }

    public dz(boolean flag)
    {
        a = new HashMap();
        b = flag;
    }

    public final void clear()
    {
        a.clear();
    }

    public final boolean containsKey(Object obj)
    {
        return a.containsKey(obj);
    }

    public final boolean containsValue(Object obj)
    {
        return a.containsValue(obj);
    }

    public final Set entrySet()
    {
        return a.entrySet();
    }

    public final Object get(Object obj)
    {
        return a.get(obj);
    }

    public final boolean isEmpty()
    {
        return a.isEmpty();
    }

    public final Set keySet()
    {
        return a.keySet();
    }

    public final Object put(Object obj, Object obj1)
    {
        return a.put(obj, obj1);
    }

    public final void putAll(Map map)
    {
        a.putAll(map);
    }

    public final Object remove(Object obj)
    {
        return a.remove(obj);
    }

    public final int size()
    {
        return a.size();
    }

    public final Collection values()
    {
        return a.values();
    }
}
