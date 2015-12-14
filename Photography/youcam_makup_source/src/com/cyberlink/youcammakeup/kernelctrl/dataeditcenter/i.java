// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter;

import com.cyberlink.youcammakeup.clflurry.ar;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.utility.BeautyMode;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.dataeditcenter:
//            s, r, m, k, 
//            u, q, o, n, 
//            p, t, l

public class i
{

    private Boolean A;
    private Boolean B;
    private q C;
    private o D;
    private o E;
    private String a;
    private int b;
    private boolean c;
    private r d;
    private s e;
    private m f;
    private k g;
    private u h;
    private n i;
    private p j;
    private t k;
    private l l;
    private r m;
    private r n;
    private r o;
    private r p;
    private r q;
    private float r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public i()
    {
        a(((String) (null)));
        a(0);
        a(false);
        e = null;
        d = null;
        f = null;
        m = null;
        n = null;
        o = null;
        q = null;
        p = null;
        r = -1F;
        s = -1F;
        t = -1F;
        u = -1F;
        v = -1F;
        z = -1F;
        w = -1F;
        x = -1F;
        y = -1F;
        A = null;
        B = null;
        h = null;
        a(((q) (null)));
        a(((o) (null)));
        b(((o) (null)));
    }

    public i(i i1)
    {
        Object obj1 = null;
        this();
        if (i1 == null)
        {
            return;
        }
        a(i1.a);
        a(i1.b);
        a(i1.c);
        Object obj;
        if (i1.a() == null)
        {
            obj = null;
        } else
        {
            obj = new s(i1.a());
        }
        e = ((s) (obj));
        if (i1.b() == null)
        {
            obj = null;
        } else
        {
            obj = new r(i1.b());
        }
        d = ((r) (obj));
        if (i1.c() == null)
        {
            obj = null;
        } else
        {
            obj = new m(i1.c());
        }
        f = ((m) (obj));
        if (i1.e() == null)
        {
            obj = null;
        } else
        {
            obj = new r(i1.e());
        }
        m = ((r) (obj));
        if (i1.f() == null)
        {
            obj = null;
        } else
        {
            obj = new r(i1.f());
        }
        n = ((r) (obj));
        if (i1.d() == null)
        {
            obj = null;
        } else
        {
            obj = new k(i1.d());
        }
        g = ((k) (obj));
        if (i1.g() == null)
        {
            obj = null;
        } else
        {
            obj = new r(i1.g());
        }
        o = ((r) (obj));
        if (i1.i() == null)
        {
            obj = null;
        } else
        {
            obj = new r(i1.i());
        }
        p = ((r) (obj));
        if (i1.h() == null)
        {
            obj = null;
        } else
        {
            obj = new r(i1.h());
        }
        q = ((r) (obj));
        if (i1.u() == null)
        {
            obj = null;
        } else
        {
            obj = new u(i1.u());
        }
        h = ((u) (obj));
        r = i1.j();
        s = i1.k();
        t = i1.l();
        u = i1.m();
        v = i1.n();
        z = i1.r();
        w = i1.o();
        x = i1.p();
        y = i1.q();
        A = i1.s();
        B = i1.t();
        i = i1.y();
        j = i1.z();
        k = i1.A();
        l = i1.B();
        if (i1.C() == null)
        {
            obj = null;
        } else
        {
            obj = new q(i1.C());
        }
        a(((q) (obj)));
        if (i1.D() == null)
        {
            obj = null;
        } else
        {
            obj = new o(i1.D());
        }
        a(((o) (obj)));
        if (i1.E() == null)
        {
            i1 = obj1;
        } else
        {
            i1 = new o(i1.E());
        }
        b(i1);
    }

    public t A()
    {
        return k;
    }

    public l B()
    {
        return l;
    }

    public q C()
    {
        return C;
    }

    public o D()
    {
        return D;
    }

    public o E()
    {
        return E;
    }

