// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobeta.android.dslv;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;

// Referenced classes of package com.mobeta.android.dslv:
//            DragSortListView, DragSortItemView, DragSortItemViewCheckable

private class  extends BaseAdapter
{

    private ListAdapter mAdapter;
    final DragSortListView this$0;

    public boolean areAllItemsEnabled()
    {
        return mAdapter.areAllItemsEnabled();
    }

    public ListAdapter getAdapter()
    {
        return mAdapter;
    }

    public int getCount()
    {
        return mAdapter.getCount();
    }

    public Object getItem(int i)
    {
        return mAdapter.getItem(i);
    }

    public long getItemId(int i)
    {
        return mAdapter.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return mAdapter.getItemViewType(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view != null)
        {
            viewgroup = (DragSortItemView)view;
            View view1 = viewgroup.getChildAt(0);
            View view2 = mAdapter.getView(i, view1, DragSortListView.this);
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
            viewgroup = mAdapter.getView(i, null, DragSortListView.this);
            if (viewgroup instanceof Checkable)
            {
                view = new DragSortItemViewCheckable(getContext());
            } else
            {
                view = new DragSortItemView(getContext());
            }
            view.setLayoutParams(new android.widget.outParams(-1, -2));
            view.addView(viewgroup);
        }
        DragSortListView.access$1(DragSortListView.this, getHeaderViewsCount() + i, view, true);
        return view;
    }

    public int getViewTypeCount()
    {
        return mAdapter.getViewTypeCount();
    }

    public boolean hasStableIds()
    {
        return mAdapter.hasStableIds();
    }

    public boolean isEmpty()
    {
        return mAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return mAdapter.isEnabled(i);
    }

    public _cls1.this._cls1(ListAdapter listadapter)
    {
        this$0 = DragSortListView.this;
        super();
        mAdapter = listadapter;
        mAdapter.registerDataSetObserver(new DataSetObserver() {

            final DragSortListView.AdapterWrapper this$1;

            public void onChanged()
            {
                notifyDataSetChanged();
            }

            public void onInvalidated()
            {
                notifyDataSetInvalidated();
            }

            
            {
                this$1 = DragSortListView.AdapterWrapper.this;
                super();
            }
        });
    }
}
