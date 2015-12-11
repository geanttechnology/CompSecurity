// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class aip extends im
{

    private final amq a;
    private final chq b;

    public aip(amq amq1, chq chq1)
    {
        a = (amq)b.a(amq1);
        b = (chq)b.a(chq1);
    }

    public final void a(int i)
    {
        b.a("set volume on route: %d", new Object[] {
            Integer.valueOf(i)
        });
        a.a(i);
        super.a(i);
    }

    public final void b(int i)
    {
        b.a("update volume on route: %d", new Object[] {
            Integer.valueOf(i)
        });
        if (i > 0)
        {
            a.a();
            return;
        } else
        {
            a.b();
            return;
        }
    }
}
