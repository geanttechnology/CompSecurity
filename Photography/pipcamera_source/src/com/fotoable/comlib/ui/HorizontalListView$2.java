// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.comlib.ui;

import android.database.DataSetObserver;

// Referenced classes of package com.fotoable.comlib.ui:
//            HorizontalListView

class a extends DataSetObserver
{

    final HorizontalListView a;

    public void onChanged()
    {
        HorizontalListView.access$202(a, true);
        HorizontalListView.access$302(a, false);
        HorizontalListView.access$400(a);
        a.invalidate();
        a.requestLayout();
    }

    public void onInvalidated()
    {
        HorizontalListView.access$302(a, false);
        HorizontalListView.access$400(a);
        HorizontalListView.access$500(a);
        a.invalidate();
        a.requestLayout();
    }

    (HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }
}
