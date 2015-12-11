// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.media;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.rdio.android.core.util.Logging;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleUriAudioPlayer
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnPreparedListener
{
    public static interface Listener
    {

        public abstract void onError();

        public abstract void onPlaybackComplete();

        public abstract void onPlayingChanged(boolean flag);

        public abstract void onPositionChanged();
    }

    private class PositionTimer
    {

        final SimpleUriAudioPlayer this$0;
        private Timer timer;
        private TimerTask timerTask;

        public void pause()
        {
            if (timer != null)
            {
                timer.cancel();
            }
        }

        public void resume()
        {
            timer = new Timer();
            if (timerTask != null)
            {
                timerTask.cancel();
            }
            timerTask = new TimerTask() {

                final PositionTimer this$1;

                public void run()
                {
                    onPositionUpdate();
                }

            
            {
                this$1 = PositionTimer.this;
                super();
            }
            };
            timer.scheduleAtFixedRate(timerTask, 0L, 1000L);
        }

        private PositionTimer()
        {
            this$0 = SimpleUriAudioPlayer.this;
            super();
        }

    }


    private static final String TAG = "SimpleUriAudioPlayer";
    private final Context context;
    private boolean isMediaPlayerPreparing;
    private Listener listener;
    private final Logging logging;
    private MediaPlayer mediaPlayer;
    private final PositionTimer positionTimer = new PositionTimer();

    public SimpleUriAudioPlayer(Context context1, Logging logging1)
    {
        logging = logging1;
        context = context1;
    }

    private void destroyMediaPlayer()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
        }
        mediaPlayer = null;
        positionTimer.pause();
    }

    private void onPlayingChanged()
    {
        if (listener != null)
        {
            listener.onPlayingChanged(isPlaying());
        }
    }

    private void onPositionUpdate()
    {
        if (listener != null)
        {
            listener.onPositionChanged();
        }
    }

    public int getDuration()
    {
        if (isMediaPlayerPreparing)
        {
            logging.log(5, "SimpleUriAudioPlayer", "getDuration() called while preparing");
        } else
        if (mediaPlayer != null)
        {
            return mediaPlayer.getDuration();
        }
        return 0;
    }

    public int getPosition()
    {
        if (isMediaPlayerPreparing)
        {
            logging.log(5, "SimpleUriAudioPlayer", "getPosition() called while preparing");
        } else
        if (mediaPlayer != null)
        {
            return mediaPlayer.getCurrentPosition();
        }
        return 0;
    }

    public boolean isPlaying()
    {
        if (isMediaPlayerPreparing)
        {
            return true;
        }
        if (mediaPlayer != null)
        {
            return mediaPlayer.isPlaying();
        } else
        {
            return false;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (listener != null)
        {
            listener.onPlaybackComplete();
        }
        positionTimer.pause();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        logging.log(6, "SimpleUriAudioPlayer", (new StringBuilder("onError(what = ")).append(i).append(", extra = ").append(j).append(")").toString());
        destroyMediaPlayer();
        onPlayingChanged();
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        isMediaPlayerPreparing = false;
        play();
    }

    public void pause()
    {
        if (isMediaPlayerPreparing)
        {
            logging.log(5, "SimpleUriAudioPlayer", "pause() called while preparing");
        } else
        if (mediaPlayer != null)
        {
            positionTimer.pause();
            mediaPlayer.pause();
            onPlayingChanged();
            return;
        }
    }

    public void play()
    {
        if (isMediaPlayerPreparing)
        {
            logging.log(5, "SimpleUriAudioPlayer", "play() called while preparing");
        } else
        if (mediaPlayer != null)
        {
            positionTimer.resume();
            mediaPlayer.start();
            onPlayingChanged();
            return;
        }
    }

    public boolean playUri(String s)
    {
        if (isMediaPlayerPreparing)
        {
            logging.log(5, "SimpleUriAudioPlayer", (new StringBuilder("MediaPlayer is preparing, cannot play: ")).append(s).toString());
            return false;
        }
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnErrorListener(this);
        isMediaPlayerPreparing = true;
        try
        {
            mediaPlayer.setDataSource(context, Uri.parse(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logging.log(6, "SimpleUriAudioPlayer", "Failed to set data source!");
            logging.logException(s, true);
            return false;
        }
        mediaPlayer.prepareAsync();
        return true;
    }

    public void setListener(Listener listener1)
    {
        listener = listener1;
    }

}
