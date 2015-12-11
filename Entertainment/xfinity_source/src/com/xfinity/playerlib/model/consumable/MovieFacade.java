// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import android.net.Uri;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.LeftEither;
import com.google.common.collect.Sets;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalVideo;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            BaseWatchable, VideoFacade, SeriesWatchableInfo

public class MovieFacade extends BaseWatchable
{

    private HalMovieConsumable movieEntity;
    private final Set videos;

    public MovieFacade(HalMovieConsumable halmovieconsumable)
    {
        Validate.notNull(halmovieconsumable);
        movieEntity = halmovieconsumable;
        java.util.HashSet hashset = Sets.newHashSet();
        for (Iterator iterator = halmovieconsumable.getVideos().iterator(); iterator.hasNext(); hashset.add(new VideoFacade((HalVideo)iterator.next(), halmovieconsumable.getMerlinEntityId()))) { }
        videos = hashset;
        initFromVideos();
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
            obj = (MovieFacade)obj;
            if (movieEntity == null ? ((MovieFacade) (obj)).movieEntity != null : !movieEntity.equals(((MovieFacade) (obj)).movieEntity))
            {
                return false;
            }
            if (videos == null ? ((MovieFacade) (obj)).videos != null : !videos.equals(((MovieFacade) (obj)).videos))
            {
                return false;
            }
        }
        return true;
    }

    public Either getBackingEntity()
    {
        return new LeftEither(movieEntity);
    }

    public String getCast()
    {
        return movieEntity.castListAsString();
    }

    public String getDescription()
    {
        return movieEntity.getDescription();
    }

    public String getDisplayTitle()
    {
        return getTitle();
    }

    public Uri getEntityDeeplinkUri(String s)
    {
        return Uri.parse((new StringBuilder()).append(s).append("://entity/1/").append(getMerlinId().getSimpleId()).toString());
    }

    public MerlinId getMerlinId()
    {
        return movieEntity.getMerlinEntityId();
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return getMerlinId();
    }

    public Uri getPlaybackDeeplinkUri(String s)
    {
        return Uri.parse((new StringBuilder()).append(s).append("://playback/1/").append(getMerlinId().getSimpleId()).toString());
    }

    public String getReleaseYear()
    {
        return movieEntity.getYearPublished();
    }

    public List getReviews()
    {
        return movieEntity.getReviews();
    }

    public SeriesWatchableInfo getSeriesInfoIfApplicable()
    {
        return null;
    }

    public String getTitle()
    {
        return movieEntity.getTitle();
    }

    public Set getVideos()
    {
        return videos;
    }

    public int hashCode()
    {
        int j = 0;
        int k = super.hashCode();
        int i;
        if (videos != null)
        {
            i = videos.hashCode();
        } else
        {
            i = 0;
        }
        if (movieEntity != null)
        {
            j = movieEntity.hashCode();
        }
        return (k * 31 + i) * 31 + j;
    }

    public boolean isNew()
    {
        return false;
    }
}
