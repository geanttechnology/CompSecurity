// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

public abstract class be extends o
{

    private static final String b;
    private static final String c;

    public be(String s)
    {
        super(s, new String[] {
            b, c
        });
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)
        {
            if ((com.google.android.gms.d.h.a)iterator.next() == com.google.android.gms.e.cj.f())
            {
                return cj.a(Boolean.valueOf(false));
            }
        }

        com.google.android.gms.d.h.a a1 = (com.google.android.gms.d.h.a)map.get(b);
        com.google.android.gms.d.h.a a2 = (com.google.android.gms.d.h.a)map.get(c);
        boolean flag;
        if (a1 == null || a2 == null)
        {
            flag = false;
        } else
        {
            flag = a(a1, a2, map);
        }
        return cj.a(Boolean.valueOf(flag));
    }

    public final boolean a()
    {
        return true;
    }

    protected abstract boolean a(com.google.android.gms.d.h.a a1, com.google.android.gms.d.h.a a2, Map map);

    public final volatile String b()
    {
        return super.b();
    }

    public final volatile Set c()
    {
        return super.c();
    }

    static 
    {
        b = f.p.toString();
        c = f.q.toString();
    }
}
