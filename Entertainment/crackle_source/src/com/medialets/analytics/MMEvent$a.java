// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import java.util.Date;

// Referenced classes of package com.medialets.analytics:
//            MMEvent

static final class b
{

    private final String a;
    private final Date b;

    static String a(b b1)
    {
        return b1.a;
    }

    static Date b(a a1)
    {
        return a1.b;
    }

    public final String toString()
    {
        return a;
    }

    public (String s, Date date)
    {
        a = s;
        b = date;
    }
}
