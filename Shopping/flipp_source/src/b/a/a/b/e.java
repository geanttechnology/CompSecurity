// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.l;
import b.a.a.d;
import b.a.a.o;
import java.util.Locale;

// Referenced classes of package b.a.a.b:
//            d, p

final class e extends l
{

    e()
    {
        super(d.k(), d.S(), d.T());
    }

    public final int a(Locale locale)
    {
        return p.a(locale).m;
    }

    public final long a(long l1, String s, Locale locale)
    {
        locale = p.a(locale).f;
        int i = locale.length;
        do
        {
            int j = i - 1;
            if (j >= 0)
            {
                i = j;
                if (locale[j].equalsIgnoreCase(s))
                {
                    return b(l1, j);
                }
            } else
            {
                throw new o(d.k(), s);
            }
        } while (true);
    }

    public final String a(int i, Locale locale)
    {
        return p.a(locale).f[i];
    }
}
