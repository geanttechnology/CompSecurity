// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.f;

import android.text.TextUtils;
import com.helpshift.h.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{

    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private String i;
    private boolean j;
    private boolean k;
    private boolean l;

    c(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, boolean flag, boolean flag1, boolean flag2)
    {
        a = s;
        b = s1;
        c = s2;
        d = s3;
        e = s4;
        f = s5;
        g = s6;
        h = s7;
        i = s8;
        j = flag;
        k = flag1;
        l = flag2;
    }

    public static void a(String s, String s1)
    {
        s = com.helpshift.h.e.e(s);
        s.a(s1);
        com.helpshift.h.e.a(s);
    }

    public static void a(String s, boolean flag)
    {
        s = com.helpshift.h.e.e(s);
        s.c(flag);
        com.helpshift.h.e.a(s);
    }

    private void a(boolean flag)
    {
        j = flag;
    }

    public static List b(String s)
    {
        ArrayList arraylist = new ArrayList();
        s = com.helpshift.h.e.d(s);
        c c1;
        for (Iterator iterator = s.iterator(); iterator.hasNext(); arraylist.add(c1.b()))
        {
            c1 = (c)iterator.next();
            c1.a(true);
        }

        com.helpshift.h.e.b(s);
        return arraylist;
    }

    public static void b(String s, boolean flag)
    {
        s = com.helpshift.h.e.e(s);
        s.b(flag);
        com.helpshift.h.e.a(s);
    }

    private void b(boolean flag)
    {
        l = flag;
    }

    private void c(boolean flag)
    {
        k = flag;
    }

    public String a()
    {
        return a;
    }

    public void a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            i = "";
            return;
        } else
        {
            i = s;
            return;
        }
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
        if (obj instanceof c)
        {
            obj = (c)obj;
            flag = flag1;
            if (a().equals(((c) (obj)).a()))
            {
                flag = flag1;
                if (b().equals(((c) (obj)).b()))
                {
                    flag = flag1;
                    if (c().equals(((c) (obj)).c()))
                    {
                        flag = flag1;
                        if (d().equals(((c) (obj)).d()))
                        {
                            flag = flag1;
                            if (e().equals(((c) (obj)).e()))
                            {
                                flag = flag1;
                                if (f().equals(((c) (obj)).f()))
                                {
                                    flag = flag1;
                                    if (g().equals(((c) (obj)).g()))
                                    {
                                        flag = flag1;
                                        if (h().equals(((c) (obj)).h()))
                                        {
                                            flag = flag1;
                                            if (i().equals(((c) (obj)).i()))
                                            {
                                                flag = flag1;
                                                if (j() == ((c) (obj)).j())
                                                {
                                                    flag = flag1;
                                                    if (k() == ((c) (obj)).k())
                                                    {
                                                        flag = flag1;
                                                        if (l() == ((c) (obj)).l())
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
            }
        }
        return flag;
    }

    public String f()
    {
        return f;
    }

    public String g()
    {
        return g;
    }

    public String h()
    {
        return h;
    }

    public String i()
    {
        return i;
    }

    public boolean j()
    {
        return j;
    }

    public boolean k()
    {
        return k;
    }

    public boolean l()
    {
        return l;
    }
}
