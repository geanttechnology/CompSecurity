// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.animations;

import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.TextView;

public class AnimationFAB
{

    public AnimationFAB()
    {
    }

    public static void albumOverlayFadeIn(View view, int i)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        view.setAnimation(animationset);
    }

    public static void buttonFadeInCenter(ImageButton imagebutton, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, imagebutton.getWidth() / 2, imagebutton.getHeight() / 2);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        imagebutton.setAnimation(animationset);
    }

    public static void buttonFadeInDown(ImageButton imagebutton, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, imagebutton.getWidth() / 2, imagebutton.getHeight());
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        imagebutton.setAnimation(animationset);
    }

    public static void buttonFadeOut(ImageButton imagebutton, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, imagebutton.getWidth() / 2, imagebutton.getHeight());
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        imagebutton.setAnimation(animationset);
    }

    public static void defaultFadeIn(View view, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, view.getWidth() / 2, view.getHeight() / 2);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        view.setAnimation(animationset);
    }

    public static void defaultFadeOut(View view, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, view.getWidth() / 2, view.getHeight() / 2);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        view.setAnimation(animationset);
    }

    public static void textFadeIn(TextView textview, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, textview.getWidth(), textview.getHeight() / 2);
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        textview.setAnimation(animationset);
    }

    public static void textFadeOut(TextView textview, int i)
    {
        ScaleAnimation scaleanimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, textview.getWidth(), textview.getHeight() / 2);
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        scaleanimation.setDuration(i);
        alphaanimation.setInterpolator(new AccelerateInterpolator());
        alphaanimation.setDuration(i);
        AnimationSet animationset = new AnimationSet(false);
        animationset.addAnimation(alphaanimation);
        animationset.addAnimation(scaleanimation);
        textview.setAnimation(animationset);
    }
}
