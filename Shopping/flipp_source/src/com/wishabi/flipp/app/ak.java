// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            FavoritesFragment

final class ak
    implements android.view.View.OnLayoutChangeListener
{

    final FavoritesFragment a;

    ak(FavoritesFragment favoritesfragment)
    {
        a = favoritesfragment;
        super();
    }

    public final void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        FavoritesFragment.b(a);
    }
}
