// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.disney.datg.videoplatforms.sdk.common.AsyncHandler;
import com.disney.datg.videoplatforms.sdk.error.AndroidSDKException;
import com.disney.datg.videoplatforms.sdk.error.ErrorCode;
import com.disney.datg.videoplatforms.sdk.utils.LogUtils;
import com.uplynk.media.CaptionEvent;
import com.uplynk.media.MediaPlayer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Future;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer, VPMedia, Configuration, CaptionUtils, 
//            CaptionData, VPMediaMetadata

public class LiveMediaPlayer extends VPMediaPlayer
{
    class AuthZTimeoutTask extends TimerTask
    {

        final LiveMediaPlayer this$0;

        public void run()
        {
            authTimerDone();
        }

        AuthZTimeoutTask()
        {
            this$0 = LiveMediaPlayer.this;
            super();
        }
    }


    public static int STREAM_AUTHORIZATION_ERROR;
    private static String TAG = com/disney/datg/videoplatforms/sdk/media/LiveMediaPlayer.getName();
    private boolean doingAuthZ;
    private boolean forceAuthZ;
    protected Timer liveAuthZIntervalTimer;

    protected LiveMediaPlayer(Context context, Configuration configuration)
        throws AndroidSDKException
    {
        super(context, configuration);
        doingAuthZ = false;
        forceAuthZ = false;
    }

    private void authTimerDone()
    {
        forceAuthZ = true;
        LogUtils.LOGD(TAG, "AUTHZ Timer expired --AUTHZ will commence on the next break");
    }

    private void reauthorization()
    {
        if (!doingAuthZ)
        {
            LogUtils.LOGD(TAG, "DOING AUTHZ For Live");
            doingAuthZ = true;
            stopLiveIntervalAuthTimer();
            if (getCurrentMedia() != null)
            {
                getCurrentMedia().getPlayableAssetUrl(new AsyncHandler() {

                    final LiveMediaPlayer this$0;

                    public void onAsyncTask()
                    {
                    }

                    public void onError(Exception exception)
                    {
                        stop();
                        doingAuthZ = false;
                        getOnErrorListener().onError(LiveMediaPlayer.this, 1, LiveMediaPlayer.STREAM_AUTHORIZATION_ERROR);
                    }

                    public volatile void onSuccess(Object obj)
                    {
                        onSuccess((String)obj);
                    }

                    public void onSuccess(String s)
                    {
                        doingAuthZ = false;
                        forceAuthZ = false;
                        LogUtils.LOGD(LiveMediaPlayer.TAG, "AUTHZ Success --restarting interval");
                        startLiveIntervalAuthTimer();
                    }

            
            {
                this$0 = LiveMediaPlayer.this;
                super();
            }
                });
            }
        }
    }

    private void restartLiveStream()
    {
        LogUtils.LOGD(TAG, "restarting live stream");
        VPMedia vpmedia = getCurrentMedia();
        reset();
        setDataSource(vpmedia, new AsyncHandler() {

            final LiveMediaPlayer this$0;

            public void onAsyncTask()
            {
            }

            public void onError(Exception exception)
            {
                getOnErrorListener().onError(LiveMediaPlayer.this, 1, LiveMediaPlayer.STREAM_AUTHORIZATION_ERROR);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((String)obj);
            }

            public void onSuccess(String s)
            {
                prepareAsync();
            }

            
            {
                this$0 = LiveMediaPlayer.this;
                super();
            }
        });
    }

    private void startLiveIntervalAuthTimer()
    {
        stopLiveIntervalAuthTimer();
        liveAuthZIntervalTimer = new Timer();
        liveAuthZIntervalTimer.schedule(new AuthZTimeoutTask(), Configuration.LIVE_STREAM_AUTHZ_INTERVAL * 1000);
    }

    private void stopLiveIntervalAuthTimer()
    {
        if (liveAuthZIntervalTimer != null)
        {
            liveAuthZIntervalTimer.cancel();
            liveAuthZIntervalTimer.purge();
        }
    }

