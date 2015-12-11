// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Player
    implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener
{

    Context ctx;
    Handler handler;
    private Timer mTimer;
    public MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    TimerTask timerTask;

    public Player(Context context, SeekBar seekbar)
    {
        mTimer = new Timer();
        timerTask = new TimerTask() {

            final Player this$0;

            public void run()
            {
                while (mediaPlayer == null || !mediaPlayer.isPlaying() || seekBar.isPressed()) 
                {
                    return;
                }
                handler.sendEmptyMessage(0);
            }

            
            {
                this$0 = Player.this;
                super();
            }
        };
        handler = new Handler() {

            final Player this$0;

            public void handleMessage(Message message)
            {
                int i = mediaPlayer.getCurrentPosition();
                int j = mediaPlayer.getDuration();
                if (j > 0)
                {
                    long l = (seekBar.getMax() * i) / j;
                    seekBar.setProgress((int)l);
                }
            }

            
            {
                this$0 = Player.this;
                super();
            }
        };
        seekBar = seekbar;
        ctx = context;
        try
        {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setOnPreparedListener(this);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        mTimer.schedule(timerTask, 0L, 1000L);
    }

    public static String formatTime(long l)
    {
        String s;
        String s2;
        s = (new StringBuilder(String.valueOf(l / 60000L))).toString();
        s2 = (new StringBuilder(String.valueOf(l % 60000L))).toString();
        String s1;
        if (s.length() < 2)
        {
            s1 = (new StringBuilder("0")).append(l / 60000L).toString();
        } else
        {
            s1 = (new StringBuilder(String.valueOf(l / 60000L))).toString();
        }
        if (s2.length() != 4) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder("0")).append(l % 60000L).toString();
_L4:
        return (new StringBuilder(String.valueOf(s1))).append(":").append(s.trim().substring(0, 2)).toString();
_L2:
        if (s2.length() == 3)
        {
            s = (new StringBuilder("00")).append(l % 60000L).toString();
        } else
        if (s2.length() == 2)
        {
            s = (new StringBuilder("000")).append(l % 60000L).toString();
        } else
        {
            s = s2;
            if (s2.length() == 1)
            {
                s = (new StringBuilder("0000")).append(l % 60000L).toString();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        seekBar.setSecondaryProgress(i);
        Log.e((new StringBuilder(String.valueOf((seekBar.getMax() * mediaPlayer.getCurrentPosition()) / mediaPlayer.getDuration()))).append("% play").toString(), (new StringBuilder(String.valueOf(i))).append(" buffer").toString());
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        Log.e("mediaPlayer", "onCompletion");
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        Intent intent = new Intent();
        intent.setAction("show");
        ctx.sendBroadcast(intent);
        mediaplayer.start();
        Log.e("mediaPlayer", "onPrepared");
    }

    public void pause()
    {
        mediaPlayer.pause();
    }

    public void play()
    {
        mediaPlayer.start();
    }

    public void playUrl(String s)
    {
        try
        {
            if (mediaPlayer.getCurrentPosition() != 0)
            {
                mediaPlayer.reset();
            }
            mediaPlayer.setDataSource(s);
            mediaPlayer.prepare();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
    }

    public void stop()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
