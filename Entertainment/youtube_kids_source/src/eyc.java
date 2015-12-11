// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyc extends eug
{

    private boolean A;
    private eyq B;
    private boolean C;
    private eya D;
    private boolean E;
    private eyd F;
    private boolean G;
    private eyb H;
    private boolean I;
    private boolean J;
    private eyh K;
    private boolean L;
    private exz M;
    private boolean N;
    private eyx O;
    private int P;
    public List a;
    public List b;
    public eyl c;
    public eyg d;
    public eyy e;
    public eyw f;
    public eyr g;
    public eyt h;
    private boolean i;
    private String j;
    private List k;
    private boolean l;
    private eys m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private eyv s;
    private boolean t;
    private boolean u;
    private eyk v;
    private boolean w;
    private eyj x;
    private boolean y;
    private eyi z;

    public eyc()
    {
        j = "";
        a = Collections.emptyList();
        k = Collections.emptyList();
        m = null;
        b = Collections.emptyList();
        c = null;
        d = null;
        e = null;
        f = null;
        s = null;
        g = null;
        v = null;
        x = null;
        z = null;
        B = null;
        D = null;
        F = null;
        H = null;
        h = null;
        K = null;
        M = null;
        O = null;
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
                i = true;
                j = s1;
                break;

            case 18: // '\022'
                eym eym1 = new eym();
                eud1.a(eym1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(eym1);
                break;

            case 34: // '"'
                eyp eyp1 = new eyp();
                eud1.a(eyp1);
                if (k.isEmpty())
                {
                    k = new ArrayList();
                }
                k.add(eyp1);
                break;

            case 42: // '*'
                eys eys1 = new eys();
                eud1.a(eys1);
                l = true;
                m = eys1;
                break;

            case 50: // '2'
                eyn eyn1 = new eyn();
                eud1.a(eyn1);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(eyn1);
                break;

            case 58: // ':'
                eyl eyl1 = new eyl();
                eud1.a(eyl1);
                n = true;
                c = eyl1;
                break;

            case 66: // 'B'
                eyg eyg1 = new eyg();
                eud1.a(eyg1);
                o = true;
                d = eyg1;
                break;

            case 74: // 'J'
                eyv eyv1 = new eyv();
                eud1.a(eyv1);
                r = true;
                s = eyv1;
                break;

            case 82: // 'R'
                eyj eyj1 = new eyj();
                eud1.a(eyj1);
                w = true;
                x = eyj1;
                break;

            case 90: // 'Z'
                eyi eyi1 = new eyi();
                eud1.a(eyi1);
                y = true;
                z = eyi1;
                break;

            case 98: // 'b'
                eyq eyq1 = new eyq();
                eud1.a(eyq1);
                A = true;
                B = eyq1;
                break;

            case 106: // 'j'
                eyy eyy1 = new eyy();
                eud1.a(eyy1);
                p = true;
                e = eyy1;
                break;

            case 114: // 'r'
                eyw eyw1 = new eyw();
                eud1.a(eyw1);
                q = true;
                f = eyw1;
                break;

            case 122: // 'z'
                eya eya1 = new eya();
                eud1.a(eya1);
                C = true;
                D = eya1;
                break;

            case 130: 
                eyr eyr1 = new eyr();
                eud1.a(eyr1);
                t = true;
                g = eyr1;
                break;

            case 138: 
                eyd eyd1 = new eyd();
                eud1.a(eyd1);
                E = true;
                F = eyd1;
                break;

            case 146: 
                eyb eyb1 = new eyb();
                eud1.a(eyb1);
                G = true;
                H = eyb1;
                break;

            case 154: 
                eyt eyt1 = new eyt();
                eud1.a(eyt1);
                I = true;
                h = eyt1;
                break;

            case 162: 
                eyk eyk1 = new eyk();
                eud1.a(eyk1);
                u = true;
                v = eyk1;
                break;

            case 170: 
                eyh eyh1 = new eyh();
                eud1.a(eyh1);
                J = true;
                K = eyh1;
                break;

            case 178: 
                exz exz1 = new exz();
                eud1.a(exz1);
                L = true;
                M = exz1;
                break;

            case 186: 
                eyx eyx1 = new eyx();
                eud1.a(eyx1);
                N = true;
                O = eyx1;
                break;
            }
        } while (true);
    }

    public final eym a(int i1)
    {
        return (eym)a.get(i1);
    }

    public final void a(eue eue1)
    {
        if (i)
        {
            eue1.a(1, j);
        }
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(2, (eym)iterator.next())) { }
        for (Iterator iterator1 = k.iterator(); iterator1.hasNext(); eue1.b(4, (eyp)iterator1.next())) { }
        if (l)
        {
            eue1.b(5, m);
        }
        for (Iterator iterator2 = b.iterator(); iterator2.hasNext(); eue1.b(6, (eyn)iterator2.next())) { }
        if (n)
        {
            eue1.b(7, c);
        }
        if (o)
        {
            eue1.b(8, d);
        }
        if (r)
        {
            eue1.b(9, s);
        }
        if (w)
        {
            eue1.b(10, x);
        }
        if (y)
        {
            eue1.b(11, z);
        }
        if (A)
        {
            eue1.b(12, B);
        }
        if (p)
        {
            eue1.b(13, e);
        }
        if (q)
        {
            eue1.b(14, f);
        }
        if (C)
        {
            eue1.b(15, D);
        }
        if (t)
        {
            eue1.b(16, g);
        }
        if (E)
        {
            eue1.b(17, F);
        }
        if (G)
        {
            eue1.b(18, H);
        }
        if (I)
        {
            eue1.b(19, h);
        }
        if (u)
        {
            eue1.b(20, v);
        }
        if (J)
        {
            eue1.b(21, K);
        }
        if (L)
        {
            eue1.b(22, M);
        }
        if (N)
        {
            eue1.b(23, O);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (i)
        {
            i1 = eue.b(1, j) + 0;
        }
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            i1 = eue.d(2, (eym)iterator.next()) + i1;
        }

        for (Iterator iterator1 = k.iterator(); iterator1.hasNext();)
        {
            i1 += eue.d(4, (eyp)iterator1.next());
        }

        int j1 = i1;
        if (l)
        {
            j1 = i1 + eue.d(5, m);
        }
        for (Iterator iterator2 = b.iterator(); iterator2.hasNext();)
        {
            j1 += eue.d(6, (eyn)iterator2.next());
        }

        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.d(7, c);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(8, d);
        }
        i1 = j1;
        if (r)
        {
            i1 = j1 + eue.d(9, s);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.d(10, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.d(11, z);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.d(12, B);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.d(13, e);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.d(14, f);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.d(15, D);
        }
        j1 = i1;
        if (t)
        {
            j1 = i1 + eue.d(16, g);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(17, F);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.d(18, H);
        }
        i1 = j1;
        if (I)
        {
            i1 = j1 + eue.d(19, h);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.d(20, v);
        }
        i1 = j1;
        if (J)
        {
            i1 = j1 + eue.d(21, K);
        }
        j1 = i1;
        if (L)
        {
            j1 = i1 + eue.d(22, M);
        }
        i1 = j1;
        if (N)
        {
            i1 = j1 + eue.d(23, O);
        }
        P = i1;
        return i1;
    }
}
