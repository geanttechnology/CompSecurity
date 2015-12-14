// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import axw;
import bkn;
import bkp;
import bkq;
import bkr;
import bks;
import gi;
import gl;

// Referenced classes of package com.wantu.imagelib.decorator.sprite:
//            Vector2D

public class ImageTransformPanel extends bks
{

    private float e[];
    private Drawable f;
    private Drawable g;
    private bkn h;
    private PointF i;
    private Context j;
    private State k;
    private float l;
    private float m;
    private float n;
    private float o;
    private PointF p;
    private ScaleGestureDetector q;
    private gl r;
    private gi s;

    public ImageTransformPanel(Context context)
    {
        i = new PointF();
        k = State.Normal;
        l = 0.0F;
        m = 0.0F;
        n = 0.0F;
        o = 1.0F;
        a(context);
        f = context.getResources().getDrawable(0x7f0203dc);
        g = context.getResources().getDrawable(0x7f0200ea);
        q = new ScaleGestureDetector(context, new bkr(this, null));
        r = new gl(context, new bkq(this, null));
        s = new gi(context, new bkp(this, null));
    }

    private float a(PointF pointf, PointF pointf1)
    {
        return (float)Math.sqrt((pointf1.x - pointf.x) * (pointf1.x - pointf.x) + (pointf1.y - pointf.y) * (pointf1.y - pointf.y));
    }

    public static float a(ImageTransformPanel imagetransformpanel)
    {
        return imagetransformpanel.o;
    }

    public static float a(ImageTransformPanel imagetransformpanel, float f1)
    {
        imagetransformpanel.o = f1;
        return f1;
    }

    public static float b(ImageTransformPanel imagetransformpanel)
    {
        return imagetransformpanel.l;
    }

    public static float b(ImageTransformPanel imagetransformpanel, float f1)
    {
        imagetransformpanel.l = f1;
        return f1;
    }

    public static float c(ImageTransformPanel imagetransformpanel)
    {
        return imagetransformpanel.m;
    }

    public static float c(ImageTransformPanel imagetransformpanel, float f1)
    {
        imagetransformpanel.m = f1;
        return f1;
    }

    private void c()
    {
        float af[] = new float[4];
        af[0] = h.a;
        af[1] = h.b;
        af[2] = 0.0F;
        af[3] = 0.0F;
        h.j().mapPoints(af);
        e = af;
    }

    public static float d(ImageTransformPanel imagetransformpanel)
    {
        return imagetransformpanel.n;
    }

    public static float d(ImageTransformPanel imagetransformpanel, float f1)
    {
        imagetransformpanel.n = f1;
        return f1;
    }

    private PointF d()
    {
        if (h == null)
        {
            return null;
        } else
        {
            RectF rectf = new RectF(0.0F, 0.0F, h.a, h.b);
            Matrix matrix = h.j();
            float af[] = new float[2];
            af[0] = rectf.centerX();
            af[1] = rectf.centerY();
            matrix.mapPoints(af);
            return new PointF(af[0], af[1]);
        }
    }

    public bkn a()
    {
        return h;
    }

    public void a(Context context)
    {
        j = context;
    }

    public void a(Canvas canvas)
    {
        if (h == null || !d)
        {
            return;
        } else
        {
            c();
            float f1 = axw.a(j, 20F);
            float f2 = axw.a(j, 20F);
            f.setBounds((int)(e[0] - f1), (int)(e[1] - f2), (int)(e[0] + f1), (int)(e[1] + f2));
            f.draw(canvas);
            g.setBounds((int)(e[2] - f1), (int)(e[3] - f2), (int)(f1 + e[2]), (int)(f2 + e[3]));
            g.draw(canvas);
            return;
        }
    }

    public void a(bkn bkn1)
    {
        if (h != bkn1)
        {
            h = bkn1;
            k = State.SpriteChange;
        }
    }

    public boolean a(int i1, int j1)
    {
        Rect rect = f.getBounds();
        rect.inset(-4, -4);
        return rect.contains(i1, j1);
    }

    public boolean a(MotionEvent motionevent)
    {
        boolean flag = true;
        if (h == null)
        {
            flag = false;
        } else
        {
            if (motionevent.getAction() == 0 && a((int)motionevent.getX(), (int)motionevent.getY()))
            {
                k = State.SingleFingleTrans;
                b(motionevent);
            }
            if (k == State.SingleFingleTrans)
            {
                b(motionevent);
                return true;
            }
            if (motionevent.getPointerCount() >= 2)
            {
                q.onTouchEvent(motionevent);
                r.a(motionevent);
            }
            s.a(motionevent);
            Matrix matrix = new Matrix();
            matrix.postScale(o, o);
            h.a(matrix);
            matrix = new Matrix();
            matrix.postRotate(l);
            h.e(matrix);
            matrix = new Matrix();
            matrix.postTranslate(m, n);
            h.c(matrix);
            if (motionevent.getAction() == 1)
            {
                h.d(h.f());
                h.c(new Matrix());
                h.b(h.d());
                h.a(new Matrix());
                h.f(h.h());
                h.e(new Matrix());
                o = 1.0F;
                l = 0.0F;
                m = 0.0F;
                n = 0.0F;
                return true;
            }
        }
        return flag;
    }

    public Context b()
    {
        return j;
    }

    public void b(MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0)
        {
            i.set(motionevent.getX(), motionevent.getY());
            p = d();
        } else
        {
            if (motionevent.getAction() == 2)
            {
                Object obj = new Matrix();
                float f1 = a(p, i);
                o = a(p, new PointF(motionevent.getX(), motionevent.getY())) / f1;
                ((Matrix) (obj)).setScale(o, o);
                h.a(((Matrix) (obj)));
                obj = new Vector2D(p.x, p.y);
                Vector2D vector2d = new Vector2D(i.x, i.y);
                vector2d.sub(((Vector2D) (obj)));
                motionevent = new Vector2D(motionevent.getX(), motionevent.getY());
                motionevent.sub(((Vector2D) (obj)));
                double d1 = motionevent.angle(vector2d);
                f1 = (float)Math.toDegrees(d1);
                Log.v("Angle", (new StringBuilder()).append("radius    ").append(d1).toString());
                Log.v("Angle", (new StringBuilder()).append("angle    ").append(f1).toString());
                motionevent = new Matrix();
                motionevent.setRotate(f1);
                h.e(motionevent);
                return;
            }
            if (motionevent.getAction() == 1)
            {
                h.b(h.d());
                h.a(new Matrix());
                h.f(h.h());
                h.e(new Matrix());
                o = 1.0F;
                k = State.Normal;
                return;
            }
        }
    }

    public boolean b(int i1, int j1)
    {
        Rect rect = g.getBounds();
        rect.inset(-4, -4);
        return rect.contains(i1, j1);
    }

    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State Normal;
        public static final State SingleFingleTrans;
        public static final State SpriteChange;

        public static State valueOf(String s1)
        {
            return (State)Enum.valueOf(com/wantu/imagelib/decorator/sprite/ImageTransformPanel$State, s1);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            Normal = new State("Normal", 0);
            SpriteChange = new State("SpriteChange", 1);
            SingleFingleTrans = new State("SingleFingleTrans", 2);
            $VALUES = (new State[] {
                Normal, SpriteChange, SingleFingleTrans
            });
        }

        private State(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
