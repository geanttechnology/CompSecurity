// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;
import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.github.ignition.support.cache.AbstractImageCache;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.tags.FeaturedShow;

// Referenced classes of package com.xfinity.playerlib.image:
//            ProgramArtImageLoader

public class ProgramDetailArtImageLoader extends ProgramArtImageLoader
{

    private AndroidDevice deviceInfo;
    private int movie_detail_art_height;
    private int movie_detail_art_width;
    private int series_detail_art_height;
    private int series_detail_art_width;

    public ProgramDetailArtImageLoader(String s, RemoteImageLoader remoteimageloader, AbstractImageCache abstractimagecache, Context context, AndroidDevice androiddevice)
    {
        super(s, remoteimageloader, abstractimagecache);
        series_detail_art_width = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.series_detail_art_src_width);
        series_detail_art_height = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.series_detail_art_src_height);
        movie_detail_art_width = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.movie_detail_art_src_width);
        movie_detail_art_height = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.movie_detail_art_src_height);
        s = new ColorDrawable(context.getResources().getColor(com.xfinity.playerlib.R.color.MissingImage));
        remoteimageloader.setDownloadFailedDrawable(s);
        remoteimageloader.setDownloadInProgressDrawable(s);
        deviceInfo = androiddevice;
    }

    private String getImageUrl(MerlinId merlinid)
    {
        if (merlinid.getNamespace().equals(com.xfinity.playerlib.model.MerlinId.Namespace.Movie))
        {
            return getImageUrl(movie_detail_art_width, movie_detail_art_height, merlinid);
        } else
        {
            return getSeriesImageUrl(series_detail_art_width, series_detail_art_height, merlinid);
        }
    }

    public Bitmap getBitmapFromCache(MerlinId merlinid)
    {
        return getBitmapFromMemory(getImageUrl(merlinid));
    }

    public void loadDetailProgramArt(MerlinId merlinid, ImageView imageview)
    {
        loadImage(getImageUrl(merlinid), imageview);
    }

    public void loadDetailProgramArt(MerlinId merlinid, ImageView imageview, int i, int j)
    {
        loadImage(getImageUrl(i, j, merlinid), imageview);
    }

    public void loadNetworkFeatureDetailProgramArt(FeaturedShow featuredshow, ImageView imageview, com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener)
    {
        if (deviceInfo.getDensity() > 1.0F)
        {
            featuredshow = featuredshow.getImageUrl2x();
        } else
        {
            featuredshow = featuredshow.getImageUrl();
        }
        loadImage(featuredshow, imageview, onloadlistener);
    }

    public void preCacheDrawable(MerlinId merlinid)
    {
        if (getBitmapFromCache(merlinid) == null)
        {
            preloadImage(getImageUrl(merlinid));
        }
    }
}
