// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import b.a.a.v;
import java.util.Locale;

// Referenced classes of package b.a.a.d:
//            am, al

public final class ac
{

    final am a;
    final al b;
    private final Locale c;
    private final v d;

    public ac(am am, al al)
    {
        a = am;
        b = al;
        c = null;
        d = null;
    }

    private ac(am am, al al, Locale locale, v v)
    {
        a = am;
        b = al;
        c = locale;
        d = v;
    }

    public final ac a(v v)
    {
        if (v == d)
        {
            return this;
        } else
        {
            return new ac(a, b, c, v);
        }
    }
}
