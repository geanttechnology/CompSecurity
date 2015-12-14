// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.itemmanipulation;

import android.view.View;
import android.widget.AbsListView;
import com.nineoldandroids.animation.ValueAnimator;

// Referenced classes of package com.nhaarman.listviewanimations.itemmanipulation:
//            ExpandableListItemAdapter

static final class val.listView
    implements com.nineoldandroids.animation.ndCollapseHelper._cls2
{

    final int listViewBottomPadding;
    final int listViewHeight;
    final View v;
    final AbsListView val$listView;
    final View val$view;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        int i = v.getBottom();
        if (i > listViewHeight)
        {
            int j = v.getTop();
            if (j > 0)
            {
                val$listView.smoothScrollBy(Math.min((i - listViewHeight) + listViewBottomPadding, j), 0);
            }
        }
    }

    (AbsListView abslistview, View view1)
    {
        val$listView = abslistview;
        val$view = view1;
        super();
        listViewHeight = val$listView.getHeight();
        listViewBottomPadding = val$listView.getPaddingBottom();
        v = cess._mth300(val$view, val$listView);
    }
}
