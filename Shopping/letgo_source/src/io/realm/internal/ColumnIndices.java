// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.realm.internal;

import java.util.HashMap;
import java.util.Map;

public class ColumnIndices
{

    private Map classes;

    public ColumnIndices()
    {
        classes = new HashMap();
    }

    public void addClass(Class class1, Map map)
    {
        classes.put(class1, map);
    }

    public Map getClassFields(Class class1)
    {
        return (Map)classes.get(class1);
    }

    public long getColumnIndex(Class class1, String s)
    {
        class1 = (Map)classes.get(class1);
        if (class1 != null)
        {
            class1 = (Long)class1.get(s);
            if (class1 != null)
            {
                return class1.longValue();
            } else
            {
                return -1L;
            }
        } else
        {
            return -1L;
        }
    }
}
