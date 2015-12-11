// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            dk

final class di extends AnimatorListenerAdapter
{

    private dk a;
    private View b;

    di(dk dk1, View view)
    {
        a = dk1;
        b = view;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        a.onAnimationCancel(b);
    }

    public final void onAnimationEnd(Animator animator)
    {
        a.onAnimationEnd(b);
    }

    public final void onAnimationStart(Animator animator)
    {
        a.onAnimationStart(b);
    }
}
