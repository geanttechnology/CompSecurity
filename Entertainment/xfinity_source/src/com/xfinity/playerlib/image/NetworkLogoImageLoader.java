// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.image;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LongSparseArray;
import android.widget.ImageView;
import com.comcast.cim.android.image.CimImageLoader;
import com.github.ignition.support.cache.AbstractImageCache;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.xfinity.playerlib.model.tags.Network;
import java.util.Locale;

public class NetworkLogoImageLoader extends CimImageLoader
{

    private final String entityThumbnailUrl;
    private LongSparseArray largeLogos;
    private int logo_large_height;
    private int logo_large_width;
    private int logo_small_height;
    private int logo_small_width;
    final Resources res;
    private LongSparseArray smallLogos;

    public NetworkLogoImageLoader(String s, RemoteImageLoader remoteimageloader, AbstractImageCache abstractimagecache, Context context)
    {
        super(remoteimageloader, abstractimagecache);
        entityThumbnailUrl = s;
        res = context.getResources();
        smallLogos = new LongSparseArray();
        smallLogos.put(0x5191db2eb5f4aeb9L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallcinemax));
        smallLogos.put(0x4acd937245c76579L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallencore));
        smallLogos.put(0x489f141b597c9d11L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallhbo));
        smallLogos.put(0x4daa5dcfd0e4a3d1L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallmovieplex));
        smallLogos.put(0x5b4aca02ef0587b1L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallshowtime));
        smallLogos.put(0x767875080c061f21L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallstarzoncomcast));
        smallLogos.put(0x62fb954a0c4dc881L, Integer.valueOf(com.xfinity.playerlib.R.drawable.smallstreampix));
        largeLogos = new LongSparseArray();
        largeLogos.put(0x5191db2eb5f4aeb9L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_cinemax));
        largeLogos.put(0x4acd937245c76579L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_encore));
        largeLogos.put(0x489f141b597c9d11L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_hbo));
        largeLogos.put(0x4daa5dcfd0e4a3d1L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_movieplex));
        largeLogos.put(0x5b4aca02ef0587b1L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_showtime));
        largeLogos.put(0x767875080c061f21L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_starz));
        largeLogos.put(0x62fb954a0c4dc881L, Integer.valueOf(com.xfinity.playerlib.R.drawable.prem_streampix));
        logo_small_width = res.getDimensionPixelSize(com.xfinity.playerlib.R.dimen.network_logo_small_src_width);
        logo_small_height = res.getDimensionPixelSize(com.xfinity.playerlib.R.dimen.network_logo_small_src_height);
        logo_large_width = res.getDimensionPixelSize(com.xfinity.playerlib.R.dimen.network_logo_large_src_width);
        logo_large_height = res.getDimensionPixelSize(com.xfinity.playerlib.R.dimen.network_logo_large_src_height);
    }

    private String getLogoUrl(long l, int i, int j)
    {
        return String.format(Locale.US, "%s/Network-%d/%d/%d", new Object[] {
            entityThumbnailUrl, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j)
        });
    }

    public void loadNetworkLogoLarge(long l, ImageView imageview, Drawable drawable, Drawable drawable1)
    {
        if (largeLogos.indexOfKey(l) >= 0)
        {
            imageview.setImageDrawable(res.getDrawable(((Integer)largeLogos.get(l)).intValue()));
            return;
        } else
        {
            loadImage(getLogoUrl(l, logo_large_width, logo_large_height), imageview, drawable, drawable1);
            return;
        }
    }

    public void loadNetworkLogoLarge(Network network, ImageView imageview, com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener)
    {
        long l = network.getCompanyId();
        if (largeLogos.indexOfKey(l) >= 0)
        {
            imageview.setImageDrawable(res.getDrawable(((Integer)largeLogos.get(l)).intValue()));
            onloadlistener.onLoad(imageview, null, null);
            return;
        } else
        {
            loadImage(getLogoUrl(l, logo_large_width, logo_large_height), imageview, onloadlistener);
            return;
        }
    }

    public void loadNetworkLogoSmall(long l, ImageView imageview)
    {
        if (smallLogos.indexOfKey(l) >= 0)
        {
            imageview.setImageDrawable(res.getDrawable(((Integer)smallLogos.get(l)).intValue()));
            return;
        } else
        {
            loadImage(getLogoUrl(l, logo_small_width, logo_small_height), imageview);
            return;
        }
    }

    public void loadNetworkLogoSmall(long l, ImageView imageview, Drawable drawable, Drawable drawable1, boolean flag)
    {
        if (flag && smallLogos.indexOfKey(l) >= 0)
        {
            imageview.setImageDrawable(res.getDrawable(((Integer)smallLogos.get(l)).intValue()));
            return;
        } else
        {
            loadImage(getLogoUrl(l, logo_small_width, logo_small_height), imageview, drawable, drawable1);
            return;
        }
    }
}
