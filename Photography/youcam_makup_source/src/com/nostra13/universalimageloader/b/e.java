// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.b;

import com.nostra13.universalimageloader.a.b.a;
import com.nostra13.universalimageloader.core.assist.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class e
{

    public static String a(String s, c c1)
    {
        return (new StringBuilder(s)).append("_").append(c1.a()).append("x").append(c1.b()).toString();
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

    public static List a(String s, a a1)
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = a1.a().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (String)iterator.next();
            if (s1.startsWith(s))
            {
                arraylist.add(a1.a(s1));
            }
        } while (true);
        return arraylist;
    }
}
