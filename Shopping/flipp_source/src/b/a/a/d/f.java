// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.i;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            t, x, u

final class f
    implements t, x
{

    private final char a;

    f(char c)
    {
        a = c;
    }

    public final int a()
    {
        return 1;
    }

    public final int a(u u, String s, int i)
    {
        if (i >= s.length())
        {
            return ~i;
        }
        char c1 = s.charAt(i);
        char c = a;
        if (c1 != c)
        {
            c1 = Character.toUpperCase(c1);
            c = Character.toUpperCase(c);
            if (c1 != c && Character.toLowerCase(c1) != Character.toLowerCase(c))
            {
                return ~i;
            }
        }
        return i + 1;
    }

    public final void a(StringBuffer stringbuffer, long l, a a1, int i, i j, Locale locale)
    {
        stringbuffer.append(a);
    }

    public final void a(StringBuffer stringbuffer, aa aa, Locale locale)
    {
        stringbuffer.append(a);
    }

    public final int b()
    {
        return 1;
    }
}
