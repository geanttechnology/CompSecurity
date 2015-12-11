// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class ejw extends ekw
{

    ejw()
    {
    }

    abstract Map a();

    public void clear()
    {
        a().clear();
    }

    public boolean contains(Object obj)
    {
        return a().containsKey(obj);
    }

    public boolean isEmpty()
    {
        return a().isEmpty();
    }

    public Iterator iterator()
    {
        return ejr.a(a().entrySet().iterator());
    }

    public boolean remove(Object obj)
    {
        if (contains(obj))
        {
            a().remove(obj);
            return true;
        } else
        {
            return false;
        }
    }

    public int size()
    {
        return a().size();
    }
}
