// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

public final class ez extends AnimatorListenerAdapter
{

    private fa a;
    private View b;

    public ez(fa fa1, View view)
    {
        a = fa1;
        b = view;
        super();
    }

    public final void onAnimationCancel(Animator animator)
    {
        a.c(b);
    }

    public final void onAnimationEnd(Animator animator)
    {
        a.b(b);
    }

    public final void onAnimationStart(Animator animator)
    {
        a.a(b);
    }
}
