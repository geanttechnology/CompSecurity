// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ProgressBar;

// Referenced classes of package com.wishabi.flipp.app:
//            fv, fu

final class fw extends AnimatorListenerAdapter
{

    final fv a;

    fw(fv fv1)
    {
        a = fv1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (a.a.getActivity() == null)
        {
            return;
        } else
        {
            fu.b(a.a).setVisibility(8);
            return;
        }
    }
}
