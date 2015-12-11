// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            CouponFragment

final class x extends com.wishabi.flipp.b.x
{

    final CouponFragment a;

    x(CouponFragment couponfragment)
    {
        a = couponfragment;
        super();
    }

    public final void a()
    {
        CouponFragment.b(a).setRefreshing(false);
    }

    public final void a(boolean flag)
    {
        CouponFragment.b(a).setRefreshing(false);
    }
}
