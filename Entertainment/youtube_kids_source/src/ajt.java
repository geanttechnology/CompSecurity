// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.google.android.gms.cast.CastDevice;

final class ajt
    implements akh
{

    private alo a;
    private alw b;
    private ajs c;

    ajt(ajs ajs1, alo alo1, alw alw)
    {
        c = ajs1;
        a = alo1;
        b = alw;
        super();
    }

    private void b()
    {
        c.b.a(a);
        c.a.a(false);
    }

    public final void a()
    {
        c.c = null;
        b();
    }

    public final void a(alu alu, boolean flag)
    {
        if (c.i() != amj.e)
        {
            c.c = null;
            c.b.a(alu);
            if (flag)
            {
                b();
                return;
            }
        }
    }

    public final void a(cgr cgr)
    {
        cgr = new alq(new cgc(cgr, a.a.d, null, null, cgn.d));
        c.a.a(cgr, b);
    }
}
