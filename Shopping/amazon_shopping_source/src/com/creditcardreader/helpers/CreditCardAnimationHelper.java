// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.creditcardreader.helpers;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.creditcardreader.activities.CreditCardScanActivity;
import com.creditcardreader.camera.CreditCardCameraPreview;

public class CreditCardAnimationHelper
{

    private CreditCardScanActivity mActivity;
    private android.view.animation.Animation.AnimationListener mCenterToScanning;
    private Animation mFadeInGhost;
    private Animation mFadeInText;
    private Animation mFadeOutGhost;
    private Animation mFadeOutScan;
    private Animation mFadeOutText;
    private ImageView mGhostView;
    private RelativeLayout mInnerLayout;
    private android.view.animation.Animation.AnimationListener mInvisToVisible;
    private RelativeLayout mOuterLayout;
    private CreditCardCameraPreview mPreview;
    private ImageView mProgressView;
    private Resources mResources;
    private android.view.animation.Animation.AnimationListener mScanningToCenter;
    private android.view.animation.Animation.AnimationListener mScanningToScanned;
    private Animation mSlideScan;
    private android.view.animation.Animation.AnimationListener mSlideToFade;
    private TextView mStatusView;
    private android.view.animation.Animation.AnimationListener mVisibleToInvis;

    public CreditCardAnimationHelper(CreditCardScanActivity creditcardscanactivity, CreditCardCameraPreview creditcardcamerapreview)
    {
        mActivity = creditcardscanactivity;
        mPreview = creditcardcamerapreview;
        mResources = creditcardscanactivity.getResources();
        mOuterLayout = (RelativeLayout)creditcardscanactivity.findViewById(com.creditcardreader.R.id.cc_scan_outer_layout);
        mInnerLayout = (RelativeLayout)creditcardscanactivity.findViewById(com.creditcardreader.R.id.cc_scan_inner_layout);
    }

    private android.view.animation.Animation.AnimationListener createGhostListener(final boolean visible)
    {
        return new android.view.animation.Animation.AnimationListener() {

            final CreditCardAnimationHelper this$0;
            final boolean val$visible;

            public void onAnimationEnd(Animation animation)
            {
                if (visible)
                {
                    mGhostView.setVisibility(0);
                    return;
                } else
                {
                    mGhostView.setVisibility(4);
                    return;
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = CreditCardAnimationHelper.this;
                visible = flag;
                super();
            }
        };
    }

    private android.view.animation.Animation.AnimationListener createSlideListener()
    {
        return new android.view.animation.Animation.AnimationListener() {

            final CreditCardAnimationHelper this$0;

            public void onAnimationEnd(Animation animation)
            {
                mFadeOutScan.setStartOffset(300L);
                mFadeOutScan.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final _cls3 this$1;

                    public void onAnimationEnd(Animation animation)
                    {
                        if (mPreview.isScanning())
                        {
                            mProgressView.startAnimation(mSlideScan);
                        }
                    }

                    public void onAnimationRepeat(Animation animation)
                    {
                    }

                    public void onAnimationStart(Animation animation)
                    {
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
                if (mPreview.isScanning())
                {
                    mProgressView.startAnimation(mFadeOutScan);
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = CreditCardAnimationHelper.this;
                super();
            }
        };
    }

    private Animation createSlideScan()
    {
        TranslateAnimation translateanimation = new TranslateAnimation(mProgressView.getDrawable().getIntrinsicWidth() * -1, mProgressView.getLeft(), 0.0F, 0.0F);
        translateanimation.setDuration(900L);
        return translateanimation;
    }

    private android.view.animation.Animation.AnimationListener createStatusListener(final String text)
    {
        return new android.view.animation.Animation.AnimationListener() {

            final CreditCardAnimationHelper this$0;
            final String val$text;

            public void onAnimationEnd(Animation animation)
            {
                mStatusView.setText(text);
                mStatusView.startAnimation(mFadeInText);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = CreditCardAnimationHelper.this;
                text = s;
                super();
            }
        };
    }

    private void setAnimationListeners()
    {
        mCenterToScanning = createStatusListener(mResources.getString(com.creditcardreader.R.string.cc_scan_scanning));
        mScanningToCenter = createStatusListener(mResources.getString(com.creditcardreader.R.string.cc_scan_center_card));
        mScanningToScanned = createStatusListener(mResources.getString(com.creditcardreader.R.string.cc_scan_success));
        mVisibleToInvis = createGhostListener(false);
        mInvisToVisible = createGhostListener(true);
        mSlideToFade = createSlideListener();
        mFadeOutGhost.setAnimationListener(mVisibleToInvis);
        mFadeInGhost.setAnimationListener(mInvisToVisible);
        mSlideScan.setAnimationListener(mSlideToFade);
    }

    private void setAnimations()
    {
        mFadeOutText = AnimationUtils.loadAnimation(mActivity, com.creditcardreader.R.anim.cc_scan_fade_out);
        mFadeInText = AnimationUtils.loadAnimation(mActivity, com.creditcardreader.R.anim.cc_scan_fade_in);
        mFadeOutGhost = AnimationUtils.loadAnimation(mActivity, com.creditcardreader.R.anim.cc_scan_fade_out);
        mFadeInGhost = AnimationUtils.loadAnimation(mActivity, com.creditcardreader.R.anim.cc_scan_fade_in);
        mFadeOutScan = AnimationUtils.loadAnimation(mActivity, com.creditcardreader.R.anim.cc_scan_fade_out_scan);
        mSlideScan = createSlideScan();
    }

    private void stopScanAnimation()
    {
        mProgressView.clearAnimation();
        mProgressView.setVisibility(4);
    }

    public void blacken()
    {
        mOuterLayout.setBackgroundColor(mResources.getColor(com.creditcardreader.R.color.cc_scan_background));
        mInnerLayout.setVisibility(4);
    }

    public void centerToScanning()
    {
        mGhostView.startAnimation(mFadeOutGhost);
        mFadeOutText.setAnimationListener(mCenterToScanning);
        mStatusView.startAnimation(mFadeOutText);
        mProgressView.startAnimation(mSlideScan);
        mProgressView.setVisibility(0);
    }

    public void createAnimations()
    {
        setAnimations();
        setAnimationListeners();
    }

    public void lighten()
    {
        mInnerLayout.setVisibility(0);
        mOuterLayout.setBackgroundColor(0);
    }

    public void resetOverlay()
    {
        mStatusView.setText(mResources.getString(com.creditcardreader.R.string.cc_scan_center_card));
        stopScanAnimation();
        if (mGhostView.getVisibility() == 4)
        {
            mFadeInGhost.setAnimationListener(mInvisToVisible);
            mGhostView.startAnimation(mFadeInGhost);
        }
    }

    public void scanningToCenter()
    {
        mFadeInGhost.setAnimationListener(mInvisToVisible);
        mGhostView.startAnimation(mFadeInGhost);
        mFadeOutText.setAnimationListener(mScanningToCenter);
        mStatusView.startAnimation(mFadeOutText);
        stopScanAnimation();
    }

    public void scanningToScanned()
    {
        mFadeOutText.setAnimationListener(mScanningToScanned);
        mStatusView.startAnimation(mFadeOutText);
        stopScanAnimation();
    }

    public void setViews()
    {
        mStatusView = (TextView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_status_text);
        mGhostView = (ImageView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_ghost);
        mProgressView = (ImageView)mActivity.findViewById(com.creditcardreader.R.id.cc_scan_progress);
    }







}
