// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.abtest.TabOrderAbTestHelper;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.util:
//            GlobalSearchUtil, ChannelUtil

public class TabHelper
{

    private List channelList;
    private Hashtable channelToNameMap;
    private CurrentCountryManager currentCountryManager;
    private GlobalSearchUtil globalSearchUtil;
    private TabOrderAbTestHelper tabOrderAbTestHelper;
    private com.groupon.abtest.TabOrderAbTestHelper.TabOrderVariant tabOrderVariant;

    public TabHelper(Context context)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        generateChannelList(context);
    }

    private void generateChannelList(Context context)
    {
        ArrayList arraylist = globalSearchUtil.getSupportedChannels();
        channelToNameMap = globalSearchUtil.createChannelToNameMap(context, currentCountryManager.getCurrentCountry());
        boolean flag = currentCountryManager.getCurrentCountry().isUSACompatible();
        tabOrderVariant = tabOrderAbTestHelper.getTabOrderVariant();
        Object obj;
        if (tabOrderVariant != null)
        {
            obj = Arrays.asList(tabOrderVariant.getTabs());
        } else
        {
            obj = ChannelUtil.getDefaultChannelListAsStrings(flag);
        }
        channelList = new ArrayList(((List) (obj)).size());
        channelList.add(Channel.ALL_CHANNELS);
        context = new ChannelUtil(context);
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Channel channel = Channel.safeValueOf((String)((Iterator) (obj)).next());
            if (arraylist.contains(channel) && context.isChannelEnabledForSite(channel))
            {
                channelList.add(channel);
            }
        } while (true);
    }

    public Channel channelInPosition(int i)
    {
        return (Channel)channelList.get(i);
    }

    public int getNumChannels()
    {
        return channelList.size();
    }

    public String getPageTitle(int i)
    {
        return (String)channelToNameMap.get(channelList.get(i));
    }

    public int getPositionForChannel(Channel channel)
    {
        for (int i = 0; i < channelList.size(); i++)
        {
            if (channel == channelList.get(i))
            {
                return i;
            }
        }

        return 0;
    }
}
