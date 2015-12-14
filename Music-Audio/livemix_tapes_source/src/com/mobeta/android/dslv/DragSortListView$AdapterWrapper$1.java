// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.database.DataSetObserver;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

class this._cls1 extends DataSetObserver
{

    final tifyDataSetInvalidated this$1;

    public void onChanged()
    {
        tifyDataSetChanged();
    }

    public void onInvalidated()
    {
        tifyDataSetInvalidated();
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
