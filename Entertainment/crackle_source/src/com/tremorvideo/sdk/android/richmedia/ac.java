// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, ae, b, p, 
//            k, o, j, e

public class ac extends q
{
    protected class a extends j
    {

        public float a;
        public int b;
        public float c;
        public int d;
        public float e;
        public int f;
        public float g;
        public int h;
        public int i;
        public boolean j;
        final ac k;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                a = e1.d();
                b = e1.b();
                c = e1.d();
                d = e1.b();
                e = e1.d();
                f = e1.b();
                g = e1.d();
                h = e1.b();
                i = (int)e1.d();
                j = e1.f();
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
            k = ac.this;
            super();
        }
    }


    public ac(o o)
    {
        super(o);
    }

    public void a(p p1, long l)
    {
    }

    public k b(p p1, long l)
    {
        q.a a1 = a(l);
        if (a1 != null)
        {
            a a2 = (a)a1.a;
            a a3 = (a)a1.b;
            float f3 = a1.c;
            if (a2.j)
            {
                float f = ae.b(a2.a, a3.a, a2.b, a3.b, f3);
                float f1 = ae.b(a2.c, a3.c, a2.d, a3.d, f3);
                float f2 = ae.b(a2.e, a3.e, a2.f, a3.f, f3);
                f3 = ae.b(a2.g, a3.g, a2.h, a3.h, f3);
                PointF pointf = com.tremorvideo.sdk.android.richmedia.b.a(f2, f3, c.c());
                p1.a(f - pointf.x, f1 - pointf.y, f2, f3, this.l, c.c());
                f3 = p1.h();
                f2 = p1.i();
                float f4 = p1.j();
                float f5 = p1.k();
                f1 = f2;
                f = f3;
                if (c.a() != null)
                {
                    Object obj = c.a().c(p1, l);
                    f = ((k) (obj)).a;
                    f1 = ((k) (obj)).b;
                    obj = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj)).f), Math.round(((k) (obj)).g), c.b());
                    f = f3 + f + (float)((Point) (obj)).x;
                    f1 = f2 + f1 + (float)((Point) (obj)).y;
                }
                p1 = a(p1, l, new RectF(f, f1, f4 + f, f5 + f1));
                return new k(((RectF) (p1)).left, ((RectF) (p1)).top, p1.width(), p1.height(), 1.0F, 1.0F, 0.0F);
            }
        }
        return k.h;
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
