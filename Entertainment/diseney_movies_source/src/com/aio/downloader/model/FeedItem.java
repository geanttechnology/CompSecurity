// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.model;


public class FeedItem
{

    private String description;
    private String iconUrl;
    private String link;
    private Float rating;
    private String thumbnailurl;
    private String title;

    public FeedItem()
    {
    }

    public String getDescription()
    {
        return description;
    }

    public String getIconUrl()
    {
        return iconUrl;
    }

    public String getLink()
    {
        return link;
    }

    public Float getRating()
    {
        return rating;
    }

    public String getThumbnailurl()
    {
        return thumbnailurl;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setIconUrl(String s)
    {
        iconUrl = s;
    }

    public void setLink(String s)
    {
        link = s;
    }

    public void setRating(Float float1)
    {
        rating = float1;
    }

    public void setThumbnailurl(String s)
    {
        thumbnailurl = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }
}
