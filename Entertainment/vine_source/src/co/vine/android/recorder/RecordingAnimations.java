// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import co.vine.android.animation.SimpleAnimationListener;

public class RecordingAnimations
{

    public RecordingAnimations()
    {
    }

    public static AnimationSet getFocusAnimationSet(AlphaAnimation alphaanimation, ImageView imageview)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)imageview.getLayoutParams();
        if (layoutparams == null)
        {
            throw new RuntimeException("XML is missing layout params for focus indicator. Wrong view?");
        } else
        {
            ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.85F, 1.0F, 0.85F, layoutparams.width / 2, layoutparams.height / 2);
            scaleanimation.setRepeatMode(2);
            scaleanimation.setRepeatCount(1);
            scaleanimation.setDuration(80L);
            scaleanimation.setFillAfter(true);
            scaleanimation.setAnimationListener(new SimpleAnimationListener(imageview, alphaanimation) {

                final AlphaAnimation val$focusDismissAnimation;
                final ImageView val$focusIndicator;

                public void onAnimationEnd(Animation animation)
                {
                    focusIndicator.startAnimation(focusDismissAnimation);
                }

            
            {
                focusIndicator = imageview;
                focusDismissAnimation = alphaanimation;
                super();
            }
            });
            alphaanimation = new AnimationSet(true);
            alphaanimation.addAnimation(new AlphaAnimation(0.0F, 1.0F));
            alphaanimation.addAnimation(new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, layoutparams.width / 2, layoutparams.height / 2));
            alphaanimation.setFillAfter(true);
            alphaanimation.setDuration(300L);
            alphaanimation.setAnimationListener(new SimpleAnimationListener(imageview, scaleanimation) {

                final ImageView val$focusIndicator;
                final ScaleAnimation val$focusResizeAnimation;

                public void onAnimationEnd(Animation animation)
                {
                    focusIndicator.startAnimation(focusResizeAnimation);
                }

            
            {
                focusIndicator = imageview;
                focusResizeAnimation = scaleanimation;
                super();
            }
            });
            return alphaanimation;
        }
    }

    public static AlphaAnimation getFocusDismissAnimation(ImageView imageview)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(300L);
        alphaanimation.setFillAfter(true);
        alphaanimation.setAnimationListener(new SimpleAnimationListener(imageview) {

            final ImageView val$focusIndicator;

            public void onAnimationEnd(Animation animation)
            {
                if (focusIndicator != null)
                {
                    focusIndicator.setVisibility(4);
                }
            }

            
            {
                focusIndicator = imageview;
                super();
            }
        });
        return alphaanimation;
    }

    public static AlphaAnimation getGridDimissAnimation(SimpleAnimationListener simpleanimationlistener)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(200L);
        alphaanimation.setFillAfter(true);
        alphaanimation.setAnimationListener(simpleanimationlistener);
        return alphaanimation;
    }

    public static AlphaAnimation getShowGridAinimation(SimpleAnimationListener simpleanimationlistener)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(200L);
        alphaanimation.setFillAfter(true);
        alphaanimation.setAnimationListener(simpleanimationlistener);
        return alphaanimation;
    }
}
