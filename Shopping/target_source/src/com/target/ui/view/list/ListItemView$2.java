// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import com.target.ui.e.g;

// Referenced classes of package com.target.ui.view.list:
//            ListItemView

class this._cls0
    implements android.animation.orListener
{

    final ListItemView this$0;

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        if (ListItemView.a(ListItemView.this) != null && !ListItemView.f(ListItemView.this).a() && !ListItemView.e(ListItemView.this))
        {
            ListItemView.a(ListItemView.this).d(mItem);
        }
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ener()
    {
        this$0 = ListItemView.this;
        super();
    }
}
