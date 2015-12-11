// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.videoplay.adobeplayer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.downloads.DownloadServiceException;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.xfinity.playerlib.model.downloads.PlayerDownloadServiceManager;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import com.xfinity.playerlib.model.user.PlayerUserSettings;
import com.xfinity.playerlib.view.videoplay.PlayerPlatformMediaPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.model.videoplay.adobeplayer:
//            DefaultVideoState, VideoStateController, VideoState, QuitState

public class MobileDataWarningState extends DefaultVideoState
{

    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState);
    private boolean paused;
    private VideoState transitionState;

    public MobileDataWarningState(VideoStateController videostatecontroller, VideoState videostate)
    {
        super(videostatecontroller);
        paused = false;
        transitionState = videostate;
    }

    private void mobileDataRequirementCheck()
    {
        if (!stateController.shouldUseDownloadFile() && stateController.getInternetConnection().isConnectedNotOnWiFi() && !((PlayerUserSettings)stateController.getUserManager().getUserSettings()).getUseCellularWhenAvailable() && !stateController.isIgnoreMobileDataWarningSettingThisSession())
        {
            if (stateController.getMediaPlayer() != null && stateController.getMediaPlayer().getPlayerStatus() == PlayerStatus.PLAYING)
            {
                stateController.getMediaPlayer().pause();
                paused = true;
            }
            postMobileDataWarningDialog();
            return;
        } else
        {
            stateController.transitionToState(transitionState);
            return;
        }
    }

    public String getStateName()
    {
        return "MobileDataWarningState";
    }

    public void postMobileDataWarningDialog()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(stateController.getActivityContext());
        builder.setCancelable(true);
        if (!((WifiManager)stateController.getActivityContext().getSystemService("wifi")).isWifiEnabled())
        {
            builder.setTitle(com.xfinity.playerlib.R.string.alert_video_over_mobile_warning__wifi_disabled_title);
        } else
        {
            builder.setTitle(com.xfinity.playerlib.R.string.alert_video_over_mobile_warning_title);
        }
        builder.setMessage(com.xfinity.playerlib.R.string.alert_video_over_mobile_warning_msg);
        builder.setPositiveButton(com.xfinity.playerlib.R.string.alert_video_over_mobile_warning_btn_positive, new android.content.DialogInterface.OnClickListener() {

            final MobileDataWarningState this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                stateController.setIgnoreMobileDataWarningSettingThisSession(true);
                stateController.transitionToState(transitionState);
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MobileDataWarningState.this;
                super();
            }
        });
        builder.setNegativeButton(com.xfinity.playerlib.R.string.alert_video_over_mobile_warning_btn_negative, new android.content.DialogInterface.OnClickListener() {

            final MobileDataWarningState this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.cancel();
            }

            
            {
                this$0 = MobileDataWarningState.this;
                super();
            }
        });
        builder.setNeutralButton(com.xfinity.playerlib.R.string.alert_video_over_mobile_warning_btn_positive_change_setting, new android.content.DialogInterface.OnClickListener() {

            final MobileDataWarningState this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                try
                {
                    stateController.getPlayerDownloadServiceManager().setCellularDataThreshold(-1D);
                }
                catch (DownloadServiceException downloadserviceexception)
                {
                    dialoginterface.dismiss();
                    stateController.getPlayerDownloadServiceManager().showCrashDialog(stateController.getActivityContext(), downloadserviceexception);
                    return;
                }
                ((PlayerUserSettings)stateController.getUserManager().getUserSettings()).setUseCellularWhenAvailable(true);
                stateController.transitionToState(transitionState);
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MobileDataWarningState.this;
                super();
            }
        });
        builder.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final MobileDataWarningState this$0;

            public void onCancel(DialogInterface dialoginterface)
            {
                stateController.transitionToState(new QuitState(stateController));
            }

            
            {
                this$0 = MobileDataWarningState.this;
                super();
            }
        });
        builder.create().show();
    }

    public void run()
    {
        mobileDataRequirementCheck();
    }

    public void transitionToState(VideoState videostate)
    {
        if (videostate.getClass() == transitionState.getClass())
        {
            if (paused)
            {
                stateController.getMediaPlayer().play();
            }
            stateController.setState(videostate);
            return;
        } else
        {
            super.transitionToState(videostate);
            return;
        }
    }


}
