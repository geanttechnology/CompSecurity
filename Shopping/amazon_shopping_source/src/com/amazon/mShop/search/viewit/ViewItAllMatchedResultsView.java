// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItPhotoCaptureView, ViewItSlidingDrawerBrowser, ViewItSearchResultWrapper, 
//            ViewItSlidingDrawerView, ViewItItemView

public class ViewItAllMatchedResultsView extends LinearLayout
{
    public class ViewItAllMatchesAdapter extends BaseAdapter
    {

        final ViewItAllMatchedResultsView this$0;

        public int getCount()
        {
            if (Util.isEmpty(mObject.getSearchResults()))
            {
                return 0;
            } else
            {
                return mObject.getSearchResults().size();
            }
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(i);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = (SearchResult)mObject.getSearchResults().get(i);
            if (view == null)
            {
                view = (ViewItItemView)LayoutInflater.from(mActivity).inflate(com.amazon.mShop.android.lib.R.layout.view_it_item_row, null);
            } else
            {
                view = (ViewItItemView)view;
            }
            view.setObject(mObject, viewgroup, mBrowser, ViewItItemView.ItemShowType.ITEM_SHOW_IN_ALL_MATCHES);
            view.updateButtonVisibility();
            if (mBrowser.isObjectToDelete(mObject, viewgroup, ViewItItemView.ItemShowType.ITEM_SHOW_IN_ALL_MATCHES))
            {
                view.showUndoButtonContent();
            } else
            {
                view.showItemContent();
            }
            view.update(null, viewgroup, (byte[])null, i);
            view.setItemClickAction(mSlidingDrawer, viewgroup, mObject, true);
            return view;
        }

        public ViewItAllMatchesAdapter()
        {
            this$0 = ViewItAllMatchedResultsView.this;
            super();
        }
    }


    private ViewItActivity mActivity;
    private ViewItSlidingDrawerBrowser mBrowser;
    private ListView mListView;
    private ViewItSearchResultWrapper mObject;
    private final ViewItSlidingDrawerView mSlidingDrawer;

    public ViewItAllMatchedResultsView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mActivity = (ViewItActivity)context;
        mSlidingDrawer = mActivity.getPhotoCaptureView().getViewItSlidingDrawerView();
    }

    public void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mBrowser.setAllMatchesPageListingAdapter(null);
    }

    public void updateAllMatchedResultsView(ViewItSearchResultWrapper viewitsearchresultwrapper, ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser)
    {
        mObject = viewitsearchresultwrapper;
        mBrowser = viewitslidingdrawerbrowser;
        mListView = (ListView)findViewById(com.amazon.mShop.android.lib.R.id.items_list);
        mListView.setDividerHeight(0);
        mListView.setItemsCanFocus(true);
        viewitsearchresultwrapper = new ViewItAllMatchesAdapter();
        mListView.setAdapter(viewitsearchresultwrapper);
        mListView.setOnItemClickListener(null);
        mBrowser.setAllMatchesPageListingAdapter(viewitsearchresultwrapper);
    }




}
