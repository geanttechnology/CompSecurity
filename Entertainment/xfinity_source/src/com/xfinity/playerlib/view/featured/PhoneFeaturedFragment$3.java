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
import com.xfinity.playerlib.model.EditorialTVSeries;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment, FeaturedSection

class val.gallery
    implements android.widget.istener
{

    final PhoneFeaturedFragment this$0;
    final FeaturedSection val$featuredSection;
    final ListView val$gallery;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (val$featuredSection == FeaturedSection.TV_SERIES)
        {
            showDetail(((EditorialTVSeries)val$gallery.getAdapter().getItem(i)).getMerlinId());
            return;
        }
        if (val$featuredSection == FeaturedSection.MOVIES)
        {
            showDetail(((EditorialMovie)val$gallery.getAdapter().getItem(i)).getMerlinId());
            return;
        } else
        {
            adapterview = (CoverVideo)val$gallery.getAdapter().getItem(i);
            showDetail(adapterview.getParentMerlinIdIfApplicable(), adapterview.getEpisodeMerlinId());
            return;
        }
    }

    A()
    {
        this$0 = final_phonefeaturedfragment;
        val$featuredSection = featuredsection;
        val$gallery = ListView.this;
        super();
    }
}
