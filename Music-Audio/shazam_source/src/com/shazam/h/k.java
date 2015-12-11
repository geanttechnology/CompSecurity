// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.google.b.j;
import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import java.lang.reflect.Type;

public final class k extends Enum
{
    public static final class a
        implements com.google.b.k
    {

        public final Object deserialize(l l1, Type type, j j)
        {
            return k.a(l1.h().b());
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
            return new r(((k)obj).e);
        }

        public b()
        {
        }
    }


    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    private static final k f[];
    final String e;

    private k(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static k a(String s)
    {
        k ak[] = values();
        int j = ak.length;
        for (int i = 0; i < j; i++)
        {
            k k1 = ak[i];
            if (s != null && s.equalsIgnoreCase(k1.e))
            {
                return k1;
            }
        }

        throw new IllegalArgumentException((new StringBuilder("Http method name: ")).append(s).append(" does not match a configured HttpMethod").toString());
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/shazam/h/k, s);
    }

    public static k[] values()
    {
        return (k[])f.clone();
    }

    static 
    {
        a = new k("GET", 0, "GET");
        b = new k("POST", 1, "POST");
        c = new k("PUT", 2, "PUT");
        d = new k("DELETE", 3, "DELETE");
        f = (new k[] {
            a, b, c, d
        });
    }
}
