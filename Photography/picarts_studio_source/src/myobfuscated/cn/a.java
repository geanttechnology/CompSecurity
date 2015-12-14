// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cn;

import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;

public class a
{

    public Path a;
    public Paint b;
    public Paint c;
    public Rect d;
    private PathMeasure e;
    private Path f;
    private RectF g;
    private RectF h;
    private Matrix i;
    private float j;
    private float k;
    private float l;
    private float m[] = {
        10F, 5F, 5F, 5F
    };
    private float n[] = {
        10F, 5F, 5F, 10F
    };
    private CornerPathEffect o;
    private DashPathEffect p;
    private DashPathEffect q;
    private PathEffect r;
    private PathEffect s;
    private float t[];

    public a(float f1)
    {
        a = new Path();
        e = new PathMeasure(a, false);
        f = new Path();
        g = new RectF();
        d = new Rect();
        h = new RectF();
        i = new Matrix();
        o = new CornerPathEffect(3F);
        p = new DashPathEffect(m, 0.0F);
        q = new DashPathEffect(n, 1.0F);
        r = new ComposePathEffect(o, p);
        s = new ComposePathEffect(o, q);
        t = new float[4];
        l = f1;
        b = new Paint();
        b.setAntiAlias(true);
        b.setStyle(android.graphics.Paint.Style.STROKE);
        b.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        b.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        b.setStrokeWidth(l);
        b.setFilterBitmap(true);
        b.setColor(-1);
        b.setPathEffect(r);
        c = new Paint();
        c.setAntiAlias(true);
        c.setStyle(android.graphics.Paint.Style.STROKE);
        c.setStrokeJoin(android.graphics.Paint.Join.ROUND);
        c.setStrokeCap(android.graphics.Paint.Cap.ROUND);
        c.setStrokeWidth(l);
        c.setFilterBitmap(true);
        c.setColor(0xff000000);
        c.setPathEffect(s);
        a(0.0F);
    }

    public final float a()
    {
        e.setPath(a, false);
        return e.getLength();
    }

    public final void a(float f1)
    {
        p = new DashPathEffect(m, f1);
        q = new DashPathEffect(n, 1.0F + f1);
        r = new ComposePathEffect(o, p);
        s = new ComposePathEffect(o, q);
        b.setPathEffect(r);
        c.setPathEffect(s);
    }

    public final void a(float f1, float f2)
    {
        a.reset();
        a.moveTo(f1, f2);
        f.reset();
        f.moveTo(f1, f2);
    }

    public final void a(Canvas canvas)
    {
        canvas.drawPath(a, b);
        canvas.drawPath(a, c);
    }

    public final void a(RectF rectf)
    {
        a.computeBounds(h, true);
        j = h.left - rectf.left;
        k = h.top - rectf.top;
    }

    public final void a(RectF rectf, float f1)
    {
        i.reset();
        i.postTranslate(-h.left, -h.top);
        i.postScale(f1, f1);
        i.postTranslate(rectf.left + j * f1, rectf.top + k * f1);
        a.transform(i);
    }

    public final float[] a(float f1, float f2, float f3, float f4)
    {
        f.quadTo(f1, f2, (f3 + f1) / 2.0F, (f4 + f2) / 2.0F);
        f.computeBounds(g, true);
        float f5 = l / 2.0F + 1.0F;
        RectF rectf = g;
        rectf.left = rectf.left - f5;
        rectf = g;
        rectf.top = rectf.top - f5;
        rectf = g;
        rectf.right = rectf.right + f5;
        rectf = g;
        rectf.bottom = f5 + rectf.bottom;
        d.set((int)g.left, (int)g.top, (int)g.right, (int)g.bottom);
        t[0] = f1;
        t[1] = f2;
        t[2] = (f3 + f1) / 2.0F;
        t[3] = (f4 + f2) / 2.0F;
        a.quadTo(t[0], t[1], t[2], t[3]);
        f.reset();
        f.moveTo((f3 + f1) / 2.0F, (f4 + f2) / 2.0F);
        return t;
    }
}
