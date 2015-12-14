// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.beautyui.gpuimage.sample.activity.contiCapturePhotoEditActivity1;

public class rp
    implements android.view.animation.Animation.AnimationListener
{

    final contiCapturePhotoEditActivity1 a;

    public rp(contiCapturePhotoEditActivity1 conticapturephotoeditactivity1)
    {
        a = conticapturephotoeditactivity1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (!contiCapturePhotoEditActivity1.o(a))
        {
            a.b.setVisibility(8);
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
