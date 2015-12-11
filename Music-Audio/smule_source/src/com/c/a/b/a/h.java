// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.a;

import java.util.Comparator;

// Referenced classes of package com.c.a.b.a:
//            f

public final class h
{

    public static String a(String s, f f1)
    {
        return (new StringBuilder(s)).append("_").append(f1.a()).append("x").append(f1.b()).toString();
    }

    public static Comparator a()
    {
        return new Comparator() {

            public int a(String s, String s1)
            {
                return s.substring(0, s.lastIndexOf("_")).compareTo(s1.substring(0, s1.lastIndexOf("_")));
            }

            public int compare(Object obj, Object obj1)
            {
                return a((String)obj, (String)obj1);
            }

        };
    }
}
