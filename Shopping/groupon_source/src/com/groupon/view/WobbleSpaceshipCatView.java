// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.groupon.animation.AnimatorPath;
import com.groupon.animation.PathEvaluator;
import com.groupon.animation.PathPoint;
import com.groupon.util.WobbleSpaceshipCatAnimationListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WobbleSpaceshipCatView extends RelativeLayout
{

    private static final String PROPERTY_ALPHA = "alpha";
    private static final String PROPERTY_LOCATION = "location";
    private static final String PROPERTY_ROTATION = "rotation";
    private static final int SPACESHIP_LIGHT_COUNT = 5;
    private static final int SPACESHIP_LIGHT_PADDING_TOP[] = {
        5, 14, 17, 14, 5
    };
    private AnimatorSet lightsSet;
    private boolean progressAnimationCanceled;
    private LinearLayout spaceshipLightsContainer;
    private ObjectAnimator wobblePathAnimation;
    private AnimatorSet wobbleRotateAnimation;
    public WobbleSpaceshipCatAnimationListener wobbleSpaceshipCatAnimationListener;
    private RelativeLayout wobbleSpaceshipCatContainer;

    public WobbleSpaceshipCatView(Context context)
    {
        this(context, null, 0);
    }

    public WobbleSpaceshipCatView(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public WobbleSpaceshipCatView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        context = context.obtainStyledAttributes(attributeset, com.groupon.R.styleable.WobbleSpaceshipCat, 0, 0);
        i = context.getResourceId(0, 0x7f0202ee);
        int j = context.getColor(1, getResources().getColor(0x7f0e0110));
        int k = context.getDimensionPixelSize(2, (int)getResources().getDimension(0x7f0b0229));
        int l = context.getDimensionPixelSize(3, 0);
        LayoutInflater.from(getContext()).inflate(0x7f03022b, this, true);
        wobbleSpaceshipCatContainer = (RelativeLayout)findViewById(0x7f100590);
        spaceshipLightsContainer = (LinearLayout)findViewById(0x7f100591);
        context = (ImageView)findViewById(0x7f1003e0);
        wobbleSpaceshipCatContainer.setLayerType(1, null);
        spaceshipLightsContainer.setPadding(0, l, 0, 0);
        context.setImageResource(i);
        for (i = 0; i < 5; i++)
        {
            context = new ImageView(getContext());
            attributeset = new ShapeDrawable(new OvalShape());
            attributeset.getPaint().setColor(j);
            attributeset.setIntrinsicHeight(k);
            attributeset.setIntrinsicWidth(k);
            context.setImageDrawable(attributeset);
            context.setPadding(0, (int)TypedValue.applyDimension(1, SPACESHIP_LIGHT_PADDING_TOP[i], getResources().getDisplayMetrics()), 0, 0);
            spaceshipLightsContainer.addView(context, i, new android.widget.LinearLayout.LayoutParams(0, -2, 1.0F));
        }

    }

    public void curveUp()
    {
        Object obj = new AnimatorPath();
        ((AnimatorPath) (obj)).moveTo(0.0F, 0.0F);
        ((AnimatorPath) (obj)).curveTo(100F, -150F, 0.0F, -200F, 0.0F, -200F);
        obj = ObjectAnimator.ofObject(this, "location", new PathEvaluator(), ((AnimatorPath) (obj)).getPoints().toArray());
        ((ObjectAnimator) (obj)).setDuration(700L);
        ((ObjectAnimator) (obj)).setInterpolator(new DecelerateInterpolator());
        ((ObjectAnimator) (obj)).start();
    }

    public void exitRight()
    {
        Object obj = new DisplayMetrics();
        ((Activity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        AnimatorPath animatorpath = new AnimatorPath();
        animatorpath.moveTo(0.0F, -200F);
        animatorpath.curveTo(200F, -170F, ((DisplayMetrics) (obj)).widthPixels, -200F, ((DisplayMetrics) (obj)).widthPixels, -200F);
        obj = ObjectAnimator.ofObject(this, "location", new PathEvaluator(), animatorpath.getPoints().toArray());
        ((ObjectAnimator) (obj)).setDuration(300L);
        ((ObjectAnimator) (obj)).setStartDelay(500L);
        ((ObjectAnimator) (obj)).setInterpolator(new AccelerateInterpolator());
        ((ObjectAnimator) (obj)).addListener(new AnimatorListenerAdapter() {

            final WobbleSpaceshipCatView this$0;

            public void onAnimationEnd(Animator animator)
            {
                wobbleSpaceshipCatAnimationListener.onExitRightAnimationEnd();
            }

            
            {
                this$0 = WobbleSpaceshipCatView.this;
                super();
            }
        });
        ((ObjectAnimator) (obj)).start();
    }

    public void loopProgressAnimation(int i)
    {
        wobbleRotateAnimation = new AnimatorSet();
        wobbleRotateAnimation.playSequentially(new Animator[] {
            ObjectAnimator.ofFloat(wobbleSpaceshipCatContainer, "rotation", new float[] {
                0.0F, -3F
            }).setDuration(150L), ObjectAnimator.ofFloat(wobbleSpaceshipCatContainer, "rotation", new float[] {
                -3F, 3F
            }).setDuration(300L), ObjectAnimator.ofFloat(wobbleSpaceshipCatContainer, "rotation", new float[] {
                3F, 0.0F
            }).setDuration(150L)
        });
        wobbleRotateAnimation.addListener(new AnimatorListenerAdapter() {

            final WobbleSpaceshipCatView this$0;

            public void onAnimationCancel(Animator animator)
            {
                progressAnimationCanceled = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                if (!progressAnimationCanceled)
                {
                    wobbleRotateAnimation.start();
                }
            }

            public void onAnimationStart(Animator animator)
            {
                progressAnimationCanceled = false;
            }

            
            {
                this$0 = WobbleSpaceshipCatView.this;
                super();
            }
        });
        wobbleRotateAnimation.start();
        Object obj = new AnimatorPath();
        ((AnimatorPath) (obj)).lineTo(3F, -3F);
        ((AnimatorPath) (obj)).lineTo(3F, 3F);
        ((AnimatorPath) (obj)).lineTo(-3F, 3F);
        ((AnimatorPath) (obj)).lineTo(-3F, -3F);
        ((AnimatorPath) (obj)).lineTo(0.0F, -3F);
        ((AnimatorPath) (obj)).lineTo(3F, 0.0F);
        ((AnimatorPath) (obj)).lineTo(0.0F, 3F);
        ((AnimatorPath) (obj)).lineTo(-3F, 0.0F);
        ((AnimatorPath) (obj)).lineTo(3F, -3F);
        wobblePathAnimation = ObjectAnimator.ofObject(this, "location", new PathEvaluator(), ((AnimatorPath) (obj)).getPoints().toArray());
        wobblePathAnimation.setDuration(2000L);
        wobblePathAnimation.setRepeatCount(-1);
        wobblePathAnimation.start();
        obj = new ArrayList();
        for (int j = 0; j < spaceshipLightsContainer.getChildCount(); j++)
        {
            View view = spaceshipLightsContainer.getChildAt(j);
            view.setAlpha(0.0F);
            ((List) (obj)).add(ObjectAnimator.ofFloat(view, "alpha", new float[] {
                0.0F, 1.0F
            }).setDuration(i));
            ((List) (obj)).add(ObjectAnimator.ofFloat(view, "alpha", new float[] {
                1.0F, 0.0F
            }).setDuration(i));
        }

        lightsSet = new AnimatorSet();
        lightsSet.playSequentially(((List) (obj)));
        lightsSet.addListener(new AnimatorListenerAdapter() {

            final WobbleSpaceshipCatView this$0;

            public void onAnimationCancel(Animator animator)
            {
                progressAnimationCanceled = true;
            }

            public void onAnimationEnd(Animator animator)
            {
                if (!progressAnimationCanceled)
                {
                    lightsSet.start();
                }
            }

            public void onAnimationStart(Animator animator)
            {
                progressAnimationCanceled = false;
            }

            
            {
                this$0 = WobbleSpaceshipCatView.this;
                super();
            }
        });
        lightsSet.start();
    }

    public void setLocation(PathPoint pathpoint)
    {
        wobbleSpaceshipCatContainer.setTranslationX(pathpoint.getX());
        wobbleSpaceshipCatContainer.setTranslationY(pathpoint.getY());
    }

    public void stopProgressAnimation()
    {
        if (wobbleRotateAnimation != null)
        {
            wobbleRotateAnimation.removeAllListeners();
            wobbleRotateAnimation.cancel();
        }
        if (wobblePathAnimation != null)
        {
            wobblePathAnimation.removeAllListeners();
            wobblePathAnimation.cancel();
        }
        if (lightsSet != null)
        {
            lightsSet.removeAllListeners();
            lightsSet.cancel();
        }
    }

    public void tiltLeftRight()
    {
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playSequentially(new Animator[] {
            ObjectAnimator.ofFloat(wobbleSpaceshipCatContainer, "rotation", new float[] {
                0.0F, -20F
            }).setDuration(300L), ObjectAnimator.ofFloat(wobbleSpaceshipCatContainer, "rotation", new float[] {
                -20F, 20F
            }).setDuration(200L)
        });
        animatorset.start();
    }




/*
    static boolean access$002(WobbleSpaceshipCatView wobblespaceshipcatview, boolean flag)
    {
        wobblespaceshipcatview.progressAnimationCanceled = flag;
        return flag;
    }

*/


}
