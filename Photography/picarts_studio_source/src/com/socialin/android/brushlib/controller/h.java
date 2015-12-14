// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.view.MotionEvent;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.input.d;
import com.socialin.android.brushlib.input.gesture.a;
import com.socialin.android.brushlib.input.gesture.g;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.view.Camera;
import com.socialin.android.brushlib.view.DrawingView;

// Referenced classes of package com.socialin.android.brushlib.controller:
//            i

public final class h
    implements d
{

    public DrawingView a;
    public PointF b;
    public Matrix c;
    float d;
    PointF e;
    PointF f;
    float g;
    PointF h;
    PointF i;
    Matrix j;
    public ValueAnimator k;
    public Matrix l;
    public Matrix m;
    public Matrix n;
    private com.socialin.android.brushlib.input.gesture.d o;
    private com.socialin.android.brushlib.input.gesture.h p;
    private com.socialin.android.brushlib.input.gesture.b q;

    public h(DrawingView drawingview)
    {
        d = 1.0F;
        g = 0.0F;
        p = new com.socialin.android.brushlib.input.gesture.h() {

            private h a;

            public final void a(float f1, float f2)
            {
                a.j = a.a.c.b.a;
                a.h = new PointF(f1, f2);
            }

            public final void b(float f1, float f2)
            {
            }

            public final void c(float f1, float f2)
            {
                float f3 = f1 - a.h.x;
                float f4 = f2 - a.h.y;
                float f5 = a.b.x;
                float f6 = a.b.y;
                a.j.postTranslate(f3, f4);
                PointF pointf = a.h;
                pointf.x = f3 + pointf.x;
                pointf = a.h;
                pointf.y = f4 + pointf.y;
                pointf = a.b;
                pointf.x = pointf.x + (f1 - f5);
                pointf = a.b;
                pointf.y = pointf.y + (f2 - f6);
            }

            
            {
                a = h.this;
                super();
            }
        };
        q = new com.socialin.android.brushlib.input.gesture.b() {

            private h a;

            public final void a()
            {
                a.f = null;
                a.e = null;
            }

            public final void a(float f1, float f2, float f3, float f4)
            {
                a.j = a.a.c.b.a;
                a.e = new PointF(f1, f2);
                a.f = new PointF(f3, f4);
                a.i = new PointF(f1, f2);
                a.g = 0.0F;
                a.d = 1.0F;
            }

            public final void b(float f1, float f2, float f3, float f4)
            {
                double d1 = com.socialin.android.brushlib.controller.h.a(a.e.x, a.e.y, a.f.x, a.f.y);
                float f6 = (float)(com.socialin.android.brushlib.controller.h.a(f1, f2, f3, f4) / d1);
                float f5 = f6;
                if (f6 == 0.0F)
                {
                    f5 = 1.0F;
                }
                f6 = a.e.x;
                float f7 = a.e.y;
                float f8 = a.f.x;
                f4 = (float)Math.toDegrees((float)Math.atan2(f7 - a.f.y, f6 - f8) - (float)Math.atan2(f2 - f4, f1 - f3)) % 360F;
                f3 = f4;
                if (f4 < -180F)
                {
                    f3 = f4 + 360F;
                }
                f4 = f3;
                if (f3 > 180F)
                {
                    f4 = f3 - 360F;
                }
                Object obj = a;
                Object obj1 = a.j;
                f3 = -(f4 - a.g);
                f6 = f5 / a.d;
                PointF pointf = new PointF(f1, f2);
                PointF pointf1 = a.i;
                PointF pointf2 = new PointF(pointf1.x, pointf1.y);
                f1 = pointf.x - pointf1.x;
                f2 = pointf.y - pointf1.y;
                ((h) (obj)).a.d.a(pointf2, pointf2);
                ((Matrix) (obj1)).postRotate(f3, pointf2.x, pointf2.y);
                ((Matrix) (obj1)).postScale(f6, f6, pointf2.x, pointf2.y);
                pointf1.x = pointf1.x + f1;
                pointf1.y = pointf1.y + f2;
                ((Matrix) (obj1)).postTranslate(f1, f2);
                f1 = pointf.x;
                f2 = ((h) (obj)).b.x;
                f3 = pointf.y;
                f6 = ((h) (obj)).b.y;
                obj1 = ((h) (obj)).b;
                obj1.x = (f1 - f2) + ((PointF) (obj1)).x;
                obj = ((h) (obj)).b;
                obj.y = ((PointF) (obj)).y + (f3 - f6);
                a.g = f4;
                a.d = f5;
            }

            
            {
                a = h.this;
                super();
            }
        };
        a = drawingview;
        o = new com.socialin.android.brushlib.input.gesture.d();
        o.a(new g(p));
        o.a(new a(q));
        l = new Matrix();
        m = new Matrix();
        n = new Matrix();
        k = new ValueAnimator();
    }

    static double a(float f1, float f2, float f3, float f4)
    {
        return Math.sqrt((f2 - f4) * (f2 - f4) + (f1 - f3) * (f1 - f3));
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        o.a(motionevent);
        a.a(true);
        return TouchResponse.ACCEPT;
    }

    public final void a()
    {
        a.c.b.a.set(c);
        a.a(true);
    }

    public final void a(Matrix matrix, Matrix matrix1)
    {
        k = ValueAnimator.ofObject(new i(), new Object[] {
            matrix, matrix1
        });
        k.setDuration(300L);
        k.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener() {

            private h a;

            public final void onAnimationUpdate(ValueAnimator valueanimator)
            {
                a.a.c.b.a.set((Matrix)valueanimator.getAnimatedValue());
                a.a.a(true);
            }

            
            {
                a = h.this;
                super();
            }
        });
        k.start();
    }

    public final void b()
    {
        b b1 = a.c.b;
        if (k == null || !k.isRunning())
        {
            l = a.c.b.a;
            m.set(l);
            n.set(l);
            n.preRotate(-90F, b1.i() / 2, b1.j() / 2);
            a(m, n);
        }
    }

    public final void d()
    {
    }
}
