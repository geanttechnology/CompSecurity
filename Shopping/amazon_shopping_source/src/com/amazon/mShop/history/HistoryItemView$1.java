// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.view.View;

// Referenced classes of package com.amazon.mShop.history:
//            HistoryItemView, ObjectDeletingObserver

class this._cls0
    implements android.view.er
{

    final HistoryItemView this$0;

    public void onClick(View view)
    {
        showUndoGroup();
        if (HistoryItemView.access$000(HistoryItemView.this) != null)
        {
            HistoryItemView.access$000(HistoryItemView.this).deleteObjectInIndex(HistoryItemView.access$100(HistoryItemView.this));
        }
    }

    rver()
    {
        this$0 = HistoryItemView.this;
        super();
    }
}
