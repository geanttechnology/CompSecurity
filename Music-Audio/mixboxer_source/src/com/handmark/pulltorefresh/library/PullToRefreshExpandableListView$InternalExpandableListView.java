// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshExpandableListView

class this._cls0 extends ExpandableListView
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

    public (Context context, AttributeSet attributeset)
    {
        this$0 = PullToRefreshExpandableListView.this;
        super(context, attributeset);
    }
}
