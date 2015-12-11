// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompositeOnScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    private List listeners;

    public CompositeOnScrollListener()
    {
        listeners = new ArrayList();
    }

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.widget.AbsListView.OnScrollListener)iterator.next()).onScroll(abslistview, i, j, k)) { }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.widget.AbsListView.OnScrollListener)iterator.next()).onScrollStateChanged(abslistview, i)) { }
    }
}
