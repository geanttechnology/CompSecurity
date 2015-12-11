// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItUtil, ViewItTutorialView2, ViewItTutorialView3

public class ViewItTutorialContentView extends LinearLayout
{

    private AmazonActivity mActivity;
    protected ViewGroup mDeviceAndHistoryTrayFrame;
    protected ImageView mDeviceFrame;
    private float mDeviceFrameBottom;
    protected int mDeviceFrameHeight;
    private float mDeviceFrameTop;
    private ImageView mHistoryArrow;
    private ImageView mHistoryBottomTray;
    private LinearLayout mHistoryTrayFrame;
    private float mHistoryTrayFrameHandle;
    private int mHistoryTrayFrameHeight;
    private Button mNextButton;
    protected ImageView mProductsFrame;
    protected int mProductsFrameWidth;
    protected ImageView mScannedHistoryItem;
    private float mScannedItemAnimationToYValue;
    private ImageView mScannedItemFrame;
    private int mScannedItemHeight;
    private int mScannedItemWidth;
    protected int mScreenWidth;
    private Button mSkipButton;
    private TextView mTutorialDescription;
    private TextView mTutorialTitle;
    private View mTutorialTitleAndDescription;

    public ViewItTutorialContentView(Context context)
    {
        super(context);
        mActivity = (AmazonActivity)context;
        addView(LayoutInflater.from(mActivity).inflate(com.amazon.mShop.android.lib.R.layout.view_it_tutorial, null), new android.widget.LinearLayout.LayoutParams(-1, -1));
    }

