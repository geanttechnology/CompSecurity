// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.animations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;

public class AnimatableResultsImage extends ImageView
{

    public static final int DEFAULT_ANIMATION_SPEED = 350;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/animations/AnimatableResultsImage);
    private int animationSpeed;
    private View parentView;
    private Object targetModel;

    public AnimatableResultsImage(Context context)
    {
        super(context);
        animationSpeed = 350;
    }

    public AnimatableResultsImage(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        animationSpeed = 350;
    }

    public AnimatableResultsImage(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        animationSpeed = 350;
    }

    public void animateToDestination(int ai[], int ai1[], android.animation.Animator.AnimatorListener animatorlistener)
    {
        targetModel = null;
        if (ai == null || ai.length != 2 || ai1 == null || ai1.length != 2)
        {
            log.error("Unable to start animation, invalid input");
            setVisibility(8);
            return;
        }
        android.widget.FrameLayout.LayoutParams layoutparams = (android.widget.FrameLayout.LayoutParams)getLayoutParams();
        if (layoutparams == null)
        {
            log.error("Unable to get the AnimatableResultsImage's layout parameters when starting animation");
            setVisibility(8);
            return;
        }
        float f = ai[0] - layoutparams.leftMargin;
        float f1 = ai[1] + -layoutparams.topMargin;
        ai = new AnimatorSet();
        ai.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(this, "translationX", new float[] {
                0.0F, f
            }), ObjectAnimator.ofFloat(this, "translationY", new float[] {
                0.0F, f1
            }), ObjectAnimator.ofInt(this, "width", new int[] {
                ai1[0]
            }), ObjectAnimator.ofInt(this, "height", new int[] {
                ai1[1]
            })
        });
        if (animatorlistener != null)
        {
            ai.addListener(animatorlistener);
        }
        ai.setDuration(animationSpeed).start();
    }

    public Object getTargetProductModel()
    {
        return targetModel;
    }

    public void positionOverInitialImage(ImageView imageview)
    {
        if (imageview == null)
        {
            log.error("Invalid initialImage");
            setVisibility(8);
            return;
        }
        setImageDrawable(imageview.getDrawable());
        android.view.ViewGroup.MarginLayoutParams marginlayoutparams = (android.view.ViewGroup.MarginLayoutParams)getLayoutParams();
        if (marginlayoutparams == null)
        {
            log.error("Unable to get the AnimatableResultsImage's layout parameters when setting the initial position");
            setVisibility(8);
            return;
        }
        marginlayoutparams.width = imageview.getWidth();
        marginlayoutparams.height = imageview.getHeight();
        int ai[] = new int[2];
        if (parentView == null)
        {
            log.error("positionOverInitialImage called without a valid parent view");
            setVisibility(8);
            return;
        } else
        {
            parentView.getLocationOnScreen(ai);
            int ai1[] = new int[2];
            imageview.getLocationOnScreen(ai1);
            int i = ai1[0];
            int j = ai[0];
            int k = ai1[1];
            int l = ai[1];
            setTranslationX(0.0F);
            setTranslationY(0.0F);
            marginlayoutparams.setMargins(i - j, k - l, 0, 0);
            setLayoutParams(marginlayoutparams);
            setVisibility(0);
            return;
        }
    }

    public void reset()
    {
        targetModel = null;
        animationSpeed = 350;
        setVisibility(8);
    }

    public void setAnimationSpeed(int i)
    {
        animationSpeed = i;
    }

    public void setHeight(int i)
    {
        getLayoutParams().height = i;
        requestLayout();
    }

    public void setParentView(View view)
    {
        parentView = view;
    }

    public void setTargetModel(Object obj)
    {
        targetModel = obj;
    }

    public void setWidth(int i)
    {
        getLayoutParams().width = i;
        requestLayout();
    }

}
