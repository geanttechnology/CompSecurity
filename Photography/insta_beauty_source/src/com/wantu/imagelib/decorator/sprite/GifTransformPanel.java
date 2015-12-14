// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import bki;
import bks;

// Referenced classes of package com.wantu.imagelib.decorator.sprite:
//            Vector2D

public class GifTransformPanel extends bks
{

    private float e[];
    private Drawable f;
    private Drawable g;
    private bki h;
    private PointF i;
    private Context j;
    private State k;

    public GifTransformPanel(Context context)
    {
        i = new PointF();
        k = State.Pan;
        j = context;
        f = context.getResources().getDrawable(0x7f0203db);
        g = context.getResources().getDrawable(0x7f0203db);
    }

    private float a(PointF pointf, PointF pointf1)
    {
        return (float)Math.sqrt((pointf1.x - pointf.x) * (pointf1.x - pointf.x) + (pointf1.y - pointf.y) * (pointf1.y - pointf.y));
    }

    private void b()
    {
        float af[] = new float[4];
        af[0] = h.a;
        af[1] = h.b;
        af[2] = h.a;
        af[3] = 0.0F;
        h.i().mapPoints(af);
        e = af;
    }

    private PointF c()
    {
        if (h == null)
        {
            return null;
        } else
        {
            RectF rectf = new RectF(0.0F, 0.0F, h.a, h.b);
            h.i().mapRect(rectf);
            return new PointF(rectf.centerX(), rectf.centerY());
        }
    }

    public bki a()
    {
        return h;
    }

    public void a(Canvas canvas)
    {
        if (h == null || !d)
        {
            return;
        } else
        {
            b();
            Path path = new Path();
            path.moveTo(0.0F, 0.0F);
            path.lineTo(h.a, 0.0F);
            path.lineTo(h.a, h.b);
            path.lineTo(0.0F, h.b);
            path.close();
            path.transform(h.i());
            Paint paint = new Paint(1);
            paint.setStrokeWidth(2.0F);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setColor(-1);
            paint.setPathEffect(new DashPathEffect(new float[] {
                5F, 5F, 5F, 5F
            }, 1.0F));
            canvas.drawPath(path, paint);
            f.setBounds((int)(e[0] - 20F), (int)(e[1] - 20F), (int)(e[0] + 20F), (int)(e[1] + 20F));
            f.draw(canvas);
            g.setBounds((int)(e[2] - 20F), (int)(e[3] - 20F), (int)(e[2] + 20F), (int)(e[3] + 20F));
            g.draw(canvas);
            return;
        }
    }

    public void a(bki bki1)
    {
        if (h != bki1)
        {
            h = bki1;
            k = State.SpriteChange;
        }
    }

    public boolean a(MotionEvent motionevent)
    {
        boolean flag1 = true;
        if (h != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        if (motionevent.getAction() == 0)
        {
            i.set(motionevent.getX(), motionevent.getY());
            if (k == State.SpriteChange)
            {
                k = State.Pan;
                return true;
            }
            Rect rect = f.getBounds();
            rect.inset(-4, -4);
            Rect rect1 = g.getBounds();
            rect1.inset(-4, -4);
            if (rect.contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                k = State.Scale;
                return true;
            }
            if (rect1.contains((int)motionevent.getX(), (int)motionevent.getY()))
            {
                k = State.Rotate;
                return true;
            } else
            {
                k = State.Pan;
                return true;
            }
        }
        if (motionevent.getAction() != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        float f1 = motionevent.getX();
        float f2 = i.x;
        float f3 = motionevent.getY();
        float f4 = i.y;
        Object obj = c();
        Matrix matrix = new Matrix();
        if (k == State.Scale)
        {
            f1 = a(((PointF) (obj)), i);
            f1 = a(((PointF) (obj)), new PointF(motionevent.getX(), motionevent.getY())) / f1;
            matrix.setScale(f1, f1, h.a / 2.0F, h.b / 2.0F);
            h.a(matrix);
            return true;
        }
        if (k == State.Rotate)
        {
            obj = new Vector2D(((PointF) (obj)).x, ((PointF) (obj)).y);
            Vector2D vector2d = new Vector2D(i.x, i.y);
            vector2d.sub(((Vector2D) (obj)));
            motionevent = new Vector2D(motionevent.getX(), motionevent.getY());
            motionevent.sub(((Vector2D) (obj)));
            double d = motionevent.angle(vector2d);
            f1 = (float)Math.toDegrees(d);
            Log.v("Angle", (new StringBuilder()).append("radius    ").append(d).toString());
            Log.v("Angle", (new StringBuilder()).append("angle    ").append(f1).toString());
            matrix.setRotate(f1, h.a / 2.0F, h.b / 2.0F);
            h.e(matrix);
            return true;
        }
        flag = flag1;
        if (k == State.Pan)
        {
            matrix.setTranslate(f1 - f2, f3 - f4);
            h.c(matrix);
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (motionevent.getAction() == 1)
        {
            if (k == State.Scale)
            {
                h.b(h.c());
                h.a(new Matrix());
                return true;
            }
            if (k == State.Rotate)
            {
                h.f(h.g());
                h.e(new Matrix());
                return true;
            }
            flag = flag1;
            if (k == State.Pan)
            {
                h.d(h.e());
                h.c(new Matrix());
                return true;
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private class State extends Enum
    {

        private static final State $VALUES[];
        public static final State Pan;
        public static final State Rotate;
        public static final State Scale;
        public static final State SpriteChange;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/wantu/imagelib/decorator/sprite/GifTransformPanel$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            SpriteChange = new State("SpriteChange", 0);
            Pan = new State("Pan", 1);
            Rotate = new State("Rotate", 2);
            Scale = new State("Scale", 3);
            $VALUES = (new State[] {
                SpriteChange, Pan, Rotate, Scale
            });
        }

        private State(String s, int l)
        {
            super(s, l);
        }
    }

}
