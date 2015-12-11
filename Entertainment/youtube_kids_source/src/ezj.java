// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ezj extends eug
{

    private boolean A;
    private String B;
    private boolean C;
    private int D;
    private boolean E;
    private int F;
    private boolean G;
    private int H;
    private boolean I;
    private int J;
    private boolean K;
    private ezi L;
    private boolean M;
    private String N;
    private List O;
    private int P;
    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private long f;
    private boolean g;
    private String h;
    private boolean i;
    private ezg j;
    private boolean k;
    private ezg l;
    private boolean m;
    private ezh n;
    private boolean o;
    private float p;
    private boolean q;
    private int r;
    private boolean s;
    private eze t;
    private boolean u;
    private long v;
    private boolean w;
    private eze x;
    private boolean y;
    private float z;

    public ezj()
    {
        b = 0;
        d = 0;
        f = 0L;
        h = "";
        j = null;
        l = null;
        n = null;
        p = 0.0F;
        r = 100;
        t = null;
        v = 0L;
        x = null;
        z = 0.0F;
        B = "";
        D = 0;
        F = 0;
        H = 0;
        J = 0;
        L = null;
        N = "";
        O = Collections.emptyList();
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

            case 8: // '\b'
                a(eud1.f());
                break;

            case 16: // '\020'
                b(eud1.f());
                break;

            case 24: // '\030'
                a(eud1.e());
                break;

            case 34: // '"'
                String s1 = eud1.i();
                g = true;
                h = s1;
                break;

            case 42: // '*'
                ezg ezg1 = new ezg();
                eud1.a(ezg1);
                a(ezg1);
                break;

            case 50: // '2'
                ezg ezg2 = new ezg();
                eud1.a(ezg2);
                k = true;
                l = ezg2;
                break;

            case 61: // '='
                a(eud1.c());
                break;

            case 64: // '@'
                int j1 = eud1.f();
                q = true;
                r = j1;
                break;

            case 72: // 'H'
                int k1 = eud1.f();
                C = true;
                D = k1;
                break;

            case 82: // 'R'
                eze eze1 = new eze();
                eud1.a(eze1);
                s = true;
                t = eze1;
                break;

            case 90: // 'Z'
                String s2 = eud1.i();
                A = true;
                B = s2;
                break;

            case 96: // '`'
                int l1 = eud1.f();
                E = true;
                F = l1;
                break;

            case 104: // 'h'
                int i2 = eud1.f();
                G = true;
                H = i2;
                break;

            case 114: // 'r'
                ezh ezh1 = new ezh();
                eud1.a(ezh1);
                m = true;
                n = ezh1;
                break;

            case 120: // 'x'
                int j2 = eud1.f();
                I = true;
                J = j2;
                break;

            case 128: 
                long l2 = eud1.d();
                u = true;
                v = l2;
                break;

            case 138: 
                eze eze2 = new eze();
                eud1.a(eze2);
                w = true;
                x = eze2;
                break;

            case 149: 
                float f1 = eud1.c();
                y = true;
                z = f1;
                break;

            case 154: 
                ezi ezi1 = new ezi();
                eud1.a(ezi1);
                K = true;
                L = ezi1;
                break;

            case 162: 
                String s3 = eud1.i();
                M = true;
                N = s3;
                break;

            case 168: 
                int k2 = eud1.f();
                if (O.isEmpty())
                {
                    O = new ArrayList();
                }
                O.add(Integer.valueOf(k2));
                break;
            }
        } while (true);
    }

    public final ezj a(float f1)
    {
        o = true;
        p = f1;
        return this;
    }

    public final ezj a(int i1)
    {
        a = true;
        b = i1;
        return this;
    }

    public final ezj a(long l1)
    {
        e = true;
        f = l1;
        return this;
    }

    public final ezj a(ezg ezg1)
    {
        i = true;
        j = ezg1;
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
            eue1.b(5, j);
        }
        if (k)
        {
            eue1.b(6, l);
        }
        if (o)
        {
            eue1.a(7, p);
        }
        if (q)
        {
            eue1.a(8, r);
        }
        if (C)
        {
            eue1.a(9, D);
        }
        if (s)
        {
            eue1.b(10, t);
        }
        if (A)
        {
            eue1.a(11, B);
        }
        if (E)
        {
            eue1.a(12, F);
        }
        if (G)
        {
            eue1.a(13, H);
        }
        if (m)
        {
            eue1.b(14, n);
        }
        if (I)
        {
            eue1.a(15, J);
        }
        if (u)
        {
            eue1.a(16, v);
        }
        if (w)
        {
            eue1.b(17, x);
        }
        if (y)
        {
            eue1.a(18, z);
        }
        if (K)
        {
            eue1.b(19, L);
        }
        if (M)
        {
            eue1.a(20, N);
        }
        for (Iterator iterator = O.iterator(); iterator.hasNext(); eue1.a(21, ((Integer)iterator.next()).intValue())) { }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
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
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(7, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(8, r);
        }
        j1 = i1;
        if (C)
        {
            j1 = i1 + eue.d(9, D);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.d(10, t);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.b(11, B);
        }
        i1 = j1;
        if (E)
        {
            i1 = j1 + eue.d(12, F);
        }
        j1 = i1;
        if (G)
        {
            j1 = i1 + eue.d(13, H);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(14, n);
        }
        j1 = i1;
        if (I)
        {
            j1 = i1 + eue.d(15, J);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.d(16, v);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.d(17, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.b(18, z);
        }
        j1 = i1;
        if (K)
        {
            j1 = i1 + eue.d(19, L);
        }
        if (M)
        {
            i1 = j1 + eue.b(20, N);
        } else
        {
            i1 = j1;
        }
        iterator = O.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a(((Integer)iterator.next()).intValue())) { }
        i1 = i1 + j1 + O.size() * 2;
        P = i1;
        return i1;
    }

    public final ezj b(int i1)
    {
        c = true;
        d = i1;
        return this;
    }
}
