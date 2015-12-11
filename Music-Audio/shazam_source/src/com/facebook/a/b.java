// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.a;

import java.io.Serializable;

// Referenced classes of package com.facebook.a:
//            a

final class b
    implements Serializable
{

    static final String a = com/facebook/a/a.getCanonicalName();
    private static final long j[] = {
        0x493e0L, 0xdbba0L, 0x1b7740L, 0x36ee80L, 0x1499700L, 0x2932e00L, 0x5265c00L, 0xa4cb800L, 0xf731400L, 0x240c8400L, 
        0x48190800L, 0x6c258c00L, 0x90321000L, 0x134fd9000L, 0x1cf7c5800L, 0x269fb2000L, 0x30479e800L, 0x39ef8b000L, 0x757b12c00L
    };
    boolean b;
    boolean c;
    long d;
    long e;
    long f;
    long g;
    int h;
    String i;

    b()
    {
        a();
    }

    static int a(long l)
    {
        int k;
        for (k = 0; k < j.length && j[k] < l; k++) { }
        return k;
    }

    final void a()
    {
        c = false;
        e = -1L;
        f = -1L;
        h = 0;
        g = 0L;
    }

}
