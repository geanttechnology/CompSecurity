// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            Snackbar, ba

final class av
    implements android.view.animation.Animation.AnimationListener
{

    private Snackbar a;

    av(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (Snackbar.d(a) != null)
        {
            Snackbar.d(a);
        }
        ba.a().b(Snackbar.a(a));
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
