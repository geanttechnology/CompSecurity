// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.ubercab.client.feature.payment.expense.ExpenseInfoFragment;

public final class ese
    implements hsr
{

    static final boolean a;
    private final hsr b;
    private final hzb c;
    private final hzb d;
    private final hzb e;
    private final hzb f;
    private final hzb g;

    private ese(hsr hsr1, hzb hzb1, hzb hzb2, hzb hzb3, hzb hzb4, hzb hzb5)
    {
        if (!a && hsr1 == null)
        {
            throw new AssertionError();
        }
        b = hsr1;
        if (!a && hzb1 == null)
        {
            throw new AssertionError();
        }
        c = hzb1;
        if (!a && hzb2 == null)
        {
            throw new AssertionError();
        }
        d = hzb2;
        if (!a && hzb3 == null)
        {
            throw new AssertionError();
        }
        e = hzb3;
        if (!a && hzb4 == null)
        {
            throw new AssertionError();
        }
        f = hzb4;
        if (!a && hzb5 == null)
        {
            throw new AssertionError();
        } else
        {
            g = hzb5;
            return;
        }
    }

    public static hsr a(hsr hsr1, hzb hzb1, hzb hzb2, hzb hzb3, hzb hzb4, hzb hzb5)
    {
        return new ese(hsr1, hzb1, hzb2, hzb3, hzb4, hzb5);
    }

    private void a(ExpenseInfoFragment expenseinfofragment)
    {
        if (expenseinfofragment == null)
        {
            throw new NullPointerException("Cannot inject members into a null reference");
        } else
        {
            b.injectMembers(expenseinfofragment);
            expenseinfofragment.c = (chp)c.a();
            expenseinfofragment.d = (cev)d.a();
            expenseinfofragment.e = (hkr)e.a();
            expenseinfofragment.f = (gmg)f.a();
            expenseinfofragment.g = (dal)g.a();
            return;
        }
    }

    public final void injectMembers(Object obj)
    {
        a((ExpenseInfoFragment)obj);
    }

    static 
    {
        boolean flag;
        if (!ese.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
