// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.downloads;

import com.comcast.cim.downloads.DownloadMetaData;
import com.xfinity.playerlib.model.consumable.WatchableKey;
import java.util.Date;
import java.util.UUID;

public class PlayerDownloadMetaData extends DownloadMetaData
{

    private final Date downloadDate;
    private final long expectedFileSizeInBytes;
    private volatile Date lastLicenseRenewal;
    private volatile Date licenseExpiration;
    private final UUID uuid;
    private final long videoId;
    private final WatchableKey watchableKey;

    public PlayerDownloadMetaData(UUID uuid1, WatchableKey watchablekey, long l, Date date, long l1, 
            Date date1, Date date2)
    {
        uuid = uuid1;
        watchableKey = watchablekey;
        videoId = l;
        downloadDate = date;
        expectedFileSizeInBytes = l1;
        lastLicenseRenewal = date1;
        licenseExpiration = date2;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (PlayerDownloadMetaData)obj;
            if (expectedFileSizeInBytes != ((PlayerDownloadMetaData) (obj)).expectedFileSizeInBytes)
            {
                return false;
            }
            if (videoId != ((PlayerDownloadMetaData) (obj)).videoId)
            {
                return false;
            }
            if (downloadDate == null ? ((PlayerDownloadMetaData) (obj)).downloadDate != null : !downloadDate.equals(((PlayerDownloadMetaData) (obj)).downloadDate))
            {
                return false;
            }
            if (watchableKey == null ? ((PlayerDownloadMetaData) (obj)).watchableKey != null : !watchableKey.equals(((PlayerDownloadMetaData) (obj)).watchableKey))
            {
                return false;
            }
            if (lastLicenseRenewal == null ? ((PlayerDownloadMetaData) (obj)).lastLicenseRenewal != null : !lastLicenseRenewal.equals(((PlayerDownloadMetaData) (obj)).lastLicenseRenewal))
            {
                return false;
            }
            if (licenseExpiration == null ? ((PlayerDownloadMetaData) (obj)).licenseExpiration != null : !licenseExpiration.equals(((PlayerDownloadMetaData) (obj)).licenseExpiration))
            {
                return false;
            }
        }
        return true;
    }

    public Date getDownloadDate()
    {
        return downloadDate;
    }

    public long getExpectedFileSizeInBytes()
    {
        return expectedFileSizeInBytes;
    }

    public Date getLastLicenseRenewal()
    {
        return lastLicenseRenewal;
    }

    public Date getLicenseExpiration()
    {
        return licenseExpiration;
    }

    public UUID getUuid()
    {
        return uuid;
    }

    public long getVideoId()
    {
        return videoId;
    }

    public WatchableKey getWatchableKey()
    {
        return watchableKey;
    }

    public int hashCode()
    {
        int i1 = 0;
        int i;
        int j;
        int k;
        int l;
        int j1;
        int k1;
        if (uuid != null)
        {
            i = uuid.hashCode();
        } else
        {
            i = 0;
        }
        if (watchableKey != null)
        {
            j = watchableKey.hashCode();
        } else
        {
            j = 0;
        }
        j1 = (int)(videoId ^ videoId >>> 32);
        if (downloadDate != null)
        {
            k = downloadDate.hashCode();
        } else
        {
            k = 0;
        }
        k1 = (int)(expectedFileSizeInBytes ^ expectedFileSizeInBytes >>> 32);
        if (lastLicenseRenewal != null)
        {
            l = lastLicenseRenewal.hashCode();
        } else
        {
            l = 0;
        }
        if (licenseExpiration != null)
        {
            i1 = licenseExpiration.hashCode();
        }
        return (((((i * 31 + j) * 31 + j1) * 31 + k) * 31 + k1) * 31 + l) * 31 + i1;
    }

    public void setLastLicenseRenewal(Date date)
    {
        lastLicenseRenewal = date;
    }

    public void setLicenseExpiration(Date date)
    {
        licenseExpiration = date;
    }
}
