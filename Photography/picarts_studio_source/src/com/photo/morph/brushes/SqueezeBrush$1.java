// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.PointF;
import android.os.Handler;

// Referenced classes of package com.photo.morph.brushes:
//            SqueezeBrush

final class a
    implements Runnable
{

    private SqueezeBrush a;

    public final void run()
    {
        synchronized (a.d)
        {
            SqueezeBrush.a(a, a.a.x, a.a.y, a.b / 2.0F, a.c * 0.04F, SqueezeBrush.a(a).ordinal());
        }
        SqueezeBrush.c(a).postDelayed(SqueezeBrush.b(a), 40L);
        return;
        exception;
        enderer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    de(SqueezeBrush squeezebrush)
    {
        a = squeezebrush;
        super();
    }
}
