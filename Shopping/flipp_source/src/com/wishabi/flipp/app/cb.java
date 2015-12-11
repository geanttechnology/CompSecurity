// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ProgressBar;

// Referenced classes of package com.wishabi.flipp.app:
//            bx

final class cb extends AnimatorListenerAdapter
{

    final bx a;

    cb(bx bx1)
    {
        a = bx1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        bx.f(a).setVisibility(8);
    }
}
