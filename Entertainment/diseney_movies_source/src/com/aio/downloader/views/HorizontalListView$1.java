// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.views;

import android.database.DataSetObserver;

// Referenced classes of package com.aio.downloader.views:
//            HorizontalListView

class this._cls0 extends DataSetObserver
{

    final HorizontalListView this$0;

    public void onChanged()
    {
        synchronized (HorizontalListView.this)
        {
            HorizontalListView.access$2(HorizontalListView.this, true);
        }
        invalidate();
        requestLayout();
        return;
        exception;
        horizontallistview;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onInvalidated()
    {
        HorizontalListView.access$3(HorizontalListView.this);
        invalidate();
        requestLayout();
    }

    ()
    {
        this$0 = HorizontalListView.this;
        super();
    }
}
