// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;

// Referenced classes of package w.panzoomview:
//            PanZoomView, i, b, j, 
//            n

class t>
    implements android.animation.AnimatorUpdateListener
{

    final aleMode a;
    final float b;
    final i c;
    final float d;
    final float e;
    final float f;
    final PointF g;
    final Matrix h;
    final float i;
    final float j;
    final float k;
    final PanZoomView l;
    private Matrix m;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        float f1 = valueanimator.getAnimatedFraction();
        PanZoomView.a(l, ewerMode.d);
        if (a == aleMode.a && b == 1.0F)
        {
            valueanimator = l.b(c.a, c.b, false);
            f1 = (f1 * (b - d) + d) / l.b.i;
            valueanimator = new PointF(e - ((j) (valueanimator)).a, f - ((j) (valueanimator)).b);
            Object obj = PanZoomView.c(l, valueanimator, g, f1);
            obj = new PointF(PanZoomView.a(l, ((n) (obj)).a), PanZoomView.b(l, ((n) (obj)).a));
            PanZoomView.d(l, valueanimator, ((PointF) (obj)), f1);
            return;
        }
        valueanimator = new float[9];
        h.getValues(valueanimator);
        if (b != l.b.h)
        {
            valueanimator = new PointF((i - valueanimator[2]) * f1, (j - valueanimator[5]) * f1);
        } else
        {
            valueanimator = new PointF(((float)l.b.d * -0.5F - valueanimator[2]) * f1, ((float)l.b.e * -0.5F - valueanimator[5]) * f1);
        }
        m.set(h);
        m.postTranslate(((PointF) (valueanimator)).x, ((PointF) (valueanimator)).y);
        m.preScale((k - 1.0F) * f1 + 1.0F, f1 * (k - 1.0F) + 1.0F);
        valueanimator = new float[9];
        m.getValues(valueanimator);
        f1 = valueanimator[0];
        l.b.j = m;
        l.b.i = f1;
        l.b.f = false;
        if (f1 <= l.b.h)
        {
            l.b.f = true;
        }
        l.b.k = l.c(l.b);
        l.invalidate();
    }

    aleMode(PanZoomView panzoomview, aleMode alemode, float f1, i i1, float f2, float f3, float f4, 
            PointF pointf, Matrix matrix, float f5, float f6, float f7)
    {
        l = panzoomview;
        a = alemode;
        b = f1;
        c = i1;
        d = f2;
        e = f3;
        f = f4;
        g = pointf;
        h = matrix;
        i = f5;
        j = f6;
        k = f7;
        super();
        m = new Matrix();
    }
}
