// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            n

final class s extends AnimatorListenerAdapter
{

    final n a;

    s(n n1)
    {
        a = n1;
        super();
    }

    public final void onAnimationEnd(Animator animator)
    {
        n.e(a).setVisibility(8);
    }
}
