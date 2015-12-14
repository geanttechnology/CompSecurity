// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            PanZoomViewer, q, t, ImageLoader, 
//            i

class f
    implements android.animation.imatorUpdateListener
{

    final Matrix a;
    final float b;
    final float c;
    final float d;
    final PanZoomViewer e;
    private Matrix f;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1 = valueanimator.getAnimatedFraction();
        valueanimator = new float[9];
        a.getValues(valueanimator);
        valueanimator = new PointF((b - valueanimator[2]) * f1, (c - valueanimator[5]) * f1);
        f.set(a);
        f.postTranslate(((PointF) (valueanimator)).x, ((PointF) (valueanimator)).y);
        f.preScale((d - 1.0F) * f1 + 1.0F, f1 * (d - 1.0F) + 1.0F);
        valueanimator = new float[9];
        f.getValues(valueanimator);
        f1 = valueanimator[0];
        e.m.q.e = new Matrix(f);
        e.m.q.d = f1;
        e.m.q.a = false;
        if (f1 <= e.m.q.c)
        {
            e.m.q.a = true;
        }
        e.m.q.f = e.b(e.m);
        e.o();
        valueanimator = erName.b;
        if (!((i)e.l.b.get(valueanimator)).c)
        {
            valueanimator = (i)e.l.b.get(erName.c);
            if (((i) (valueanimator)).c && ((i) (valueanimator)).d)
            {
                valueanimator = erName.c;
            } else
            {
                valueanimator = erName.a;
            }
        }
        PanZoomViewer.a(e, valueanimator, new q(e, e.m), PanZoomViewer.f(e));
    }

    erName(PanZoomViewer panzoomviewer, Matrix matrix, float f1, float f2, float f3)
    {
        e = panzoomviewer;
        a = matrix;
        b = f1;
        c = f2;
        d = f3;
        super();
        f = new Matrix();
    }
}
