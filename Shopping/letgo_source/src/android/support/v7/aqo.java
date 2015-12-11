// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.util.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public final class aqo
{
    public static abstract class a
    {

        private final ThreadLocal a = new ThreadLocal();

        private transient void a(int i, Throwable throwable, String s, Object aobj[])
        {
            if (a(i)) goto _L2; else goto _L1
_L1:
            return;
_L2:
            String s1;
            if (s != null && s.length() == 0)
            {
                s1 = null;
            } else
            {
                s1 = s;
            }
            if (s1 != null) goto _L4; else goto _L3
_L3:
            if (throwable == null) goto _L1; else goto _L5
_L5:
            aobj = Log.getStackTraceString(throwable);
_L7:
            a(i, a(), ((String) (aobj)), throwable);
            return;
_L4:
            s = s1;
            if (aobj.length > 0)
            {
                s = String.format(s1, aobj);
            }
            aobj = s;
            if (throwable != null)
            {
                aobj = (new StringBuilder()).append(s).append("\n").append(Log.getStackTraceString(throwable)).toString();
            }
            if (true) goto _L7; else goto _L6
_L6:
        }

        String a()
        {
            String s = (String)a.get();
            if (s != null)
            {
                a.remove();
            }
            return s;
        }

        protected abstract void a(int i, String s, String s1, Throwable throwable);

        public transient void a(String s, Object aobj[])
        {
            a(4, ((Throwable) (null)), s, aobj);
        }

        public transient void a(Throwable throwable, String s, Object aobj[])
        {
            a(5, throwable, s, aobj);
        }

        protected boolean a(int i)
        {
            return true;
        }

        public transient void b(String s, Object aobj[])
        {
            a(5, ((Throwable) (null)), s, aobj);
        }

        public transient void b(Throwable throwable, String s, Object aobj[])
        {
            a(6, throwable, s, aobj);
        }

        public transient void c(String s, Object aobj[])
        {
            a(6, ((Throwable) (null)), s, aobj);
        }

        public transient void d(String s, Object aobj[])
        {
            a(3, ((Throwable) (null)), s, aobj);
        }

        public a()
        {
        }
    }


    private static final List a = new CopyOnWriteArrayList();
    private static final a b = new a() {

        protected void a(int i, String s, String s1, Throwable throwable)
        {
            throw new AssertionError("Missing override for log method.");
        }

        public transient void a(String s, Object aobj[])
        {
            List list = aqo.a();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ((a)list.get(i)).a(s, aobj);
            }

        }

        public transient void a(Throwable throwable, String s, Object aobj[])
        {
            List list = aqo.a();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ((a)list.get(i)).a(throwable, s, aobj);
            }

        }

        public transient void b(String s, Object aobj[])
        {
            List list = aqo.a();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ((a)list.get(i)).b(s, aobj);
            }

        }

        public transient void b(Throwable throwable, String s, Object aobj[])
        {
            List list = aqo.a();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ((a)list.get(i)).b(throwable, s, aobj);
            }

        }

        public transient void c(String s, Object aobj[])
        {
            List list = aqo.a();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ((a)list.get(i)).c(s, aobj);
            }

        }

        public transient void d(String s, Object aobj[])
        {
            List list = aqo.a();
            int j = list.size();
            for (int i = 0; i < j; i++)
            {
                ((a)list.get(i)).d(s, aobj);
            }

        }

    };

    static List a()
    {
        return a;
    }

    public static void a(a a1)
    {
        if (a1 == null)
        {
            throw new NullPointerException("tree == null");
        }
        if (a1 == b)
        {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        } else
        {
            a.add(a1);
            return;
        }
    }

    public static transient void a(String s, Object aobj[])
    {
        b.d(s, aobj);
    }

    public static transient void a(Throwable throwable, String s, Object aobj[])
    {
        b.a(throwable, s, aobj);
    }

    public static transient void b(String s, Object aobj[])
    {
        b.a(s, aobj);
    }

    public static transient void b(Throwable throwable, String s, Object aobj[])
    {
        b.b(throwable, s, aobj);
    }

    public static transient void c(String s, Object aobj[])
    {
        b.b(s, aobj);
    }

    public static transient void d(String s, Object aobj[])
    {
        b.c(s, aobj);
    }

}
