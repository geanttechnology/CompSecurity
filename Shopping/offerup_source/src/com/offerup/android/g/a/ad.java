// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.a;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.offerup.android.g.a:
//            y

final class ad
    implements android.view.animation.Animation.AnimationListener
{

    private y a;

    ad(y y1)
    {
        a = y1;
        super();
    }

    public final void onAnimationEnd(Animation animation)
    {
        if (y.h(a) != null)
        {
            y.h(a).setVisibility(0);
        }
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }
}
