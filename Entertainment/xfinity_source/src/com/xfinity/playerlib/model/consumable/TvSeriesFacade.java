// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.Program;
import com.xfinity.playerlib.model.consumable.hal.HalEpisode;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeason;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            EpisodeFacade, SeriesWatchable

public class TvSeriesFacade
    implements Program, Serializable
{

    private final List allEpisodes;
    private final List allWatchables;
    private final Map seasonNumberToEpisodeMap;
    private final HalTvSeriesConsumable tvSeriesEntity;

    public TvSeriesFacade(HalTvSeriesConsumable haltvseriesconsumable)
    {
        Validate.notNull(haltvseriesconsumable);
        tvSeriesEntity = haltvseriesconsumable;
        java.util.TreeMap treemap = Maps.newTreeMap(Collections.reverseOrder());
        ArrayList arraylist = Lists.newArrayList();
        ArrayList arraylist1 = Lists.newArrayList();
        Object obj = haltvseriesconsumable.getSeasons();
        if (obj != null)
        {
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                HalTvSeason haltvseason = (HalTvSeason)((Iterator) (obj)).next();
                Object obj1 = haltvseason.getEpisodes();
                if (obj1 != null)
                {
                    obj1 = ((List) (obj1)).iterator();
                    while (((Iterator) (obj1)).hasNext()) 
                    {
                        Object obj2 = (HalEpisode)((Iterator) (obj1)).next();
                        if (((HalEpisode) (obj2)).getVideos().size() > 0)
                        {
                            if (!treemap.containsKey(Integer.valueOf(haltvseason.getSeasonNumber())))
                            {
                                treemap.put(Integer.valueOf(haltvseason.getSeasonNumber()), new ArrayList());
                            }
                            obj2 = new EpisodeFacade(((HalEpisode) (obj2)), haltvseriesconsumable);
                            ((List)treemap.get(Integer.valueOf(haltvseason.getSeasonNumber()))).add(obj2);
                            arraylist.add(obj2);
                            arraylist1.add(obj2);
                        }
                    }
                }
            }

        }
        seasonNumberToEpisodeMap = Collections.unmodifiableMap(treemap);
        allEpisodes = Collections.unmodifiableList(arraylist);
        allWatchables = Collections.unmodifiableList(arraylist1);
    }

    public EpisodeFacade findEpisodeById(MerlinId merlinid)
    {
        for (Iterator iterator = allEpisodes.iterator(); iterator.hasNext();)
        {
            EpisodeFacade episodefacade = (EpisodeFacade)iterator.next();
            if (episodefacade.getMerlinId().equals(merlinid))
            {
                return episodefacade;
            }
        }

        return null;
    }

    public SeriesWatchable findWatchableByVideoId(long l)
    {
        for (Iterator iterator = allWatchables.iterator(); iterator.hasNext();)
        {
            SeriesWatchable serieswatchable = (SeriesWatchable)iterator.next();
            if (serieswatchable.findVideoById(l) != null)
            {
                return serieswatchable;
            }
        }

        return null;
    }

    public List getAllEpisodeFacades()
    {
        return allWatchables;
    }

    public String getCast()
    {
        return tvSeriesEntity.castListAsString();
    }

    public String getDescription()
    {
        return tvSeriesEntity.getDescription();
    }

    public MerlinId getMerlinId()
    {
        return tvSeriesEntity.getMerlinEntityId();
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getMerlinIdNamespace()
    {
        return tvSeriesEntity.getNamespace();
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return tvSeriesEntity.getMerlinEntityId();
    }

    public List getReviews()
    {
        return tvSeriesEntity.getReviews();
    }

    public Map getSeasonNumberToEpisodeMap()
    {
        return seasonNumberToEpisodeMap;
    }

    public String getTitle()
    {
        return tvSeriesEntity.getTitle();
    }

    public boolean isMovie()
    {
        return false;
    }
}
