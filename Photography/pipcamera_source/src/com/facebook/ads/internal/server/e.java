// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.server;

import com.facebook.ads.internal.dto.c;

// Referenced classes of package com.facebook.ads.internal.server:
//            c

public class e extends com.facebook.ads.internal.server.c
{

    private final String a;
    private final int b;

    public e(String s, int i, c c1)
    {
        super(c.a.b, c1);
        b = i;
        a = s;
    }

    public String c()
    {
        return a;
    }

    public int d()
    {
        return b;
    }
}
