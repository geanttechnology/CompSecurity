// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.util.SparseIntArray;
import java.util.ArrayList;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView

public class d
{

    private SparseIntArray a;
    private ArrayList b;
    private int c;

    public d()
    {
    }

    public d(DragSortListView dragsortlistview, int i)
    {
        a = new SparseIntArray(3);
        b = new ArrayList(3);
        c = 3;
    }

    public final int a(int i)
    {
        return a.get(i, -1);
    }

    public final void a()
    {
        a.clear();
        b.clear();
    }

    public final void a(int i, int j)
    {
        int k = a.get(i, -1);
        if (k != j)
        {
            if (k == -1)
            {
                if (a.size() == c)
                {
                    a.delete(((Integer)b.remove(0)).intValue());
                }
            } else
            {
                b.remove(Integer.valueOf(i));
            }
            a.put(i, j);
            b.add(Integer.valueOf(i));
        }
    }
}
