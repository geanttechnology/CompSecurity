// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, MobileDataWarningState, VideoStateController, VideoState

public class BackgroundState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState);
    private BroadcastReceiver keyguardReciever;
    private VideoState previousState;

    public BackgroundState(VideoStateController videostatecontroller, VideoState videostate)
    {
        super(videostatecontroller);
        previousState = videostate;
    }

    private void returnFromBackground()
    {
        stateController.transitionToState(new MobileDataWarningState(stateController, previousState));
    }

    private void unregisterKeyguardReceiver()
    {
        this;
        JVM INSTR monitorenter ;
        if (keyguardReciever != null)
        {
            stateController.getActivityContext().unregisterReceiver(keyguardReciever);
            keyguardReciever = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String getStateName()
    {
        return "BackgroundState";
    }

    public void onActivityResumed()
    {
        if (((KeyguardManager)stateController.getActivityContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode())
        {
            unregisterKeyguardReceiver();
            keyguardReciever = new BroadcastReceiver() {

                final BackgroundState this$0;

                public void onReceive(Context context, Intent intent)
                {
                    if (!intent.getAction().equals("android.intent.action.USER_PRESENT"))
                    {
                        return;
                    } else
                    {
                        returnFromBackground();
                        unregisterKeyguardReceiver();
                        return;
                    }
                }

            
            {
                this$0 = BackgroundState.this;
                super();
            }
            };
            stateController.getActivityContext().registerReceiver(keyguardReciever, new IntentFilter("android.intent.action.USER_PRESENT"));
            return;
        } else
        {
            returnFromBackground();
            return;
        }
    }

    public void onBufferComplete()
    {
        stateController.getUiController().hideSpinner();
    }

    public void onPlayStateChanged(PlayerStatus playerstatus)
    {
        if (playerstatus == PlayerStatus.PLAYING)
        {
            stateController.getMediaPlayer().pause();
        }
    }

    public void onVideoSeekComplete()
    {
        stateController.getUiController().hideSpinner();
    }

    public void run()
    {
    }

    public void transitionToState(VideoState videostate)
    {
        unregisterKeyguardReceiver();
        if (videostate instanceof MobileDataWarningState)
        {
            stateController.setState(videostate);
            return;
        } else
        {
            super.transitionToState(videostate);
            return;
        }
    }



}
