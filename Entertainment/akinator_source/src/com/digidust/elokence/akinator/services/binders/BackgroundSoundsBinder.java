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
import com.digidust.elokence.akinator.services.BackgroundSoundsService;

public class BackgroundSoundsBinder
{

    private static BackgroundSoundsBinder _instance = null;
    private static Intent backgroundSoundsServiceIntent;
    private ServiceConnection Scon;
    private boolean mIsBound;
    private BackgroundSoundsService mServ;

    public BackgroundSoundsBinder()
    {
        mIsBound = false;
        Scon = new ServiceConnection() {

            final BackgroundSoundsBinder this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                mServ = ((com.digidust.elokence.akinator.services.BackgroundSoundsService.ServiceBinder)ibinder).getService();
                mServ.setBSB(BackgroundSoundsBinder.this);
                AkLog.v("Akinator", "Service Connected");
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mServ = null;
            }

            
            {
                this$0 = BackgroundSoundsBinder.this;
                super();
            }
        };
    }

    public static BackgroundSoundsBinder sharedInstance()
    {
        if (_instance == null)
        {
            _instance = new BackgroundSoundsBinder();
        }
        if (!_instance.mIsBound)
        {
            _instance.doBindService();
            if (_instance.mServ == null)
            {
                backgroundSoundsServiceIntent = new Intent(AkApplication.getAppContext(), com/digidust/elokence/akinator/services/BackgroundSoundsService);
                AkApplication.getAppContext().startService(backgroundSoundsServiceIntent);
            }
        }
        return _instance;
    }

    void doBindService()
    {
        if (!mIsBound)
        {
            AkLog.d("Akinator", "BIND SOUNDS SERVICE");
            AkApplication.getAppContext().bindService(new Intent(AkApplication.getAppContext(), com/digidust/elokence/akinator/services/BackgroundSoundsService), Scon, 1);
            mIsBound = true;
        }
    }

    public void doUnbindService()
    {
        if (!mIsBound)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        AkLog.d("Akinator", "UNBIND SOUNDS SERVICE");
        mIsBound = false;
        AkApplication.getAppContext().stopService(backgroundSoundsServiceIntent);
        AkApplication.getAppContext().unbindService(Scon);
        return;
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        AkLog.e("Akinator", "Impossible d'unbinder le service de sons, le service n'est pas bind\351!");
        illegalargumentexception.printStackTrace();
        return;
    }

    public void playBip()
    {
        if (mServ != null)
        {
            mServ.playBip();
        }
    }

    public void playClap()
    {
        if (mServ != null)
        {
            mServ.playClap();
        }
    }

    public void playDescente()
    {
        if (mServ != null)
        {
            mServ.playDescente();
        }
    }

    public void playGzSound(int i)
    {
        if (mServ != null)
        {
            mServ.playGzSound(i);
        }
    }

    public void playMonte()
    {
        if (mServ != null)
        {
            mServ.playMonte();
        }
    }

    public void playPropose()
    {
        if (mServ != null)
        {
            mServ.playPropose();
        }
    }

    public void playReponse()
    {
        if (mServ != null)
        {
            mServ.playReponse();
        }
    }

    public void playStartPlaying()
    {
        if (mServ != null)
        {
            mServ.playStartPlaying();
        }
    }

    public void playWin()
    {
        if (mServ != null)
        {
            mServ.playWin();
        }
    }




/*
    static BackgroundSoundsService access$002(BackgroundSoundsBinder backgroundsoundsbinder, BackgroundSoundsService backgroundsoundsservice)
    {
        backgroundsoundsbinder.mServ = backgroundsoundsservice;
        return backgroundsoundsservice;
    }

*/
}
