// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view:
//            CustomErrorViewWrapper

class nit> extends AnimatorListenerAdapter
{

    final CustomErrorViewWrapper this$0;

    public void onAnimationCancel(Animator animator)
    {
        al.b(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
    }

    public void onAnimationEnd(Animator animator)
    {
        al.d(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
    }

    public void onAnimationStart(Animator animator)
    {
        al.b(CustomErrorViewWrapper.b(CustomErrorViewWrapper.this).error);
    }

    ()
    {
        this$0 = CustomErrorViewWrapper.this;
        super();
    }
}