    public boolean canSeek()
    {
        static class _cls3
        {

            static final int $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[];

            static 
            {
                $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType = new int[VPMediaPlayer.BasePlayerType.values().length];
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[VPMediaPlayer.BasePlayerType.UPLYNK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$disney$datg$videoplatforms$sdk$media$VPMediaPlayer$BasePlayerType[VPMediaPlayer.BasePlayerType.NATIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()];
        JVM INSTR tableswitch 1 2: default 32
    //                   1 34
    //                   2 63;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        if (super.canSeek() && (uplynkMediaPlayer.canSeekBackward() || uplynkMediaPlayer.canSeekForward()))
        {
            return true;
        }
          goto _L1
_L3:
        return super.canSeek();
    }

    public void onAssetBoundary(MediaPlayer mediaplayer, String s)
    {
        if (!isPlaying() || TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_24;
        }
        super.onAssetBoundary(mediaplayer, s);
        doGeo();
        return;
        mediaplayer;
        LogUtils.LOGE(TAG, mediaplayer.getMessage());
        return;
    }

    public boolean onCaptionEvent(MediaPlayer mediaplayer, CaptionEvent captionevent)
    {
        if (captionevent != null && closeCaptionsOn && captionevent.eventType != null)
        {
            mediaplayer = CaptionUtils.parseEvent(captionevent, "00:00:00", "00:00:00");
            sendTimedText(mediaplayer.getWebVTT(), mediaplayer);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        Bundle bundle = new Bundle();
        if (i == 100 || i == 100)
        {
            String s = ErrorCode.ANDROID_SDK_MEDIA_PLAYER_PLAYBACK_ERROR.getReason().replace("[video id]", "live");
            bundle.putString("trackCode", s);
            bundle.putString("error", String.format("live:feed:%s", new Object[] {
                s
            }));
        } else
        {
            String s1 = (new StringBuilder()).append("unknown:liveplayer:").append(i).append(",").append(j).toString();
            bundle.putString("trackCode", s1);
            bundle.putString("error", String.format("live:feed:%s", new Object[] {
                s1
            }));
        }
        sendTrackable(VPMediaPlayer.TrackableState.MEDIA_ERROR, bundle);
        super.onError(mediaplayer, i, j);
        return false;
    }

    public boolean onUplynkMetadata(MediaPlayer mediaplayer, com.uplynk.media.MediaPlayer.UplynkMetadata uplynkmetadata)
    {
        super.onUplynkMetadata(mediaplayer, uplynkmetadata);
        if (processNextAsset && uplynkmetadata != null && !TextUtils.isEmpty(uplynkmetadata.getAssetID()) && !TextUtils.isEmpty(currentAssetId) && TextUtils.equals(currentAssetId, uplynkmetadata.getAssetID()))
        {
            if (getCurrentMedia() != null && getCurrentMedia().getCurrentMetadata() != null)
            {
                getCurrentMedia().getCurrentMetadata().setUplynkMetadata(uplynkmetadata);
            }
            LogUtils.LOGD(TAG, "processing uplynk metadata");
            mediaplayer = uplynkmetadata.getAssetInfo();
            if (mediaplayer != null)
            {
                processNextAsset = false;
                if (mediaplayer.isAd())
                {
                    seekAllowed = false;
                    if (getCurrentMedia() != null && getCurrentMedia().getCurrentMetadata() != null && getCurrentMedia().getCurrentMetadata().getUplynkMetadata() != null && getCurrentMedia().getCurrentMetadata().getUplynkMetadata().getAssetInfo() != null && getCurrentMedia().getCurrentMetadata().getUplynkMetadata().getAssetInfo().isAd())
                    {
                        sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_AD_END);
                    }
                    sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_AD_START);
                } else
                {
                    seekAllowed = true;
                    if (!TextUtils.equals(currentAssetId, currentProgramId))
                    {
                        sendMetadataEvent(VPMediaMetadata.BOUNDARY_EVENT_PROGRAM_START);
                        uplynkmetadata = new Bundle();
                        uplynkmetadata.putString("start_video", "");
                        sendTrackable(VPMediaPlayer.TrackableState.PROGRAM_START, uplynkmetadata);
                        currentProgramId = currentAssetId;
                        int i = mediaplayer.getTvRating();
                        int j = mediaplayer.getMovieRating();
                        boolean flag = false;
                        if (currentRating != -1)
                        {
                            if (forceAuthZ || currentRating != i || currentRating != j)
                            {
                                flag = true;
                            } else
                            {
                                flag = false;
                            }
                        }
                        if (i != -1)
                        {
                            currentRating = i;
                        }
                        if (j != -1)
                        {
                            currentRating = j;
                        }
                        if (flag)
                        {
                            reauthorization();
                            return true;
                        }
                    } else
                    {
                        mediaplayer = new Bundle();
                        mediaplayer.putString("start_video", "");
                        sendTrackable(VPMediaPlayer.TrackableState.PROGRAM_START, mediaplayer);
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public Future setDataSource(VPMedia vpmedia, AsyncHandler asynchandler)
        throws IllegalArgumentException, IllegalStateException
    {
        if (vpmedia == null)
        {
            throw new IllegalArgumentException(new AndroidSDKException(ErrorCode.ANDROID_INVALID_MEDIA_EXCEPTION, "valid Media object must be set"));
        }
        if (vpmedia.getMediaType() != VPMedia.MediaType.LIVE)
        {
            throw new IllegalArgumentException(new AndroidSDKException(ErrorCode.ANDROID_MEDIA_INITIALIZED_ON_WRONG_PLAYER_TYPE_EXCEPTION, "Media must be a VOD type"));
        } else
        {
            return super.setDataSource(vpmedia, asynchandler);
        }
    }

    public void start()
        throws IllegalStateException
    {
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            if (uplynkMediaPlayer != null && (playerState == VPMediaPlayer.PlayerState.PAUSED || playerState == VPMediaPlayer.PlayerState.STOPPED) && !hdmiError)
            {
                restartLiveStream();
                return;
            } else
            {
                super.start();
                return;
            }

        case 2: // '\002'
            super.start();
            return;
        }
    }

    public void stop()
    {
        switch (_cls3..SwitchMap.com.disney.datg.videoplatforms.sdk.media.VPMediaPlayer.BasePlayerType[currentPlayerType.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            super.stop();
            forceAuthZ = true;
            stopLiveIntervalAuthTimer();
            return;

        case 2: // '\002'
            super.stop();
            break;
        }
    }

    static 
    {
        STREAM_AUTHORIZATION_ERROR = ErrorCode.ANDROID_AUTHZ_FAILED_EXCEPTION.getErrorCode();
    }



/*
    static boolean access$102(LiveMediaPlayer livemediaplayer, boolean flag)
    {
        livemediaplayer.doingAuthZ = flag;
        return flag;
    }

*/


/*
    static boolean access$202(LiveMediaPlayer livemediaplayer, boolean flag)
    {
        livemediaplayer.forceAuthZ = flag;
        return flag;
    }

*/


}
