// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.d;
import b.a.a.o;
import java.util.Locale;
import java.util.TreeMap;

// Referenced classes of package b.a.a.b:
//            j, p, d

final class q extends j
{

    q(b.a.a.b.d d1)
    {
        super(d1);
    }

    protected final int a(String s, Locale locale)
    {
        locale = (Integer)p.a(locale).i.get(s);
        if (locale != null)
        {
            return locale.intValue();
        } else
        {
            throw new o(d.r(), s);
        }
    }

    public final int a(Locale locale)
    {
        return p.a(locale).l;
    }

    public final String a(int i, Locale locale)
    {
        return p.a(locale).d[i];
    }

    public final String b(int i, Locale locale)
    {
        return p.a(locale).e[i];
    }
}
