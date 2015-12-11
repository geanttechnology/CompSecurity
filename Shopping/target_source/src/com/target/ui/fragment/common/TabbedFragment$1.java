// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.fragment.common:
//            TabbedFragment

class > extends AnimatorListenerAdapter
{

    final TabbedFragment this$0;

    public void onAnimationCancel(Animator animator)
    {
        TabbedFragment.a(TabbedFragment.this, false);
    }

    public void onAnimationEnd(Animator animator)
    {
        TabbedFragment.a(TabbedFragment.this, false);
    }

    ()
    {
        this$0 = TabbedFragment.this;
        super();
    }
}
