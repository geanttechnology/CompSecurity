// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.utils.ViewUtils;

public class PMListView extends ListView
{
    public static interface LoadMoreItemsListener
    {

        public abstract void loadItems(boolean flag);
    }


    CursorAdapter adapter;
    View emptyContentView;
    private boolean fetchingMoreItemsOnScroll;
    View footerView;
    PMData listData;
    LoadMoreItemsListener loadMoreItemsListener;

    public PMListView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        fetchingMoreItemsOnScroll = false;
        listData = null;
        setupScrollHandler();
        footerView = LayoutInflater.from(context).inflate(0x7f03004d, null);
        super.addFooterView(footerView);
    }

    private void setupScrollHandler()
    {
        setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

            final PMListView this$0;

            public void onScroll(AbsListView abslistview, int i, int j, int k)
            {
label0:
                {
                    if (!fetchingMoreItemsOnScroll && k > 1 && i + j >= k)
                    {
                        fetchingMoreItemsOnScroll = true;
                        if (listData == null || listData.getNextPageMaxValue() == null)
                        {
                            break label0;
                        }
                        ViewUtils.showLoadingProgress(getContext(), footerView);
                        if (loadMoreItemsListener != null)
                        {
                            loadMoreItemsListener.loadItems(true);
                        }
                    }
                    return;
                }
                fetchingMoreItemsOnScroll = false;
                abslistview = (LinearLayout)footerView.findViewById(0x7f0c012d);
                abslistview.removeAllViews();
                ViewUtils.addEmptyView(getContext(), abslistview, 15, false);
            }

            public void onScrollStateChanged(AbsListView abslistview, int i)
            {
            }

            
            {
                this$0 = PMListView.this;
                super();
            }
        });
    }

    public void addFooterView(View view)
    {
        throw new IllegalAccessError("Footer should be added using the setup method");
    }

    public void addHeaderView(View view)
    {
        throw new IllegalAccessError("Header should be added using the setup method");
    }

    public void removeEmptyContentView()
    {
        if (emptyContentView != null)
        {
            super.removeHeaderView(emptyContentView);
        }
        emptyContentView = null;
    }

    public void resetScrollState()
    {
        LinearLayout linearlayout = (LinearLayout)footerView.findViewById(0x7f0c012d);
        linearlayout.removeAllViews();
        ViewUtils.addEmptyView(getContext(), linearlayout, 15, false);
    }

    public void setListData(PMData pmdata)
    {
        listData = pmdata;
    }

    public void setup(CursorAdapter cursoradapter, View view, View view1, LoadMoreItemsListener loadmoreitemslistener)
    {
        adapter = cursoradapter;
        loadMoreItemsListener = loadmoreitemslistener;
        if (view != null)
        {
            super.addHeaderView(view);
        }
        if (view1 != null)
        {
            ((LinearLayout)view1.findViewById(0x7f0c012d)).addView(view1);
        }
        setAdapter(cursoradapter);
    }

    public void showDefaultEmptyContentView()
    {
        emptyContentView = LayoutInflater.from(getContext()).inflate(0x7f030090, null, false);
        super.addHeaderView(emptyContentView);
    }

    public void showEmptyContentView(View view)
    {
        emptyContentView = view;
        super.addHeaderView(view);
    }

    public void updateList()
    {
        if (listData != null)
        {
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            listData.fillCursor(custommatrixcursor);
            adapter.changeCursor(custommatrixcursor);
            adapter.notifyDataSetChanged();
            fetchingMoreItemsOnScroll = false;
        }
    }



/*
    static boolean access$002(PMListView pmlistview, boolean flag)
    {
        pmlistview.fetchingMoreItemsOnScroll = flag;
        return flag;
    }

*/
}
