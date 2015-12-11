// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;
import com.google.inject.Injector;
import com.groupon.Channel;
import com.groupon.abtest.TabOrderAbTestHelper;
import com.groupon.models.CarouselPage;
import com.groupon.provider.FragmentProvider;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.List;

// Referenced classes of package com.groupon.adapter:
//            CarouselPagesCreator

public class CarouselFragmentPagerAdapter extends FragmentPagerAdapter
{

    private CarouselPagesCreator carouselPagesCreator;

    public CarouselFragmentPagerAdapter(FragmentManager fragmentmanager, CurrentCountryManager currentcountrymanager, TabOrderAbTestHelper taborderabtesthelper, Injector injector)
    {
        super(fragmentmanager);
        carouselPagesCreator = new CarouselPagesCreator(injector, currentcountrymanager.getCurrentCountry(), taborderabtesthelper);
        carouselPagesCreator.createCarouselPages();
    }

    public Channel getChannel(int i)
    {
        return ((CarouselPage)carouselPagesCreator.getCarouselPages().get(i)).getChannel();
    }

    public int getChannelPosition(Channel channel)
    {
        for (int i = 0; i < carouselPagesCreator.getCarouselPages().size(); i++)
        {
            if (((CarouselPage)carouselPagesCreator.getCarouselPages().get(i)).getChannel() == channel)
            {
                return i;
            }
        }

        return -2;
    }

    public int getCount()
    {
        return carouselPagesCreator.getCarouselPages().size();
    }

    public Fragment getItem(int i)
    {
        return (Fragment)((CarouselPage)carouselPagesCreator.getCarouselPages().get(i)).getFragmentProvider().get();
    }

    public volatile CharSequence getPageTitle(int i)
    {
        return getPageTitle(i);
    }

    public String getPageTitle(int i)
    {
        String s = ((CarouselPage)carouselPagesCreator.getCarouselPages().get(i)).getTitle();
        if (s.length() <= 20)
        {
            return s;
        } else
        {
            return s.substring(0, 20);
        }
    }
}
