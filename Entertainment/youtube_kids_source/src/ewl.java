// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ewl extends eug
{

    public List a;
    private boolean b;
    private long c;
    private boolean d;
    private long e;
    private boolean f;
    private euc g;
    private int h;

    public ewl()
    {
        c = 0L;
        e = 0L;
        a = Collections.emptyList();
        g = euc.b;
        h = -1;
    }

    public final int a()
    {
        if (h < 0)
        {
            b();
        }
        return h;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i = eud1.a();
            switch (i)
            {
            default:
                if (a(eud1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                long l = eud1.e();
                b = true;
                c = l;
                break;

            case 16: // '\020'
                long l1 = eud1.e();
                d = true;
                e = l1;
                break;

            case 26: // '\032'
                ewh ewh1 = new ewh();
                eud1.a(ewh1);
                a(ewh1);
                break;

            case 34: // '"'
                euc euc1 = eud1.j();
                f = true;
                g = euc1;
                break;
            }
        } while (true);
    }

    public final ewh a(int i)
    {
        return (ewh)a.get(i);
    }

    public final ewl a(ewh ewh1)
    {
        if (ewh1 == null)
        {
            throw new NullPointerException();
        }
        if (a.isEmpty())
        {
            a = new ArrayList();
        }
        a.add(ewh1);
        return this;
    }

    public final void a(eue eue1)
    {
        if (b)
        {
            eue1.b(1, c);
        }
        if (d)
        {
            eue1.b(2, e);
        }
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(3, (ewh)iterator.next())) { }
        if (f)
        {
            eue1.a(4, g);
        }
    }

    public final int b()
    {
        int i = 0;
        if (b)
        {
            i = eue.e(1, c) + 0;
        }
        int j = i;
        if (d)
        {
            j = i + eue.e(2, e);
        }
        Iterator iterator = a.iterator();
        for (i = j; iterator.hasNext(); i = eue.d(3, (ewh)iterator.next()) + i) { }
        j = i;
        if (f)
        {
            j = i + eue.b(4, g);
        }
        h = j;
        return j;
    }

    public final int d()
    {
        return a.size();
    }
}
