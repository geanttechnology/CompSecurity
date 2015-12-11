// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class evg extends eug
{

    private boolean A;
    private float B;
    private boolean C;
    private float D;
    private boolean E;
    private int F;
    private boolean G;
    private boolean H;
    private boolean I;
    private evf J;
    private boolean K;
    private int L;
    private boolean M;
    private float N;
    private boolean O;
    private int P;
    private boolean Q;
    private String R;
    private boolean S;
    private String T;
    private List U;
    private boolean V;
    private String W;
    private boolean X;
    private String Y;
    private boolean Z;
    private boolean a;
    private int aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private long ae;
    private boolean af;
    private evc ag;
    private boolean ah;
    private boolean ai;
    private int aj;
    private String b;
    private boolean c;
    private euc d;
    private boolean e;
    private int f;
    private boolean g;
    private int h;
    private boolean i;
    private eva j;
    private boolean k;
    private float l;
    private boolean m;
    private eve n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private int x;
    private boolean y;
    private float z;

    public evg()
    {
        b = "";
        d = euc.b;
        f = 0;
        h = 0;
        j = null;
        l = 0.0F;
        n = null;
        p = "";
        r = "";
        t = "";
        v = "";
        x = 0;
        z = 0.0F;
        B = 0.0F;
        D = 0.0F;
        F = 0;
        H = false;
        J = null;
        L = 0;
        N = 0.0F;
        P = 0;
        R = "";
        T = "";
        U = Collections.emptyList();
        W = "";
        Y = "";
        aa = 0;
        ac = false;
        ae = 0L;
        ag = null;
        ai = false;
        aj = -1;
    }

    public final int a()
    {
        if (aj < 0)
        {
            b();
        }
        return aj;
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

            case 18: // '\022'
                euc euc1 = eud1.j();
                c = true;
                d = euc1;
                break;

            case 24: // '\030'
                int j1 = eud1.f();
                g = true;
                h = j1;
                break;

            case 37: // '%'
                float f1 = eud1.c();
                k = true;
                l = f1;
                break;

            case 42: // '*'
                eve eve1 = new eve();
                eud1.a(eve1);
                m = true;
                n = eve1;
                break;

            case 50: // '2'
                String s2 = eud1.i();
                o = true;
                p = s2;
                break;

            case 58: // ':'
                String s3 = eud1.i();
                q = true;
                r = s3;
                break;

            case 66: // 'B'
                String s4 = eud1.i();
                s = true;
                t = s4;
                break;

            case 74: // 'J'
                String s5 = eud1.i();
                u = true;
                v = s5;
                break;

            case 80: // 'P'
                int k1 = eud1.f();
                w = true;
                x = k1;
                break;

            case 93: // ']'
                float f2 = eud1.c();
                y = true;
                z = f2;
                break;

            case 101: // 'e'
                float f3 = eud1.c();
                A = true;
                B = f3;
                break;

            case 109: // 'm'
                float f4 = eud1.c();
                C = true;
                D = f4;
                break;

            case 112: // 'p'
                int l1 = eud1.f();
                E = true;
                F = l1;
                break;

            case 120: // 'x'
                boolean flag = eud1.h();
                G = true;
                H = flag;
                break;

            case 130: 
                evf evf1 = new evf();
                eud1.a(evf1);
                I = true;
                J = evf1;
                break;

            case 136: 
                int i2 = eud1.f();
                K = true;
                L = i2;
                break;

            case 149: 
                float f5 = eud1.c();
                M = true;
                N = f5;
                break;

            case 152: 
                int j2 = eud1.f();
                O = true;
                P = j2;
                break;

            case 162: 
                String s6 = eud1.i();
                Q = true;
                R = s6;
                break;

            case 170: 
                a(eud1.i());
                break;

            case 178: 
                evh evh1 = new evh();
                eud1.a(evh1);
                if (U.isEmpty())
                {
                    U = new ArrayList();
                }
                U.add(evh1);
                break;

            case 186: 
                String s7 = eud1.i();
                V = true;
                W = s7;
                break;

            case 192: 
                int k2 = eud1.f();
                Z = true;
                aa = k2;
                break;

            case 200: 
                boolean flag1 = eud1.h();
                ab = true;
                ac = flag1;
                break;

            case 208: 
                long l3 = eud1.e();
                ad = true;
                ae = l3;
                break;

            case 218: 
                evc evc1 = new evc();
                eud1.a(evc1);
                a(evc1);
                break;

            case 226: 
                String s8 = eud1.i();
                X = true;
                Y = s8;
                break;

            case 232: 
                int l2 = eud1.f();
                e = true;
                f = l2;
                break;

            case 242: 
                eva eva1 = new eva();
                eud1.a(eva1);
                i = true;
                j = eva1;
                break;

            case 248: 
                boolean flag2 = eud1.h();
                ah = true;
                ai = flag2;
                break;
            }
        } while (true);
    }

    public final evg a(evc evc1)
    {
        if (evc1 == null)
        {
            throw new NullPointerException();
        } else
        {
            af = true;
            ag = evc1;
            return this;
        }
    }

    public final evg a(String s1)
    {
        S = true;
        T = s1;
        return this;
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (c)
        {
            eue1.a(2, d);
        }
        if (g)
        {
            eue1.a(3, h);
        }
        if (k)
        {
            eue1.a(4, l);
        }
        if (m)
        {
            eue1.b(5, n);
        }
        if (o)
        {
            eue1.a(6, p);
        }
        if (q)
        {
            eue1.a(7, r);
        }
        if (s)
        {
            eue1.a(8, t);
        }
        if (u)
        {
            eue1.a(9, v);
        }
        if (w)
        {
            eue1.a(10, x);
        }
        if (y)
        {
            eue1.a(11, z);
        }
        if (A)
        {
            eue1.a(12, B);
        }
        if (C)
        {
            eue1.a(13, D);
        }
        if (E)
        {
            eue1.a(14, F);
        }
        if (G)
        {
            eue1.a(15, H);
        }
        if (I)
        {
            eue1.b(16, J);
        }
        if (K)
        {
            eue1.a(17, L);
        }
        if (M)
        {
            eue1.a(18, N);
        }
        if (O)
        {
            eue1.a(19, P);
        }
        if (Q)
        {
            eue1.a(20, R);
        }
        if (S)
        {
            eue1.a(21, T);
        }
        for (Iterator iterator = U.iterator(); iterator.hasNext(); eue1.b(22, (evh)iterator.next())) { }
        if (V)
        {
            eue1.a(23, W);
        }
        if (Z)
        {
            eue1.a(24, aa);
        }
        if (ab)
        {
            eue1.a(25, ac);
        }
        if (ad)
        {
            eue1.b(26, ae);
        }
        if (af)
        {
            eue1.b(27, ag);
        }
        if (X)
        {
            eue1.a(28, Y);
        }
        if (e)
        {
            eue1.a(29, f);
        }
        if (i)
        {
            eue1.b(30, j);
        }
        if (ah)
        {
            eue1.a(31, ai);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(3, h);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(4, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(5, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(6, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(7, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(8, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(9, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.d(10, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.b(11, z);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.b(12, B);
        }
        j1 = i1;
        if (C)
        {
            j1 = i1 + eue.b(13, D);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(14, F);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.b(15, H);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.d(16, J);
        }
        j1 = i1;
        if (K)
        {
            j1 = i1 + eue.d(17, L);
        }
        i1 = j1;
        if (M)
        {
            i1 = j1 + eue.b(18, N);
        }
        j1 = i1;
        if (O)
        {
            j1 = i1 + eue.d(19, P);
        }
        i1 = j1;
        if (Q)
        {
            i1 = j1 + eue.b(20, R);
        }
        j1 = i1;
        if (S)
        {
            j1 = i1 + eue.b(21, T);
        }
        for (Iterator iterator = U.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(22, (evh)iterator.next()) + j1;
        }

        i1 = j1;
        if (V)
        {
            i1 = j1 + eue.b(23, W);
        }
        j1 = i1;
        if (Z)
        {
            j1 = i1 + eue.d(24, aa);
        }
        i1 = j1;
        if (ab)
        {
            i1 = j1 + eue.b(25, ac);
        }
        j1 = i1;
        if (ad)
        {
            j1 = i1 + eue.e(26, ae);
        }
        i1 = j1;
        if (af)
        {
            i1 = j1 + eue.d(27, ag);
        }
        j1 = i1;
        if (X)
        {
            j1 = i1 + eue.b(28, Y);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.d(29, f);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(30, j);
        }
        i1 = j1;
        if (ah)
        {
            i1 = j1 + eue.b(31, ai);
        }
        aj = i1;
        return i1;
    }
}
