// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class HeaderViewListAdapter
    implements Filterable, WrapperListAdapter
{
    public static class FixedViewInfo
    {

        public Object data;
        public boolean isSelectable;
        public View view;

        public FixedViewInfo()
        {
        }
    }


    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    ArrayList mFooterViewInfos;
    ArrayList mHeaderViewInfos;
    private final boolean mIsFilterable;

    public HeaderViewListAdapter(ArrayList arraylist, ArrayList arraylist1, ListAdapter listadapter)
    {
        mAdapter = listadapter;
        mIsFilterable = listadapter instanceof Filterable;
        boolean flag;
        if (arraylist == null)
        {
            mHeaderViewInfos = new ArrayList();
        } else
        {
            mHeaderViewInfos = arraylist;
        }
        if (arraylist1 == null)
        {
            mFooterViewInfos = new ArrayList();
        } else
        {
            mFooterViewInfos = arraylist1;
        }
        if (areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mAreAllFixedViewsSelectable = flag;
    }

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

    public void addFooter(FixedViewInfo fixedviewinfo)
    {
        mFooterViewInfos.add(fixedviewinfo);
        boolean flag;
        if (areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mAreAllFixedViewsSelectable = flag;
    }

    public boolean areAllItemsEnabled()
    {
        return mAdapter == null || mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
    }

    public int getCount()
    {
        if (mAdapter != null)
        {
            return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        } else
        {
            return getFootersCount() + getHeadersCount();
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

    public int getFootersCount()
    {
        return mFooterViewInfos.size();
    }

    public int getHeadersCount()
    {
        return mHeaderViewInfos.size();
    }

    public Object getItem(int i)
    {
        int j = getHeadersCount();
        if (i < j)
        {
            return ((FixedViewInfo)mHeaderViewInfos.get(i)).data;
        }
        int l = i - j;
        i = 0;
        if (mAdapter != null)
        {
            int k = mAdapter.getCount();
            i = k;
            if (l < k)
            {
                return mAdapter.getItem(l);
            }
        }
        return ((FixedViewInfo)mFooterViewInfos.get(l - i)).data;
    }

    public long getItemId(int i)
    {
        int j = getHeadersCount();
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
        int j = getHeadersCount();
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
        int j = getHeadersCount();
        if (i < j)
        {
            return ((FixedViewInfo)mHeaderViewInfos.get(i)).view;
        }
        int l = i - j;
        i = 0;
        if (mAdapter != null)
        {
            int k = mAdapter.getCount();
            i = k;
            if (l < k)
            {
                return mAdapter.getView(l, view, viewgroup);
            }
        }
        return ((FixedViewInfo)mFooterViewInfos.get(l - i)).view;
    }

    public int getViewTypeCount()
    {
        if (mAdapter != null)
        {
            return mAdapter.getViewTypeCount();
        } else
        {
            return 1;
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
        return mAdapter == null || mAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        int j = getHeadersCount();
        if (i < j)
        {
            return ((FixedViewInfo)mHeaderViewInfos.get(i)).isSelectable;
        }
        int l = i - j;
        i = 0;
        if (mAdapter != null)
        {
            int k = mAdapter.getCount();
            i = k;
            if (l < k)
            {
                return mAdapter.isEnabled(l);
            }
        }
        return ((FixedViewInfo)mFooterViewInfos.get(l - i)).isSelectable;
    }

    public void registerDataSetObserver(DataSetObserver datasetobserver)
    {
        if (mAdapter != null)
        {
            mAdapter.registerDataSetObserver(datasetobserver);
        }
    }

    public void removeAllFooters()
    {
        mFooterViewInfos.clear();
        boolean flag;
        if (areAllListInfosSelectable(mHeaderViewInfos) && areAllListInfosSelectable(mFooterViewInfos))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mAreAllFixedViewsSelectable = flag;
    }

    public boolean removeFooter(View view)
    {
        boolean flag1 = false;
        for (int i = 0; i < mFooterViewInfos.size(); i++)
        {
            if (((FixedViewInfo)mFooterViewInfos.get(i)).view == view)
            {
                mFooterViewInfos.remove(i);
                boolean flag = flag1;
                if (areAllListInfosSelectable(mHeaderViewInfos))
                {
                    flag = flag1;
                    if (areAllListInfosSelectable(mFooterViewInfos))
                    {
                        flag = true;
                    }
                }
                mAreAllFixedViewsSelectable = flag;
                return true;
            }
        }

        return false;
    }

    public boolean removeHeader(View view)
    {
        boolean flag1 = false;
        for (int i = 0; i < mHeaderViewInfos.size(); i++)
        {
            if (((FixedViewInfo)mHeaderViewInfos.get(i)).view == view)
            {
                mHeaderViewInfos.remove(i);
                boolean flag = flag1;
                if (areAllListInfosSelectable(mHeaderViewInfos))
                {
                    flag = flag1;
                    if (areAllListInfosSelectable(mFooterViewInfos))
                    {
                        flag = true;
                    }
                }
                mAreAllFixedViewsSelectable = flag;
                return true;
            }
        }

        return false;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(datasetobserver);
        }
    }
}
