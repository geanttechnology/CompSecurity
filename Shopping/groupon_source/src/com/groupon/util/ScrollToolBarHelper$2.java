// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.animation.Animator;
import android.animation.AnimatorSet;

// Referenced classes of package com.groupon.util:
//            ScrollToolBarHelper

class val.animatorSet
    implements android.animation.ner
{

    final ScrollToolBarHelper this$0;
    final AnimatorSet val$animatorSet;
    final ToolBarSnapDownListener val$listener;

    public void onAnimationCancel(Animator animator)
    {
        val$listener.onSnapDown();
        val$animatorSet.removeListener(this);
    }

    public void onAnimationEnd(Animator animator)
    {
        val$listener.onSnapDown();
        val$animatorSet.removeListener(this);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ToolBarSnapDownListener()
    {
        this$0 = final_scrolltoolbarhelper;
        val$listener = toolbarsnapdownlistener;
        val$animatorSet = AnimatorSet.this;
        super();
    }
}
