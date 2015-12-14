// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.ImageView;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;

class nf
    implements android.view.animation.Animation.AnimationListener
{

    final ne a;

    nf(ne ne1)
    {
        a = ne1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        ActivityCameraNew.h(a.a).setVisibility(8);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
