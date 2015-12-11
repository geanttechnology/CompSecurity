// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class c
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        private static final a e[];
        private final int d;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/appsflyer/c$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        public int a()
        {
            return d;
        }

        static 
        {
            a = new a("NONE", 0, 0);
            b = new a("SHA1", 1, 1);
            c = new a("MD5", 2, 2);
            e = (new a[] {
                a, b, c
            });
        }

        private a(String s, int i, int j)
        {
            super(s, i);
            d = j;
        }
    }


    static ArrayList a = new ArrayList();
    private static c b = new c();
    private Map c;
    private boolean d;
    private boolean e;
    private String f;
    private boolean g;

    private c()
    {
        c = new HashMap();
    }

    public static c a()
    {
        return b;
    }

    public String a(Context context)
    {
        if (f != null)
        {
            return f;
        } else
        {
            return context.getSharedPreferences("appsflyer-data", 0).getString("referrer", null);
        }
    }

    public void a(String s, int i)
    {
        c.put(s, Integer.toString(i));
    }

    public void a(String s, String s1)
    {
        c.put(s, s1);
    }

    public void a(String s, boolean flag)
    {
        c.put(s, Boolean.toString(flag));
    }

    public void a(String s, String as[])
    {
        c.put(s, as);
    }

    public String[] a(String s)
    {
        return (String[])(String[])c.get(s);
    }

    public int b(String s, int i)
    {
        s = b(s);
        if (s == null)
        {
            return i;
        } else
        {
            return Integer.valueOf(s).intValue();
        }
    }

    public String b(String s)
    {
        return (String)c.get(s);
    }

    protected void b()
    {
        d = true;
    }

    public boolean b(String s, boolean flag)
    {
        s = b(s);
        if (s == null)
        {
            return flag;
        } else
        {
            return Boolean.valueOf(s).booleanValue();
        }
    }

    protected void c(String s)
    {
        f = s;
    }

    protected boolean c()
    {
        return e;
    }

    protected void d()
    {
        e = true;
    }

    public boolean e()
    {
        return g;
    }

}
