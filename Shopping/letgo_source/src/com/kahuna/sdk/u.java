// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.kahuna.sdk:
//            j, v, m

public class u
    implements j
{

    private Map a;

    protected u()
    {
        a = new HashMap();
    }

    protected u(Map map)
    {
        a = map;
    }

    public Map a()
    {
        HashMap hashmap = new HashMap();
        Iterator iterator = a.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Object obj = (Set)entry.getValue();
            if (!v.a(((Set) (obj))))
            {
                obj = new HashSet(((Collection) (obj)));
                hashmap.put(entry.getKey(), obj);
            }
        } while (true);
        return hashmap;
    }

    public void a(String s, String s1)
    {
        if (v.a(s) || v.a(s1))
        {
            if (m.s())
            {
                Log.w("Kahuna", (new StringBuilder()).append("Attempted to add invalid credentials to a UserCredentials Object. Key: ").append(v.a(s)).append(" Value:").append(v.a(s1)).toString());
            }
            return;
        }
        if (!a.containsKey(s))
        {
            a.put(s, new HashSet());
        }
        ((Set)a.get(s)).add(s1);
    }

    public boolean a(u u1)
    {
        if (u1 == null)
        {
            return false;
        }
        u1 = u1.a;
        for (Iterator iterator = a.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            Set set = (Set)entry.getValue();
            if (!u1.containsKey(entry.getKey()))
            {
                return false;
            }
            if (set.size() != ((Set)u1.get(entry.getKey())).size())
            {
                return false;
            }
            if (!set.containsAll((Collection)u1.get(entry.getKey())))
            {
                return false;
            }
        }

        return true;
    }

    public boolean b()
    {
        return a.isEmpty();
    }
}
