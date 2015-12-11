// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.b.x;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            FeaturedFragment

final class au extends x
{

    final FeaturedFragment a;

    au(FeaturedFragment featuredfragment)
    {
        a = featuredfragment;
        super();
    }

    public final void a()
    {
        FeaturedFragment.f(a).setRefreshing(false);
    }

    public final void a(boolean flag)
    {
        FeaturedFragment.f(a).setRefreshing(false);
        FeaturedFragment.d(a);
    }
}
