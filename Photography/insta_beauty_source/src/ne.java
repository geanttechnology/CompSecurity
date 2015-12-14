// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

public class ne
    implements android.view.animation.Animation.AnimationListener
{

    final ActivityCameraNew a;

    public ne(ActivityCameraNew activitycameranew)
    {
        a = activitycameranew;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        animation = AnimationUtils.loadAnimation(a, 0x7f040013);
        animation.setAnimationListener(new nf(this));
        ActivityCameraNew.h(a).setAnimation(animation);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
