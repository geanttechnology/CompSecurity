// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import com.jumio.netswipe.sdk.core.ScanCardActivity;

// Referenced classes of package netswipe:
//            o, bu, c, ai

class q
    implements Runnable
{

    final boolean a;
    final boolean b;
    final boolean c;
    final boolean d;
    final boolean e;
    final boolean f;
    final o g;

    q(o o1, boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5)
    {
        g = o1;
        a = flag;
        b = flag1;
        c = flag2;
        d = flag3;
        e = flag4;
        f = flag5;
        super();
    }

    public void run()
    {
        o.c(g).scanOverlayView.a(a, b, c, d);
        if (o.p(g) != null && !o.b(g).c())
        {
            o.p(g).a(e);
        }
        if (f && o.b(g) != null)
        {
            o.b(g).g();
        }
    }
}
