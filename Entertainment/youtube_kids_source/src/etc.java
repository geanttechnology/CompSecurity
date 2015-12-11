// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class etc extends eug
{

    private boolean A;
    private String B;
    private boolean C;
    private etb D;
    private boolean E;
    private String F;
    private boolean G;
    private String H;
    private boolean I;
    private String J;
    private List K;
    private boolean L;
    private etd M;
    private boolean N;
    private String O;
    private boolean P;
    private String Q;
    private int R;
    private boolean a;
    private int b;
    private boolean c;
    private String d;
    private boolean e;
    private long f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private etb n;
    private boolean o;
    private ete p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private etb v;
    private boolean w;
    private ete x;
    private boolean y;
    private String z;

    public etc()
    {
        b = 0;
        d = "";
        f = 0L;
        h = "";
        j = "";
        l = "";
        n = null;
        p = null;
        r = "";
        t = "";
        v = null;
        x = null;
        z = "";
        B = "";
        D = null;
        F = "";
        H = "";
        J = "";
        K = Collections.emptyList();
        M = null;
        O = "";
        Q = "";
        R = -1;
    }

    public final int a()
    {
        if (R < 0)
        {
            b();
        }
        return R;
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

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 24: // '\030'
                long l1 = eud1.e();
                e = true;
                f = l1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                g = true;
                h = s2;
                break;

            case 42: // '*'
                String s3 = eud1.i();
                i = true;
                j = s3;
                break;

            case 50: // '2'
                etb etb1 = new etb();
                eud1.a(etb1);
                m = true;
                n = etb1;
                break;

            case 58: // ':'
                ete ete1 = new ete();
                eud1.a(ete1);
                o = true;
                p = ete1;
                break;

            case 66: // 'B'
                String s4 = eud1.i();
                q = true;
                r = s4;
                break;

            case 74: // 'J'
                String s5 = eud1.i();
                s = true;
                t = s5;
                break;

            case 82: // 'R'
                etb etb2 = new etb();
                eud1.a(etb2);
                u = true;
                v = etb2;
                break;

            case 90: // 'Z'
                ete ete2 = new ete();
                eud1.a(ete2);
                w = true;
                x = ete2;
                break;

            case 98: // 'b'
                String s6 = eud1.i();
                y = true;
                z = s6;
                break;

            case 106: // 'j'
                String s7 = eud1.i();
                A = true;
                B = s7;
                break;

            case 114: // 'r'
                etb etb3 = new etb();
                eud1.a(etb3);
                C = true;
                D = etb3;
                break;

            case 122: // 'z'
                String s8 = eud1.i();
                E = true;
                F = s8;
                break;

            case 130: 
                String s9 = eud1.i();
                G = true;
                H = s9;
                break;

            case 138: 
                String s10 = eud1.i();
                k = true;
                l = s10;
                break;

            case 146: 
                String s11 = eud1.i();
                I = true;
                J = s11;
                break;

            case 154: 
                eqd eqd1 = new eqd();
                eud1.a(eqd1);
                if (K.isEmpty())
                {
                    K = new ArrayList();
                }
                K.add(eqd1);
                break;

            case 162: 
                etd etd1 = new etd();
                eud1.a(etd1);
                L = true;
                M = etd1;
                break;

            case 170: 
                String s12 = eud1.i();
                N = true;
                O = s12;
                break;

            case 178: 
                String s13 = eud1.i();
                P = true;
                Q = s13;
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
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.a(5, j);
        }
        if (m)
        {
            eue1.b(6, n);
        }
        if (o)
        {
            eue1.b(7, p);
        }
        if (q)
        {
            eue1.a(8, r);
        }
        if (s)
        {
            eue1.a(9, t);
        }
        if (u)
        {
            eue1.b(10, v);
        }
        if (w)
        {
            eue1.b(11, x);
        }
        if (y)
        {
            eue1.a(12, z);
        }
        if (A)
        {
            eue1.a(13, B);
        }
        if (C)
        {
            eue1.b(14, D);
        }
        if (E)
        {
            eue1.a(15, F);
        }
        if (G)
        {
            eue1.a(16, H);
        }
        if (k)
        {
            eue1.a(17, l);
        }
        if (I)
        {
            eue1.a(18, J);
        }
        for (Iterator iterator = K.iterator(); iterator.hasNext(); eue1.b(19, (eqd)iterator.next())) { }
        if (L)
        {
            eue1.b(20, M);
        }
        if (N)
        {
            eue1.a(21, O);
        }
        if (P)
        {
            eue1.a(22, Q);
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
            j1 = i1 + eue.e(3, f);
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
        if (m)
        {
            i1 = j1 + eue.d(6, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(7, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.b(8, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.b(9, t);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.d(10, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.d(11, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.b(12, z);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.b(13, B);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.d(14, D);
        }
        j1 = i1;
        if (E)
        {
            j1 = i1 + eue.b(15, F);
        }
        i1 = j1;
        if (G)
        {
            i1 = j1 + eue.b(16, H);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(17, l);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.b(18, J);
        }
        Iterator iterator = K.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(19, (eqd)iterator.next()) + j1) { }
        i1 = j1;
        if (L)
        {
            i1 = j1 + eue.d(20, M);
        }
        j1 = i1;
        if (N)
        {
            j1 = i1 + eue.b(21, O);
        }
        i1 = j1;
        if (P)
        {
            i1 = j1 + eue.b(22, Q);
        }
        R = i1;
        return i1;
    }
}
