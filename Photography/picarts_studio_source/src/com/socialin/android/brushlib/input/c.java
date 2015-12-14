// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.input;

import android.graphics.PointF;

// Referenced classes of package com.socialin.android.brushlib.input:
//            a, b

final class c
    implements Runnable
{

    public PointF a;
    private a b;

    private c(a a1)
    {
        b = a1;
        super();
    }

    c(a a1, byte byte0)
    {
        this(a1);
    }

    public final void run()
    {
        if (b.b)
        {
            b.a.onLongPress(a);
        }
    }
}
