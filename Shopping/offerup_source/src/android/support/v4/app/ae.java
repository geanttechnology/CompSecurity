// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.app;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package android.support.v4.app:
//            af, Fragment, ab

final class ae extends af
{

    private Fragment a;
    private ab b;

    ae(ab ab1, View view, Animation animation, Fragment fragment)
    {
        b = ab1;
        a = fragment;
        super(view, animation);
    }

    public final void onAnimationEnd(Animation animation)
    {
        super.onAnimationEnd(animation);
        if (a.mAnimatingAway != null)
        {
            a.mAnimatingAway = null;
            b.a(a, a.mStateAfterAnimating, 0, 0, false);
        }
    }
}
