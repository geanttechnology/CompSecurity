// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.database.DataSetObserver;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            HorizontalListView

private class <init> extends DataSetObserver
{

    final HorizontalListView this$0;

    public void onChanged()
    {
        synchronized (HorizontalListView.this)
        {
            HorizontalListView.access$002(HorizontalListView.this, true);
        }
        invalidate();
        requestLayout();
        HorizontalListView.access$102(HorizontalListView.this, false);
        return;
        exception;
        horizontallistview;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onInvalidated()
    {
        HorizontalListView.access$200(HorizontalListView.this);
        invalidate();
        requestLayout();
        HorizontalListView.access$102(HorizontalListView.this, false);
    }

    private ()
    {
        this$0 = HorizontalListView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
