// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.comcast.cim.cmasl.android.util.view.widget:
//            HeaderGridView

private static class mHeaderViewInfos
    implements Filterable, WrapperListAdapter
{

    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    ArrayList mHeaderViewInfos;
    private final boolean mIsFilterable;
    private int mNumColumns;

    private boolean areAllListInfosSelectable(ArrayList arraylist)
    {
label0:
        {
            if (arraylist == null)
            {
                break label0;
            }
            arraylist = arraylist.iterator();
            do
            {
                if (!arraylist.hasNext())
                {
                    break label0;
                }
            } while (((mHeaderViewInfos)arraylist.next()).able);
            return false;
        }
        return true;
    }

    public boolean areAllItemsEnabled()
    {
        return mAdapter == null || mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
    }

    public int getCount()
    {
        if (mAdapter != null)
        {
            return getHeadersCount() * mNumColumns + mAdapter.getCount();
        } else
        {
            return getHeadersCount() * mNumColumns;
        }
    }

    public Filter getFilter()
    {
        if (mIsFilterable)
        {
            return ((Filterable)mAdapter).getFilter();
        } else
        {
            return null;
        }
    }

    public int getHeadersCount()
    {
        return mHeaderViewInfos.size();
    }

    public Object getItem(int i)
    {
        int j = getHeadersCount() * mNumColumns;
        if (i < j)
        {
            if (i % mNumColumns == 0)
            {
                return ((mNumColumns)mHeaderViewInfos.get(i / mNumColumns)).mNumColumns;
            } else
            {
                return null;
            }
        }
        j = i - j;
        if (mAdapter != null && j < mAdapter.getCount())
        {
            return mAdapter.getItem(j);
        } else
        {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public long getItemId(int i)
    {
        int j = getHeadersCount() * mNumColumns;
        if (mAdapter != null && i >= j)
        {
            i -= j;
            if (i < mAdapter.getCount())
            {
                return mAdapter.getItemId(i);
            }
        }
        return -1L;
    }

    public int getItemViewType(int i)
    {
        int j = getHeadersCount() * mNumColumns;
        if (i < j && i % mNumColumns != 0)
        {
            if (mAdapter != null)
            {
                return mAdapter.getViewTypeCount();
            } else
            {
                return 1;
            }
        }
        if (mAdapter != null && i >= j)
        {
            i -= j;
            if (i < mAdapter.getCount())
            {
                return mAdapter.getItemViewType(i);
            }
        }
        return -2;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j = getHeadersCount() * mNumColumns;
        if (i < j)
        {
            ViewGroup viewgroup1 = ((mNumColumns)mHeaderViewInfos.get(i / mNumColumns)).ainer;
            if (i % mNumColumns == 0)
            {
                return viewgroup1;
            }
            View view1 = view;
            if (view == null)
            {
                view1 = new View(viewgroup.getContext());
            }
            view1.setVisibility(4);
            view1.setMinimumHeight(viewgroup1.getHeight());
            return view1;
        }
        j = i - j;
        if (mAdapter != null && j < mAdapter.getCount())
        {
            return mAdapter.getView(j, view, viewgroup);
        } else
        {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public int getViewTypeCount()
    {
        if (mAdapter != null)
        {
            return mAdapter.getViewTypeCount() + 1;
        } else
        {
            return 2;
        }
    }

    public ListAdapter getWrappedAdapter()
    {
        return mAdapter;
    }

    public boolean hasStableIds()
    {
        if (mAdapter != null)
        {
            return mAdapter.hasStableIds();
        } else
        {
            return false;
        }
    }

    public boolean isEmpty()
    {
        return (mAdapter == null || mAdapter.isEmpty()) && getHeadersCount() == 0;
    }

    public boolean isEnabled(int i)
    {
        int j = getHeadersCount() * mNumColumns;
        if (i < j)
        {
            return i % mNumColumns == 0 && ((mNumColumns)mHeaderViewInfos.get(i / mNumColumns)).able;
        }
        j = i - j;
        if (mAdapter != null && j < mAdapter.getCount())
        {
            return mAdapter.isEnabled(j);
        } else
        {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public void notifyDataSetChanged()
    {
        mDataSetObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObservable.registerObserver(datasetobserver);
        if (mAdapter != null)
        {
            mAdapter.registerDataSetObserver(datasetobserver);
        }
    }

    public boolean removeHeader(View view)
    {
        for (int i = 0; i < mHeaderViewInfos.size(); i++)
        {
            if (((mHeaderViewInfos)mHeaderViewInfos.get(i)).mHeaderViewInfos == view)
            {
                mHeaderViewInfos.remove(i);
                mAreAllFixedViewsSelectable = areAllListInfosSelectable(mHeaderViewInfos);
                mDataSetObservable.notifyChanged();
                return true;
            }
        }

        return false;
    }

    public void setNumColumns(int i)
    {
        if (i < 1)
        {
            throw new IllegalArgumentException("Number of columns must be 1 or more");
        }
        if (mNumColumns != i)
        {
            mNumColumns = i;
            notifyDataSetChanged();
        }
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObservable.unregisterObserver(datasetobserver);
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(datasetobserver);
        }
    }

    public Y(ArrayList arraylist, ListAdapter listadapter)
    {
        mNumColumns = 1;
        mAdapter = listadapter;
        mIsFilterable = listadapter instanceof Filterable;
        if (arraylist == null)
        {
            throw new IllegalArgumentException("headerViewInfos cannot be null");
        } else
        {
            mHeaderViewInfos = arraylist;
            mAreAllFixedViewsSelectable = areAllListInfosSelectable(mHeaderViewInfos);
            return;
        }
    }
}
