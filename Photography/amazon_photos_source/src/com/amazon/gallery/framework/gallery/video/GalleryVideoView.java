// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.VideoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GalleryVideoView extends VideoView
{
    public static interface PlaybackListener
    {

        public abstract void pause();

        public abstract void resume();

        public abstract void start();

        public abstract void stopPlayback();

        public abstract void suspend();
    }


    private final List listeners;

    public GalleryVideoView(Context context)
    {
        super(context);
        listeners = new ArrayList();
    }

    public GalleryVideoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        listeners = new ArrayList();
    }

    public GalleryVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        listeners = new ArrayList();
    }

    public void addPlaybackListener(PlaybackListener playbacklistener)
    {
        listeners.add(playbacklistener);
    }

    public void clearPlaybackListeners()
    {
        listeners.clear();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        return false;
    }

    public void pause()
    {
        super.pause();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PlaybackListener)iterator.next()).pause()) { }
    }

    public void resume()
    {
        super.resume();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PlaybackListener)iterator.next()).resume()) { }
    }

    public void start()
    {
        super.start();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PlaybackListener)iterator.next()).start()) { }
    }

    public void stopPlayback()
    {
        super.stopPlayback();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PlaybackListener)iterator.next()).stopPlayback()) { }
    }

    public void suspend()
    {
        super.suspend();
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PlaybackListener)iterator.next()).suspend()) { }
    }
}
