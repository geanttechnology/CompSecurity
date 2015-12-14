// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.instabeauty.application.InstaBeautyApplication;

public class xc
{

    private static xc a = new xc();

    public xc()
    {
    }

    public static xc a()
    {
        return a;
    }

    public void a(int i, int j, int k, View view, xf xf)
    {
        view.setVisibility(0);
        AlphaAnimation alphaanimation = new AlphaAnimation(i, j);
        alphaanimation.setDuration(k);
        alphaanimation.setAnimationListener(new xd(this, xf));
        view.startAnimation(alphaanimation);
    }

    public void a(int i, View view, xf xf)
    {
        view.setVisibility(0);
        Animation animation = AnimationUtils.loadAnimation(InstaBeautyApplication.a, i);
        animation.setAnimationListener(new xe(this, xf));
        view.startAnimation(animation);
    }

}
