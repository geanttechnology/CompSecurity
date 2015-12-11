// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.view.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderGridView extends GridView
{
    private static class FixedViewInfo
    {

        public Object data;
        public boolean isSelectable;
        public View view;
        public ViewGroup viewContainer;

        private FixedViewInfo()
        {
        }

    }

    private class FullWidthFixedViewLayout extends FrameLayout
    {

        final HeaderGridView this$0;

        protected void onMeasure(int i, int j)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), android.view.View.MeasureSpec.getMode(i)), j);
        }

        public FullWidthFixedViewLayout(Context context)
        {
            this$0 = HeaderGridView.this;
            super(context);
        }
    }

    private static class HeaderViewGridAdapter
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
                } while (((FixedViewInfo)arraylist.next()).isSelectable);
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
                    return ((FixedViewInfo)mHeaderViewInfos.get(i / mNumColumns)).data;
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
                ViewGroup viewgroup1 = ((FixedViewInfo)mHeaderViewInfos.get(i / mNumColumns)).viewContainer;
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
                return i % mNumColumns == 0 && ((FixedViewInfo)mHeaderViewInfos.get(i / mNumColumns)).isSelectable;
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
                if (((FixedViewInfo)mHeaderViewInfos.get(i)).view == view)
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

        public HeaderViewGridAdapter(ArrayList arraylist, ListAdapter listadapter)
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


    private ArrayList mHeaderViewInfos;

    public HeaderGridView(Context context)
    {
        super(context);
        mHeaderViewInfos = new ArrayList();
        initHeaderGridView();
    }

    public HeaderGridView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mHeaderViewInfos = new ArrayList();
        initHeaderGridView();
    }

    public HeaderGridView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHeaderViewInfos = new ArrayList();
        initHeaderGridView();
    }

    private void initHeaderGridView()
    {
        super.setClipChildren(false);
    }

    private void removeFixedViewInfo(View view, ArrayList arraylist)
    {
        int j = arraylist.size();
        int i = 0;
        do
        {
label0:
            {
                if (i < j)
                {
                    if (((FixedViewInfo)arraylist.get(i)).view != view)
                    {
                        break label0;
                    }
                    arraylist.remove(i);
                }
                return;
            }
            i++;
        } while (true);
    }

    public void addHeaderView(View view)
    {
        addHeaderView(view, null, true);
    }

    public void addHeaderView(View view, Object obj, boolean flag)
    {
        ListAdapter listadapter = getAdapter();
        if (listadapter != null && !(listadapter instanceof HeaderViewGridAdapter))
        {
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        }
        FixedViewInfo fixedviewinfo = new FixedViewInfo();
        FullWidthFixedViewLayout fullwidthfixedviewlayout = new FullWidthFixedViewLayout(getContext());
        fullwidthfixedviewlayout.addView(view);
        fixedviewinfo.view = view;
        fixedviewinfo.viewContainer = fullwidthfixedviewlayout;
        fixedviewinfo.data = obj;
        fixedviewinfo.isSelectable = flag;
        mHeaderViewInfos.add(fixedviewinfo);
        if (listadapter != null)
        {
            ((HeaderViewGridAdapter)listadapter).notifyDataSetChanged();
        }
    }

    public int getHeaderViewCount()
    {
        return mHeaderViewInfos.size();
    }

    public ListAdapter getWrappedAdapter()
    {
        ListAdapter listadapter1 = getAdapter();
        ListAdapter listadapter = listadapter1;
        if (listadapter1 instanceof HeaderViewGridAdapter)
        {
            listadapter = ((HeaderViewGridAdapter)getAdapter()).getWrappedAdapter();
        }
        return listadapter;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        ListAdapter listadapter = getAdapter();
        if (listadapter != null && (listadapter instanceof HeaderViewGridAdapter))
        {
            ((HeaderViewGridAdapter)listadapter).setNumColumns(getNumColumns());
        }
    }

    public boolean removeHeaderView(View view)
    {
        if (mHeaderViewInfos.size() > 0)
        {
            boolean flag1 = false;
            ListAdapter listadapter = getAdapter();
            boolean flag = flag1;
            if (listadapter != null)
            {
                flag = flag1;
                if (((HeaderViewGridAdapter)listadapter).removeHeader(view))
                {
                    flag = true;
                }
            }
            removeFixedViewInfo(view, mHeaderViewInfos);
            return flag;
        } else
        {
            return false;
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        if (mHeaderViewInfos.size() > 0)
        {
            listadapter = new HeaderViewGridAdapter(mHeaderViewInfos, listadapter);
            int i = getNumColumns();
            if (i > 1)
            {
                listadapter.setNumColumns(i);
            }
            super.setAdapter(listadapter);
            return;
        } else
        {
            super.setAdapter(listadapter);
            return;
        }
    }

    public void setClipChildren(boolean flag)
    {
    }
}
