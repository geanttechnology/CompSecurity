// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.livemixtapes:
//            PullToRefreshListView

private class <init>
    implements android.widget.r
{

    final PullToRefreshListView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        PullToRefreshListView.access$11(PullToRefreshListView.this, false);
        if (PullToRefreshListView.access$12(PullToRefreshListView.this) != null && PullToRefreshListView.access$0(PullToRefreshListView.this) == this._fld0)
        {
            PullToRefreshListView.access$12(PullToRefreshListView.this)._mth0(adapterview, view, i - getHeaderViewsCount(), l);
        }
    }

    private ()
    {
        this$0 = PullToRefreshListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
