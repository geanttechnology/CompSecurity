// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.common.collect:
//            Maps

static abstract class dAbstractSet extends dAbstractSet
{

    public void clear()
    {
        map().clear();
    }

    public boolean contains(Object obj)
    {
        return map().containsKey(obj);
    }

    public boolean isEmpty()
    {
        return map().isEmpty();
    }

    public Iterator iterator()
    {
        return Maps.keyIterator(map().entrySet().iterator());
    }

    abstract Map map();

    public boolean remove(Object obj)
    {
        if (contains(obj))
        {
            map().remove(obj);
            return true;
        } else
        {
            return false;
        }
    }

    public int size()
    {
        return map().size();
    }

    dAbstractSet()
    {
    }
}
