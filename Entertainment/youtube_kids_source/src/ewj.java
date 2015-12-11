// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ewj extends eug
{

    private ewn A;
    private int B;
    private List a;
    private boolean b;
    private long c;
    private boolean d;
    private long e;
    private boolean f;
    private euv g;
    private boolean h;
    private euv i;
    private boolean j;
    private euv k;
    private List l;
    private boolean m;
    private ewd n;
    private boolean o;
    private float p;
    private boolean q;
    private boolean r;
    private boolean s;
    private long t;
    private boolean u;
    private long v;
    private boolean w;
    private euc x;
    private List y;
    private boolean z;

    public ewj()
    {
        a = Collections.emptyList();
        c = 0L;
        e = 0L;
        g = null;
        i = null;
        k = null;
        l = Collections.emptyList();
        n = null;
        p = 0.0F;
        r = false;
        t = 0L;
        v = 0L;
        x = euc.b;
        y = Collections.emptyList();
        A = null;
        B = -1;
    }

    public final int a()
    {
        if (B < 0)
        {
            b();
        }
        return B;
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
                ewi ewi1 = new ewi();
                eud1.a(ewi1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(ewi1);
                break;

            case 16: // '\020'
                long l1 = eud1.e();
                b = true;
                c = l1;
                break;

            case 24: // '\030'
                long l2 = eud1.e();
                d = true;
                e = l2;
                break;

            case 34: // '"'
                euv euv1 = new euv();
                eud1.a(euv1);
                f = true;
                g = euv1;
                break;

            case 42: // '*'
                euv euv2 = new euv();
                eud1.a(euv2);
                h = true;
                i = euv2;
                break;

            case 50: // '2'
                eux eux1 = new eux();
                eud1.a(eux1);
                if (l.isEmpty())
                {
                    l = new ArrayList();
                }
                l.add(eux1);
                break;

            case 58: // ':'
                ewd ewd1 = new ewd();
                eud1.a(ewd1);
                m = true;
                n = ewd1;
                break;

            case 69: // 'E'
                float f1 = eud1.c();
                o = true;
                p = f1;
                break;

            case 72: // 'H'
                a(eud1.h());
                break;

            case 82: // 'R'
                euv euv3 = new euv();
                eud1.a(euv3);
                j = true;
                k = euv3;
                break;

            case 88: // 'X'
                long l3 = eud1.e();
                s = true;
                t = l3;
                break;

            case 96: // '`'
                long l4 = eud1.e();
                u = true;
                v = l4;
                break;

            case 106: // 'j'
                euc euc1 = eud1.j();
                w = true;
                x = euc1;
                break;

            case 114: // 'r'
                ewh ewh1 = new ewh();
                eud1.a(ewh1);
                if (y.isEmpty())
                {
                    y = new ArrayList();
                }
                y.add(ewh1);
                break;

            case 122: // 'z'
                ewn ewn1 = new ewn();
                eud1.a(ewn1);
                z = true;
                A = ewn1;
                break;
            }
        } while (true);
    }

    public final ewi a(int i1)
    {
        return (ewi)a.get(i1);
    }

    public final ewj a(boolean flag)
    {
        q = true;
        r = flag;
        return this;
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (ewi)iterator.next())) { }
        if (b)
        {
            eue1.b(2, c);
        }
        if (d)
        {
            eue1.b(3, e);
        }
        if (f)
        {
            eue1.b(4, g);
        }
        if (h)
        {
            eue1.b(5, i);
        }
        for (Iterator iterator1 = l.iterator(); iterator1.hasNext(); eue1.b(6, (eux)iterator1.next())) { }
        if (m)
        {
            eue1.b(7, n);
        }
        if (o)
        {
            eue1.a(8, p);
        }
        if (q)
        {
            eue1.a(9, r);
        }
        if (j)
        {
            eue1.b(10, k);
        }
        if (s)
        {
            eue1.b(11, t);
        }
        if (u)
        {
            eue1.b(12, v);
        }
        if (w)
        {
            eue1.a(13, x);
        }
        for (Iterator iterator2 = y.iterator(); iterator2.hasNext(); eue1.b(14, (ewh)iterator2.next())) { }
        if (z)
        {
            eue1.b(15, A);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = eue.d(1, (ewi)iterator.next()) + j1) { }
        int i1 = j1;
        if (b)
        {
            i1 = j1 + eue.e(2, c);
        }
        j1 = i1;
        if (d)
        {
            j1 = i1 + eue.e(3, e);
        }
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.d(4, g);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.d(5, i);
        }
        for (Iterator iterator1 = l.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(6, (eux)iterator1.next());
        }

        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.d(7, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(8, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.b(9, r);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.d(10, k);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.e(11, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.e(12, v);
        }
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(13, x);
        }
        for (Iterator iterator2 = y.iterator(); iterator2.hasNext();)
        {
            i1 += eue.d(14, (ewh)iterator2.next());
        }

        j1 = i1;
        if (z)
        {
            j1 = i1 + eue.d(15, A);
        }
        B = j1;
        return j1;
    }

    public final int d()
    {
        return a.size();
    }
}
