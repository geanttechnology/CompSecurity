// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.a;
import b.a.a.aa;
import b.a.a.c;
import b.a.a.d;
import b.a.a.i;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            k, y, e

class l extends k
{

    protected final int d;

    protected l(d d1, int i, boolean flag, int j)
    {
        super(d1, i, flag);
        d = j;
    }

    public final int a()
    {
        return b;
    }

    public final void a(StringBuffer stringbuffer, long l1, a a1, int i, i j, Locale locale)
    {
        try
        {
            b.a.a.d.y.a(stringbuffer, a.a(a1).a(l1), d);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            b.a.a.d.e.a(stringbuffer, d);
        }
    }

    public final void a(StringBuffer stringbuffer, aa aa1, Locale locale)
    {
        if (aa1.b(a))
        {
            try
            {
                b.a.a.d.y.a(stringbuffer, aa1.a(a), d);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (aa aa1) { }
        }
        b.a.a.d.e.a(stringbuffer, d);
    }
}
