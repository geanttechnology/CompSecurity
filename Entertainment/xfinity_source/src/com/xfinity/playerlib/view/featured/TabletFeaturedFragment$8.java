// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import com.xfinity.playerlib.model.EditorialTVSeries;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;
import it.sephiroth.android.library.widget.AdapterView;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            TabletFeaturedFragment

class this._cls0
    implements it.sephiroth.android.library.widget.ckListener
{

    final TabletFeaturedFragment this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (EditorialTVSeries)adapterview.getItemAtPosition(i);
        bookmarkUtils.promptBookmarkDialog(TabletFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
        return true;
    }

    ckListener()
    {
        this$0 = TabletFeaturedFragment.this;
        super();
    }
}
