// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

// Referenced classes of package com.groupon.view:
//            GrouponCheckMark

class apter extends AnimatorListenerAdapter
{

    final GrouponCheckMark this$0;
    final AnimatorListenerAdapter val$animationEndListenerAdapter;
    final boolean val$checked;

    public void onAnimationEnd(Animator animator)
    {
        if (!val$checked)
        {
            GrouponCheckMark.access$000(GrouponCheckMark.this).setVisibility(8);
            GrouponCheckMark.access$100(GrouponCheckMark.this).setVisibility(8);
        }
        if (val$animationEndListenerAdapter != null)
        {
            val$animationEndListenerAdapter.onAnimationEnd(animator);
        }
    }

    apter()
    {
        this$0 = final_grouponcheckmark;
        val$checked = flag;
        val$animationEndListenerAdapter = AnimatorListenerAdapter.this;
        super();
    }
}
