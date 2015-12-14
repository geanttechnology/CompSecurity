// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.camera.opengl.a;
import com.socialin.camera.opengl.h;

public class ColorSplashForegroundView extends View
{

    private static float e;
    private static int f;
    private static int g;
    private static int h;
    private static float i;
    private static float j;
    private static final int k = Color.argb(128, 0, 0, 0);
    public PointF a;
    public h b;
    public float c;
    public float d;
    private boolean l;
    private Paint m;
    private GLSurfaceView n;
    private RectF o;
    private RectF p;
    private Rect q;
    private RectF r;
    private float s;
    private int t;
    private PickerState u;
    private Handler v;

    public ColorSplashForegroundView(Context context)
    {
        super(context);
        a = new PointF();
        l = true;
        m = new Paint();
        o = new RectF();
        q = new Rect();
        r = new RectF();
        s = 1.0F;
        t = 0xff000000;
        u = PickerState.CLOSED;
        v = new Handler(Looper.getMainLooper());
        a(context);
    }

    public ColorSplashForegroundView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new PointF();
        l = true;
        m = new Paint();
        o = new RectF();
        q = new Rect();
        r = new RectF();
        s = 1.0F;
        t = 0xff000000;
        u = PickerState.CLOSED;
        v = new Handler(Looper.getMainLooper());
        a(context);
    }

    static Rect a(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.q;
    }

    static PickerState a(ColorSplashForegroundView colorsplashforegroundview, PickerState pickerstate)
    {
        colorsplashforegroundview.u = pickerstate;
        return pickerstate;
    }

    private void a(float f1, float f2)
    {
        float f3;
        RectF rectf;
        if (b != null)
        {
            int j1 = b.k;
            int i1 = b.l;
            j1 = (int)((c - (float)j1) / 2.0F);
            i1 = (int)((d - (float)i1) / 2.0F);
            rectf = new RectF(j1, i1, c - (float)j1, d - (float)i1);
        } else
        {
            rectf = new RectF(0.0F, 0.0F, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
        }
        if (f1 < rectf.left + 2.0F)
        {
            f3 = rectf.left + 2.0F;
        } else
        {
            f3 = f1;
            if (f1 > rectf.right - 2.0F)
            {
                f3 = rectf.right - 2.0F;
            }
        }
        if (f2 < rectf.top + 2.0F)
        {
            f1 = rectf.top + 2.0F;
        } else
        {
            f1 = f2;
            if (f2 > rectf.bottom - 2.0F)
            {
                f1 = rectf.bottom - 2.0F;
            }
        }
        a.set(f3, f1);
    }

    private void a(Context context)
    {
        m.setStyle(android.graphics.Paint.Style.STROKE);
        m.setAntiAlias(true);
        e = (int)TypedValue.applyDimension(1, 75F, context.getResources().getDisplayMetrics());
        f = (int)TypedValue.applyDimension(1, 15F, context.getResources().getDisplayMetrics());
        g = (int)TypedValue.applyDimension(1, 20F, context.getResources().getDisplayMetrics());
        h = (int)TypedValue.applyDimension(1, 22F, context.getResources().getDisplayMetrics());
        i = (int)TypedValue.applyDimension(1, 2.0F, context.getResources().getDisplayMetrics());
        j = e + (float)h;
        p = new RectF(o);
        u = PickerState.OPEN;
    }

    static float b(ColorSplashForegroundView colorsplashforegroundview)
    {
        float f1 = colorsplashforegroundview.s / 2.0F;
        colorsplashforegroundview.s = f1;
        return f1;
    }

    static float c(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.s;
    }

    static GLSurfaceView d(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.n;
    }

    static h e(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.b;
    }

    static Handler f(ColorSplashForegroundView colorsplashforegroundview)
    {
        return colorsplashforegroundview.v;
    }

    public final void a()
    {
        o.set(a.x - j - 1.0F, a.y - j - 1.0F, a.x + j + 1.0F, a.y + j + 1.0F);
        r.set(o);
        r.union(p);
        p.set(o);
        r.roundOut(q);
        invalidate(q);
    }

    public final void a(boolean flag)
    {
        if (l || flag || u == PickerState.OPEN)
        {
            u = PickerState.OPEN;
            s = 1.0F;
            Log.e("ex", (new StringBuilder("screenW = ")).append(c).toString());
            Log.e("ex", (new StringBuilder("screenH = ")).append(d).toString());
            a(c / 2.0F, d / 2.0F);
            p.set(a.x - j - 1.0F, a.y - j - 1.0F, a.x + j + 1.0F, a.y + j + 1.0F);
            postInvalidate();
        }
        l = false;
    }

    protected void onDraw(Canvas canvas)
    {
        if (b != null)
        {
            canvas.scale(s, s, a.x, a.y);
            m.setStrokeWidth(h);
            m.setColor(k);
            canvas.drawCircle(a.x, a.y, e, m);
            m.setStrokeWidth(g);
            m.setColor(-1);
            canvas.drawCircle(a.x, a.y, e, m);
            m.setStrokeWidth(f);
            m.setColor(t);
            canvas.drawCircle(a.x, a.y, e, m);
            m.setStrokeWidth(i);
            m.setColor(k);
            float f1 = a.x;
            float f2 = e / 6F;
            float f3 = a.y;
            float f4 = a.x;
            canvas.drawLine(f1 - f2, f3, e / 6F + f4, a.y, m);
            f1 = a.x;
            f2 = a.y;
            f3 = e / 6F;
            f4 = a.x;
            float f5 = a.y;
            canvas.drawLine(f1, f2 - f3, f4, e / 6F + f5, m);
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        c = i1;
        d = j1;
        if (u == PickerState.OPEN)
        {
            a(false);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (b == null || !b.c()) goto _L2; else goto _L1
_L1:
        PickerState pickerstate = PickerState.CLOSING;
        if (motionevent.getAction() != 1) goto _L4; else goto _L3
_L3:
        u = PickerState.CLOSING;
        o.set(a.x - j - 1.0F, a.y - j - 1.0F, a.x + j + 1.0F, a.y + j + 1.0F);
        r.set(o);
        r.union(p);
        p.set(o);
        r.roundOut(q);
        v.post(new Runnable() {

            final ColorSplashForegroundView a;

            public final void run()
            {
                a.invalidate(com.socialin.picsin.camera.view.ColorSplashForegroundView.a(a));
                ColorSplashForegroundView.b(a);
                if (ColorSplashForegroundView.c(a) <= 0.01F)
                {
                    com.socialin.picsin.camera.view.ColorSplashForegroundView.a(a, PickerState.CLOSED);
                    if (ColorSplashForegroundView.d(a) != null && ColorSplashForegroundView.e(a) != null && ColorSplashForegroundView.e(a).c())
                    {
                        ColorSplashForegroundView.d(a).queueEvent(new Runnable(this) {

                            private _cls1 a;

                            public final void run()
                            {
                                ColorSplashForegroundView.e(a.a).c = false;
                            }

            
            {
                a = _pcls1;
                super();
            }
                        });
                        h h1 = ColorSplashForegroundView.e(a);
                        if (h1.a != null)
                        {
                            h1.a.a(1, true, false, true);
                        }
                    }
                    return;
                } else
                {
                    ColorSplashForegroundView.f(a).postDelayed(this, 50L);
                    return;
                }
            }

            
            {
                a = ColorSplashForegroundView.this;
                super();
            }
        });
_L5:
        a();
        return true;
_L4:
        if (motionevent.getAction() == 2)
        {
            a(motionevent.getX(), motionevent.getY());
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public void setGlSurfaceView(GLSurfaceView glsurfaceview)
    {
        n = glsurfaceview;
    }

    public void setRenderer(h h1)
    {
        b = h1;
    }

    public void setSelectedColor(int i1)
    {
        t = i1;
    }


    private class PickerState extends Enum
    {

        private static final PickerState $VALUES[];
        public static final PickerState CLOSED;
        public static final PickerState CLOSING;
        public static final PickerState OPEN;

        public static PickerState valueOf(String s1)
        {
            return (PickerState)Enum.valueOf(com/socialin/picsin/camera/view/ColorSplashForegroundView$PickerState, s1);
        }

        public static PickerState[] values()
        {
            return (PickerState[])$VALUES.clone();
        }

        static 
        {
            OPEN = new PickerState("OPEN", 0);
            CLOSED = new PickerState("CLOSED", 1);
            CLOSING = new PickerState("CLOSING", 2);
            $VALUES = (new PickerState[] {
                OPEN, CLOSED, CLOSING
            });
        }

        private PickerState(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
