// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.VastVideoProgressBarWidget;
import com.mopub.mobileads.resource.CloseButtonDrawable;
import com.mopub.mobileads.resource.CtaButtonDrawable;

public class NativeFullScreenVideoView extends RelativeLayout
{
    static class LoadingBackground extends Drawable
    {

        private final RectF mButtonRect;
        final int mCornerRadiusPx;
        private final Paint mPaint;

        public void draw(Canvas canvas)
        {
            mButtonRect.set(getBounds());
            canvas.drawRoundRect(mButtonRect, mCornerRadiusPx, mCornerRadiusPx, mPaint);
        }

        public int getOpacity()
        {
            return 0;
        }

        public void setAlpha(int i)
        {
        }

        public void setColorFilter(ColorFilter colorfilter)
        {
        }

        LoadingBackground(Context context)
        {
            this(context, new RectF(), new Paint());
        }

        LoadingBackground(Context context, RectF rectf, Paint paint)
        {
            Preconditions.checkNotNull(context);
            Preconditions.checkNotNull(rectf);
            Preconditions.checkNotNull(paint);
            mButtonRect = rectf;
            mPaint = paint;
            mPaint.setColor(0xff000000);
            mPaint.setAlpha(128);
            mPaint.setAntiAlias(true);
            mCornerRadiusPx = Dips.asIntPixels(5F, context);
        }
    }

    public static final class Mode extends Enum
    {

        private static final Mode $VALUES[];
        public static final Mode FINISHED;
        public static final Mode LOADING;
        public static final Mode PAUSED;
        public static final Mode PLAYING;

        public static Mode valueOf(String s)
        {
            return (Mode)Enum.valueOf(com/mopub/nativeads/NativeFullScreenVideoView$Mode, s);
        }

        public static Mode[] values()
        {
            return (Mode[])$VALUES.clone();
        }

        static 
        {
            LOADING = new Mode("LOADING", 0);
            PLAYING = new Mode("PLAYING", 1);
            PAUSED = new Mode("PAUSED", 2);
            FINISHED = new Mode("FINISHED", 3);
            $VALUES = (new Mode[] {
                LOADING, PLAYING, PAUSED, FINISHED
            });
        }

        private Mode(String s, int i)
        {
            super(s, i);
        }
    }


    private final ImageView mBottomGradient;
    private final ImageView mCachedVideoFrameView;
    private final ImageView mCloseControl;
    final int mCloseControlSizePx;
    final int mClosePaddingPx;
    private final ImageView mCtaButton;
    final int mCtaHeightPx;
    final int mCtaMarginPx;
    final int mCtaWidthPx;
    final int mGradientStripHeightPx;
    private final ProgressBar mLoadingSpinner;
    Mode mMode;
    private int mOrientation;
    private final View mOverlay;
    private final ImageView mPlayButton;
    final int mPlayControlSizePx;
    private final ImageView mPrivacyInformationIcon;
    final int mPrivacyInformationIconSizePx;
    private final ImageView mTopGradient;
    private final VastVideoProgressBarWidget mVideoProgress;
    private final TextureView mVideoTexture;

    public NativeFullScreenVideoView(Context context, int i, String s)
    {
        this(context, i, s, new ImageView(context), new TextureView(context), new ProgressBar(context), new ImageView(context), new ImageView(context), new VastVideoProgressBarWidget(context), new View(context), new ImageView(context), new ImageView(context), new ImageView(context), new ImageView(context));
    }

