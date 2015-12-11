// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.shared.ui;

import android.database.DataSetObserver;

// Referenced classes of package com.ebay.shared.ui:
//            TableView

class this._cls0 extends DataSetObserver
{

    final TableView this$0;

    public void onChanged()
    {
        TableView.access$000(TableView.this);
        requestLayout();
    }

    public void onInvalidated()
    {
        TableView.access$000(TableView.this);
        requestLayout();
    }

    ()
    {
        this$0 = TableView.this;
        super();
    }
}
