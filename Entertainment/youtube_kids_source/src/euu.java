// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class euu extends eug
{

    private boolean A;
    private boolean B;
    private boolean C;
    private String D;
    private List E;
    private boolean F;
    private String G;
    private boolean H;
    private String I;
    private boolean J;
    private String K;
    private boolean L;
    private String M;
    private boolean N;
    private String O;
    private int P;
    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private String x;
    private boolean y;
    private String z;

    public euu()
    {
        b = "";
        d = "";
        f = "";
        h = false;
        j = "";
        l = "";
        n = 0;
        p = 0;
        r = "";
        t = "";
        v = "";
        x = "";
        z = "";
        B = false;
        D = "";
        E = Collections.emptyList();
        G = "";
        I = "";
        K = "";
        M = "";
        O = "";
        P = -1;
    }

    public final int a()
    {
        if (P < 0)
        {
            b();
        }
        return P;
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

            case 32: // ' '
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 42: // '*'
                String s4 = eud1.i();
                i = true;
                j = s4;
                break;

            case 50: // '2'
                String s5 = eud1.i();
                k = true;
                l = s5;
                break;

            case 56: // '8'
                int j1 = eud1.f();
                m = true;
                n = j1;
                break;

            case 64: // '@'
                int k1 = eud1.f();
                o = true;
                p = k1;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                q = true;
                r = s6;
                break;

            case 82: // 'R'
                String s7 = eud1.i();
                w = true;
                x = s7;
                break;

            case 90: // 'Z'
                String s8 = eud1.i();
                y = true;
                z = s8;
                break;

            case 96: // '`'
                boolean flag1 = eud1.h();
                A = true;
                B = flag1;
                break;

            case 106: // 'j'
                String s9 = eud1.i();
                C = true;
                D = s9;
                break;

            case 114: // 'r'
                String s10 = eud1.i();
                if (s10 == null)
                {
                    throw new NullPointerException();
                }
                if (E.isEmpty())
                {
                    E = new ArrayList();
                }
                E.add(s10);
                break;

            case 122: // 'z'
                String s11 = eud1.i();
                F = true;
                G = s11;
                break;

            case 130: 
                String s12 = eud1.i();
                H = true;
                I = s12;
                break;

            case 138: 
                String s13 = eud1.i();
                J = true;
                K = s13;
                break;

            case 146: 
                String s14 = eud1.i();
                L = true;
                M = s14;
                break;

            case 154: 
                String s15 = eud1.i();
                N = true;
                O = s15;
                break;

            case 162: 
                String s16 = eud1.i();
                s = true;
                t = s16;
                break;

            case 170: 
                String s17 = eud1.i();
                u = true;
                v = s17;
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
        if (o)
        {
            eue1.a(8, p);
        }
        if (q)
        {
            eue1.a(9, r);
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
        for (Iterator iterator = E.iterator(); iterator.hasNext(); eue1.a(14, (String)iterator.next())) { }
        if (F)
        {
            eue1.a(15, G);
        }
        if (H)
        {
            eue1.a(16, I);
        }
        if (J)
        {
            eue1.a(17, K);
        }
        if (L)
        {
            eue1.a(18, M);
        }
        if (N)
        {
            eue1.a(19, O);
        }
        if (s)
        {
            eue1.a(20, t);
        }
        if (u)
        {
            eue1.a(21, v);
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
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(6, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(9, r);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(10, x);
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
        if (C)
        {
            i1 += eue.b(13, D);
        }
        iterator = E.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        j1 = i1 + j1 + E.size() * 1;
        i1 = j1;
        if (F)
        {
            i1 = j1 + eue.b(15, G);
        }
        j1 = i1;
        if (H)
        {
            j1 = i1 + eue.b(16, I);
        }
        i1 = j1;
        if (J)
        {
            i1 = j1 + eue.b(17, K);
        }
        j1 = i1;
        if (L)
        {
            j1 = i1 + eue.b(18, M);
        }
        i1 = j1;
        if (N)
        {
            i1 = j1 + eue.b(19, O);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.b(20, t);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.b(21, v);
        }
        P = i1;
        return i1;
    }
}
