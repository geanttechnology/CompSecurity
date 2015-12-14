// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.socialin.android.brushlib.input.gesture.b;
import com.socialin.android.brushlib.state.a;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.controller:
//            h

final class a
    implements b
{

    private h a;

    public final void a()
    {
        a.f = null;
        a.e = null;
    }

    public final void a(float f, float f1, float f2, float f3)
    {
        a.j = a.a.c.b.a;
        a.e = new PointF(f, f1);
        a.f = new PointF(f2, f3);
        a.i = new PointF(f, f1);
        a.g = 0.0F;
        a.d = 1.0F;
    }

    public final void b(float f, float f1, float f2, float f3)
    {
        double d = com.socialin.android.brushlib.controller.h.a(a.e.x, a.e.y, a.f.x, a.f.y);
        float f5 = (float)(com.socialin.android.brushlib.controller.h.a(f, f1, f2, f3) / d);
        float f4 = f5;
        if (f5 == 0.0F)
        {
            f4 = 1.0F;
        }
        f5 = a.e.x;
        float f6 = a.e.y;
        float f7 = a.f.x;
        f3 = (float)Math.toDegrees((float)Math.atan2(f6 - a.f.y, f5 - f7) - (float)Math.atan2(f1 - f3, f - f2)) % 360F;
        f2 = f3;
        if (f3 < -180F)
        {
            f2 = f3 + 360F;
        }
        f3 = f2;
        if (f2 > 180F)
        {
            f3 = f2 - 360F;
        }
        Object obj = a;
        Object obj1 = a.j;
        f2 = -(f3 - a.g);
        f5 = f4 / a.d;
        PointF pointf = new PointF(f, f1);
        PointF pointf1 = a.i;
        PointF pointf2 = new PointF(pointf1.x, pointf1.y);
        f = pointf.x - pointf1.x;
        f1 = pointf.y - pointf1.y;
        ((h) (obj)).a.d.a(pointf2, pointf2);
        ((Matrix) (obj1)).postRotate(f2, pointf2.x, pointf2.y);
        ((Matrix) (obj1)).postScale(f5, f5, pointf2.x, pointf2.y);
        pointf1.x = pointf1.x + f;
        pointf1.y = pointf1.y + f1;
        ((Matrix) (obj1)).postTranslate(f, f1);
        f = pointf.x;
        f1 = ((h) (obj)).b.x;
        f2 = pointf.y;
        f5 = ((h) (obj)).b.y;
        obj1 = ((h) (obj)).b;
        obj1.x = (f - f1) + ((PointF) (obj1)).x;
        obj = ((h) (obj)).b;
        obj.y = ((PointF) (obj)).y + (f2 - f5);
        a.g = f3;
        a.d = f4;
    }

    w(h h1)
    {
        a = h1;
        super();
    }
}
