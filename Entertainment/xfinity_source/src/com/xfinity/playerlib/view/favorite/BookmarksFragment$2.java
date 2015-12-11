// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.favorite;

import com.xfinity.playerlib.model.Favorite;
import com.xfinity.playerlib.model.LiveStreamFavorite;
import com.xfinity.playerlib.model.VideoFavorite;

// Referenced classes of package com.xfinity.playerlib.view.favorite:
//            BookmarksFragment

class this._cls0
    implements com.xfinity.playerlib.view.browsehistory.gment.ItemClickListener
{

    final BookmarksFragment this$0;

    public void onItemClicked(Favorite favorite)
    {
        if (favorite instanceof VideoFavorite)
        {
            BookmarksFragment.access$500(BookmarksFragment.this).showDetail((VideoFavorite)favorite);
            return;
        } else
        {
            BookmarksFragment.access$600(BookmarksFragment.this, (LiveStreamFavorite)favorite);
            return;
        }
    }

    public volatile void onItemClicked(Object obj)
    {
        onItemClicked((Favorite)obj);
    }

    voriteListener()
    {
        this$0 = BookmarksFragment.this;
        super();
    }
}
