// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ajp
    implements rw
{

    private final rh a;
    private final rh b;
    private final ctx c;
    private final ctx d;
    private final amd e;
    private final rv f;
    private final bje g;
    private rg h;
    private rg i;

    public ajp(amd amd1, rv rv1, bje bje1, rh rh1, rh rh2, ctx ctx1, ctx ctx2)
    {
        e = (amd)b.a(amd1);
        f = (rv)b.a(rv1);
        g = (bje)b.a(bje1);
        a = (rh)b.a(rh1);
        b = (rh)b.a(rh2);
        c = (ctx)b.a(ctx1);
        d = (ctx)b.a(ctx2);
        h = rh1.a();
        i = rh2.a();
    }

    private boolean e()
    {
        return e.i().a();
    }

    public final rg a()
    {
        if (e())
        {
            return i;
        } else
        {
            return h;
        }
    }

    public final rh b()
    {
        if (e())
        {
            return b;
        } else
        {
            return a;
        }
    }

    public final ctx c()
    {
        if (e())
        {
            return d;
        } else
        {
            return c;
        }
    }

    public final boolean d()
    {
        return !e();
    }

    public final void handleMdxStateChangedEvent(amk amk1)
    {
        amk1 = amk1.a;
        switch (ajq.a[amk1.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            g.a(i);
            f.b(true);
            return;

        case 2: // '\002'
            g.b(i);
            break;
        }
        f.b(false);
    }
}
