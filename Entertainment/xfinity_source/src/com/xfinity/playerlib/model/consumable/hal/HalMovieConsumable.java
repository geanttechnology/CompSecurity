// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable.hal;

import com.comcast.cim.cmasl.hal.model.MicrodataPropertyResolver;
import com.comcast.cim.microdata.model.MicrodataItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.model.consumable.hal:
//            HalBaseConsumable, HalVideo

public class HalMovieConsumable extends HalBaseConsumable
{

    private List videos;
    private String yearPublished;

    public HalMovieConsumable()
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
            obj = (HalMovieConsumable)obj;
            if (!yearPublished.equals(((HalMovieConsumable) (obj)).yearPublished))
            {
                return false;
            }
            if (!videos.equals(((HalMovieConsumable) (obj)).videos))
            {
                return false;
            }
        }
        return true;
    }

    public com.xfinity.playerlib.model.MerlinId.Namespace getNamespace()
    {
        return com.xfinity.playerlib.model.MerlinId.Namespace.Movie;
    }

    public List getVideos()
    {
        return videos;
    }

    public String getYearPublished()
    {
        return yearPublished;
    }

    public int hashCode()
    {
        return (super.hashCode() * 31 + yearPublished.hashCode()) * 31 + videos.hashCode();
    }

    public void parseHalContent(MicrodataPropertyResolver microdatapropertyresolver)
    {
        super.parseHalContent(microdatapropertyresolver);
        yearPublished = microdatapropertyresolver.fetchOptionalString("yearPublished");
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
