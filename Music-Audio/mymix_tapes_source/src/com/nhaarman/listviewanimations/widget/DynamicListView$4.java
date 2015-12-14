// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.widget;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

// Referenced classes of package com.nhaarman.listviewanimations.widget:
//            DynamicListView

class it> extends AnimatorListenerAdapter
{

    final DynamicListView this$0;
    final View val$mobileView;

    public void onAnimationEnd(Animator animator)
    {
        DynamicListView.access$502(DynamicListView.this, -1L);
        DynamicListView.access$602(DynamicListView.this, -1L);
        DynamicListView.access$702(DynamicListView.this, -1L);
        val$mobileView.setVisibility(0);
        DynamicListView.access$802(DynamicListView.this, null);
        setEnabled(true);
        invalidate();
        if (DynamicListView.access$900(DynamicListView.this) != null)
        {
            DynamicListView.access$900(DynamicListView.this).onItemMoved(DynamicListView.access$1000(DynamicListView.this) - getHeaderViewsCount());
        }
    }

    public void onAnimationStart(Animator animator)
    {
        setEnabled(false);
    }

    ItemMovedListener()
    {
        this$0 = final_dynamiclistview;
        val$mobileView = View.this;
        super();
    }
}
