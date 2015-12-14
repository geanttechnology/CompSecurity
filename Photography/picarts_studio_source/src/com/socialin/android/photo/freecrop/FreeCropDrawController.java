// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.photo.select.o;
import com.socialin.android.photo.view.a;
import com.socialin.android.util.Utils;
import com.socialin.android.util.c;
import java.util.ArrayList;

// Referenced classes of package com.socialin.android.photo.freecrop:
//            f, b, e, a

public final class FreeCropDrawController
    implements f
{

    public Paint A;
    public b B;
    public DrawMode C;
    public com.socialin.android.photo.freecrop.a D;
    public e E;
    public View F;
    public boolean G;
    private Canvas H;
    float a;
    float b;
    Path c;
    Path d;
    Path e;
    float f;
    float g;
    RectF h;
    Rect i;
    boolean j;
    boolean k;
    float l;
    public int m;
    public Bitmap n;
    public Bitmap o;
    public int p;
    public int q;
    RectF r;
    RectF s;
    Rect t;
    public Activity u;
    Paint v;
    public boolean w;
    Paint x;
    Paint y;
    Paint z;

    public FreeCropDrawController(Context context, Bitmap bitmap)
    {
        int i1;
        int j1;
        a = 2.0F;
        b = 3F;
        c = new Path();
        d = new Path();
        e = new Path();
        h = new RectF();
        i = new Rect();
        j = false;
        k = false;
        l = 10F;
        m = 1;
        r = new RectF();
        s = new RectF();
        t = new Rect();
        v = new Paint();
        w = false;
        B = new b();
        C = DrawMode.FreeCrop;
        F = null;
        G = true;
        n = bitmap;
        p = bitmap.getWidth();
        q = bitmap.getHeight();
        t.set(0, 0, bitmap.getWidth(), bitmap.getHeight());
        a = Utils.a(3F, context);
        b = Utils.a(5F, context);
        j1 = m;
        i1 = 10;
        j1;
        JVM INSTR tableswitch 0 5: default 276
    //                   0 420
    //                   1 414
    //                   2 408
    //                   3 402
    //                   4 396
    //                   5 391;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        l = Utils.a(i1, context);
        x = d();
        x.setStrokeWidth(l);
        z = g();
        z.setStrokeWidth(l);
        y = h();
        A = new Paint();
        A.setFilterBitmap(true);
        a(bitmap, false);
        E = new e(context, s, t, a, b);
        E.y = this;
        return;
_L7:
        i1 = 5;
        continue; /* Loop/switch isn't completed */
_L6:
        i1 = 8;
        continue; /* Loop/switch isn't completed */
_L5:
        i1 = 15;
        continue; /* Loop/switch isn't completed */
_L4:
        i1 = 20;
        continue; /* Loop/switch isn't completed */
_L3:
        i1 = 25;
        continue; /* Loop/switch isn't completed */
_L2:
        i1 = 30;
        if (true) goto _L1; else goto _L8
_L8:
    }

    private void a(Path path, boolean flag)
    {
        float f1 = (float)n.getWidth() / s.width();
        if (flag)
        {
            Path path1 = new Path(path);
            x.setStrokeWidth(l * f1);
            z.setStrokeWidth(l * f1);
            H.drawPath(path1, x);
            H.drawBitmap(n, 0.0F, 0.0F, y);
            if (!w)
            {
                H.drawPath(path1, z);
            }
            c(l);
            B.a(path1, f1 * z.getStrokeWidth(), w);
            path.reset();
        } else
        {
            Matrix matrix = new Matrix();
            matrix.postTranslate(-s.left, -s.top);
            matrix.postScale(f1, f1);
            Path path2 = new Path();
            path.transform(matrix, path2);
            path = new Paint();
            path.setAntiAlias(true);
            path.setStyle(android.graphics.Paint.Style.FILL);
            path.setAntiAlias(true);
            path.setFilterBitmap(true);
            path.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
            H.drawPath(path2, path);
            H.drawBitmap(n, 0.0F, 0.0F, y);
            path.setXfermode(null);
            path.setColor(0xffff0000);
            path.setAlpha(80);
            path.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
            H.drawPath(path2, path);
            B.a(path2, false);
        }
        if (D != null)
        {
            D.b();
        }
    }

    public static Paint d()
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        paint.setFilterBitmap(true);
        return paint;
    }

    public static Paint e()
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setFilterBitmap(true);
        return paint;
    }

    public static Paint f()
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        return paint;
    }

    public static Paint g()
    {
        Paint paint = new Paint();
        paint.setColor(0xffff0000);
        paint.setAlpha(80);
        paint.setFilterBitmap(true);
        paint.setAntiAlias(true);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        paint.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_ATOP));
        return paint;
    }

    public static Paint h()
    {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        paint.setFilterBitmap(true);
        return paint;
    }

    final float a(float f1)
    {
        return (f1 - s.left) * ((float)p / s.width());
    }

    public final void a()
    {
        if (F != null)
        {
            F.invalidate();
        }
    }

    public final void a(Bitmap bitmap, boolean flag)
    {
        if (o == null)
        {
            o = com.socialin.android.util.c.a(n.getWidth(), n.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        } else
        {
            o.eraseColor(0);
        }
        if (H == null)
        {
            H = new Canvas(o);
        }
        H.drawBitmap(bitmap, 0.0F, 0.0F, A);
        if (flag)
        {
            com.socialin.android.util.c.a(bitmap);
        }
    }

    public final void a(Path path)
    {
        a(path, false);
    }

    public final void a(MotionEvent motionevent, boolean flag)
    {
        if (C == DrawMode.FreeCrop)
        {
            if (k)
            {
                a(d, true);
                c.reset();
                d.reset();
            }
        } else
        {
            e e1 = E;
            if (e1.j)
            {
                boolean flag1;
                if (flag && e1.u)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                e1.s = flag1;
                flag1 = e1.s;
                if (e1.k)
                {
                    if (motionevent != null && !e1.i)
                    {
                        e1.a(e1.a(motionevent.getX()), e1.b(motionevent.getY()));
                    }
                    if (e1.p != null)
                    {
                        e1.p.e = false;
                        motionevent = e1.p;
                        e1.q.getWidth();
                        e1.q.getHeight();
                        motionevent.a();
                    }
                    if (e1.c != null)
                    {
                        e1.c.b = com.socialin.android.photo.view.a.a(e1.n, e1.o);
                        e1.c.b(e1.g, e1.h);
                        if (flag1)
                        {
                            motionevent = e1.v.a;
                            motionevent.lineTo(e1.d.c, e1.d.d);
                            if (e1.y != null)
                            {
                                e1.y.a(motionevent);
                            }
                            e1.b();
                        } else
                        {
                            e1.c();
                            e1.c.a = true;
                        }
                    }
                    e1.k = false;
                } else
                if (flag && !e1.c.c(e1.g, e1.h))
                {
                    e1.b();
                    e1.q.invalidate();
                }
                if (flag)
                {
                    e1.a();
                }
            }
            e1.j = false;
        }
        k = false;
        j = false;
        F.invalidate();
    }

    public final void a(DrawMode drawmode)
    {
        C = drawmode;
        if (E != null)
        {
            E.b();
        }
        if (drawmode == DrawMode.Lasso)
        {
            w = false;
        }
    }

    public final void a(boolean flag)
    {
        if (C == DrawMode.Lasso)
        {
            e e1 = E;
            if (e1.x > 0.0F && !e1.v.a.isEmpty())
            {
                float f1 = e1.e.width() / e1.x;
                e1.v.a(e1.e, f1);
                e1.c.a(e1.e.left, e1.e.top, f1);
                e1.d.a(e1.e.left, e1.e.top, f1);
                if (flag && !e1.s)
                {
                    e1.d();
                }
            }
        }
    }

    final float b(float f1)
    {
        return (f1 - s.top) * ((float)p / s.width());
    }

    public final void b()
    {
        B.a.clear();
        a(n, false);
    }

    public final void c()
    {
        if (C == DrawMode.Lasso)
        {
            e e1 = E;
            if (e1.e != null && !e1.v.a.isEmpty())
            {
                e1.x = e1.e.width();
                e1.v.a(e1.e);
                e1.c.a(e1.e.left, e1.e.top);
                e1.d.a(e1.e.left, e1.e.top);
            }
        }
    }

    public final void c(float f1)
    {
        l = f1;
        if (x != null)
        {
            x.setStrokeWidth(l);
        }
        if (z != null)
        {
            z.setStrokeWidth(l);
        }
    }

    private class DrawMode extends Enum
    {

        private static final DrawMode $VALUES[];
        public static final DrawMode FreeCrop;
        public static final DrawMode Lasso;

        public static DrawMode valueOf(String s1)
        {
            return (DrawMode)Enum.valueOf(com/socialin/android/photo/freecrop/FreeCropDrawController$DrawMode, s1);
        }

        public static DrawMode[] values()
        {
            return (DrawMode[])$VALUES.clone();
        }

        static 
        {
            FreeCrop = new DrawMode("FreeCrop", 0);
            Lasso = new DrawMode("Lasso", 1);
            $VALUES = (new DrawMode[] {
                FreeCrop, Lasso
            });
        }

        private DrawMode(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
