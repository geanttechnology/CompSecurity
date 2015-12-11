// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.image;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import com.github.ignition.support.cache.AbstractImageCache;
import com.github.ignition.support.images.remote.RemoteImageLoader;
import com.xfinity.playerlib.model.MerlinId;
import com.xfinity.playerlib.model.Program;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.image:
//            ProgramArtImageLoader

public class CoverArtImageLoader extends ProgramArtImageLoader
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/image/CoverArtImageLoader);
    private int cover_art_height;
    private int cover_art_width;

    public CoverArtImageLoader(String s, RemoteImageLoader remoteimageloader, AbstractImageCache abstractimagecache, Context context)
    {
        super(s, remoteimageloader, abstractimagecache);
        cover_art_width = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.cover_art_src_width);
        cover_art_height = context.getResources().getDimensionPixelSize(com.xfinity.playerlib.R.dimen.cover_art_src_height);
    }

    private String getImageUrl(MerlinId merlinid)
    {
        return getImageUrl(cover_art_width, cover_art_height, merlinid);
    }

    public String getImageUrl(Program program)
    {
        if (program == null)
        {
            LOG.warn("unexpected null program");
            return null;
        } else
        {
            return getImageUrl(cover_art_width, cover_art_height, program);
        }
    }

    public void loadImage(MerlinId merlinid, ImageView imageview, com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener)
    {
        loadImage(getImageUrl(merlinid), imageview, onloadlistener);
    }

    public void loadImage(Program program, ImageView imageview, com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener)
    {
        loadImage(getImageUrl(program), imageview, onloadlistener);
    }

    public boolean loadImageFromMemory(MerlinId merlinid, ImageView imageview, com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener)
    {
        return super.loadImageFromMemory(getImageUrl(merlinid), null, imageview, onloadlistener);
    }

    public boolean loadImageFromMemory(Program program, ImageView imageview)
    {
        return loadImageFromMemory(getImageUrl(program), null, imageview);
    }

    public boolean loadImageFromMemory(Program program, ImageView imageview, com.comcast.cim.android.image.CimImageLoader.OnLoadListener onloadlistener)
    {
        return loadImageFromMemory(getImageUrl(program), null, imageview, onloadlistener);
    }

}
