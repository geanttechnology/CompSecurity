// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.binders.BackgroundSoundsBinder;
import java.util.Timer;
import java.util.TimerTask;

public class BackgroundSoundsService extends Service
{
    public class ServiceBinder extends Binder
    {

        final BackgroundSoundsService this$0;

        public BackgroundSoundsService getService()
        {
            return BackgroundSoundsService.this;
        }

        public ServiceBinder()
        {
            this$0 = BackgroundSoundsService.this;
            super();
        }
    }


    private BackgroundSoundsBinder bsb;
    private int counterInactivity;
    private final IBinder mBinder = new ServiceBinder();
    private MediaPlayer mPlayer;
    private MediaPlayer mPlayerDescente;
    private MediaPlayer mPlayerMonte;
    private Timer timer;
    private TimerTask timerTask;

    public BackgroundSoundsService()
    {
        timer = null;
        timerTask = null;
        counterInactivity = 0;
        bsb = null;
    }

    private boolean isSoundEnabled()
    {
        return AkConfigFactory.sharedInstance().isSoundEnabled();
    }

    public void destroyPlayerDescente()
    {
        if (mPlayerDescente == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        mPlayerDescente.stop();
        mPlayerDescente.release();
        mPlayerDescente = null;
        return;
        Exception exception;
        exception;
        mPlayerDescente = null;
        throw exception;
    }

    public void destroyPlayerMonte()
    {
        if (mPlayerMonte == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        mPlayerMonte.stop();
        mPlayerMonte.release();
        mPlayerMonte = null;
        return;
        Exception exception;
        exception;
        mPlayerMonte = null;
        throw exception;
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onCreate()
    {
        super.onCreate();
        AkLog.w("BackgroundSoundsService", "onCreate");
        mPlayerDescente = MediaPlayer.create(this, 0x7f060002);
        mPlayerMonte = MediaPlayer.create(this, 0x7f060004);
        timer = new Timer();
        timerTask = new TimerTask() {

            final BackgroundSoundsService this$0;

            public void run()
            {
                if (AkActivity.nbActivities == 0)
                {
                    int i = this.stopSelf;
                } else
                {
                    counterInactivity = 0;
                }
                if (counterInactivity > 10)
                {
                    if (bsb != null)
                    {
                        bsb.doUnbindService();
                    }
                    timerTask.cancel();
                    stopSelf();
                    AkLog.w("Akinator", "BackgroundSoundsService Stopped");
                }
            }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
        };
        timer.scheduleAtFixedRate(timerTask, 2000L, 2000L);
    }

    public void onDestroy()
    {
        super.onDestroy();
        AkLog.w("BackgroundSoundsService", "onDestroy");
        destroyPlayerDescente();
        destroyPlayerMonte();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Toast.makeText(this, "music player failed", 0).show();
        destroyPlayerDescente();
        destroyPlayerMonte();
        return false;
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return 1;
    }

    public void playBip()
    {
        if (isSoundEnabled())
        {
            mPlayer = MediaPlayer.create(this, 0x7f060000);
            if (mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                    final BackgroundSoundsService this$0;

                    public void onCompletion(MediaPlayer mediaplayer)
                    {
                        mediaplayer.release();
                    }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
                });
                mPlayer.start();
            }
        }
    }

    public void playClap()
    {
        if (isSoundEnabled())
        {
            mPlayer = MediaPlayer.create(this, 0x7f060001);
            if (mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                    final BackgroundSoundsService this$0;

                    public void onCompletion(MediaPlayer mediaplayer)
                    {
                        mediaplayer.release();
                    }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
                });
                mPlayer.start();
            }
        }
    }

    public void playDescente()
    {
        if (isSoundEnabled() && mPlayerDescente != null && !mPlayerDescente.isPlaying())
        {
            mPlayerDescente.start();
        }
    }

    public void playGzSound(int i)
    {
        if (!isSoundEnabled()) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 1 6: default 48
    //                   1 98
    //                   2 111
    //                   3 124
    //                   4 137
    //                   5 150
    //                   6 163;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L3:
        mPlayer = MediaPlayer.create(this, 0x7f06000c);
_L11:
        if (mPlayer != null && !mPlayer.isPlaying())
        {
            mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                final BackgroundSoundsService this$0;

                public void onCompletion(MediaPlayer mediaplayer)
                {
                    mediaplayer.release();
                }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
            });
            mPlayer.start();
        }
_L2:
        return;
_L4:
        mPlayer = MediaPlayer.create(this, 0x7f06000c);
        continue; /* Loop/switch isn't completed */
_L5:
        mPlayer = MediaPlayer.create(this, 0x7f06000d);
        continue; /* Loop/switch isn't completed */
_L6:
        mPlayer = MediaPlayer.create(this, 0x7f06000e);
        continue; /* Loop/switch isn't completed */
_L7:
        mPlayer = MediaPlayer.create(this, 0x7f06000f);
        continue; /* Loop/switch isn't completed */
_L8:
        mPlayer = MediaPlayer.create(this, 0x7f060010);
        continue; /* Loop/switch isn't completed */
_L9:
        mPlayer = MediaPlayer.create(this, 0x7f060011);
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void playMonte()
    {
        if (isSoundEnabled() && mPlayerMonte != null && !mPlayerMonte.isPlaying())
        {
            mPlayerMonte.start();
        }
    }

    public void playPropose()
    {
        if (isSoundEnabled())
        {
            mPlayer = MediaPlayer.create(this, 0x7f06000a);
            if (mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                    final BackgroundSoundsService this$0;

                    public void onCompletion(MediaPlayer mediaplayer)
                    {
                        mediaplayer.release();
                    }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
                });
                mPlayer.start();
            }
        }
    }

    public void playReponse()
    {
        if (isSoundEnabled())
        {
            mPlayer = MediaPlayer.create(this, 0x7f06000b);
            if (mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                    final BackgroundSoundsService this$0;

                    public void onCompletion(MediaPlayer mediaplayer)
                    {
                        mediaplayer.release();
                    }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
                });
                mPlayer.start();
            }
        }
    }

    public void playStartPlaying()
    {
        if (isSoundEnabled())
        {
            mPlayer = MediaPlayer.create(this, 0x7f060009);
            if (mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                    final BackgroundSoundsService this$0;

                    public void onCompletion(MediaPlayer mediaplayer)
                    {
                        mediaplayer.release();
                    }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
                });
                mPlayer.start();
            }
        }
    }

    public void playWin()
    {
        if (isSoundEnabled())
        {
            mPlayer = MediaPlayer.create(this, 0x7f060012);
            if (mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

                    final BackgroundSoundsService this$0;

                    public void onCompletion(MediaPlayer mediaplayer)
                    {
                        mediaplayer.release();
                    }

            
            {
                this$0 = BackgroundSoundsService.this;
                super();
            }
                });
                mPlayer.start();
            }
        }
    }

    public void setBSB(BackgroundSoundsBinder backgroundsoundsbinder)
    {
        bsb = backgroundsoundsbinder;
    }



/*
    static int access$002(BackgroundSoundsService backgroundsoundsservice, int i)
    {
        backgroundsoundsservice.counterInactivity = i;
        return i;
    }

*/


/*
    static int access$008(BackgroundSoundsService backgroundsoundsservice)
    {
        int i = backgroundsoundsservice.counterInactivity;
        backgroundsoundsservice.counterInactivity = i + 1;
        return i;
    }

*/


}