    public r a(BeautyMode beautymode)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.l.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[BeautyMode.m.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[BeautyMode.a.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[BeautyMode.b.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[BeautyMode.v.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.s.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.x.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.y.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[beautymode.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return e();

        case 2: // '\002'
            return f();

        case 3: // '\003'
            return g();

        case 4: // '\004'
            return i();

        case 5: // '\005'
            return h();

        case 6: // '\006'
            return c();

        case 7: // '\007'
            return u();

        case 8: // '\b'
            return C();
        }
    }

    public s a()
    {
        return e;
    }

    public void a(float f1)
    {
        r = f1;
    }

    public void a(int i1)
    {
        b = i1;
    }

    public void a(ar ar1)
    {
        Object obj = i();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.c, ((r) (obj)), ar1);
        obj = g();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.d, ((r) (obj)), ar1);
        obj = f();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.k, ((r) (obj)), ar1);
        obj = e();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.j, ((r) (obj)), ar1);
        obj = a();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.m, ((r) (obj)), ar1);
        obj = c();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.n, ((r) (obj)), ar1);
        obj = u();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.v, ((r) (obj)), ar1);
        obj = b();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.l, ((r) (obj)), ar1);
        obj = h();
        ar.a(com.cyberlink.youcammakeup.clflurry.YMKApplyEvent.FeatureName.t, ((r) (obj)), ar1);
        obj = y();
        if (obj != null)
        {
            ((n) (obj)).a(ar1);
        }
        obj = z();
        if (obj != null)
        {
            ((p) (obj)).a(ar1);
        }
        obj = A();
        if (obj != null)
        {
            ((t) (obj)).a(ar1);
        }
        obj = B();
        if (obj != null)
        {
            ((l) (obj)).a(ar1);
        }
        com.cyberlink.youcammakeup.clflurry.b.a(ar1.e());
    }

    public void a(k k1)
    {
        g = k1;
    }

    public void a(l l1)
    {
        l = l1;
    }

    public void a(m m1)
    {
        f = new m(m1);
    }

    public void a(n n1)
    {
        i = n1;
    }

    public void a(o o1)
    {
        D = o1;
    }

    public void a(p p1)
    {
        j = p1;
    }

    public void a(q q1)
    {
        C = q1;
    }

    public void a(r r1)
    {
        d = new r(r1);
    }

    public void a(s s1)
    {
        e = new s(s1);
    }

    public void a(t t1)
    {
        k = t1;
    }

    public void a(u u1)
    {
        h = u1;
    }

    public void a(BeautyMode beautymode, r r1)
    {
        switch (_cls1.a[beautymode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            b(r1);
            return;

        case 2: // '\002'
            c(r1);
            return;

        case 3: // '\003'
            d(r1);
            return;

        case 4: // '\004'
            f(r1);
            return;

        case 5: // '\005'
            e(r1);
            break;
        }
    }

    public void a(Boolean boolean1)
    {
        A = boolean1;
    }

    public void a(String s1)
    {
        a = s1;
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public r b()
    {
        return d;
    }

    public void b(float f1)
    {
        s = f1;
    }

    public void b(o o1)
    {
        E = o1;
    }

    public void b(r r1)
    {
        m = new r(r1);
    }

    public void b(Boolean boolean1)
    {
        B = boolean1;
    }

    public m c()
    {
        return f;
    }

    public void c(float f1)
    {
        t = f1;
    }

    public void c(r r1)
    {
        n = new r(r1);
    }

    public k d()
    {
        return g;
    }

    public void d(float f1)
    {
        u = f1;
    }

    public void d(r r1)
    {
        o = new r(r1);
    }

    public r e()
    {
        return m;
    }

    public void e(float f1)
    {
        v = f1;
    }

    public void e(r r1)
    {
        q = new r(r1);
    }

    public r f()
    {
        return n;
    }

    public void f(float f1)
    {
        w = f1;
    }

    public void f(r r1)
    {
        p = new r(r1);
    }

    public r g()
    {
        return o;
    }

    public void g(float f1)
    {
        x = f1;
    }

    public r h()
    {
        return q;
    }

    public void h(float f1)
    {
        z = f1;
    }

    public r i()
    {
        return p;
    }

    public void i(float f1)
    {
        y = f1;
    }

    public float j()
    {
        return r;
    }

    public float k()
    {
        return s;
    }

    public float l()
    {
        return t;
    }

    public float m()
    {
        return u;
    }

    public float n()
    {
        return v;
    }

    public float o()
    {
        return w;
    }

    public float p()
    {
        return x;
    }

    public float q()
    {
        return y;
    }

    public float r()
    {
        return z;
    }

    public Boolean s()
    {
        return A;
    }

    public Boolean t()
    {
        return B;
    }

    public u u()
    {
        return h;
    }

    public String v()
    {
        return a;
    }

    public int w()
    {
        return b;
    }

    public boolean x()
    {
        return c;
    }

    public n y()
    {
        return i;
    }

    public p z()
    {
        return j;
    }
}
