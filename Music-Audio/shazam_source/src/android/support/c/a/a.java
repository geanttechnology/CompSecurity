// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.c.a;

import android.animation.Animator;

public class a
    implements android.animation.Animator.AnimatorListener
{

    private boolean a;

    public a()
    {
    }

    public void onAnimationCancel(Animator animator)
    {
        a = true;
    }

    public void onAnimationEnd(Animator animator)
    {
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
        a = false;
    }
}
