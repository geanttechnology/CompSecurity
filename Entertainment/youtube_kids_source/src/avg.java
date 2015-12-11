// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;

final class avg
    implements azy
{

    awi a;
    final auz b;
    private long c;

    public avg(auz auz)
    {
        b = auz;
        super();
        c = 0L;
    }

    public final long a()
    {
        long l = c + 1L;
        c = l;
        return l;
    }

    public final void a(String s, String s1, long l)
    {
        if (a == null)
        {
            throw new IOException("No GoogleApiClient available");
        } else
        {
            aud.c.a(a, s, s1).a(new avh(this, l));
            return;
        }
    }
}
