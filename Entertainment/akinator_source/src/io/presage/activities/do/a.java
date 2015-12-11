// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;

import io.presage.activities.PresageActivity;
import io.presage.ads.d;

// Referenced classes of package io.presage.activities.do:
//            d, b

public abstract class io.presage.activities.do.a
    implements io.presage.activities.do.d
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(io/presage/activities/do/a$a, s);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("STATE_DEFAULT", 0);
            b = new a("STATE_CANCELED", 1);
            c = new a("STATE_CLOSED", 2);
            d = new a("STATE_ERRORED", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    c.a a;
    protected d b;
    private a c;
    private PresageActivity d;
    private b e;

    public io.presage.activities.do.a(c.a a1, PresageActivity presageactivity, b b1, d d1)
    {
        a = a1;
        c = a.a;
        d = presageactivity;
        b = d1;
        e = b1;
    }

    public final c.a a()
    {
        return a;
    }

    public final void a(String s)
    {
        if (s.equals("cancel"))
        {
            c = a.b;
        } else
        if (s.equals("close"))
        {
            c = a.c;
            return;
        }
    }

    public final void a(boolean flag)
    {
        if (!flag)
        {
            if (c == a.a && b != null)
            {
                c = a.b;
            }
            d.finish();
        }
    }

    public final a b()
    {
        return c;
    }

    public void c()
    {
    }

    public final void d()
    {
        c = io.presage.activities.do.a.d;
    }

    public final d e()
    {
        return b;
    }

    public final PresageActivity f()
    {
        return d;
    }
}
