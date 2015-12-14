// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.DataSetObserver;
import com.fotoable.comlib.ui.HorizontalListView;

public class yu extends DataSetObserver
{

    final HorizontalListView a;

    public yu(HorizontalListView horizontallistview)
    {
        a = horizontallistview;
        super();
    }

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
}
