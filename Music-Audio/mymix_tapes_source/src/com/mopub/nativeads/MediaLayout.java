// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;

public class MediaLayout extends RelativeLayout
{
    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode BUFFERING;
        public static final Mode FINISHED;
        public static final Mode IMAGE;
        public static final Mode LOADING;
        public static final Mode PAUSED;
        public static final Mode PLAYING;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/mopub/nativeads/MediaLayout$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            IMAGE = new Mode("IMAGE", 0);
            PLAYING = new Mode("PLAYING", 1);
            LOADING = new Mode("LOADING", 2);
            BUFFERING = new Mode("BUFFERING", 3);
            PAUSED = new Mode("PAUSED", 4);
            FINISHED = new Mode("FINISHED", 5);
            $VALUES = (new Mode[] {
                IMAGE, PLAYING, LOADING, BUFFERING, PAUSED, FINISHED
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MuteState extends Enum
    {

        private static final MuteState $VALUES[];
        public static final MuteState MUTED;
        public static final MuteState UNMUTED;

        public static MuteState valueOf(String s)
        {
            return (MuteState)Enum.valueOf(com/mopub/nativeads/MediaLayout$MuteState, s);
        }

        public static MuteState[] values()
        {
            return (MuteState[])$VALUES.clone();
        }

        static 
        {
            MUTED = new MuteState("MUTED", 0);
            UNMUTED = new MuteState("UNMUTED", 1);
            $VALUES = (new MuteState[] {
                MUTED, UNMUTED
            });
        }

        private MuteState(String s, int i)
        {
            super(s, i);
        }
    }


    private static final float ASPECT_MULTIPLIER_HEIGHT_TO_WIDTH = 1.777778F;
    private static final float ASPECT_MULTIPLIER_WIDTH_TO_HEIGHT = 0.5625F;
    private static final int CONTROL_SIZE_DIPS = 40;
    private static final int GRADIENT_STRIP_HEIGHT_DIPS = 35;
    private static final int MUTE_SIZE_DIPS = 36;
    private static final int PINNER_PADDING_DIPS = 10;
    private ImageView mBottomGradient;
    private final int mControlSizePx;
    private final int mGradientStripHeightPx;
    private boolean mIsInitialized;
    private ProgressBar mLoadingSpinner;
    private ImageView mMainImageView;
    private volatile Mode mMode;
    private ImageView mMuteControl;
    private final int mMuteSizePx;
    private MuteState mMuteState;
    private Drawable mMutedDrawable;
    private View mOverlay;
    private final int mPaddingPx;
    private ImageView mPlayButton;
    private ImageView mTopGradient;
    private Drawable mUnmutedDrawable;
    private VastVideoProgressBarWidget mVideoProgress;
    private TextureView mVideoTextureView;

    public MediaLayout(Context context)
    {
        this(context, null);
    }

    public MediaLayout(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public MediaLayout(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMode = Mode.IMAGE;
        Preconditions.checkNotNull(context);
        mMuteState = MuteState.MUTED;
        attributeset = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        attributeset.addRule(13);
        mMainImageView = new ImageView(context);
        mMainImageView.setLayoutParams(attributeset);
        mMainImageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
        addView(mMainImageView);
        mControlSizePx = Dips.asIntPixels(40F, context);
        mGradientStripHeightPx = Dips.asIntPixels(35F, context);
        mMuteSizePx = Dips.asIntPixels(36F, context);
        mPaddingPx = Dips.asIntPixels(10F, context);
    }

    private void setLoadingSpinnerVisibility(int i)
    {
        if (mLoadingSpinner != null)
        {
            mLoadingSpinner.setVisibility(i);
        }
        if (mTopGradient != null)
        {
            mTopGradient.setVisibility(i);
        }
    }

    private void setMainImageVisibility(int i)
    {
        mMainImageView.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i)
    {
        if (mPlayButton != null && mOverlay != null)
        {
            mPlayButton.setVisibility(i);
            mOverlay.setVisibility(i);
        }
    }

    private void setVideoControlVisibility(int i)
    {
        if (mBottomGradient != null)
        {
            mBottomGradient.setVisibility(i);
        }
        if (mVideoProgress != null)
        {
            mVideoProgress.setVisibility(i);
        }
        if (mMuteControl != null)
        {
            mMuteControl.setVisibility(i);
        }
    }

    private void updateViewState()
    {
        static class _cls2
        {

            static final int $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[];
            static final int $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState[];

            static 
            {
                $SwitchMap$com$mopub$nativeads$MediaLayout$Mode = new int[Mode.values().length];
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[Mode.IMAGE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[Mode.LOADING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[Mode.BUFFERING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[Mode.PLAYING.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[Mode.PAUSED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$Mode[Mode.FINISHED.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState = new int[MuteState.values().length];
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState[MuteState.MUTED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$MediaLayout$MuteState[MuteState.UNMUTED.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.mopub.nativeads.MediaLayout.Mode[mMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            setMainImageVisibility(0);
            setLoadingSpinnerVisibility(4);
            setVideoControlVisibility(4);
            setPlayButtonVisibility(4);
            return;

        case 2: // '\002'
            setMainImageVisibility(0);
            setLoadingSpinnerVisibility(0);
            setVideoControlVisibility(4);
            setPlayButtonVisibility(4);
            return;

        case 3: // '\003'
            setMainImageVisibility(4);
            setLoadingSpinnerVisibility(0);
            setVideoControlVisibility(0);
            setPlayButtonVisibility(4);
            // fall through

        case 4: // '\004'
            setMainImageVisibility(4);
            setLoadingSpinnerVisibility(4);
            setVideoControlVisibility(0);
            setPlayButtonVisibility(4);
            return;

        case 5: // '\005'
            setMainImageVisibility(4);
            setLoadingSpinnerVisibility(4);
            setVideoControlVisibility(0);
            setPlayButtonVisibility(0);
            return;

        case 6: // '\006'
            setMainImageVisibility(0);
            break;
        }
        setLoadingSpinnerVisibility(4);
        setVideoControlVisibility(4);
        setPlayButtonVisibility(0);
    }

    public ImageView getMainImageView()
    {
        return mMainImageView;
    }

    public TextureView getTextureView()
    {
        return mVideoTextureView;
    }

    public void initForVideo()
    {
        if (mIsInitialized)
        {
            return;
        } else
        {
            Object obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            mVideoTextureView = new TextureView(getContext());
            mVideoTextureView.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mVideoTextureView.setId((int)Utils.generateUniqueId());
            addView(mVideoTextureView);
            mMainImageView.bringToFront();
            obj = new android.widget.RelativeLayout.LayoutParams(mControlSizePx, mControlSizePx);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
            mLoadingSpinner = new ProgressBar(getContext());
            mLoadingSpinner.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mLoadingSpinner.setPadding(0, mPaddingPx, mPaddingPx, 0);
            mLoadingSpinner.setIndeterminate(true);
            addView(mLoadingSpinner);
            obj = new android.widget.RelativeLayout.LayoutParams(-1, mGradientStripHeightPx);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(8, mVideoTextureView.getId());
            mBottomGradient = new ImageView(getContext());
            mBottomGradient.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, new int[] {
                com.mopub.mobileads.resource.DrawableConstants.GradientStrip.START_COLOR, com.mopub.mobileads.resource.DrawableConstants.GradientStrip.END_COLOR
            });
            mBottomGradient.setImageDrawable(((Drawable) (obj)));
            addView(mBottomGradient);
            obj = new android.widget.RelativeLayout.LayoutParams(-1, mGradientStripHeightPx);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(6, mVideoTextureView.getId());
            mTopGradient = new ImageView(getContext());
            mTopGradient.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            obj = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
                com.mopub.mobileads.resource.DrawableConstants.GradientStrip.START_COLOR, com.mopub.mobileads.resource.DrawableConstants.GradientStrip.END_COLOR
            });
            mTopGradient.setImageDrawable(((Drawable) (obj)));
            addView(mTopGradient);
            mVideoProgress = new VastVideoProgressBarWidget(getContext());
            mVideoProgress.setAnchorId(mVideoTextureView.getId());
            mVideoProgress.calibrateAndMakeVisible(1000, 0);
            addView(mVideoProgress);
            mMutedDrawable = Drawables.NATIVE_MUTED.createDrawable(getContext());
            mUnmutedDrawable = Drawables.NATIVE_UNMUTED.createDrawable(getContext());
            obj = new android.widget.RelativeLayout.LayoutParams(mMuteSizePx, mMuteSizePx);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(2, mVideoProgress.getId());
            mMuteControl = new ImageView(getContext());
            mMuteControl.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mMuteControl.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
            mMuteControl.setPadding(mPaddingPx, mPaddingPx, mPaddingPx, mPaddingPx);
            mMuteControl.setImageDrawable(mMutedDrawable);
            addView(mMuteControl);
            obj = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            mOverlay = new View(getContext());
            mOverlay.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mOverlay.setBackgroundColor(0);
            addView(mOverlay);
            obj = new android.widget.RelativeLayout.LayoutParams(mControlSizePx, mControlSizePx);
            ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
            mPlayButton = new ImageView(getContext());
            mPlayButton.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            mPlayButton.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(getContext()));
            addView(mPlayButton);
            mIsInitialized = true;
            updateViewState();
            return;
        }
    }

    protected void onMeasure(int i, int j)
    {
        int l = android.view.View.MeasureSpec.getMode(i);
        int j2 = android.view.View.MeasureSpec.getMode(j);
        int k = android.view.View.MeasureSpec.getSize(i);
        int k1 = android.view.View.MeasureSpec.getSize(j);
        int j1 = getMeasuredWidth();
        int i2 = getMeasuredHeight();
        int i1;
        int l1;
        if (l != 0x40000000)
        {
            if (l == 0x80000000)
            {
                k = Math.min(k, j1);
            } else
            {
                k = j1;
            }
        }
        l1 = (int)(0.5625F * (float)k);
        i1 = l1;
        l = k;
        if (j2 == 0x40000000)
        {
            i1 = l1;
            l = k;
            if (k1 < l1)
            {
                i1 = k1;
                l = (int)(1.777778F * (float)i1);
            }
        }
        if (Math.abs(i1 - i2) >= 2 || Math.abs(l - j1) >= 2)
        {
            MoPubLog.v(String.format("Resetting mediaLayout size to w: %d h: %d", new Object[] {
                Integer.valueOf(l), Integer.valueOf(i1)
            }));
            getLayoutParams().width = l;
            getLayoutParams().height = i1;
        }
        super.onMeasure(i, j);
    }

    public void reset()
    {
        setMode(Mode.IMAGE);
        setPlayButtonClickListener(null);
        setMuteControlClickListener(null);
        setVideoClickListener(null);
    }

    public void resetProgress()
    {
        if (mVideoProgress != null)
        {
            mVideoProgress.reset();
        }
    }

    public void setMainImageDrawable(Drawable drawable)
    {
        Preconditions.checkNotNull(drawable);
        mMainImageView.setImageDrawable(drawable);
    }

    public void setMode(Mode mode)
    {
        Preconditions.checkNotNull(mode);
        mMode = mode;
        post(new Runnable() {

            final MediaLayout this$0;

            public void run()
            {
                updateViewState();
            }

            
            {
                this$0 = MediaLayout.this;
                super();
            }
        });
    }

    public void setMuteControlClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (mMuteControl != null)
        {
            mMuteControl.setOnClickListener(onclicklistener);
        }
    }

    public void setMuteState(MuteState mutestate)
    {
        Preconditions.checkNotNull(mutestate);
        if (mutestate != mMuteState)
        {
            mMuteState = mutestate;
            if (mMuteControl != null)
            {
                switch (_cls2..SwitchMap.com.mopub.nativeads.MediaLayout.MuteState[mMuteState.ordinal()])
                {
                default:
                    mMuteControl.setImageDrawable(mUnmutedDrawable);
                    return;

                case 1: // '\001'
                    mMuteControl.setImageDrawable(mMutedDrawable);
                    break;
                }
                return;
            }
        }
    }

    public void setPlayButtonClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (mPlayButton != null && mOverlay != null)
        {
            mOverlay.setOnClickListener(onclicklistener);
            mPlayButton.setOnClickListener(onclicklistener);
        }
    }

    public void setSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener surfacetexturelistener)
    {
        if (mVideoTextureView != null)
        {
            mVideoTextureView.setSurfaceTextureListener(surfacetexturelistener);
            android.graphics.SurfaceTexture surfacetexture = mVideoTextureView.getSurfaceTexture();
            if (surfacetexture != null && surfacetexturelistener != null)
            {
                surfacetexturelistener.onSurfaceTextureAvailable(surfacetexture, mVideoTextureView.getWidth(), mVideoTextureView.getHeight());
            }
        }
    }

    public void setVideoClickListener(android.view.View.OnClickListener onclicklistener)
    {
        if (mVideoTextureView != null)
        {
            mVideoTextureView.setOnClickListener(onclicklistener);
        }
    }

    public void updateProgress(int i)
    {
        if (mVideoProgress != null)
        {
            mVideoProgress.updateProgress(i);
        }
    }

}
