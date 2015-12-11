// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import com.google.inject.Injector;
import com.groupon.Channel;
import com.groupon.abtest.RapiAbTestHelper;
import com.groupon.abtest.TabOrderAbTestHelper;
import com.groupon.getaways.carousel.GetawaysFragmentProvider;
import com.groupon.models.CarouselPage;
import com.groupon.models.country.Country;
import com.groupon.provider.CouponProvider;
import com.groupon.provider.FeaturedProvider;
import com.groupon.provider.FeaturedRapiProvider;
import com.groupon.provider.FragmentProvider;
import com.groupon.provider.GoodsProvider;
import com.groupon.provider.HotelsProvider;
import com.groupon.provider.NearbyProvider;
import com.groupon.provider.OccasionsProvider;
import com.groupon.provider.ShoppingOrGoodsFragmentWrapperProvider;
import com.groupon.util.ChannelUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CarouselPagesCreator
{

    private final List carouselPages = new ArrayList();
    private final Country country;
    private final Injector injector;
    private final boolean isFeaturedUsingRapi;
    private final com.groupon.abtest.TabOrderAbTestHelper.TabOrderVariant tabOrderVariant;

    public CarouselPagesCreator(Injector injector1, Country country1, TabOrderAbTestHelper taborderabtesthelper)
    {
        injector = injector1;
        country = country1;
        tabOrderVariant = taborderabtesthelper.getTabOrderVariant();
        isFeaturedUsingRapi = ((RapiAbTestHelper)injector1.getInstance(com/groupon/abtest/RapiAbTestHelper)).isFeaturedUsingRAPI1511USCAEnabled();
    }

    private void createCarouselPages(List list)
    {
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Channel channel = (Channel)list.next();
            FragmentProvider fragmentprovider = getFragmentProvider(channel);
            if (fragmentprovider.isFragmentEnabled())
            {
                String s = fragmentprovider.getTitle();
                carouselPages.add(new CarouselPage(channel, fragmentprovider, s));
            }
        } while (true);
    }

    private void createDefaultCarouselPages(Country country1)
    {
        createCarouselPages(ChannelUtil.getDefaultChannelList(country1.isUSACompatible()));
    }

    private FragmentProvider getFragmentProvider(Channel channel)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$Channel[];

            static 
            {
                $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.FEATURED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.OCCASIONS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.HOTELS.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.COUPONS.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.groupon.Channel[channel.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return (FragmentProvider)injector.getInstance(com/groupon/provider/NearbyProvider);

        case 2: // '\002'
            if (isFeaturedUsingRapi)
            {
                return (FragmentProvider)injector.getInstance(com/groupon/provider/FeaturedRapiProvider);
            } else
            {
                return (FragmentProvider)injector.getInstance(com/groupon/provider/FeaturedProvider);
            }

        case 3: // '\003'
            return (FragmentProvider)injector.getInstance(com/groupon/provider/GoodsProvider);

        case 4: // '\004'
            return (FragmentProvider)injector.getInstance(com/groupon/provider/OccasionsProvider);

        case 5: // '\005'
            return (FragmentProvider)injector.getInstance(com/groupon/provider/HotelsProvider);

        case 6: // '\006'
        case 7: // '\007'
            return (FragmentProvider)injector.getInstance(com/groupon/getaways/carousel/GetawaysFragmentProvider);

        case 8: // '\b'
            return (FragmentProvider)injector.getInstance(com/groupon/provider/ShoppingOrGoodsFragmentWrapperProvider);

        case 9: // '\t'
            return (FragmentProvider)injector.getInstance(com/groupon/provider/CouponProvider);
        }
    }

    public void createCarouselPages()
    {
        if (tabOrderVariant != null)
        {
            Object obj = Arrays.asList(tabOrderVariant.getTabs());
            if (((List) (obj)).contains(tabOrderVariant.getDefaultChannel()) || ((List) (obj)).contains(Channel.FEATURED.toString()))
            {
                ArrayList arraylist = new ArrayList(((List) (obj)).size());
                for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(Channel.safeValueOf((String)((Iterator) (obj)).next()))) { }
                createCarouselPages(((List) (arraylist)));
            }
        }
        if (carouselPages.isEmpty())
        {
            createDefaultCarouselPages(country);
        }
    }

    public List getCarouselPages()
    {
        return carouselPages;
    }
}
