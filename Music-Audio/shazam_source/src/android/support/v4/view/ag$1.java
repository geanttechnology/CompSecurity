// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            ag, aj

static final class b
    implements android.animation.Animator.AnimatorUpdateListener
{

    final aj a;
    final View b;

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.a();
    }

    or(aj aj1, View view)
    {
        a = aj1;
        b = view;
        super();
    }
}
