// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.model;

import com.mdotm.android.vast.Companion;
import java.io.Serializable;
import java.util.ArrayList;

public class MdotMAdResponse
    implements Serializable
{

    private static final long serialVersionUID = 0xc31444ff6642717L;
    private String Text;
    private int adType;
    private boolean cachedLocally;
    private Companion companion;
    private int height;
    private String imageUrl;
    private String imp_pixel;
    private ArrayList impression;
    private boolean isRequestForBannerAd;
    private String landingUrl;
    private int launchType;
    private String originalImageUrl;
    private int resourceType;
    private int status;
    private int width;

    public MdotMAdResponse()
    {
    }

    public int getAdType()
    {
        return adType;
    }

    public Companion getCompanion()
    {
        return companion;
    }

    public int getHeight()
    {
        return height;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getImp_pixel()
    {
        return imp_pixel;
    }

    public ArrayList getImpression()
    {
        return impression;
    }

    public String getLandingUrl()
    {
        return landingUrl;
    }

    public int getLaunchType()
    {
        return launchType;
    }

    public String getOriginalImageUrl()
    {
        return originalImageUrl;
    }

    public int getResourceType()
    {
        return resourceType;
    }

    public int getStatus()
    {
        return status;
    }

    public String getText()
    {
        return Text;
    }

    public int getWidth()
    {
        return width;
    }

    public boolean isCachedLocally()
    {
        return cachedLocally;
    }

    public boolean isRequestForBannerAd()
    {
        return isRequestForBannerAd;
    }

    public void setAdType(int i)
    {
        adType = i;
    }

    public void setCachedLocally(boolean flag)
    {
        cachedLocally = flag;
    }

    public void setCompanion(Companion companion1)
    {
        companion = companion1;
    }

    public void setHeight(int i)
    {
        height = i;
    }

    public void setImageUrl(String s)
    {
        imageUrl = s;
    }

    public void setImp_pixel(String s)
    {
        imp_pixel = s;
    }

    public void setImpression(ArrayList arraylist)
    {
        impression = arraylist;
    }

    public void setLandingUrl(String s)
    {
        landingUrl = s;
    }

    public void setLaunchType(int i)
    {
        launchType = i;
    }

    public void setOriginalImageUrl(String s)
    {
        originalImageUrl = s;
    }

    public void setRequestForBannerAd(boolean flag)
    {
        isRequestForBannerAd = flag;
    }

    public void setResourceType(int i)
    {
        resourceType = i;
    }

    public void setStatus(int i)
    {
        status = i;
    }

    public void setText(String s)
    {
        Text = s;
    }

    public void setWidth(int i)
    {
        width = i;
    }
}
