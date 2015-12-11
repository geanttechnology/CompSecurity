// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            q, o, a, ae, 
//            b, p, k, j, 
//            e

public class ab extends q
{
    protected class a extends j
    {

        final ab A;
        public int e;
        public int f;
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
        public float r;
        public int s;
        public float t;
        public int u;
        public float v;
        public int w;
        public float x;
        public int y;
        public boolean z;

        public void a(e e1)
        {
            super.a(e1);
            try
            {
                e = e1.b();
                f = e1.b();
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
                r = e1.d();
                s = e1.b();
                t = e1.d();
                u = e1.b();
                v = e1.d();
                w = e1.b();
                x = e1.d();
                y = e1.b();
                z = e1.f();
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
            A = ab.this;
            super();
        }
    }

    protected static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        public static final b e;
        public static final b f;
        public static final b g;
        public static final b h;
        public static final b i;
        private static final b j[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/ab$b, s);
        }

        public static b[] values()
        {
            return (b[])j.clone();
        }

        static 
        {
            a = new b("TopLeft", 0);
            b = new b("TopCenter", 1);
            c = new b("TopRight", 2);
            d = new b("CenterLeft", 3);
            e = new b("CenterCenter", 4);
            f = new b("CenterRight", 5);
            g = new b("BottomLeft", 6);
            h = new b("BottomCenter", 7);
            i = new b("BottomRight", 8);
            j = (new b[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private b(String s, int l)
        {
            super(s, l);
        }
    }


    private static int q[] = new int[20];
    private static int r = 0;
    protected final int o[] = {
        10, 20, 30
    };
    protected String p;

    public ab(o o1)
    {
        super(o1);
    }

    private float a(b b1, float f, RectF rectf)
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[b.values().length];
                try
                {
                    a[b.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    a[b.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[b.g.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[b.b.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[b.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[b.h.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[b.c.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[b.f.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[b.i.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[b1.ordinal()])
        {
        default:
            return rectf.left;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
            return rectf.left;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return rectf.left + (rectf.width() - f) / 2.0F;

        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
            return rectf.right - f;
        }
    }

    private void a(String s, TextPaint textpaint, RectF rectf)
    {
        int j;
        j = 0;
        r = 0;
_L2:
        int i;
        int l;
label0:
        {
            if (j < s.length())
            {
                l = textpaint.breakText(s, j, s.length(), true, rectf.width(), null);
                if (l != 0)
                {
                    break label0;
                }
            }
            return;
        }
        if (j + l >= s.length() || Character.isWhitespace(s.charAt(j + l)))
        {
            break; /* Loop/switch isn't completed */
        }
        for (i = l; i > 0 && !Character.isWhitespace(s.charAt(j + i)); i--) { }
        if (i == 0)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        if (r < q.length)
        {
            q[r] = i;
            r++;
        }
        j += i;
        if (true) goto _L2; else goto _L1
_L1:
        i = l;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
    }

    private void a(String s, b b1, RectF rectf, TextPaint textpaint, Canvas canvas)
    {
        int i = 0;
        a(s, textpaint, rectf);
        int j = Math.max(1, (int)Math.floor(rectf.height() / textpaint.getTextSize()));
        float f1 = Math.min(r, j);
        float f2 = textpaint.getTextSize();
        float f = 0.0F;
        if (!g.f().e())
        {
            f = -textpaint.descent();
        }
        int l = Math.round(b(b1, f1 * f2, rectf));
        j = 0;
        for (; (float)i < f1; i++)
        {
            String s1 = s.substring(j, q[i] + j).trim();
            canvas.drawText(s1, a(b1, textpaint.measureText(s1), rectf), (float)l + f + textpaint.getTextSize(), textpaint);
            l = (int)((float)l + textpaint.getTextSize());
            j += q[i];
        }

    }

    private float b(b b1, float f, RectF rectf)
    {
        switch (_cls1.a[b1.ordinal()])
        {
        default:
            return rectf.top;

        case 1: // '\001'
        case 4: // '\004'
        case 7: // '\007'
            return rectf.top;

        case 2: // '\002'
        case 5: // '\005'
        case 8: // '\b'
            return rectf.top + (rectf.height() - f) / 2.0F;

        case 3: // '\003'
        case 6: // '\006'
        case 9: // '\t'
            return rectf.bottom - f;
        }
    }

    protected String a(p p1, a a1, long l)
    {
        if (p != null)
        {
            return p;
        } else
        {
            return g.f().a(a1.e);
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
                float f = a1.c;
                k = ((a) (obj)).z;
                if (((a) (obj)).e != -1 && d(((a) (obj)).z))
                {
                    int j1 = ae.a(((a) (obj)).j, a2.j, ((a) (obj)).k, a2.k, f);
                    int k1 = ae.a(((a) (obj)).l, a2.l, ((a) (obj)).m, a2.m, f);
                    int l1 = ae.a(((a) (obj)).n, a2.n, ((a) (obj)).o, a2.o, f);
                    int i2 = ae.a(((a) (obj)).p, a2.p, ((a) (obj)).q, a2.q, f);
                    int j2 = ae.a(((a) (obj)).r, a2.r, ((a) (obj)).s, a2.s, f);
                    int k2 = ae.a(((a) (obj)).t, a2.t, ((a) (obj)).u, a2.u, f);
                    int l2 = ae.a(((a) (obj)).v, a2.v, ((a) (obj)).w, a2.w, f);
                    int i3 = ae.a(((a) (obj)).x, a2.x, ((a) (obj)).y, a2.y, f);
                    f = ae.b(((a) (obj)).h, a2.h, ((a) (obj)).i, a2.i, f);
                    b b1 = b.values()[((a) (obj)).g];
                    int j3 = o[((a) (obj)).f];
                    obj = a(p1, ((a) (obj)), l);
                    int i1 = Math.round((float)((String) (obj)).length() * f);
                    if (i1 != 0)
                    {
                        if (i1 != ((String) (obj)).length())
                        {
                            int i = i1;
                            if (((String) (obj)).length() < i1)
                            {
                                i = ((String) (obj)).length();
                            }
                            obj = ((String) (obj)).substring(0, i);
                        }
                        Object obj1 = com.tremorvideo.sdk.android.richmedia.b.a(l1, i2, c.c());
                        int j = ((Point) (obj1)).x;
                        i1 = ((Point) (obj1)).y;
                        p1.a(j1 - j, k1 - i1, l1, i2, this.l, c.c());
                        float f4 = p1.h();
                        float f3 = p1.i();
                        float f5 = p1.j();
                        float f6 = p1.k();
                        float f2 = f3;
                        float f1 = f4;
                        if (c.a() != null)
                        {
                            obj1 = c.a().c(p1, l);
                            f1 = Math.round(((k) (obj1)).a);
                            f2 = Math.round(((k) (obj1)).b);
                            obj1 = com.tremorvideo.sdk.android.richmedia.b.a(Math.round(((k) (obj1)).f), Math.round(((k) (obj1)).g), c.b());
                            f1 = f4 + f1 + (float)((Point) (obj1)).x;
                            f2 = f3 + f2 + (float)((Point) (obj1)).y;
                        }
                        obj1 = a(p1, l, new RectF(f1, f2, f5 + f1, f6 + f2));
                        f1 = Math.round(((RectF) (obj1)).left);
                        f2 = Math.round(((RectF) (obj1)).top);
                        f3 = Math.round(((RectF) (obj1)).width());
                        f4 = Math.round(((RectF) (obj1)).height());
                        obj1 = p1.c();
                        ((Canvas) (obj1)).save();
                        TextPaint textpaint = new TextPaint();
                        textpaint.setColor(Color.argb(i3, j2, k2, l2));
                        textpaint.setTextSize((float)j3 * p1.a(this.l));
                        textpaint.setAntiAlias(true);
                        textpaint.setTypeface(Typeface.create("helvetica", 1));
                        a(((String) (obj)), b1, new RectF(f1, f2, f3 + f1, f4 + f2), textpaint, ((Canvas) (obj1)));
                        ((Canvas) (obj1)).restore();
                        return;
                    }
                }
            }
        }
    }

    void a(String s)
    {
        p = s;
    }

    public k b(p p1, long l)
    {
        q.a a1 = a(l);
        if (a1 != null)
        {
            a a2 = (a)a1.a;
            a a3 = (a)a1.b;
            float f3 = a1.c;
            if (a2.e != -1)
            {
                float f = ae.b(a2.j, a3.j, a2.k, a3.k, f3);
                float f1 = ae.b(a2.l, a3.l, a2.m, a3.m, f3);
                float f2 = ae.b(a2.n, a3.n, a2.o, a3.o, f3);
                f3 = ae.b(a2.p, a3.p, a2.q, a3.q, f3);
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

    public void b()
    {
        p = null;
        super.b();
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
