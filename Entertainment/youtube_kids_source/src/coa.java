// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class coa
    implements crb
{

    final bid a;
    final bmi b;
    private final crb c;
    private final long d;

    protected coa(bid bid1, crb crb1, bmi bmi1, long l)
    {
        a = bid1;
        c = crb1;
        b = bmi1;
        d = l;
    }

    public static coa a(bid bid1, crb crb1, bmi bmi1, long l)
    {
        b.a(bid1);
        b.a(crb1);
        b.a(bmi1);
        boolean flag;
        if (l >= 0L && l <= 0x9a7ec800L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "time to live must be >=0 and <= 2592000000");
        return new coc(bid1, crb1, bmi1, l);
    }

    protected abstract Object a(Object obj);

    public final void a(Object obj, bhv bhv1)
    {
        if (d > 0L)
        {
            cnz cnz1 = (cnz)a.a(a(obj));
            long l = b.a();
            if (cnz1 != null && l >= cnz1.b && cnz1.b + d >= l)
            {
                bhv1.a(obj, cnz1.a);
                return;
            }
        }
        if (c != null)
        {
            c.a(obj, new cob(this, bhv1));
            return;
        } else
        {
            bhv1.a(obj, new cny());
            return;
        }
    }
}
