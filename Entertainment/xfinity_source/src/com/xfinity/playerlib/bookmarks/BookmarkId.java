// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.bookmarks;

import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.hal.HalNetworkProvider;
import org.apache.commons.lang3.Validate;

public class BookmarkId
{

    private final long companyId;
    private final long networkId;
    private final MerlinId programId;
    private long videoId;

    public BookmarkId(MerlinId merlinid, long l, long l1, long l2)
    {
        Validate.notNull(merlinid);
        programId = merlinid;
        networkId = l;
        companyId = l1;
        videoId = l2;
    }

    public BookmarkId(VideoFacade videofacade)
    {
        this(videofacade.getProgramId(), videofacade.getNetworkInfo().getNetworkId(), videofacade.getNetworkInfo().getCompanyId(), videofacade.getVideoId());
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (BookmarkId)obj;
            if (companyId != ((BookmarkId) (obj)).companyId)
            {
                return false;
            }
            if (videoId != ((BookmarkId) (obj)).videoId)
            {
                return false;
            }
            if (!programId.equals(((BookmarkId) (obj)).programId))
            {
                return false;
            }
        }
        return true;
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public long getNetworkId()
    {
        return networkId;
    }

    public MerlinId getProgramId()
    {
        return programId;
    }

    public long getVideoId()
    {
        return videoId;
    }

    public int hashCode()
    {
        return ((int)(companyId ^ companyId >>> 32) * 31 + programId.hashCode()) * 31 + (int)(videoId ^ videoId >>> 32);
    }

    public String toString()
    {
        return (new StringBuilder()).append("BookmarkId{companyId=").append(companyId).append(", programId=").append(programId).append(", videoId=").append(videoId).append('}').toString();
    }
}
