// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import java.util.LinkedHashMap;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Referenced classes of package com.xfinity.playerlib.model:
//            Program, MerlinId

public abstract class EditorialProgram
    implements Program
{

    String brand;
    private String episodeNumber;
    private String episodeTitle;
    String imageKey;
    MerlinId merlinId;
    private String providerCode;
    private String seasonNumber;
    String title;

    public EditorialProgram()
    {
    }

    public String getBrand()
    {
        return brand;
    }

    public String getEpisodeNumber()
    {
        return episodeNumber;
    }

    public String getEpisodeTitle()
    {
        return episodeTitle;
    }

    public String getImageKey()
    {
        return imageKey;
    }

    public MerlinId getMerlinId()
    {
        return merlinId;
    }

    public MerlinId getParentMerlinIdIfApplicable()
    {
        return getMerlinId();
    }

    public String getProviderCode()
    {
        return providerCode;
    }

    public String getSeasonNumber()
    {
        return seasonNumber;
    }

    public String getTitle()
    {
        return title;
    }

    public abstract void parse(LinkedHashMap linkedhashmap);

    public void setBrand(String s)
    {
        brand = s;
    }

    public void setEpisodeNumber(String s)
    {
        episodeNumber = s;
    }

    public void setEpisodeTitle(String s)
    {
        episodeTitle = s;
    }

    public void setImageKey(String s)
    {
        imageKey = s;
    }

    public void setMerlinId(MerlinId merlinid)
    {
        merlinId = merlinid;
    }

    public void setProviderCode(String s)
    {
        providerCode = s;
    }

    public void setSeasonNumber(String s)
    {
        seasonNumber = s;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("imageKey", imageKey).append("title", title).append("merlinId", merlinId).append("brand", brand).append("seasonNumber", seasonNumber).append("episodeNumber", episodeNumber).append("episodeTitle", episodeTitle).toString();
    }
}
