// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public final class rl
    implements cwu, czc, rg
{

    private final cnb A;
    private boolean B;
    private final rv C;
    private final ctw D;
    private bhx E;
    private boolean F;
    private boolean G;
    private boolean H;
    private cse I;
    private rk J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private cke O;
    private bhv P;
    cyr a;
    final cyp b;
    final ckk c;
    final Context d;
    final bmi e;
    final rs f;
    int g;
    int h;
    bxb i;
    final bwu j;
    boolean k;
    int l;
    ctt m;
    final rp n = new rp(this);
    float o;
    int p;
    private final Handler q = new Handler(Looper.getMainLooper(), new ro(this));
    private final cyz r;
    private final cyr s = new cyr();
    private final cyr t = new cyr();
    private final ow u;
    private final bmw v;
    private final czh w;
    private String x;
    private buz y;
    private bfz z;

    rl(bmi bmi1, ckk ckk1, Context context, cyp cyp1, cnb cnb1, ow ow1, rs rs1, 
            rv rv1, ctw ctw1, ckt ckt, bwu bwu1, bmw bmw1, czh czh1)
    {
        p = 4;
        e = (bmi)b.a(bmi1);
        c = (ckk)b.a(ckk1);
        d = (Context)b.a(context);
        b = (cyp)b.a(cyp1);
        A = (cnb)b.a(cnb1);
        u = ow1;
        f = (rs)b.a(rs1);
        C = (rv)b.a(rv1);
        D = (ctw)b.a(ctw1);
        b.a(ckt);
        j = bwu1;
        v = (bmw)b.a(bmw1);
        w = (czh)b.a(czh1);
        B = false;
        o = 1.0F;
        l = 1;
        c(ctt.a);
        r = new cyz(new bis(), this, bmi1);
        a = s;
        rs1.d.f = this;
        P = new rm(this);
        ckk1.a(q);
    }

    private void A()
    {
        Object obj1;
        rs rs1;
        String s1;
        bxb bxb1;
        csg csg1;
        String s3;
        boolean flag;
        boolean flag1;
        r.a(true);
        if (J != null)
        {
            return;
        }
        k = false;
        if (b(ctt.j))
        {
            g = 0;
            c(ctt.h);
        }
        y = null;
        z = null;
        rs1 = f;
        s1 = x;
        bxb1 = i;
        obj1 = D.i();
        flag = D.e();
        flag1 = D.f();
        csg1 = C.b();
        s3 = D.h();
        if (!rs1.v) goto _L2; else goto _L1
_L1:
        if (!a(ctt.h))
        {
            c(ctt.h);
        }
        w();
        B();
        bws bws = A.c();
        obj1 = i.h();
        b.a(new csr(((bwp) (obj1)).a(bws), ((bwp) (obj1)).b(bws)));
        c.a(i.d, g, x, ((bwp) (obj1)));
        return;
_L2:
        String s2;
        if (!rs1.u)
        {
            bmo.b("ERROR reset onPlayVideo called for new video with out reset being called. Clients in correct state");
        }
        b.a(s1);
        rs1.v = true;
        rs1.u = false;
        if (rs1.b != null)
        {
            rs.a(rs1.b);
            rs1.b = null;
        }
        s2 = bxb.a(bxb1.a);
        if (!s2.equals(rs1.q))
        {
            if (!rs1.a(s2))
            {
                break; /* Loop/switch isn't completed */
            }
            rs1.a(s1, csg1);
        }
_L5:
        rs1.q = s2;
        rs1.r = null;
        rs1.g = rs1.f.a(s1);
        if (true) goto _L1; else goto _L3
_L3:
        if (rs1.x) goto _L5; else goto _L4
_L4:
        Object obj;
        int i1;
        bst bst1 = bxb1.g();
        rs1.x = false;
        obj = rs1.d;
        dlt dlt1 = bxb1.a.c;
        b.a(((cwq) (obj)).f);
        b.a(s2);
        dtj adtj[];
        int j1;
        if (dlt1 != null && !TextUtils.isEmpty(dlt1.a) && dlt1.b > 0L && dlt1.c != 0L)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 != 0)
        {
            obj = new cwo(((cwq) (obj)).a, ((cwq) (obj)).b, ((cwq) (obj)).c, ((cwq) (obj)).d, ((cwq) (obj)).f, dlt1.a, dlt1.b, dlt1.c, s2, ((cwq) (obj)).e);
        } else
        {
            obj = null;
        }
        rs1.e = ((cwo) (obj));
        if (rs1.h != null)
        {
            obj = rs1.h;
        }
        rs1.j = rs1.i.a(bst1.f, s1);
        rs1.l = rs1.k.a(bst1.e, s1, s2, bxb.b(bxb1.a), null);
        rs1.n = rs1.m.a(bst1.b, bst1.c, bst1.d, s2, s1, s3, bxb1.e(), flag, flag1, ((ctn) (obj1)), csg1);
        rs1.p = rs1.o.a(bxb1.l(), bst1.a, s1, bxb1.e());
        if (bxb1.e != null) goto _L7; else goto _L6
_L6:
        obj1 = null;
        adtj = bxb1.a.d;
        j1 = adtj.length;
        i1 = 0;
_L8:
        obj = obj1;
        if (i1 < j1)
        {
            obj = adtj[i1];
            if (((dtj) (obj)).d == null)
            {
                break MISSING_BLOCK_LABEL_787;
            }
            obj = ((dtj) (obj)).d.a;
        }
        if (obj != null)
        {
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = a.a(((ear) (obj)));
                obj.S = 0x7fffffffffffffffL;
                obj = ((bvd) (obj)).a();
            }
            bxb1.e = ((buz) (obj));
            if (bxb1.e != null)
            {
                obj = bxb1.e.a();
                obj.r = bxb1.e();
                obj.j = bxb.a(bxb1.a);
                obj.u = bxb1.h();
                bxb1.e = ((bvd) (obj)).a();
            }
        }
