// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            FeaturedFragment

final class aq
    implements android.view.View.OnLayoutChangeListener
{

    final FeaturedFragment a;

    aq(FeaturedFragment featuredfragment)
    {
        a = featuredfragment;
        super();
    }

    public final void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
            int k1, int l1)
    {
        FeaturedFragment.d(a);
    }
}
