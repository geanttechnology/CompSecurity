// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import com.comcast.cim.downloads.DownloadFile;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

// Referenced classes of package com.xfinity.playerlib.model.downloads:
//            PlayerDownloadMetaData

public class PlayerDownloadFile extends DownloadFile
{
    public static final class ExpirationStatus extends Enum
    {

        private static final ExpirationStatus $VALUES[];
        public static final ExpirationStatus AAW_EXPIRED;
        public static final ExpirationStatus NOT_EXPIRED;
        public static final ExpirationStatus OVP_EXPIRED;

        public static ExpirationStatus valueOf(String s)
        {
            return (ExpirationStatus)Enum.valueOf(com/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus, s);
        }

        public static ExpirationStatus[] values()
        {
            return (ExpirationStatus[])$VALUES.clone();
        }

        static 
        {
            NOT_EXPIRED = new ExpirationStatus("NOT_EXPIRED", 0);
            OVP_EXPIRED = new ExpirationStatus("OVP_EXPIRED", 1);
            AAW_EXPIRED = new ExpirationStatus("AAW_EXPIRED", 2);
            $VALUES = (new ExpirationStatus[] {
                NOT_EXPIRED, OVP_EXPIRED, AAW_EXPIRED
            });
        }

        private ExpirationStatus(String s, int i)
        {
            super(s, i);
        }
    }


    private volatile Watchable watchable;

    public PlayerDownloadFile(IVirtuosoAsset ivirtuosoasset, PlayerDownloadMetaData playerdownloadmetadata, Watchable watchable1)
    {
        super(ivirtuosoasset, playerdownloadmetadata);
        Validate.notNull(watchable1);
        watchable = watchable1;
    }

    public boolean downloadVideoExistsInWatchable(Watchable watchable1)
    {
        for (watchable1 = watchable1.getVideos().iterator(); watchable1.hasNext();)
        {
            VideoFacade videofacade = (VideoFacade)watchable1.next();
            if (videofacade.getVideoId() == getVideoId() && videofacade.isDownloadable())
            {
                return true;
            }
        }

        return false;
    }

    public Date getAssetExpirationDate()
    {
        return watchable.getExpiresDate();
    }

    public Date getDownloadDate()
    {
        return ((PlayerDownloadMetaData)metaData).getDownloadDate();
    }

    public int getExpectedFileSizeInMb()
    {
        return (int)(((PlayerDownloadMetaData)metaData).getExpectedFileSizeInBytes() / 0x100000L);
    }

    public ExpirationStatus getExpirationStatus()
    {
        Date date = new Date();
        if (getAssetExpirationDate() != null && date.compareTo(getAssetExpirationDate()) >= 0)
        {
            return ExpirationStatus.AAW_EXPIRED;
        }
        if (date.compareTo(getLicenseExpirationDate()) >= 0)
        {
            return ExpirationStatus.OVP_EXPIRED;
        } else
        {
            return ExpirationStatus.NOT_EXPIRED;
        }
    }

    public Date getLastLicenseRenewalDate()
    {
        return ((PlayerDownloadMetaData)metaData).getLastLicenseRenewal();
    }

    public Date getLicenseExpirationDate()
    {
        return ((PlayerDownloadMetaData)metaData).getLicenseExpiration();
    }

    public String getPlaylistUri()
    {
        return (new StringBuilder()).append(getFileDirectory()).append("variant.m3u8").toString();
    }

    public UUID getUuid()
    {
        return ((PlayerDownloadMetaData)metaData).getUuid();
    }

    public VideoFacade getVideo()
    {
        return watchable.findVideoById(((PlayerDownloadMetaData)metaData).getVideoId());
    }

    public long getVideoId()
    {
        return ((PlayerDownloadMetaData)metaData).getVideoId();
    }

    public Watchable getWatchable()
    {
        return watchable;
    }

    public WatchableKey getWatchableKey()
    {
        return ((PlayerDownloadMetaData)metaData).getWatchableKey();
    }

    public void setLastLicenseRenewalDate(Date date)
    {
        ((PlayerDownloadMetaData)metaData).setLastLicenseRenewal(date);
    }

    public void setLicenseExpirationDate(Date date)
    {
        ((PlayerDownloadMetaData)metaData).setLicenseExpiration(date);
    }

    public void setWatchable(Watchable watchable1)
    {
        watchable = watchable1;
    }

    public String toString()
    {
        return (new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)).append("title", watchable.getTitle()).append("merlinId", watchable.getMerlinId()).append("uuid", asset.uuid()).toString();
    }
}
