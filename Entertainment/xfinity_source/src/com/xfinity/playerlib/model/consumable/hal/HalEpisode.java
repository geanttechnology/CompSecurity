// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalBaseConsumable, HalVideo

public class HalEpisode extends HalBaseConsumable
{

    private int episodeNumber;
    private boolean isNew;
    private Date originalAirdate;
    List videos;

    public HalEpisode()
    {
        videos = new ArrayList();
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
            obj = (HalEpisode)obj;
            if (episodeNumber != ((HalEpisode) (obj)).episodeNumber)
            {
                return false;
            }
            if (isNew != ((HalEpisode) (obj)).isNew)
            {
                return false;
            }
            if (originalAirdate == null ? ((HalEpisode) (obj)).originalAirdate != null : !originalAirdate.equals(((HalEpisode) (obj)).originalAirdate))
            {
                return false;
            }
            if (!videos.equals(((HalEpisode) (obj)).videos))
            {
                return false;
            }
        }
        return true;
    }

    public int getEpisodeNumber()
    {
        return episodeNumber;
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getNamespace()
    {
        return com.xfinity.playerlib.model.MerlinId.Namespace.TvEpisode;
    }

    public Date getOriginalAirdate()
    {
        return originalAirdate;
    }

    public List getVideos()
    {
        return videos;
    }

    public int hashCode()
    {
        int j = 0;
        int k = super.hashCode();
        int l = episodeNumber;
        int i;
        if (isNew)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (originalAirdate != null)
        {
            j = originalAirdate.hashCode();
        }
        return (((k * 31 + l) * 31 + i) * 31 + j) * 31 + videos.hashCode();
    }

    public boolean isNew()
    {
        return isNew;
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        super.parseHalContent(microdatapropertyresolver);
        episodeNumber = microdatapropertyresolver.fetchInt("episodeNumber");
        isNew = microdatapropertyresolver.fetchOptionalBoolean("isNew", false);
        originalAirdate = parseDate(microdatapropertyresolver.fetchOptionalString("datePublished/originalAirDate"));
        Object obj = microdatapropertyresolver.fetchOptionalItemList("video");
        if (obj != null)
        {
            HalVideo halvideo;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); videos.add(halvideo))
            {
                MicrodataItem microdataitem = (MicrodataItem)((Iterator) (obj)).next();
                halvideo = new HalVideo();
                halvideo.parseHalContent(microdatapropertyresolver.copy(microdataitem));
            }

        }
    }

    public void setVideos(List list)
    {
        videos = list;
    }
}
