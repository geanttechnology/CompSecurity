// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.eas;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.adobe.mediacore.DefaultMediaPlayer;
import com.adobe.mediacore.MediaPlayer;
import com.adobe.mediacore.MediaPlayerNotification;
import com.adobe.mediacore.MediaPlayerView;
import com.adobe.mediacore.MediaResource;
import com.adobe.mediacore.metadata.TimedMetadata;
import com.comcast.playerplatform.primetime.android.enums.PlayerStatus;
import com.comcast.playerplatform.primetime.android.enums.StreamType;
import com.comcast.playerplatform.primetime.android.player.IPlayerPlatform;
import com.comcast.playerplatform.primetime.android.util.ThreadManager;

// Referenced classes of package com.comcast.playerplatform.primetime.android.eas:
//            EmergencyAlertScroller, EmergencyAlertSettings, Alert, AlertEventListener

public class AlertAnimationManager
{

    private MediaPlayer alertPlayer;
    private EmergencyAlertScroller alertScrollView;
    private TranslateAnimation alertTextAnimation;
    private TextView alertTextView;
    private android.view.animation.Animation.AnimationListener animationListener;
    private Context applicationContext;
    private Alert currentAlert;
    private AlertEventListener listener;
    private IPlayerPlatform playerPlatform;
    private PlayerStatus savedPlayerStatus;
    private View savedView;
    private EmergencyAlertSettings settings;

    public AlertAnimationManager()
    {
        animationListener = new android.view.animation.Animation.AnimationListener() {

            final AlertAnimationManager this$0;

            public void onAnimationEnd(Animation animation)
            {
                destroyText();
                synchronized (listener)
                {
                    String s = currentAlert.getIdentifier();
                    listener.emergencyAlertCompleted(s, true);
                    checkForNextAlert();
                }
                return;
                exception;
                animation;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = AlertAnimationManager.this;
                super();
            }
        };
    }

