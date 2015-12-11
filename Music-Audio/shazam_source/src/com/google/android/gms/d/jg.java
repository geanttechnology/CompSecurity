// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.d:
//            iy

public final class jg extends iy
{

    public final List a = new ArrayList();
    public final List b = new ArrayList();
    public final Map c = new HashMap();
    public b d;

    public jg()
    {
    }

    public final void a(iy iy1)
    {
        jg jg1 = (jg)iy1;
        jg1.a.addAll(a);
        jg1.b.addAll(b);
        for (Iterator iterator = c.entrySet().iterator(); iterator.hasNext();)
        {
            iy1 = (java.util.Map.Entry)iterator.next();
            String s = (String)iy1.getKey();
            Iterator iterator1 = ((List)iy1.getValue()).iterator();
            while (iterator1.hasNext()) 
            {
                a a1 = (a)iterator1.next();
                if (a1 != null)
                {
                    if (s == null)
                    {
                        iy1 = "";
                    } else
                    {
                        iy1 = s;
                    }
                    if (!jg1.c.containsKey(iy1))
                    {
                        jg1.c.put(iy1, new ArrayList());
                    }
                    ((List)jg1.c.get(iy1)).add(a1);
                }
            }
        }

        if (d != null)
        {
            jg1.d = d;
        }
    }

    public final String toString()
    {
        HashMap hashmap = new HashMap();
        if (!a.isEmpty())
        {
            hashmap.put("products", a);
        }
        if (!b.isEmpty())
        {
            hashmap.put("promotions", b);
        }
        if (!c.isEmpty())
        {
            hashmap.put("impressions", c);
        }
        hashmap.put("productAction", d);
        return a(hashmap);
    }
}
