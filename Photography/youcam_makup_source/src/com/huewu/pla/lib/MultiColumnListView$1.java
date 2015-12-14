// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.huewu.pla.lib;

import android.widget.ListAdapter;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.d;

// Referenced classes of package com.huewu.pla.lib:
//            MultiColumnListView, d

class b
    implements d
{

    final MultiColumnListView a;
    private int b;

    public void a(PLA_AbsListView pla_abslistview, int i)
    {
        int j = a.getAdapter().getCount();
        if (i == 0 && b == j - 2 && MultiColumnListView.a(a))
        {
            a.b.a();
            MultiColumnListView.a(a, false);
        }
    }

    public void a(PLA_AbsListView pla_abslistview, int i, int j, int k)
    {
        b = (i + j) - 2;
    }

    ew(MultiColumnListView multicolumnlistview)
    {
        a = multicolumnlistview;
        super();
        b = 0;
    }
}
