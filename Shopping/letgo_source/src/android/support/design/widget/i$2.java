// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package android.support.design.widget:
//            i

class Adapter extends AnimatorListenerAdapter
{

    final a a;
    final i b;

    public void onAnimationCancel(Animator animator)
    {
        a.c();
    }

    public void onAnimationEnd(Animator animator)
    {
        a.b();
    }

    public void onAnimationStart(Animator animator)
    {
        a.a();
    }

    a(i j, a a1)
    {
        b = j;
        a = a1;
        super();
    }
}
