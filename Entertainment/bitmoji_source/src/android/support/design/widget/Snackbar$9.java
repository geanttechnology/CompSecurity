// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            Snackbar

class val.event
    implements android.view.animation.nimationListener
{

    final Snackbar this$0;
    final int val$event;

    public void onAnimationEnd(Animation animation)
    {
        Snackbar.access$600(Snackbar.this, val$event);
    }

    public void onAnimationRepeat(Animation animation)
    {
    }

    public void onAnimationStart(Animation animation)
    {
    }

    nListener()
    {
        this$0 = final_snackbar;
        val$event = I.this;
        super();
    }
}
