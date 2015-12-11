// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ert extends eug
{

    private boolean A;
    private double B;
    private boolean C;
    private double D;
    private boolean E;
    private String F;
    private boolean G;
    private String H;
    private boolean I;
    private String J;
    private boolean K;
    private String L;
    private boolean M;
    private String N;
    private boolean O;
    private String P;
    private boolean Q;
    private String R;
    private boolean S;
    private String T;
    private boolean U;
    private esc V;
    private boolean W;
    private String X;
    private boolean Y;
    private String Z;
    private boolean a;
    private boolean aa;
    private String ab;
    private boolean ac;
    private String ad;
    private boolean ae;
    private String af;
    private boolean ag;
    private int ah;
    private boolean ai;
    private int aj;
    private boolean ak;
    private String al;
    private List am;
    private boolean an;
    private eqe ao;
    private boolean ap;
    private erw aq;
    private boolean ar;
    private boolean as;
    private boolean at;
    private ern au;
    private int av;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private double v;
    private boolean w;
    private double x;
    private boolean y;
    private double z;

    public ert()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = "";
        l = "";
        n = "";
        p = "";
        r = "";
        t = "";
        v = 0.0D;
        x = 0.0D;
        z = 0.0D;
        B = 0.0D;
        D = 0.0D;
        F = "";
        H = "";
        J = "";
        L = "";
        N = "";
        P = "";
        R = "";
        T = "";
        V = null;
        X = "";
        Z = "";
        ab = "";
        ad = "";
        af = "";
        ah = 0;
        aj = 0;
        al = "";
        am = Collections.emptyList();
        ao = null;
        aq = null;
        as = false;
        au = null;
        av = -1;
    }

    public final int a()
    {
        if (av < 0)
        {
            b();
        }
        return av;
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
                String s2 = eud1.i();
                c = true;
                d = s2;
                break;

            case 26: // '\032'
                String s3 = eud1.i();
                e = true;
                f = s3;
                break;

            case 34: // '"'
                String s4 = eud1.i();
                g = true;
                h = s4;
                break;

            case 41: // ')'
                double d1 = eud1.b();
                u = true;
                v = d1;
                break;

            case 49: // '1'
                double d2 = eud1.b();
                w = true;
                x = d2;
                break;

            case 58: // ':'
                String s5 = eud1.i();
                E = true;
                F = s5;
                break;

            case 66: // 'B'
                String s6 = eud1.i();
                G = true;
                H = s6;
                break;

            case 74: // 'J'
                String s7 = eud1.i();
                I = true;
                J = s7;
                break;

            case 82: // 'R'
                String s8 = eud1.i();
                K = true;
                L = s8;
                break;

            case 90: // 'Z'
                String s9 = eud1.i();
                M = true;
                N = s9;
                break;

            case 98: // 'b'
                String s10 = eud1.i();
                O = true;
                P = s10;
                break;

            case 106: // 'j'
                String s11 = eud1.i();
                S = true;
                T = s11;
                break;

            case 114: // 'r'
                String s12 = eud1.i();
                W = true;
                X = s12;
                break;

            case 122: // 'z'
                String s13 = eud1.i();
                Y = true;
                Z = s13;
                break;

            case 130: 
                String s14 = eud1.i();
                aa = true;
                ab = s14;
                break;

            case 138: 
                String s15 = eud1.i();
                ac = true;
                ad = s15;
                break;

            case 146: 
                String s16 = eud1.i();
                ae = true;
                af = s16;
                break;

            case 152: 
                int j1 = eud1.f();
                ag = true;
                ah = j1;
                break;

            case 160: 
                int k1 = eud1.f();
                ai = true;
                aj = k1;
                break;

            case 170: 
                String s17 = eud1.i();
                ak = true;
                al = s17;
                break;

            case 178: 
                eso eso1 = new eso();
                eud1.a(eso1);
                if (am.isEmpty())
                {
                    am = new ArrayList();
                }
                am.add(eso1);
                break;

            case 186: 
                String s18 = eud1.i();
                s = true;
                t = s18;
                break;

            case 194: 
                String s19 = eud1.i();
                i = true;
                j = s19;
                break;

            case 202: 
                String s20 = eud1.i();
                k = true;
                l = s20;
                break;

            case 210: 
                String s21 = eud1.i();
                m = true;
                n = s21;
                break;

            case 218: 
                String s22 = eud1.i();
                o = true;
                p = s22;
                break;

            case 226: 
                String s23 = eud1.i();
                q = true;
                r = s23;
                break;

            case 233: 
                double d3 = eud1.b();
                y = true;
                z = d3;
                break;

            case 241: 
                double d4 = eud1.b();
                A = true;
                B = d4;
                break;

            case 250: 
                esc esc1 = new esc();
                eud1.a(esc1);
                U = true;
                V = esc1;
                break;

            case 258: 
                String s24 = eud1.i();
                Q = true;
                R = s24;
                break;

            case 266: 
                eqe eqe1 = new eqe();
                eud1.a(eqe1);
                an = true;
                ao = eqe1;
                break;

            case 274: 
                erw erw1 = new erw();
                eud1.a(erw1);
                ap = true;
                aq = erw1;
                break;

            case 280: 
                boolean flag = eud1.h();
                ar = true;
                as = flag;
                break;

            case 290: 
                ern ern1 = new ern();
                eud1.a(ern1);
                at = true;
                au = ern1;
                break;

            case 297: 
                double d5 = eud1.b();
                C = true;
                D = d5;
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
            eue1.a(2, d);
        }
        if (e)
        {
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (u)
        {
            eue1.a(5, v);
        }
        if (w)
        {
            eue1.a(6, x);
        }
        if (E)
        {
            eue1.a(7, F);
        }
        if (G)
        {
            eue1.a(8, H);
        }
        if (I)
        {
            eue1.a(9, J);
        }
        if (K)
        {
            eue1.a(10, L);
        }
        if (M)
        {
            eue1.a(11, N);
        }
        if (O)
        {
            eue1.a(12, P);
        }
        if (S)
        {
            eue1.a(13, T);
        }
        if (W)
        {
            eue1.a(14, X);
        }
        if (Y)
        {
            eue1.a(15, Z);
        }
        if (aa)
        {
            eue1.a(16, ab);
        }
        if (ac)
        {
            eue1.a(17, ad);
        }
        if (ae)
        {
            eue1.a(18, af);
        }
        if (ag)
        {
            eue1.a(19, ah);
        }
        if (ai)
        {
            eue1.a(20, aj);
        }
        if (ak)
        {
            eue1.a(21, al);
        }
        for (Iterator iterator = am.iterator(); iterator.hasNext(); eue1.b(22, (eso)iterator.next())) { }
        if (s)
        {
            eue1.a(23, t);
        }
        if (i)
        {
            eue1.a(24, j);
        }
        if (k)
        {
            eue1.a(25, l);
        }
        if (m)
        {
            eue1.a(26, n);
        }
        if (o)
        {
            eue1.a(27, p);
        }
        if (q)
        {
            eue1.a(28, r);
        }
        if (y)
        {
            eue1.a(29, z);
        }
        if (A)
        {
            eue1.a(30, B);
        }
        if (U)
        {
            eue1.b(31, V);
        }
        if (Q)
        {
            eue1.a(32, R);
        }
        if (an)
        {
            eue1.b(33, ao);
        }
        if (ap)
        {
            eue1.b(34, aq);
        }
        if (ar)
        {
            eue1.a(35, as);
        }
        if (at)
        {
            eue1.b(36, au);
        }
        if (C)
        {
            eue1.a(37, D);
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
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(5, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(6, x);
        }
        j1 = i1;
        if (E)
        {
            j1 = i1 + eue.b(7, F);
        }
        i1 = j1;
        if (G)
        {
            i1 = j1 + eue.b(8, H);
        }
        j1 = i1;
        if (I)
        {
            j1 = i1 + eue.b(9, J);
        }
        i1 = j1;
        if (K)
        {
            i1 = j1 + eue.b(10, L);
        }
        j1 = i1;
        if (M)
        {
            j1 = i1 + eue.b(11, N);
        }
        i1 = j1;
        if (O)
        {
            i1 = j1 + eue.b(12, P);
        }
        j1 = i1;
        if (S)
        {
            j1 = i1 + eue.b(13, T);
        }
        i1 = j1;
        if (W)
        {
            i1 = j1 + eue.b(14, X);
        }
        j1 = i1;
        if (Y)
        {
            j1 = i1 + eue.b(15, Z);
        }
        i1 = j1;
        if (aa)
        {
            i1 = j1 + eue.b(16, ab);
        }
        j1 = i1;
        if (ac)
        {
            j1 = i1 + eue.b(17, ad);
        }
        i1 = j1;
        if (ae)
        {
            i1 = j1 + eue.b(18, af);
        }
        j1 = i1;
        if (ag)
        {
            j1 = i1 + eue.d(19, ah);
        }
        i1 = j1;
        if (ai)
        {
            i1 = j1 + eue.d(20, aj);
        }
        j1 = i1;
        if (ak)
        {
            j1 = i1 + eue.b(21, al);
        }
        for (Iterator iterator = am.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(22, (eso)iterator.next()) + j1;
        }

        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(23, t);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(24, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(25, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(26, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(27, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(28, r);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.b(29, z);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.b(30, B);
        }
        i1 = j1;
        if (U)
        {
            i1 = j1 + eue.d(31, V);
        }
        j1 = i1;
        if (Q)
        {
            j1 = i1 + eue.b(32, R);
        }
        i1 = j1;
        if (an)
        {
            i1 = j1 + eue.d(33, ao);
        }
        j1 = i1;
        if (ap)
        {
            j1 = i1 + eue.d(34, aq);
        }
        i1 = j1;
        if (ar)
        {
            i1 = j1 + eue.b(35, as);
        }
        j1 = i1;
        if (at)
        {
            j1 = i1 + eue.d(36, au);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.b(37, D);
        }
        av = i1;
        return i1;
    }
}
