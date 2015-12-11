// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.HalParseable;
import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalEpisode

public class HalTvSeason
    implements HalParseable
{

    private List episodes;
    private int seasonNumber;

    public HalTvSeason()
    {
        episodes = new ArrayList();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (HalTvSeason)obj;
            if (seasonNumber != ((HalTvSeason) (obj)).seasonNumber)
            {
                return false;
            }
            if (!episodes.equals(((HalTvSeason) (obj)).episodes))
            {
                return false;
            }
        }
        return true;
    }

    public List getEpisodes()
    {
        return episodes;
    }

    public int getSeasonNumber()
    {
        return seasonNumber;
    }

    public int hashCode()
    {
        return seasonNumber * 31 + episodes.hashCode();
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        seasonNumber = microdatapropertyresolver.fetchInt("seasonNumber");
        Object obj = microdatapropertyresolver.fetchOptionalItemList("episode");
        if (obj != null)
        {
            HalEpisode halepisode;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); episodes.add(halepisode))
            {
                MicrodataItem microdataitem = (MicrodataItem)((Iterator) (obj)).next();
                halepisode = new HalEpisode();
                halepisode.parseHalContent(microdatapropertyresolver.copy(microdataitem));
            }

        }
    }
}
