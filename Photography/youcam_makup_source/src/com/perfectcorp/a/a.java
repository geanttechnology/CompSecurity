// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.perfectcorp.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class a
{

    private String a;
    private Map b;
    private int c;

    public a(String s)
    {
        a = s;
        b = null;
        c = 1;
    }

    public String a()
    {
        return a;
    }

    public void a(Map map)
    {
        Object obj = new ArrayList();
        Iterator iterator = map.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            if ((String)entry.getValue() == null)
            {
                ((List) (obj)).add(s);
            }
        } while (true);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); map.remove((String)((Iterator) (obj)).next())) { }
        if (map.size() == 0)
        {
            b = null;
            return;
        } else
        {
            b = map;
            return;
        }
    }

    public Map b()
    {
        return b;
    }

    public int c()
    {
        return c;
    }
}
