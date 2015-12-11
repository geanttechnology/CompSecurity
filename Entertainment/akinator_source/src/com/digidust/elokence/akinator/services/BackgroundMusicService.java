// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import com.digidust.elokence.akinator.activities.AkActivity;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.binders.BackgroundMusicBinder;
import java.util.Timer;
import java.util.TimerTask;

public class BackgroundMusicService extends Service
{
    public static final class MusicType extends Enum
    {

        private static final MusicType $VALUES[];
        public static final MusicType FULL_MUSIC;
        public static final MusicType NO_CHANGE;
        public static final MusicType SHORT_MUSIC;

        public static MusicType valueOf(String s)
        {
            return (MusicType)Enum.valueOf(com/digidust/elokence/akinator/services/BackgroundMusicService$MusicType, s);
        }

        public static MusicType[] values()
        {
            return (MusicType[])$VALUES.clone();
        }

        static 
        {
            FULL_MUSIC = new MusicType("FULL_MUSIC", 0);
            SHORT_MUSIC = new MusicType("SHORT_MUSIC", 1);
            NO_CHANGE = new MusicType("NO_CHANGE", 2);
            $VALUES = (new MusicType[] {
                FULL_MUSIC, SHORT_MUSIC, NO_CHANGE
            });
        }

        private MusicType(String s, int i)
        {
            super(s, i);
        }
    }

    public class ServiceBinder extends Binder
    {

        final BackgroundMusicService this$0;

        public BackgroundMusicService getService()
        {
            return BackgroundMusicService.this;
        }

        public ServiceBinder()
        {
            this$0 = BackgroundMusicService.this;
            super();
        }
    }


    private static final String TAG = "BackgroundMusicService";
    private static MusicType mMusicType;
    private static MediaPlayer mPlayer = null;
    private static Timer mTimer = null;
    private static TimerTask mTimerTask = null;
    private BackgroundMusicBinder bmb;
    private int counterInactivity;
    private final IBinder mBinder = new ServiceBinder();

    public BackgroundMusicService()
    {
        counterInactivity = 0;
        bmb = null;
    }

    private void initMusicPlayer()
    {
        if (mMusicType == null || mMusicType == MusicType.FULL_MUSIC)
        {
            mPlayer = MediaPlayer.create(this, 0x7f060006);
        } else
        {
            mPlayer = MediaPlayer.create(this, AkConfigFactory.sharedInstance().getShortMusic());
        }
        if (mPlayer != null)
        {
            mPlayer.setLooping(true);
        }
    }

    private boolean isMusicEnabled()
    {
        return AkConfigFactory.sharedInstance().isMusicEnabled() && !((AudioManager)getSystemService("audio")).isMusicActive();
    }

    private void resetAll()
    {
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
        if (mTimerTask != null)
        {
            mTimerTask.cancel();
            mTimerTask = null;
        }
        if (mPlayer != null)
        {
            mPlayer.stop();
            mPlayer.release();
            mPlayer = null;
        }
    }

    public IBinder onBind(Intent intent)
    {
        return mBinder;
    }

    public void onDestroy()
    {
        super.onDestroy();
        AkLog.d("BackgroundMusicService", "onDestroy");
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        super.onStartCommand(intent, i, j);
        resetAll();
        initMusicPlayer();
        return 1;
    }

    public void pauseMusic()
    {
        try
        {
            if (mPlayer != null && mPlayer.isPlaying())
            {
                mPlayer.pause();
            }
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            return;
        }
    }

    public void resumeMusic()
    {
        try
        {
            if (isMusicEnabled() && mPlayer != null && !mPlayer.isPlaying())
            {
                mPlayer.start();
            }
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            return;
        }
    }

    public void setBMB(BackgroundMusicBinder backgroundmusicbinder)
    {
        bmb = backgroundmusicbinder;
    }

    public void startMusic(MusicType musictype)
    {
        if (mMusicType != musictype || mPlayer == null)
        {
            mMusicType = musictype;
            stopMusic();
            if (mPlayer == null)
            {
                resetAll();
            }
            initMusicPlayer();
            resumeMusic();
            if (mTimer == null && mTimerTask == null)
            {
                mTimer = new Timer();
                mTimerTask = new TimerTask() {

                    final BackgroundMusicService this$0;

                    public void run()
                    {
                        if (AkActivity.nbActivities == 0)
                        {
                            int i = 
// JavaClassFileOutputException: get_constant: invalid tag

            
            {
                this$0 = BackgroundMusicService.this;
                super();
            }
                };
                mTimer.scheduleAtFixedRate(mTimerTask, 3000L, 1500L);
            }
            return;
        } else
        {
            resumeMusic();
            return;
        }
    }

    public void stopMusic()
    {
        try
        {
            if (mPlayer != null)
            {
                mPlayer.stop();
                mPlayer.release();
                mPlayer = null;
            }
            return;
        }
        catch (IllegalStateException illegalstateexception)
        {
            return;
        }
    }




/*
    static int access$002(BackgroundMusicService backgroundmusicservice, int i)
    {
        backgroundmusicservice.counterInactivity = i;
        return i;
    }

*/


/*
    static int access$008(BackgroundMusicService backgroundmusicservice)
    {
        int i = backgroundmusicservice.counterInactivity;
        backgroundmusicservice.counterInactivity = i + 1;
        return i;
    }

*/


}
