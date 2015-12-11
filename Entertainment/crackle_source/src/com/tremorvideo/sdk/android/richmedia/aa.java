// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.ax;
import java.util.GregorianCalendar;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, ad, o, a, 
//            ae, p, b, k, 
//            e, m, j

public class aa extends q
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
        public boolean i;
        final aa j;

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
                i = e1.f();
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
            j = aa.this;
            super();
        }
    }


    double A;
    int B;
    Paint o;
    Paint p;
    Paint q;
    Paint r;
    Paint s;
    int t;
    int u;
    int v;
    int w;
    int x;
    int y;
    int z;

    public aa(o o1)
    {
        super(o1);
        t = 0;
        u = 0;
        v = 0;
        w = 0;
        x = 0;
        y = 0;
        A = 0.0D;
        B = 0;
    }

    private int a(com.tremorvideo.sdk.android.richmedia.ad aad[], int j)
    {
        int l = 0;
        int j1 = aad.length;
        int i1 = 0;
        for (; l < j1; l++)
        {
            com.tremorvideo.sdk.android.richmedia.ad ad1 = aad[l];
            if (ad1.c == 0)
            {
                ad1.c = Math.round(a(ad1.a, j).measureText(ad1.b));
            }
            i1 += ad1.c;
        }

        return i1;
    }

    private Paint a(ad.a a1, int j)
    {
        if (a1 == ad.a.a)
        {
            return c(j);
        }
        if (a1 == ad.a.c)
        {
            return b(j);
        }
        if (a1 == ad.a.b)
        {
            return d(j);
        } else
        {
            return c(j);
        }
    }

    private com.tremorvideo.sdk.android.richmedia.ad i(int j, int l)
    {
        l = e(l);
        int i1 = w;
        com.tremorvideo.sdk.android.richmedia.ad aad[] = g.f().o();
        if (aad != null)
        {
            int j1 = aad.length;
            i1 += l;
            for (l = 0; l < j1; l++)
            {
                com.tremorvideo.sdk.android.richmedia.ad ad1 = aad[l];
                if (i1 < j && ad1.c + i1 >= j)
                {
                    return ad1;
                }
                i1 += ad1.c;
            }

        }
        return null;
    }

    public void a()
    {
        super.a();
        t = 0;
        u = 0;
        v = 0;
        w = 0;
        x = 0;
        y = 0;
        o = null;
        p = null;
        q = null;
        r = null;
        s = null;
        B = 250;
        com.tremorvideo.sdk.android.richmedia.ad aad[] = g.f().o();
        if (aad != null)
        {
            int l = aad.length;
            for (int j = 0; j < l; j++)
            {
                aad[j].c = 0;
            }

        }
    }

    protected void a(Canvas canvas, int j, int l, int i1, int j1)
    {
        canvas.save();
        Object obj = g.f().o();
        int k1 = 0;
        if (obj != null)
        {
            k1 = a(((com.tremorvideo.sdk.android.richmedia.ad []) (obj)), j1);
        }
        z = k1;
        k1 = e(i1) + (j + 2);
        b(canvas, j, l, i1, j1);
        canvas.clipRect(j + 2, 0, (j + i1) - 2, j1);
        if (obj == null)
        {
            obj = c(j1);
            j = Math.round(((float)j1 - ((Paint) (obj)).getTextSize()) / 2.0F);
            canvas.drawText("Loading Show Times...", k1, ((float)j + ((Paint) (obj)).getTextSize()) - ((Paint) (obj)).descent(), ((Paint) (obj)));
        } else
        {
            i1 = obj.length;
            j = 0;
            l = k1;
            while (j < i1) 
            {
                Object obj1 = obj[j];
                Paint paint = a(((com.tremorvideo.sdk.android.richmedia.ad) (obj1)).a, j1);
                int l1 = Math.round(((float)j1 - paint.getTextSize()) / 2.0F);
                canvas.save();
                canvas.translate(l, ((float)l1 + paint.getTextSize()) - paint.descent());
                canvas.drawText(((com.tremorvideo.sdk.android.richmedia.ad) (obj1)).b, 0.0F, 0.0F, paint);
                canvas.restore();
                l += ((com.tremorvideo.sdk.android.richmedia.ad) (obj1)).c;
                j++;
            }
        }
        canvas.restore();
    }

    public void a(e e1)
    {
        super.a(e1);
        h = true;
    }

    public void a(m m, long l)
    {
        if (g.f().o() != null && z != 0)
        {
            if (B > 0)
            {
                B = (int)Math.max(0L, (long)B - l);
                if (B == 0)
                {
                    a();
                    B = 0;
                }
            }
            double d1 = v;
            A = A - (d1 * 0.20000000000000001D * (double)l) / 1000D;
        }
    }

    public void a(p p1, long l)
    {
        q.a a1;
        if (n())
        {
            if ((a1 = a(l)) != null)
            {
                Object obj = (a)a1.a;
                a a2 = (a)a1.b;
                float f4 = a1.c;
                k = ((a) (obj)).i;
                if (d(((a) (obj)).i))
                {
                    float f1 = ae.b(((a) (obj)).a, a2.a, ((a) (obj)).b, a2.b, f4);
                    float f2 = ae.b(((a) (obj)).c, a2.c, ((a) (obj)).d, a2.d, f4);
                    float f3 = ae.b(((a) (obj)).e, a2.e, ((a) (obj)).f, a2.f, f4);
                    f4 = ae.b(((a) (obj)).g, a2.g, ((a) (obj)).h, a2.h, f4);
                    Canvas canvas = p1.c();
                    obj = com.tremorvideo.sdk.android.richmedia.b.a(f3, f4, c.c());
                    p1.a(f1 - ((PointF) (obj)).x, f2 - ((PointF) (obj)).y, f3, f4, this.l, c.c());
                    f4 = p1.h();
                    f3 = p1.i();
                    float f5 = p1.j();
                    float f6 = p1.k();
                    f2 = f3;
                    f1 = f4;
                    if (c.a() != null)
                    {
                        Object obj1 = c.a().c(p1, l);
                        f1 = ((k) (obj1)).a;
                        f2 = ((k) (obj1)).b;
                        obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                        f1 = f4 + f1 + (float)((Point) (obj1)).x;
                        f2 = f3 + f2 + (float)((Point) (obj1)).y;
                    }
                    p1 = a(p1, l, new RectF(f1, f2, f5 + f1, f6 + f2));
                    f1 = ((RectF) (p1)).left;
                    f2 = ((RectF) (p1)).top;
                    f3 = p1.width();
                    f4 = p1.height();
                    int j = Math.round(f4);
                    int j2 = Math.round(f3);
                    int k2 = Math.round(f4);
                    int i1 = e(j2, k2);
                    int j1 = f(j2, k2);
                    int k1 = c(j2, k2);
                    int l1 = d(j2, k2);
                    int i2 = g(j2, k2);
                    j2 = h(j2, k2);
                    canvas.save();
                    canvas.translate(Math.round(f1), Math.round(f2));
                    c(canvas, i1, 0, j1, j);
                    a(canvas, i2, 0, j2, j);
                    d(canvas, k1, 0, l1, j);
                    canvas.restore();
                    return;
                }
            }
        }
    }

    public boolean a(int j, int l)
    {
        if (j >= x && j < x + y)
        {
            g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.J);
        } else
        if (j >= t && j < t + u)
        {
            g.f().c().a(com.tremorvideo.sdk.android.videoad.aw.b.K);
            return true;
        }
        if (j >= w && j <= w + v)
        {
            com.tremorvideo.sdk.android.richmedia.ad ad1 = i(j, v);
            if (ad1 != null && ad1.d != null && ad1.d != "")
            {
                ad.d((new StringBuilder()).append("TMS URL: ").append(ad1.d).toString());
                ax ax1 = g.f().c();
                ax1.a(com.tremorvideo.sdk.android.videoad.aw.b.I);
                ax1.d(ad1.d);
            }
        }
        return false;
    }

    protected Paint b(int j)
    {
        if (s != null)
        {
            return s;
        } else
        {
            s = new Paint();
            s.setTextSize((float)j * 0.4F);
            s.setColor(-1);
            s.setAntiAlias(true);
            return s;
        }
    }

    protected Paint b(int j, int l)
    {
        if (o != null)
        {
            return o;
        } else
        {
            int i1 = Color.argb(255, 54, 54, 54);
            int j1 = Color.argb(255, 35, 35, 35);
            int k1 = Color.argb(255, 35, 35, 35);
            float f1 = j;
            float f2 = l;
            Object obj = android.graphics.Shader.TileMode.CLAMP;
            obj = new LinearGradient(0.0F, f1, 0.0F, f2, new int[] {
                i1, j1, k1
            }, new float[] {
                0.0F, 0.75F, 1.0F
            }, ((android.graphics.Shader.TileMode) (obj)));
            o = new Paint();
            o.setDither(true);
            o.setShader(((android.graphics.Shader) (obj)));
            return o;
        }
    }

    public k b(p p1, long l)
    {
        Object obj = a(l);
        if (obj != null)
        {
            a a1 = (a)((q.a) (obj)).a;
            a a2 = (a)((q.a) (obj)).b;
            float f4 = ((q.a) (obj)).c;
            float f1 = ae.b(a1.a, a2.a, a1.b, a2.b, f4);
            float f2 = ae.b(a1.c, a2.c, a1.d, a2.d, f4);
            float f3 = ae.b(a1.e, a2.e, a1.f, a2.f, f4);
            f4 = ae.b(a1.g, a2.g, a1.h, a2.h, f4);
            obj = com.tremorvideo.sdk.android.richmedia.b.a(f3, f4, c.c());
            p1.a(f1 - ((PointF) (obj)).x, f2 - ((PointF) (obj)).y, f3, f4, this.l, c.c());
            f4 = p1.h();
            f3 = p1.i();
            float f5 = p1.j();
            float f6 = p1.k();
            f2 = f3;
            f1 = f4;
            if (c.a() != null)
            {
                Object obj1 = c.a().c(p1, l);
                f1 = ((k) (obj1)).a;
                f2 = ((k) (obj1)).b;
                obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                f1 = f4 + f1 + (float)((Point) (obj1)).x;
                f2 = f3 + f2 + (float)((Point) (obj1)).y;
            }
            p1 = a(p1, l, new RectF(f1, f2, f5 + f1, f6 + f2));
            return new k(((RectF) (p1)).left, ((RectF) (p1)).top, ((RectF) (p1)).right - ((RectF) (p1)).left, ((RectF) (p1)).bottom - ((RectF) (p1)).top, 1.0F, 1.0F, 0.0F);
        } else
        {
            return k.h;
        }
    }

    protected void b(Canvas canvas, int j, int l, int i1, int j1)
    {
        Paint paint = c();
        Paint paint1 = b(l, l + j1);
        canvas.drawRect(j, l, j + i1, l + j1, paint1);
        canvas.drawRect(j, l, (j + i1) - 1, (l + j1) - 1, paint);
    }

    protected int c(int j, int l)
    {
        if (t > 0)
        {
            return t;
        } else
        {
            t = e(j, l) + f(j, l) + 2;
            return t;
        }
    }

    protected Paint c()
    {
        if (q != null)
        {
            return q;
        } else
        {
            q = new Paint();
            q.setColor(Color.argb(255, 73, 73, 73));
            q.setStyle(android.graphics.Paint.Style.STROKE);
            return q;
        }
    }

    protected Paint c(int j)
    {
        if (p != null)
        {
            return p;
        } else
        {
            p = new Paint();
            p.setTextSize((float)j * 0.4F);
            p.setColor(-1);
            p.setAntiAlias(true);
            return p;
        }
    }

    protected void c(Canvas canvas, int j, int l, int i1, int j1)
    {
        int k1 = f(i1, j1);
        Paint paint = c(j1);
        String s1 = g.f().p();
        k1 = (k1 - Math.round(paint.measureText(s1))) / 2;
        int l1 = Math.round(((float)j1 - paint.getTextSize()) / 2.0F);
        b(canvas, j, l, i1, j1);
        canvas.drawText(s1, k1 + j, ((float)(l1 + l) + paint.getTextSize()) - paint.descent(), paint);
    }

    protected int d(int j, int l)
    {
        if (u > 0)
        {
            return u;
        } else
        {
            u = Math.round(c(l).measureText("0000-00-00") + 20F);
            return u;
        }
    }

    protected Paint d(int j)
    {
        if (r != null)
        {
            return r;
        } else
        {
            r = new Paint();
            r.setTextSize((float)j * 0.4F);
            r.setColor(-1);
            r.setAntiAlias(true);
            r.setFakeBoldText(true);
            return r;
        }
    }

    protected a d()
    {
        return new a();
    }

    protected void d(Canvas canvas, int j, int l, int i1, int j1)
    {
        int k1 = d(i1, j1);
        Paint paint = c(j1);
        Object obj = g.f().q();
        int l1 = ((GregorianCalendar) (obj)).get(1);
        int i2 = ((GregorianCalendar) (obj)).get(5);
        obj = String.format("%d-%02d-%02d", new Object[] {
            Integer.valueOf(l1), Integer.valueOf(((GregorianCalendar) (obj)).get(2) + 1), Integer.valueOf(i2)
        });
        k1 = (k1 - Math.round(paint.measureText(((String) (obj))))) / 2;
        l1 = Math.round(((float)(j1 + 0) - paint.getTextSize()) / 2.0F);
        b(canvas, j, l, i1, j1);
        canvas.drawText(((String) (obj)), k1 + (j + 0), ((float)(0 + l + l1) + paint.getTextSize()) - paint.descent(), paint);
    }

    protected int e(int j)
    {
        if (g.f().o() == null)
        {
            return 0;
        }
        if (A <= (double)(-(z + j)))
        {
            A = 0.0D;
        }
        return (int)A + j;
    }

    protected int e(int j, int l)
    {
        return 0;
    }

    protected j e()
    {
        return d();
    }

    protected int f(int j, int l)
    {
        if (y > 0)
        {
            return y;
        } else
        {
            y = Math.round(c(l).measureText("00000") + 20F);
            return y;
        }
    }

    protected int g(int j, int l)
    {
        if (w > 0)
        {
            return w;
        } else
        {
            w = c(j, l) + d(j, l) + 2;
            return w;
        }
    }

    protected int h(int j, int l)
    {
        if (v > 0)
        {
            return v;
        } else
        {
            l = g(j, l);
            v = Math.round(j) - l;
            return v;
        }
    }
}
