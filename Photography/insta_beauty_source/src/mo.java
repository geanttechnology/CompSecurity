// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mo
    implements android.view.animation.Animation.AnimationListener
{

    final ActivityCameraNew a;

    public mo(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        animation = new AlphaAnimation(1.0F, 0.0F);
        animation.setDuration(1000L);
        animation.setAnimationListener(new mp(this));
        ActivityCameraNew.aj(a).startAnimation(animation);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        ActivityCameraNew.aj(a).setVisibility(0);
    }
}
