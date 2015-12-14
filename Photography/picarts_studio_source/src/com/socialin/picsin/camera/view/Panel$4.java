// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.picsin.camera.view;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.socialin.picsin.camera.view:
//            Panel

final class a
    implements android.view.animation.n.AnimationListener
{

    private Panel a;

    public final void onAnimationEnd(Animation animation)
    {
        Panel.a(a, ate.READY);
        if (Panel.k(a))
        {
            Panel.c(a).setVisibility(8);
        }
        Panel.p(a);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
        Panel.a(a, ate.ANIMATING);
    }

    ate(Panel panel)
    {
        a = panel;
        super();
    }
}
