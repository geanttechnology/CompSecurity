// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eph extends eug
{

    private boolean A;
    private long B;
    private List C;
    private boolean D;
    private double E;
    private boolean F;
    private int G;
    private boolean H;
    private String I;
    private boolean J;
    private String K;
    private boolean L;
    private boolean M;
    private boolean N;
    private String O;
    private List P;
    private boolean Q;
    private boolean R;
    private List S;
    private int T;
    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private epl f;
    private boolean g;
    private epk h;
    private boolean i;
    private epj j;
    private boolean k;
    private epi l;
    private boolean m;
    private String n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private euc t;
    private boolean u;
    private String v;
    private boolean w;
    private String x;
    private boolean y;
    private int z;

    public eph()
    {
        b = "";
        d = 0;
        f = null;
        h = null;
        j = null;
        l = null;
        n = "";
        p = "";
        r = "";
        t = euc.b;
        v = "";
        x = "";
        z = 1;
        B = 0L;
        C = Collections.emptyList();
        E = 0.0D;
        G = 0;
        I = "";
        K = "";
        M = false;
        O = "";
        P = Collections.emptyList();
        R = true;
        S = Collections.emptyList();
        T = -1;
    }

    public final int a()
    {
        if (T < 0)
        {
            b();
        }
        return T;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 24: // '\030'
                int j1 = eud1.f();
                c = true;
                d = j1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                q = true;
                r = s2;
                break;

            case 42: // '*'
                String s3 = eud1.i();
                N = true;
                O = s3;
                break;

            case 50: // '2'
                epl epl1 = new epl();
                eud1.a(epl1);
                e = true;
                f = epl1;
                break;

            case 58: // ':'
                epk epk1 = new epk();
                eud1.a(epk1);
                g = true;
                h = epk1;
                break;

            case 66: // 'B'
                epj epj1 = new epj();
                eud1.a(epj1);
                i = true;
                j = epj1;
                break;

            case 74: // 'J'
                String s4 = eud1.i();
                m = true;
                n = s4;
                break;

            case 82: // 'R'
                euc euc1 = eud1.j();
                s = true;
                t = euc1;
                break;

            case 90: // 'Z'
                String s5 = eud1.i();
                u = true;
                v = s5;
                break;

            case 98: // 'b'
                String s6 = eud1.i();
                w = true;
                x = s6;
                break;

            case 112: // 'p'
                long l2 = eud1.e();
                A = true;
                B = l2;
                break;

            case 122: // 'z'
                epm epm1 = new epm();
                eud1.a(epm1);
                if (C.isEmpty())
                {
                    C = new ArrayList();
                }
                C.add(epm1);
                break;

            case 129: 
                double d1 = eud1.b();
                D = true;
                E = d1;
                break;

            case 136: 
                int k1 = eud1.f();
                F = true;
                G = k1;
                break;

            case 146: 
                String s7 = eud1.i();
                H = true;
                I = s7;
                break;

            case 154: 
                String s8 = eud1.i();
                J = true;
                K = s8;
                break;

            case 160: 
                boolean flag = eud1.h();
                L = true;
                M = flag;
                break;

            case 170: 
                epi epi1 = new epi();
                eud1.a(epi1);
                k = true;
                l = epi1;
                break;

            case 176: 
                int l1 = eud1.f();
                if (P.isEmpty())
                {
                    P = new ArrayList();
                }
                P.add(Integer.valueOf(l1));
                break;

            case 184: 
                boolean flag1 = eud1.h();
                Q = true;
                R = flag1;
                break;

            case 194: 
                epf epf1 = new epf();
                eud1.a(epf1);
                if (S.isEmpty())
                {
                    S = new ArrayList();
                }
                S.add(epf1);
                break;

            case 200: 
                int i2 = eud1.f();
                y = true;
                z = i2;
                break;

            case 210: 
                String s9 = eud1.i();
                o = true;
                p = s9;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (c)
        {
            eue1.a(3, d);
        }
        if (q)
        {
            eue1.a(4, r);
        }
        if (N)
        {
            eue1.a(5, O);
        }
        if (e)
        {
            eue1.b(6, f);
        }
        if (g)
        {
            eue1.b(7, h);
        }
        if (i)
        {
            eue1.b(8, j);
        }
        if (m)
        {
            eue1.a(9, n);
        }
        if (s)
        {
            eue1.a(10, t);
        }
        if (u)
        {
            eue1.a(11, v);
        }
        if (w)
        {
            eue1.a(12, x);
        }
        if (A)
        {
            eue1.b(14, B);
        }
        for (Iterator iterator = C.iterator(); iterator.hasNext(); eue1.b(15, (epm)iterator.next())) { }
        if (D)
        {
            eue1.a(16, E);
        }
        if (F)
        {
            eue1.a(17, G);
        }
        if (H)
        {
            eue1.a(18, I);
        }
        if (J)
        {
            eue1.a(19, K);
        }
        if (L)
        {
            eue1.a(20, M);
        }
        if (k)
        {
            eue1.b(21, l);
        }
        for (Iterator iterator1 = P.iterator(); iterator1.hasNext(); eue1.a(22, ((Integer)iterator1.next()).intValue())) { }
        if (Q)
        {
            eue1.a(23, R);
        }
        for (Iterator iterator2 = S.iterator(); iterator2.hasNext(); eue1.b(24, (epf)iterator2.next())) { }
        if (y)
        {
            eue1.a(25, z);
        }
        if (o)
        {
            eue1.a(26, p);
        }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(3, d);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(4, r);
        }
        i1 = j1;
        if (N)
        {
            i1 = j1 + eue.b(5, O);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(6, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(7, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(8, j);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(9, n);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.b(10, t);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.b(11, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.b(12, x);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.e(14, B);
        }
        iterator = C.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(15, (epm)iterator.next()) + j1) { }
        i1 = j1;
        if (D)
        {
            i1 = j1 + eue.b(16, E);
        }
        j1 = i1;
        if (F)
        {
            j1 = i1 + eue.d(17, G);
        }
        i1 = j1;
        if (H)
        {
            i1 = j1 + eue.b(18, I);
        }
        j1 = i1;
        if (J)
        {
            j1 = i1 + eue.b(19, K);
        }
        i1 = j1;
        if (L)
        {
            i1 = j1 + eue.b(20, M);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(21, l);
        }
        iterator = P.iterator();
        for (i1 = ((flag) ? 1 : 0); iterator.hasNext(); i1 += eue.a(((Integer)iterator.next()).intValue())) { }
        j1 = j1 + i1 + P.size() * 2;
        i1 = j1;
        if (Q)
        {
            i1 = j1 + eue.b(23, R);
        }
        iterator = S.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(24, (epf)iterator.next()) + j1) { }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.d(25, z);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(26, p);
        }
        T = j1;
        return j1;
    }
}
