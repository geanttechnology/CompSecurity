// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.socialin.android.util.c;

// Referenced classes of package com.picsart.studio.editor.custommasks:
//            o

final class a
    implements android.animation.ator.AnimatorListener
{

    private o a;

    public final void onAnimationCancel(Animator animator)
    {
        a.a.setVisibility(4);
        if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
        {
            c.a(com.picsart.studio.editor.custommasks.o.c(a));
        }
        o.d(a, false);
    }

    public final void onAnimationEnd(Animator animator)
    {
        a.a.setVisibility(4);
        if (com.picsart.studio.editor.custommasks.o.c(a) != null && !com.picsart.studio.editor.custommasks.o.c(a).equals(o.l(a)))
        {
            c.a(com.picsart.studio.editor.custommasks.o.c(a));
        }
        o.d(a, false);
    }

    public final void onAnimationRepeat(Animator animator)
    {
    }

    public final void onAnimationStart(Animator animator)
    {
        o.d(a, true);
    }

    r(o o1)
    {
        a = o1;
        super();
    }
}
