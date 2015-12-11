// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;

// Referenced classes of package co.vine.android.recorder:
//            SegmentEditorAdapter

public class RotatingEditorAdapter extends BaseAdapter
    implements ListAdapter, co.vine.android.dragsort.DragSortWidget.RemoveListener, co.vine.android.dragsort.DragSortWidget.DragListener
{

    SegmentEditorAdapter mAdapter;
    private int mFirstPosition;

    public RotatingEditorAdapter(SegmentEditorAdapter segmenteditoradapter)
    {
        mFirstPosition = 0;
        mAdapter = segmenteditoradapter;
    }

    public boolean areAllItemsEnabled()
    {
        return mAdapter.areAllItemsEnabled();
    }

    public void drag(int i, int j)
    {
        mAdapter.drag(getPositionInAdapter(i), getPositionInAdapter(j));
    }

    public int getCount()
    {
        return mAdapter.getCount();
    }

    public Object getItem(int i)
    {
        return mAdapter.getItem(getPositionInAdapter(i));
    }

    public long getItemId(int i)
    {
        return mAdapter.getItemId(getPositionInAdapter(i));
    }

    public int getItemViewType(int i)
    {
        return mAdapter.getItemViewType(getPositionInAdapter(i));
    }

    public int getPositionInAdapter(int i)
    {
        return (mFirstPosition + i) % mAdapter.getCount();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return mAdapter.getView(getPositionInAdapter(i), view, viewgroup);
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
        return mAdapter.isEnabled(getPositionInAdapter(i));
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        if (datasetobserver != null)
        {
            super.registerDataSetObserver(datasetobserver);
        }
        mAdapter.registerDataSetObserver(datasetobserver);
    }

    public void remove(int i)
    {
        mAdapter.remove(getPositionInAdapter(i));
    }

    public void reset()
    {
        mFirstPosition = 0;
        notifyDataSetChanged();
    }

    public void setFirstPosition(int i)
    {
        mFirstPosition = (mAdapter.getCount() + i) % mAdapter.getCount();
        notifyDataSetChanged();
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        if (datasetobserver != null)
        {
            super.unregisterDataSetObserver(datasetobserver);
        }
        mAdapter.unregisterDataSetObserver(datasetobserver);
    }
}
