// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.a.a;

import android.content.Context;
import android.util.Log;
import com.target.mothership.util.o;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class com.target.a.a.b
{
    public static class a
        implements e
    {

        public void a(int i, String s, String s1)
        {
            switch (i)
            {
            default:
                throw new RuntimeException((new StringBuilder()).append("Unknown log level '").append(i).append("'!").toString());

            case 100: // 'd'
                Log.e(s, s1);
                return;

            case 80: // 'P'
                Log.w(s, s1);
                return;

            case 60: // '<'
                Log.i(s, s1);
                return;

            case 40: // '('
                Log.d(s, s1);
                return;

            case 20: // '\024'
                Log.v(s, s1);
                return;
            }
        }

        public void a(int i, String s, String s1, Throwable throwable)
        {
            a(i, s, com.target.a.a.b.a(s1, throwable));
        }

        public a()
        {
        }
    }

    public static class b
        implements e
    {

        public static final com.google.a.a.b a = new com.google.a.a.b() {

            public volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            public String a(String s)
            {
                String s1 = s;
                if (s == null)
                {
                    s1 = "(empty message)";
                }
                return s1;
            }

        };
        public static final com.google.a.a.b b = new com.google.a.a.b() {

            public volatile Object a(Object obj)
            {
                return a((String)obj);
            }

            public String a(String s)
            {
                return o.b(s, 23);
            }

        };
        private final com.google.a.a.b c;
        private final com.google.a.a.b d;
        private final e e;

        public void a(int i, String s, String s1)
        {
            e.a(i, (String)c.a(s), (String)d.a(s1));
        }

        public void a(int i, String s, String s1, Throwable throwable)
        {
            e.a(i, (String)c.a(s), (String)d.a(s1), throwable);
        }


        public b(com.google.a.a.b b1, com.google.a.a.b b2, e e1)
        {
            c = b1;
            d = b2;
            e = e1;
        }
    }

    public static abstract class c
        implements e
    {

        protected final e mDecoratedLogger;

        public void a(int i, String s, String s1)
        {
            if (b(i, s, s1, null))
            {
                mDecoratedLogger.a(i, s, s1);
            }
        }

        public void a(int i, String s, String s1, Throwable throwable)
        {
            if (b(i, s, s1, throwable))
            {
                mDecoratedLogger.a(i, s, s1, throwable);
            }
        }

        public abstract boolean b(int i, String s, String s1, Throwable throwable);

        public c(e e1)
        {
            mDecoratedLogger = e1;
        }
    }

    private static class d
        implements e
    {

        public void a(int i, String s, String s1)
        {
            throw new IllegalStateException("Logging attempted, but Logging.initLogging() has not been called yet!");
        }

        public void a(int i, String s, String s1, Throwable throwable)
        {
            a(i, s, s1);
        }

        private d()
        {
        }

    }

    public static interface e
    {

        public abstract void a(int i, String s, String s1);

        public abstract void a(int i, String s, String s1, Throwable throwable);
    }

    public static class f
        implements e
    {

        private final CopyOnWriteArrayList a;

        public static transient f a(e ae[])
        {
            return new f(new CopyOnWriteArrayList(ae));
        }

        public void a(int i, String s, String s1)
        {
            for (Iterator iterator = a.iterator(); iterator.hasNext(); ((e)iterator.next()).a(i, s, s1)) { }
        }

        public void a(int i, String s, String s1, Throwable throwable)
        {
            for (Iterator iterator = a.iterator(); iterator.hasNext(); ((e)iterator.next()).a(i, s, s1, throwable)) { }
        }

        private f(CopyOnWriteArrayList copyonwritearraylist)
        {
            a = copyonwritearraylist;
        }
    }

    public static class g
        implements e
    {

        public void a(int i, String s, String s1)
        {
        }

        public void a(int i, String s, String s1, Throwable throwable)
        {
        }

        public g()
        {
        }
    }


    private static e a = new d();

    public static e a(Context context)
    {
        if (!context.getPackageName().endsWith(".debug"))
        {
            return new g();
        } else
        {
            return new b(b.b, b.a, f.a(new e[] {
                new a()
            }));
        }
    }

    public static String a(String s, Throwable throwable)
    {
        return (new StringBuilder()).append(s).append('\n').append(Log.getStackTraceString(throwable)).toString();
    }

    public static void a(e e1)
    {
        a = e1;
    }

    public static void a(String s, String s1)
    {
        a.a(100, s, s1);
    }

    public static void a(String s, String s1, Throwable throwable)
    {
        a.a(100, s, s1, throwable);
    }

    public static void b(String s, String s1)
    {
        a.a(80, s, s1);
    }

    public static void b(String s, String s1, Throwable throwable)
    {
        a.a(80, s, s1, throwable);
    }

    public static void c(String s, String s1)
    {
        a.a(60, s, s1);
    }

    public static void d(String s, String s1)
    {
        a.a(40, s, s1);
    }

    public static void e(String s, String s1)
    {
        a.a(20, s, s1);
    }

}
