// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;
import com.instamag.activity.compose.MagComposeFragement;

public class bap
    implements android.view.animation.Animation.AnimationListener
{

    final MagComposeFragement a;

    public bap(MagComposeFragement magcomposefragement)
    {
        a = magcomposefragement;
        super();
    }

    public void onAnimationEnd(Animation animation)
    {
        MagComposeFragement.access$1002(a, false);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
        MagComposeFragement.access$1002(a, true);
    }
}
