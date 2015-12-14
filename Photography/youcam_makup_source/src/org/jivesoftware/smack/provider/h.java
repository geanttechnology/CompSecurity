// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.provider;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package org.jivesoftware.smack.provider:
//            e, g, d, b

public final class h
{

    private static final Map a = new ConcurrentHashMap();
    private static final Map b = new ConcurrentHashMap();

    public static Object a(String s, String s1)
    {
        s = c(s, s1);
        return b.get(s);
    }

    public static void a(String s, String s1, Object obj)
    {
        if (!(obj instanceof e) && !(obj instanceof Class))
        {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        } else
        {
            s = c(s, s1);
            a.put(s, obj);
            return;
        }
    }

    public static void a(g g1)
    {
        if (g1.a() != null)
        {
            d d1;
            for (Iterator iterator = g1.a().iterator(); iterator.hasNext(); b.put(c(d1.a(), d1.b()), d1.c()))
            {
                d1 = (d)iterator.next();
            }

        }
        if (g1.b() != null)
        {
            b b1;
            for (g1 = g1.b().iterator(); g1.hasNext(); a.put(c(b1.a(), b1.b()), b1.c()))
            {
                b1 = (b)g1.next();
            }

        }
    }

    public static Object b(String s, String s1)
    {
        s = c(s, s1);
        return a.get(s);
    }

    private static String c(String s, String s1)
    {
        return (new StringBuilder()).append(s).append('#').append(s1).toString();
    }

}
