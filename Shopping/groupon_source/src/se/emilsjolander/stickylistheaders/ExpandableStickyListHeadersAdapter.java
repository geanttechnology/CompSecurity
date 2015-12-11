// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package se.emilsjolander.stickylistheaders:
//            StickyListHeadersAdapter, DualHashMap, DistinctMultiHashMap

class ExpandableStickyListHeadersAdapter extends BaseAdapter
    implements StickyListHeadersAdapter
{

    List mCollapseHeaderIds;
    DistinctMultiHashMap mHeaderIdToViewMap;
    private final StickyListHeadersAdapter mInnerAdapter;
    DualHashMap mViewToItemIdMap;

    ExpandableStickyListHeadersAdapter(StickyListHeadersAdapter stickylistheadersadapter)
    {
        mViewToItemIdMap = new DualHashMap();
        mHeaderIdToViewMap = new DistinctMultiHashMap();
        mCollapseHeaderIds = new ArrayList();
        mInnerAdapter = stickylistheadersadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return mInnerAdapter.areAllItemsEnabled();
    }

    public void collapse(long l)
    {
        if (!isHeaderCollapsed(l))
        {
            mCollapseHeaderIds.add(Long.valueOf(l));
        }
    }

    public void expand(long l)
    {
        if (isHeaderCollapsed(l))
        {
            mCollapseHeaderIds.remove(Long.valueOf(l));
        }
    }

    public int getCount()
    {
        return mInnerAdapter.getCount();
    }

    public long getHeaderId(int i)
    {
        return mInnerAdapter.getHeaderId(i);
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        return mInnerAdapter.getHeaderView(i, view, viewgroup);
    }

    public Object getItem(int i)
    {
        return mInnerAdapter.getItem(i);
    }

    public long getItemId(int i)
    {
        return mInnerAdapter.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return mInnerAdapter.getItemViewType(i);
    }

    public List getItemViewsByHeaderId(long l)
    {
        return mHeaderIdToViewMap.get(Integer.valueOf((int)l));
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = mInnerAdapter.getView(i, view, viewgroup);
        mViewToItemIdMap.put(view, Long.valueOf(getItemId(i)));
        mHeaderIdToViewMap.add(Integer.valueOf((int)getHeaderId(i)), view);
        if (mCollapseHeaderIds.contains(Long.valueOf(getHeaderId(i))))
        {
            view.setVisibility(8);
            return view;
        } else
        {
            view.setVisibility(0);
            return view;
        }
    }

    public int getViewTypeCount()
    {
        return mInnerAdapter.getViewTypeCount();
    }

    public boolean hasStableIds()
    {
        return mInnerAdapter.hasStableIds();
    }

    public boolean isEmpty()
    {
        return mInnerAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return mInnerAdapter.isEnabled(i);
    }

    public boolean isHeaderCollapsed(long l)
    {
        return mCollapseHeaderIds.contains(Long.valueOf(l));
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mInnerAdapter.registerDataSetObserver(datasetobserver);
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mInnerAdapter.unregisterDataSetObserver(datasetobserver);
    }
}
