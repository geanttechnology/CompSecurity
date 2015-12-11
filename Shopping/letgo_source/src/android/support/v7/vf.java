// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Binder;

public abstract class vf
{
    private static interface a
    {

        public abstract Boolean a(String s, Boolean boolean1);

        public abstract Float a(String s, Float float1);

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

    protected vf(String s, Object obj)
    {
        g = null;
        a = s;
        b = obj;
    }

    public static int a()
    {
        return e;
    }

    public static vf a(String s, Float float1)
    {
        return new vf(s, float1) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Float b(String s1)
            {
                return vf.e().a(a, (Float)b);
            }

        };
    }

    public static vf a(String s, Integer integer)
    {
        return new vf(s, integer) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Integer b(String s1)
            {
                return vf.e().a(a, (Integer)b);
            }

        };
    }

    public static vf a(String s, Long long1)
    {
        return new vf(s, long1) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Long b(String s1)
            {
                return vf.e().a(a, (Long)b);
            }

        };
    }

    public static vf a(String s, String s1)
    {
        return new vf(s, s1) {

            protected Object a(String s2)
            {
                return b(s2);
            }

            protected String b(String s2)
            {
                return vf.e().a(a, (String)b);
            }

        };
    }

    public static vf a(String s, boolean flag)
    {
        return new vf(s, Boolean.valueOf(flag)) {

            protected Object a(String s1)
            {
                return b(s1);
            }

            protected Boolean b(String s1)
            {
                return vf.e().a(a, (Boolean)b);
            }

        };
    }

    public static boolean b()
    {
        return d != null;
    }

    static a e()
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

    public final Object d()
    {
        long l = Binder.clearCallingIdentity();
        Object obj = c();
        Binder.restoreCallingIdentity(l);
        return obj;
        Exception exception;
        exception;
        Binder.restoreCallingIdentity(l);
        throw exception;
    }

}
