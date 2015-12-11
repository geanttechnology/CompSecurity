// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            AdTarget, Airdates, Assets, Duration, 
//            Season, Show, Thumbnails, TvRating

public class Video
    implements Serializable, Cloneable
{

    private String accesslevel;
    private AdTarget adtarget;
    private Airdates airdates;
    private Assets assets;
    private String availdate;
    private String description;
    private Duration duration;
    private String expiredate;
    private String id;
    private boolean inSubWindon;
    private String number;
    private Season season;
    private Show show;
    private Thumbnails thumbnails;
    private String title;
    private TvRating tvrating;
    private String workflowid;

    public Video()
    {
        inSubWindon = false;
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        return super.clone();
    }

    public String getAccesslevel()
    {
        return accesslevel;
    }

    public AdTarget getAdtarget()
    {
        return adtarget;
    }

    public Airdates getAirdates()
    {
        return airdates;
    }

    public Assets getAssets()
    {
        return assets;
    }

    public String getAvaildate()
    {
        return availdate;
    }

    public String getDescription()
    {
        return description;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public String getExpiredate()
    {
        return expiredate;
    }

    public String getId()
    {
        return id;
    }

    public String getNumber()
    {
        return number;
    }

    public Season getSeason()
    {
        return season;
    }

    public Show getShow()
    {
        return show;
    }

    public Thumbnails getThumbnails()
    {
        return thumbnails;
    }

    public String getTitle()
    {
        return title;
    }

    public TvRating getTvrating()
    {
        return tvrating;
    }

    public String getWorkflowid()
    {
        return workflowid;
    }
}
