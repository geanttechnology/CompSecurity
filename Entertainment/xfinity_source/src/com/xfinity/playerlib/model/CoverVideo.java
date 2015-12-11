// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.utils.exceptions.CimException;
import java.util.LinkedHashMap;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.xfinity.playerlib.model:
//            EditorialProgram, MerlinId

public class CoverVideo extends EditorialProgram
{

    private int duration;
    private String entityType;
    private MerlinId episodeId;
    private String releaseUrl;
    private String secureMetadata;
    private long videoId;

    public CoverVideo()
    {
    }

    public String getDescription()
    {
        return null;
    }

    public int getDuration()
    {
        return duration;
    }

    public String getEntityType()
    {
        return entityType;
    }

    public MerlinId getEpisodeMerlinId()
    {
        return episodeId;
    }

    public MerlinId.Namespace getMerlinIdNamespace()
    {
        return MerlinId.Namespace.valueOf(entityType);
    }

    public String getReleaseURL()
    {
        return releaseUrl;
    }

    public String getSecureMetadata()
    {
        return secureMetadata;
    }

    public long getVideoId()
    {
        return videoId;
    }

    public boolean isMovie()
    {
        return merlinId.getNamespace() == MerlinId.Namespace.Movie;
    }

    public void parse(LinkedHashMap linkedhashmap)
    {
        setImageKey((String)linkedhashmap.get("imgIpad"));
        if (imageKey == null || imageKey.length() == 0)
        {
            throw new CimException("the image URL has to be present");
        }
        setEpisodeTitle((String)linkedhashmap.get("episodeName"));
        setTitle((String)linkedhashmap.get("name"));
        setSeasonNumber((String)linkedhashmap.get("episodeSeasonNumber"));
        setEpisodeNumber((String)linkedhashmap.get("episodeNumber"));
        setSecureMetadata((String)linkedhashmap.get("secData"));
        setReleaseUrl((String)linkedhashmap.get("videoReleaseUrl"));
        setProviderCode((String)linkedhashmap.get("videoProviderCode"));
        setEntityType((String)linkedhashmap.get("entityType"));
        String s = (String)linkedhashmap.get("entityMerlinId");
        String s1 = (String)linkedhashmap.get("episodeMerlinId");
        String s2 = (String)linkedhashmap.get("videoBrand");
        duration = Integer.parseInt((String)linkedhashmap.get("videoDuration"));
        setVideoId((String)linkedhashmap.get("videoGlobalUid"));
        setMerlinId(new MerlinId(MerlinId.Namespace.valueOf(getEntityType()), Long.valueOf(s)));
        if (s1 != null)
        {
            setEpisodeMerlinId(new MerlinId(MerlinId.Namespace.TvEpisode, Long.valueOf(s1)));
        }
        setBrand(s2);
    }

    public void setDuration(int i)
    {
        duration = i;
    }

    public void setEntityType(String s)
    {
        entityType = s;
    }

    public void setEpisodeMerlinId(MerlinId merlinid)
    {
        episodeId = merlinid;
    }

    public void setReleaseUrl(String s)
    {
        releaseUrl = s;
    }

    public void setSecureMetadata(String s)
    {
        secureMetadata = s;
    }

    public void setVideoId(String s)
    {
        s = StringUtils.split(s, "-");
        if (s.length != 2)
        {
            throw new IllegalArgumentException("ID should be in the form namespace-intID (f.e. TvSeries-12345)");
        } else
        {
            videoId = Long.parseLong(s[1]);
            return;
        }
    }
}
