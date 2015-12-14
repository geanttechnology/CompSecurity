// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package w.panzoomview;

import android.animation.Animator;
import android.graphics.Matrix;
import android.graphics.PointF;

// Referenced classes of package w.panzoomview:
//            PanZoomView, b

class a
    implements android.animation.torListener
{

    boolean a;
    final float b;
    final PanZoomView c;

    private void a()
    {
        if (b == c.b.h)
        {
            float af[] = new float[9];
            c.b.j.getValues(af);
            float f = af[0];
            float f1 = c.b.d;
            float f2 = c.b.e;
            float f4 = af[2];
            float f3 = af[5];
            f1 = (f1 * f) / 2.0F + f4 * f;
            f2 = f3 * f + (f2 * f) / 2.0F;
            f = f1;
            if (f1 < 1.0F)
            {
                f = f1;
                if (f1 > -1F)
                {
                    f = 0.0F;
                }
            }
            f1 = f2;
            if (f2 < 1.0F)
            {
                f1 = f2;
                if (f2 > -1F)
                {
                    f1 = 0.0F;
                }
            }
            PointF pointf = new PointF(0.0F, 0.0F);
            PointF pointf1 = new PointF(0.0F - f, 0.0F - f1);
            f1 = b / c.b.i;
            f = f1;
            if (f1 > 0.0F)
            {
                f = 1.0F;
            }
            if (pointf1.x != 0.0F || pointf1.y != 0.0F || f != 1.0F)
            {
                c.a(pointf, pointf1, f, true);
            }
        }
        PanZoomView.c(c, false);
        if (b == 1.0F)
        {
            c.a(new PointF(0.0F, 0.0F), new PointF(0.0F, 0.0F), b, true);
        }
        PanZoomView.a(c, ewerMode.a);
        PanZoomView.e(c);
        PanZoomView.b(c, false);
        PanZoomView.a(c, false);
    }

    public void onAnimationCancel(Animator animator)
    {
        a();
        a = true;
    }

    public void onAnimationEnd(Animator animator)
    {
        if (a)
        {
            return;
        } else
        {
            a();
            return;
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ewerMode(PanZoomView panzoomview, float f)
    {
        c = panzoomview;
        b = f;
        super();
        a = false;
    }
}
