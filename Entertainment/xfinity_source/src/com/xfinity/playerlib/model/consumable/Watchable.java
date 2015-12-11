// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import android.net.Uri;
import com.comcast.cim.cmasl.utils.container.Either;
import com.comcast.cim.cmasl.utils.container.Tuple;
import com.comcast.cim.model.Rating;
import com.xfinity.playerlib.model.MerlinId;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            VideoFacade, SeriesWatchableInfo

public interface Watchable
    extends Serializable
{

    public abstract VideoFacade findVideoById(long l);

    public abstract Either getBackingEntity();

    public abstract String getCast();

    public abstract String getDescription();

    public abstract String getDisplayTitle();

    public abstract Uri getEntityDeeplinkUri(String s);

    public abstract Date getExpiresDate();

    public abstract Set getLanguageCodes();

    public abstract MerlinId getMerlinId();

    public abstract String getNextItemDisplayTitle();

    public abstract Tuple getNextVideoItem(VideoFacade videofacade, String s);

    public abstract MerlinId getParentMerlinIdIfApplicable();

    public abstract Uri getPlaybackDeeplinkUri(String s);

    public abstract SeriesWatchableInfo getSeriesInfoIfApplicable();

    public abstract String getSortTitle();

    public abstract String getTitle();

    public abstract Rating getVideoRating();

    public abstract String getVideoSubRatings();

    public abstract Set getVideos();

    public abstract boolean hasDownloadableVideo();

    public abstract boolean isNew();
}
