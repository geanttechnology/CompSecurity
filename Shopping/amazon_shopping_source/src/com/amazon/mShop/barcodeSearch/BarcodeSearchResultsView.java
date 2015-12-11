// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.barcodeSearch;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.mShop.control.barcodeSearch.BarcodeSearchBrowser;
import com.amazon.mShop.control.barcodeSearch.BarcodeSearchController;
import com.amazon.mShop.control.barcodeSearch.BarcodeSearchSubscriber;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.NoMatchSearchResultsView;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

// Referenced classes of package com.amazon.mShop.barcodeSearch:
//            BarcodeSearchResultsAdapter

public class BarcodeSearchResultsView extends ListView
    implements TitleProvider, ObjectSubscriber, BarcodeSearchSubscriber
{

    private AmazonActivity mActivity;
    private BarcodeSearchResultsAdapter mAdapter;
    private String mBarcodeFormat;
    private BarcodeSearchController mBarcodeSearchController;
    private String mBarcodeString;
    private BarcodeSearchBrowser mBrowser;
    private ProgressBar mFooterProgressBar;
    private ViewGroup mFooterProgressBarRow;
    private TextView mFooterStatus;

    public BarcodeSearchResultsView(AmazonActivity amazonactivity, String s, String s1, String s2)
    {
        super(amazonactivity);
        mActivity = amazonactivity;
        mBarcodeString = s;
        mBarcodeFormat = s1;
        mBarcodeSearchController = new BarcodeSearchController(this);
        setHeaderDividersEnabled(false);
        setFooterDividersEnabled(false);
        setItemsCanFocus(true);
        mFooterProgressBarRow = (ViewGroup)View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.barcode_search_results_view_footer_progressbar_row, null);
        mFooterProgressBar = (ProgressBar)mFooterProgressBarRow.findViewById(com.amazon.mShop.android.lib.R.id.barcode_search_results_view_footer_progress);
        mFooterStatus = (TextView)mFooterProgressBarRow.findViewById(com.amazon.mShop.android.lib.R.id.barcode_search_results_view_footer_status);
        addFooterView(mFooterProgressBarRow);
        mAdapter = new BarcodeSearchResultsAdapter(amazonactivity, com.amazon.mShop.android.lib.R.layout.item_row, mBarcodeSearchController, s2);
        mBrowser = new BarcodeSearchBrowser(null, 8, 3, 0, 100);
        mAdapter.setBrowser(mBrowser);
        mBrowser.setSecondarySubscriber(this);
        mAdapter.setListView(this);
    }

    private void startBarcodeSearch()
    {
        int i = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.item_row_height);
        int j = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding);
        mBarcodeSearchController.startBarcodeSearch(mBarcodeString, mBarcodeFormat, i - j);
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        if (mActivity.isErrorBoxShowing())
        {
            return getResources().getString(com.amazon.mShop.android.lib.R.string.search_results_title);
        }
        int i = mBarcodeSearchController.getBarcodeSearchResultType();
        if (mBarcodeSearchController.getBarcodeSearchStatus() == 2)
        {
            if (i == 0)
            {
                return mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_no_result);
            }
            if (i == 1)
            {
                return mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_result);
            } else
            {
                return mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_search_result_plural);
            }
        } else
        {
            return mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.bc_searching_for);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        startBarcodeSearch();
    }

    public void onAvailableCountReceived(int i)
    {
    }

    public void onCancelled()
    {
    }

    public void onCompleted()
    {
        mActivity.updateTitle(this);
        int i = mBarcodeSearchController.getBarcodeSearchResultType();
        if (i == 0)
        {
            RefMarkerObserver.logRefMarker("scan_no_matches");
        } else
        {
            RefMarkerObserver.logRefMarker("scan_success");
        }
        if (!mBarcodeSearchController.hasMoreResults())
        {
            mFooterProgressBar.setVisibility(8);
            mFooterStatus.setVisibility(8);
            if (i == 0)
            {
                removeFooterView(mFooterProgressBarRow);
                addFooterView(new NoMatchSearchResultsView((AmazonActivity)getContext(), "scanItSearchResultsType"));
            }
        }
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mBarcodeSearchController.cancel();
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        mBarcodeSearchController.setBarcodeSearchStatus(2);
        AmazonErrorUtils.reportMShopServerError((AmazonActivity)getContext(), new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final BarcodeSearchResultsView this$0;

            public void onActionButtonClick(int i)
            {
                startBarcodeSearch();
                mActivity.updateTitle(BarcodeSearchResultsView.this);
            }

            
            {
                this$0 = BarcodeSearchResultsView.this;
                super();
            }
        }, this, exception);
        mActivity.updateTitle(this);
    }

    public void onImageReceived(byte abyte0[], int i)
    {
    }

    public void onMatchedItemReceived(SearchResult searchresult)
    {
        mAdapter.notifyDataSetChanged();
    }

    public void onMatchedItemThumbnailReceived(byte abyte0[])
    {
        mAdapter.notifyDataSetChanged();
    }

    public void onMatchedItemsReturnedReceived(boolean flag)
    {
        if (mBarcodeSearchController.getBarcodeSearchResultType() == 0)
        {
            mBarcodeSearchController.setBarcodeSearchStatus(2);
        }
        mAdapter.notifyDataSetChanged();
    }

    public void onObjectReceived(Object obj, int i)
    {
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    public void onObjectsReceived()
    {
    }

    public void onPageComplete()
    {
        if (mBrowser.getAvailableCount() == 0 && mBrowser.getReceivedCount() == 0)
        {
            mFooterProgressBar.setVisibility(8);
            mFooterStatus.setVisibility(8);
            removeFooterView(mFooterProgressBarRow);
            mBarcodeSearchController.setBarcodeSearchStatus(2);
            return;
        }
        if (mBrowser.getAvailableCount() <= mBrowser.getReceivedCount())
        {
            mFooterProgressBar.setVisibility(8);
            mFooterStatus.setVisibility(8);
            removeFooterView(mFooterProgressBarRow);
            mBarcodeSearchController.setBarcodeSearchStatus(2);
            return;
        } else
        {
            mFooterProgressBarRow.setVisibility(0);
            mFooterStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
            return;
        }
    }

    public void onQueryDescriptorReceived(QueryDescriptor querydescriptor)
    {
        if (querydescriptor == null || Util.isEmpty(querydescriptor.getQueryData()))
        {
            mBarcodeSearchController.setBarcodeSearchStatus(2);
        } else
        {
            int i = mBarcodeSearchController.getBarcodeSearchResultType();
            if (i == 1 || i == 2)
            {
                mBrowser.setQueryDescriptor(querydescriptor);
                mBrowser.startFirstPageRequest(0x7fffffff, null);
                return;
            }
        }
    }

    public void onResultsTitleReceived(String s)
    {
        mAdapter.notifyDataSetChanged();
    }

    public void onSearchResultReceived(SearchResult searchresult, int i)
    {
    }


}
