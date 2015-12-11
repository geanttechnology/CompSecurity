// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esf extends eug
{

    private boolean A;
    private String B;
    private boolean C;
    private String D;
    private boolean E;
    private ese F;
    private boolean G;
    private String H;
    private boolean I;
    private boolean J;
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
    private String V;
    private boolean W;
    private String X;
    private List Y;
    private boolean Z;
    private boolean a;
    private erl aa;
    private int ab;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private long h;
    private boolean i;
    private String j;
    private boolean k;
    private int l;
    private boolean m;
    private String n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private ese t;
    private boolean u;
    private String v;
    private boolean w;
    private boolean x;
    private boolean y;
    private String z;

    public esf()
    {
        b = 0;
        d = false;
        f = false;
        h = 0L;
        j = "";
        l = 0;
        n = "";
        p = "";
        r = "";
        t = null;
        v = "";
        x = false;
        z = "";
        B = "";
        D = "";
        F = null;
        H = "";
        J = false;
        L = "";
        N = "";
        P = "";
        R = "";
        T = "";
        V = "";
        X = "";
        Y = Collections.emptyList();
        aa = null;
        ab = -1;
    }

    public final int a()
    {
        if (ab < 0)
        {
            b();
        }
        return ab;
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

            case 8: // '\b'
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                c = true;
                d = flag;
                break;

            case 24: // '\030'
                boolean flag1 = eud1.h();
                e = true;
                f = flag1;
                break;

            case 32: // ' '
                long l1 = eud1.e();
                g = true;
                h = l1;
                break;

            case 42: // '*'
                String s1 = eud1.i();
                i = true;
                j = s1;
                break;

            case 48: // '0'
                int k1 = eud1.f();
                k = true;
                l = k1;
                break;

            case 58: // ':'
                String s2 = eud1.i();
                m = true;
                n = s2;
                break;

            case 66: // 'B'
                String s3 = eud1.i();
                u = true;
                v = s3;
                break;

            case 72: // 'H'
                boolean flag2 = eud1.h();
                w = true;
                x = flag2;
                break;

            case 82: // 'R'
                String s4 = eud1.i();
                y = true;
                z = s4;
                break;

            case 90: // 'Z'
                String s5 = eud1.i();
                G = true;
                H = s5;
                break;

            case 96: // '`'
                boolean flag3 = eud1.h();
                I = true;
                J = flag3;
                break;

            case 106: // 'j'
                String s6 = eud1.i();
                K = true;
                L = s6;
                break;

            case 114: // 'r'
                String s7 = eud1.i();
                M = true;
                N = s7;
                break;

            case 122: // 'z'
                String s8 = eud1.i();
                S = true;
                T = s8;
                break;

            case 130: 
                String s9 = eud1.i();
                U = true;
                V = s9;
                break;

            case 138: 
                esi esi1 = new esi();
                eud1.a(esi1);
                if (Y.isEmpty())
                {
                    Y = new ArrayList();
                }
                Y.add(esi1);
                break;

            case 146: 
                erl erl1 = new erl();
                eud1.a(erl1);
                Z = true;
                aa = erl1;
                break;

            case 154: 
                String s10 = eud1.i();
                q = true;
                r = s10;
                break;

            case 162: 
                String s11 = eud1.i();
                C = true;
                D = s11;
                break;

            case 170: 
                ese ese1 = new ese();
                eud1.a(ese1);
                s = true;
                t = ese1;
                break;

            case 178: 
                ese ese2 = new ese();
                eud1.a(ese2);
                E = true;
                F = ese2;
                break;

            case 186: 
                String s12 = eud1.i();
                A = true;
                B = s12;
                break;

            case 194: 
                String s13 = eud1.i();
                o = true;
                p = s13;
                break;

            case 202: 
                String s14 = eud1.i();
                O = true;
                P = s14;
                break;

            case 210: 
                String s15 = eud1.i();
                Q = true;
                R = s15;
                break;

            case 218: 
                String s16 = eud1.i();
                W = true;
                X = s16;
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
            eue1.b(4, h);
        }
        if (i)
        {
            eue1.a(5, j);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (m)
        {
            eue1.a(7, n);
        }
        if (u)
        {
            eue1.a(8, v);
        }
        if (w)
        {
            eue1.a(9, x);
        }
        if (y)
        {
            eue1.a(10, z);
        }
        if (G)
        {
            eue1.a(11, H);
        }
        if (I)
        {
            eue1.a(12, J);
        }
        if (K)
        {
            eue1.a(13, L);
        }
        if (M)
        {
            eue1.a(14, N);
        }
        if (S)
        {
            eue1.a(15, T);
        }
        if (U)
        {
            eue1.a(16, V);
        }
        for (Iterator iterator = Y.iterator(); iterator.hasNext(); eue1.b(17, (esi)iterator.next())) { }
        if (Z)
        {
            eue1.b(18, aa);
        }
        if (q)
        {
            eue1.a(19, r);
        }
        if (C)
        {
            eue1.a(20, D);
        }
        if (s)
        {
            eue1.b(21, t);
        }
        if (E)
        {
            eue1.b(22, F);
        }
        if (A)
        {
            eue1.a(23, B);
        }
        if (o)
        {
            eue1.a(24, p);
        }
        if (O)
        {
            eue1.a(25, P);
        }
        if (Q)
        {
            eue1.a(26, R);
        }
        if (W)
        {
            eue1.a(27, X);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
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
            i1 = j1 + eue.e(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(7, n);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.b(8, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.b(9, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.b(10, z);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.b(11, H);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.b(12, J);
        }
        j1 = i1;
        if (K)
        {
            j1 = i1 + eue.b(13, L);
        }
        i1 = j1;
        if (M)
        {
            i1 = j1 + eue.b(14, N);
        }
        j1 = i1;
        if (S)
        {
            j1 = i1 + eue.b(15, T);
        }
        i1 = j1;
        if (U)
        {
            i1 = j1 + eue.b(16, V);
        }
        Iterator iterator = Y.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(17, (esi)iterator.next()) + j1) { }
        i1 = j1;
        if (Z)
        {
            i1 = j1 + eue.d(18, aa);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(19, r);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.b(20, D);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.d(21, t);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(22, F);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.b(23, B);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.b(24, p);
        }
        j1 = i1;
        if (O)
        {
            j1 = i1 + eue.b(25, P);
        }
        i1 = j1;
        if (Q)
        {
            i1 = j1 + eue.b(26, R);
        }
        j1 = i1;
        if (W)
        {
            j1 = i1 + eue.b(27, X);
        }
        ab = j1;
        return j1;
    }
}
