// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

// Referenced classes of package com.mobeta.android.dslv:
//            n, DragSortItemView, DragSortListView, DragSortItemViewCheckable

final class h extends BaseAdapter
{

    private ListAdapter a;
    private DragSortListView b;

    public h(DragSortListView dragsortlistview, ListAdapter listadapter)
    {
        b = dragsortlistview;
        super();
        a = listadapter;
        a.registerDataSetObserver(new n(this, dragsortlistview));
    }

    public final boolean areAllItemsEnabled()
    {
        return a.areAllItemsEnabled();
    }

    public final int getCount()
    {
        return a.getCount();
    }

    public final Object getItem(int i)
    {
        return a.getItem(i);
    }

    public final long getItemId(int i)
    {
        return a.getItemId(i);
    }

    public final int getItemViewType(int i)
    {
        return a.getItemViewType(i);
    }

    public final View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            viewgroup = (DragSortItemView)view;
            View view1 = viewgroup.getChildAt(0);
            View view2 = a.getView(i, view1, b);
            view = viewgroup;
            if (view2 != view1)
            {
                if (view1 != null)
                {
                    viewgroup.removeViewAt(0);
                }
                viewgroup.addView(view2);
                view = viewgroup;
            }
        } else
        {
            viewgroup = a.getView(i, null, b);
            if (viewgroup instanceof Checkable)
            {
                view = new DragSortItemViewCheckable(b.getContext());
            } else
            {
                view = new DragSortItemView(b.getContext());
            }
            view.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, -2));
            view.addView(viewgroup);
        }
        DragSortListView.a(b, b.getHeaderViewsCount() + i, view, true);
        return view;
    }

    public final int getViewTypeCount()
    {
        return a.getViewTypeCount();
    }

    public final boolean hasStableIds()
    {
        return a.hasStableIds();
    }

    public final boolean isEmpty()
    {
        return a.isEmpty();
    }

    public final boolean isEnabled(int i)
    {
        return a.isEnabled(i);
    }
}
