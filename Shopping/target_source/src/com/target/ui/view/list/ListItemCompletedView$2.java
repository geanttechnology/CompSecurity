// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.target.ui.model.list.ListDetailCompletedItem;

// Referenced classes of package com.target.ui.view.list:
//            ListItemCompletedView

class  extends AnimatorListenerAdapter
{

    final ListItemCompletedView this$0;
    final ListDetailCompletedItem val$detailListItem;

    public void onAnimationEnd(Animator animator)
    {
        if (ListItemCompletedView.a(ListItemCompletedView.this) != null)
        {
            ListItemCompletedView.a(ListItemCompletedView.this).a(val$detailListItem);
        }
    }

    ()
    {
        this$0 = final_listitemcompletedview;
        val$detailListItem = ListDetailCompletedItem.this;
        super();
    }
}
