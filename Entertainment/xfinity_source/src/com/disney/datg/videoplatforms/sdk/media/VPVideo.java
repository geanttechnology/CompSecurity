// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public class VPVideo extends VPMedia
{

    private static VPMedia.MediaType MEDIA_TYPE;
    private String airDate;
    private String availableDate;
    private String cGenre;
    private String cShowName;
    private String cVideo;
    private String dayPart;
    private long duration;
    private String episodeNumber;
    private String expireDate;
    private String seasonNumber;
    private String storageId;

    public VPVideo()
    {
    }

    public String getAirDate()
    {
        return airDate;
    }

    public String getAvailableDate()
    {
        return availableDate;
    }

    public String getCGenre()
    {
        return cGenre;
    }

    public String getCShowName()
    {
        return cShowName;
    }

    public String getCVideo()
    {
        return cVideo;
    }

    public String getContentUrl()
    {
        if (contentUrl.substring(Math.max(0, contentUrl.length() - 4), contentUrl.length()).contains("json"))
        {
            contentUrl = contentUrl.replace("json", "m3u8");
        }
        return contentUrl;
    }

    public String getDayPart()
    {
        return dayPart;
    }

    public long getDuration()
    {
        return duration;
    }

    public String getEpisodeNumber()
    {
        return episodeNumber;
    }

    public String getExpireDate()
    {
        return expireDate;
    }

    public VPMedia.MediaType getMediaType()
    {
        return MEDIA_TYPE;
    }

    public String getSeasonNumber()
    {
        return seasonNumber;
    }

    public void setAirDate(String s)
    {
        airDate = s;
    }

    public void setAvailableDate(String s)
    {
        availableDate = s;
    }

    public void setCGenre(String s)
    {
        cGenre = s;
    }

    public void setCShowName(String s)
    {
        cShowName = s;
    }

    public void setCVideo(String s)
    {
        cVideo = s;
    }

    public void setDayPart(String s)
    {
        dayPart = s;
    }

    public void setDuration(long l)
    {
        duration = l;
    }

    public void setEpisodeNumber(String s)
    {
        episodeNumber = s;
    }

    public void setExpireDate(String s)
    {
        expireDate = s;
    }

    public void setSeasonNumber(String s)
    {
        seasonNumber = s;
    }

    public void setStorageId(String s)
    {
        storageId = s;
    }

    static 
    {
        MEDIA_TYPE = VPMedia.MediaType.VOD;
    }
}
