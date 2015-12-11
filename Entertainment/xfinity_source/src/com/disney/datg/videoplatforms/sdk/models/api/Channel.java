// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            Assets, Thumbnails, TvRating

public class Channel
    implements Serializable
{

    private String accesslevel;
    private Assets assets;
    private String description;
    private String id;
    private Thumbnails thumbnails;
    private String title;
    private TvRating tvrating;
    private String workflowid;

    public Channel()
    {
    }

    public String getAccesslevel()
    {
        return accesslevel;
    }

    public Assets getAssets()
    {
        return assets;
    }

    public String getDescription()
    {
        return description;
    }

    public String getId()
    {
        return id;
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
