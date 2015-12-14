// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.animation.Animator;
import android.view.View;
import android.widget.LinearLayout;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            j

class a
    implements android.animation.ator.AnimatorListener
{

    final View a;
    final j b;

    public void onAnimationCancel(Animator animator)
    {
        j.i(b).removeView(a);
        b.c();
    }

    public void onAnimationEnd(Animator animator)
    {
        j.i(b).removeView(a);
        b.c();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    (j j1, View view)
    {
        b = j1;
        a = view;
        super();
    }
}
