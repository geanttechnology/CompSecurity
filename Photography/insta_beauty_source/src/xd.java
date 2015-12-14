// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;

class xd
    implements android.view.animation.Animation.AnimationListener
{

    final xf a;
    final xc b;

    xd(xc xc, xf xf1)
    {
        b = xc;
        a = xf1;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        if (a != null)
        {
            a.b();
        }
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        if (a != null)
        {
            a.a();
        }
    }
}
