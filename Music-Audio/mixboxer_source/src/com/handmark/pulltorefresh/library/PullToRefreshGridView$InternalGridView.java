// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

// Referenced classes of package com.handmark.pulltorefresh.library:
//            PullToRefreshGridView

class this._cls0 extends GridView
    implements EmptyViewMethodAccessor
{

    final PullToRefreshGridView this$0;

    public void setEmptyView(View view)
    {
        PullToRefreshGridView.this.setEmptyView(view);
    }

    public void setEmptyViewInternal(View view)
    {
        super.setEmptyView(view);
    }

    public (Context context, AttributeSet attributeset)
    {
        this$0 = PullToRefreshGridView.this;
        super(context, attributeset);
    }
}
