// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class LinkedCaseInsensitiveMap extends LinkedHashMap
{

    private final Map caseInsensitiveKeys;
    private final Locale locale;

    public LinkedCaseInsensitiveMap()
    {
        this(null);
    }

    public LinkedCaseInsensitiveMap(int i, Locale locale1)
    {
        super(i);
        caseInsensitiveKeys = new HashMap(i);
        if (locale1 == null)
        {
            locale1 = Locale.getDefault();
        }
        locale = locale1;
    }

    public LinkedCaseInsensitiveMap(Locale locale1)
    {
        caseInsensitiveKeys = new HashMap();
        if (locale1 == null)
        {
            locale1 = Locale.getDefault();
        }
        locale = locale1;
    }

    public void clear()
    {
        caseInsensitiveKeys.clear();
        super.clear();
    }

    public boolean containsKey(Object obj)
    {
        return (obj instanceof String) && caseInsensitiveKeys.containsKey(convertKey((String)obj));
    }

    protected String convertKey(String s)
    {
        return s.toLowerCase(locale);
    }

    public Object get(Object obj)
    {
        if (obj instanceof String)
        {
            return super.get(caseInsensitiveKeys.get(convertKey((String)obj)));
        } else
        {
            return null;
        }
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put((String)obj, obj1);
    }

    public Object put(String s, Object obj)
    {
        caseInsensitiveKeys.put(convertKey(s), s);
        return super.put(s, obj);
    }

    public void putAll(Map map)
    {
        if (!map.isEmpty())
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                put((String)entry.getKey(), entry.getValue());
            }
        }
    }

    public Object remove(Object obj)
    {
        if (obj instanceof String)
        {
            return super.remove(caseInsensitiveKeys.remove(convertKey((String)obj)));
        } else
        {
            return null;
        }
    }
}
