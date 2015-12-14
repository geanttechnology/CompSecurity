// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.collages;

import android.view.View;
import android.view.animation.Animation;

// Referenced classes of package com.picsart.collages:
//            e

final class a
    implements android.view.animation.tion.AnimationListener
{

    private e a;

    public final void onAnimationEnd(Animation animation)
    {
        e.k(a).setVisibility(8);
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    mation(e e1)
    {
        a = e1;
        super();
    }
}
