// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.v7.a.a;

// Referenced classes of package com.shazam.android.activities:
//            g

final class Adapter extends AnimatorListenerAdapter
{

    final a a;
    final g b;

    public final void onAnimationEnd(Animator animator)
    {
        a.d();
    }

    Adapter(g g1, a a1)
    {
        b = g1;
        a = a1;
        super();
    }
}
