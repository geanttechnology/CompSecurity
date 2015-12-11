// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services.binders;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.digidust.elokence.akinator.factories.AkApplication;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.services.BackgroundMusicService;

public class BackgroundMusicBinder
{

    private static final String TAG = "BackgroundMusicBinder";
    private static BackgroundMusicBinder _instance = null;
    private static Intent backgroundMusicServiceIntent;
    private ServiceConnection Scon;
    private boolean mIsBound;
    private com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType mMusicType;
    private BackgroundMusicService mServ;

    public BackgroundMusicBinder()
    {
        mIsBound = false;
        mMusicType = com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.FULL_MUSIC;
        Scon = new ServiceConnection() {

            final BackgroundMusicBinder this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                mServ = ((com.digidust.elokence.akinator.services.BackgroundMusicService.ServiceBinder)ibinder).getService();
                mServ.setBMB(BackgroundMusicBinder.this);
                mServ.startMusic(mMusicType);
                AkLog.v("BackgroundMusicBinder", (new StringBuilder()).append("BackgroundMusicBinder Service Connected with Music Type : ").append(mMusicType).toString());
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                AkLog.v("BackgroundMusicBinder", "BackgroundMusicBinder Service Disconnected");
                mServ = null;
            }

            
            {
                this$0 = BackgroundMusicBinder.this;
                super();
            }
        };
    }

    public static BackgroundMusicBinder sharedInstance()
    {
        return sharedInstance(com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.NO_CHANGE);
    }

    public static BackgroundMusicBinder sharedInstance(com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType musictype)
    {
        if (_instance == null)
        {
            _instance = new BackgroundMusicBinder();
        }
        if (musictype != com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType.NO_CHANGE)
        {
            _instance.mMusicType = musictype;
        }
        if (!_instance.mIsBound)
        {
            _instance.doBindService();
            if (_instance.mServ == null)
            {
                backgroundMusicServiceIntent = new Intent(AkApplication.getAppContext(), com/digidust/elokence/akinator/services/BackgroundMusicService);
                AkApplication.getAppContext().startService(backgroundMusicServiceIntent);
            }
        }
        return _instance;
    }

    public void doBindService()
    {
        if (!mIsBound)
        {
            AkLog.d("Akinator", "BIND MUSIC SERVICE");
            AkApplication.getAppContext().bindService(new Intent(AkApplication.getAppContext(), com/digidust/elokence/akinator/services/BackgroundMusicService), Scon, 1);
            mIsBound = true;
        }
    }

    public void doUnbindService()
    {
        if (!mIsBound)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        AkLog.d("Akinator", "UNBIND MUSIC SERVICE");
        mIsBound = false;
        AkApplication.getAppContext().stopService(backgroundMusicServiceIntent);
        AkApplication.getAppContext().unbindService(Scon);
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        AkLog.e("Akinator", "Impossible d'unbinder le service de musique, le service n'est pas bind\351!");
        illegalargumentexception.printStackTrace();
        return;
    }

    public boolean isBound()
    {
        return mIsBound;
    }

    public void pauseMusic()
    {
        if (mServ != null)
        {
            mServ.pauseMusic();
        }
    }

    public void resumeMusic()
    {
        if (mServ != null)
        {
            mServ.resumeMusic();
        }
    }

    public void setBound(boolean flag)
    {
        mIsBound = flag;
    }

    public void startMusic(com.digidust.elokence.akinator.services.BackgroundMusicService.MusicType musictype)
    {
        if (mServ != null)
        {
            mServ.startMusic(musictype);
            return;
        } else
        {
            mMusicType = musictype;
            return;
        }
    }

    public void stopMusic()
    {
        if (mServ != null)
        {
            mServ.stopMusic();
        }
    }




/*
    static BackgroundMusicService access$002(BackgroundMusicBinder backgroundmusicbinder, BackgroundMusicService backgroundmusicservice)
    {
        backgroundmusicbinder.mServ = backgroundmusicservice;
        return backgroundmusicservice;
    }

*/

}
