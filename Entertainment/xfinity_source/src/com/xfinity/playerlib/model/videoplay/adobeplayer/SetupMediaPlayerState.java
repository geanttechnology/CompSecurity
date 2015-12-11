// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.os.Build;
import com.comcast.cim.cmasl.utils.exceptions.CimException;
import com.comcast.playerplatform.analytics.java.util.HostInfo;
import com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies;
import com.xfinity.playerlib.PlayerApplication;
import com.xfinity.playerlib.model.videoplay.PlayerConfigUtil;
import com.xfinity.playerlib.model.videoplay.PlayerConfigurationListener;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, MobileDataWarningState, AuthenticatingState, 
//            VideoState

public class SetupMediaPlayerState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState);
    private PlayerConfigurationListener configurationEventListener;

    public SetupMediaPlayerState(VideoStateController videostatecontroller)
    {
        super(videostatecontroller);
        configurationEventListener = new PlayerConfigurationListener() {

            final SetupMediaPlayerState this$0;

            public void configurationFailed(String s)
            {
                super.configurationFailed(s);
                throw new CimException(s);
            }

            public void configurationLoaded()
            {
                super.configurationLoaded();
                stateController.onConfigurationLoaded();
            }

            
            {
                this$0 = SetupMediaPlayerState.this;
                super();
            }
        };
    }

    public String getStateName()
    {
        return "SetupMediaPlayerState";
    }

    public void onActivityResumed()
    {
        run();
    }

    public void onConfigurationLoaded()
    {
        stateController.initPlayerPlatformMediaPlayer();
        stateController.getUiController().setupVideoView();
        String s = stateController.getPlayerApplication().getInstallId();
        PlayerPlatformMediaPlayer playerplatformmediaplayer = stateController.getMediaPlayer();
        playerplatformmediaplayer.configureAnalytics(new HostInfo("tvgo-android", stateController.getPlayerApplication().getVersionNumber(), s, Build.MODEL, android.os.Build.VERSION.RELEASE));
        playerplatformmediaplayer.setPlayerAdBreakPolicies((new PlayerAdBreakPolicies()).setPreRollPolicy(com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakPolicy.REMOVE).setMidRollPolicy(com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakPolicy.KEEP).setPostRollPolicy(com.comcast.playerplatform.primetime.android.ads.PlayerAdBreakPolicies.AdBreakPolicy.REMOVE));
        playerplatformmediaplayer.setAutoPlay(false);
        stateController.transitionToState(new MobileDataWarningState(stateController, new AuthenticatingState(stateController, null, null)));
    }

    public void run()
    {
        stateController.getPlayerConfigUtil().configurePlayerPlatform(configurationEventListener);
    }

    public void transitionToState(VideoState videostate)
    {
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
