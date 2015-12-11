// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ap;

import com.shazam.android.ay.b;
import com.shazam.android.ay.c.m;
import com.shazam.android.d.c;

// Referenced classes of package com.shazam.android.ap:
//            a

private final class <init>
    implements m
{

    final a a;

    public final void onError(b b1, c c)
    {
        switch (com.shazam.android.ap.b[b1.ordinal()])
        {
        default:
            a a1 = a;
            (new StringBuilder("Error performing recognition. Error type: ")).append(b1).append(". Error branding: ").append(c);
            a1.a();
            return;

        case 1: // '\001'
            a.b(com.shazam.android.ag.h.b.e);
            break;
        }
        a.a(com.shazam.android.ag.h.b.e);
    }

    private (a a1)
    {
        a = a1;
        super();
    }

    public a(a a1, byte byte0)
    {
        this(a1);
    }
}
