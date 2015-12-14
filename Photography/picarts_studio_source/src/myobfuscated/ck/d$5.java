// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ck;

import android.animation.Animator;
import android.widget.TextView;

// Referenced classes of package myobfuscated.ck:
//            d

final class it>
    implements android.animation.ator.AnimatorListener
{

    private boolean a;
    private d b;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (a)
        {
            d.g(b).setVisibility(0);
            return;
        } else
        {
            d.g(b).setVisibility(4);
            return;
        }
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
    }

    imator(d d1, boolean flag)
    {
        b = d1;
        a = flag;
        super();
    }
}