    NativeFullScreenVideoView(Context context, int i, String s, ImageView imageview, TextureView textureview, ProgressBar progressbar, ImageView imageview1, 
            ImageView imageview2, VastVideoProgressBarWidget vastvideoprogressbarwidget, View view, ImageView imageview3, ImageView imageview4, ImageView imageview5, ImageView imageview6)
    {
        super(context);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(imageview);
        Preconditions.checkNotNull(textureview);
        Preconditions.checkNotNull(progressbar);
        Preconditions.checkNotNull(imageview1);
        Preconditions.checkNotNull(imageview2);
        Preconditions.checkNotNull(vastvideoprogressbarwidget);
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(imageview3);
        Preconditions.checkNotNull(imageview4);
        Preconditions.checkNotNull(imageview5);
        Preconditions.checkNotNull(imageview6);
        mOrientation = i;
        mMode = Mode.LOADING;
        mCtaWidthPx = Dips.asIntPixels(200F, context);
        mCtaHeightPx = Dips.asIntPixels(42F, context);
        mCtaMarginPx = Dips.asIntPixels(10F, context);
        mCloseControlSizePx = Dips.asIntPixels(50F, context);
        mClosePaddingPx = Dips.asIntPixels(8F, context);
        mPrivacyInformationIconSizePx = Dips.asIntPixels(44F, context);
        mPlayControlSizePx = Dips.asIntPixels(50F, context);
        mGradientStripHeightPx = Dips.asIntPixels(45F, context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(13);
        mVideoTexture = textureview;
        mVideoTexture.setId((int)Utils.generateUniqueId());
        mVideoTexture.setLayoutParams(layoutparams);
        addView(mVideoTexture);
        mCachedVideoFrameView = imageview;
        mCachedVideoFrameView.setId((int)Utils.generateUniqueId());
        mCachedVideoFrameView.setLayoutParams(layoutparams);
        mCachedVideoFrameView.setBackgroundColor(0);
        addView(mCachedVideoFrameView);
        imageview = new android.widget.RelativeLayout.LayoutParams(mPlayControlSizePx, mPlayControlSizePx);
        imageview.addRule(13);
        mLoadingSpinner = progressbar;
        mLoadingSpinner.setId((int)Utils.generateUniqueId());
        mLoadingSpinner.setBackground(new LoadingBackground(context));
        mLoadingSpinner.setLayoutParams(imageview);
        mLoadingSpinner.setIndeterminate(true);
        addView(mLoadingSpinner);
        imageview = new android.widget.RelativeLayout.LayoutParams(-1, mGradientStripHeightPx);
        imageview.addRule(8, mVideoTexture.getId());
        mBottomGradient = imageview1;
        mBottomGradient.setId((int)Utils.generateUniqueId());
        mBottomGradient.setLayoutParams(imageview);
        imageview = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.BOTTOM_TOP, new int[] {
            com.mopub.mobileads.resource.DrawableConstants.GradientStrip.START_COLOR, com.mopub.mobileads.resource.DrawableConstants.GradientStrip.END_COLOR
        });
        mBottomGradient.setImageDrawable(imageview);
        addView(mBottomGradient);
        imageview = new android.widget.RelativeLayout.LayoutParams(-1, mGradientStripHeightPx);
        imageview.addRule(10);
        mTopGradient = imageview2;
        mTopGradient.setId((int)Utils.generateUniqueId());
        mTopGradient.setLayoutParams(imageview);
        imageview = new GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, new int[] {
            com.mopub.mobileads.resource.DrawableConstants.GradientStrip.START_COLOR, com.mopub.mobileads.resource.DrawableConstants.GradientStrip.END_COLOR
        });
        mTopGradient.setImageDrawable(imageview);
        addView(mTopGradient);
        mVideoProgress = vastvideoprogressbarwidget;
        mVideoProgress.setId((int)Utils.generateUniqueId());
        mVideoProgress.setAnchorId(mVideoTexture.getId());
        mVideoProgress.calibrateAndMakeVisible(1000, 0);
        addView(mVideoProgress);
        imageview = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        imageview.addRule(13);
        mOverlay = view;
        mOverlay.setId((int)Utils.generateUniqueId());
        mOverlay.setLayoutParams(imageview);
        mOverlay.setBackgroundColor(0x88000000);
        addView(mOverlay);
        imageview = new android.widget.RelativeLayout.LayoutParams(mPlayControlSizePx, mPlayControlSizePx);
        imageview.addRule(13);
        mPlayButton = imageview3;
        mPlayButton.setId((int)Utils.generateUniqueId());
        mPlayButton.setLayoutParams(imageview);
        mPlayButton.setImageDrawable(Drawables.NATIVE_PLAY.createDrawable(context));
        addView(mPlayButton);
        mPrivacyInformationIcon = imageview4;
        mPrivacyInformationIcon.setId((int)Utils.generateUniqueId());
        mPrivacyInformationIcon.setImageDrawable(Drawables.NATIVE_PRIVACY_INFORMATION_ICON.createDrawable(context));
        mPrivacyInformationIcon.setPadding(mClosePaddingPx, mClosePaddingPx, mClosePaddingPx * 2, mClosePaddingPx * 2);
        addView(mPrivacyInformationIcon);
        context = new CtaButtonDrawable(context);
        if (!TextUtils.isEmpty(s))
        {
            context.setCtaText(s);
        }
        mCtaButton = imageview5;
        mCtaButton.setId((int)Utils.generateUniqueId());
        mCtaButton.setImageDrawable(context);
        addView(mCtaButton);
        mCloseControl = imageview6;
        mCloseControl.setId((int)Utils.generateUniqueId());
        mCloseControl.setImageDrawable(new CloseButtonDrawable());
        mCloseControl.setPadding(mClosePaddingPx * 3, mClosePaddingPx, mClosePaddingPx, mClosePaddingPx * 3);
        addView(mCloseControl);
        updateViewState();
    }

    private void setCachedImageVisibility(int i)
    {
        mCachedVideoFrameView.setVisibility(i);
    }

    private void setLoadingSpinnerVisibility(int i)
    {
        mLoadingSpinner.setVisibility(i);
    }

    private void setPlayButtonVisibility(int i)
    {
        mPlayButton.setVisibility(i);
        mOverlay.setVisibility(i);
    }

    private void setVideoProgressVisibility(int i)
    {
        mVideoProgress.setVisibility(i);
    }

    private void updateControlLayouts()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams;
        android.widget.RelativeLayout.LayoutParams layoutparams1;
        android.widget.RelativeLayout.LayoutParams layoutparams2;
        layoutparams = new android.widget.RelativeLayout.LayoutParams(mCtaWidthPx, mCtaHeightPx);
        layoutparams.setMargins(mCtaMarginPx, mCtaMarginPx, mCtaMarginPx, mCtaMarginPx);
        layoutparams1 = new android.widget.RelativeLayout.LayoutParams(mPrivacyInformationIconSizePx, mPrivacyInformationIconSizePx);
        layoutparams2 = new android.widget.RelativeLayout.LayoutParams(mCloseControlSizePx, mCloseControlSizePx);
        mOrientation;
        JVM INSTR tableswitch 1 2: default 96
    //                   1 121
    //                   2 166;
           goto _L1 _L2 _L3
