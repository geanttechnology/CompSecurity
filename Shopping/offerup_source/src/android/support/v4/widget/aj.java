// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.v4.widget:
//            al, ah

final class aj
    implements android.view.animation.Animation.AnimationListener
{

    private al a;
    private ah b;

    aj(ah ah1, al al1)
    {
        b = ah1;
        a = al1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
    }

    public final void onAnimationRepeat(Animation animation)
    {
        a.l();
        a.b();
        a.b(a.i());
        if (b.a)
        {
            b.a = false;
            animation.setDuration(1332L);
            a.a(false);
            return;
        } else
        {
            ah.a(b, (ah.a(b) + 1.0F) % 5F);
            return;
        }
    }

    public final void onAnimationStart(Animation animation)
    {
        ah.a(b, 0.0F);
    }
}
