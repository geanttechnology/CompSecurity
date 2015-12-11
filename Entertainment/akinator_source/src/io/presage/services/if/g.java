// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.services.if;

import io.presage.utils.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package io.presage.services.if:
//            a, e

public final class g extends a
    implements io.presage.services.if.e
{

    private boolean a;
    private String b;
    private Boolean c;
    private Map d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l[];

    public g()
    {
        a = false;
        c = null;
    }

    public final void a(String s, String s1)
    {
        j = s;
        i = s1;
    }

    public final void a(Map map)
    {
        d = map;
    }

    public final void a(boolean flag)
    {
        c = Boolean.valueOf(flag);
    }

    public final void a(String as[])
    {
        l = as;
    }

    public final void b(String s)
    {
        b = s;
    }

    public final void c()
    {
        a = true;
    }

    public final void c(String s)
    {
        e = s;
    }

    public final Map d()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("first", Boolean.valueOf(a));
        StringBuilder stringbuilder;
        if (b != null)
        {
            hashmap.put("aaid", b);
            Iterator iterator;
            String s;
            if (c != null)
            {
                hashmap.put("aaid_optin", c);
            } else
            {
                hashmap.put("aaid_optin", Boolean.valueOf(true));
            }
        }
        hashmap.put("device", e);
        hashmap.put("os", f);
        hashmap.put("screen", d);
        hashmap.put("country_code", g);
        hashmap.put("language_code", h);
        hashmap.put("phone_arch", k);
        hashmap.put("vm_name", j);
        hashmap.put("vm_version", i);
        hashmap.put("declared_permissions", l);
        stringbuilder = new StringBuilder();
        for (iterator = hashmap.keySet().iterator(); iterator.hasNext(); stringbuilder.append(" "))
        {
            s = (String)iterator.next();
            stringbuilder.append(s);
            stringbuilder.append(": ");
            if (hashmap.get(s) != null)
            {
                stringbuilder.append(hashmap.get(s).toString());
            }
        }

        io.presage.utils.e.b(new String[] {
            "DEBUG", stringbuilder.toString()
        });
        return hashmap;
    }

    public final void d(String s)
    {
        f = s;
    }

    public final void e(String s)
    {
        g = s;
    }

    public final String f()
    {
        return b;
    }

    public final void f(String s)
    {
        h = s;
    }

    public final void g(String s)
    {
        k = s;
    }
}
