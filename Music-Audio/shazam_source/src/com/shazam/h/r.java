// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public final class r extends Enum
{
    public static final class a
        implements k
    {

        public final Object deserialize(l l1, Type type, j j)
        {
            return r.a(l1.h().b());
        }

        public a()
        {
        }
    }

    public static final class b
        implements t
    {

        public final l serialize(Object obj, Type type, s s)
        {
            return new com.google.b.r(((r)obj).f);
        }

        public b()
        {
        }
    }


    public static final r a;
    public static final r b;
    public static final r c;
    public static final r d;
    public static final r e;
    private static final r g[];
    final String f;

    private r(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static r a(String s)
    {
        r ar[] = values();
        int j = ar.length;
        for (int i = 0; i < j; i++)
        {
            r r1 = ar[i];
            if (s != null && s.contains(r1.f))
            {
                return r1;
            }
        }

        throw new IllegalArgumentException((new StringBuilder("Media type parameter: ")).append(s).append(" does not match a configured MediaType").toString());
    }

    public static r valueOf(String s)
    {
        return (r)Enum.valueOf(com/shazam/h/r, s);
    }

    public static r[] values()
    {
        return (r[])g.clone();
    }

    static 
    {
        a = new r("APPLICATION_JSON", 0, "application/json");
        b = new r("APPLICATION_XML", 1, "application/xml");
        c = new r("TEXT_XML", 2, "text/xml");
        d = new r("TEXT_HTML", 3, "text/html");
        e = new r("APPLICATION_FORM_URLENCODED", 4, "application/x-www-form-urlencoded");
        g = (new r[] {
            a, b, c, d, e
        });
    }
}
