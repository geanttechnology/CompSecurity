// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;


public abstract class ct
{
    private static interface a
    {

        public abstract Boolean a(String s, Boolean boolean1);

        public abstract Integer a(String s, Integer integer);

        public abstract Long a(String s, Long long1);

        public abstract String a(String s, String s1);
    }


    private static final Object c = new Object();
    private static a d = null;
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String a;
    protected final Object b;
    private Object g;

    protected ct(String s, Object obj)
    {
        g = null;
        a = s;
        b = obj;
    }

    public static int a()
    {
        return e;
    }

    public static ct a(String s, Integer integer)
    {
        return new ct(s, integer) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Integer b(String s1)
            {
                return ct.d().a(a, (Integer)b);
            }

        };
    }

    public static ct a(String s, Long long1)
    {
        return new ct(s, long1) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Long b(String s1)
            {
                return ct.d().a(a, (Long)b);
            }

        };
    }

    public static ct a(String s, String s1)
    {
        return new ct(s, s1) {

            protected Object a(String s2)
            {
                return b(s2);
            }

            protected String b(String s2)
            {
                return ct.d().a(a, (String)b);
            }

        };
    }

    public static ct a(String s, boolean flag)
    {
        return new ct(s, Boolean.valueOf(flag)) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Boolean b(String s1)
            {
                return ct.d().a(a, (Boolean)b);
            }

        };
    }

    public static boolean b()
    {
        return d != null;
    }

    static a d()
    {
        return d;
    }

    protected abstract Object a(String s);

    public final Object c()
    {
        if (g != null)
        {
            return g;
        } else
        {
            return a(a);
        }
    }

}
