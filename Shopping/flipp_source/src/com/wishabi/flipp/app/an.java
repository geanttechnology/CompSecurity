// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.b.x;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;

// Referenced classes of package com.wishabi.flipp.app:
//            FavoritesFragment

final class an extends x
{

    final FavoritesFragment a;

    an(FavoritesFragment favoritesfragment)
    {
        a = favoritesfragment;
        super();
    }

    public final void a()
    {
        FavoritesFragment.e(a).setRefreshing(false);
    }

    public final void a(boolean flag)
    {
        FavoritesFragment.e(a).setRefreshing(false);
        FavoritesFragment.b(a);
    }
}
