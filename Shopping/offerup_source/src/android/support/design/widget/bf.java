// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Animation;

// Referenced classes of package android.support.design.widget:
//            be

final class bf
    implements android.view.animation.Animation.AnimationListener
{

    private be a;

    bf(be be1)
    {
        a = be1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (be.a(a) == animation)
        {
            be.a(a, null);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
