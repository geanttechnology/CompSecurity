// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class o
{
    public static final class a
    {

        int a;
        InputStream b;
        public Map c;

        public final a a(Map map)
        {
            if (map != null)
            {
                Iterator iterator = map.keySet().iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    String s = (String)iterator.next();
                    List list = (List)map.get(s);
                    if (s != null && list != null)
                    {
                        c.put(s.toLowerCase(), list);
                    }
                } while (true);
            }
            return this;
        }

        public final o a()
        {
            return new o(this, (byte)0);
        }

        public a()
        {
            a = -1;
            c = new HashMap();
        }
    }


    public final int a;
    public final InputStream b;
    private final Map c;

    private o(a a1)
    {
        a = a1.a;
        b = a1.b;
        c = a1.c;
    }

    o(a a1, byte byte0)
    {
        this(a1);
    }

    public final String a(String s)
    {
        s = (List)c.get(s.toLowerCase());
        if (s == null || s.isEmpty())
        {
            return null;
        } else
        {
            return (String)s.get(0);
        }
    }
}
