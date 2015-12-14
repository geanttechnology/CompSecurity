// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.PointF;
import android.os.Handler;

// Referenced classes of package com.photo.morph.brushes:
//            SwirlBrush

final class a
    implements Runnable
{

    private SwirlBrush a;

    public final void run()
    {
        synchronized (a.d)
        {
            SwirlBrush.a(a, a.a.x, a.a.y, a.b / 2.0F, a.c * 0.04F, 0.0F, SwirlBrush.a(a).ordinal());
        }
        SwirlBrush.c(a).postDelayed(SwirlBrush.b(a), 40L);
        return;
        exception;
        renderer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    de(SwirlBrush swirlbrush)
    {
        a = swirlbrush;
        super();
    }
}
