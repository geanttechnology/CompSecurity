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

final class m
    implements t, x
{

    private final String a;

    m(String s)
    {
        a = s;
    }

    public final int a()
    {
        return a.length();
    }

    public final int a(u u, String s, int i)
    {
        if (s.regionMatches(true, i, a, 0, a.length()))
        {
            return a.length() + i;
        } else
        {
            return ~i;
        }
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
        return a.length();
    }
}
