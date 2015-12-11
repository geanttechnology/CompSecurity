// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.animation.ValueAnimator;
import android.view.View;

// Referenced classes of package android.support.v4.view:
//            dm

final class dj
    implements android.animation.ValueAnimator.AnimatorUpdateListener
{

    private dm a;
    private View b;

    dj(dm dm1, View view)
    {
        a = dm1;
        b = view;
        super();
    }

    public final void onAnimationUpdate(ValueAnimator valueanimator)
    {
        a.onAnimationUpdate(b);
    }
}
