// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.coach_mark;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.fragment.coach_mark:
//            NavigationDrawerCoachMarkDialogFragment

class this._cls0 extends AnimatorListenerAdapter
{

    final NavigationDrawerCoachMarkDialogFragment this$0;

    public void onAnimationEnd(Animator animator)
    {
        if (NavigationDrawerCoachMarkDialogFragment.b(NavigationDrawerCoachMarkDialogFragment.this) == null)
        {
            return;
        } else
        {
            dismiss();
            return;
        }
    }

    Q()
    {
        this$0 = NavigationDrawerCoachMarkDialogFragment.this;
        super();
    }
}
