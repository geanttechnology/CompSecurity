// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class mt
    implements android.view.animation.Animation.AnimationListener
{

    final ActivityCameraNew a;

    public mt(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        ActivityCameraNew.ad(a).clearAnimation();
        animation = (android.widget.FrameLayout.LayoutParams)ActivityCameraNew.ad(a).getLayoutParams();
        animation.gravity = 80;
        animation.bottomMargin = ActivityCameraNew.Z(a).getHeight();
        ActivityCameraNew.ad(a).setLayoutParams(animation);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
