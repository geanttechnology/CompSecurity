// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.widget;

import android.widget.AbsListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class OnCascadingScrollListener
    implements android.widget.AbsListView.OnScrollListener
{

    protected List listeners;

    public transient OnCascadingScrollListener(android.widget.AbsListView.OnScrollListener aonscrolllistener[])
    {
        if (aonscrolllistener == null)
        {
            listeners = new ArrayList();
            return;
        } else
        {
            listeners = new ArrayList(Arrays.asList(aonscrolllistener));
            return;
        }
    }

    public void add(android.widget.AbsListView.OnScrollListener onscrolllistener)
    {
        listeners.add(onscrolllistener);
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
