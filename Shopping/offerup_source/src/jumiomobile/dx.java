// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.core.InternalCardInformation;

// Referenced classes of package jumiomobile:
//            dm, ew, fl, aa

class dx
    implements Runnable
{

    final dm a;
    private InternalCardInformation b;
    private aa c;
    private aa d;
    private boolean e;

    public dx(dm dm1, InternalCardInformation internalcardinformation, boolean flag, boolean flag1, aa aa, aa aa1)
    {
        a = dm1;
        super();
        b = internalcardinformation;
        b.e(flag);
        c = aa;
        d = aa1;
        e = flag1;
    }

    public void run()
    {
        if (e)
        {
            a.G.setTextVisible(false);
        }
        if (b == null)
        {
            return;
        } else
        {
            a.o.a(a.k, b, c, d, a.x, a.f, a.e, a.a);
            return;
        }
    }
}
