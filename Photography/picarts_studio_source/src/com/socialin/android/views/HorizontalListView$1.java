// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.views;

import android.database.DataSetObserver;

// Referenced classes of package com.socialin.android.views:
//            HorizontalListView

final class a extends DataSetObserver
{

    private HorizontalListView a;

    public final void onChanged()
    {
        synchronized (a)
        {
            HorizontalListView.access$002(a, true);
        }
        a.invalidate();
        a.requestLayout();
        return;
        exception;
        horizontallistview;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void onInvalidated()
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
