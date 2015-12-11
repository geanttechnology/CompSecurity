// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mixerbox.mixerbox3b.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import com.mixerbox.mixerbox3b.utils.MixerBoxUtils;

public class MyService extends Service
    implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, Runnable
{

    public static boolean isPending = false;
    public static MediaPlayer mediaPlayer = null;
    int time;

    public MyService()
    {
        time = 0;
    }

    private void play()
    {
        mediaPlayer.setAudioStreamType(3);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnPreparedListener(this);
        mediaPlayer.setOnInfoListener(this);
        mediaPlayer.setOnErrorListener(this);
        mediaPlayer.setOnBufferingUpdateListener(this);
        mediaPlayer.prepareAsync();
        isPending = false;
    }

    private void stop()
    {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        stopForeground(true);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        MixerBoxUtils.logMsg((new StringBuilder()).append("MediaPlayer Buffering: ").append(i).append("%").toString());
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        try
        {
            if (!isPending)
            {
                isPending = true;
                mediaplayer = new Intent("MyService");
                mediaplayer.putExtra("t", 0);
                sendBroadcast(mediaplayer);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            return;
        }
    }

    public void onDestroy()
    {
        stop();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (i != 100) goto _L2; else goto _L1
_L1:
        (new StringBuilder()).append("Media Error, Server Died ").append(j).toString();
_L4:
        return false;
_L2:
        if (i == 1)
        {
            (new StringBuilder()).append("Media Error, Error Unknown ").append(j).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        if (i != 800) goto _L2; else goto _L1
_L1:
        (new StringBuilder()).append("Media Info, Media Info Bad Interleaving ").append(j).toString();
_L4:
        return false;
_L2:
        if (i == 801)
        {
            (new StringBuilder()).append("Media Info, Media Info Not Seekable ").append(j).toString();
        } else
        if (i == 1)
        {
            (new StringBuilder()).append("Media Info, Media Info Unknown ").append(j).toString();
        } else
        if (i == 700)
        {
            (new StringBuilder()).append("MediaInfo, Media Info Video Track Lagging ").append(j).toString();
        } else
        if (i == 802)
        {
            (new StringBuilder()).append("MediaInfo, Media Info Metadata Update ").append(j).toString();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        isPending = false;
        mediaplayer.start();
        if (time != 0)
        {
            mediaplayer.seekTo(time * 1000);
        }
        (new Thread(this)).start();
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        if (intent.getExtras() == null || !intent.getExtras().containsKey("time")) goto _L2; else goto _L1
_L1:
        time = intent.getExtras().getInt("time");
_L4:
        play();
        break MISSING_BLOCK_LABEL_48;
_L2:
        time = 0;
        if (true) goto _L4; else goto _L3
_L3:
        intent;
        return 2;
    }

    public void run()
    {
        int i = 0;
_L2:
        int k;
        if (mediaPlayer == null)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        Thread.sleep(1000L);
        int j;
        j = i;
        k = i;
        if (mediaPlayer == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        k = i;
        j = mediaPlayer.getCurrentPosition();
        i = j;
        k = j;
        if (mediaPlayer == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = j;
        k = j;
        if (!mediaPlayer.isPlaying())
        {
            continue; /* Loop/switch isn't completed */
        }
        k = j;
        Intent intent = new Intent("MyService");
        k = j;
        intent.putExtra("t", 2);
        k = j;
        intent.putExtra("c", j);
        k = j;
        sendBroadcast(intent);
        i = j;
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        exception.printStackTrace();
        i = k;
        if (true) goto _L2; else goto _L1
_L1:
    }

}
