// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.xfinity.playerlib.model.CoverVideo;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import it.sephiroth.android.library.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class this._cls0
    implements it.sephiroth.android.library.widget.kListener
{

    final TabletFeaturedFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (CoverVideo)adapterview.getItemAtPosition(i);
        if (!adapterview.getEntityType().equalsIgnoreCase("Movie")) goto _L2; else goto _L1
_L1:
        bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
_L4:
        return true;
_L2:
        if (adapterview.getEntityType().equalsIgnoreCase("TvSeries"))
        {
            bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getParentMerlinIdIfApplicable(), adapterview.getTitle()));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    kListener()
    {
        this$0 = TabletFeaturedFragment.this;
        super();
    }
}
