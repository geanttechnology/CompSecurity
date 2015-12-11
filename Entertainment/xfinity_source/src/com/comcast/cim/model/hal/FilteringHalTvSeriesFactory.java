// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.model.hal;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.xfinity.playerlib.model.consumable.hal.HalEpisode;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeason;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.comcast.cim.model.hal:
//            HalTvSeriesFactory, HalVideoFilter

public class FilteringHalTvSeriesFactory extends HalTvSeriesFactory
{

    private final HalVideoFilter videoFilter;

    public volatile HalParseable createWithUrl(String s, HalHttpClient halhttpclient)
    {
        return createWithUrl(s, halhttpclient);
    }

    public HalTvSeriesConsumable createWithUrl(String s, HalHttpClient halhttpclient)
    {
        s = (HalTvSeriesConsumable)super.createWithUrl(s, halhttpclient);
        halhttpclient = s.getSeasons().iterator();
        do
        {
            if (!halhttpclient.hasNext())
            {
                break;
            }
            List list = ((HalTvSeason)halhttpclient.next()).getEpisodes();
            for (Iterator iterator = list.iterator(); iterator.hasNext();)
            {
                HalEpisode halepisode = (HalEpisode)iterator.next();
                List list1 = videoFilter.filter(halepisode.getVideos());
                if (list1.size() == 0)
                {
                    iterator.remove();
                } else
                {
                    halepisode.setVideos(list1);
                }
            }

            if (list.size() == 0)
            {
                halhttpclient.remove();
            }
        } while (true);
        return s;
    }
}
