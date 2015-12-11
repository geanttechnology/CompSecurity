// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BarcodeSearchRequest;
import com.amazon.rio.j2me.client.services.mShop.BarcodeSearchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.SearchResultsCounts;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItMetricHelper, ViewItScannedItemAnimationFrame, ViewItSearchResultWrapper, 
//            ViewItUtil

public class ViewItItemBarcodeSearchController
    implements BarcodeSearchResponseListener
{

    private ViewItActivity mActivity;
    private String mBarcodeString;
    private boolean mMatchedItemsReturned;
    private ViewItMetricHelper mMetricHelper;
    private SearchResult mOneMatchedSearchResult;
    private List mSearchResultsList;
    private ServiceCall mServiceCall;
    private ViewItScannedItemAnimationFrame mViewItScannedItemAnimationFrame;

    public ViewItItemBarcodeSearchController(ViewItActivity viewitactivity, ViewItScannedItemAnimationFrame viewitscanneditemanimationframe)
    {
        mServiceCall = null;
        mBarcodeString = null;
        mSearchResultsList = null;
        mOneMatchedSearchResult = null;
        mMatchedItemsReturned = false;
        mActivity = viewitactivity;
        mMetricHelper = mActivity.getViewItMetricHelper();
        mViewItScannedItemAnimationFrame = viewitscanneditemanimationframe;
    }

    private int getBarcodeSearchResultType()
    {
        if (mMatchedItemsReturned)
        {
            return 2;
        }
        return mOneMatchedSearchResult == null ? 0 : 1;
    }

    public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
    {
    }

    public void cancel()
    {
        if (mServiceCall != null)
        {
            mServiceCall.cancel();
        }
    }

    public void cancelled(final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItItemBarcodeSearchController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (mServiceCall == sc)
                {
                    mViewItScannedItemAnimationFrame.dismissAnimationWindow(true);
                    mServiceCall = null;
                    mMetricHelper.cancelFlowBarcodeNoMatchesObserver();
                    mMetricHelper.cancelFlowBarcodeFailObserver();
                    mMetricHelper.cancelFlowBarcodeSuccessObserver();
                }
            }

            
            {
                this$0 = ViewItItemBarcodeSearchController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public void completed(final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItItemBarcodeSearchController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (mServiceCall != sc) goto _L2; else goto _L1
_L1:
                Object obj;
                String s;
                int i;
                mMetricHelper.cancelFlowBarcodeFailObserver();
                obj = new ArrayList();
                i = getBarcodeSearchResultType();
                s = (new StringBuilder()).append(ResultWrapper.ResultType.BARCODE.getTypeValue()).append(mBarcodeString).toString();
                if (i != 1) goto _L4; else goto _L3
_L3:
                ((List) (obj)).add(mOneMatchedSearchResult);
                obj = new ViewItSearchResultWrapper(s, ((List) (obj)), null, ViewItSearchResultWrapper.getCurrentDate(), true);
                mViewItScannedItemAnimationFrame.updateToShowItemContentInLoadingWindow(((ViewItSearchResultWrapper) (obj)));
                mMetricHelper.cancelFlowBarcodeNoMatchesObserver();
                mMetricHelper.finishFlowBarcodeSuccessObserver();
                RefMarkerObserver.logRefMarker("fl_barcode_success");
_L6:
                mServiceCall = null;
_L2:
                return;
_L4:
                if (i == 2)
                {
                    if (mOneMatchedSearchResult != null)
                    {
                        ((List) (obj)).add(mOneMatchedSearchResult);
                    }
                    if (!Util.isEmpty(mSearchResultsList))
                    {
                        ViewItUtil.removeIfContained(mSearchResultsList, mOneMatchedSearchResult);
                        ((List) (obj)).addAll(mSearchResultsList);
                    }
                    obj = new ViewItSearchResultWrapper(s, ((List) (obj)), null, ViewItSearchResultWrapper.getCurrentDate(), true);
                    mViewItScannedItemAnimationFrame.updateToShowItemContentInLoadingWindow(((ViewItSearchResultWrapper) (obj)));
                    mMetricHelper.cancelFlowBarcodeNoMatchesObserver();
                    mMetricHelper.finishFlowBarcodeSuccessObserver();
                    RefMarkerObserver.logRefMarker("fl_barcode_success");
                } else
                if (i == 0)
                {
                    mViewItScannedItemAnimationFrame.showServiceCallErrorInLoadingWindow(null, mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_no_matched_item_found), ViewItDialogHelper.DialogType.ERROR_NO_MATCHED_ITEM);
                    mMetricHelper.finishFlowBarcodeNoMatchesObserver();
                    mMetricHelper.cancelFlowBarcodeSuccessObserver();
                    RefMarkerObserver.logRefMarker("fl_barcode_nomatch");
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                this$0 = ViewItItemBarcodeSearchController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItItemBarcodeSearchController this$0;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                if (mServiceCall == sc)
                {
                    mViewItScannedItemAnimationFrame.showServiceCallErrorInLoadingWindow(null, UIUtils.getMessageForException(mActivity, e), ViewItDialogHelper.DialogType.ERROR_MSHOP_SERVER);
                    mServiceCall = null;
                    mMetricHelper.finishFlowBarcodeFailObserver();
                    mMetricHelper.cancelFlowBarcodeNoMatchesObserver();
                    mMetricHelper.cancelFlowBarcodeSuccessObserver();
                }
            }

            
            {
                this$0 = ViewItItemBarcodeSearchController.this;
                sc = servicecall;
                e = exception;
                super();
            }
        });
    }

    public void receivedCounts(SearchResultsCounts searchresultscounts, ServiceCall servicecall)
    {
    }

    public void receivedImage(byte abyte0[], int i, ServiceCall servicecall)
    {
    }

    public void receivedMatchedItem(final SearchResult value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItItemBarcodeSearchController this$0;
            final ServiceCall val$sc;
            final SearchResult val$value;

            public void run()
            {
                if (mServiceCall == sc)
                {
                    mOneMatchedSearchResult = value;
                }
            }

            
            {
                this$0 = ViewItItemBarcodeSearchController.this;
                sc = servicecall;
                value = searchresult;
                super();
            }
        });
    }

    public void receivedMatchedItemThumbnail(byte abyte0[], ServiceCall servicecall)
    {
    }

    public void receivedMatchedItemsReturned(Boolean boolean1, ServiceCall servicecall)
    {
        mMatchedItemsReturned = boolean1.booleanValue();
    }

    public void receivedQueryDescriptor(QueryDescriptor querydescriptor, ServiceCall servicecall)
    {
    }

    public void receivedResultsTitle(String s, ServiceCall servicecall)
    {
    }

    public void receivedSearchResult(SearchResult searchresult, int i, ServiceCall servicecall)
    {
        mSearchResultsList.add(i, searchresult);
    }

    public void startBarcodeSearch(List list)
    {
        mSearchResultsList = new ArrayList();
        mMatchedItemsReturned = false;
        mOneMatchedSearchResult = null;
        mBarcodeString = (String)list.get(0);
        BarcodeSearchRequest barcodesearchrequest = new BarcodeSearchRequest();
        barcodesearchrequest.setBarcode((String)list.get(0));
        barcodesearchrequest.setBarcodeType(null);
        barcodesearchrequest.setMaxImageDimension(1);
        barcodesearchrequest.setSize(8);
        barcodesearchrequest.setIncludeAddOnItems(Boolean.TRUE);
        barcodesearchrequest.setClickStreamOrigin(mActivity.getClickStreamOrigin());
        CustomClientFields.setCustomHeaderFields("barcode_search_v32", false, CustomClientFields.getAmazonRequestId());
        mServiceCall = ServiceController.getMShopService().barcodeSearch(barcodesearchrequest, this);
        mMetricHelper.startFlowBarcodeSuccessObserver();
        mMetricHelper.startFlowBarcodeNoMatchesObserver();
        mMetricHelper.startFlowBarcodeFailObserver();
    }



/*
    static ServiceCall access$002(ViewItItemBarcodeSearchController viewititembarcodesearchcontroller, ServiceCall servicecall)
    {
        viewititembarcodesearchcontroller.mServiceCall = servicecall;
        return servicecall;
    }

*/






/*
    static SearchResult access$402(ViewItItemBarcodeSearchController viewititembarcodesearchcontroller, SearchResult searchresult)
    {
        viewititembarcodesearchcontroller.mOneMatchedSearchResult = searchresult;
        return searchresult;
    }

*/



}
