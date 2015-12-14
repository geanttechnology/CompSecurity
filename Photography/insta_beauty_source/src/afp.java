// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.fotoable.fotoproedit.activity.ProEditFilterActivity;

public class afp
    implements android.view.animation.Animation.AnimationListener
{

    final ProEditFilterActivity a;

    public afp(ProEditFilterActivity proeditfilteractivity)
    {
        a = proeditfilteractivity;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        animation = (android.widget.FrameLayout.LayoutParams)ProEditFilterActivity.r(a).getLayoutParams();
        animation.bottomMargin = yp.a(a, 40F);
        ProEditFilterActivity.r(a).setLayoutParams(animation);
        ProEditFilterActivity.r(a).clearAnimation();
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
