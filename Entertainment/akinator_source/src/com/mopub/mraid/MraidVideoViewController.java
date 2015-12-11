// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.StateListDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.VideoView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Drawables;
import com.mopub.mobileads.BaseVideoViewController;

public class MraidVideoViewController extends BaseVideoViewController
{

    private static final float CLOSE_BUTTON_PADDING = 8F;
    private static final float CLOSE_BUTTON_SIZE = 50F;
    private int mButtonPadding;
    private int mButtonSize;
    private ImageButton mCloseButton;
    private final VideoView mVideoView;

    public MraidVideoViewController(Context context, Bundle bundle, Bundle bundle1, com.mopub.mobileads.BaseVideoViewController.BaseVideoViewControllerListener basevideoviewcontrollerlistener)
    {
        super(context, null, basevideoviewcontrollerlistener);
        mVideoView = new VideoView(context);
        mVideoView.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final MraidVideoViewController this$0;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                mCloseButton.setVisibility(0);
                videoCompleted(true);
            }

            
            {
                this$0 = MraidVideoViewController.this;
                super();
            }
        });
        mVideoView.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final MraidVideoViewController this$0;

            public boolean onError(MediaPlayer mediaplayer, int i, int j)
            {
                mCloseButton.setVisibility(0);
                videoError(false);
                return false;
            }

            
            {
                this$0 = MraidVideoViewController.this;
                super();
            }
        });
        mVideoView.setVideoPath(bundle.getString("video_url"));
    }

    private void createInterstitialCloseButton()
    {
        mCloseButton = new ImageButton(getContext());
        Object obj = new StateListDrawable();
        android.graphics.drawable.Drawable drawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.createDrawable(getContext());
        ((StateListDrawable) (obj)).addState(new int[] {
            0xfefeff59
        }, drawable);
        drawable = Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.createDrawable(getContext());
        ((StateListDrawable) (obj)).addState(new int[] {
            0x10100a7
        }, drawable);
        mCloseButton.setImageDrawable(((android.graphics.drawable.Drawable) (obj)));
        mCloseButton.setBackgroundDrawable(null);
        mCloseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MraidVideoViewController this$0;

            public void onClick(View view)
            {
                getBaseVideoViewControllerListener().onFinish();
            }

            
            {
                this$0 = MraidVideoViewController.this;
                super();
            }
        });
        obj = new android.widget.RelativeLayout.LayoutParams(mButtonSize, mButtonSize);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(11);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).setMargins(mButtonPadding, 0, mButtonPadding, 0);
        getLayout().addView(mCloseButton, ((android.view.ViewGroup.LayoutParams) (obj)));
    }

    protected VideoView getVideoView()
    {
        return mVideoView;
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
    }

    protected void onCreate()
    {
        super.onCreate();
        mButtonSize = Dips.asIntPixels(50F, getContext());
        mButtonPadding = Dips.asIntPixels(8F, getContext());
        createInterstitialCloseButton();
        mCloseButton.setVisibility(8);
        mVideoView.start();
    }

    protected void onDestroy()
    {
    }

    protected void onPause()
    {
    }

    protected void onResume()
    {
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }




}
