// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package dagger.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class UniqueMap extends LinkedHashMap
{

    public UniqueMap()
    {
    }

    public Object put(Object obj, Object obj1)
    {
        Object obj2 = super.put(obj, obj1);
        if (obj2 != null)
        {
            super.put(obj, obj2);
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate:\n    ").append(obj2).append("\n    ").append(obj1).toString());
        } else
        {
            return null;
        }
    }

    public void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); put(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }
}
