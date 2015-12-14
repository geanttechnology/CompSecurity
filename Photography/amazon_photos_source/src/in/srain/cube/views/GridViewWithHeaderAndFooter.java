// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package in.srain.cube.views;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

public class GridViewWithHeaderAndFooter extends GridView
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

        final GridViewWithHeaderAndFooter this$0;

        protected void onLayout(boolean flag, int i, int j, int k, int l)
        {
            int i1 = getPaddingLeft() + getPaddingLeft();
            if (i1 != i)
            {
                offsetLeftAndRight(i1 - i);
            }
            super.onLayout(flag, i, j, k, l);
        }

        protected void onMeasure(int i, int j)
        {
            super.onMeasure(android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), android.view.View.MeasureSpec.getMode(i)), j);
        }

        public FullWidthFixedViewLayout(Context context)
        {
            this$0 = GridViewWithHeaderAndFooter.this;
            super(context);
        }
    }

    private static class HeaderViewGridAdapter
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
                } while (((FixedViewInfo)arraylist.next()).isSelectable);
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
                obj = ((FixedViewInfo)mHeaderViewInfos.get(i / mNumColumns)).data;
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
                return ((FixedViewInfo)mFooterViewInfos.get(i)).data;
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
                ViewGroup viewgroup2 = ((FixedViewInfo)mFooterViewInfos.get(j / mNumColumns)).viewContainer;
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
            if (i % mNumColumns == 0 && ((FixedViewInfo)mHeaderViewInfos.get(i / mNumColumns)).isSelectable)
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
            if (i % mNumColumns != 0 || !((FixedViewInfo)mFooterViewInfos.get(i / mNumColumns)).isSelectable)
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


        public HeaderViewGridAdapter(ArrayList arraylist, ArrayList arraylist1, ListAdapter listadapter)
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

    private class ItemClickHandler
        implements android.widget.AdapterView.OnItemClickListener, android.widget.AdapterView.OnItemLongClickListener
    {

        final GridViewWithHeaderAndFooter this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (mOnItemClickListener != null)
            {
                i -= getHeaderViewCount() * getNumColumnsCompatible();
                if (i >= 0)
                {
                    mOnItemClickListener.onItemClick(adapterview, view, i, l);
                }
            }
        }

        public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
        {
            if (mOnItemLongClickListener != null)
            {
                i -= getHeaderViewCount() * getNumColumnsCompatible();
                if (i >= 0)
                {
                    mOnItemLongClickListener.onItemLongClick(adapterview, view, i, l);
                }
            }
            return true;
        }

        private ItemClickHandler()
        {
            this$0 = GridViewWithHeaderAndFooter.this;
            super();
        }

    }


    public static boolean DEBUG = false;
    private ArrayList mFooterViewInfos;
    private ArrayList mHeaderViewInfos;
    private ItemClickHandler mItemClickHandler;
    private int mNumColumns;
    private android.widget.AdapterView.OnItemClickListener mOnItemClickListener;
    private android.widget.AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private ListAdapter mOriginalAdapter;
    private int mRowHeight;
    private View mViewForMeasureRowHeight;

    public GridViewWithHeaderAndFooter(Context context)
    {
        super(context);
        mNumColumns = -1;
        mViewForMeasureRowHeight = null;
        mRowHeight = -1;
        mHeaderViewInfos = new ArrayList();
        mFooterViewInfos = new ArrayList();
        initHeaderGridView();
    }

    public GridViewWithHeaderAndFooter(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mNumColumns = -1;
        mViewForMeasureRowHeight = null;
        mRowHeight = -1;
        mHeaderViewInfos = new ArrayList();
        mFooterViewInfos = new ArrayList();
        initHeaderGridView();
    }

    public GridViewWithHeaderAndFooter(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mNumColumns = -1;
        mViewForMeasureRowHeight = null;
        mRowHeight = -1;
        mHeaderViewInfos = new ArrayList();
        mFooterViewInfos = new ArrayList();
        initHeaderGridView();
    }

    private int getColumnWidthCompatible()
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            return super.getColumnWidth();
        }
        int i;
        try
        {
            Field field = android/widget/GridView.getDeclaredField("mColumnWidth");
            field.setAccessible(true);
            i = field.getInt(this);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new RuntimeException(nosuchfieldexception);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException(illegalaccessexception);
        }
        return i;
    }

    private ItemClickHandler getItemClickHandler()
    {
        if (mItemClickHandler == null)
        {
            mItemClickHandler = new ItemClickHandler();
        }
        return mItemClickHandler;
    }

    private int getNumColumnsCompatible()
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            return super.getNumColumns();
        }
        int i;
        try
        {
            Field field = android/widget/GridView.getDeclaredField("mNumColumns");
            field.setAccessible(true);
            i = field.getInt(this);
        }
        catch (Exception exception)
        {
            if (mNumColumns != -1)
            {
                return mNumColumns;
            } else
            {
                throw new RuntimeException("Can not determine the mNumColumns for this API platform, please call setNumColumns to set it.");
            }
        }
        return i;
    }

    private void initHeaderGridView()
    {
    }

    public void addFooterView(View view)
    {
        addFooterView(view, null, true);
    }

    public void addFooterView(View view, Object obj, boolean flag)
    {
        ListAdapter listadapter = getAdapter();
        if (listadapter != null && !(listadapter instanceof HeaderViewGridAdapter))
        {
            throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
        }
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        FixedViewInfo fixedviewinfo = new FixedViewInfo();
        FullWidthFixedViewLayout fullwidthfixedviewlayout = new FullWidthFixedViewLayout(getContext());
        if (layoutparams != null)
        {
            view.setLayoutParams(new android.widget.FrameLayout.LayoutParams(layoutparams.width, layoutparams.height));
            fullwidthfixedviewlayout.setLayoutParams(new android.widget.AbsListView.LayoutParams(layoutparams.width, layoutparams.height));
        }
        fullwidthfixedviewlayout.addView(view);
        fixedviewinfo.view = view;
        fixedviewinfo.viewContainer = fullwidthfixedviewlayout;
        fixedviewinfo.data = obj;
        fixedviewinfo.isSelectable = flag;
        mFooterViewInfos.add(fixedviewinfo);
        if (listadapter != null)
        {
            ((HeaderViewGridAdapter)listadapter).notifyDataSetChanged();
        }
    }

    public int getFooterViewCount()
    {
        return mFooterViewInfos.size();
    }

    public int getHeaderViewCount()
    {
        return mHeaderViewInfos.size();
    }

    public int getHorizontalSpacing()
    {
        int i;
        try
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                Field field = android/widget/GridView.getDeclaredField("mHorizontalSpacing");
                field.setAccessible(true);
                return field.getInt(this);
            }
            i = super.getHorizontalSpacing();
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    public ListAdapter getOriginalAdapter()
    {
        return mOriginalAdapter;
    }

    public int getRowHeight()
    {
        byte byte0 = -1;
        int i;
        if (mRowHeight > 0)
        {
            i = mRowHeight;
        } else
        {
            ListAdapter listadapter = getAdapter();
            int l = getNumColumnsCompatible();
            i = byte0;
            if (listadapter != null)
            {
                i = byte0;
                if (listadapter.getCount() > (mHeaderViewInfos.size() + mFooterViewInfos.size()) * l)
                {
                    int j = getColumnWidthCompatible();
                    View view = getAdapter().getView(mHeaderViewInfos.size() * l, mViewForMeasureRowHeight, this);
                    android.widget.AbsListView.LayoutParams layoutparams1 = (android.widget.AbsListView.LayoutParams)view.getLayoutParams();
                    android.widget.AbsListView.LayoutParams layoutparams = layoutparams1;
                    if (layoutparams1 == null)
                    {
                        layoutparams = new android.widget.AbsListView.LayoutParams(-1, -2, 0);
                        view.setLayoutParams(layoutparams);
                    }
                    int k = getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(0, 0), 0, layoutparams.height);
                    view.measure(getChildMeasureSpec(android.view.View.MeasureSpec.makeMeasureSpec(j, 0x40000000), 0, layoutparams.width), k);
                    mViewForMeasureRowHeight = view;
                    mRowHeight = view.getMeasuredHeight();
                    return mRowHeight;
                }
            }
        }
        return i;
    }

    public int getVerticalSpacing()
    {
        int i;
        try
        {
            if (android.os.Build.VERSION.SDK_INT < 16)
            {
                Field field = android/widget/GridView.getDeclaredField("mVerticalSpacing");
                field.setAccessible(true);
                return field.getInt(this);
            }
            i = super.getVerticalSpacing();
        }
        catch (Exception exception)
        {
            return 0;
        }
        return i;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mViewForMeasureRowHeight = null;
    }

    protected void onMeasure(int i, int j)
    {
        super.onMeasure(i, j);
        ListAdapter listadapter = getAdapter();
        if (listadapter != null && (listadapter instanceof HeaderViewGridAdapter))
        {
            ((HeaderViewGridAdapter)listadapter).setNumColumns(getNumColumnsCompatible());
            ((HeaderViewGridAdapter)listadapter).setRowHeight(getRowHeight());
        }
    }

    public volatile void setAdapter(Adapter adapter)
    {
        setAdapter((ListAdapter)adapter);
    }

    public void setAdapter(ListAdapter listadapter)
    {
        mOriginalAdapter = listadapter;
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0)
        {
            listadapter = new HeaderViewGridAdapter(mHeaderViewInfos, mFooterViewInfos, listadapter);
            int i = getNumColumnsCompatible();
            if (i > 1)
            {
                listadapter.setNumColumns(i);
            }
            listadapter.setRowHeight(getRowHeight());
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

    public void setClipChildrenSupper(boolean flag)
    {
        super.setClipChildren(false);
    }

    public void setNumColumns(int i)
    {
        super.setNumColumns(i);
        mNumColumns = i;
        ListAdapter listadapter = getAdapter();
        if (listadapter != null && (listadapter instanceof HeaderViewGridAdapter))
        {
            ((HeaderViewGridAdapter)listadapter).setNumColumns(i);
        }
    }

    public void setOnItemClickListener(android.widget.AdapterView.OnItemClickListener onitemclicklistener)
    {
        mOnItemClickListener = onitemclicklistener;
        super.setOnItemClickListener(getItemClickHandler());
    }

    public void setOnItemLongClickListener(android.widget.AdapterView.OnItemLongClickListener onitemlongclicklistener)
    {
        mOnItemLongClickListener = onitemlongclicklistener;
        super.setOnItemLongClickListener(getItemClickHandler());
    }




}
