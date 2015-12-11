// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.f;

import com.helpshift.h.e;
import java.util.List;
import java.util.Map;

public class a
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private int g;
    private int h;
    private List i;
    private boolean j;

    a(String s, String s1, String s2, String s3, String s4, String s5, int k, 
            List list, int l, boolean flag)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = k;
        i = list;
        h = l;
        j = flag;
    }

    public static void a(String s)
    {
        s = com.helpshift.h.e.a(s);
        if (s.g() != 1)
        {
            s.a(1);
            com.helpshift.h.e.a(s);
        }
    }

    private void b(int k)
    {
        h = k;
    }

    public static void b(String s)
    {
        s = com.helpshift.h.e.a(s);
        s.b(-1);
        com.helpshift.h.e.a(s);
    }

    public static String c(String s)
    {
        String s1 = "";
        a a1 = com.helpshift.h.e.a(s);
        s = s1;
        if (a1 != null)
        {
            s = a1.a();
        }
        return s;
    }

    public static boolean d(String s)
    {
        if (((Boolean)com.helpshift.g.b.a.b.get("san")).booleanValue())
        {
            return com.helpshift.h.e.a(s).j();
        } else
        {
            return false;
        }
    }

    public String a()
    {
        return a;
    }

    public void a(int k)
    {
        g = k;
    }

    public void a(List list)
    {
        i = list;
    }

    public String b()
    {
        return b;
    }

    public String c()
    {
        return c;
    }

    public String d()
    {
        return d;
    }

    public String e()
    {
        return e;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof a)
        {
            obj = (a)obj;
            flag = flag1;
            if (a().equals(((a) (obj)).a()))
            {
                flag = flag1;
                if (b().equals(((a) (obj)).b()))
                {
                    flag = flag1;
                    if (c().equals(((a) (obj)).c()))
                    {
                        flag = flag1;
                        if (d().equals(((a) (obj)).d()))
                        {
                            flag = flag1;
                            if (e().equals(((a) (obj)).e()))
                            {
                                flag = flag1;
                                if (f().equals(((a) (obj)).f()))
                                {
                                    flag = flag1;
                                    if (g() == ((a) (obj)).g())
                                    {
                                        flag = flag1;
                                        if (h() == ((a) (obj)).h())
                                        {
                                            flag = flag1;
                                            if (i().equals(((a) (obj)).i()))
                                            {
                                                flag = flag1;
                                                if (j() == ((a) (obj)).j())
                                                {
                                                    flag = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public String f()
    {
        return f;
    }

    public int g()
    {
        return g;
    }

    public int h()
    {
        return h;
    }

    public List i()
    {
        if (i == null)
        {
            a(com.helpshift.h.e.c(b()));
        }
        return i;
    }

    public boolean j()
    {
        return j;
    }
}
