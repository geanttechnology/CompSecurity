// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

// Referenced classes of package com.target.ui.util:
//            al

public class aj
{

    private static final String BACKGROUND_COLOR_ATTR = "backgroundColor";
    public static final int DEFAULT_ANIMATION_TIME = 300;
    private static final String PROPERTY_ROTATION = "rotation";
    private static final float PULSE_SCALE_ENDPOINT = 1F;
    private static final float PULSE_SCALE_MIDPOINT = 1.5F;

    public static Animator a(View view)
    {
        return b(view, 1.0F, 1.5F, 300);
    }

    public static Animator a(View view, float f1, float f2)
    {
        return c(view, f1, f2, 300);
    }

    public static Animator a(View view, float f1, float f2, int i)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[] {
            f1, f2
        });
        objectanimator.setDuration(i);
        view = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[] {
            f1, f2
        });
        view.setDuration(i);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, view
        });
        return animatorset;
    }

    private static Animator a(View view, float f1, float f2, int i, int j)
    {
        view = ObjectAnimator.ofFloat(view, View.ALPHA, new float[] {
            f1, f2
        });
        view.setDuration(i);
        view.setStartDelay(j);
        return view;
    }

    public static Animator a(View view, int i, int j)
    {
        view = ObjectAnimator.ofObject(view, "backgroundColor", new ArgbEvaluator(), new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        view.setDuration(300L);
        return view;
    }

    public static AnimatorSet a(View view, View view1, boolean flag)
    {
        float f1;
        ValueAnimator valueanimator;
        AnimatorSet animatorset;
        int i;
        int j;
        if (flag)
        {
            j = view.getMeasuredHeight();
            i = 0;
        } else
        {
            android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
            layoutparams.height = -2;
            view.setLayoutParams(layoutparams);
            view.measure(0, 0);
            i = view.getMeasuredHeight();
            j = 0;
        }
        valueanimator = ValueAnimator.ofInt(new int[] {
            j, i
        });
        valueanimator.addUpdateListener(new android.animation.ValueAnimator.AnimatorUpdateListener(view) {

            final View val$container;

            public void onAnimationUpdate(ValueAnimator valueanimator1)
            {
                android.view.ViewGroup.LayoutParams layoutparams1 = container.getLayoutParams();
                layoutparams1.height = ((Integer)valueanimator1.getAnimatedValue()).intValue();
                container.setLayoutParams(layoutparams1);
            }

            
            {
                container = view;
                super();
            }
        });
        if (flag)
        {
            f1 = 0.0F;
        } else
        {
            f1 = 180F;
        }
        view1 = ObjectAnimator.ofFloat(view1, View.ROTATION, new float[] {
            view1.getRotation(), f1
        });
        animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            valueanimator, view1
        });
        animatorset.setDuration(300L);
        animatorset.addListener(new AnimatorListenerAdapter(view, flag) {

            final View val$container;
            final boolean val$currentlyOpen;

            public void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                if (currentlyOpen)
                {
                    al.c(container);
                }
            }

            public void onAnimationStart(Animator animator)
            {
                super.onAnimationStart(animator);
                al.b(container);
            }

            
            {
                container = view;
                currentlyOpen = flag;
                super();
            }
        });
        return animatorset;
    }

    public static void a(View view, float f1)
    {
        a(view, f1, 300);
    }

    public static void a(View view, float f1, int i)
    {
        a(view, view.getAlpha(), f1, i, 0).start();
    }

    public static void a(View view, int i)
    {
        a(view, i, ((AnimatorListenerAdapter) (null)));
    }

    public static void a(View view, int i, AnimatorListenerAdapter animatorlisteneradapter)
    {
        Animator animator = c(view, i, 0);
        animator.addListener(new AnimatorListenerAdapter(view) {

            final View val$view;

            public void onAnimationEnd(Animator animator1)
            {
                al.c(view);
            }

            
            {
                view = view1;
                super();
            }
        });
        if (animatorlisteneradapter != null)
        {
            animator.addListener(animatorlisteneradapter);
        }
        animator.start();
    }

    public static void a(View view, AnimatorListenerAdapter animatorlisteneradapter)
    {
        a(view, 600, animatorlisteneradapter);
    }

    public static void a(View view, View view1)
    {
        Animator animator = b(view, 300, 0);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.play(animator);
        animatorset.addListener(new AnimatorListenerAdapter(view, view1) {

            final View val$fadeInAndShow;
            final View val$viewToHide;

            public void onAnimationEnd(Animator animator1)
            {
                al.a(fadeInAndShow, new View[] {
                    viewToHide
                });
            }

            public void onAnimationStart(Animator animator1)
            {
                al.b(new View[] {
                    fadeInAndShow, viewToHide
                });
            }

            
            {
                fadeInAndShow = view;
                viewToHide = view1;
                super();
            }
        });
        animatorset.start();
    }

    public static Animator b(View view, float f1, float f2, int i)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[] {
            f1, f2, f1
        });
        view = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[] {
            f1, f2, f1
        });
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.setDuration(i);
        animatorset.playTogether(new Animator[] {
            objectanimator, view
        });
        return animatorset;
    }

    private static Animator b(View view, int i, int j)
    {
        return a(view, 0.0F, 1.0F, i, j);
    }

    public static AnimatorSet b(View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[] {
            0.0F, 1.0F
        });
        objectanimator.setDuration(300L);
        view = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[] {
            (float)view.getRight(), 0.0F
        });
        view.setDuration(300L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, view
        });
        return animatorset;
    }

    public static void b(View view, int i)
    {
        Animator animator = b(view, i, 0);
        animator.addListener(new AnimatorListenerAdapter(view) {

            final View val$view;

            public void onAnimationStart(Animator animator1)
            {
                al.b(view);
            }

            
            {
                view = view1;
                super();
            }
        });
        animator.start();
    }

    public static Animator c(View view, float f1, float f2, int i)
    {
        view = ObjectAnimator.ofFloat(view, View.ALPHA, new float[] {
            f1, f2
        });
        view.setDuration(i);
        return view;
    }

    private static Animator c(View view, int i, int j)
    {
        return a(view, view.getAlpha(), 0.0F, i, j);
    }

    public static AnimatorSet c(View view)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(view, View.ALPHA, new float[] {
            1.0F, 0.0F
        });
        objectanimator.setDuration(300L);
        view = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[] {
            0.0F, (float)view.getRight()
        });
        view.setDuration(300L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            objectanimator, view
        });
        return animatorset;
    }

    public static Animator d(View view)
    {
        view = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[] {
            (float)view.getHeight(), 0.0F
        });
        view.setDuration(300L);
        return view;
    }

    private static Animator d(View view, int i, int j)
    {
        view = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[] {
            (float)(-view.getHeight()), 0.0F
        });
        view.setDuration(i);
        view.setStartDelay(j);
        return view;
    }

    public static Animator e(View view)
    {
        view = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[] {
            0.0F, (float)view.getHeight()
        });
        view.setDuration(300L);
        return view;
    }

    public static void f(View view)
    {
        Animator animator = b(view, 600, 0);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addListener(new AnimatorListenerAdapter(view) {

            final View val$view;

            public void onAnimationEnd(Animator animator1)
            {
                super.onAnimationEnd(animator1);
                al.b(view);
            }

            
            {
                view = view1;
                super();
            }
        });
        animator.start();
    }

    public static void g(View view)
    {
        a(view, 600);
    }

    public static void h(View view)
    {
        Animator animator = b(view, 600, 0);
        Animator animator1 = d(view, 300, 0);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.playTogether(new Animator[] {
            animator, animator1
        });
        animatorset.addListener(new AnimatorListenerAdapter(view) {

            final View val$view;

            public void onAnimationEnd(Animator animator2)
            {
                super.onAnimationEnd(animator2);
                al.b(view);
            }

            
            {
                view = view1;
                super();
            }
        });
        animatorset.start();
    }
}
