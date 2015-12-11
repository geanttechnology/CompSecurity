// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.c;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            u

final class v
    implements Comparable
{

    final c a;
    final int b;
    final String c;
    final Locale d;

    v(c c1, int i)
    {
        a = c1;
        b = i;
        c = null;
        d = null;
    }

    v(c c1, String s, Locale locale)
    {
        a = c1;
        b = 0;
        c = s;
        d = locale;
    }

    public final int a(v v1)
    {
        v1 = v1.a;
        int i = u.a(a.e(), v1.e());
        if (i != 0)
        {
            return i;
        } else
        {
            return u.a(a.d(), v1.d());
        }
    }

    final long a(long l, boolean flag)
    {
        long l1;
        if (c == null)
        {
            l = a.b(l, b);
        } else
        {
            l = a.a(l, c, d);
        }
        l1 = l;
        if (flag)
        {
            l1 = a.d(l);
        }
        return l1;
    }

    public final int compareTo(Object obj)
    {
        return a((v)obj);
    }
}
