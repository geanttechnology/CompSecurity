// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.database.DataSetObserver;

// Referenced classes of package com.mobeta.android.dslv:
//            h, DragSortListView

final class n extends DataSetObserver
{

    private h a;

    n(h h1, DragSortListView dragsortlistview)
    {
        a = h1;
        super();
    }

    public final void onChanged()
    {
        a.notifyDataSetChanged();
    }

    public final void onInvalidated()
    {
        a.notifyDataSetInvalidated();
    }
}
