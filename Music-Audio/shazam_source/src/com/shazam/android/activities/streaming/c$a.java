// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.streaming;

import android.view.View;
import com.facebook.c.c;
import com.facebook.c.d;

// Referenced classes of package com.shazam.android.activities.streaming:
//            c

private final class <init> extends c
{

    final com.shazam.android.activities.streaming.c a;

    private static void a(float f, View view)
    {
        view.setScaleX(f);
        view.setScaleY(f);
    }

    public final void a(d d1)
    {
        super.a(d1);
        float f = (float)d1.d.a;
        a(f, a.findViewById(0x7f110112));
        a(f, a.findViewById(0x7f110116));
    }

    private (com.shazam.android.activities.streaming.c c1)
    {
        a = c1;
        super();
    }

    a(com.shazam.android.activities.streaming.c c1, byte byte0)
    {
        this(c1);
    }
}
