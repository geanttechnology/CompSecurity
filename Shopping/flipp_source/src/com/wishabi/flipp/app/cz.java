// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            cx

final class cz extends AnimatorListenerAdapter
{

    final cx a;

    cz(cx cx1)
    {
        a = cx1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        cx.a(a).setVisibility(8);
    }
}
