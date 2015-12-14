// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.amazon.gallery.foundation.gfx.ScaleMode;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.log.Logger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.senna.SennaMediaType;
import com.amazon.gallery.framework.gallery.messaging.VideoViewerErrorEvent;
import com.amazon.gallery.framework.gallery.video.captioning.GalleryCaptioningManager;
import com.amazon.gallery.framework.gallery.video.player.ErrorCodeResolver;
import com.amazon.gallery.framework.gallery.video.player.VideoQuality;
import com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.activity.WhisperPlayActivity;
import com.amazon.gallery.framework.kindle.amazon.KindleFrameworkDependencyInjector;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.Video;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.thor.app.FeatureChecker;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.video.GalleryMediaControllerWrapper;
import com.amazon.gallery.thor.video.ThorCaptioningManager;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;
import com.amazon.gallery.thor.view.PhotosNavigationPane;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            LockscreenPlaybackManager, GalleryVideoView, VideoMetrics, GalleryMediaController

public class GalleryVideoViewer extends RelativeLayout
    implements android.media.AudioManager.OnAudioFocusChangeListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, GalleryMediaController.OnBackKeyPressedListener, GalleryMediaController.OnVisibilityChangeListener, SingleViewMediaPlayer, WhisperPlayActivity
{

    private static final String TAG = com/amazon/gallery/framework/gallery/video/GalleryVideoViewer.getName();
    protected final GalleryCaptioningManager captioningManager;
    protected Context context;
    private GalleryMediaController controller;
    private final GalleryVideoView.PlaybackListener defaultPlaybackListener = new GalleryVideoView.PlaybackListener() {

        private long playTime;
        private boolean playing;
        private long resumeTimestamp;
        final GalleryVideoViewer this$0;

        public void pause()
        {
            setPlayButtonVisibility(0);
            if (playing)
            {
                playTime = playTime + (SystemClock.uptimeMillis() - resumeTimestamp);
                playing = false;
            }
            if (videoView.getCurrentPosition() > 0)
            {
                stopPosition = videoView.getCurrentPosition();
            }
            GLogger.i(GalleryVideoViewer.TAG, "Video pause", new Object[0]);
        }

        public void resume()
        {
            resumeTimestamp = SystemClock.uptimeMillis();
            playing = true;
            GLogger.i(GalleryVideoViewer.TAG, "Video resume", new Object[0]);
        }

        public void start()
        {
            lockscreenPlaybackManager.start();
            VideoView videoview = getVideoView();
            if (videoview.getDuration() == -1)
            {
                videoview.seekTo(stopPosition);
            } else
            if (videoview.getCurrentPosition() >= videoview.getDuration())
            {
                videoview.seekTo(0);
            }
            if (mediaPlayer != null)
            {
                requestAudioFocus();
            }
            if (!videoview.isPlaying() && mediaItem != null)
            {
                mVideoMetrics.videoStartPlaying(mediaItem);
            }
            if (videoview.isPlaying())
            {
                progress.setVisibility(8);
            } else
            {
                progress.setVisibility(0);
            }
            resumeTimestamp = SystemClock.uptimeMillis();
            playing = true;
            setPlayButtonVisibility(8);
            if (!mScreenModeManager.isFullScreen())
            {
                getController().show(0, false, true);
            }
            GLogger.i(GalleryVideoViewer.TAG, "Video start", new Object[0]);
        }

        public void stopPlayback()
        {
            if (playing)
            {
                playTime = playTime + (SystemClock.uptimeMillis() - resumeTimestamp);
                playing = false;
            }
            mVideoMetrics.videoEndPlaying(mediaItem, playTime);
            lockscreenPlaybackManager.shutdown();
            GLogger.i(GalleryVideoViewer.TAG, "Video stop playback", new Object[0]);
        }

        public void suspend()
        {
            if (playing)
            {
                playTime = playTime + (SystemClock.uptimeMillis() - resumeTimestamp);
                playing = false;
            }
            GLogger.i(GalleryVideoViewer.TAG, "Video suspend", new Object[0]);
        }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
    };
    protected FeatureChecker featureChecker;
    private boolean isDestroyed;
    private LockscreenPlaybackManager lockscreenPlaybackManager;
    private boolean mHasAudioFocus;
    private ScreenModeManager mScreenModeManager;
    private com.amazon.gallery.thor.view.PhotosNavigationPane.SidePanelListener mSidePanelListener;
    private android.view.View.OnTouchListener mTouchListener;
    private VideoMetrics mVideoMetrics;
    protected MediaItem mediaItem;
    private MediaPlayer mediaPlayer;
    private final android.media.MediaPlayer.OnErrorListener onErrorListener = new android.media.MediaPlayer.OnErrorListener() {

        final GalleryVideoViewer this$0;

        public boolean onError(MediaPlayer mediaplayer, int i, int j)
        {
            GLogger.e(GalleryVideoViewer.TAG, "MediaPlayer err: %d, extra: %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
            if (MediaItemUtil.isLocalMediaItem(mediaItem))
            {
                mediaplayer = GalleryVideoViewer.getExtension(mediaItem.getLocalPath());
                if (mediaplayer != null)
                {
                    mVideoMetrics.playError(mediaplayer);
                }
            }
            if (playerObserver != null)
            {
                playerObserver.onVideoError();
            }
            return displayErrorDialogue(ErrorCodeResolver.resolve(i, j));
        }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
    };
    protected ImageView playButton;
    private com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer.PlayerObserver playerObserver;
    private ProgressBar progress;
    private RestClient restClient;
    private int stopPosition;
    private Runnable toggleScreenModeRunnable;
    private GalleryVideoView videoView;

    public GalleryVideoViewer(Context context1)
    {
        super(context1);
        mHasAudioFocus = false;
        mTouchListener = new android.view.View.OnTouchListener() {

            final GalleryVideoViewer this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                toggleController();
                return false;
            }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
        };
        mSidePanelListener = new NoOpSidePanelListener() {

            final GalleryVideoViewer this$0;

            public void onClosed()
            {
                ((MediaController)getController()).setVisibility(0);
            }

            public void onDragged()
            {
                ((MediaController)getController()).setVisibility(4);
            }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
        };
        context = context1;
        LayoutInflater.from(context1).inflate(0x7f0300f3, this, true);
        progress = (ProgressBar)findViewById(0x7f0c020a);
        setupVideoView();
        setupPlayButton();
        resetMediaControllerPadding();
        lockscreenPlaybackManager = new LockscreenPlaybackManager(this);
        captioningManager = new ThorCaptioningManager(context1);
        KindleFrameworkDependencyInjector.inject(this);
    }

    private static String getExtension(String s)
    {
        int i;
        if (s != null)
        {
            if ((i = s.lastIndexOf(".")) != -1)
            {
                return s.substring(i + 1);
            }
        }
        return null;
    }

    private void requestAudioFocus()
    {
        if (mHasAudioFocus)
        {
            return;
        }
        GLogger.i(TAG, "Request audio focus", new Object[0]);
        int i = ((AudioManager)getContext().getSystemService("audio")).requestAudioFocus(this, 3, 1);
        if (i == 1)
        {
            mHasAudioFocus = true;
            GLogger.i(TAG, "Audio focus requested and gain", new Object[0]);
            setVolume(1.0F, 1.0F);
            return;
        } else
        {
            GLogger.e(TAG, "Couldn't gain audio focus with result %d", new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
    }

    private void resetMediaControllerPadding()
    {
        View view = (View)getController();
        int i;
        if (Api.isAtLeastJellyBean())
        {
            i = (int)getContext().getResources().getDimension(0x7f0a0050);
        } else
        {
            i = 0;
        }
        switch (getResources().getConfiguration().orientation)
        {
        default:
            return;

        case 2: // '\002'
            view.setPadding(0, 0, i, 0);
            return;

        case 1: // '\001'
            view.setPadding(0, 0, 0, 0);
            return;
        }
    }

    private void setClosedCaptioning(String s)
    {
        captioningManager.setSubtitleSource(videoView, s);
    }

    private void setVolume(float f, float f1)
    {
        if (mediaPlayer == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        mediaPlayer.setVolume(f, f1);
        return;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        GLogger.wx(TAG, "Can't adjust mediaplayer volume", illegalstateexception);
        return;
    }

    private void setupPlayButton()
    {
        playButton = (ImageView)findViewById(0x7f0c0206);
        playButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GalleryVideoViewer this$0;

            public void onClick(View view)
            {
                if (MediaItemUtil.isVideoCorrupted((Video)mediaItem))
                {
                    displayErrorDialogue(0x7f0e022a);
                    stopVideoPlayer();
                    return;
                } else
                {
                    videoView.start();
                    return;
                }
            }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
        });
    }

    protected void addPlaybackListener(GalleryVideoView.PlaybackListener playbacklistener)
    {
        videoView.addPlaybackListener(playbacklistener);
    }

    protected GalleryMediaController createController()
    {
        return new GalleryMediaControllerWrapper(getContext());
    }

    public void destroy()
    {
        mVideoMetrics.preloadEnded();
        mVideoMetrics.rebufferEnded();
        mVideoMetrics.bufferEnded();
        videoView.stopPlayback();
        videoView.clearPlaybackListeners();
        controller.clearListeners();
        ((AudioManager)getContext().getSystemService("audio")).abandonAudioFocus(this);
        videoView.setOnPreparedListener(null);
        videoView.setOnErrorListener(null);
        videoView.setOnCompletionListener(null);
        Context context1 = getContext();
        if (context1 instanceof NativeGalleryActivity)
        {
            ((NativeGalleryActivity)context1).getNavPane().removeSidePanelListener(mSidePanelListener);
        }
        isDestroyed = true;
    }

    protected boolean displayErrorDialogue(int i)
    {
        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(getContext());
        builder.setMessage(i);
        builder.setPositiveButton(0x7f0e0093, new android.content.DialogInterface.OnClickListener() {

            final GalleryVideoViewer this$0;

            public void onClick(DialogInterface dialoginterface, int j)
            {
                destroy();
                GlobalMessagingBus.post(new VideoViewerErrorEvent());
            }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
        });
        builder.setCancelable(false);
        builder.create().show();
        return true;
    }

    protected GalleryMediaController getController()
    {
        return controller;
    }

    public int getDisplayDelayMS()
    {
        return 0;
    }

    public MediaItem getMediaItem()
    {
        return mediaItem;
    }

    protected VideoView getVideoView()
    {
        return videoView;
    }

    public void hide()
    {
        if (!((Activity)getContext()).isFinishing() && !isDestroyed)
        {
            toggleScreenModeRunnable.run();
        }
    }

    protected boolean isPlaying()
    {
        return videoView.isPlaying();
    }

    public boolean isWhisperPlayModeEnabled()
    {
        return false;
    }

    public void loadVideoURL(ObjectID objectid, int i, int j)
    {
        com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler resulthandler;
        int k;
        int l;
        resulthandler = new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

            final GalleryVideoViewer this$0;

            public void onFailure(TerminalException terminalexception)
            {
                videoView.post(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        onURLLoadFailure();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((String)obj);
            }

            public void onSuccess(String s)
            {
                videoView.post(s. new Runnable() {

                    final _cls2 this$1;
                    final String val$url;

                    public void run()
                    {
                        onURLLoadSuccess(url);
                    }

            
            {
                this$1 = final__pcls2;
                url = String.this;
                super();
            }
                });
            }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
        };
        k = i;
        l = j;
        static class _cls9
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality = new int[VideoQuality.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._360P.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._480P.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._720P.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$video$player$VideoQuality[VideoQuality._AUTO.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls9..SwitchMap.com.amazon.gallery.framework.gallery.video.player.VideoQuality[VideoQuality.CURRENT_QUALITY.ordinal()];
        JVM INSTR tableswitch 1 4: default 124
    //                   1 86
    //                   2 86
    //                   3 86
    //                   4 56;
           goto _L1 _L2 _L2 _L2 _L3
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        break MISSING_BLOCK_LABEL_124;
_L4:
        objectid = restClient.getMediaItemURLOperation(objectid, SennaMediaType.VIDEO, k, l, ScaleMode.SCALE_TO_FIT);
        NetworkExecutor.getInstance().executeForeground(objectid, resulthandler);
        return;
_L2:
        try
        {
            k = VideoQuality.CURRENT_QUALITY.getWidth();
            l = VideoQuality.CURRENT_QUALITY.getHeight();
        }
        // Misplaced declaration of an exception variable
        catch (ObjectID objectid)
        {
            Logger.e(TAG, "Can't get video URL", new Object[] {
                objectid
            });
            return;
        }
          goto _L4
        k = i;
        l = j;
          goto _L4
    }

    public void onAudioFocusChange(int i)
    {
        switch (i)
        {
        case 0: // '\0'
        default:
            return;

        case 1: // '\001'
            mHasAudioFocus = true;
            GLogger.i(TAG, "Audio focus gain", new Object[0]);
            setVolume(1.0F, 1.0F);
            return;

        case -1: 
            mHasAudioFocus = false;
            GLogger.i(TAG, "Audio focus loss unbounded, pausing playback", new Object[0]);
            pauseVideo();
            setVolume(0.0F, 0.0F);
            return;

        case -2: 
            mHasAudioFocus = false;
            GLogger.i(TAG, "Audio focus loss transient", new Object[0]);
            setVolume(0.0F, 0.0F);
            return;

        case -3: 
            mHasAudioFocus = false;
            GLogger.i(TAG, "Audio focus loss, can duck", new Object[0]);
            setVolume(0.1F, 0.1F);
            return;
        }
    }

    public boolean onBackKeyPressed()
    {
        videoView.stopPlayback();
        if (!((Activity)getContext()).isFinishing() && !isDestroyed)
        {
            try
            {
                ((Activity)getContext()).onBackPressed();
            }
            catch (IllegalStateException illegalstateexception)
            {
                GLogger.ex(TAG, "Unable to call the activity's onBackPressed", illegalstateexception);
            }
        }
        controller.removeBackKeyPressedListener(this);
        return true;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        setPlayButtonVisibility(0);
        getController().show();
        if (playerObserver != null)
        {
            playerObserver.onVideoCompletion();
        }
    }

    public void onConfigChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        resetMediaControllerPadding();
    }

    public void onHideController()
    {
    }

    public void onPause()
    {
        lockscreenPlaybackManager.onPause();
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mVideoMetrics.preloadEnded();
        mVideoMetrics.bufferEnded();
        mVideoMetrics.rebufferEnded();
        mediaPlayer = mediaplayer;
        progress.setVisibility(8);
        mediaPlayer.setOnInfoListener(new android.media.MediaPlayer.OnInfoListener() {

            final GalleryVideoViewer this$0;

            public boolean onInfo(MediaPlayer mediaplayer1, int i, int j)
            {
                GLogger.v(GalleryVideoViewer.TAG, "MediaInfo: (%d, %d)", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(j)
                });
                switch (i)
                {
                default:
                    return false;

                case 701: 
                    GLogger.d(GalleryVideoViewer.TAG, "MediaPlayer buffering: start", new Object[0]);
                    mVideoMetrics.rebufferStarted();
                    progress.setVisibility(0);
                    return false;

                case 702: 
                    GLogger.d(GalleryVideoViewer.TAG, "MediaPlayer buffering: end", new Object[0]);
                    mVideoMetrics.rebufferEnded();
                    progress.setVisibility(8);
                    return false;

                case 3: // '\003'
                    progress.setVisibility(8);
                    return false;
                }
            }

            
            {
                this$0 = GalleryVideoViewer.this;
                super();
            }
        });
    }

    public void onResume()
    {
        lockscreenPlaybackManager.onResume();
    }

    protected void onURLLoadFailure()
    {
        if (mediaItem.getType() == MediaType.VIDEO && ((Video)mediaItem).getDuration() >= TimeUnit.MINUTES.toMillis(20L))
        {
            onErrorListener.onError(mediaPlayer, 1, 1010);
            GLogger.i(TAG, "Failed to load video URL from Cloud Drive because video duration > 20 minutes", new Object[0]);
            return;
        } else
        {
            onErrorListener.onError(mediaPlayer, 1, -1004);
            GLogger.i(TAG, "Failed to load video URL from Cloud Drive", new Object[0]);
            return;
        }
    }

    protected void onURLLoadSuccess(String s)
    {
        videoView.setVideoURI(Uri.parse(s));
        videoView.start();
        mVideoMetrics.bufferStarted();
    }

    public void onWindowFocusChanged(boolean flag)
    {
        lockscreenPlaybackManager.onWindowFocusChanged(flag);
        super.onWindowFocusChanged(flag);
    }

    public void pauseVideo()
    {
        videoView.pause();
    }

    public void resumeVideo()
    {
        videoView.start();
    }

    public void resumeVideoPlayer()
    {
        videoView.seekTo(stopPosition);
    }

    public void setFeatureChecker(FeatureChecker featurechecker)
    {
        featureChecker = featurechecker;
    }

    public void setMediaItem(MediaItem mediaitem)
    {
        mediaItem = mediaitem;
        if (MediaItemUtil.isLocalMediaItem(mediaitem))
        {
            if (MediaItemUtil.isVideoCorrupted((Video)mediaitem))
            {
                displayErrorDialogue(0x7f0e022a);
                stopVideoPlayer();
            } else
            {
                setClosedCaptioning(mediaitem.getLocalPath());
                onURLLoadSuccess(mediaitem.getLocalPath());
            }
        } else
        {
            if (((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).promptIfOffline(context))
            {
                stopVideoPlayer();
                return;
            }
            loadVideoURL(mediaitem.getObjectId(), getWidth(), getHeight());
        }
        mVideoMetrics.preloadStarted();
    }

    protected void setPlayButtonVisibility(int i)
    {
        playButton.setVisibility(i);
    }

    public void setPlayerObserver(com.amazon.gallery.framework.gallery.view.android.SingleViewMediaPlayer.PlayerObserver playerobserver)
    {
        if (playerobserver != null)
        {
            playerObserver = playerobserver;
            playerobserver.onMediaReady(mediaItem);
        }
    }

    public void setProfiler(Profiler profiler)
    {
        mVideoMetrics = new VideoMetrics(profiler);
    }

    public void setRestClient(RestClient restclient)
    {
        restClient = restclient;
    }

    public void setScreenModeManager(ScreenModeManager screenmodemanager)
    {
        mScreenModeManager = screenmodemanager;
    }

    public void setToggleScreenModeRunnable(Runnable runnable)
    {
        toggleScreenModeRunnable = runnable;
    }

    protected void setupVideoView()
    {
        videoView = (GalleryVideoView)findViewById(0x7f0c0209);
        controller = createController();
        controller.addOnVisibilityChangeListener(this);
        controller.addBackKeyPressedListener(this);
        videoView.setMediaController((MediaController)controller);
        videoView.setOnPreparedListener(this);
        videoView.setOnErrorListener(onErrorListener);
        videoView.setOnCompletionListener(this);
        addPlaybackListener(defaultPlaybackListener);
        ((View)videoView.getParent()).setOnTouchListener(mTouchListener);
        Context context1 = getContext();
        if (context1 instanceof NativeGalleryActivity)
        {
            ((NativeGalleryActivity)context1).getNavPane().addSidePanelListener(mSidePanelListener);
        }
    }

    public void show()
    {
        toggleScreenModeRunnable.run();
        getVideoView().requestLayout();
    }

    public void shutDown()
    {
        videoView.stopPlayback();
    }

    public void stopVideoPlayer()
    {
        videoView.stopPlayback();
        if (playerObserver != null)
        {
            playerObserver.onVideoCompletion();
        }
    }

    protected void toggleController()
    {
        MediaController mediacontroller = (MediaController)getController();
        if (mediacontroller.isShowing())
        {
            mediacontroller.hide();
            return;
        } else
        {
            mediacontroller.show();
            return;
        }
    }







/*
    static int access$202(GalleryVideoViewer galleryvideoviewer, int i)
    {
        galleryvideoviewer.stopPosition = i;
        return i;
    }

*/







}