    private void addToPlayerView()
    {
        playerPlatform.getView().measure(0, 0);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(0, 0, 0, 0);
        alertScrollView.addView(alertTextView, new android.view.ViewGroup.LayoutParams(-2, -1));
        alertScrollView.setLayoutParams(layoutparams);
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final AlertAnimationManager this$0;

            public void run()
            {
                if (alertScrollView.getParent() != null)
                {
                    ((ViewGroup)alertScrollView.getParent()).removeView(alertScrollView);
                    alertScrollView.removeView(alertTextView);
                }
                ((ViewGroup)playerPlatform.getView().getParent()).addView(alertScrollView);
            }

            
            {
                this$0 = AlertAnimationManager.this;
                super();
            }
        });
    }

    private void checkForNextAlert()
    {
        if (savedPlayerStatus != null)
        {
            restartMainContent();
            currentAlert = null;
            return;
        } else
        {
            currentAlert = null;
            return;
        }
    }

    private void destroyText()
    {
        if (alertTextAnimation.hasStarted() && !alertTextAnimation.hasEnded())
        {
            alertTextAnimation.cancel();
        }
        alertTextAnimation = null;
        if (alertTextView != null)
        {
            alertTextView.clearComposingText();
            if (alertScrollView.getParent() != null)
            {
                ((ViewGroup)alertScrollView.getParent()).removeView(alertScrollView);
                alertScrollView.removeView(alertTextView);
            }
            alertTextView = null;
            alertScrollView = null;
        }
    }

    private void restartMainContent()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final AlertAnimationManager this$0;

            public void run()
            {
                FrameLayout framelayout = (FrameLayout)playerPlatform.getView();
                framelayout.removeView(alertPlayer.getView());
                framelayout.addView(savedView);
                savedView.bringToFront();
                savedView = null;
                alertPlayer.reset();
                alertPlayer = null;
                if (savedPlayerStatus == PlayerStatus.PLAYING)
                {
                    playerPlatform.play();
                }
                savedPlayerStatus = null;
                if (playerPlatform.getVideoType().equals(StreamType.LINEAR))
                {
                    playerPlatform.seekToLive();
                }
            }

            
            {
                this$0 = AlertAnimationManager.this;
                super();
            }
        });
    }

    private void saveCurrentPlayerState()
    {
        savedPlayerStatus = playerPlatform.getPlayerStatus();
        playerPlatform.pause();
    }

    private void setupTextView()
    {
        alertScrollView = new EmergencyAlertScroller(applicationContext);
        alertTextView = new TextView(applicationContext);
        alertTextView.setTextSize(settings.getTextSize());
        alertTextView.setTextColor(settings.getTextColor());
        alertTextView.setBackgroundColor(settings.getBackgroundColor());
        alertTextView.setMaxLines(1);
        alertTextView.setHorizontallyScrolling(true);
        alertTextView.setText(currentAlert.getAlertMessage());
    }

    private void startAlert()
    {
        if (listener != null)
        {
            AlertEventListener alerteventlistener = listener;
            String s = currentAlert.getIdentifier();
            boolean flag;
            if (!currentAlert.hasMediaUrl())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            alerteventlistener.emergencyAlertStarted(s, flag);
        }
        if (currentAlert.hasMediaUrl())
        {
            ThreadManager.getInstance().executeOnUIThread(new Runnable() {

                final AlertAnimationManager this$0;

                public void run()
                {
                    if (savedPlayerStatus == null)
                    {
                        saveCurrentPlayerState();
                    }
                    startAlertContent();
                }

            
            {
                this$0 = AlertAnimationManager.this;
                super();
            }
            });
            return;
        } else
        {
            setupTextView();
            addToPlayerView();
            startAlertAnimation();
            return;
        }
    }

    private void startAlertAnimation()
    {
        alertTextAnimation = new TranslateAnimation(2, 1.0F, 1, -1F, 2, 0.0F, 2, 0.0F);
        alertTextAnimation.setAnimationListener(animationListener);
        alertTextAnimation.setRepeatCount(settings.getAlertRepeatCount());
        alertTextAnimation.setInterpolator(new LinearInterpolator());
        alertTextView.measure(0, 0);
        alertScrollView.measure(0, 0);
        alertTextAnimation.initialize(alertTextView.getMeasuredWidth(), alertTextView.getMeasuredHeight(), alertScrollView.getMeasuredWidth(), alertScrollView.getMeasuredHeight());
        alertTextAnimation.setDuration((alertTextView.getMeasuredWidth() / 50) * 500);
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final AlertAnimationManager this$0;

            public void run()
            {
                alertTextView.startAnimation(alertTextAnimation);
            }

            
            {
                this$0 = AlertAnimationManager.this;
                super();
            }
        });
    }

    private void startAlertContent()
    {
        alertPlayer = DefaultMediaPlayer.create(applicationContext);
        alertPlayer.addEventListener(com.adobe.mediacore.MediaPlayer.Event.PLAYBACK, new com.adobe.mediacore.MediaPlayer.PlaybackEventListener() {

            final AlertAnimationManager this$0;

            public void onPlayComplete()
            {
                String s = currentAlert.getIdentifier();
                if (listener != null)
                {
                    listener.emergencyAlertCompleted(s, false);
                }
                checkForNextAlert();
            }

            public void onPlayStart()
            {
            }

            public void onPrepared()
            {
                alertPlayer.play();
            }

            public void onProfileChanged(long l, long l1)
            {
            }

            public void onRatePlaying(float f)
            {
            }

            public void onRateSelected(float f)
            {
            }

            public void onReplaceMediaPlayerItem()
            {
            }

            public void onSizeAvailable(long l, long l1)
            {
            }

            public void onStateChanged(com.adobe.mediacore.MediaPlayer.PlayerState playerstate, MediaPlayerNotification mediaplayernotification)
            {
                if (playerstate.equals(com.adobe.mediacore.MediaPlayer.PlayerState.INITIALIZED))
                {
                    alertPlayer.prepareToPlay();
                }
                if (playerstate.equals(com.adobe.mediacore.MediaPlayer.PlayerState.ERROR))
                {
                    listener.emergencyAlertFailed(currentAlert.getIdentifier(), String.valueOf(mediaplayernotification.getCode().getCode()), mediaplayernotification.getDescription(), false);
                    checkForNextAlert();
                }
            }

            public void onTimedMetadata(TimedMetadata timedmetadata)
            {
            }

            public void onTimelineUpdated()
            {
            }

            public void onUpdated()
            {
            }

            
            {
                this$0 = AlertAnimationManager.this;
                super();
            }
        });
        FrameLayout framelayout = (FrameLayout)playerPlatform.getView();
        savedView = framelayout.getChildAt(0);
        framelayout.removeAllViews();
        framelayout.addView(alertPlayer.getView());
        framelayout.bringChildToFront(alertPlayer.getView());
        alertPlayer.getView().bringToFront();
        alertPlayer.replaceCurrentItem(MediaResource.createFromUrl(currentAlert.getReplaceContentUri(), null));
    }

    public void displayAlert(IPlayerPlatform iplayerplatform, Context context, EmergencyAlertSettings emergencyalertsettings, AlertEventListener alerteventlistener, Alert alert)
    {
        playerPlatform = iplayerplatform;
        applicationContext = context;
        settings = emergencyalertsettings;
        listener = alerteventlistener;
        currentAlert = alert;
        startAlert();
    }

    public Alert getCurrentAlert()
    {
        return currentAlert;
    }

    public void stopEmergencyActionNotification()
    {
        this;
        JVM INSTR monitorenter ;
        listener.emergencyAlertCompleted(currentAlert.getIdentifier(), false);
        currentAlert = null;
        checkForNextAlert();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }










/*
    static MediaPlayer access$402(AlertAnimationManager alertanimationmanager, MediaPlayer mediaplayer)
    {
        alertanimationmanager.alertPlayer = mediaplayer;
        return mediaplayer;
    }

*/




/*
    static View access$602(AlertAnimationManager alertanimationmanager, View view)
    {
        alertanimationmanager.savedView = view;
        return view;
    }

*/



/*
    static PlayerStatus access$702(AlertAnimationManager alertanimationmanager, PlayerStatus playerstatus)
    {
        alertanimationmanager.savedPlayerStatus = playerstatus;
        return playerstatus;
    }

*/


}
