// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cwt
    implements Runnable
{

    private cwo a;

    cwt(cwo cwo1)
    {
        a = cwo1;
        super();
    }

    public final void run()
    {
        cwo cwo1 = a;
        b.b();
        Object obj = cwo1.c;
        obj = new bos(((bor) (obj)).b, ((bor) (obj)).c.b());
        obj.a = cwo1.i;
        obj.c = cwo1.e;
        obj.b = cwo1.h;
        try
        {
            obj = (dlv)cwo1.c.e.a(((bxi) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            cwo1.l = cwo1.l + 1;
            if ((long)cwo1.l > cwo1.g)
            {
                cwo1.a(new cse(csf.f, true, ((Throwable) (obj))));
                return;
            } else
            {
                cwo1.m = false;
                cwo1.k = cwo1.a.b() + 2000L * (long)cwo1.l;
                return;
            }
        }
        if (((dlv) (obj)).a != null)
        {
            obj = new bss(((dlv) (obj)).a);
            if (((bss) (obj)).a())
            {
                cwo1.l = 0;
                cwo1.m = false;
                cwo1.k = cwo1.a.b() + cwo1.f;
                return;
            } else
            {
                cwo1.a(new cse(csf.g, false, ((bss) (obj)).a.b));
                return;
            }
        } else
        {
            cwo1.a(new cse(csf.a, false, null));
            return;
        }
    }
}
