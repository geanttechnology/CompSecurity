// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eec extends eug
{

    private boolean a;
    private float b;
    private boolean c;
    private String d;
    private boolean e;
    private long f;
    private boolean g;
    private long h;
    private boolean i;
    private long j;
    private boolean k;
    private long l;
    private boolean m;
    private eed n;
    private boolean o;
    private eed p;
    private List q;
    private boolean r;
    private String s;
    private boolean t;
    private eeh u;
    private boolean v;
    private eek w;
    private boolean x;
    private eeg y;
    private int z;

    public eec()
    {
        b = 0.0F;
        d = "";
        f = 0L;
        h = 0L;
        j = 0L;
        l = 0L;
        n = null;
        p = null;
        q = Collections.emptyList();
        s = "";
        u = null;
        w = null;
        y = null;
        z = -1;
    }

    public final int a()
    {
        if (z < 0)
        {
            b();
        }
        return z;
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

            case 13: // '\r'
                float f1 = eud1.c();
                a = true;
                b = f1;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                eeh eeh1 = new eeh();
                eud1.a(eeh1);
                t = true;
                u = eeh1;
                break;

            case 34: // '"'
                eek eek1 = new eek();
                eud1.a(eek1);
                v = true;
                w = eek1;
                break;

            case 40: // '('
                long l1 = eud1.e();
                e = true;
                f = l1;
                break;

            case 48: // '0'
                long l2 = eud1.d();
                i = true;
                j = l2;
                break;

            case 58: // ':'
                eed eed1 = new eed();
                eud1.a(eed1);
                m = true;
                n = eed1;
                break;

            case 66: // 'B'
                eed eed2 = new eed();
                eud1.a(eed2);
                o = true;
                p = eed2;
                break;

            case 74: // 'J'
                eeg eeg1 = new eeg();
                eud1.a(eeg1);
                x = true;
                y = eeg1;
                break;

            case 82: // 'R'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (q.isEmpty())
                {
                    q = new ArrayList();
                }
                q.add(s2);
                break;

            case 90: // 'Z'
                String s3 = eud1.i();
                r = true;
                s = s3;
                break;

            case 96: // '`'
                long l3 = eud1.d();
                k = true;
                l = l3;
                break;

            case 104: // 'h'
                long l4 = eud1.e();
                g = true;
                h = l4;
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
        if (t)
        {
            eue1.b(3, u);
        }
        if (v)
        {
            eue1.b(4, w);
        }
        if (e)
        {
            eue1.b(5, f);
        }
        if (i)
        {
            eue1.a(6, j);
        }
        if (m)
        {
            eue1.b(7, n);
        }
        if (o)
        {
            eue1.b(8, p);
        }
        if (x)
        {
            eue1.b(9, y);
        }
        for (Iterator iterator = q.iterator(); iterator.hasNext(); eue1.a(10, (String)iterator.next())) { }
        if (r)
        {
            eue1.a(11, s);
        }
        if (k)
        {
            eue1.a(12, l);
        }
        if (g)
        {
            eue1.b(13, h);
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
        if (t)
        {
            j1 = i1 + eue.d(3, u);
        }
        i1 = j1;
        if (v)
        {
            i1 = j1 + eue.d(4, w);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.e(5, f);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.d(6, j);
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
        if (x)
        {
            i1 += eue.d(9, y);
        }
        iterator = q.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        j1 = i1 + j1 + q.size() * 1;
        i1 = j1;
        if (r)
        {
            i1 = j1 + eue.b(11, s);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(12, l);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.e(13, h);
        }
        z = i1;
        return i1;
    }
}
