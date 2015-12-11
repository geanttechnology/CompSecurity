// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshAdapterViewBase

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase
{

    public PullToRefreshExpandableListView(Context context)
    {
        super(context);
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode)
    {
        super(context, mode);
    }

    public PullToRefreshExpandableListView(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.AnimationStyle animationstyle)
    {
        super(context, mode, animationstyle);
    }

    protected volatile View createRefreshableView(Context context, AttributeSet attributeset)
    {
        return createRefreshableView(context, attributeset);
    }

    protected ExpandableListView createRefreshableView(Context context, AttributeSet attributeset)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            context = new InternalExpandableListViewSDK9(context, attributeset);
        } else
        {
            context = new InternalExpandableListView(context, attributeset);
        }
        context.setId(0x102000a);
        return context;
    }

    public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
    {
        return PullToRefreshBase.Orientation.VERTICAL;
    }

    private class InternalExpandableListViewSDK9 extends InternalExpandableListView
    {
        private class InternalExpandableListView extends ExpandableListView
            implements EmptyViewMethodAccessor
        {

            final PullToRefreshExpandableListView this$0;

            public void setEmptyView(View view)
            {
                PullToRefreshExpandableListView.this.setEmptyView(view);
            }

            public void setEmptyViewInternal(View view)
            {
                super.setEmptyView(view);
            }

            public InternalExpandableListView(Context context, AttributeSet attributeset)
            {
                this$0 = PullToRefreshExpandableListView.this;
                super(context, attributeset);
            }
        }


        final PullToRefreshExpandableListView this$0;

        protected final boolean overScrollBy(int i, int j, int k, int l, int i1, int j1, int k1, 
                int l1, boolean flag)
        {
            boolean flag1 = super.overScrollBy(i, j, k, l, i1, j1, k1, l1, flag);
            OverscrollHelper.overScrollBy(PullToRefreshExpandableListView.this, i, k, j, l, flag);
            return flag1;
        }

        public InternalExpandableListViewSDK9(Context context, AttributeSet attributeset)
        {
            this$0 = PullToRefreshExpandableListView.this;
            super(context, attributeset);
        }
    }

}
