// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.utils.animations;

import android.view.View;
import android.view.animation.AlphaAnimation;

public class AnimationUtil
{

    public AnimationUtil()
    {
    }

    public static void fadeIn(View view, int i)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(i);
        alphaanimation.setFillAfter(true);
        view.startAnimation(alphaanimation);
    }

    public static void fadeOut(View view, int i)
    {
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0F, 0.0F);
        alphaanimation.setDuration(i);
        alphaanimation.setFillAfter(true);
        view.startAnimation(alphaanimation);
    }
}
