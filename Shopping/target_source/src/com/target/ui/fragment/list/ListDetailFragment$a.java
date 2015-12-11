// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.target.ui.fragment.list.presenter.ListDetailPresenter;
import com.target.ui.view.list.ListDetailView;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDetailFragment

private class <init> extends AnimatorListenerAdapter
{

    final ListDetailFragment this$0;

    public void onAnimationEnd(Animator animator)
    {
        if (ListDetailFragment.b(ListDetailFragment.this) != null)
        {
            ListDetailFragment.a(ListDetailFragment.this, false);
            if (ListDetailFragment.a(ListDetailFragment.this) != null && !ListDetailFragment.a(ListDetailFragment.this).d())
            {
                ListDetailFragment.b(ListDetailFragment.this).listDetailView.setPromotionsOpen(false);
                ListDetailFragment.a(ListDetailFragment.this).a(false);
                return;
            }
        }
    }

    public void onAnimationStart(Animator animator)
    {
        ListDetailFragment.a(ListDetailFragment.this, true);
    }

    private ews()
    {
        this$0 = ListDetailFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
