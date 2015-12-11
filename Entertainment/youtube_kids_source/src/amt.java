// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class amt extends eug
{

    public boolean a;
    public amw b;
    public boolean c;
    public amw d;
    public boolean e;
    public amw f;
    public boolean g;
    public amw h;
    public List i;
    public boolean j;
    public amw k;
    public boolean l;
    private boolean m;
    private int n;

    public amt()
    {
        b = null;
        d = null;
        f = null;
        h = null;
        i = Collections.emptyList();
        k = null;
        l = false;
        n = -1;
    }

    public final int a()
    {
        if (n < 0)
        {
            b();
        }
        return n;
    }

    public final amt a(amw amw1)
    {
        if (amw1 == null)
        {
            throw new NullPointerException();
        } else
        {
            a = true;
            b = amw1;
            return this;
        }
    }

    public final amt a(boolean flag)
    {
        m = true;
        l = flag;
        return this;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (eud1.b(i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                amw amw1 = new amw();
                eud1.a(amw1);
                a(amw1);
                break;

            case 18: // '\022'
                amw amw2 = new amw();
                eud1.a(amw2);
                b(amw2);
                break;

            case 26: // '\032'
                amw amw3 = new amw();
                eud1.a(amw3);
                c(amw3);
                break;

            case 34: // '"'
                amw amw4 = new amw();
                eud1.a(amw4);
                d(amw4);
                break;

            case 42: // '*'
                amw amw5 = new amw();
                eud1.a(amw5);
                e(amw5);
                break;

            case 50: // '2'
                amw amw6 = new amw();
                eud1.a(amw6);
                f(amw6);
                break;

            case 56: // '8'
                a(eud1.h());
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.b(1, b);
        }
        if (c)
        {
            eue1.b(2, d);
        }
        if (e)
        {
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(5, (amw)iterator.next())) { }
        if (j)
        {
            eue1.b(6, k);
        }
        if (m)
        {
            eue1.a(7, l);
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
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.d(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(4, h);
        }
        Iterator iterator = i.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(5, (amw)iterator.next()) + j1) { }
        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.d(6, k);
        }
        j1 = i1;
        if (m)
        {
            boolean flag = l;
            j1 = i1 + (eue.b(7) + 1);
        }
        n = j1;
        return j1;
    }

    public final amt b(amw amw1)
    {
        if (amw1 == null)
        {
            throw new NullPointerException();
        } else
        {
            c = true;
            d = amw1;
            return this;
        }
    }

    public final amt c(amw amw1)
    {
        if (amw1 == null)
        {
            throw new NullPointerException();
        } else
        {
            e = true;
            f = amw1;
            return this;
        }
    }

    public final amt d(amw amw1)
    {
        if (amw1 == null)
        {
            throw new NullPointerException();
        } else
        {
            g = true;
            h = amw1;
            return this;
        }
    }

    public final amt e(amw amw1)
    {
        if (amw1 == null)
        {
            throw new NullPointerException();
        }
        if (i.isEmpty())
        {
            i = new ArrayList();
        }
        i.add(amw1);
        return this;
    }

    public final amt f(amw amw1)
    {
        if (amw1 == null)
        {
            throw new NullPointerException();
        } else
        {
            j = true;
            k = amw1;
            return this;
        }
    }
}
