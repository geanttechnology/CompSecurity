// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.nhaarman.listviewanimations.util.AbsListViewWrapper;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nhaarman.listviewanimations.util.ListViewWrapperSetter;

// Referenced classes of package com.nhaarman.listviewanimations:
//            ArrayAdapter

public abstract class BaseAdapterDecorator extends BaseAdapter
    implements SectionIndexer, ListViewWrapperSetter
{

    private final BaseAdapter mDecoratedBaseAdapter;
    private ListViewWrapper mListViewWrapper;

    protected BaseAdapterDecorator(BaseAdapter baseadapter)
    {
        mDecoratedBaseAdapter = baseadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return mDecoratedBaseAdapter.areAllItemsEnabled();
    }

    public int getCount()
    {
        return mDecoratedBaseAdapter.getCount();
    }

    public BaseAdapter getDecoratedBaseAdapter()
    {
        return mDecoratedBaseAdapter;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        return mDecoratedBaseAdapter.getDropDownView(i, view, viewgroup);
    }

    public Object getItem(int i)
    {
        return mDecoratedBaseAdapter.getItem(i);
    }

    public long getItemId(int i)
    {
        return mDecoratedBaseAdapter.getItemId(i);
    }

    public int getItemViewType(int i)
    {
        return mDecoratedBaseAdapter.getItemViewType(i);
    }

    public ListViewWrapper getListViewWrapper()
    {
        return mListViewWrapper;
    }

    public int getPositionForSection(int i)
    {
        int j = 0;
        if (mDecoratedBaseAdapter instanceof SectionIndexer)
        {
            j = ((SectionIndexer)mDecoratedBaseAdapter).getPositionForSection(i);
        }
        return j;
    }

    public int getSectionForPosition(int i)
    {
        int j = 0;
        if (mDecoratedBaseAdapter instanceof SectionIndexer)
        {
            j = ((SectionIndexer)mDecoratedBaseAdapter).getSectionForPosition(i);
        }
        return j;
    }

    public Object[] getSections()
    {
        Object aobj[] = new Object[0];
        if (mDecoratedBaseAdapter instanceof SectionIndexer)
        {
            aobj = ((SectionIndexer)mDecoratedBaseAdapter).getSections();
        }
        return aobj;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return mDecoratedBaseAdapter.getView(i, view, viewgroup);
    }

    public int getViewTypeCount()
    {
        return mDecoratedBaseAdapter.getViewTypeCount();
    }

    public boolean hasStableIds()
    {
        return mDecoratedBaseAdapter.hasStableIds();
    }

    public boolean isEmpty()
    {
        return mDecoratedBaseAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        return mDecoratedBaseAdapter.isEnabled(i);
    }

    public void notifyDataSetChanged()
    {
        if (!(mDecoratedBaseAdapter instanceof ArrayAdapter))
        {
            mDecoratedBaseAdapter.notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated()
    {
        mDecoratedBaseAdapter.notifyDataSetInvalidated();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mDecoratedBaseAdapter.registerDataSetObserver(datasetobserver);
    }

    public void setAbsListView(AbsListView abslistview)
    {
        setListViewWrapper(new AbsListViewWrapper(abslistview));
    }

    public void setListViewWrapper(ListViewWrapper listviewwrapper)
    {
        mListViewWrapper = listviewwrapper;
        if (mDecoratedBaseAdapter instanceof ListViewWrapperSetter)
        {
            ((ListViewWrapperSetter)mDecoratedBaseAdapter).setListViewWrapper(listviewwrapper);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDecoratedBaseAdapter.unregisterDataSetObserver(datasetobserver);
    }
}
