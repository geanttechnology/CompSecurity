// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

public final class bxu extends bxi
{

    public int A;
    public int B;
    public String C;
    public int D;
    public int E;
    public String F[];
    private final bmw G;
    private boolean H;
    private String I;
    private int J;
    public String a;
    public String b;
    public String c;
    public String d;
    public int e;
    public boolean j;
    public boolean k;
    public boolean l;
    public String m;
    public long n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public String s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public boolean x;
    public boolean y;
    public int z;

    public bxu(bxm bxm, cpj cpj1, bmw bmw1)
    {
        super(bxm, cpj1.b, bxj.b);
        e = -1;
        j = false;
        k = false;
        H = false;
        l = false;
        m = "";
        n = -1L;
        o = -1;
        p = -1;
        q = -1;
        r = false;
        s = "";
        t = false;
        u = -1;
        v = -1;
        w = -1;
        x = false;
        y = false;
        z = 0;
        A = 0;
        B = 0;
        C = "";
        D = -1;
        E = -1;
        J = -1;
        G = (bmw)b.a(bmw1);
    }

    protected final void a()
    {
        b.a(a);
        b.a(d);
        if (E == -1)
        {
            if (!l)
            {
                boolean flag;
                if (p != -1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                b.b(flag);
                if (u == -1)
                {
                    b.b(false);
                    return;
                }
            } else
            {
                b.a(C);
                return;
            }
        }
    }

    public final String b()
    {
        return "player";
    }

    public final String c()
    {
        cne cne1 = i();
        cne1.a("isAdRequest", l);
        cne1.a("videoId", a);
        cne1.a("playlistId", b(c));
        cne1.a("playlistIndex", a(e));
        cne1.a("allowControversialContent", j);
        cne1.a("allowAdultContent", k);
        cne1.a("isOfflineRequest", false);
        cne1.a("dataExpiredForSeconds", a(D));
        cne1.a("onBehalfOfClientName", a(E));
        cne1.a("autoplay", r);
        cne1.a("scriptedPlay", t);
        cne1.a("adSystem", z);
        cne1.a("adType", A);
        cne1.a("instreamType", B);
        cne1.a("hostVideoId", b(C));
        cne1.a("playerParams", b(b));
        return cne1.a();
    }

    public final eun d()
    {
        boolean flag = false;
        dub dub1 = new dub();
        dub1.e = k;
        dub1.c = j;
        dub1.b = a;
        dub1.f = false;
        dub1.d = new dta();
        dub1.a = h();
        b.a(dub1.a.f);
        b.a(dub1.a.f.a);
        dor ador[] = dub1.a.f.a;
        int i1 = ador.length;
        for (int i = 0; i < i1;)
        {
            dor dor1 = ador[i];
            boolean flag1 = flag;
            if (dor1.b.equals("ms"))
            {
                flag1 = flag;
                if (dor1.c != null)
                {
                    flag1 = true;
                }
            }
            i++;
            flag = flag1;
        }

        b.b(flag);
        if (dub1.a.a == null)
        {
            dub1.a.a = new dhf();
        }
        dub1.a.a.k = d;
        if (!TextUtils.isEmpty(b))
        {
            dub1.i = b;
        }
        if (!TextUtils.isEmpty(c))
        {
            dub1.g = c;
            if (e >= 0)
            {
                dub1.h = e;
            }
        }
        if (!l)
        {
            dip dip1 = new dip();
            if (!TextUtils.isEmpty(m))
            {
                dip1.a = m;
            }
            if (n != -1L)
            {
                dip1.c = n;
            }
            if (o != -1)
            {
                dip1.b = o;
            }
            if (q != -1)
            {
                dip1.d = q;
            }
            if (u != -1)
            {
                dip1.f = u;
            }
            dip1.h = r;
            dip1.i = s;
            dip1.g = t;
            dip1.e = p;
            if (v != -1 || w != -1)
            {
                ddr ddr1 = new ddr();
                if (v != -1)
                {
                    ddr1.a = v;
                }
                if (w != -1)
                {
                    ddr1.b = w;
                }
                ddr1.c = x;
                ddr1.d = y;
                dip1.j = ddr1;
            }
            if (F != null && F.length > 0)
            {
                dip1.k = new dkz();
                dip1.k.a = (String[])Arrays.copyOf(F, F.length);
            }
            dub1.d.a = dip1;
        } else
        {
            dci dci1 = new dci();
            dci1.a = z;
            dci1.b = A;
            dci1.c = B;
            dci1.d = C;
            dub1.d.b = dci1;
        }
        if (D != -1)
        {
            dwb dwb1 = new dwb();
            dwb1.a = D;
            dub1.d.d = dwb1;
        }
        if (E != -1)
        {
            dhf dhf1 = new dhf();
            dhf1.e = E;
            dub1.a.e = dhf1;
        }
        if (J != -1)
        {
            dub1.d.c = new dvf();
            dub1.d.c.a = J;
        }
        return dub1;
    }

    public final Map f()
    {
        if (f == null)
        {
            super.f();
            if (I == null)
            {
                I = G.a(9);
            }
            f.put("id", a);
            f.put("t", I);
        }
        return f;
    }
}
