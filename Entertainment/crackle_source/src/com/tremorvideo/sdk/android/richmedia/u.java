// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, p, ae, b, 
//            k, o, j, e

public class u extends q
{
    protected class a extends j
    {

        public int a;
        public float b;
        public int c;
        public float d;
        public int e;
        public float f;
        public int g;
        public float h;
        public int i;
        public float j;
        public int k;
        public float l;
        public int m;
        public float n;
        public int o;
        public float p;
        public int q;
        public boolean r;
        final u s;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                a = e1.b();
                b = e1.d();
                c = e1.b();
                d = e1.d();
                e = e1.b();
                f = e1.d();
                g = e1.b();
                h = e1.d();
                i = e1.b();
                j = e1.d();
                k = e1.b();
                l = e1.d();
                m = e1.b();
                n = e1.d();
                o = e1.b();
                p = e1.d();
                q = e1.b();
                r = e1.f();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                return;
            }
        }

        protected a()
        {
            s = u.this;
            super();
        }
    }

    static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        private static final b f[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/u$b, s);
        }

        public static b[] values()
        {
            return (b[])f.clone();
        }

        static 
        {
            a = new b("Rectangle", 0);
            b = new b("Ellipse", 1);
            c = new b("DrawRectThin", 2);
            d = new b("DrawRectMedium", 3);
            e = new b("DrawRectThick", 4);
            f = (new b[] {
                a, b, c, d, e
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    public u(o o)
    {
        super(o);
    }

    private int a(p p1, b b1)
    {
        int i;
        i = 1;
        if (b1 == b.c)
        {
            return 1;
        }
        if (b1 != b.d) goto _L2; else goto _L1
_L1:
        i = 10;
_L4:
        float f = p1.a(l);
        return Math.max(0, Math.round((float)i * f));
_L2:
        if (b1 == b.e)
        {
            i = 25;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
                k = ((a) (obj)).r;
                if (d(((a) (obj)).r))
                {
                    float f1 = ae.b(((a) (obj)).b, ((a) (obj1)).b, ((a) (obj)).c, ((a) (obj1)).c, f);
                    float f2 = ae.b(((a) (obj)).d, ((a) (obj1)).d, ((a) (obj)).e, ((a) (obj1)).e, f);
                    float f3 = ae.b(((a) (obj)).f, ((a) (obj1)).f, ((a) (obj)).g, ((a) (obj1)).g, f);
                    float f4 = ae.b(((a) (obj)).h, ((a) (obj1)).h, ((a) (obj)).i, ((a) (obj1)).i, f);
                    int i = ae.a(((a) (obj)).j, ((a) (obj1)).j, ((a) (obj)).k, ((a) (obj1)).k, f);
                    int i1 = ae.a(((a) (obj)).l, ((a) (obj1)).l, ((a) (obj)).m, ((a) (obj1)).m, f);
                    int k1 = ae.a(((a) (obj)).n, ((a) (obj1)).n, ((a) (obj)).o, ((a) (obj1)).o, f);
                    int l1 = ae.a(((a) (obj)).p, ((a) (obj1)).p, ((a) (obj)).q, ((a) (obj1)).q, f);
                    b b1 = b.values()[((a) (obj)).a];
                    obj = p1.c();
                    ((Canvas) (obj)).save();
                    obj1 = com.tremorvideo.sdk.android.richmedia.b.a(f3, f4, c.c());
                    p1.a(f1 - ((PointF) (obj1)).x, f2 - ((PointF) (obj1)).y, f3, f4, this.l, c.c());
                    f3 = p1.h();
                    f2 = p1.i();
                    f4 = p1.j();
                    float f5 = p1.k();
                    f1 = f2;
                    f = f3;
                    if (c.a() != null)
                    {
                        obj1 = c.a().c(p1, l);
                        f = ((k) (obj1)).a;
                        f1 = ((k) (obj1)).b;
                        obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                        f = f3 + f + (float)((Point) (obj1)).x;
                        f1 = f2 + f1 + (float)((Point) (obj1)).y;
                    }
                    obj1 = a(p1, l, new RectF(f, f1, f4 + f, f5 + f1));
                    f = ((RectF) (obj1)).left;
                    f1 = ((RectF) (obj1)).top;
                    f2 = ((RectF) (obj1)).width();
                    f3 = ((RectF) (obj1)).height();
                    ((Canvas) (obj)).translate(Math.round(f), Math.round(f1));
                    obj1 = new Paint();
                    ((Paint) (obj1)).setColor(Color.argb(l1, i, i1, k1));
                    if (b1 == b.a)
                    {
                        ((Canvas) (obj)).drawRect(0.0F, 0.0F, Math.round(f2), Math.round(f3), ((Paint) (obj1)));
                    } else
                    if (b1 == b.b)
                    {
                        ((Paint) (obj1)).setAntiAlias(true);
                        ((Canvas) (obj)).drawOval(new RectF(0.0F, 0.0F, Math.round(f2), Math.round(f3)), ((Paint) (obj1)));
                    } else
                    {
                        int j1 = a(p1, b1);
                        ((Paint) (obj1)).setStyle(android.graphics.Paint.Style.STROKE);
                        ((Paint) (obj1)).setStrokeWidth(j1);
                        int j = (int)Math.floor((double)j1 / 2D);
                        j1 = (int)Math.round((double)j1 / 2D);
                        ((Canvas) (obj)).drawRect(j, j, Math.round(f2 - (float)j1), Math.round(f3 - (float)j1), ((Paint) (obj1)));
                    }
                    ((Canvas) (obj)).restore();
                    return;
                }
            }
        }
    }

    public k b(p p1, long l)
    {
        Object obj = a(l);
        if (obj != null)
        {
            a a1 = (a)((q.a) (obj)).a;
            a a2 = (a)((q.a) (obj)).b;
            float f3 = ((q.a) (obj)).c;
            float f = ae.b(a1.b, a2.b, a1.c, a2.c, f3);
            float f1 = ae.b(a1.d, a2.d, a1.e, a2.e, f3);
            float f2 = ae.b(a1.f, a2.f, a1.g, a2.g, f3);
            f3 = ae.b(a1.h, a2.h, a1.i, a2.i, f3);
            obj = com.tremorvideo.sdk.android.richmedia.b.a(f2, f3, c.c());
            p1.a(f - ((PointF) (obj)).x, f1 - ((PointF) (obj)).y, f2, f3, this.l, c.c());
            f3 = p1.h();
            f2 = p1.i();
            float f4 = p1.j();
            float f5 = p1.k();
            f1 = f2;
            f = f3;
            if (c.a() != null)
            {
                Object obj1 = c.a().c(p1, l);
                f = ((k) (obj1)).a;
                f1 = ((k) (obj1)).b;
                obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                f = f3 + f + (float)((Point) (obj1)).x;
                f1 = f2 + f1 + (float)((Point) (obj1)).y;
            }
            p1 = a(p1, l, new RectF(f, f1, f4 + f, f5 + f1));
            return new k(((RectF) (p1)).left, ((RectF) (p1)).top, ((RectF) (p1)).right - ((RectF) (p1)).left, ((RectF) (p1)).bottom - ((RectF) (p1)).top, 1.0F, 1.0F, 0.0F);
        } else
        {
            return k.h;
        }
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
