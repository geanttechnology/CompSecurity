// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.c;

import com.google.a.a.g;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.c:
//            aq

static class c extends c
{

    final Map c;

    public void clear()
    {
        c.clear();
    }

    public boolean contains(Object obj)
    {
        return c.containsKey(obj);
    }

    public boolean isEmpty()
    {
        return c.isEmpty();
    }

    public Iterator iterator()
    {
        return aq.a(c.entrySet().iterator());
    }

    public boolean remove(Object obj)
    {
        if (contains(obj))
        {
            c.remove(obj);
            return true;
        } else
        {
            return false;
        }
    }

    public int size()
    {
        return c.size();
    }

    (Map map)
    {
        c = (Map)g.a(map);
    }
}
