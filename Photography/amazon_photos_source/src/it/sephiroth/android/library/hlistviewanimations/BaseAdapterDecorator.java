// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.hlistviewanimations;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import it.sephiroth.android.library.widget.AbsHListView;

// Referenced classes of package it.sephiroth.android.library.hlistviewanimations:
//            HListViewSetter

public abstract class BaseAdapterDecorator extends BaseAdapter
    implements SectionIndexer, HListViewSetter
{

    protected final BaseAdapter mDecoratedBaseAdapter;
    protected boolean mIsParentHorizontalScrollContainer;
    protected AbsHListView mListView;

    public BaseAdapterDecorator(BaseAdapter baseadapter)
    {
        mDecoratedBaseAdapter = baseadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return mDecoratedBaseAdapter.areAllItemsEnabled();
    }

    public AbsHListView getAbsHListView()
    {
        return mListView;
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

    public int getPositionForSection(int i)
    {
        if (mDecoratedBaseAdapter instanceof SectionIndexer)
        {
            return ((SectionIndexer)mDecoratedBaseAdapter).getPositionForSection(i);
        } else
        {
            return 0;
        }
    }

    public int getSectionForPosition(int i)
    {
        if (mDecoratedBaseAdapter instanceof SectionIndexer)
        {
            return ((SectionIndexer)mDecoratedBaseAdapter).getSectionForPosition(i);
        } else
        {
            return 0;
        }
    }

    public Object[] getSections()
    {
        if (mDecoratedBaseAdapter instanceof SectionIndexer)
        {
            return ((SectionIndexer)mDecoratedBaseAdapter).getSections();
        } else
        {
            return null;
        }
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

    public boolean isParentHorizontalScrollContainer()
    {
        return mIsParentHorizontalScrollContainer;
    }

    public void notifyDataSetChanged()
    {
        mDecoratedBaseAdapter.notifyDataSetChanged();
    }

    public void notifyDataSetChanged(boolean flag)
    {
        if (flag)
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

    public void setAbsHListView(AbsHListView abshlistview)
    {
        mListView = abshlistview;
        if (mDecoratedBaseAdapter instanceof HListViewSetter)
        {
            ((HListViewSetter)mDecoratedBaseAdapter).setAbsHListView(abshlistview);
        }
    }

    public void setIsParentHorizontalScrollContainer(boolean flag)
    {
        mIsParentHorizontalScrollContainer = flag;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDecoratedBaseAdapter.unregisterDataSetObserver(datasetobserver);
    }
}
