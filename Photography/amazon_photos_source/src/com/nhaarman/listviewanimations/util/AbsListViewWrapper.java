// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.util;

import android.view.ViewGroup;
import android.widget.AbsListView;

// Referenced classes of package com.nhaarman.listviewanimations.util:
//            ListViewWrapper

public class AbsListViewWrapper
    implements ListViewWrapper
{

    private final AbsListView mAbsListView;

    public AbsListViewWrapper(AbsListView abslistview)
    {
        mAbsListView = abslistview;
    }

    public int getFirstVisiblePosition()
    {
        return mAbsListView.getFirstVisiblePosition();
    }

    public int getLastVisiblePosition()
    {
        return mAbsListView.getLastVisiblePosition();
    }

    public volatile ViewGroup getListView()
    {
        return getListView();
    }

    public AbsListView getListView()
    {
        return mAbsListView;
    }
}
