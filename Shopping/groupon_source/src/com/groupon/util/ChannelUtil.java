// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.getaways.carousel.GetawaysFragmentProvider;
import com.groupon.provider.CouponProvider;
import com.groupon.provider.GoodsProvider;
import com.groupon.provider.HotelsProvider;
import com.groupon.provider.NearbyProvider;
import com.groupon.provider.OccasionsProvider;
import com.groupon.provider.ShoppingOrGoodsFragmentWrapperProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class ChannelUtil
{

    private CouponProvider couponProvider;
    private GetawaysFragmentProvider getawaysProvider;
    private GoodsProvider goodsProvider;
    private HotelsProvider hotelsProvider;
    private NearbyProvider nearbyProvider;
    private OccasionsProvider occasionsProvider;
    private ShoppingOrGoodsFragmentWrapperProvider shoppingProvider;

    public ChannelUtil(Context context)
    {
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public static List getDefaultChannelList(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        if (flag)
        {
            arraylist.add(Channel.NEARBY);
            arraylist.add(Channel.FEATURED);
            arraylist.add(Channel.GOODS);
            arraylist.add(Channel.OCCASIONS);
            arraylist.add(Channel.HOTELS);
            arraylist.add(Channel.GETAWAYS);
            arraylist.add(Channel.COUPONS);
            return arraylist;
        } else
        {
            arraylist.add(Channel.TRAVEL);
            arraylist.add(Channel.NEARBY);
            arraylist.add(Channel.FEATURED);
            arraylist.add(Channel.SHOPPING);
            arraylist.add(Channel.OCCASIONS);
            return arraylist;
        }
    }

    public static List getDefaultChannelListAsStrings(boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = getDefaultChannelList(flag).iterator(); iterator.hasNext(); arraylist.add(((Channel)iterator.next()).toString())) { }
        return arraylist;
    }

    public boolean isChannelEnabledForSite(Channel channel)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$groupon$Channel[];

            static 
            {
                $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 3;
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
                    $SwitchMap$com$groupon$Channel[Channel.COUPONS.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.FEATURED.ordinal()] = 9;
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
            return false;

        case 1: // '\001'
            return goodsProvider.isFragmentEnabled();

        case 2: // '\002'
            return shoppingProvider.isFragmentEnabled();

        case 3: // '\003'
            return nearbyProvider.isFragmentEnabled();

        case 4: // '\004'
            return occasionsProvider.isFragmentEnabled();

        case 5: // '\005'
            return hotelsProvider.isFragmentEnabled();

        case 6: // '\006'
        case 7: // '\007'
            return getawaysProvider.isFragmentEnabled();

        case 8: // '\b'
            return couponProvider.isFragmentEnabled();

        case 9: // '\t'
            return true;
        }
    }
}
