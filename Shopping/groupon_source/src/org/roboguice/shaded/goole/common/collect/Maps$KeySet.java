// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.roboguice.shaded.goole.common.base.Preconditions;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Maps

static class heckNotNull extends dAbstractSet
{

    final Map map;

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

    Map map()
    {
        return map;
    }

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

    dAbstractSet(Map map1)
    {
        map = (Map)Preconditions.checkNotNull(map1);
    }
}
