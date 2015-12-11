// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            bb, be

static final class b
    implements android.animation.Animator.AnimatorUpdateListener
{

    final be a;
    final View b;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.a(b);
    }

    or(be be1, View view)
    {
        a = be1;
        b = view;
        super();
    }
}
