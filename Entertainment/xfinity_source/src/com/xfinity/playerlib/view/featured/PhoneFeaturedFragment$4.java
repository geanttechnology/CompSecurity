// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.xfinity.playerlib.model.CoverVideo;
import com.xfinity.playerlib.model.EditorialMovie;
import com.xfinity.playerlib.model.EditorialProgram;
import com.xfinity.playerlib.model.EditorialTVSeries;
import com.xfinity.playerlib.model.VideoFavorite;
import com.xfinity.playerlib.view.favorite.BookmarkUtils;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment, FeaturedSection

class val.gallery
    implements android.widget.ickListener
{

    final PhoneFeaturedFragment this$0;
    final FeaturedSection val$featuredSection;
    final ListView val$gallery;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (val$featuredSection != FeaturedSection.TV_SERIES) goto _L2; else goto _L1
_L1:
        adapterview = (EditorialTVSeries)val$gallery.getAdapter().getItem(i);
        bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getParentMerlinIdIfApplicable(), adapterview.getTitle()));
_L4:
        return true;
_L2:
        if (val$featuredSection == FeaturedSection.MOVIES)
        {
            adapterview = (EditorialMovie)val$gallery.getAdapter().getItem(i);
            bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
        } else
        {
            adapterview = (CoverVideo)adapterview.getItemAtPosition(i);
            if (adapterview.getEntityType().equalsIgnoreCase("Movie"))
            {
                bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getMerlinId(), adapterview.getTitle()));
            } else
            if (adapterview.getEntityType().equalsIgnoreCase("TvSeries"))
            {
                bookmarkUtils.promptBookmarkDialog(PhoneFeaturedFragment.this, new VideoFavorite(adapterview.getParentMerlinIdIfApplicable(), adapterview.getTitle()));
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    A()
    {
        this$0 = final_phonefeaturedfragment;
        val$featuredSection = featuredsection;
        val$gallery = ListView.this;
        super();
    }
}