_L7:
        rs1.c = bxb1.e;
        if (rs1.c != null)
        {
            rs1.b = rs1.a.a(rs1.c, s1);
            rs1.b.e();
        }
          goto _L5
        i1++;
          goto _L8
    }

    private void B()
    {
        if (y())
        {
            b(false);
        } else
        if (B)
        {
            k();
            return;
        }
    }

    private boolean C()
    {
        return y != null && y.b(e);
    }

    private void D()
    {
        h = E();
        g = n();
    }

    private int E()
    {
        if (m.d())
        {
            return u();
        }
        if (C())
        {
            return h;
        } else
        {
            return 0;
        }
    }

    private rk a(boolean flag, int i1)
    {
        Object obj;
        Object obj1;
        Object obj2;
        boolean flag1;
        boolean flag2;
        boolean flag3;
label0:
        {
            if (flag)
            {
                break label0;
            }
            if (m.c())
            {
                if (c.l() || l == 2)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } else
            {
                if (k || b(ctt.j))
                {
                    break label0;
                }
                flag1 = true;
            }
        }
_L1:
        if (m == ctt.j)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag)
        {
            obj = null;
        } else
        {
            rs rs1 = f;
            if (rs1.r != null)
            {
                obj = rs1.r;
            } else
            if (rs1.q == null)
            {
                obj = null;
            } else
            {
                String s1 = rs1.q;
                Object obj3;
                Object obj4;
                Object obj5;
                if (rs1.b == null)
                {
                    obj = null;
                } else
                {
                    obj = rs1.b.k();
                }
                if (rs1.e == null)
                {
                    obj1 = null;
                } else
                {
                    obj1 = rs1.e;
                    obj1 = new cwr(((cwo) (obj1)).e, ((cwo) (obj1)).f, ((cwo) (obj1)).g, ((cwo) (obj1)).h, ((cwo) (obj1)).k);
                }
                if (rs1.j == null)
                {
                    obj2 = null;
                } else
                {
                    obj2 = rs1.j.a();
                }
                if (rs1.l == null)
                {
                    obj3 = null;
                } else
                {
                    obj3 = rs1.l;
                    obj3 = new pr(((ph) (obj3)).c.a, ((ph) (obj3)).f, ((ph) (obj3)).g, ((ph) (obj3)).h, ((ph) (obj3)).i, ((ph) (obj3)).a, ((ph) (obj3)).l);
                }
                if (rs1.n == null)
                {
                    obj4 = null;
                } else
                {
                    obj4 = rs1.n;
                    obj4 = new py(((pv) (obj4)).a, ((pv) (obj4)).b, ((pv) (obj4)).c, ((pv) (obj4)).d, ((pv) (obj4)).o, ((pv) (obj4)).e, ((pv) (obj4)).f, ((pv) (obj4)).g, ((pv) (obj4)).h, ((pv) (obj4)).i, ((pv) (obj4)).j, ((pv) (obj4)).p, ((pv) (obj4)).l, ((pv) (obj4)).m, ((pv) (obj4)).q, ((pv) (obj4)).r, ((pv) (obj4)).s, ((pv) (obj4)).u, ((pv) (obj4)).v, ((pv) (obj4)).k, ((pv) (obj4)).w);
                }
                if (rs1.p == null)
                {
                    obj5 = null;
                } else
                {
                    obj5 = rs1.p;
                    obj5 = new vc(((va) (obj5)).c, ((va) (obj5)).d, ((va) (obj5)).e, ((va) (obj5)).f, ((va) (obj5)).g, ((va) (obj5)).h);
                }
                obj = new rt(s1, ((bgj) (obj)), ((cwr) (obj1)), ((cxa) (obj2)), ((pr) (obj3)), ((py) (obj4)), ((vc) (obj5)), rs1.c);
            }
        }
        if (flag)
        {
            obj1 = null;
        } else
        {
            obj1 = new czi(w.a());
        }
        if (i1 > 0)
        {
            i1 = n();
        } else
        {
            i1 = n() + i1;
        }
        if (!flag1)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        i1 = Math.max(i1, 0);
        if (flag)
        {
            obj2 = null;
        } else
        {
            obj2 = x;
        }
        return new rk(flag3, flag2, i1, ((String) (obj2)), ((rt) (obj)), ((czi) (obj1)));
        flag1 = false;
          goto _L1
    }

    private void a(buz buz1)
    {
        if (buz1.V == null)
        {
            if (buz1.d())
            {
                u.a(buz1);
                y = null;
                z = null;
            } else
            if (buz1.l == null)
            {
                b.a(new cnd("fmt.noneavailable", u()));
                y = null;
                z = null;
                s();
                return;
            }
        }
        s();
    }

    private void a(rk rk1, bfz bfz, buz buz1, int i1)
    {
        k = rk1.a;
        H = rk1.b;
        g = rk1.c;
        F = true;
        Object obj;
        if (rk1.d == null)
        {
            obj = v.a(12);
        } else
        {
            obj = rk1.d;
        }
        x = ((String) (obj));
        z = bfz;
        y = buz1;
        h = i1;
        C.a();
        f.a();
        if (rk1.e != null)
        {
            obj = f;
            rt rt1 = rk1.e;
            if (!((rs) (obj)).u)
            {
                bmo.b("ERROR initFromState called without reset being called. Clients in incorrect state");
            }
            obj.r = rt1;
            obj.s = bfz;
            obj.t = buz1;
        }
        if (rk1.f != null)
        {
            bfz = w;
            rk1 = rk1.f.a;
            for (bfz = ((czh) (bfz)).a.iterator(); bfz.hasNext(); rk1.get(((s)bfz.next()).getClass().toString())) { }
        }
    }

    static void a(rl rl1, int i1)
    {
        rl1.d(i1);
    }

    static void a(rl rl1, int i1, int j1, int k1)
    {
        if (i1 >= 0)
        {
            rl1.L = i1;
            rl1.M = j1;
            rl1.N = k1;
            rl1.D();
            long l1 = rl1.a.a(i1);
            rl1.n.b = l1;
            rl1.d(true);
        }
    }

    private transient boolean a(ctt actt[])
    {
        return m.a(actt);
    }

    private void d(int i1)
    {
        if (i1 != 2)
        {
            u.a(y);
        }
        cyp cyp1 = b;
        crz crz1 = new crz(y, i1);
        cyp1.a.c(crz1);
        f.b();
        c(ctt.g);
        if (J != null)
        {
            cyz cyz1 = r;
            cyz1.a(new czb(cyz1, cyz1.e.a));
            return;
        } else
        {
            f.a();
            A();
            return;
        }
    }

    private void d(boolean flag)
    {
        if (a(new ctt[] {
    ctt.e, ctt.f, ctt.h, ctt.i, ctt.j
}))
        {
            cte cte1 = new cte(L, M, N, e.b(), flag);
            f.a(cte1);
            b.a(cte1);
            return;
        }
        String s1 = String.valueOf(m.name());
        if (s1.length() != 0)
        {
            s1 = "Media progress reported outside media playback: ".concat(s1);
        } else
        {
            s1 = new String("Media progress reported outside media playback: ");
        }
        bmo.b(s1);
    }

    private void e(boolean flag)
    {
        D();
        k = true;
        if (flag)
        {
            c.g();
        } else
        {
            c.f();
        }
        if (m == ctt.e)
        {
            c(ctt.d);
        } else
        if (m == ctt.h)
        {
            c(ctt.g);
            return;
        }
    }

    private void v()
    {
        Object obj1 = null;
        Object obj;
        String s1;
        buz buz1;
        boolean flag;
        if (a(ctt.b))
        {
            obj = i;
        } else
        {
            obj = null;
        }
        if (a(ctt.b))
        {
            s1 = x;
        } else
        {
            s1 = null;
        }
        if (m.a())
        {
            buz1 = y;
        } else
        {
            buz1 = null;
        }
        if (i != null)
        {
            obj1 = i.d;
        }
        if (obj1 != null && ((bww) (obj1)).g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = b;
        obj = new ctd(m, ((bxb) (obj)), s1, buz1, flag);
        ((cyp) (obj1)).a.d(obj);
    }

    private void w()
    {
        if (m.d())
        {
            long l1 = a.b(h);
            n.b = l1;
            cte cte1 = new cte(h, y.k * 1000, 0L, e.b(), false);
            f.a(cte1);
            b.a(cte1);
            return;
        } else
        {
            long l2 = a.b(g);
            n.b = l2;
            cte cte2 = new cte(g, o(), 0L, e.b(), false);
            f.a(cte2);
            b.a(cte2);
            return;
        }
    }

    private void x()
    {
        if (I != null)
        {
            cyp cyp1 = b;
            cse cse1 = I;
            cyp1.a.d(cse1);
            cyp1.a.d(new csm());
        }
    }

    private boolean y()
    {
        bww bww1 = null;
        if (m.d())
        {
            if (y != null)
            {
                bww1 = y.l;
            }
        } else
        if (i != null)
        {
            bww1 = i.d;
        }
        return bww1 != null && bww1.c();
    }

    private void z()
    {
        if (!C())
        {
            ctt ctt1;
            if (H)
            {
                ctt1 = ctt.j;
            } else
            {
                ctt1 = ctt.g;
            }
            c(ctt1);
        }
        if (k)
        {
            w();
            return;
        } else
        {
            c();
            return;
        }
    }

    public final void a()
    {
        boolean flag;
        flag = false;
        v();
        r();
        if (k)
        {
            w();
        } else
        {
            d(false);
        }
        x();
        if (c != null && i != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        bwp bwp1;
        obj = i.d;
        bwp1 = i.h();
        if (obj == null || bwp1 == null) goto _L1; else goto _L3
_L3:
        ckk ckk1 = c;
        if (C.b().a == ctr.e)
        {
            flag = true;
        }
        try
        {
            obj = ckk1.a(((bww) (obj)), bwp1, flag);
        }
        catch (ckm ckm1)
        {
            return;
        }
        obj = new cjq(null, null, ((cku) (obj)).c, ((cku) (obj)).d, ((cku) (obj)).e, 3);
        f.a(((cjq) (obj)));
        b.a.d(obj);
        return;
    }

    public final void a(float f1)
    {
        a(f1, j.a);
    }

    void a(float f1, bwp bwp1)
    {
        float f2;
        float f3;
        f3 = 1.0F;
        o = f1;
        f2 = f3;
        if (bwp1 == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (bwp1.a.a != null)
        {
            flag = bwp1.a.a.b;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        f2 = 0.0F;
_L2:
        c.a(f2 * f1);
        return;
_L4:
        f2 = f3;
        if (bwp1.a.a != null)
        {
            f2 = Math.min(1.0F, (float)Math.pow(10D, -bwp1.a.a.a / 20F));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final void a(int i1)
    {
        boolean flag;
        if (i1 >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        g = i1;
    }

    public final void a(bxb bxb1)
    {
        Pattern pattern;
        boolean flag;
        pattern = null;
        b.b(bxb1.f().a());
        i = bxb1;
        bxb1 = bxb1.h();
        if (bxb1.j() > 0 && g == 0)
        {
            g = bxb1.j() * 1000;
        }
        j.a = (bwp)b.a(bxb1);
        w();
        c(ctt.b);
        if (F || G || u == null)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        bxb1 = u;
        bxb bxb2 = i;
        if (!((ow) (bxb1)).a.b(bxb2))
        {
            break MISSING_BLOCK_LABEL_239;
        }
        flag = true;
_L1:
        F = true;
        if (flag)
        {
            c(ctt.c);
            ow ow1 = u;
            bxb bxb3 = i;
            String s1 = x;
            bxb1 = bhx.a(P);
            E = bxb1;
            bhy bhy1 = bhy.a(q, bxb1);
            bfo bfo1;
            if (bxb3.m() != null)
            {
                bxb1 = bxb3.m().a;
            } else
            {
                bxb1 = null;
            }
            bfo1 = ow1.c;
            if (bxb1 != null)
            {
                pattern = Pattern.compile(bxb1);
            }
            bfo1.a(pattern);
            ow1.b.execute(new ox(ow1, bxb3, s1, bhy1));
            return;
        }
        break MISSING_BLOCK_LABEL_250;
        flag = false;
          goto _L1
        if (y != null)
        {
            a(y);
            return;
        } else
        {
            z();
            return;
        }
    }

    public final void a(cke cke)
    {
        O = cke;
        if (!C.d)
        {
            c.a(cke);
        }
    }

    void a(cry cry1)
    {
        if (cry1 == null || cry1.b())
        {
            s();
            return;
        }
        y = cry1.a();
        if (y == null || y.d())
        {
            Object obj = f;
            String s1 = x;
            b.a(s1);
            obj = ((rs) (obj)).a.a(s1, cry1);
            ((bgi) (obj)).c();
            ((bgi) (obj)).a(crw.a);
            ((bgi) (obj)).d();
        }
        if (y != null)
        {
            rs rs1 = f;
            String s2 = x;
            b.a(s2);
            rs1.b = rs1.a.a(s2, cry1);
            rs1.b.e();
            a(y);
            return;
        } else
        {
            s();
            return;
        }
    }

    void a(cse cse1)
    {
        I = cse1;
        if (a(ctt.c))
        {
            c(ctt.b);
        }
        x();
    }

    public final void a(ri ri1)
    {
        G = true;
        bfz bfz = ri1.d;
        buz buz1;
        if (ri1.e != null && !ri1.e.a(e))
        {
            buz1 = ri1.e;
        } else
        {
            buz1 = null;
        }
        bmo.e("PlaybackState set by initFromState");
        a(ri1.a, bfz, buz1, ri1.f);
        if (ri1.b != null) goto _L2; else goto _L1
_L1:
        if (!ri1.c)
        {
            b.a(cth.a);
        }
_L4:
        c.f();
        q();
        return;
_L2:
        if (!ri1.c)
        {
            b.a(cth.b);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(boolean flag)
    {
        k = flag;
    }

    public final boolean a(ctt ctt1)
    {
        return m.a(ctt1);
    }

    public final void b()
    {
        G = false;
        k = false;
        H = false;
        g = 0;
        z = null;
        y = null;
        h = 0;
        x = v.a(12);
        F = false;
        c.f();
        j();
        q();
        C.a();
        f.a();
    }

    public final void b(int i1)
    {
        boolean flag = true;
        cyp cyp1 = b;
        csc csc1 = csc.a;
        cyp1.a.d(csc1);
        if (!m.a(ctt.g))
        {
            bmo.b("Attempting to seek during an ad");
            return;
        }
        g = Math.max(i1, 0);
        boolean flag1 = b(ctt.j);
        if (l == 1)
        {
            c.a(i.d, g, x, i.h());
            i1 = ((flag) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        if (flag1 || b(ctt.g))
        {
            c(ctt.h);
        }
        if (m.e())
        {
            c.b(g);
            if (i1 != 0)
            {
                if (flag1)
                {
                    k = false;
                } else
                {
                    c.e();
                }
            }
            w();
            return;
        } else
        {
            bmo.b("Attempting to seek when video is not playing");
            return;
        }
    }

    public final void b(cse cse1)
    {
        Object obj = cse1;
        if (cse1.d instanceof bou)
        {
            bwb bwb1 = c.b();
            obj = bwb1;
            if (bwb1 == null)
            {
                obj = c.c();
            }
            if (obj != null && ((bwb) (obj)).d())
            {
                return;
            }
            obj = new cse(csf.f, false, d.getString(0x7f0b0103), cse1.d);
        }
        e(false);
        a(((cse) (obj)));
    }

    public final void b(boolean flag)
    {
        boolean flag1 = false;
        if (flag)
        {
            B = false;
        } else
        {
            flag = B;
            if (!C.d)
            {
                flag1 = true;
            }
            B = flag1 | flag;
        }
        if (!C.d)
        {
            c.n();
            C.a(true);
        }
    }

    public final boolean b(ctt ctt1)
    {
        return m == ctt1;
    }

    public final ri c(boolean flag)
    {
        buz buz1 = null;
        if (flag && m.d())
        {
            return null;
        }
        bfz bfz;
        boolean flag1;
        if (flag)
        {
            bfz = null;
        } else
        {
            bfz = z;
            buz1 = y;
        }
        if (D != null && D.c())
        {
            flag1 = D.f();
        } else
        {
            flag1 = false;
        }
        return new ri(a(flag, 0), i, flag1, bfz, buz1, E());
    }

    public final void c()
    {
        if (!a(ctt.d))
        {
            bmo.c("play() called when the player wasn't loaded.");
            return;
        }
        k = false;
        K = false;
        if (l == 3)
        {
            if (b(ctt.j))
            {
                g = 0;
                c(ctt.i);
            }
            c.d();
            return;
        }
        if (y != null && !y.b(e))
        {
            d(2);
            y = null;
            return;
        }
        if (y == null || y.V != null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        ctn ctn;
        csg csg1;
        obj = f;
        obj1 = y;
        ctn = D.i();
        csg1 = C.b();
        if (!((rs) (obj)).w) goto _L4; else goto _L3
_L3:
        c(ctt.e);
        w();
        B();
        obj = A.c();
        obj1 = y.n;
        b.a(new csr(((bwp) (obj1)).a(((bws) (obj))), ((bwp) (obj1)).b(((bws) (obj)))));
        c.a(y.l, h, y.g, ((bwp) (obj1)));
        return;
_L4:
        if (!((rs) (obj)).u)
        {
            bmo.b("ERROR onPlayAd called for new ad without reset being called. Clients in incorrect state");
        }
        if (((rs) (obj)).b == null)
        {
            bmo.b("Ad is playing but there is no ad stats client!!");
        }
        obj.w = true;
        obj.u = false;
        if (!((rs) (obj)).a(((buz) (obj1)).c)) goto _L6; else goto _L5
_L5:
        if (!((buz) (obj1)).c.equals(((rs) (obj)).q))
        {
            ((rs) (obj)).a(((buz) (obj1)).g, csg1);
        }
_L7:
        obj.r = null;
        obj.q = ((buz) (obj1)).c;
        rs.a(((rs) (obj)).g);
        obj.g = ((rs) (obj)).f.a(((buz) (obj1)).g);
        obj.c = null;
        if (((rs) (obj)).b != null)
        {
            ((rs) (obj)).b.c();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (((buz) (obj1)).c != null)
        {
            bst bst1 = ((buz) (obj1)).m;
            obj.j = ((rs) (obj)).i.a(bst1.f, ((buz) (obj1)).g);
            obj.l = ((rs) (obj)).k.a(bst1.e, ((buz) (obj1)).g, ((buz) (obj1)).c, false, ((buz) (obj1)).j);
            obj.n = ((rs) (obj)).m.a(bst1.b, bst1.c, bst1.d, ((buz) (obj1)).c, ((buz) (obj1)).g, ((buz) (obj1)).k, ((buz) (obj1)).j, ctn, csg1);
            obj.p = ((rs) (obj)).o.a(((buz) (obj1)).o, bst1.a, ((buz) (obj1)).g, ((buz) (obj1)).k);
        }
        if (true) goto _L7; else goto _L2
_L2:
        A();
        return;
        if (true) goto _L3; else goto _L8
_L8:
    }

    public final void c(int i1)
    {
        J = a(false, i1);
        K = true;
        g();
    }

    final void c(ctt ctt1)
    {
        m = ctt1;
        String s1 = String.valueOf(ctt1.toString());
        if (s1.length() != 0)
        {
            s1 = "VideoStage: ".concat(s1);
        } else
        {
            s1 = new String("VideoStage: ");
        }
        bmo.e(s1);
        rn.a[ctt1.ordinal()];
        JVM INSTR tableswitch 1 4: default 72
    //                   1 91
    //                   2 109
    //                   3 127
    //                   4 145;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        v();
        return;
_L2:
        a = t;
        a.c();
        continue; /* Loop/switch isn't completed */
_L3:
        a = t;
        a.a();
        continue; /* Loop/switch isn't completed */
_L4:
        a = s;
        a.c();
        continue; /* Loop/switch isn't completed */
_L5:
        a = s;
        a.a();
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final void d()
    {
        c();
    }

    public final boolean e()
    {
        return a(new ctt[] {
            ctt.e, ctt.f
        });
    }

    public final boolean f()
    {
        return a(new ctt[] {
            ctt.h, ctt.i
        });
    }

    public final void g()
    {
        if (c.l())
        {
            c.e();
            D();
        }
    }

    public final void h()
    {
        e(true);
    }

    public final void i()
    {
        e(false);
    }

    public final void j()
    {
        c(ctt.a);
        f.b();
    }

    public final void k()
    {
        if (!C.d || y())
        {
            return;
        }
        if (O != null)
        {
            c.a(O);
            C.a(false);
        } else
        {
            bmo.b("Error: no UI elements available to display video");
        }
        B = false;
    }

    public final void l()
    {
        e(false);
        d(3);
    }

    public final String m()
    {
        if (i == null)
        {
            return null;
        } else
        {
            return bxb.a(i.a);
        }
    }

    public final int n()
    {
        if (m.e() && !k)
        {
            return u();
        }
        if (b(ctt.j))
        {
            return o();
        } else
        {
            return g;
        }
    }

    public final int o()
    {
        if (a(ctt.i) && l == 3)
        {
            return c.i();
        }
        if (a(ctt.b))
        {
            return i.e() * 1000;
        } else
        {
            return 0;
        }
    }

    public final void p()
    {
        rs rs1 = f;
        if (rs1.n != null)
        {
            rs1.n.a();
        }
        if (rs1.l != null)
        {
            ph ph1 = rs1.l;
            ph1.a(po.d);
            if (!ph1.l)
            {
                ph1.c.a();
            }
        }
        if (rs1.p != null)
        {
            rs1.p.a();
        }
        if (rs1.b != null)
        {
            rs1.b.m();
        }
    }

    public final void q()
    {
        if (E != null)
        {
            E.a = true;
            E = null;
        }
        r.a(false);
        cyz cyz1 = r;
        b.a();
        if (cyz1.f != null)
        {
            cyz1.f.a();
            cyz1.f = null;
        }
        cyz1.e = null;
        cyz1.g = false;
        cyz1.h.clear();
        J = null;
        I = null;
        i = null;
        if (!b(ctt.a))
        {
            c(ctt.a);
        }
        L = 0;
        M = 0;
        N = 0;
        l = 1;
        p = 4;
        c.m();
        c.f();
        n.a();
        w();
        r();
    }

    void r()
    {
        cyp cyp1 = b;
        ctf ctf1 = new ctf(p, c.l());
        cyp1.a.d(ctf1);
    }

    void s()
    {
        cyp cyp1 = b;
        csh csh1 = new csh();
        cyp1.a.d(csh1);
        if (y != null)
        {
            c(ctt.d);
        }
        z();
    }

    public final void t()
    {
        a(J, ((bfz) (null)), ((buz) (null)), 0);
        J = null;
        ctt ctt1;
        if (H)
        {
            ctt1 = ctt.j;
        } else
        {
            ctt1 = ctt.g;
        }
        c(ctt1);
        if (!k)
        {
            if (!K)
            {
                l = 1;
            }
            A();
        }
    }

    int u()
    {
        if (c.h() >= 0)
        {
            return c.h();
        } else
        {
            return 0;
        }
    }
}
