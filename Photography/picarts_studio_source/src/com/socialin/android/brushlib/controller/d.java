// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.controller;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.MotionEvent;
import com.socialin.android.brushlib.Transform;
import com.socialin.android.brushlib.a;
import com.socialin.android.brushlib.input.TouchResponse;
import com.socialin.android.brushlib.layer.b;
import com.socialin.android.brushlib.overlay.EyeDropperOverlay;
import com.socialin.android.brushlib.overlay.Overlay;
import com.socialin.android.brushlib.view.DrawingView;

public final class d extends a
{

    public DrawingView b;
    public ValueAnimator c;
    Rect d;
    RectF e;
    public PointF f;
    public android.animation.ValueAnimator.AnimatorUpdateListener g;
    public android.animation.Animator.AnimatorListener h;
    private int i;

    public d(DrawingView drawingview)
    {
        c = ValueAnimator.ofFloat(new float[] {
            0.0F, 1.0F
        });
        d = new Rect();
        e = new RectF();
        f = new PointF();
        g = new android.animation.ValueAnimator.AnimatorUpdateListener() {

            private d a;

            public final void onAnimationUpdate(ValueAnimator valueanimator)
            {
                ((a) (a)).a.getTransform().setScale(((Float)valueanimator.getAnimatedValue()).floatValue());
                a.b.invalidate(a.d);
            }

            
            {
                a = d.this;
                super();
            }
        };
        h = new android.animation.Animator.AnimatorListener() {

            private d a;

            public final void onAnimationCancel(Animator animator)
            {
            }

            public final void onAnimationEnd(Animator animator)
            {
                a.e.set(((a) (a)).a.getTransformedBounds(true));
                a.e.roundOut(a.d);
                ((a) (a)).a.getTransform().setScale(1.0F);
                a.b.invalidate(a.d);
            }

            public final void onAnimationRepeat(Animator animator)
            {
            }

            public final void onAnimationStart(Animator animator)
            {
                a.e.set(((a) (a)).a.getTransformedBounds(true));
                a.e.roundOut(a.d);
                ((a) (a)).a.getTransform().setScale(0.0F);
                a.b.invalidate(a.d);
            }

            
            {
                a = d.this;
                super();
            }
        };
        b = drawingview;
    }

    private void a()
    {
        DrawingView drawingview = b;
        drawingview.setCurrentColor(((EyeDropperOverlay)super.a).getColor());
        if (drawingview.e != null)
        {
            drawingview.e.run();
        }
        if (drawingview.f != null)
        {
            drawingview.f.run();
        }
        drawingview.setEditingMode(drawingview.q);
    }

    public final TouchResponse a(MotionEvent motionevent)
    {
        int j;
        int l;
        j = motionevent.getActionMasked();
        l = motionevent.getActionIndex();
        j;
        JVM INSTR tableswitch 0 6: default 56
    //                   0 60
    //                   1 72
    //                   2 112
    //                   3 56
    //                   4 56
    //                   5 56
    //                   6 92;
           goto _L1 _L2 _L3 _L4 _L1 _L1 _L1 _L5
_L1:
        return TouchResponse.ACCEPT;
_L2:
        i = motionevent.getPointerId(0);
        continue; /* Loop/switch isn't completed */
_L3:
        if (motionevent.getPointerId(l) == i)
        {
            a();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (motionevent.getPointerId(l) == i)
        {
            a();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        float f2;
        float f3;
        int k = motionevent.findPointerIndex(i);
        if (k < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        float f1 = motionevent.getX(k);
        f3 = motionevent.getY(k) - TypedValue.applyDimension(1, EyeDropperOverlay.getRadiusDip(), b.getResources().getDisplayMetrics());
        motionevent = b.j();
        e.set(super.a.getTransformedBounds(true));
        if (f1 > ((RectF) (motionevent)).right)
        {
            f1 = (float)Math.floor(((RectF) (motionevent)).right);
        } else
        if (f1 < ((RectF) (motionevent)).left)
        {
            f1 = (float)Math.ceil(((RectF) (motionevent)).left);
        }
        if (f3 >= ((RectF) (motionevent)).top)
        {
            break; /* Loop/switch isn't completed */
        }
        f2 = (float)Math.ceil(((RectF) (motionevent)).top);
_L7:
        super.a.getTransform().setPosition(f1, f2);
        e.union(super.a.getTransformedBounds(true));
        ((EyeDropperOverlay)super.a).setColor(b.b((int)f1, (int)f2));
        e.roundOut(d);
        b.invalidate(d);
        if (true) goto _L1; else goto _L6
_L6:
        f2 = f3;
        if (f3 > ((RectF) (motionevent)).bottom)
        {
            f2 = (float)Math.floor(((RectF) (motionevent)).bottom);
        }
          goto _L7
        if (true) goto _L1; else goto _L8
_L8:
    }

    public final void a(Canvas canvas)
    {
        super.a.draw(canvas);
    }

    public final void a(Canvas canvas, b b1)
    {
    }

    public final void d()
    {
        b.invalidate();
    }
}
