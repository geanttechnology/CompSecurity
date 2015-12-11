// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.dragsort;

import android.database.DataSetObserver;

// Referenced classes of package co.vine.android.dragsort:
//            DragSortWidget

class this._cls1 extends DataSetObserver
{

    final is._cls0 this$1;

    public void onChanged()
    {
        tifyDataSetChanged();
        DragSortWidget.access$1200(_fld0);
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
