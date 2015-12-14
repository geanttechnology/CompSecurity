// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.view;

import android.database.DataSetObserver;

// Referenced classes of package com.wantu.view:
//            HorizontalListView

class it> extends DataSetObserver
{

    final HorizontalListView a;

    public void onChanged()
    {
        synchronized (a)
        {
            HorizontalListView.access$002(a, true);
        }
        a.setEmptyView(a.getEmptyView());
        a.invalidate();
        a.requestLayout();
        return;
        exception;
        horizontallistview;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onInvalidated()
    {
        HorizontalListView.access$100(a);
        a.invalidate();
        a.requestLayout();
    }

    (HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }
}
