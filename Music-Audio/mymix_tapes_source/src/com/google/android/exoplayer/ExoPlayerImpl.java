// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.exoplayer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.google.android.exoplayer:
//            ExoPlayer, ExoPlayerImplInternal, ExoPlaybackException, TrackRenderer

final class ExoPlayerImpl
    implements ExoPlayer
{

    private static final String TAG = "ExoPlayerImpl";
    private final Handler eventHandler = new Handler() {

        final ExoPlayerImpl this$0;

        public void handleMessage(Message message)
        {
            handleEvent(message);
        }

            
            {
                this$0 = ExoPlayerImpl.this;
                super();
            }
    };
    private final ExoPlayerImplInternal internalPlayer;
    private final CopyOnWriteArraySet listeners = new CopyOnWriteArraySet();
    private int pendingPlayWhenReadyAcks;
    private boolean playWhenReady;
    private int playbackState;
    private final boolean rendererEnabledFlags[];
    private final boolean rendererHasMediaFlags[];

    public ExoPlayerImpl(int i, int j, int k)
    {
        Log.i("ExoPlayerImpl", "Init 1.4.2");
        playWhenReady = false;
        playbackState = 1;
        rendererHasMediaFlags = new boolean[i];
        rendererEnabledFlags = new boolean[i];
        for (i = 0; i < rendererEnabledFlags.length; i++)
        {
            rendererEnabledFlags[i] = true;
        }

        internalPlayer = new ExoPlayerImplInternal(eventHandler, playWhenReady, rendererEnabledFlags, j, k);
    }

    public void addListener(ExoPlayer.Listener listener)
    {
        listeners.add(listener);
    }

    public void blockingSendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        internalPlayer.blockingSendMessage(exoplayercomponent, i, obj);
    }

    public int getBufferedPercentage()
    {
        long l = 100L;
        long l1 = getBufferedPosition();
        long l2 = getDuration();
        if (l1 == -1L || l2 == -1L)
        {
            return 0;
        }
        if (l2 != 0L)
        {
            l = (100L * l1) / l2;
        }
        return (int)l;
    }

    public long getBufferedPosition()
    {
        return internalPlayer.getBufferedPosition();
    }

    public long getCurrentPosition()
    {
        return internalPlayer.getCurrentPosition();
    }

    public long getDuration()
    {
        return internalPlayer.getDuration();
    }

    public boolean getPlayWhenReady()
    {
        return playWhenReady;
    }

    public Looper getPlaybackLooper()
    {
        return internalPlayer.getPlaybackLooper();
    }

    public int getPlaybackState()
    {
        return playbackState;
    }

    public boolean getRendererEnabled(int i)
    {
        return rendererEnabledFlags[i];
    }

    public boolean getRendererHasMedia(int i)
    {
        return rendererHasMediaFlags[i];
    }

    void handleEvent(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 4: default 36
    //                   1 37
    //                   2 110
    //                   3 160
    //                   4 211;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return;
_L2:
        boolean aflag[] = (boolean[])(boolean[])message.obj;
        System.arraycopy(aflag, 0, rendererHasMediaFlags, 0, aflag.length);
        playbackState = message.arg1;
        message = listeners.iterator();
        while (message.hasNext()) 
        {
            ((ExoPlayer.Listener)message.next()).onPlayerStateChanged(playWhenReady, playbackState);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        playbackState = message.arg1;
        message = listeners.iterator();
        while (message.hasNext()) 
        {
            ((ExoPlayer.Listener)message.next()).onPlayerStateChanged(playWhenReady, playbackState);
        }
        if (true) goto _L1; else goto _L4
_L4:
        pendingPlayWhenReadyAcks = pendingPlayWhenReadyAcks - 1;
        if (pendingPlayWhenReadyAcks == 0)
        {
            message = listeners.iterator();
            while (message.hasNext()) 
            {
                ((ExoPlayer.Listener)message.next()).onPlayWhenReadyCommitted();
            }
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        message = (ExoPlaybackException)message.obj;
        Iterator iterator = listeners.iterator();
        while (iterator.hasNext()) 
        {
            ((ExoPlayer.Listener)iterator.next()).onPlayerError(message);
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public boolean isPlayWhenReadyCommitted()
    {
        return pendingPlayWhenReadyAcks == 0;
    }

    public transient void prepare(TrackRenderer atrackrenderer[])
    {
        Arrays.fill(rendererHasMediaFlags, false);
        internalPlayer.prepare(atrackrenderer);
    }

    public void release()
    {
        internalPlayer.release();
        eventHandler.removeCallbacksAndMessages(null);
    }

    public void removeListener(ExoPlayer.Listener listener)
    {
        listeners.remove(listener);
    }

    public void seekTo(long l)
    {
        internalPlayer.seekTo(l);
    }

    public void sendMessage(ExoPlayer.ExoPlayerComponent exoplayercomponent, int i, Object obj)
    {
        internalPlayer.sendMessage(exoplayercomponent, i, obj);
    }

    public void setPlayWhenReady(boolean flag)
    {
        if (playWhenReady != flag)
        {
            playWhenReady = flag;
            pendingPlayWhenReadyAcks = pendingPlayWhenReadyAcks + 1;
            internalPlayer.setPlayWhenReady(flag);
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((ExoPlayer.Listener)iterator.next()).onPlayerStateChanged(flag, playbackState)) { }
        }
    }

    public void setRendererEnabled(int i, boolean flag)
    {
        if (rendererEnabledFlags[i] != flag)
        {
            rendererEnabledFlags[i] = flag;
            internalPlayer.setRendererEnabled(i, flag);
        }
    }

    public void stop()
    {
        internalPlayer.stop();
    }
}
