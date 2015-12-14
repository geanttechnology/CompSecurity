// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import my.googlemusic.play.adapters.feed.HeaderLayoutManagerFixed;
import my.googlemusic.play.feed.listeners.EndlessRecyclerOnScrollListener;

// Referenced classes of package my.googlemusic.play.activities:
//            FavoriteActivity

class gerFixed extends EndlessRecyclerOnScrollListener
{

    final FavoriteActivity this$0;

    public void onLoadMore(int i)
    {
    /* block-local class not found */
    class _cls1 {}

        (new Thread(new _cls1(i))).start();
    }

    public void onScroll(int i, int j)
    {
    }

    gerFixed(HeaderLayoutManagerFixed headerlayoutmanagerfixed)
    {
        this$0 = FavoriteActivity.this;
        super(headerlayoutmanagerfixed);
    }
}