    private void animateInBarcodeFrame()
    {
        mProductsFrame.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_barcode);
        mProductsFrame.setVisibility(0);
        TranslateAnimation translateanimation = new TranslateAnimation(0, mScreenWidth / 2 + mProductsFrameWidth / 2, 1, 0.0F, 1, 0.0F, 1, 0.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(500L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;

            public void onAnimationEnd(Animation animation)
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls10 this$1;

                    public void run()
                    {
                        startScannedItemTranslateAnimation(3, 0.0F);
                    }

            
            {
                this$1 = _cls10.this;
                super();
            }
                }, 300L);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
        mProductsFrame.startAnimation(animationset);
    }

    private void completeTutorial()
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("keyTutorialScreenDisplayed", true);
        mActivity.setResult(-1, null);
        mActivity.finish();
    }

    private void reLayoutContentView()
    {
        mDeviceFrameHeight = mDeviceFrame.getHeight();
        mDeviceFrameTop = (float)mDeviceFrameHeight * 0.08F;
        mDeviceFrameBottom = (float)mDeviceFrameHeight * 0.1F;
        mScannedItemAnimationToYValue = (float)(mDeviceFrameHeight / 2) - mDeviceFrameBottom - (float)(mScannedItemHeight / 2);
        setHistoryTrayToBottomOfDeviceFrame();
        setScannedHistoryItemToBottomOfDeviceFrame();
    }

    private void setHistoryTrayToBottomOfDeviceFrame()
    {
        Matrix matrix = new Matrix();
        matrix.setTranslate(0.0F, ((mDeviceFrameHeight - mHistoryTrayFrameHeight) / 2 + mHistoryTrayFrameHeight) - (int)mDeviceFrameBottom - mScannedItemHeight - (int)mHistoryTrayFrameHandle);
        mHistoryBottomTray.setImageMatrix(matrix);
    }

    private void setScannedHistoryItemToBottomOfDeviceFrame()
    {
        android.view.ViewGroup.LayoutParams layoutparams = mScannedHistoryItem.getLayoutParams();
        layoutparams.height = (int)mDeviceFrameBottom + mScannedItemHeight;
        mScannedHistoryItem.setLayoutParams(layoutparams);
        int i = (int)mDeviceFrameBottom;
        mScannedHistoryItem.setPadding(0, 0, 0, i);
    }

    private void showHistorySlidingArrow()
    {
        mHistoryArrow.setVisibility(0);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.5F, 1.0F);
        alphaanimation.setRepeatCount(3);
        alphaanimation.setRepeatMode(2);
        float f = mDeviceFrameBottom + (float)mScannedItemHeight + mHistoryTrayFrameHandle;
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -f, 0, -(f + 40F));
        translateanimation.setRepeatCount(3);
        translateanimation.setRepeatMode(2);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(500L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;

            public void onAnimationEnd(Animation animation)
            {
                mHistoryArrow.setVisibility(8);
                startHistoryTrayFrameTranslateAnimation();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
        mHistoryArrow.startAnimation(animationset);
    }

    private void showNextButton(android.view.View.OnClickListener onclicklistener)
    {
        mNextButton.setVisibility(0);
        mNextButton.setOnClickListener(onclicklistener);
        onclicklistener = new AlphaAnimation(0.0F, 1.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(onclicklistener);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(1500L);
        mNextButton.startAnimation(animationset);
    }

    private void showTutorialTitleAndDescription(int i, int j)
    {
        updateTitleAndDescription(i, j);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(200L);
        mTutorialTitleAndDescription.startAnimation(animationset);
    }

    private void startDeviceFrameTranslateAnimation2(float f)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0, f, 1, 0.0F, 1, 0.0F, 1, 0.0F);
        startTranslateAnimation(mDeviceAndHistoryTrayFrame, translateanimation, 1000, new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;

            public void onAnimationEnd(Animation animation)
            {
                startScannedItemTranslateAnimation(1, 0.0F);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
    }

    private void startDeviceFrameTranslateAnimation3(float f)
    {
        final float toXValue = f + (float)mProductsFrameWidth * 0.375F;
        TranslateAnimation translateanimation = new TranslateAnimation(0, f, 0, toXValue, 1, 0.0F, 1, 0.0F);
        startTranslateAnimation(mDeviceAndHistoryTrayFrame, translateanimation, 1000, new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;
            final float val$toXValue;

            public void onAnimationEnd(Animation animation)
            {
                startScannedItemTranslateAnimation(2, toXValue);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                toXValue = f;
                super();
            }
        });
    }

    private void startDeviceFrameTranslateAnimation4()
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0, (float)mProductsFrameWidth * 0.375F, 1, 0.0F, 1, 0.0F, 1, 0.0F);
        startTranslateAnimation(mDeviceAndHistoryTrayFrame, translateanimation, 500, new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;

            public void onAnimationEnd(Animation animation)
            {
                showTutorialTitleAndDescription(com.amazon.mShop.android.lib.R.string.view_it_tutorial_title_2, com.amazon.mShop.android.lib.R.string.view_it_tutorial_description_2);
                animateInBarcodeFrame();
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
    }

    private void startHistoryTrayFrameTranslateAnimation()
    {
        mHistoryTrayFrame.setVisibility(0);
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, (float)mHistoryTrayFrameHeight - mDeviceFrameBottom - (float)mScannedItemHeight - mHistoryTrayFrameHandle, 0, -((float)mDeviceFrameHeight - mDeviceFrameTop - (float)mHistoryTrayFrameHeight));
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(1500L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;

            public void onAnimationEnd(Animation animation)
            {
                mNextButton.setText(com.amazon.mShop.android.lib.R.string.view_it_tutorial_next_button_get_started_text);
                showNextButton(new android.view.View.OnClickListener() {

                    final _cls8 this$1;

                    public void onClick(View view)
                    {
                        completeTutorial();
                        RefMarkerObserver.logRefMarker("fl_tutor_start_btn");
                    }

            
            {
                this$1 = _cls8.this;
                super();
            }
                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
        mHistoryTrayFrame.startAnimation(animationset);
    }

    private void startScannedItemTranslateAnimation(final int scannedItemIndex, final float fromXValue)
    {
        scannedItemIndex;
        JVM INSTR tableswitch 0 3: default 32
    //                   0 182
    //                   1 195
    //                   2 208
    //                   3 221;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        mScannedItemFrame.setVisibility(0);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.5F, 1.0F);
        ScaleAnimation scaleanimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 0, mScannedItemWidth / 2, 1, 0.5F);
        TranslateAnimation translateanimation = new TranslateAnimation(0, fromXValue, 0, fromXValue, 1, 0.0F, 0, mScannedItemAnimationToYValue);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(false);
        animationset.setDuration(1000L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;
            final float val$fromXValue;
            final int val$scannedItemIndex;

            public void onAnimationEnd(Animation animation)
            {
                mScannedItemFrame.setVisibility(8);
                switch (scannedItemIndex)
                {
                default:
                    return;

                case 0: // '\0'
                    mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_bottle);
                    startDeviceFrameTranslateAnimation2(fromXValue);
                    return;

                case 1: // '\001'
                    mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_book);
                    startDeviceFrameTranslateAnimation3(fromXValue);
                    return;

                case 2: // '\002'
                    mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_jar);
                    showNextButton(new android.view.View.OnClickListener() {

                        final _cls7 this$1;

                        public void onClick(View view)
                        {
                            view = new ViewItTutorialView2(mActivity, mDeviceFrameHeight, mProductsFrameWidth);
                            mActivity.pushView(view, false);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    return;

                case 3: // '\003'
                    mScannedHistoryItem.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_barcode);
                    break;
                }
                showNextButton(new android.view.View.OnClickListener() {

                    final _cls7 this$1;

                    public void onClick(View view)
                    {
                        view = new ViewItTutorialView3(mActivity, mDeviceFrameHeight, mProductsFrameWidth);
                        mActivity.pushView(view, false);
                    }

            
            {
                this$1 = _cls7.this;
                super();
            }
                });
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                scannedItemIndex = i;
                fromXValue = f;
                super();
            }
        });
        mScannedItemFrame.startAnimation(animationset);
        return;
_L2:
        mScannedItemFrame.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_bottle);
        continue; /* Loop/switch isn't completed */
_L3:
        mScannedItemFrame.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_book);
        continue; /* Loop/switch isn't completed */
