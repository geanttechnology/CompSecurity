// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package android.support.design.widget:
//            af

final class ag extends AnimatorListenerAdapter
{

    private af a;

    ag(af af1)
    {
        a = af1;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        af.a(a, false);
    }

    public final void onAnimationEnd(Animator animator)
    {
        af.a(a, false);
        a.e.setVisibility(8);
    }

    public final void onAnimationStart(Animator animator)
    {
        af.a(a, true);
        a.e.setVisibility(0);
    }
}
