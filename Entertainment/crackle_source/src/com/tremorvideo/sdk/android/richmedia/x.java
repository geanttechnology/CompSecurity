// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, o, a, ae, 
//            p, b, k, j, 
//            e

public class x extends q
{
    protected class a extends j
    {

        public int e;
        public float f;
        public int g;
        public float h;
        public int i;
        public int j;
        public float k;
        public int l;
        public float m;
        public int n;
        public float o;
        public int p;
        public float q;
        public int r;
        public boolean s;
        final x t;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                e = e1.b();
                f = e1.d();
                g = e1.b();
                h = e1.d();
                i = e1.b();
                j = 0;
                k = e1.d();
                l = e1.b();
                m = e1.d();
                n = e1.b();
                o = e1.d();
                p = e1.b();
                q = e1.d();
                r = e1.b();
                s = e1.f();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                return;
            }
        }

        protected void b(e e1)
        {
            super.a(e1);
        }

        protected a()
        {
            t = x.this;
            super();
        }
    }


    o u;

    public x(o o1)
    {
        super(o1);
    }

    protected o a(a a1, long l)
    {
        if (u != null)
        {
            return u;
        } else
        {
            int i = a1.e;
            return g.f().b(i);
        }
    }

    void a(o o1)
    {
        u = o1;
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
                float f = a1.c;
                k = ((a) (obj)).s;
                if (d(((a) (obj)).s) && ((a) (obj)).e != 255)
                {
                    o o1 = a(((a) (obj)), l);
                    long l1 = b(((a) (obj)), l);
                    int i = ae.a(((a) (obj)).f, ((a) (obj1)).f, ((a) (obj)).g, ((a) (obj1)).g, f);
                    int j = ae.a(((a) (obj)).h, ((a) (obj1)).h, ((a) (obj)).i, ((a) (obj1)).i, f);
                    float f5 = ae.b(((a) (obj)).m, ((a) (obj1)).m, ((a) (obj)).n, ((a) (obj1)).n, f);
                    float f6 = ae.b(((a) (obj)).o, ((a) (obj1)).o, ((a) (obj)).p, ((a) (obj1)).p, f);
                    float f7 = ae.b(((a) (obj)).q, ((a) (obj1)).q, ((a) (obj)).r, ((a) (obj1)).r, f);
                    obj = new p();
                    ((p) (obj)).a(p1.c());
                    obj.f = p1.f;
                    obj.g = p1.g;
                    obj.h = p1.h;
                    Object obj2 = o1.a(((p) (obj)), l1);
                    int i1 = ((Rect) (obj2)).width();
                    int j1 = ((Rect) (obj2)).height();
                    obj1 = com.tremorvideo.sdk.android.richmedia.b.a(i1, j1, c.c());
                    f = i;
                    f = j;
                    float f8 = i1;
                    float f9 = j1;
                    float f2;
                    float f3;
                    float f4;
                    float f10;
                    if (c.c() == b.b.e)
                    {
                        ((PointF) (obj1)).set(0.0F, 0.0F);
                    } else
                    {
                        obj1.x = ((PointF) (obj1)).x + (float)((Rect) (obj2)).left;
                        float f1 = ((PointF) (obj1)).y;
                        obj1.y = (float)((Rect) (obj2)).top + f1;
                    }
                    p1.a(i, j, 0.0F, 0.0F, this.l, c.c());
                    f4 = p1.h();
                    f3 = p1.i();
                    f10 = p1.a(this.l);
                    f2 = f3;
                    f = f4;
                    if (c.a() != null)
                    {
                        p1 = c.a().c(p1, l);
                        f = Math.round(((k) (p1)).a);
                        f2 = Math.round(((k) (p1)).b);
                        p1 = com.tremorvideo.sdk.android.richmedia.b.a(((k) (p1)).f, ((k) (p1)).g, c.b());
                        f = f4 + f + ((PointF) (p1)).x;
                        f2 = f3 + f2 + ((PointF) (p1)).y;
                    }
                    p1 = com.tremorvideo.sdk.android.richmedia.b.a(f8 * f5, f9 * f6, c.c());
                    p1.set(0.0F, 0.0F);
                    obj2 = ((p) (obj)).c();
                    ((Canvas) (obj2)).save();
                    ((Canvas) (obj2)).translate(Math.round(f), Math.round(f2));
                    ((Canvas) (obj2)).translate(Math.round(((PointF) (p1)).x), Math.round(((PointF) (p1)).y));
                    ((Canvas) (obj2)).rotate(f7);
                    ((Canvas) (obj2)).translate(-Math.round(((PointF) (p1)).x), -Math.round(((PointF) (p1)).y));
                    ((Canvas) (obj2)).scale(f5, f6);
                    ((Canvas) (obj2)).scale(f10, f10);
                    ((Canvas) (obj2)).translate(-((PointF) (obj1)).x, -((PointF) (obj1)).y);
                    o1.a(((p) (obj)), l1, null);
                    ((Canvas) (obj2)).restore();
                    return;
                }
            }
        }
    }

    protected long b(a a1, long l)
    {
        if (u != null)
        {
            return l % u.c();
        } else
        {
            int i = a1.e;
            return l % g.f().b(i).c();
        }
    }

    public k b(p p1, long l)
    {
        q.a a1 = a(l);
        if (a1 != null)
        {
            Object obj = (a)a1.a;
            Object obj1 = (a)a1.b;
            float f2 = a1.c;
            if (((a) (obj)).e != 255)
            {
                Object obj2 = a(((a) (obj)), l);
                long l1 = b(((a) (obj)), l);
                float f = ae.b(((a) (obj)).f, ((a) (obj1)).f, ((a) (obj)).g, ((a) (obj1)).g, f2);
                float f1 = ae.b(((a) (obj)).h, ((a) (obj1)).h, ((a) (obj)).i, ((a) (obj1)).i, f2);
                float f4 = ae.b(((a) (obj)).m, ((a) (obj1)).m, ((a) (obj)).n, ((a) (obj1)).n, f2);
                float f5 = ae.b(((a) (obj)).o, ((a) (obj1)).o, ((a) (obj)).p, ((a) (obj1)).p, f2);
                float f6 = ae.b(((a) (obj)).q, ((a) (obj1)).q, ((a) (obj)).r, ((a) (obj1)).r, f2);
                obj = new p();
                ((p) (obj)).a(p1.c());
                obj.f = p1.f;
                obj.g = p1.g;
                obj = ((o) (obj2)).b(((p) (obj)), l1);
                float f7 = ((RectF) (obj)).width();
                float f8 = ((RectF) (obj)).height();
                obj1 = com.tremorvideo.sdk.android.richmedia.b.a(f7, f8, c.c());
                float f3;
                Matrix matrix;
                if (c.c() == b.b.e)
                {
                    ((PointF) (obj1)).set(0.0F, 0.0F);
                } else
                {
                    obj1.x = ((PointF) (obj1)).x + ((RectF) (obj)).left;
                    obj1.y = ((PointF) (obj1)).y + ((RectF) (obj)).top;
                }
                p1.a(f, f1, 0.0F, 0.0F, this.l, c.c());
                f3 = p1.h();
                f2 = p1.i();
                f1 = f2;
                f = f3;
                if (c.a() != null)
                {
                    obj2 = c.a().c(p1, l);
                    f = Math.round(((k) (obj2)).a);
                    f1 = Math.round(((k) (obj2)).b);
                    obj2 = com.tremorvideo.sdk.android.richmedia.b.a(((k) (obj2)).f, ((k) (obj2)).g, c.b());
                    f = f3 + f + ((PointF) (obj2)).x;
                    f1 = f2 + f1 + ((PointF) (obj2)).y;
                }
                obj2 = com.tremorvideo.sdk.android.richmedia.b.a(f7, f8, c.c());
                if (c.c() == b.b.e)
                {
                    ((PointF) (obj2)).set(0.0F, 0.0F);
                }
                matrix = new Matrix();
                matrix.preTranslate(f, f1);
                matrix.preTranslate(((PointF) (obj2)).x, ((PointF) (obj2)).y);
                matrix.preScale(f4, f5);
                matrix.preTranslate(-((PointF) (obj2)).x, -((PointF) (obj2)).y);
                matrix.preScale(p1.a(this.l), p1.a(this.l));
                matrix.preTranslate(-((PointF) (obj1)).x, -((PointF) (obj1)).y);
                matrix.mapRect(((RectF) (obj)));
                return new k(((RectF) (obj)).left, ((RectF) (obj)).top, ((RectF) (obj)).width(), ((RectF) (obj)).height(), f4, f5, f6);
            }
        }
        return k.h;
    }

    public void b()
    {
        super.b();
        u = null;
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
