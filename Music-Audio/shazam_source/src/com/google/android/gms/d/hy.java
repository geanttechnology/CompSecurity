// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.Binder;

public abstract class hy
{
    private static interface a
    {

        public abstract Boolean a();

        public abstract Long b();

        public abstract Integer c();

        public abstract Float d();

        public abstract String e();
    }


    static a a = null;
    private static final Object d = new Object();
    private static int e = 0;
    private static String f = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    protected final String b;
    protected final Object c;
    private Object g;

    protected hy(String s, Object obj)
    {
        g = null;
        b = s;
        c = obj;
    }

    public static int a()
    {
        return e;
    }

    public static hy a(String s, Float float1)
    {
        return new hy(s, float1) {

            protected final Object c()
            {
                return hy.a.d();
            }

        };
    }

    public static hy a(String s, Integer integer)
    {
        return new hy(s, integer) {

            protected final Object c()
            {
                return hy.a.c();
            }

        };
    }

    public static hy a(String s, Long long1)
    {
        return new hy(s, long1) {

            protected final Object c()
            {
                return hy.a.b();
            }

        };
    }

    public static hy a(String s, String s1)
    {
        return new hy(s, s1) {

            protected final Object c()
            {
                return hy.a.e();
            }

        };
    }

    public static hy a(String s, boolean flag)
    {
        return new hy(s, Boolean.valueOf(flag)) {

            protected final Object c()
            {
                return hy.a.a();
            }

        };
    }

    public static boolean b()
    {
        return a != null;
    }

    protected abstract Object c();

    public final Object d()
    {
        if (g != null)
        {
            return g;
        } else
        {
            return c();
        }
    }

    public final Object e()
    {
        long l = Binder.clearCallingIdentity();
        Object obj = d();
        Binder.restoreCallingIdentity(l);
        return obj;
        Exception exception;
        exception;
        Binder.restoreCallingIdentity(l);
        throw exception;
    }

}
