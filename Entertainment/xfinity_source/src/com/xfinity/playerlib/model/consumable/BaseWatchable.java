// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.model.Rating;
import com.comcast.cim.utils.UIPresentationUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            Watchable, VideoFacade

public abstract class BaseWatchable
    implements Watchable
{

    private Date expiresDate;
    private boolean hasDownloadableVideo;
    private String sortTitle;
    private Rating videoRating;
    private String videoSubRatings;

    public BaseWatchable()
    {
        hasDownloadableVideo = false;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (BaseWatchable)obj;
            if (expiresDate == null ? ((BaseWatchable) (obj)).expiresDate != null : !expiresDate.equals(((BaseWatchable) (obj)).expiresDate))
            {
                return false;
            }
            if (sortTitle == null ? ((BaseWatchable) (obj)).sortTitle != null : !sortTitle.equals(((BaseWatchable) (obj)).sortTitle))
            {
                return false;
            }
            if (videoRating == null ? ((BaseWatchable) (obj)).videoRating != null : !videoRating.equals(((BaseWatchable) (obj)).videoRating))
            {
                return false;
            }
            if (videoSubRatings == null ? ((BaseWatchable) (obj)).videoSubRatings != null : !videoSubRatings.equals(((BaseWatchable) (obj)).videoSubRatings))
            {
                return false;
            }
        }
        return true;
    }

    public VideoFacade findVideoById(long l)
    {
        for (Iterator iterator = getVideos().iterator(); iterator.hasNext();)
        {
            VideoFacade videofacade = (VideoFacade)iterator.next();
            if (videofacade.getVideoId() == l)
            {
                return videofacade;
            }
        }

        return null;
    }

    public Date getExpiresDate()
    {
        return expiresDate;
    }

    public Set getLanguageCodes()
    {
        HashSet hashset = new HashSet();
        if (getVideos() != null)
        {
            Iterator iterator = getVideos().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                VideoFacade videofacade = (VideoFacade)iterator.next();
                if (videofacade.getLanguageCodes() != null && !videofacade.getLanguageCodes().isEmpty())
                {
                    hashset.add(videofacade.getLanguageCodes().get(0));
                }
            } while (true);
        }
        return hashset;
    }

    public String getNextItemDisplayTitle()
    {
        return null;
    }

    public Tuple getNextVideoItem(VideoFacade videofacade, String s)
    {
        return null;
    }

    public String getSortTitle()
    {
        if (sortTitle == null)
        {
            sortTitle = UIPresentationUtil.getSortStringFromTitle(getDisplayTitle());
        }
        return sortTitle;
    }

    public Rating getVideoRating()
    {
        return videoRating;
    }

    public String getVideoSubRatings()
    {
        return videoSubRatings;
    }

    public boolean hasDownloadableVideo()
    {
        return hasDownloadableVideo;
    }

    public int hashCode()
    {
        int l = 0;
        int i;
        int j;
        int k;
        if (videoRating != null)
        {
            i = videoRating.hashCode();
        } else
        {
            i = 0;
        }
        if (videoSubRatings != null)
        {
            j = videoSubRatings.hashCode();
        } else
        {
            j = 0;
        }
        if (expiresDate != null)
        {
            k = expiresDate.hashCode();
        } else
        {
            k = 0;
        }
        if (sortTitle != null)
        {
            l = sortTitle.hashCode();
        }
        return ((i * 31 + j) * 31 + k) * 31 + l;
    }

    protected void initFromVideos()
    {
        Iterator iterator = getVideos().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoFacade videofacade = (VideoFacade)iterator.next();
            videoRating = videofacade.getVideoRating();
            videoSubRatings = videofacade.getVideoSubRating();
            Date date = videofacade.getExpirationDate();
            if (expiresDate == null || date != null && date.after(expiresDate))
            {
                expiresDate = date;
            }
            if (videofacade.isDownloadable())
            {
                hasDownloadableVideo = true;
            }
        } while (true);
    }
}
