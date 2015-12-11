// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.image;

import com.comcast.cim.android.image.CimImageLoader;
import com.github.ignition.support.cache.AbstractImageCache;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.Program;
import java.util.Locale;

public class ProgramArtImageLoader extends CimImageLoader
{

    private final String entityThumbnailUrl;

    public ProgramArtImageLoader(String s, RemoteImageLoader remoteimageloader, AbstractImageCache abstractimagecache)
    {
        super(remoteimageloader, abstractimagecache);
        entityThumbnailUrl = s;
    }

    public String getImageUrl(int i, int j, MerlinId merlinid)
    {
        return String.format(Locale.US, "%s/%d/%d/%d?noRedir=true", new Object[] {
            entityThumbnailUrl, merlinid.getSimpleId(), Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public String getImageUrl(int i, int j, Program program)
    {
        return getImageUrl(i, j, program.getParentMerlinIdIfApplicable());
    }

    public String getSeriesImageUrl(int i, int j, MerlinId merlinid)
    {
        if (merlinid.getSimpleId().longValue() >= 0x2386f26fc10000L)
        {
            return getImageUrl(i, j, merlinid);
        } else
        {
            return String.format(Locale.US, "%s/%s/%d/%d?noRedir=true", new Object[] {
                entityThumbnailUrl, merlinid.getNamespacedId(), Integer.valueOf(i), Integer.valueOf(j)
            });
        }
    }
}
