// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.widget.ImageView;
import it.sephiroth.android.library.widget.AbsHListView;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class val.justAiredShadowRight
    implements it.sephiroth.android.library.widget.ener
{

    final TabletFeaturedFragment this$0;
    final ImageView val$justAiredShadowLeft;
    final ImageView val$justAiredShadowRight;

    public void onScroll(AbsHListView abshlistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsHListView abshlistview, int i)
    {
        TabletFeaturedFragment.access$400(TabletFeaturedFragment.this, TabletFeaturedFragment.access$000(TabletFeaturedFragment.this), val$justAiredShadowLeft, val$justAiredShadowRight);
    }

    ener()
    {
        this$0 = final_tabletfeaturedfragment;
        val$justAiredShadowLeft = imageview;
        val$justAiredShadowRight = ImageView.this;
        super();
    }
}
