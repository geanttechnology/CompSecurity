// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.VideoView;
import com.mopub.common.Preconditions;
import com.mopub.common.UrlAction;
import com.mopub.common.UrlHandler;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseVideoViewController;
import com.mopub.mobileads.VastVideoConfig;

// Referenced classes of package com.mopub.nativeads:
//            NativeFullScreenVideoView, NativeVideoController

public class NativeVideoViewController extends BaseVideoViewController
    implements android.view.TextureView.SurfaceTextureListener, NativeVideoController.Listener, android.media.AudioManager.OnAudioFocusChangeListener
{
    static final class VideoState extends Enum
    {

        private static final VideoState $VALUES[];
        public static final VideoState BUFFERING;
        public static final VideoState ENDED;
        public static final VideoState FAILED_LOAD;
        public static final VideoState LOADING;
        public static final VideoState NONE;
        public static final VideoState PAUSED;
        public static final VideoState PLAYING;

        public static VideoState valueOf(String s)
        {
            return (VideoState)Enum.valueOf(com/mopub/nativeads/NativeVideoViewController$VideoState, s);
        }

        public static VideoState[] values()
        {
            return (VideoState[])$VALUES.clone();
        }

        static 
        {
            NONE = new VideoState("NONE", 0);
            LOADING = new VideoState("LOADING", 1);
            BUFFERING = new VideoState("BUFFERING", 2);
            PAUSED = new VideoState("PAUSED", 3);
            PLAYING = new VideoState("PLAYING", 4);
            ENDED = new VideoState("ENDED", 5);
            FAILED_LOAD = new VideoState("FAILED_LOAD", 6);
            $VALUES = (new VideoState[] {
                NONE, LOADING, BUFFERING, PAUSED, PLAYING, ENDED, FAILED_LOAD
            });
        }

        private VideoState(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String NATIVE_VAST_VIDEO_CONFIG = "native_vast_video_config";
    public static final String NATIVE_VIDEO_ID = "native_video_id";
    private Bitmap mCachedVideoFrame;
    private boolean mEnded;
    private boolean mError;
    private final NativeFullScreenVideoView mFullScreenVideoView;
    private int mLatestVideoControllerState;
    private final NativeVideoController mNativeVideoController;
    private VastVideoConfig mVastVideoConfig;
    private VideoState mVideoState;

    public NativeVideoViewController(Context context, Bundle bundle, Bundle bundle1, com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener basevideoviewcontrollerlistener)
    {
        this(context, bundle, bundle1, basevideoviewcontrollerlistener, new NativeFullScreenVideoView(context, context.getResources().getConfiguration().orientation, ((VastVideoConfig)bundle.get("native_vast_video_config")).getCustomCtaText()));
    }

    NativeVideoViewController(Context context, Bundle bundle, Bundle bundle1, com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener basevideoviewcontrollerlistener, NativeFullScreenVideoView nativefullscreenvideoview)
    {
        super(context, null, basevideoviewcontrollerlistener);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotNull(basevideoviewcontrollerlistener);
        Preconditions.checkNotNull(nativefullscreenvideoview);
        mVideoState = VideoState.NONE;
        mVastVideoConfig = (VastVideoConfig)bundle.get("native_vast_video_config");
        mFullScreenVideoView = nativefullscreenvideoview;
        mNativeVideoController = NativeVideoController.getForId(((Long)bundle.get("native_video_id")).longValue());
        Preconditions.checkNotNull(mVastVideoConfig);
        Preconditions.checkNotNull(mNativeVideoController);
    }

    private void maybeChangeState()
    {
        VideoState videostate = mVideoState;
        if (!mError) goto _L2; else goto _L1
_L1:
        videostate = VideoState.FAILED_LOAD;
_L4:
        applyState(videostate);
        return;
_L2:
        if (mEnded)
        {
            videostate = VideoState.ENDED;
        } else
        if (mLatestVideoControllerState == 2 || mLatestVideoControllerState == 1)
        {
            videostate = VideoState.LOADING;
        } else
        if (mLatestVideoControllerState == 3)
        {
            videostate = VideoState.BUFFERING;
        } else
        if (mLatestVideoControllerState == 4)
        {
            videostate = VideoState.PLAYING;
        } else
        if (mLatestVideoControllerState == 5 || mLatestVideoControllerState == 6)
        {
            videostate = VideoState.ENDED;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void applyState(VideoState videostate)
    {
        applyState(videostate, false);
    }

    void applyState(VideoState videostate, boolean flag)
    {
        Preconditions.checkNotNull(videostate);
        if (mVideoState == videostate)
        {
            return;
        }
        static class _cls6
        {

            static final int $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[];

            static 
            {
                $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState = new int[VideoState.values().length];
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[VideoState.FAILED_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[VideoState.LOADING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[VideoState.BUFFERING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[VideoState.PLAYING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[VideoState.PAUSED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeVideoViewController$VideoState[VideoState.ENDED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6..SwitchMap.com.mopub.nativeads.NativeVideoViewController.VideoState[videostate.ordinal()];
        JVM INSTR tableswitch 1 6: default 60
    //                   1 66
    //                   2 116
    //                   3 116
    //                   4 137
    //                   5 174
    //                   6 207;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L6
_L1:
        mVideoState = videostate;
        return;
_L2:
        mNativeVideoController.setPlayWhenReady(false);
        mNativeVideoController.setAudioEnabled(false);
        mNativeVideoController.setAppAudioEnabled(false);
        mFullScreenVideoView.setMode(NativeFullScreenVideoView.Mode.LOADING);
        mVastVideoConfig.handleError(getContext(), null, 0);
        continue; /* Loop/switch isn't completed */
_L3:
        mNativeVideoController.setPlayWhenReady(true);
        mFullScreenVideoView.setMode(NativeFullScreenVideoView.Mode.LOADING);
        continue; /* Loop/switch isn't completed */
_L4:
        mNativeVideoController.setPlayWhenReady(true);
        mNativeVideoController.setAudioEnabled(true);
        mNativeVideoController.setAppAudioEnabled(true);
        mFullScreenVideoView.setMode(NativeFullScreenVideoView.Mode.PLAYING);
        continue; /* Loop/switch isn't completed */
_L5:
        if (!flag)
        {
            mNativeVideoController.setAppAudioEnabled(false);
        }
        mNativeVideoController.setPlayWhenReady(false);
        mFullScreenVideoView.setMode(NativeFullScreenVideoView.Mode.PAUSED);
        continue; /* Loop/switch isn't completed */
_L6:
        mEnded = true;
        mNativeVideoController.setAppAudioEnabled(false);
        mFullScreenVideoView.updateProgress(1000);
        mFullScreenVideoView.setMode(NativeFullScreenVideoView.Mode.FINISHED);
        mVastVideoConfig.handleComplete(getContext(), 0);
        if (true) goto _L1; else goto _L7
_L7:
    }

    NativeFullScreenVideoView getNativeFullScreenVideoView()
    {
        return mFullScreenVideoView;
    }

    VideoState getVideoState()
    {
        return mVideoState;
    }

    protected VideoView getVideoView()
    {
        return null;
    }

    public void onAudioFocusChange(int i)
    {
        if (i == -1 || i == -2)
        {
            applyState(VideoState.PAUSED);
        } else
        {
            if (i == -3)
            {
                mNativeVideoController.setAudioVolume(0.3F);
                return;
            }
            if (i == 1)
            {
                mNativeVideoController.setAudioVolume(1.0F);
                maybeChangeState();
                return;
            }
        }
    }

    protected void onBackPressed()
    {
        applyState(VideoState.PAUSED, true);
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        mFullScreenVideoView.setOrientation(configuration.orientation);
    }

    protected void onCreate()
    {
        mFullScreenVideoView.setSurfaceTextureListener(this);
        mFullScreenVideoView.setMode(NativeFullScreenVideoView.Mode.LOADING);
        mFullScreenVideoView.setPlayControlClickListener(new android.view.View.OnClickListener() {

            final NativeVideoViewController this$0;

            public void onClick(View view)
            {
                if (mEnded)
                {
                    mEnded = false;
                    mFullScreenVideoView.resetProgress();
                    mNativeVideoController.seekTo(0L);
                }
                applyState(VideoState.PLAYING);
            }

            
            {
                this$0 = NativeVideoViewController.this;
                super();
            }
        });
        mFullScreenVideoView.setCloseControlListener(new android.view.View.OnClickListener() {

            final NativeVideoViewController this$0;

            public void onClick(View view)
            {
                applyState(VideoState.PAUSED, true);
                getBaseVideoViewControllerListener().onFinish();
            }

            
            {
                this$0 = NativeVideoViewController.this;
                super();
            }
        });
        mFullScreenVideoView.setCtaClickListener(new android.view.View.OnClickListener() {

            final NativeVideoViewController this$0;

            public void onClick(View view)
            {
                mNativeVideoController.setPlayWhenReady(false);
                mCachedVideoFrame = mFullScreenVideoView.getTextureView().getBitmap();
                mNativeVideoController.handleCtaClick((Activity)getContext());
            }

            
            {
                this$0 = NativeVideoViewController.this;
                super();
            }
        });
        mFullScreenVideoView.setPrivacyInformationClickListener(new android.view.View.OnClickListener() {

            final NativeVideoViewController this$0;

            public void onClick(View view)
            {
                mNativeVideoController.setPlayWhenReady(false);
                mCachedVideoFrame = mFullScreenVideoView.getTextureView().getBitmap();
                (new com.mopub.common.UrlHandler.Builder()).withSupportedUrlActions(UrlAction.OPEN_IN_APP_BROWSER, new UrlAction[0]).build().handleUrl(getContext(), "https://www.mopub.com/optout/");
            }

            
            {
                this$0 = NativeVideoViewController.this;
                super();
            }
        });
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(-1, -1);
        mFullScreenVideoView.setLayoutParams(layoutparams);
        getBaseVideoViewControllerListener().onSetContentView(mFullScreenVideoView);
        mNativeVideoController.setProgressListener(new NativeVideoController.NativeVideoProgressRunnable.ProgressListener() {

            final NativeVideoViewController this$0;

            public void updateProgress(int i)
            {
                mFullScreenVideoView.updateProgress(i);
            }

            
            {
                this$0 = NativeVideoViewController.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
    }

    public void onError(Exception exception)
    {
        MoPubLog.w("Error playing back video.", exception);
        mError = true;
        maybeChangeState();
    }

    protected void onPause()
    {
    }

    protected void onResume()
    {
        if (mCachedVideoFrame != null)
        {
            mFullScreenVideoView.setCachedVideoFrame(mCachedVideoFrame);
        }
        mNativeVideoController.prepare(this);
        mNativeVideoController.setListener(this);
        mNativeVideoController.setOnAudioFocusChangeListener(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    public void onStateChanged(boolean flag, int i)
    {
        mLatestVideoControllerState = i;
        maybeChangeState();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i, int j)
    {
        mNativeVideoController.setTextureView(mFullScreenVideoView.getTextureView());
        if (!mEnded)
        {
            mNativeVideoController.seekTo(mNativeVideoController.getCurrentPosition());
        }
        surfacetexture = mNativeVideoController;
        long l;
        boolean flag;
        if (!mEnded)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        surfacetexture.setPlayWhenReady(flag);
        l = mNativeVideoController.getCurrentPosition();
        if (mNativeVideoController.getDuration() - l < 750L)
        {
            mEnded = true;
            maybeChangeState();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        mNativeVideoController.release(this);
        applyState(VideoState.PAUSED);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i, int j)
    {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }



/*
    static boolean access$002(NativeVideoViewController nativevideoviewcontroller, boolean flag)
    {
        nativevideoviewcontroller.mEnded = flag;
        return flag;
    }

*/





/*
    static Bitmap access$402(NativeVideoViewController nativevideoviewcontroller, Bitmap bitmap)
    {
        nativevideoviewcontroller.mCachedVideoFrame = bitmap;
        return bitmap;
    }

*/


}