_L4:
        mScannedItemFrame.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_jar);
        continue; /* Loop/switch isn't completed */
_L5:
        mScannedItemFrame.setImageResource(com.amazon.mShop.android.lib.R.drawable.tutorial_history_barcode);
        if (true) goto _L1; else goto _L6
_L6:
    }

    private void startTranslateAnimation(View view, TranslateAnimation translateanimation, int i, android.view.animation.Animation.AnimationListener animationlistener)
    {
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(i);
        animationset.setAnimationListener(animationlistener);
        view.startAnimation(animationset);
    }

    public void animateOutProductsFrame(final boolean isBarcode)
    {
        TranslateAnimation translateanimation = new TranslateAnimation(1, 0.0F, 0, -(float)(mScreenWidth / 2 + mProductsFrameWidth / 2), 1, 0.0F, 1, 0.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(false);
        animationset.setDuration(500L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;
            final boolean val$isBarcode;

            public void onAnimationEnd(Animation animation)
            {
                mProductsFrame.setVisibility(8);
                if (!isBarcode)
                {
                    hideTutorialTitleAndDescription();
                    startDeviceFrameTranslateAnimation4();
                    return;
                } else
                {
                    com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                        final _cls9 this$1;

                        public void run()
                        {
                            showTutorialTitleAndDescription(com.amazon.mShop.android.lib.R.string.view_it_tutorial_title_3, com.amazon.mShop.android.lib.R.string.view_it_tutorial_description_3);
                            showHistorySlidingArrow();
                        }

            
            {
                this$1 = _cls9.this;
                super();
            }
                    }, 100L);
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
                this$0 = ViewItTutorialContentView.this;
                isBarcode = flag;
                super();
            }
        });
        mProductsFrame.startAnimation(animationset);
    }

    public void hideNextButton()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(1000L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;

            public void onAnimationEnd(Animation animation)
            {
                mNextButton.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
        mNextButton.startAnimation(animationset);
    }

    public void hideTutorialTitleAndDescription()
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet animationset = new AnimationSet(true);
        animationset.addAnimation(alphaanimation);
        animationset.setInterpolator(new DecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(300L);
        mTutorialTitleAndDescription.startAnimation(animationset);
    }

    public void reLayoutContentView(int i, int j)
    {
        mDeviceFrameHeight = i;
        mProductsFrameWidth = j;
        mDeviceFrameTop = (float)mDeviceFrameHeight * 0.08F;
        mDeviceFrameBottom = (float)mDeviceFrameHeight * 0.1F;
        mScannedItemAnimationToYValue = (float)(mDeviceFrameHeight / 2) - mDeviceFrameBottom - (float)(mScannedItemHeight / 2);
        setHistoryTrayToBottomOfDeviceFrame();
        setScannedHistoryItemToBottomOfDeviceFrame();
    }

    public void startDeviceFrameTranslateAnimation1()
    {
        mDeviceAndHistoryTrayFrame.setVisibility(0);
        float f = mScreenWidth;
        final float toXValue = (float)mProductsFrameWidth * 0.375F;
        TranslateAnimation translateanimation = new TranslateAnimation(0, -f, 0, -toXValue, 1, 0.0F, 1, 0.0F) {

            final ViewItTutorialContentView this$0;

            protected void applyTransformation(float f1, Transformation transformation)
            {
                super.applyTransformation(f1, transformation);
                transformation = (View)getParent();
                postInvalidate();
                transformation.postInvalidate();
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super(i, f, j, f1, k, f2, l, f3);
            }
        };
        startTranslateAnimation(mDeviceAndHistoryTrayFrame, translateanimation, 1000, new android.view.animation.Animation.AnimationListener() {

            final ViewItTutorialContentView this$0;
            final float val$toXValue;

            public void onAnimationEnd(Animation animation)
            {
                startScannedItemTranslateAnimation(0, -toXValue);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                reLayoutContentView();
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                toXValue = f;
                super();
            }
        });
    }

    public void updateContentView()
    {
        mSkipButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_skip_button);
        mNextButton = (Button)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_next_button);
        mTutorialTitleAndDescription = findViewById(com.amazon.mShop.android.lib.R.id.view_it_tutorial_title_and_description);
        mTutorialTitle = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.view_it_tutorial_title);
        mTutorialDescription = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.view_it_tutorial_description);
        mHistoryArrow = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_history_arrow);
        mHistoryBottomTray = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_history_bottom_tray);
        mHistoryTrayFrame = (LinearLayout)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_animation_history_tray_frame);
        mHistoryTrayFrameHeight = mHistoryTrayFrame.getBackground().getIntrinsicHeight();
        mHistoryTrayFrameHandle = (float)mHistoryTrayFrameHeight * 0.04F;
        mHistoryTrayFrame.setPadding(0, (int)mHistoryTrayFrameHandle, 0, 0);
        mScannedItemFrame = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_animation_scanned_item_frame);
        mScannedHistoryItem = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_history_scanned_item);
        mScannedItemHeight = mScannedItemFrame.getDrawable().getIntrinsicHeight();
        mScannedItemWidth = mScannedItemFrame.getDrawable().getIntrinsicWidth();
        mProductsFrame = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_animation_products_frame);
        mProductsFrameWidth = mProductsFrame.getWidth();
        mDeviceAndHistoryTrayFrame = (ViewGroup)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_animation_device_and_history_frame);
        mDeviceFrame = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.tutorial_animation_device_frame);
        mScreenWidth = ViewItUtil.getScreenSize(mActivity).x;
        mSkipButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItTutorialContentView this$0;

            public void onClick(View view)
            {
                completeTutorial();
                RefMarkerObserver.logRefMarker("fl_tutor_sk_btn");
            }

            
            {
                this$0 = ViewItTutorialContentView.this;
                super();
            }
        });
    }

    public void updateTitleAndDescription(int i, int j)
    {
        mTutorialTitle.setText(i);
        mTutorialDescription.setText(j);
        mTutorialTitleAndDescription.setVisibility(0);
    }















}
