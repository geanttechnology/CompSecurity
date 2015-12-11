// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.view.View;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

class rformClick
    implements Runnable
{

    final HorizontalListView this$0;
    final View val$child;
    final rformClick val$performClick;

    public void run()
    {
        HorizontalListView.access$002(HorizontalListView.this, -1);
        val$child.setPressed(false);
        setPressed(false);
        if (!HorizontalListView.access$100(HorizontalListView.this) && HorizontalListView.access$200(HorizontalListView.this) == HorizontalListView.access$300(HorizontalListView.this))
        {
            val$performClick.run();
        }
    }

    rformClick()
    {
        this$0 = final_horizontallistview;
        val$child = view;
        val$performClick = rformClick.this;
        super();
    }
}
