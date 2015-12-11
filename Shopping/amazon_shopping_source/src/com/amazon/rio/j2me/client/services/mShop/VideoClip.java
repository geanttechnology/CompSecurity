// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class VideoClip
{

    private String clipId;
    private String segmentId;
    private Integer slateImageHeight;
    private String slateImageUrl;
    private Integer slateImageWidth;
    private String title;
    private List videoFiles;

    public VideoClip()
    {
    }

    public void setClipId(String s)
    {
        clipId = s;
    }

    public void setSegmentId(String s)
    {
        segmentId = s;
    }

    public void setSlateImageHeight(Integer integer)
    {
        slateImageHeight = integer;
    }

    public void setSlateImageUrl(String s)
    {
        slateImageUrl = s;
    }

    public void setSlateImageWidth(Integer integer)
    {
        slateImageWidth = integer;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setVideoFiles(List list)
    {
        videoFiles = list;
    }
}
