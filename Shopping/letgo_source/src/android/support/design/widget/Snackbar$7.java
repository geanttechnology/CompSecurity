// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            Snackbar

class a
    implements android.view.animation.nimationListener
{

    final Snackbar a;

    public void onAnimationEnd(Animation animation)
    {
        Snackbar.d(a);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    nListener(Snackbar snackbar)
    {
        a = snackbar;
        super();
    }
}
