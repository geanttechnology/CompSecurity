// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.manager.SearchResultsDeepLinkParameterProcessor;
import com.groupon.models.country.Country;
import com.groupon.service.LocationService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.util:
//            GeoPoint

public class GlobalSearchUtil
{

    Context context;
    private Lazy locationService;

    public GlobalSearchUtil()
    {
    }

    public Hashtable createChannelToNameMap(Context context1, Country country)
    {
        Hashtable hashtable = new Hashtable();
        int i;
        if (country.isGetawaysTitle())
        {
            i = 0x7f0801e5;
        } else
        {
            i = 0x7f0803e7;
        }
        country = context1.getString(i);
        hashtable.put(Channel.ALL_CHANNELS, context1.getString(0x7f080202));
        hashtable.put(Channel.GOODS, context1.getString(0x7f080206));
        hashtable.put(Channel.NEARBY, context1.getString(0x7f080288));
        hashtable.put(Channel.GETAWAYS, country);
        hashtable.put(Channel.SHOPPING, context1.getString(0x7f08044b));
        hashtable.put(Channel.TRAVEL, country);
        return hashtable;
    }

    public String filterStringForChannel(Channel channel)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$groupon$Channel[];

            static 
            {
                $SwitchMap$com$groupon$Channel = new int[Channel.values().length];
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GOODS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.SHOPPING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.NEARBY.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.GETAWAYS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$groupon$Channel[Channel.TRAVEL.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.groupon.Channel[channel.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
        case 2: // '\002'
            return "goods";

        case 3: // '\003'
            return "local";

        case 4: // '\004'
        case 5: // '\005'
            return "travel";
        }
    }

    public ArrayList getSupportedChannels()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(Arrays.asList(new Channel[] {
            Channel.GOODS, Channel.NEARBY, Channel.GETAWAYS, Channel.TRAVEL, Channel.SHOPPING
        }));
        return arraylist;
    }

    public String loggingNameForChannel(Channel channel)
    {
        if (channel == null)
        {
            return "GPSearchTabAll";
        }
        switch (_cls2..SwitchMap.com.groupon.Channel[channel.ordinal()])
        {
        default:
            return "GPSearchTabAll";

        case 1: // '\001'
        case 2: // '\002'
            return "GPSearchTabGoods";

        case 3: // '\003'
            return "GPSearchTabLocal";

        case 4: // '\004'
        case 5: // '\005'
            return "GPSearchTabGetaways";
        }
    }

    public String loggingNameForChannelString(String s)
    {
        return loggingNameForChannel(Channel.safeValueOf(s));
    }

    public List mergeDeepLinkParams(String s, List list)
    {
        locationService = new Lazy(context) {

            final GlobalSearchUtil this$0;

            
            {
                this$0 = GlobalSearchUtil.this;
                super(context1);
            }
        };
        GeoPoint geopoint = ((LocationService)locationService.get()).getBestGuessForLocation();
        list.addAll(Arrays.asList(new Serializable[] {
            "lat", Float.valueOf(geopoint.getLatitudeDegrees()), "lng", Float.valueOf(geopoint.getLongitudeDegrees())
        }));
        return (new SearchResultsDeepLinkParameterProcessor(s, list)).process();
    }
}
