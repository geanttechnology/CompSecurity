// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.TextView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

class mp
    implements android.view.animation.Animation.AnimationListener
{

    final mo a;

    mp(mo mo1)
    {
        a = mo1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        ActivityCameraNew.aj(a.a).setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
