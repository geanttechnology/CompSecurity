// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.c;

import com.b.e.g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.b.c:
//            a, d

public class b
{

    public HashMap a;
    protected String b;
    public long c;

    public b(com.b.a.b b1)
    {
        a = new HashMap();
        b = b1.r();
        c = System.currentTimeMillis();
    }

    private void a(String s, Boolean boolean1, Boolean boolean2)
    {
        a a1 = (a)a.get(s);
        if (a1 != null && (!(a1 instanceof d) || boolean2.booleanValue() || boolean1.booleanValue()))
        {
            a.remove(s);
        }
    }

    private void b(a a1)
    {
        if (a.get(a1.a) == null)
        {
            a.put(a1.a, a1);
        }
    }

    public final String a(String as[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        HashMap hashmap = new HashMap(a);
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            String s = as[i];
            a a1 = (a)hashmap.get(s);
            if (a1 != null)
            {
                stringbuilder.append(a1.a());
                hashmap.remove(s);
            }
        }

        if (as != g.c)
        {
            as = g.c;
            int l = as.length;
            for (int j = 0; j < l; j++)
            {
                String s1 = as[j];
                a a2 = (a)hashmap.get(s1);
                if (a2 != null)
                {
                    stringbuilder.append(a2.a());
                    hashmap.remove(s1);
                }
            }

        }
        for (as = hashmap.values().iterator(); as.hasNext(); stringbuilder.append(((a)as.next()).a())) { }
        if (stringbuilder.length() > 0 && stringbuilder.charAt(0) == '&')
        {
            return stringbuilder.substring(1);
        } else
        {
            return stringbuilder.toString();
        }
    }

    public final void a(a a1)
    {
        a(a1.a, a1.c, Boolean.valueOf(a1 instanceof d));
        b(a1);
    }

    public final void a(String s, String s1, Boolean boolean1)
    {
        a(s, boolean1, Boolean.valueOf(false));
        if (Boolean.valueOf(false).booleanValue())
        {
            b(new d(s, s1, boolean1));
            return;
        } else
        {
            b(new a(s, s1, boolean1));
            return;
        }
    }

    public final void a(HashMap hashmap, boolean flag)
    {
        if (hashmap != null)
        {
            String s;
            for (Iterator iterator = hashmap.keySet().iterator(); iterator.hasNext(); a(s, (String)hashmap.get(s), Boolean.valueOf(flag)))
            {
                s = (String)iterator.next();
            }

        }
    }

    public final String b()
    {
        return b;
    }

    public final void b(String s)
    {
        b = s;
    }

    public final void b(String s, String s1)
    {
        a(s, s1, Boolean.valueOf(false));
    }
}
