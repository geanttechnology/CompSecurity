// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class evd extends eug
{

    private List a;
    private boolean b;
    private int c;
    private boolean d;
    private int e;
    private int f;

    public evd()
    {
        a = Collections.emptyList();
        c = 0;
        e = 0;
        f = -1;
    }

    public final int a()
    {
        if (f < 0)
        {
            b();
        }
        return f;
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

            case 10: // '\n'
                euz euz1 = new euz();
                eud1.a(euz1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(euz1);
                break;

            case 16: // '\020'
                int j = eud1.f();
                b = true;
                c = j;
                break;

            case 24: // '\030'
                int k = eud1.f();
                d = true;
                e = k;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (euz)iterator.next())) { }
        if (b)
        {
            eue1.a(2, c);
        }
        if (d)
        {
            eue1.a(3, e);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j;
        for (j = 0; iterator.hasNext(); j = eue.d(1, (euz)iterator.next()) + j) { }
        int i = j;
        if (b)
        {
            i = j + eue.d(2, c);
        }
        j = i;
        if (d)
        {
            j = i + eue.d(3, e);
        }
        f = j;
        return j;
    }
}
