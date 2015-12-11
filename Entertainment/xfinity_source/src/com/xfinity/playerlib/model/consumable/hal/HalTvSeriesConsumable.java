// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import com.xfinity.playerlib.model.MerlinId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalBaseConsumable, HalTvSeason, HalEpisode, HalVideo

public class HalTvSeriesConsumable extends HalBaseConsumable
{

    List seasons;

    public HalTvSeriesConsumable()
    {
        seasons = new ArrayList();
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            if (!super.equals(obj))
            {
                return false;
            }
            obj = (HalTvSeriesConsumable)obj;
            if (!seasons.equals(((HalTvSeriesConsumable) (obj)).seasons))
            {
                return false;
            }
        }
        return true;
    }

    public HalEpisode findEpisodeByMerlinId(MerlinId merlinid)
    {
        Iterator iterator = seasons.iterator();
        HalEpisode halepisode;
label0:
        do
        {
            if (iterator.hasNext())
            {
                Iterator iterator1 = ((HalTvSeason)iterator.next()).getEpisodes().iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        continue label0;
                    }
                    halepisode = (HalEpisode)iterator1.next();
                } while (!halepisode.getMerlinEntityId().equals(merlinid));
                break;
            } else
            {
                return null;
            }
        } while (true);
        return halepisode;
    }

    public HalEpisode findEpisodeByVideoId(long l)
    {
        Iterator iterator = seasons.iterator();
_L2:
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        iterator1 = ((HalTvSeason)iterator.next()).getEpisodes().iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        HalEpisode halepisode;
        Iterator iterator2;
        halepisode = (HalEpisode)iterator1.next();
        iterator2 = halepisode.getVideos().iterator();
_L6:
        if (!iterator2.hasNext()) goto _L4; else goto _L3
_L3:
        if (((HalVideo)iterator2.next()).getVideoId() != l) goto _L6; else goto _L5
_L5:
        return halepisode;
        return null;
    }

    public HalTvSeason findSeasonForEpisode(HalEpisode halepisode)
    {
        Iterator iterator = seasons.iterator();
_L2:
        HalTvSeason haltvseason;
        Iterator iterator1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        haltvseason = (HalTvSeason)iterator.next();
        iterator1 = haltvseason.getEpisodes().iterator();
_L4:
        if (!iterator1.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((HalEpisode)iterator1.next()).getMerlinEntityId().equals(halepisode.getMerlinEntityId())) goto _L4; else goto _L3
_L3:
        return haltvseason;
        return null;
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getNamespace()
    {
        return com.xfinity.playerlib.model.MerlinId.Namespace.TvSeries;
    }

    public List getSeasons()
    {
        return seasons;
    }

    public int hashCode()
    {
        return super.hashCode() * 31 + seasons.hashCode();
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        super.parseHalContent(microdatapropertyresolver);
        Object obj = microdatapropertyresolver.fetchOptionalItemList("season");
        if (obj != null)
        {
            HalTvSeason haltvseason;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); seasons.add(haltvseason))
            {
                MicrodataItem microdataitem = (MicrodataItem)((Iterator) (obj)).next();
                haltvseason = new HalTvSeason();
                haltvseason.parseHalContent(microdatapropertyresolver.copy(microdataitem));
            }

        }
    }
}
