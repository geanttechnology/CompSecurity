// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.view;

import android.graphics.PointF;
import com.picsart.studio.editor.Camera;
import com.socialin.android.brushlib.input.gesture.h;
import com.socialin.android.brushlib.input.gesture.j;

// Referenced classes of package com.picsart.studio.editor.view:
//            MotionLassoCropView

final class i
    implements h, j
{

    private PointF a;
    private PointF b;
    private MotionLassoCropView c;

    private i(MotionLassoCropView motionlassocropview)
    {
        c = motionlassocropview;
        super();
        a = new PointF();
        b = new PointF();
    }

    i(MotionLassoCropView motionlassocropview, byte byte0)
    {
        this(motionlassocropview);
    }

    public final void a(float f, float f1)
    {
        b.set(f, f1);
        Camera camera = c.c;
        PointF pointf = b;
        camera.a(pointf, pointf);
        c.a(b.x, b.y);
    }

    public final void a_(float f, float f1)
    {
    }

    public final void b(float f, float f1)
    {
        a.set(0.0F, 0.0F);
        b.set(f, f1);
        Camera camera = c.c;
        PointF pointf = b;
        camera.a(pointf, pointf);
        c.a(b.x, b.y, true);
    }

    public final void c(float f, float f1)
    {
        if (!a.equals(0.0F, 0.0F))
        {
            b.set(f, f1);
            Camera camera = c.c;
            PointF pointf = b;
            camera.a(pointf, pointf);
            if (c.b(b.x, b.y))
            {
                c.f();
            }
        }
        a.set(b.x, b.y);
    }
}
