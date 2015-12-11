// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class exf extends eug
{

    public int a;
    public boolean b;
    public exl c;
    public boolean d;
    public exu e;
    public boolean f;
    public ewv g;
    private boolean h;
    private boolean i;
    private int j;
    private boolean k;
    private String l;
    private List m;
    private boolean n;
    private exj o;
    private boolean p;
    private exq q;
    private boolean r;
    private eeu s;
    private boolean t;
    private ext u;
    private int v;

    public exf()
    {
        a = 0;
        j = 0;
        l = "";
        m = Collections.emptyList();
        c = null;
        o = null;
        e = null;
        q = null;
        s = null;
        g = null;
        u = null;
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

            case 8: // '\b'
                a(eud1.f());
                break;

            case 16: // '\020'
                int j1 = eud1.f();
                i = true;
                j = j1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                k = true;
                l = s1;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (m.isEmpty())
                {
                    m = new ArrayList();
                }
                m.add(s2);
                break;

            case 10029002: 
                exl exl1 = new exl();
                eud1.a(exl1);
                a(exl1);
                break;

            case 212798498: 
                exj exj1 = new exj();
                eud1.a(exj1);
                a(exj1);
                break;

            case 228798498: 
                exu exu1 = new exu();
                eud1.a(exu1);
                d = true;
                e = exu1;
                break;

            case 282815562: 
                exq exq1 = new exq();
                eud1.a(exq1);
                p = true;
                q = exq1;
                break;

            case 283359866: 
                eeu eeu1 = new eeu();
                eud1.a(eeu1);
                r = true;
                s = eeu1;
                break;

            case 315537450: 
                ewv ewv1 = new ewv();
                eud1.a(ewv1);
                f = true;
                g = ewv1;
                break;

            case 367857354: 
                ext ext1 = new ext();
                eud1.a(ext1);
                t = true;
                u = ext1;
                break;
            }
        } while (true);
    }

    public final exf a(int i1)
    {
        h = true;
        a = i1;
        return this;
    }

    public final exf a(exj exj1)
    {
        if (exj1 == null)
        {
            throw new NullPointerException();
        } else
        {
            n = true;
            o = exj1;
            return this;
        }
    }

    public final exf a(exl exl1)
    {
        if (exl1 == null)
        {
            throw new NullPointerException();
        } else
        {
            b = true;
            c = exl1;
            return this;
        }
    }

    public final void a(eue eue1)
    {
        if (h)
        {
            eue1.a(1, a);
        }
        if (i)
        {
            eue1.a(2, j);
        }
        if (k)
        {
            eue1.a(3, l);
        }
        for (Iterator iterator = m.iterator(); iterator.hasNext(); eue1.a(4, (String)iterator.next())) { }
        if (b)
        {
            eue1.b(0x1320f9, c);
        }
        if (n)
        {
            eue1.b(0x195e184, o);
        }
        if (d)
        {
            eue1.b(0x1b46604, e);
        }
        if (p)
        {
            eue1.b(0x21b6d89, q);
        }
        if (r)
        {
            eue1.b(0x21c774f, s);
        }
        if (f)
        {
            eue1.b(0x259d705, g);
        }
        if (t)
        {
            eue1.b(0x2bda1d9, u);
        }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (h)
        {
            i1 = eue.d(1, a) + 0;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(2, j);
        }
        if (k)
        {
            i1 = j1 + eue.b(3, l);
        } else
        {
            i1 = j1;
        }
        iterator = m.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        j1 = i1 + j1 + m.size() * 1;
        i1 = j1;
        if (b)
        {
            i1 = j1 + eue.d(0x1320f9, c);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.d(0x195e184, o);
        }
        i1 = j1;
        if (d)
        {
            i1 = j1 + eue.d(0x1b46604, e);
        }
        j1 = i1;
        if (p)
        {
            j1 = i1 + eue.d(0x21b6d89, q);
        }
        i1 = j1;
        if (r)
        {
            i1 = j1 + eue.d(0x21c774f, s);
        }
        j1 = i1;
        if (f)
        {
            j1 = i1 + eue.d(0x259d705, g);
        }
        i1 = j1;
        if (t)
        {
            i1 = j1 + eue.d(0x2bda1d9, u);
        }
        v = i1;
        return i1;
    }
}
