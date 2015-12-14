// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityMediaPlayerTest;

public class pk
    implements android.view.animation.Animation.AnimationListener
{

    final ActivityMediaPlayerTest a;

    public pk(ActivityMediaPlayerTest activitymediaplayertest)
    {
        a = activitymediaplayertest;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (!a.b)
        {
            ActivityMediaPlayerTest.b(a).setVisibility(8);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
