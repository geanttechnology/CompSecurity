// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.ubercab.client.core.app.RiderActivity;

public final class fwn
    implements hst
{

    static final boolean a;
    private final hzb b;
    private final hzb c;
    private final hzb d;

    private fwn(hzb hzb1, hzb hzb2, hzb hzb3)
    {
        if (!a && hzb1 == null)
        {
            throw new AssertionError();
        }
        b = hzb1;
        if (!a && hzb2 == null)
        {
            throw new AssertionError();
        }
        c = hzb2;
        if (!a && hzb3 == null)
        {
            throw new AssertionError();
        } else
        {
            d = hzb3;
            return;
        }
    }

    public static hst a(hzb hzb1, hzb hzb2, hzb hzb3)
    {
        return new fwn(hzb1, hzb2, hzb3);
    }

    private fwl b()
    {
        return new fwl((hkr)b.a(), (RiderActivity)c.a(), (fte)d.a());
    }

    public final Object a()
    {
        return b();
    }

    static 
    {
        boolean flag;
        if (!fwn.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a = flag;
    }
}
