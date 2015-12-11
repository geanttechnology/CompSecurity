// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;
import com.groupon.GrouponApplication;
import com.groupon.adapter.CarouselFragmentPagerAdapter;
import com.groupon.fragment.Hotels;
import com.groupon.models.StartupContext;
import com.groupon.view.GrouponViewPager;

// Referenced classes of package com.groupon.activity:
//            Carousel

class this._cls0
    implements android.support.v4.view.PageChangeListener
{

    final Carousel this$0;

    public void onPageScrollStateChanged(int i)
    {
        if (i == 0)
        {
            android.app.Fragment fragment = pager.getCurrentFragment();
            if (fragment instanceof Hotels)
            {
                ((Hotels)fragment).setUpHotelMap();
            }
        }
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        Carousel.access$2000(Carousel.this);
        if (((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(i) != Channel.FEATURED)
        {
            GrouponApplication.startupContext.shouldLogGrp24 = false;
        }
        Carousel.access$2100(Carousel.this);
    }

    ()
    {
        this$0 = Carousel.this;
        super();
    }
}
