// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.animation.Animator;

// Referenced classes of package android.support.v7:
//            g, c, h

static class b
    implements android.animation.ator.AnimatorListener
{

    final c a;
    final h b;

    public void onAnimationCancel(Animator animator)
    {
        a.onAnimationCancel(b);
    }

    public void onAnimationEnd(Animator animator)
    {
        a.onAnimationEnd(b);
    }

    public void onAnimationRepeat(Animator animator)
    {
        a.onAnimationRepeat(b);
    }

    public void onAnimationStart(Animator animator)
    {
        a.onAnimationStart(b);
    }

    public tor(c c1, h h)
    {
        a = c1;
        b = h;
    }
}
