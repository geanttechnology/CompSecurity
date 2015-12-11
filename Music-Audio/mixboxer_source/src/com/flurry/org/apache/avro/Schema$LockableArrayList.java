// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

static class locked extends ArrayList
{

    private static final long serialVersionUID = 1L;
    private boolean locked;

    private void ensureUnlocked()
    {
        if (locked)
        {
            throw new IllegalStateException();
        } else
        {
            return;
        }
    }

    public boolean add(Object obj)
    {
        ensureUnlocked();
        return super.add(obj);
    }

    public boolean addAll(int i, Collection collection)
    {
        ensureUnlocked();
        return super.addAll(i, collection);
    }

    public boolean addAll(Collection collection)
    {
        ensureUnlocked();
        return super.addAll(collection);
    }

    public void clear()
    {
        ensureUnlocked();
        super.clear();
    }

    public List lock()
    {
        locked = true;
        return this;
    }

    public Object remove(int i)
    {
        ensureUnlocked();
        return super.remove(i);
    }

    public boolean remove(Object obj)
    {
        ensureUnlocked();
        return super.remove(obj);
    }

    public boolean removeAll(Collection collection)
    {
        ensureUnlocked();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection)
    {
        ensureUnlocked();
        return super.retainAll(collection);
    }

    public _cls9()
    {
        locked = false;
    }

    public locked(int i)
    {
        super(i);
        locked = false;
    }

    public locked(List list)
    {
        super(list);
        locked = false;
    }
}
