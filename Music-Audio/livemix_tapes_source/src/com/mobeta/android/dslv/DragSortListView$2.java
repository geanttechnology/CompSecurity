// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.database.DataSetObserver;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

class this._cls0 extends DataSetObserver
{

    final DragSortListView this$0;

    private void cancel()
    {
        if (DragSortListView.access$4(DragSortListView.this) == 4)
        {
            cancelDrag();
        }
    }

    public void onChanged()
    {
        cancel();
    }

    public void onInvalidated()
    {
        cancel();
    }

    ()
    {
        this$0 = DragSortListView.this;
        super();
    }
}
