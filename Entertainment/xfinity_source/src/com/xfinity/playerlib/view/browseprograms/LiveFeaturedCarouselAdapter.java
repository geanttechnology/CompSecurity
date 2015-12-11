// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v13.app.FragmentStatePagerAdapter;
import com.xfinity.playerlib.view.CarouselItemFragment;
import java.util.List;

public class LiveFeaturedCarouselAdapter extends FragmentStatePagerAdapter
    implements LiveStreamsFragment.HalLiveFeaturedContentContainer
{

    private final int imageHeight;
    private final int imageWidth;
    private List liveFeaturedContentList;

    public LiveFeaturedCarouselAdapter(FragmentManager fragmentmanager, List list, int i, int j)
    {
        super(fragmentmanager);
        liveFeaturedContentList = list;
        imageWidth = i;
        imageHeight = j;
    }

    public int getCount()
    {
        if (liveFeaturedContentList != null)
        {
            return liveFeaturedContentList.size();
        } else
        {
            return 0;
        }
    }

    public Fragment getItem(int i)
    {
        CarouselItemFragment carouselitemfragment = new CarouselItemFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("imageHeight", imageHeight);
        bundle.putInt("imageWidth", imageWidth);
        bundle.putParcelable("content", (Parcelable)liveFeaturedContentList.get(i));
        carouselitemfragment.setArguments(bundle);
        return carouselitemfragment;
    }

    public void setLiveFeaturedContentList(List list)
    {
        liveFeaturedContentList = list;
    }
}
