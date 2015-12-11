// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ewh extends eug
{

    public boolean a;
    public String b;
    public boolean c;
    public ewm d;
    public float e;
    public boolean f;
    public eut g;
    private boolean h;
    private String i;
    private boolean j;
    private String k;
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private euv p;
    private boolean q;
    private euv r;
    private boolean s;
    private euv t;
    private List u;
    private int v;

    public ewh()
    {
        b = "";
        i = "";
        k = "";
        d = null;
        e = 0.0F;
        n = true;
        p = null;
        r = null;
        t = null;
        u = Collections.emptyList();
        g = null;
        v = -1;
    }

    public final int a()
    {
        if (v < 0)
        {
            b();
        }
        return v;
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
                a(eud1.i());
                break;

            case 21: // '\025'
                a(eud1.c());
                break;

            case 26: // '\032'
                euv euv1 = new euv();
                eud1.a(euv1);
                q = true;
                r = euv1;
                break;

            case 34: // '"'
                euv euv2 = new euv();
                eud1.a(euv2);
                s = true;
                t = euv2;
                break;

            case 42: // '*'
                eux eux1 = new eux();
                eud1.a(eux1);
                if (u.isEmpty())
                {
                    u = new ArrayList();
                }
                u.add(eux1);
                break;

            case 50: // '2'
                eut eut1 = new eut();
                eud1.a(eut1);
                f = true;
                g = eut1;
                break;

            case 58: // ':'
                ewm ewm1 = new ewm();
                eud1.a(ewm1);
                c = true;
                d = ewm1;
                break;

            case 82: // 'R'
                euv euv3 = new euv();
                eud1.a(euv3);
                o = true;
                p = euv3;
                break;

            case 88: // 'X'
                boolean flag = eud1.h();
                m = true;
                n = flag;
                break;

            case 98: // 'b'
                String s1 = eud1.i();
                h = true;
                i = s1;
                break;

            case 106: // 'j'
                String s2 = eud1.i();
                j = true;
                k = s2;
                break;
            }
        } while (true);
    }

    public final ewh a(float f1)
    {
        l = true;
        e = f1;
        return this;
    }

    public final ewh a(String s1)
    {
        a = true;
        b = s1;
        return this;
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (l)
        {
            eue1.a(2, e);
        }
        if (q)
        {
            eue1.b(3, r);
        }
        if (s)
        {
            eue1.b(4, t);
        }
        for (Iterator iterator = u.iterator(); iterator.hasNext(); eue1.b(5, (eux)iterator.next())) { }
        if (f)
        {
            eue1.b(6, g);
        }
        if (c)
        {
            eue1.b(7, d);
        }
        if (o)
        {
            eue1.b(10, p);
        }
        if (m)
        {
            eue1.a(11, n);
        }
        if (h)
        {
            eue1.a(12, i);
        }
        if (j)
        {
            eue1.a(13, k);
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
        if (l)
        {
            i1 = j1 + eue.b(2, e);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.d(3, r);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.d(4, t);
        }
        Iterator iterator = u.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(5, (eux)iterator.next()) + j1) { }
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.d(6, g);
        }
        j1 = i1;
        if (c)
        {
            j1 = i1 + eue.d(7, d);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(10, p);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(11, n);
        }
        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.b(12, i);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(13, k);
        }
        v = j1;
        return j1;
    }
}
