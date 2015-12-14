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
import com.nhaarman.listviewanimations.widget.DynamicListView;

// Referenced classes of package com.nhaarman.listviewanimations:
//            ListViewSetter, ArrayAdapter

public abstract class BaseAdapterDecorator extends BaseAdapter
    implements SectionIndexer, com.nhaarman.listviewanimations.widget.DynamicListView.Swappable, ListViewSetter
{

    protected final BaseAdapter mDecoratedBaseAdapter;
    private boolean mIsParentHorizontalScrollContainer;
    private AbsListView mListView;
    private int mResIdTouchChild;

    public BaseAdapterDecorator(BaseAdapter baseadapter)
    {
        mDecoratedBaseAdapter = baseadapter;
    }

    public boolean areAllItemsEnabled()
    {
        return mDecoratedBaseAdapter.areAllItemsEnabled();
    }

    public AbsListView getAbsListView()
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

    public int getTouchChild()
    {
        return mResIdTouchChild;
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
        if (!(mDecoratedBaseAdapter instanceof ArrayAdapter))
        {
            mDecoratedBaseAdapter.notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged(boolean flag)
    {
        if (flag || !(mDecoratedBaseAdapter instanceof ArrayAdapter))
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
        mListView = abslistview;
        if (mDecoratedBaseAdapter instanceof ListViewSetter)
        {
            ((ListViewSetter)mDecoratedBaseAdapter).setAbsListView(abslistview);
        }
        if (mListView instanceof DynamicListView)
        {
            abslistview = (DynamicListView)mListView;
            abslistview.setIsParentHorizontalScrollContainer(mIsParentHorizontalScrollContainer);
            abslistview.setDynamicTouchChild(mResIdTouchChild);
        }
    }

    public void setIsParentHorizontalScrollContainer(boolean flag)
    {
        mIsParentHorizontalScrollContainer = flag;
        if (mListView instanceof DynamicListView)
        {
            ((DynamicListView)mListView).setIsParentHorizontalScrollContainer(mIsParentHorizontalScrollContainer);
        }
    }

    public void setTouchChild(int i)
    {
        mResIdTouchChild = i;
        if (mListView instanceof DynamicListView)
        {
            ((DynamicListView)mListView).setDynamicTouchChild(mResIdTouchChild);
        }
    }

    public void swapItems(int i, int j)
    {
        if (mDecoratedBaseAdapter instanceof com.nhaarman.listviewanimations.widget.DynamicListView.Swappable)
        {
            ((com.nhaarman.listviewanimations.widget.DynamicListView.Swappable)mDecoratedBaseAdapter).swapItems(i, j);
        }
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDecoratedBaseAdapter.unregisterDataSetObserver(datasetobserver);
    }
}
