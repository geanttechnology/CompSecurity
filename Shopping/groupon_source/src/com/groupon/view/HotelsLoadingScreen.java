// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.groupon.util.DeviceInfoUtil;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class HotelsLoadingScreen extends LinearLayout
{

    private static final int FADE_ANIMATION_DURATION = 300;
    public static final int buildingResIds[] = {
        0x7f0201cc, 0x7f0201d0, 0x7f0201cf, 0x7f0201ca, 0x7f0201c9, 0x7f0201ce, 0x7f0201cd, 0x7f0201c8, 0x7f0201cb
    };
    private boolean areAnimationsSet;
    private ImageView building;
    private ImageView cloud;
    private DeviceInfoUtil deviceInfoUtil;
    private DisplayMetrics displayMetrics;
    private ImageView plane;

    public HotelsLoadingScreen(Context context)
    {
        this(context, null);
    }

    public HotelsLoadingScreen(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        deviceInfoUtil = (DeviceInfoUtil)RoboGuice.getInjector(context).getInstance(com/groupon/util/DeviceInfoUtil);
        inflate(context, 0x7f030141, this);
        setupViews();
    }

    private void animate(final ImageView imageView, final int images[], final int imageIndex, final boolean forever)
    {
        imageView.setVisibility(4);
        imageView.setImageResource(images[imageIndex]);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setInterpolator(new DecelerateInterpolator());
        alphaanimation.setDuration(300L);
        AlphaAnimation alphaanimation1 = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation1.setInterpolator(new AccelerateInterpolator());
        alphaanimation1.setStartOffset(300L);
        alphaanimation1.setDuration(300L);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(alphaanimation1);
        animationset.setRepeatCount(1);
        imageView.setAnimation(animationset);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final HotelsLoadingScreen this$0;
            final boolean val$forever;
            final int val$imageIndex;
            final ImageView val$imageView;
            final int val$images[];

            public void onAnimationEnd(Animation animation)
            {
                if (images.length - 1 > imageIndex)
                {
                    animate(imageView, images, imageIndex + 1, forever);
                } else
                if (forever)
                {
                    animate(imageView, images, 0, forever);
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
                this$0 = HotelsLoadingScreen.this;
                images = ai;
                imageIndex = i;
                imageView = imageview;
                forever = flag;
                super();
            }
        });
    }

    private void setBuildingsAnimation()
    {
        animate(building, buildingResIds, 0, false);
    }

    private void setCloudAnimation()
    {
        TranslateAnimation translateanimation = new TranslateAnimation(0.0F, (int)deviceInfoUtil.getDensity() * 30, 0.0F, 0.0F);
        translateanimation.setDuration(5000L);
        translateanimation.setRepeatCount(-1);
        translateanimation.setRepeatMode(2);
        cloud.startAnimation(translateanimation);
    }

    private void setPlaneAnimation()
    {
        int i = displayMetrics.widthPixels / 2;
        int j = (int)deviceInfoUtil.getDensity();
        TranslateAnimation translateanimation = new TranslateAnimation(i, displayMetrics.widthPixels, 0.0F, 0.0F);
        translateanimation.setDuration(10000L);
        translateanimation.setInterpolator(new AccelerateInterpolator());
        translateanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final HotelsLoadingScreen this$0;
            final int val$fromXFull;

            public void onAnimationEnd(Animation animation)
            {
                animation = new TranslateAnimation(fromXFull, displayMetrics.widthPixels, 0.0F, 0.0F);
                animation.setDuration(20000L);
                animation.setRepeatCount(-1);
                animation.setRepeatMode(1);
                animation.setInterpolator(new AccelerateInterpolator());
                plane.startAnimation(animation);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = HotelsLoadingScreen.this;
                fromXFull = i;
                super();
            }
        });
        plane.startAnimation(translateanimation);
    }

    private void setupViews()
    {
        displayMetrics = deviceInfoUtil.getDisplayMetrics();
        cloud = (ImageView)findViewById(0x7f1003bd);
        plane = (ImageView)findViewById(0x7f1003be);
        building = (ImageView)findViewById(0x7f1003c0);
        areAnimationsSet = false;
    }

    protected void clearAnimations()
    {
        cloud.clearAnimation();
        plane.clearAnimation();
        building.clearAnimation();
        cloud.setImageBitmap(null);
        plane.setImageBitmap(null);
        building.setImageBitmap(null);
        areAnimationsSet = false;
    }

    protected void setAnimations()
    {
        if (!areAnimationsSet)
        {
            setCloudAnimation();
            setPlaneAnimation();
            setBuildingsAnimation();
            areAnimationsSet = true;
        }
    }

    public void setVisibility(int i)
    {
        super.setVisibility(i);
        if (i == 0)
        {
            setAnimations();
            return;
        } else
        {
            clearAnimations();
            return;
        }
    }




}
