// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.m;
import b.a.a.d;
import b.a.a.l;
import b.a.a.o;
import java.util.Locale;
import java.util.TreeMap;

// Referenced classes of package b.a.a.b:
//            d, p, a

final class n extends m
{

    private final b.a.a.b.d b;

    n(b.a.a.b.d d1, l l)
    {
        super(d.l(), l);
        b = d1;
    }

    public final int a(long l)
    {
        return b.a.a.b.d.d(l);
    }

    protected final int a(String s, Locale locale)
    {
        locale = (Integer)p.a(locale).h.get(s);
        if (locale != null)
        {
            return locale.intValue();
        } else
        {
            throw new o(d.l(), s);
        }
    }

    public final int a(Locale locale)
    {
        return p.a(locale).k;
    }

    public final String a(int i, Locale locale)
    {
        return p.a(locale).b[i];
    }

    public final String b(int i, Locale locale)
    {
        return p.a(locale).c[i];
    }

    public final l e()
    {
        return ((a) (b)).d;
    }

    public final int g()
    {
        return 1;
    }

    public final int h()
    {
        return 7;
    }
}
