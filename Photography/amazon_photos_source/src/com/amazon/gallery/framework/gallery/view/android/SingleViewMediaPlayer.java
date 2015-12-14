// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view.android;

import android.content.res.Configuration;
import com.amazon.gallery.framework.model.media.MediaItem;

public interface SingleViewMediaPlayer
{
    public static interface PlayerObserver
    {

        public abstract void onMediaReady(MediaItem mediaitem);

        public abstract void onVideoCompletion();

        public abstract void onVideoError();
    }


    public abstract void destroy();

    public abstract int getDisplayDelayMS();

    public abstract MediaItem getMediaItem();

    public abstract void onConfigChanged(Configuration configuration);

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setMediaItem(MediaItem mediaitem);

    public abstract void setPlayerObserver(PlayerObserver playerobserver);

    public abstract void shutDown();
}
