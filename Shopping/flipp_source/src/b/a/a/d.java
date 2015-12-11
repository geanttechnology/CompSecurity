// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import java.io.Serializable;

// Referenced classes of package b.a.a:
//            e, m, a, c

public abstract class d
    implements Serializable
{

    private static final d b = new e("era", (byte)1, b.a.a.m.l(), null);
    private static final d c = new e("yearOfEra", (byte)2, b.a.a.m.j(), b.a.a.m.l());
    private static final d d = new e("centuryOfEra", (byte)3, b.a.a.m.k(), b.a.a.m.l());
    private static final d e = new e("yearOfCentury", (byte)4, b.a.a.m.j(), b.a.a.m.k());
    private static final d f = new e("year", (byte)5, b.a.a.m.j(), null);
    private static final d g = new e("dayOfYear", (byte)6, b.a.a.m.f(), b.a.a.m.j());
    private static final d h = new e("monthOfYear", (byte)7, b.a.a.m.i(), b.a.a.m.j());
    private static final d i = new e("dayOfMonth", (byte)8, b.a.a.m.f(), b.a.a.m.i());
    private static final d j = new e("weekyearOfCentury", (byte)9, b.a.a.m.h(), b.a.a.m.k());
    private static final d k = new e("weekyear", (byte)10, b.a.a.m.h(), null);
    private static final d l = new e("weekOfWeekyear", (byte)11, b.a.a.m.g(), b.a.a.m.h());
    private static final d m = new e("dayOfWeek", (byte)12, b.a.a.m.f(), b.a.a.m.g());
    private static final d n = new e("halfdayOfDay", (byte)13, b.a.a.m.e(), b.a.a.m.f());
    private static final d o = new e("hourOfHalfday", (byte)14, b.a.a.m.d(), b.a.a.m.e());
    private static final d p = new e("clockhourOfHalfday", (byte)15, b.a.a.m.d(), b.a.a.m.e());
    private static final d q = new e("clockhourOfDay", (byte)16, b.a.a.m.d(), b.a.a.m.f());
    private static final d r = new e("hourOfDay", (byte)17, b.a.a.m.d(), b.a.a.m.f());
    private static final d s = new e("minuteOfDay", (byte)18, b.a.a.m.c(), b.a.a.m.f());
    private static final d t = new e("minuteOfHour", (byte)19, b.a.a.m.c(), b.a.a.m.d());
    private static final d u = new e("secondOfDay", (byte)20, b.a.a.m.b(), b.a.a.m.f());
    private static final d v = new e("secondOfMinute", (byte)21, b.a.a.m.b(), b.a.a.m.c());
    private static final d w = new e("millisOfDay", (byte)22, b.a.a.m.a(), b.a.a.m.f());
    private static final d x = new e("millisOfSecond", (byte)23, b.a.a.m.a(), b.a.a.m.b());
    public final String a;

    protected d(String s1)
    {
        a = s1;
    }

    public static d a()
    {
        return x;
    }

    public static d b()
    {
        return w;
    }

    public static d c()
    {
        return v;
    }

    public static d d()
    {
        return u;
    }

    public static d e()
    {
        return t;
    }

    public static d f()
    {
        return s;
    }

    public static d g()
    {
        return r;
    }

    public static d h()
    {
        return q;
    }

    public static d i()
    {
        return o;
    }

    public static d j()
    {
        return p;
    }

    public static d k()
    {
        return n;
    }

    public static d l()
    {
        return m;
    }

    public static d m()
    {
        return i;
    }

    public static d n()
    {
        return g;
    }

    public static d o()
    {
        return l;
    }

    public static d p()
    {
        return k;
    }

    public static d q()
    {
        return j;
    }

    public static d r()
    {
        return h;
    }

    public static d s()
    {
        return f;
    }

    public static d t()
    {
        return c;
    }

    public static d u()
    {
        return e;
    }

    public static d v()
    {
        return d;
    }

    public static d w()
    {
        return b;
    }

    public abstract c a(a a1);

    public String toString()
    {
        return a;
    }

    public abstract m x();

    public abstract m y();

}
