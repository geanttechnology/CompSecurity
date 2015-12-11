// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.tapjoy.internal:
//            ce, cd

public final class bf extends AbstractMap
{

    private final HashMap a = new HashMap();
    private final ce b = new ce();

    public bf()
    {
    }

    public static bf a()
    {
        return new bf();
    }

    private static Object a(cd cd1)
    {
        if (cd1 != null)
        {
            return cd1.get();
        } else
        {
            return null;
        }
    }

    private void b()
    {
        do
        {
            cd cd1 = b.a();
            if (cd1 != null)
            {
                a.remove(cd1.a());
            } else
            {
                return;
            }
        } while (true);
    }

    public final void clear()
    {
        a.clear();
        while (b.a() != null) ;
    }

    public final boolean containsKey(Object obj)
    {
        b();
        return a.containsKey(obj);
    }

    public final boolean containsValue(Object obj)
    {
        b();
        for (Iterator iterator = a.values().iterator(); iterator.hasNext();)
        {
            if (obj.equals(((cd)iterator.next()).get()))
            {
                return true;
            }
        }

        return false;
    }

    public final Set entrySet()
    {
        b();
        throw new UnsupportedOperationException();
    }

    public final boolean equals(Object obj)
    {
        b();
        throw new UnsupportedOperationException();
    }

    public final Object get(Object obj)
    {
        b();
        return a((cd)a.get(obj));
    }

    public final int hashCode()
    {
        b();
        throw new UnsupportedOperationException();
    }

    public final Set keySet()
    {
        b();
        return a.keySet();
    }

    public final Object put(Object obj, Object obj1)
    {
        b();
        return a((cd)a.put(obj, b.a(obj, obj1)));
    }

    public final Object remove(Object obj)
    {
        b();
        return a((cd)a.remove(obj));
    }

    public final int size()
    {
        b();
        return a.size();
    }

    public final String toString()
    {
        b();
        throw new UnsupportedOperationException();
    }

    public final Collection values()
    {
        b();
        throw new UnsupportedOperationException();
    }
}
