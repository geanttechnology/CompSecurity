// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import android.view.animation.Animation;
import com.instamag.activity.compose.MagComposeFragement;

public class bao
    implements android.view.animation.Animation.AnimationListener
{

    final View a;
    final MagComposeFragement b;

    public bao(MagComposeFragement magcomposefragement, View view)
    {
        b = magcomposefragement;
        a = view;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        a.setVisibility(4);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }
}
