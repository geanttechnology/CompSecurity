// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;

import android.database.DataSetObserver;
import java.util.ArrayList;

// Referenced classes of package com.twitter.android.widget:
//            RefreshableListView

private class this._cls0 extends DataSetObserver
{

    private final ArrayList mObservers = new ArrayList();
    final RefreshableListView this$0;

    public void onChanged()
    {
        updateItemCount();
        ArrayList arraylist = mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        int i = mObservers.size() - 1;
_L2:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((DataSetObserver)mObservers.get(i)).onChanged();
        i--;
        if (true) goto _L2; else goto _L1
_L1:
        arraylist;
        JVM INSTR monitorexit ;
        requestLayout();
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void onInvalidated()
    {
        mItemCount = 0;
        ArrayList arraylist = mObservers;
        arraylist;
        JVM INSTR monitorenter ;
        int i = mObservers.size() - 1;
_L2:
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((DataSetObserver)mObservers.get(i)).onInvalidated();
        i--;
        if (true) goto _L2; else goto _L1
_L1:
        arraylist;
        JVM INSTR monitorexit ;
        requestLayout();
        return;
        Exception exception;
        exception;
        arraylist;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mObservers.add(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mObservers.remove(datasetobserver);
    }

    public ()
    {
        this$0 = RefreshableListView.this;
        super();
    }
}
