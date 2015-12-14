// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediastore;

import android.media.MediaMetadataRetriever;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class GalleryMetadataRetriever
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/mediastore/GalleryMetadataRetriever.getName();
    private final MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

    public GalleryMetadataRetriever(String s)
    {
        mediaMetadataRetriever.setDataSource(s);
    }

    public String extractMetadata(int i)
    {
        return mediaMetadataRetriever.extractMetadata(i);
    }

    public void release()
    {
        try
        {
            mediaMetadataRetriever.release();
            return;
        }
        catch (Exception exception)
        {
            GLogger.ex(TAG, "Release MediaMetadataRetriever failed", exception);
        }
    }

}
