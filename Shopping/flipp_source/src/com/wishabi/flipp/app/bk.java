// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;


// Referenced classes of package com.wishabi.flipp.app:
//            bj, bi, FlyerCarouselFragment

final class bk
    implements Runnable
{

    final boolean a;
    final bj b;

    bk(bj bj1, boolean flag)
    {
        b = bj1;
        a = flag;
        super();
    }

    public final void run()
    {
        FlyerCarouselFragment.d(b.a.b, a);
    }
}
