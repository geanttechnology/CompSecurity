// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.do;

import io.presage.utils.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class e
{

    protected ArrayList a;

    public e()
    {
        a = new ArrayList();
    }

    public e(ArrayList arraylist)
    {
        a = arraylist;
    }

    private e a()
    {
        return new e((ArrayList)a.clone());
    }

    public final e a(e e1)
    {
        return a(e1.a().a);
    }

    public final e a(ArrayList arraylist)
    {
        ArrayList arraylist1;
        Iterator iterator;
        arraylist1 = (ArrayList)arraylist.clone();
        iterator = a.iterator();
_L2:
        Map map;
        boolean flag;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        map = (Map)iterator.next();
        Iterator iterator1 = arraylist.iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_111;
            }
        } while (!((Map)iterator1.next()).get("name").equals(map.get("name")));
        flag = true;
_L3:
        if (!flag)
        {
            arraylist1.add(map);
        }
        if (true) goto _L2; else goto _L1
_L1:
        return new e(arraylist1);
        flag = false;
          goto _L3
    }

    public final Object a(String s)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            Map map = (Map)iterator.next();
            if (map.get("name").equals(s))
            {
                return map.get("value");
            }
        }

        return null;
    }

    public final void a(String s, Object obj)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("name", s);
        hashmap.put("value", obj);
        a.add(hashmap);
    }

    public final String b(String s)
    {
        return m.a(a(s));
    }

    public final Object clone()
    {
        return a();
    }
}
