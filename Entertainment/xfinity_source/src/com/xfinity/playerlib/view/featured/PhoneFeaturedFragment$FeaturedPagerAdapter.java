// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.comcast.cim.cmasl.utils.collections.CollectionUtils;
import com.google.common.collect.Lists;
import com.xfinity.playerlib.model.editorial.FeaturedResource;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            PhoneFeaturedFragment, FeaturedSection

private class programLists extends PagerAdapter
{

    private List labels;
    private List programLists;
    final PhoneFeaturedFragment this$0;

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public int getCount()
    {
        return labels.size();
    }

    public CharSequence getPageTitle(int i)
    {
        return (CharSequence)labels.get(i);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        return PhoneFeaturedFragment.access$400(PhoneFeaturedFragment.this, viewgroup, FeaturedSection.values()[i], (List)programLists.get(i), getPageTitle(i).toString());
    }

    public boolean isViewFromObject(View view, Object obj)
    {
        return view == obj;
    }

    public void setData(FeaturedResource featuredresource)
    {
        labels = Lists.newArrayList(new String[] {
            featuredresource.getCoverVideoCollectionTitle(), featuredresource.getSeriesCollectionTitle(), featuredresource.getMovieCollectionTitle()
        });
        programLists = CollectionUtils.createList(featuredresource.getCoverVideos(), featuredresource.getSeries(), featuredresource.getMovies());
        notifyDataSetChanged();
    }

    public ()
    {
        this$0 = PhoneFeaturedFragment.this;
        super();
        labels = Lists.newArrayList();
        programLists = Lists.newArrayList();
    }
}
