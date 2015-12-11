// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.tracking;

import com.comcast.cim.cmasl.analytics.EventData;
import com.comcast.cim.model.Rating;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;

public class FoxAnalyticsEventData extends EventData
{

    public FoxAnalyticsEventData(String s, VideoFacade videofacade, VideoBookmark videobookmark)
    {
        String s1;
        if (videofacade.getDurationInSeconds() > 60)
        {
            int i = videofacade.getDurationInSeconds() / 60;
            int j = videofacade.getDurationInSeconds();
            s1 = (new StringBuilder()).append(String.valueOf(i)).append(":").append(j % 60).toString();
        } else
        {
            s1 = (new StringBuilder()).append("0:").append(videofacade.getDurationInSeconds()).toString();
        }
        addData("c_event", s);
        addData("c_format", "longform");
        addData("c_rating", videofacade.getVideoRating().getRating());
        addData("c_network_name", videofacade.getNetworkInfo().getName());
        addData("c_playerId", "xtv app_android");
        addData("c_contentId", String.valueOf(videofacade.getVideoId()));
        addData("c_title", videofacade.getTitle());
        addData("c_duration", s1);
        if (videofacade.isMovie())
        {
            addData("c_content_type", "movie clip");
            addData("c_show", videofacade.getTitle());
        } else
        {
            addData("c_content_type", "full episode");
            addData("c_show", videofacade.getTitle());
            addData("c_season", String.valueOf(videobookmark.getSeasonNumber()));
            addData("c_episode", String.valueOf(videobookmark.getEpisodeNumber()));
        }
        addData("c_MVPD", "comcast");
        addData("c_screensize", "standard");
    }
}
