// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.widget.ImageView;
import it.sephiroth.android.library.widget.AbsHListView;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class val.newMoviesShadowRight
    implements it.sephiroth.android.library.widget.ner
{

    final TabletFeaturedFragment this$0;
    final ImageView val$newMoviesShadowLeft;
    final ImageView val$newMoviesShadowRight;

    public void onScroll(AbsHListView abshlistview, int i, int j, int k)
    {
    }

    public void onScrollStateChanged(AbsHListView abshlistview, int i)
    {
        TabletFeaturedFragment.access$400(TabletFeaturedFragment.this, TabletFeaturedFragment.access$600(TabletFeaturedFragment.this), val$newMoviesShadowLeft, val$newMoviesShadowRight);
    }

    ner()
    {
        this$0 = final_tabletfeaturedfragment;
        val$newMoviesShadowLeft = imageview;
        val$newMoviesShadowRight = ImageView.this;
        super();
    }
}
