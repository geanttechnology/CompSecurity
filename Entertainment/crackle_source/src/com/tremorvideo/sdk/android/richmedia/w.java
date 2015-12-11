// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, o, a, c, 
//            ae, p, b, k, 
//            j, e

public class w extends q
{
    private class a extends j
    {

        public float a;
        public int b;
        public float c;
        public int d;
        public float e;
        public int f;
        public float g;
        public int h;
        public float i;
        public int j;
        public float k;
        public int l;
        public boolean m;
        public int n;
        final w o;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                n = e1.b();
                i = e1.d();
                j = e1.b();
                k = e1.d();
                l = e1.b();
                e1.d();
                e1.b();
                a = e1.d();
                b = e1.b();
                c = e1.d();
                d = e1.b();
                e = e1.d();
                f = e1.b();
                g = e1.d();
                h = e1.b();
                m = e1.f();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                return;
            }
        }

        private a()
        {
            o = w.this;
            super();
        }

    }


    Bitmap o;

    public w(o o1)
    {
        super(o1);
    }

    private Bitmap a(a a1)
    {
        if (o != null)
        {
            return o;
        } else
        {
            return g.f().r().a(a1.n);
        }
    }

    public void a(Bitmap bitmap)
    {
        o = bitmap;
    }

    public void a(p p1, long l)
    {
        q.a a1;
        if (n())
        {
            if ((a1 = a(l)) != null)
            {
                Object obj = (a)a1.a;
                Object obj1 = (a)a1.b;
                float f2 = a1.c;
                k = ((a) (obj)).m;
                if (((a) (obj)).n != -1 && d(((a) (obj)).m))
                {
                    int j = ae.a(((a) (obj)).i, ((a) (obj1)).i, ((a) (obj)).j, ((a) (obj1)).j, f2);
                    int i = ae.a(((a) (obj)).k, ((a) (obj1)).k, ((a) (obj)).l, ((a) (obj1)).l, f2);
                    float f1 = ae.b(((a) (obj)).a, ((a) (obj1)).a, ((a) (obj)).b, ((a) (obj1)).b, f2);
                    float f = ae.b(((a) (obj)).c, ((a) (obj1)).c, ((a) (obj)).d, ((a) (obj1)).d, f2);
                    float f4 = ae.b(((a) (obj)).e, ((a) (obj1)).e, ((a) (obj)).f, ((a) (obj1)).f, f2);
                    float f5 = ae.b(((a) (obj)).g, ((a) (obj1)).g, ((a) (obj)).h, ((a) (obj1)).h, f2);
                    Bitmap bitmap = a(((a) (obj)));
                    f1 *= (float)bitmap.getWidth() * p1.a();
                    f *= (float)bitmap.getHeight() * p1.a();
                    obj = com.tremorvideo.sdk.android.richmedia.b.a(f1, f, c.c());
                    j = (int)((float)j - ((PointF) (obj)).x);
                    i = (int)((float)i - ((PointF) (obj)).y);
                    p1.a(j, i, f1, f, this.l, c.c());
                    float f3 = p1.h();
                    f2 = p1.i();
                    float f6 = p1.j();
                    float f7 = p1.k();
                    f1 = f2;
                    f = f3;
                    if (c.a() != null)
                    {
                        obj = c.a().c(p1, l);
                        f = ((k) (obj)).a;
                        f1 = ((k) (obj)).b;
                        obj = com.tremorvideo.sdk.android.richmedia.b.a(((k) (obj)).f, ((k) (obj)).g, c.b());
                        f = f3 + f + ((PointF) (obj)).x;
                        f1 = f2 + f1 + ((PointF) (obj)).y;
                    }
                    obj = a(p1, l, new RectF(f, f1, f6 + f, f7 + f1));
                    f = ((RectF) (obj)).left;
                    f1 = ((RectF) (obj)).top;
                    f2 = ((RectF) (obj)).width();
                    f3 = ((RectF) (obj)).height();
                    f6 = f2 / (float)bitmap.getWidth();
                    f7 = f3 / (float)bitmap.getHeight();
                    obj = com.tremorvideo.sdk.android.richmedia.b.a(f2, f3, c.c());
                    obj1 = new Paint();
                    ((Paint) (obj1)).setAlpha(Math.round(255F * f5));
                    ((Paint) (obj1)).setFilterBitmap(true);
                    p1 = p1.c();
                    p1.save();
                    p1.translate(Math.round(f), Math.round(f1));
                    p1.translate(Math.round(((PointF) (obj)).x), Math.round(((PointF) (obj)).y));
                    p1.rotate(f4);
                    p1.translate(-Math.round(((PointF) (obj)).x), -Math.round(((PointF) (obj)).y));
                    p1.scale(f6, f7);
                    p1.drawBitmap(bitmap, 0.0F, 0.0F, ((Paint) (obj1)));
                    p1.restore();
                    return;
                }
            }
        }
    }

    public k b(p p1, long l)
    {
        q.a a2 = a(l);
        if (a2 != null)
        {
            Object obj = (a)a2.a;
            a a1 = (a)a2.b;
            float f2 = a2.c;
            if (((a) (obj)).n != -1)
            {
                Bitmap bitmap = a(((a) (obj)));
                float f = ae.b(((a) (obj)).i, a1.i, ((a) (obj)).j, a1.j, f2);
                float f1 = ae.b(((a) (obj)).k, a1.k, ((a) (obj)).l, a1.l, f2);
                float f4 = ae.b(((a) (obj)).a, a1.a, ((a) (obj)).b, a1.b, f2);
                float f5 = ae.b(((a) (obj)).c, a1.c, ((a) (obj)).d, a1.d, f2);
                float f6 = ae.b(((a) (obj)).e, a1.e, ((a) (obj)).f, a1.f, f2);
                f2 = (float)bitmap.getWidth() * f4 * p1.a();
                float f3 = (float)bitmap.getHeight() * f5 * p1.a();
                obj = com.tremorvideo.sdk.android.richmedia.b.a(f2, f3, c.c());
                p1.a(f - ((PointF) (obj)).x, f1 - ((PointF) (obj)).y, f2, f3, this.l, c.c());
                f3 = p1.h();
                f2 = p1.i();
                float f7 = p1.j();
                float f8 = p1.k();
                f1 = f2;
                f = f3;
                if (c.a() != null)
                {
                    Object obj1 = c.a().c(p1, l);
                    f = Math.round(((k) (obj1)).a);
                    f1 = Math.round(((k) (obj1)).b);
                    obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                    f = f3 + f + (float)((Point) (obj1)).x;
                    f1 = f2 + f1 + (float)((Point) (obj1)).y;
                }
                p1 = a(p1, l, new RectF(f, f1, f7 + f, f8 + f1));
                return new k(((RectF) (p1)).left, ((RectF) (p1)).top, p1.width(), p1.height(), f4, f5, f6);
            }
        }
        return k.h;
    }

    public void b()
    {
        super.b();
        o = null;
    }

    protected a c()
    {
        return new a();
    }

    protected j e()
    {
        return c();
    }
}
