// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            Snackbar

final class ax
    implements android.view.animation.Animation.AnimationListener
{

    private int a;
    private Snackbar b;

    ax(Snackbar snackbar, int i)
    {
        b = snackbar;
        a = i;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        Snackbar.b(b, a);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
