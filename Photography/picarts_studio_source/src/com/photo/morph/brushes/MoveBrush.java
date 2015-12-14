// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.photo.morph.brushes;

import android.graphics.PointF;

// Referenced classes of package com.photo.morph.brushes:
//            AbstractBrush

public class MoveBrush extends AbstractBrush
{

    private MoveBrush()
    {
        super(null);
    }

    public MoveBrush(byte byte0)
    {
        this();
    }

    private native void paint(float f, float f1, float f2, float f3, float f4, float f5);

    public final void b(PointF pointf)
    {
        synchronized (d)
        {
            paint(a.x, a.y, pointf.x, pointf.y, b / 2.0F, c);
        }
        super.b(pointf);
        return;
        pointf;
        renderer;
        JVM INSTR monitorexit ;
        throw pointf;
    }
}
