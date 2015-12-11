// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.graphics.Rect;

// Referenced classes of package com.amazon.device.ads:
//            bk, bj, c

final class b
    implements Runnable
{

    final c a;
    final Rect b;
    final bk c;

    public final void run()
    {
        c.a.e();
    }

    (bk bk1, c c1, Rect rect)
    {
        c = bk1;
        a = c1;
        b = rect;
        super();
    }
}
