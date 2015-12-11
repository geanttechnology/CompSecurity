// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

public class ll
{

    public static Animation a(Activity activity)
    {
        activity = AnimationUtils.loadAnimation(activity.getApplicationContext(), 0x7f040002);
        activity.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation)
            {
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

        });
        return activity;
    }

    public static void a(View view)
    {
        int i = view.getMeasuredHeight();
        Animation animation = new Animation(view, i) {

            final View a;
            final int b;

            protected void applyTransformation(float f, Transformation transformation)
            {
                if (f == 1.0F)
                {
                    a.setVisibility(8);
                    return;
                } else
                {
                    a.getLayoutParams().height = b - (int)((float)b * f);
                    a.requestLayout();
                    return;
                }
            }

            public boolean willChangeBounds()
            {
                return true;
            }

            
            {
                a = view;
                b = i;
                super();
            }
        };
        animation.setDuration((int)((float)i / view.getContext().getResources().getDisplayMetrics().density));
        view.startAnimation(animation);
    }

    public static Animation b(Activity activity)
    {
        activity = AnimationUtils.loadAnimation(activity.getApplicationContext(), 0x7f04000d);
        activity.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            public void onAnimationEnd(Animation animation)
            {
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

        });
        return activity;
    }

    public static void b(View view)
    {
        view.bringToFront();
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(2000L);
        alphaanimation.setAnimationListener(new android.view.animation.Animation.AnimationListener(view) {

            final View a;

            public void onAnimationEnd(Animation animation)
            {
                a.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                a = view;
                super();
            }
        });
        AlphaAnimation alphaanimation1 = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation1.setDuration(300L);
        alphaanimation1.setAnimationListener(new android.view.animation.Animation.AnimationListener(view, alphaanimation) {

            final View a;
            final Animation b;

            public void onAnimationEnd(Animation animation)
            {
                try
                {
                    Thread.sleep(2000L);
                }
                // Misplaced declaration of an exception variable
                catch (Animation animation)
                {
                    animation.printStackTrace();
                }
                a.startAnimation(b);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
                a.setVisibility(0);
            }

            
            {
                a = view;
                b = animation;
                super();
            }
        });
        view.startAnimation(alphaanimation1);
    }
}
