// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.animation.Animator;
import android.widget.TextView;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o

final class a
    implements android.animation.ator.AnimatorListener
{

    private boolean a;
    private o b;

    public final void onAnimationCancel(Animator animator)
    {
    }

    public final void onAnimationEnd(Animator animator)
    {
        if (a)
        {
            o.g(b).setVisibility(0);
            return;
        } else
        {
            o.g(b).setVisibility(4);
            return;
        }
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
    }

    r(o o1, boolean flag)
    {
        b = o1;
        a = flag;
        super();
    }
}
