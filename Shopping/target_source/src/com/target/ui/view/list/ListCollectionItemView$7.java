// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import com.target.ui.util.e.a;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

class this._cls0
    implements android.animation.
{

    final ListCollectionItemView this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        d(ListCollectionItemView.c(ListCollectionItemView.this)).requestFocus();
        a.c(d(ListCollectionItemView.c(ListCollectionItemView.this)));
        com.target.ui.view.list.ListCollectionItemView.a(ListCollectionItemView.this, true);
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = ListCollectionItemView.this;
        super();
    }
}
