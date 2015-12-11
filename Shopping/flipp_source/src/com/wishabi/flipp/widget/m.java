// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.database.DataSetObserver;
import android.util.SparseArray;
import android.widget.ListAdapter;
import java.util.List;
import java.util.Stack;

// Referenced classes of package com.wishabi.flipp.widget:
//            j, CollectionView

final class m extends DataSetObserver
{

    final j a;

    m(j j1)
    {
        a = j1;
        super();
    }

    public final void onChanged()
    {
        a.removeAllViews();
        j.c(a).clear();
        a.a.clear();
        if (j.b(a) != null)
        {
            int k = j.b(a).getViewTypeCount();
            for (int i = 0; i < k; i++)
            {
                j.c(a).add(new Stack());
            }

        }
        CollectionView.c(a.h);
        a.requestLayout();
    }

    public final void onInvalidated()
    {
        a.removeAllViews();
        j.c(a).clear();
        a.a.clear();
        if (j.b(a) != null)
        {
            int k = j.b(a).getViewTypeCount();
            for (int i = 0; i < k; i++)
            {
                j.c(a).add(new Stack());
            }

        }
        CollectionView.c(a.h);
        a.requestLayout();
    }
}
