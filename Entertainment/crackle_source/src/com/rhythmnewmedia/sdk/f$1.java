// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;

import android.view.animation.Animation;

// Referenced classes of package com.rhythmnewmedia.sdk:
//            f

final class a
    implements android.view.animation.ation.AnimationListener
{

    final f a;

    public final void onAnimationEnd(Animation animation)
    {
        ((ation)a.contentView).b();
    }

    public final void onAnimationRepeat(Animation animation)
    {
    }

    public final void onAnimationStart(Animation animation)
    {
    }

    ation(f f1)
    {
        a = f1;
        super();
    }
}
