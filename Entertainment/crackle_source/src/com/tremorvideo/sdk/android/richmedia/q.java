// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.graphics.PointF;
import android.graphics.RectF;
import com.tremorvideo.sdk.android.richmedia.a.i;
import com.tremorvideo.sdk.android.richmedia.b.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            b, h, w, ab, 
//            s, u, x, r, 
//            ac, t, aa, z, 
//            v, j, e, o, 
//            a, k, p, m

public abstract class q
{
    protected class a
    {

        public j a;
        public j b;
        public float c;
        final q d;

        protected a()
        {
            d = q.this;
            super();
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        private static final b d[];

        public static b valueOf(String s1)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/richmedia/q$b, s1);
        }

        public static b[] values()
        {
            return (b[])d.clone();
        }

        static 
        {
            a = new b("Normal", 0);
            b = new b("Smaller", 1);
            c = new b("Larger", 2);
            d = (new b[] {
                a, b, c
            });
        }

        private b(String s1, int i1)
        {
            super(s1, i1);
        }
    }


    public float a;
    public float b;
    protected com.tremorvideo.sdk.android.richmedia.b c;
    protected h d;
    protected int e;
    protected List f;
    protected o g;
    protected boolean h;
    protected boolean i;
    protected int j;
    protected boolean k;
    protected b l;
    protected int m;
    protected boolean n;

    public q(o o1)
    {
        c = new com.tremorvideo.sdk.android.richmedia.b(this);
        j = 0;
        k = true;
        l = com.tremorvideo.sdk.android.richmedia.b.a;
        m = 0;
        n = false;
        g = o1;
        d = new h();
    }

    public static q a(o o1, int i1)
        throws Exception
    {
        if (i1 == 0x125cdd26)
        {
            return new w(o1);
        }
        if (i1 == 0x55e9b1c8)
        {
            return new ab(o1);
        }
        if (i1 == 0x5543b163)
        {
            return new s(o1);
        }
        if (i1 == 0x55e213ea)
        {
            return new u(o1);
        }
        if (i1 == 0x130c6851)
        {
            return new x(o1);
        }
        if (i1 == 0x4e3fcdbf)
        {
            return new r(o1);
        }
        if (i1 == 0x1345f6ba)
        {
            return new ac(o1);
        }
        if (i1 == 0x7aa6085f)
        {
            return new t(o1);
        }
        if (i1 == 0x629b2a5a)
        {
            return new aa(o1);
        }
        if (i1 == 0x39763ebd)
        {
            return new com.tremorvideo.sdk.android.richmedia.b.a(o1);
        }
        if (i1 == 0x2a0e2f)
        {
            return new i(o1);
        }
        if (i1 == 0xdee84e)
        {
            return new z(o1);
        }
        if (i1 == 0x27389e)
        {
            return new i(o1);
        }
        if (i1 == 0xb8878cc)
        {
            return new v(o1);
        } else
        {
            throw new Exception((new StringBuilder()).append("Loading Scene Object: Unknown type: ").append(i1).toString());
        }
    }

    protected RectF a(p p, long l1, RectF rectf)
    {
        if (c.a(0) != null)
        {
            b.a a1 = c.a(0);
            rectf.left = com.tremorvideo.sdk.android.richmedia.b.a(a1.a(g).c(p, l1), a1.a()).x;
        }
        if (c.a(1) != null)
        {
            Object obj = c.a(1);
            obj = com.tremorvideo.sdk.android.richmedia.b.a(((b.a) (obj)).a(g).c(p, l1), ((b.a) (obj)).a());
            float f1 = rectf.left;
            rectf.right = (((PointF) (obj)).x + f1) - rectf.left;
        }
        if (c.a(2) != null)
        {
            b.a a2 = c.a(2);
            rectf.top = com.tremorvideo.sdk.android.richmedia.b.a(a2.a(g).c(p, l1), a2.a()).y;
        }
        if (c.a(3) != null)
        {
            b.a a3 = c.a(3);
            p = com.tremorvideo.sdk.android.richmedia.b.a(a3.a(g).c(p, l1), a3.a());
            float f2 = rectf.top;
            rectf.bottom = (((PointF) (p)).y + f2) - rectf.top;
        }
        return rectf;
    }

    public h.a a(h.c c1)
    {
        return d.a(c1);
    }

    public h.a a(boolean flag)
    {
        if (flag)
        {
            return d.a(h.c.e);
        } else
        {
            return null;
        }
    }

    protected a a(long l1)
    {
        a a1 = new a();
        Iterator iterator = f.iterator();
        long l4 = 0x8000000000000000L;
        long l2 = 0x7fffffffffffffffL;
        while (iterator.hasNext()) 
        {
            j j1 = (j)iterator.next();
            long l3 = l4;
            if (j1.a() <= l1)
            {
                l3 = l4;
                if (j1.a() >= l4)
                {
                    a1.a = j1;
                    l3 = j1.a();
                }
            }
            if (j1.a() >= l1 && j1.a() <= l2)
            {
                a1.b = j1;
                l2 = j1.a();
            }
            l4 = l3;
        }
        if (a1.b == null)
        {
            a1.b = a1.a;
        }
        if (a1.a != null && a1.b != null)
        {
            float f1 = a1.b.a() - a1.a.a();
            if (f1 == 0.0F)
            {
                a1.c = 0.0F;
            } else
            {
                a1.c = (float)(l1 - a1.a.a()) / f1;
            }
            return a1;
        } else
        {
            return null;
        }
    }

    public void a()
    {
    }

    public void a(int i1)
    {
        j = i1;
    }

    public void a(e e1)
    {
        int i1 = 0;
        e = e1.a();
        if (g.f().g() > 1)
        {
            l = b.values()[e1.b()];
        }
        if (g.f().g() > 2)
        {
            m = e1.a();
            if ((m & 1) != 1)
            {
                break MISSING_BLOCK_LABEL_152;
            }
            n = true;
        }
_L1:
        int k1;
        c.a(e1);
        d.a(e1, g.f().g());
        k1 = e1.b();
        f = new ArrayList(k1);
        while (i1 < k1) 
        {
            try
            {
                j j1 = e();
                j1.a(e1);
                f.add(j1);
            }
            // Misplaced declaration of an exception variable
            catch (e e1)
            {
                return;
            }
            i1++;
        }
        break MISSING_BLOCK_LABEL_160;
        n = false;
          goto _L1
        if (d.a(h.c.d) == null)
        {
            break MISSING_BLOCK_LABEL_197;
        }
        h = true;
_L3:
        if (d.a(h.c.k) != null)
        {
            i = true;
            return;
        }
        break MISSING_BLOCK_LABEL_205;
        h = false;
        if (true) goto _L3; else goto _L2
_L2:
        i = false;
        return;
    }

    public void a(m m1, long l1)
    {
    }

    public void a(p p, long l1)
    {
    }

    public boolean a(int i1, int j1)
    {
        return false;
    }

    public h.a b(boolean flag)
    {
        return d.a(h.c.j);
    }

    protected k b(p p, long l1)
    {
        return k.h;
    }

    public void b()
    {
        a = 0.0F;
        b = 0.0F;
    }

    public h.a c(boolean flag)
    {
        return d.a(h.c.k);
    }

    public k c(p p, long l1)
    {
        p = b(p, l1);
        p.a = ((k) (p)).a + a;
        p.b = ((k) (p)).b + b;
        return p;
    }

    protected boolean d(boolean flag)
    {
        if (j == -1)
        {
            flag = false;
        } else
        if (j == 1)
        {
            return true;
        }
        return flag;
    }

    protected abstract j e();

    public boolean f()
    {
        return d.b();
    }

    public boolean g()
    {
        return d.c();
    }

    public int h()
    {
        return e;
    }

    public h i()
    {
        return d;
    }

    public o j()
    {
        return g;
    }

    public boolean k()
    {
        return h;
    }

    public boolean l()
    {
        return i;
    }

    public h.a m()
    {
        return d.a(h.c.d);
    }

    public boolean n()
    {
        return !n || g.f().b;
    }
}
