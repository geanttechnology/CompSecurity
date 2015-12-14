// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package in.srain.cube.views;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package in.srain.cube.views:
//            GridViewWithHeaderAndFooter

private static class mAreAllFixedViewsSelectable
    implements Filterable, WrapperListAdapter
{

    static final ArrayList EMPTY_INFO_LIST = new ArrayList();
    private final ListAdapter mAdapter;
    boolean mAreAllFixedViewsSelectable;
    private boolean mCacheFirstHeaderView;
    private boolean mCachePlaceHoldView;
    private final DataSetObservable mDataSetObservable = new DataSetObservable();
    ArrayList mFooterViewInfos;
    ArrayList mHeaderViewInfos;
    private final boolean mIsFilterable;
    private int mNumColumns;
    private int mRowHeight;

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
            } while (((mAreAllFixedViewsSelectable)arraylist.next()).able);
            return false;
        }
        return true;
    }

    private int getAdapterAndPlaceHolderCount()
    {
        return (int)(Math.ceil((1.0F * (float)mAdapter.getCount()) / (float)mNumColumns) * (double)mNumColumns);
    }

    public boolean areAllItemsEnabled()
    {
        return mAdapter == null || mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
    }

    public int getCount()
    {
        if (mAdapter != null)
        {
            return (getFootersCount() + getHeadersCount()) * mNumColumns + getAdapterAndPlaceHolderCount();
        } else
        {
            return (getFootersCount() + getHeadersCount()) * mNumColumns;
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
        Object obj;
        int j;
        obj = null;
        j = getHeadersCount() * mNumColumns;
        if (i >= j) goto _L2; else goto _L1
_L1:
        if (i % mNumColumns == 0)
        {
            obj = ((mNumColumns)mHeaderViewInfos.get(i / mNumColumns)).mNumColumns;
        }
_L4:
        return obj;
_L2:
        int k;
        k = i - j;
        i = 0;
        if (mAdapter == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = getAdapterAndPlaceHolderCount();
        i = j;
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (k < mAdapter.getCount())
        {
            return mAdapter.getItem(k);
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = k - i;
        if (i % mNumColumns == 0)
        {
            return ((mNumColumns)mFooterViewInfos.get(i)).mFooterViewInfos;
        }
        if (true) goto _L4; else goto _L5
_L5:
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
        int j;
        int k;
        int l;
        int i1;
        int j1;
        i1 = getHeadersCount() * mNumColumns;
        int k1;
        if (mAdapter == null)
        {
            l = 0;
        } else
        {
            l = mAdapter.getViewTypeCount() - 1;
        }
        k = -2;
        j = k;
        if (mCachePlaceHoldView)
        {
            j = k;
            if (i < i1)
            {
                j = k;
                if (i == 0)
                {
                    j = k;
                    if (mCacheFirstHeaderView)
                    {
                        j = mHeaderViewInfos.size() + l + mFooterViewInfos.size() + 1 + 1;
                    }
                }
                if (i % mNumColumns != 0)
                {
                    j = l + (i / mNumColumns + 1);
                }
            }
        }
        k1 = i - i1;
        i1 = 0;
        k = j;
        if (mAdapter == null) goto _L2; else goto _L1
_L1:
        j1 = getAdapterAndPlaceHolderCount();
        i1 = j1;
        k = j;
        if (k1 < 0) goto _L2; else goto _L3
_L3:
        i1 = j1;
        k = j;
        if (k1 >= j1) goto _L2; else goto _L4
_L4:
        if (k1 >= mAdapter.getCount()) goto _L6; else goto _L5
_L5:
        k = mAdapter.getItemViewType(k1);
        i1 = j1;
_L2:
        j = k;
        if (mCachePlaceHoldView)
        {
            i1 = k1 - i1;
            j = k;
            if (i1 >= 0)
            {
                j = k;
                if (i1 < getCount())
                {
                    j = k;
                    if (i1 % mNumColumns != 0)
                    {
                        j = mHeaderViewInfos.size() + l + 1 + (i1 / mNumColumns + 1);
                    }
                }
            }
        }
        if (GridViewWithHeaderAndFooter.DEBUG)
        {
            Log.d("GridViewHeaderAndFooter", String.format("getItemViewType: pos: %s, result: %s", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Boolean.valueOf(mCachePlaceHoldView), Boolean.valueOf(mCacheFirstHeaderView)
            }));
        }
        return j;
_L6:
        i1 = j1;
        k = j;
        if (mCachePlaceHoldView)
        {
            k = mHeaderViewInfos.size() + l + 1;
            i1 = j1;
        }
        if (true) goto _L2; else goto _L7
_L7:
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        int j;
        if (GridViewWithHeaderAndFooter.DEBUG)
        {
            boolean flag;
            if (view == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Log.d("GridViewHeaderAndFooter", String.format("getView: %s, reused: %s", new Object[] {
                Integer.valueOf(i), Boolean.valueOf(flag)
            }));
        }
        j = getHeadersCount() * mNumColumns;
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
        int l = i - j;
        j = 0;
        if (mAdapter != null)
        {
            int k = getAdapterAndPlaceHolderCount();
            j = k;
            if (l < k)
            {
                if (l < mAdapter.getCount())
                {
                    return mAdapter.getView(l, view, viewgroup);
                }
                View view2 = view;
                if (view == null)
                {
                    view2 = new View(viewgroup.getContext());
                }
                view2.setVisibility(4);
                view2.setMinimumHeight(mRowHeight);
                return view2;
            }
        }
        j = l - j;
        if (j < getCount())
        {
            ViewGroup viewgroup2 = ((getCount)mFooterViewInfos.get(j / mNumColumns)).ainer;
            if (i % mNumColumns == 0)
            {
                return viewgroup2;
            }
            View view3 = view;
            if (view == null)
            {
                view3 = new View(viewgroup.getContext());
            }
            view3.setVisibility(4);
            view3.setMinimumHeight(viewgroup2.getHeight());
            return view3;
        } else
        {
            throw new ArrayIndexOutOfBoundsException(i);
        }
    }

    public int getViewTypeCount()
    {
        int i;
        int j;
        if (mAdapter == null)
        {
            i = 1;
        } else
        {
            i = mAdapter.getViewTypeCount();
        }
        j = i;
        if (mCachePlaceHoldView)
        {
            int k = mHeaderViewInfos.size() + 1 + mFooterViewInfos.size();
            j = k;
            if (mCacheFirstHeaderView)
            {
                j = k + 1;
            }
            j = i + j;
        }
        if (GridViewWithHeaderAndFooter.DEBUG)
        {
            Log.d("GridViewHeaderAndFooter", String.format("getViewTypeCount: %s", new Object[] {
                Integer.valueOf(j)
            }));
        }
        return j;
    }

    public ListAdapter getWrappedAdapter()
    {
        return mAdapter;
    }

    public boolean hasStableIds()
    {
        return mAdapter != null && mAdapter.hasStableIds();
    }

    public boolean isEmpty()
    {
        return mAdapter == null || mAdapter.isEmpty();
    }

    public boolean isEnabled(int i)
    {
        int j;
        boolean flag;
        flag = true;
        j = getHeadersCount() * mNumColumns;
        if (i >= j) goto _L2; else goto _L1
_L1:
        if (i % mNumColumns == 0 && ((mNumColumns)mHeaderViewInfos.get(i / mNumColumns)).able)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        return flag;
_L2:
        int k;
        k = i - j;
        i = 0;
        if (mAdapter == null)
        {
            break; /* Loop/switch isn't completed */
        }
        j = getAdapterAndPlaceHolderCount();
        i = j;
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (k >= mAdapter.getCount() || !mAdapter.isEnabled(k))
        {
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = k - i;
        if (i % mNumColumns != 0 || !((mNumColumns)mFooterViewInfos.get(i / mNumColumns)).able)
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
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

    public void setNumColumns(int i)
    {
        while (i < 1 || mNumColumns == i) 
        {
            return;
        }
        mNumColumns = i;
        notifyDataSetChanged();
    }

    public void setRowHeight(int i)
    {
        mRowHeight = i;
    }

    public void unregisterDataSetObserver(DataSetObserver datasetobserver)
    {
        mDataSetObservable.unregisterObserver(datasetobserver);
        if (mAdapter != null)
        {
            mAdapter.unregisterDataSetObserver(datasetobserver);
        }
    }


    public (ArrayList arraylist, ArrayList arraylist1, ListAdapter listadapter)
    {
        boolean flag = true;
        super();
        mNumColumns = 1;
        mRowHeight = -1;
        mCachePlaceHoldView = true;
        mCacheFirstHeaderView = false;
        mAdapter = listadapter;
        mIsFilterable = listadapter instanceof Filterable;
        if (arraylist == null)
        {
            mHeaderViewInfos = EMPTY_INFO_LIST;
        } else
        {
            mHeaderViewInfos = arraylist;
        }
        if (arraylist1 == null)
        {
            mFooterViewInfos = EMPTY_INFO_LIST;
        } else
        {
            mFooterViewInfos = arraylist1;
        }
        if (!areAllListInfosSelectable(mHeaderViewInfos) || !areAllListInfosSelectable(mFooterViewInfos))
        {
            flag = false;
        }
        mAreAllFixedViewsSelectable = flag;
    }
}
