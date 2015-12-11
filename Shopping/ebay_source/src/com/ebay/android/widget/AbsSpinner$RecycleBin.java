// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.util.SparseArray;
import android.view.View;

// Referenced classes of package com.ebay.android.widget:
//            AbsSpinner

class mScrapHeap
{

    private SparseArray mScrapHeap;
    final AbsSpinner this$0;

    void clear()
    {
        SparseArray sparsearray = mScrapHeap;
        int j = sparsearray.size();
        for (int i = 0; i < j; i++)
        {
            View view = (View)sparsearray.valueAt(i);
            if (view != null)
            {
                AbsSpinner.access$100(AbsSpinner.this, view, true);
            }
        }

        sparsearray.clear();
    }

    View get(int i)
    {
        View view = (View)mScrapHeap.get(i);
        if (view != null)
        {
            mScrapHeap.delete(i);
        }
        return view;
    }

    View peek(int i)
    {
        return (View)mScrapHeap.get(i);
    }

    public void put(int i, View view)
    {
        mScrapHeap.put(i, view);
    }

    ()
    {
        this$0 = AbsSpinner.this;
        super();
        mScrapHeap = new SparseArray();
    }
}
