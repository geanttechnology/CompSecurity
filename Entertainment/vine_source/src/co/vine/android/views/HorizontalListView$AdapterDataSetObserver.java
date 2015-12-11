// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.views;

import android.database.DataSetObserver;
import android.widget.ListAdapter;

// Referenced classes of package co.vine.android.views:
//            HorizontalListView

private class this._cls0 extends DataSetObserver
{

    final HorizontalListView this$0;

    public void onChanged()
    {
        HorizontalListView.access$402(HorizontalListView.this, HorizontalListView.access$500(HorizontalListView.this).getCount());
        HorizontalListView.access$102(HorizontalListView.this, true);
        requestLayout();
    }

    public void onInvalidated()
    {
        HorizontalListView.access$402(HorizontalListView.this, 0);
        HorizontalListView.access$102(HorizontalListView.this, true);
        requestLayout();
    }

    public ()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
