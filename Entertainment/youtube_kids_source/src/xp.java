// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.apps.youtube.kids.activities.ParentalControlActivity;

public final class xp extends AnimatorListenerAdapter
{

    private ParentalControlActivity a;

    public xp(ParentalControlActivity parentalcontrolactivity)
    {
        a = parentalcontrolactivity;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (ParentalControlActivity.d(a))
        {
            a.finish();
        }
    }
}
