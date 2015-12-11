// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import java.io.Serializable;

// Referenced classes of package b.a.a:
//            n, a, l

public abstract class m
    implements Serializable
{

    static final m a = new n("eras", (byte)1);
    static final m b = new n("centuries", (byte)2);
    static final m c = new n("weekyears", (byte)3);
    static final m d = new n("years", (byte)4);
    static final m e = new n("months", (byte)5);
    static final m f = new n("weeks", (byte)6);
    static final m g = new n("days", (byte)7);
    static final m h = new n("halfdays", (byte)8);
    static final m i = new n("hours", (byte)9);
    static final m j = new n("minutes", (byte)10);
    static final m k = new n("seconds", (byte)11);
    static final m l = new n("millis", (byte)12);
    public final String m;

    protected m(String s)
    {
        m = s;
    }

    public static m a()
    {
        return l;
    }

    public static m b()
    {
        return k;
    }

    public static m c()
    {
        return j;
    }

    public static m d()
    {
        return i;
    }

    public static m e()
    {
        return h;
    }

    public static m f()
    {
        return g;
    }

    public static m g()
    {
        return f;
    }

    public static m h()
    {
        return c;
    }

    public static m i()
    {
        return e;
    }

    public static m j()
    {
        return d;
    }

    public static m k()
    {
        return b;
    }

    public static m l()
    {
        return a;
    }

    public abstract l a(a a1);

    public String toString()
    {
        return m;
    }

}
