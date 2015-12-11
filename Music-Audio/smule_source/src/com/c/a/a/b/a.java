// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.a.b;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// Referenced classes of package com.c.a.a.b:
//            c

public abstract class a
    implements c
{

    private final Map a = Collections.synchronizedMap(new HashMap());

    public a()
    {
    }

    public Object a(Object obj)
    {
        obj = (Reference)a.get(obj);
        if (obj != null)
        {
            return ((Reference) (obj)).get();
        } else
        {
            return null;
        }
    }

    public Collection a()
    {
        HashSet hashset;
        synchronized (a)
        {
            hashset = new HashSet(a.keySet());
        }
        return hashset;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean a(Object obj, Object obj1)
    {
        a.put(obj, c(obj1));
        return true;
    }

    public void b(Object obj)
    {
        a.remove(obj);
    }

    protected abstract Reference c(Object obj);
}
