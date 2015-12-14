// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityContinousPhotoViewer;

public class ot
    implements android.view.animation.Animation.AnimationListener
{

    final ActivityContinousPhotoViewer a;

    public ot(ActivityContinousPhotoViewer activitycontinousphotoviewer)
    {
        a = activitycontinousphotoviewer;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (!a.C)
        {
            a.d.setVisibility(8);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
