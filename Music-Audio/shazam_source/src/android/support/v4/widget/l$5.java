// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.v4.widget:
//            l

final class a
    implements android.view.animation.ation.AnimationListener
{

    final l a;

    public final void onAnimationEnd(Animation animation)
    {
        if (!l.g(a))
        {
            l.i(a);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    on(l l1)
    {
        a = l1;
        super();
    }
}
