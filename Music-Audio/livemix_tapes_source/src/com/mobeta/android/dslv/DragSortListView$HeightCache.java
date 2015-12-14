// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.util.SparseIntArray;
import java.util.ArrayList;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

private class mMaxSize
{

    private SparseIntArray mMap;
    private int mMaxSize;
    private ArrayList mOrder;
    final DragSortListView this$0;

    public void add(int i, int j)
    {
        int k = mMap.get(i, -1);
        if (k != j)
        {
            if (k == -1)
            {
                if (mMap.size() == mMaxSize)
                {
                    mMap.delete(((Integer)mOrder.remove(0)).intValue());
                }
            } else
            {
                mOrder.remove(Integer.valueOf(i));
            }
            mMap.put(i, j);
            mOrder.add(Integer.valueOf(i));
        }
    }

    public void clear()
    {
        mMap.clear();
        mOrder.clear();
    }

    public int get(int i)
    {
        return mMap.get(i, -1);
    }

    public (int i)
    {
        this$0 = DragSortListView.this;
        super();
        mMap = new SparseIntArray(i);
        mOrder = new ArrayList(i);
        mMaxSize = i;
    }
}
