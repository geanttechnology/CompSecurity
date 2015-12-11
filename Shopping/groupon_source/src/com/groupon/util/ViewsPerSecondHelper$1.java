// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.app.ListFragment;
import android.os.Debug;
import android.widget.AbsListView;
import com.groupon.adapter.VpsAdapter;

// Referenced classes of package com.groupon.util:
//            ViewsPerSecondHelper, DialogManager

static final class val.adapter
    implements android.widget.tener
{

    int currentFirstVisibleItem;
    int currentVisibleItemCount;
    final VpsAdapter val$adapter;
    final DialogManager val$dialogManager;
    final ListFragment val$fragment;
    final int val$maxViews;
    final boolean val$trace;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        currentFirstVisibleItem = i;
        currentVisibleItemCount = j;
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
        if (currentVisibleItemCount + currentFirstVisibleItem >= val$maxViews && i == 0)
        {
            if (val$trace)
            {
                Debug.stopMethodTracing();
            }
            ViewsPerSecondHelper.access$000(val$dialogManager, val$fragment, val$adapter);
        }
    }

    ner(int i, boolean flag, DialogManager dialogmanager, ListFragment listfragment, VpsAdapter vpsadapter)
    {
        val$maxViews = i;
        val$trace = flag;
        val$dialogManager = dialogmanager;
        val$fragment = listfragment;
        val$adapter = vpsadapter;
        super();
    }
}
