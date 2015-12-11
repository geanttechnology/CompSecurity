// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.roboguice.shaded.goole.common.collect:
//            Multimap, Multimaps

abstract class AbstractMultimap
    implements Multimap
{

    private transient Map asMap;
    private transient Set keySet;

    AbstractMultimap()
    {
    }

    public Map asMap()
    {
        Map map1 = asMap;
        Map map = map1;
        if (map1 == null)
        {
            map = createAsMap();
            asMap = map;
        }
        return map;
    }

    abstract Map createAsMap();

    Set createKeySet()
    {
        return new Maps.KeySet(asMap());
    }

    public boolean equals(Object obj)
    {
        return Multimaps.equalsImpl(this, obj);
    }

    public int hashCode()
    {
        return asMap().hashCode();
    }

    public Set keySet()
    {
        Set set1 = keySet;
        Set set = set1;
        if (set1 == null)
        {
            set = createKeySet();
            keySet = set;
        }
        return set;
    }

    public boolean put(Object obj, Object obj1)
    {
        return get(obj).add(obj1);
    }

    public String toString()
    {
        return asMap().toString();
    }
}
