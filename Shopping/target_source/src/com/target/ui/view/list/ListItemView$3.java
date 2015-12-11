// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class er extends AnimatorListenerAdapter
{

    final ListItemView this$0;

    public void onAnimationEnd(Animator animator)
    {
        ListItemView.g(ListItemView.this);
        ListItemView.a(ListItemView.this, null);
    }

    er()
    {
        this$0 = ListItemView.this;
        super();
    }
}