_L1:
        mCtaButton.setLayoutParams(layoutparams);
        mPrivacyInformationIcon.setLayoutParams(layoutparams1);
        mCloseControl.setLayoutParams(layoutparams2);
        return;
_L2:
        layoutparams.addRule(3, mVideoTexture.getId());
        layoutparams.addRule(14);
        layoutparams1.addRule(10);
        layoutparams1.addRule(9);
        layoutparams2.addRule(10);
        layoutparams2.addRule(11);
        continue; /* Loop/switch isn't completed */
_L3:
        layoutparams.addRule(2, mVideoProgress.getId());
        layoutparams.addRule(11);
        layoutparams1.addRule(6, mVideoTexture.getId());
        layoutparams1.addRule(5, mVideoTexture.getId());
        layoutparams2.addRule(6, mVideoTexture.getId());
        layoutparams2.addRule(7, mVideoTexture.getId());
        if (true) goto _L1; else goto _L4
_L4:
    }

    private void updateVideoTextureLayout()
    {
        Configuration configuration = getContext().getResources().getConfiguration();
        android.view.ViewGroup.LayoutParams layoutparams = mVideoTexture.getLayoutParams();
        int i = Dips.dipsToIntPixels(configuration.screenWidthDp, getContext());
        if (i != layoutparams.width)
        {
            layoutparams.width = i;
        }
        i = Dips.dipsToIntPixels(((float)configuration.screenWidthDp * 9F) / 16F, getContext());
        if (i != layoutparams.height)
        {
            layoutparams.height = i;
        }
    }

    private void updateViewState()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$mopub$nativeads$NativeFullScreenVideoView$Mode[];

            static 
            {
                $SwitchMap$com$mopub$nativeads$NativeFullScreenVideoView$Mode = new int[Mode.values().length];
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeFullScreenVideoView$Mode[Mode.LOADING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeFullScreenVideoView$Mode[Mode.PLAYING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeFullScreenVideoView$Mode[Mode.PAUSED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$nativeads$NativeFullScreenVideoView$Mode[Mode.FINISHED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.mopub.nativeads.NativeFullScreenVideoView.Mode[mMode.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 49
    //                   2 72
    //                   3 95
    //                   4 118;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        updateVideoTextureLayout();
        updateControlLayouts();
        return;
_L2:
        setCachedImageVisibility(0);
        setLoadingSpinnerVisibility(0);
        setVideoProgressVisibility(4);
        setPlayButtonVisibility(4);
        continue; /* Loop/switch isn't completed */
_L3:
        setCachedImageVisibility(4);
        setLoadingSpinnerVisibility(4);
        setVideoProgressVisibility(0);
        setPlayButtonVisibility(4);
        continue; /* Loop/switch isn't completed */
_L4:
        setCachedImageVisibility(4);
        setLoadingSpinnerVisibility(4);
        setVideoProgressVisibility(0);
        setPlayButtonVisibility(0);
        continue; /* Loop/switch isn't completed */
_L5:
        setCachedImageVisibility(0);
        setLoadingSpinnerVisibility(4);
        setVideoProgressVisibility(4);
        setPlayButtonVisibility(0);
        if (true) goto _L1; else goto _L6
_L6:
    }

    ImageView getCtaButton()
    {
        return mCtaButton;
    }

    public TextureView getTextureView()
    {
        return mVideoTexture;
    }

    public void resetProgress()
    {
        mVideoProgress.reset();
    }

    public void setCachedVideoFrame(Bitmap bitmap)
    {
        mCachedVideoFrameView.setImageBitmap(bitmap);
    }

    public void setCloseControlListener(android.view.View.OnClickListener onclicklistener)
    {
        mCloseControl.setOnClickListener(onclicklistener);
    }

    public void setCtaClickListener(android.view.View.OnClickListener onclicklistener)
    {
        mCtaButton.setOnClickListener(onclicklistener);
    }

    public void setMode(Mode mode)
    {
        Preconditions.checkNotNull(mode);
        if (mMode == mode)
        {
            return;
        } else
        {
            mMode = mode;
            updateViewState();
            return;
        }
    }

    public void setOrientation(int i)
    {
        if (mOrientation == i)
        {
            return;
        } else
        {
            mOrientation = i;
            updateViewState();
            return;
        }
    }

    public void setPlayControlClickListener(android.view.View.OnClickListener onclicklistener)
    {
        mPlayButton.setOnClickListener(onclicklistener);
        mOverlay.setOnClickListener(onclicklistener);
    }

    public void setPrivacyInformationClickListener(android.view.View.OnClickListener onclicklistener)
    {
        mPrivacyInformationIcon.setOnClickListener(onclicklistener);
    }

    public void setSurfaceTextureListener(android.view.TextureView.SurfaceTextureListener surfacetexturelistener)
    {
        mVideoTexture.setSurfaceTextureListener(surfacetexturelistener);
        android.graphics.SurfaceTexture surfacetexture = mVideoTexture.getSurfaceTexture();
        if (surfacetexture != null && surfacetexturelistener != null)
        {
            surfacetexturelistener.onSurfaceTextureAvailable(surfacetexture, mVideoTexture.getWidth(), mVideoTexture.getHeight());
        }
    }

    public void updateProgress(int i)
    {
        mVideoProgress.updateProgress(i);
    }
}
