// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import tv.freewheel.ad.interfaces.IConstants;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoRenderer, VideoAdController

public class VideoAdView extends SurfaceView
    implements android.view.SurfaceHolder.Callback, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.view.View.OnClickListener
{
    private static final class MuteState extends Enum
    {

        private static final MuteState $VALUES[];
        public static final MuteState MUTED;
        public static final MuteState UNINITIALIZED;
        public static final MuteState UNMUTED;

        public static MuteState valueOf(String s)
        {
            return (MuteState)Enum.valueOf(tv/freewheel/renderers/temporal/VideoAdView$MuteState, s);
        }

        public static MuteState[] values()
        {
            return (MuteState[])$VALUES.clone();
        }

        static 
        {
            UNINITIALIZED = new MuteState("UNINITIALIZED", 0);
            MUTED = new MuteState("MUTED", 1);
            UNMUTED = new MuteState("UNMUTED", 2);
            $VALUES = (new MuteState[] {
                UNINITIALIZED, MUTED, UNMUTED
            });
        }

        private MuteState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int STATE_ERROR = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PAUSED = 4;
    private static final int STATE_PLAYBACK_COMPLETED = 5;
    private static final int STATE_PLAYING = 3;
    private static final int STATE_PREPARED = 2;
    private static final int STATE_PREPARING = 1;
    private String adUrl;
    private AudioManager audioManager;
    protected IConstants constants;
    private android.media.MediaPlayer.OnErrorListener errorListener = new android.media.MediaPlayer.OnErrorListener() {

        final VideoAdView this$0;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            logger.debug((new StringBuilder()).append("onError: ").append(i).append(",").append(j).toString());
            mCurrentState = -1;
            mTargetState = -1;
            if (mediaController != null)
            {
                mediaController.hide();
            }
            Bundle bundle = new Bundle();
            if (i == 200)
            {
                bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
                mediaplayer = "The video is streamed and its container is not valid for progressive playback i.e the video's index (e.g moov atom) is not at the start of the file.";
            } else
            if (i == 1)
            {
                bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
                mediaplayer = "media file format is not recognized.";
            } else
            if (i == 100)
            {
                bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_IO());
                mediaplayer = "media server has gone away.";
            } else
            {
                bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_IO());
                mediaplayer = "unknown common IO error.";
            }
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), mediaplayer);
            hostRenderer.onAdVideoViewError(bundle);
            return true;
        }

            
            {
                this$0 = VideoAdView.this;
                super();
            }
    };
    private VideoRenderer hostRenderer;
    private MuteState isMuted;
    private Logger logger;
    private int mCurrentState;
    private int mDuration;
    private int mLastPlayheadTime;
    private int mSeekWhenPrepared;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private int mTargetState;
    private int mVideoHeight;
    private int mVideoWidth;
    private MediaController mediaController;
    private MediaPlayer mediaPlayer;
    android.media.MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = new android.media.MediaPlayer.OnBufferingUpdateListener() {

        final VideoAdView this$0;

        public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
        {
        }

            
            {
                this$0 = VideoAdView.this;
                super();
            }
    };
    android.media.MediaPlayer.OnInfoListener onInfoListener = new android.media.MediaPlayer.OnInfoListener() {

        final VideoAdView this$0;

        public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
        {
            logger.debug((new StringBuilder()).append("onInfo(").append(i).append(",").append(j).append(")").toString());
            switch (i)
            {
            default:
                return true;

            case 701: 
                hostRenderer.onAdViewBuffered(false);
                return true;

            case 702: 
                hostRenderer.onAdViewBuffered(true);
                break;
            }
            return true;
        }

            
            {
                this$0 = VideoAdView.this;
                super();
            }
    };
    private final boolean preloadEnabled;
    private boolean preloading;
    android.media.MediaPlayer.OnPreparedListener preparedListener = new android.media.MediaPlayer.OnPreparedListener() {

        final VideoAdView this$0;

        public void onPrepared(MediaPlayer mediaplayer)
        {
            int i;
            logger.debug("OnPrepared");
            mCurrentState = 2;
            if (preloading)
            {
                hostRenderer.onAdViewLoaded();
                return;
            }
            i = mSeekWhenPrepared;
            if (i != 0)
            {
                seekTo(i);
            }
            if (mediaController != null)
            {
                mediaController.setEnabled(true);
            }
            mVideoWidth = mediaplayer.getVideoWidth();
            mVideoHeight = mediaplayer.getVideoHeight();
            logger.debug((new StringBuilder()).append("videoWidth: ").append(mVideoWidth).append(", videoHeight: ").append(mVideoHeight).toString());
            if (mVideoWidth == 0 || mVideoHeight == 0) goto _L2; else goto _L1
_L1:
            getHolder().setFixedSize(mVideoWidth, mVideoHeight);
            if (mSurfaceWidth != mVideoWidth || mSurfaceHeight != mVideoHeight) goto _L4; else goto _L3
_L3:
            if (mTargetState != 3) goto _L6; else goto _L5
_L5:
            start();
            if (mediaController != null)
            {
                mediaController.show();
            }
_L4:
            hostRenderer.onAdViewMediaPrepared();
            return;
_L6:
            if (!isInPlaybackState() && !mediaPlayer.isPlaying() && (i != 0 || getPlayheadTime() > 0.0D) && mediaController != null)
            {
                mediaController.show(0);
            }
            continue; /* Loop/switch isn't completed */
_L2:
            if (mTargetState == 3)
            {
                start();
            }
            if (true) goto _L4; else goto _L7
_L7:
        }

            
            {
                this$0 = VideoAdView.this;
                super();
            }
    };
    private SurfaceHolder surfaceHolder;
    private VideoAdController videoAdController;

    private VideoAdView(Context context, VideoRenderer videorenderer)
    {
        super(context);
        mCurrentState = 0;
        mTargetState = 0;
        surfaceHolder = null;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT > 13)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        preloadEnabled = flag;
        preloading = false;
        logger = Logger.getLogger(this);
        hostRenderer = videorenderer;
        constants = videorenderer.constants;
        initVideoView();
        setOnClickListener(this);
        audioManager = (AudioManager)getContext().getSystemService("audio");
        isMuted = MuteState.UNINITIALIZED;
    }

    public VideoAdView(Context context, VideoRenderer videorenderer, boolean flag)
    {
        this(context, videorenderer);
        Logger logger1 = logger;
        StringBuilder stringbuilder = (new StringBuilder()).append("with");
        if (flag)
        {
            videorenderer = "";
        } else
        {
            videorenderer = "out";
        }
        logger1.debug(stringbuilder.append(videorenderer).append(" MediaController").toString());
        if (flag)
        {
            context = new MediaController(context);
        } else
        {
            context = null;
        }
        mediaController = context;
        mVideoWidth = 0;
        mVideoHeight = 0;
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -1, 17));
        if (!preloadEnabled)
        {
            requestLayout();
        }
    }

    private void initVideoView()
    {
        getHolder().addCallback(this);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        mCurrentState = 0;
        mTargetState = 0;
    }

    private void openVideo()
    {
        if (surfaceHolder == null)
        {
            return;
        }
        release(false);
        try
        {
            mediaPlayer = new MediaPlayer();
            mDuration = -1;
            mediaPlayer.setDisplay(surfaceHolder);
            mediaPlayer.setDataSource(adUrl);
            mediaPlayer.setOnErrorListener(errorListener);
            mediaPlayer.setOnPreparedListener(preparedListener);
            mediaPlayer.setOnInfoListener(onInfoListener);
            mediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
            mediaPlayer.setOnCompletionListener(this);
            mediaPlayer.setOnVideoSizeChangedListener(this);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.setScreenOnWhilePlaying(true);
            mediaPlayer.prepareAsync();
            mCurrentState = 1;
            prepareMediaController();
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.debug(illegalargumentexception.getMessage());
            mCurrentState = -1;
            mTargetState = -1;
            Bundle bundle = new Bundle();
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_INVALID_VALUE());
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), illegalargumentexception.getMessage());
            hostRenderer.onAdVideoViewError(bundle);
            return;
        }
        catch (IOException ioexception)
        {
            mCurrentState = -1;
            mTargetState = -1;
            Bundle bundle1 = new Bundle();
            bundle1.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_IO());
            bundle1.putString(constants.INFO_KEY_ERROR_INFO(), (new StringBuilder()).append("Unable to open content: ").append(adUrl).append(", error: ").append(ioexception.toString()).toString());
            hostRenderer.onAdVideoViewError(bundle1);
            return;
        }
    }

    private void prepareMediaController()
    {
        if (mediaController != null)
        {
            videoAdController = new VideoAdController(hostRenderer, this, mediaPlayer);
            mediaController.setMediaPlayer(videoAdController);
            mediaController.setAnchorView(this);
            mediaController.setEnabled(isInPlaybackState());
        }
    }

    private void release(boolean flag)
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer = null;
            mCurrentState = 0;
            if (flag)
            {
                mTargetState = 0;
            }
        }
    }

    private void startPreloadedVideo()
    {
        mDuration = -1;
        mediaPlayer.setDisplay(surfaceHolder);
        mediaPlayer.setOnErrorListener(errorListener);
        mediaPlayer.setOnCompletionListener(this);
        mediaPlayer.setOnVideoSizeChangedListener(this);
        mediaPlayer.setScreenOnWhilePlaying(true);
        if (mCurrentState == 2)
        {
            preparedListener.onPrepared(mediaPlayer);
            prepareMediaController();
            return;
        } else
        {
            mCurrentState = -1;
            mTargetState = -1;
            Bundle bundle = new Bundle();
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_UNKNOWN());
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), "MediaPlayer should in prepared state when start play");
            hostRenderer.onAdVideoViewError(bundle);
            return;
        }
    }

    private void toggleMediaControlsVisibility()
    {
        if (mediaController == null)
        {
            return;
        }
        if (mediaController.isShowing())
        {
            mediaController.hide();
            return;
        } else
        {
            mediaController.show();
            return;
        }
    }

    public void dispose()
    {
        logger.debug("dispose");
        release(true);
    }

    public double getDuration()
    {
        if (isInPlaybackState())
        {
            if (mDuration > 0)
            {
                return (double)mDuration;
            } else
            {
                mDuration = mediaPlayer.getDuration();
                return (double)mDuration;
            }
        } else
        {
            mDuration = -1;
            return (double)mDuration;
        }
    }

    public double getPlayheadTime()
    {
        if (isInPlaybackState())
        {
            int j = mediaPlayer.getCurrentPosition();
            int i = j;
            if (mLastPlayheadTime > 0)
            {
                if (j == 0)
                {
                    i = mLastPlayheadTime;
                } else
                {
                    mLastPlayheadTime = 0;
                    i = j;
                }
            }
            return (double)i;
        }
        if (mLastPlayheadTime > 0)
        {
            return (double)mLastPlayheadTime;
        } else
        {
            return -1D;
        }
    }

    protected boolean isInPlaybackState()
    {
        return mediaPlayer != null && mCurrentState != -1 && mCurrentState != 0 && mCurrentState != 1 && !preloading;
    }

    protected void loadContent()
    {
        logger.debug("loadContent");
        mediaPlayer = new MediaPlayer();
        try
        {
            mediaPlayer.setDataSource(adUrl);
            mediaPlayer.setOnErrorListener(errorListener);
            mediaPlayer.setOnInfoListener(onInfoListener);
            mediaPlayer.setOnBufferingUpdateListener(onBufferingUpdateListener);
            mediaPlayer.setOnPreparedListener(preparedListener);
            mediaPlayer.setAudioStreamType(3);
            mediaPlayer.prepareAsync();
            mCurrentState = 1;
            preloading = true;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            logger.debug(illegalargumentexception.getMessage());
            mCurrentState = -1;
            mTargetState = -1;
            Bundle bundle = new Bundle();
            bundle.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_INVALID_VALUE());
            bundle.putString(constants.INFO_KEY_ERROR_INFO(), illegalargumentexception.getMessage());
            hostRenderer.onAdVideoViewError(bundle);
            return;
        }
        catch (IOException ioexception)
        {
            mCurrentState = -1;
            mTargetState = -1;
            Bundle bundle1 = new Bundle();
            bundle1.putString(constants.INFO_KEY_ERROR_CODE(), constants.ERROR_IO());
            bundle1.putString(constants.INFO_KEY_ERROR_INFO(), (new StringBuilder()).append("Unable to open content: ").append(adUrl).append(", error: ").append(ioexception.toString()).toString());
            hostRenderer.onAdVideoViewError(bundle1);
            return;
        }
    }

    public void onClick(View view)
    {
        if (mediaController != null)
        {
            toggleMediaControlsVisibility();
            return;
        }
        if (isInPlaybackState())
        {
            hostRenderer.onAdViewClicked();
            return;
        } else
        {
            logger.debug((new StringBuilder()).append("ignore click if not in playback state, current state ").append(mCurrentState).toString());
            return;
        }
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        logger.debug("video completion");
        mCurrentState = 5;
        mTargetState = 5;
        if (mediaController != null)
        {
            mediaController.hide();
        }
        hostRenderer.onAdVideoViewComplete();
    }

    protected void onImprTimer()
    {
        int i = audioManager.getStreamVolume(3);
        MuteState mutestate;
        if (isMuted == MuteState.MUTED)
        {
            if (i > 0)
            {
                hostRenderer.onAdUnMuted();
            }
        } else
        if (isMuted == MuteState.UNMUTED && i == 0)
        {
            hostRenderer.onAdMuted();
        }
        if (i > 0)
        {
            mutestate = MuteState.UNMUTED;
        } else
        {
            mutestate = MuteState.MUTED;
        }
        isMuted = mutestate;
        if (videoAdController != null)
        {
            videoAdController.onImprTimer();
        }
    }

    protected void onMeasure(int i, int j)
    {
        int k;
        int l;
        k = getDefaultSize(mVideoWidth, i);
        l = getDefaultSize(mVideoHeight, j);
        i = l;
        j = k;
        if (mVideoWidth <= 0) goto _L2; else goto _L1
_L1:
        i = l;
        j = k;
        if (mVideoHeight <= 0) goto _L2; else goto _L3
_L3:
        if (mVideoWidth * l <= mVideoHeight * k) goto _L5; else goto _L4
_L4:
        i = (mVideoHeight * k) / mVideoWidth;
        j = k;
_L2:
        logger.debug((new StringBuilder()).append("onMeasure width: ").append(j).append(" height: ").append(i).toString());
        setMeasuredDimension(j, i);
        return;
_L5:
        i = l;
        j = k;
        if (mVideoWidth * l < mVideoHeight * k)
        {
            j = (mVideoWidth * l) / mVideoHeight;
            i = l;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        logger.debug((new StringBuilder()).append("onVideoSizeChanged width: ").append(i).append(" height: ").append(j).toString());
        mVideoWidth = mediaplayer.getVideoWidth();
        mVideoHeight = mediaplayer.getVideoHeight();
        if (mVideoWidth != 0 && mVideoHeight != 0)
        {
            getHolder().setFixedSize(mVideoWidth, mVideoHeight);
        }
    }

    public void pause()
    {
        logger.debug("pause");
        if (isInPlaybackState() && mediaPlayer.isPlaying())
        {
            mSeekWhenPrepared = mediaPlayer.getCurrentPosition();
            mLastPlayheadTime = mSeekWhenPrepared;
            mediaPlayer.pause();
            mCurrentState = 4;
        }
        mTargetState = 4;
    }

    public void seekTo(int i)
    {
        logger.debug((new StringBuilder()).append("seekTo : ").append(i).toString());
        if (isInPlaybackState())
        {
            mediaPlayer.seekTo(i);
            mSeekWhenPrepared = 0;
            return;
        } else
        {
            mSeekWhenPrepared = i;
            return;
        }
    }

    public void setAdUrl(String s)
    {
        adUrl = s;
    }

    public void start()
    {
        logger.debug("start");
        if (isInPlaybackState())
        {
            mediaPlayer.start();
            mCurrentState = 3;
        }
        mTargetState = 3;
    }

    public void startPlayback()
    {
        logger.debug("startPlayback");
        start();
        hostRenderer.onAdViewStart();
    }

    public void stop()
    {
        logger.debug("stop");
        if (isInPlaybackState())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
            mCurrentState = 0;
            mTargetState = 0;
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        logger.debug((new StringBuilder()).append("surfaceChanged w:").append(j).append(" h:").append(k).toString());
        mSurfaceWidth = j;
        mSurfaceHeight = k;
        if (mTargetState == 3)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (mVideoWidth == j && mVideoHeight == k)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (mediaPlayer != null && i != 0 && j != 0)
        {
            if (mSeekWhenPrepared != 0)
            {
                seekTo(mSeekWhenPrepared);
            }
            start();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        logger.debug("surfaceCreated");
        surfaceHolder = surfaceholder;
        if (preloading)
        {
            preloading = false;
            startPreloadedVideo();
            return;
        } else
        {
            openVideo();
            return;
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        logger.debug("surfaceDestroyed");
        surfaceHolder = null;
        if (mediaController != null)
        {
            mediaController.hide();
        }
        if (hostRenderer != null)
        {
            hostRenderer.onAdViewSurfaceDestroyed();
        }
        dispose();
    }

    public void tryToGetRedirectedUrl(final String url, final int timeoutMs)
    {
        (new Thread(new Runnable() {

            final VideoAdView this$0;
            final int val$timeoutMs;
            final String val$url;

            public void run()
            {
                Object obj;
                HttpURLConnection httpurlconnection;
                Object obj2;
                Object obj3;
                obj3 = null;
                adUrl = url;
                obj2 = null;
                obj = null;
                httpurlconnection = null;
                HttpURLConnection httpurlconnection1 = (HttpURLConnection)(new URL(url)).openConnection();
                httpurlconnection = httpurlconnection1;
                obj2 = httpurlconnection1;
                obj = httpurlconnection1;
                httpurlconnection1.setConnectTimeout(timeoutMs);
                httpurlconnection = httpurlconnection1;
                obj2 = httpurlconnection1;
                obj = httpurlconnection1;
                httpurlconnection1.setReadTimeout(timeoutMs);
                httpurlconnection = httpurlconnection1;
                obj2 = httpurlconnection1;
                obj = httpurlconnection1;
                httpurlconnection1.setInstanceFollowRedirects(false);
                httpurlconnection = httpurlconnection1;
                obj2 = httpurlconnection1;
                obj = httpurlconnection1;
                if (httpurlconnection1.getResponseCode() != 302)
                {
                    break MISSING_BLOCK_LABEL_156;
                }
                httpurlconnection = httpurlconnection1;
                obj2 = httpurlconnection1;
                obj = httpurlconnection1;
                logger.debug("tryToGetRedirectedUrl asset url is a redirect url");
                httpurlconnection = httpurlconnection1;
                obj2 = httpurlconnection1;
                obj = httpurlconnection1;
                adUrl = httpurlconnection1.getHeaderField("Location");
                httpurlconnection1.disconnect();
                obj = obj3;
_L1:
                if (adUrl == null)
                {
                    adUrl = url;
                }
                hostRenderer.onRedirectUrlChecked(adUrl, ((Exception) (obj)));
                return;
                obj2;
                obj = httpurlconnection;
                logger.warn((new StringBuilder()).append("tryToGetRedirectedUrl MalformedURLException for url:").append(url).toString());
                httpurlconnection.disconnect();
                obj = obj2;
                  goto _L1
                Object obj1;
                obj1;
                obj = obj2;
                logger.warn((new StringBuilder()).append("tryToGetRedirectedUrl IOException for url:").append(url).toString());
                ((HttpURLConnection) (obj2)).disconnect();
                obj = obj1;
                  goto _L1
                obj1;
                ((HttpURLConnection) (obj)).disconnect();
                throw obj1;
            }

            
            {
                this$0 = VideoAdView.this;
                url = s;
                timeoutMs = i;
                super();
            }
        })).start();
    }




/*
    static int access$102(VideoAdView videoadview, int i)
    {
        videoadview.mCurrentState = i;
        return i;
    }

*/




/*
    static String access$1202(VideoAdView videoadview, String s)
    {
        videoadview.adUrl = s;
        return s;
    }

*/



/*
    static int access$202(VideoAdView videoadview, int i)
    {
        videoadview.mTargetState = i;
        return i;
    }

*/







/*
    static int access$702(VideoAdView videoadview, int i)
    {
        videoadview.mVideoWidth = i;
        return i;
    }

*/



/*
    static int access$802(VideoAdView videoadview, int i)
    {
        videoadview.mVideoHeight = i;
        return i;
    }

*/

}
