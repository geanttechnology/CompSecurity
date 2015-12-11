// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;

import com.amazon.mShop.control.BaseController;
import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BarcodeBadMatch;
import com.amazon.rio.j2me.client.services.mShop.BarcodeBadMatchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.BarcodeSearchRequest;
import com.amazon.rio.j2me.client.services.mShop.BarcodeSearchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.SearchResultsCounts;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// Referenced classes of package com.amazon.mShop.control.barcodeSearch:
//            BarcodeSearchSubscriber

public class BarcodeSearchController extends BaseController
    implements BarcodeBadMatchResponseListener, BarcodeSearchResponseListener
{

    private String mBarcodeFormat;
    private int mBarcodeSearchStatus;
    private String mBarcodeString;
    private byte mMatchedItemThumbnail[];
    private boolean mMatchedItemsReturned;
    private QueryDescriptor mQueryDescriptor;
    private String mResultsTitle;
    private SearchResult mSearchResult;
    private final BarcodeSearchSubscriber mSubscriber;

    public BarcodeSearchController(BarcodeSearchSubscriber barcodesearchsubscriber)
    {
        mBarcodeSearchStatus = 0;
        mSearchResult = null;
        mMatchedItemsReturned = false;
        mSubscriber = barcodesearchsubscriber;
    }

    public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
    {
    }

    public void completed(final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                mBarcodeSearchStatus = 2;
                if (isRunningServiceCall(sc))
                {
                    serviceCallCompleted();
                    mSubscriber.onCompleted();
                }
            }

            
            {
                this$0 = BarcodeSearchController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public void completed(Null null1, ServiceCall servicecall)
    {
        if (isRunningServiceCall(servicecall))
        {
            serviceCallCompleted();
        }
    }

    public int getBarcodeSearchResultType()
    {
        if (mMatchedItemsReturned)
        {
            return 2;
        }
        return mSearchResult == null ? 0 : 1;
    }

    public int getBarcodeSearchStatus()
    {
        return mBarcodeSearchStatus;
    }

    public SearchResult getMatchItemSearchResult()
    {
        return mSearchResult;
    }

    public String getResultsTitle()
    {
        return mResultsTitle;
    }

    protected volatile GenericSubscriber getSubscriber()
    {
        return getSubscriber();
    }

    protected BarcodeSearchSubscriber getSubscriber()
    {
        return mSubscriber;
    }

    public boolean hasMoreResults()
    {
        return mQueryDescriptor != null;
    }

    public void receivedCounts(SearchResultsCounts searchresultscounts, ServiceCall servicecall)
    {
    }

    public void receivedImage(final byte value[], final int index, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final int val$index;
            final byte val$value[];

            public void run()
            {
                mSubscriber.onImageReceived(value, index);
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = abyte0;
                index = i;
                super();
            }
        });
    }

    public void receivedMatchedItem(final SearchResult value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final SearchResult val$value;

            public void run()
            {
                mSearchResult = value;
                mSubscriber.onMatchedItemReceived(value);
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = searchresult;
                super();
            }
        });
    }

    public void receivedMatchedItemThumbnail(final byte value[], ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final byte val$value[];

            public void run()
            {
                mMatchedItemThumbnail = value;
                mSubscriber.onMatchedItemThumbnailReceived(value);
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = abyte0;
                super();
            }
        });
    }

    public void receivedMatchedItemsReturned(final Boolean value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final Boolean val$value;

            public void run()
            {
                mMatchedItemsReturned = value.booleanValue();
                mSubscriber.onMatchedItemsReturnedReceived(value.booleanValue());
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = boolean1;
                super();
            }
        });
    }

    public void receivedQueryDescriptor(final QueryDescriptor value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final QueryDescriptor val$value;

            public void run()
            {
                mQueryDescriptor = value;
                mSubscriber.onQueryDescriptorReceived(value);
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = querydescriptor;
                super();
            }
        });
    }

    public void receivedResultsTitle(final String value, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final String val$value;

            public void run()
            {
                mResultsTitle = value;
                mSubscriber.onResultsTitleReceived(value);
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = s;
                super();
            }
        });
    }

    public void receivedSearchResult(final SearchResult value, final int index, ServiceCall servicecall)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final BarcodeSearchController this$0;
            final int val$index;
            final SearchResult val$value;

            public void run()
            {
                mSubscriber.onSearchResultReceived(value, index);
            }

            
            {
                this$0 = BarcodeSearchController.this;
                value = searchresult;
                index = i;
                super();
            }
        });
    }

    public void reportMismatch()
    {
        BarcodeBadMatch barcodebadmatch;
        ArrayList arraylist;
        barcodebadmatch = new BarcodeBadMatch();
        barcodebadmatch.setBarcode(mBarcodeString);
        barcodebadmatch.setBarcodeType(mBarcodeFormat);
        arraylist = new ArrayList();
        if (mSearchResult == null) goto _L2; else goto _L1
_L1:
        arraylist.add(mSearchResult.getBasicProduct().getAsin());
_L4:
        if (arraylist.size() > 0)
        {
            barcodebadmatch.setAsins(new Vector(arraylist));
        }
        if (!hasServiceCallRunning())
        {
            serviceCallStarted(ServiceController.getMShopService().barcodeBadMatch(barcodebadmatch, this), null);
        }
        return;
_L2:
        if (mQueryDescriptor != null)
        {
            arraylist.addAll(mQueryDescriptor.getQueryData());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setBarcodeSearchStatus(int i)
    {
        mBarcodeSearchStatus = i;
    }

    public void startBarcodeSearch(String s, String s1, int i)
    {
        mBarcodeString = s;
        mBarcodeFormat = s1;
        BarcodeSearchRequest barcodesearchrequest = new BarcodeSearchRequest();
        barcodesearchrequest.setBarcode(s);
        barcodesearchrequest.setBarcodeType(s1);
        barcodesearchrequest.setMaxImageDimension(i);
        barcodesearchrequest.setIncludeAddOnItems(Boolean.TRUE);
        mBarcodeSearchStatus = 1;
        serviceCallStarted(ServiceController.getMShopService().barcodeSearch(barcodesearchrequest, this), null);
    }


/*
    static int access$002(BarcodeSearchController barcodesearchcontroller, int i)
    {
        barcodesearchcontroller.mBarcodeSearchStatus = i;
        return i;
    }

*/





/*
    static SearchResult access$402(BarcodeSearchController barcodesearchcontroller, SearchResult searchresult)
    {
        barcodesearchcontroller.mSearchResult = searchresult;
        return searchresult;
    }

*/


/*
    static byte[] access$502(BarcodeSearchController barcodesearchcontroller, byte abyte0[])
    {
        barcodesearchcontroller.mMatchedItemThumbnail = abyte0;
        return abyte0;
    }

*/


/*
    static boolean access$602(BarcodeSearchController barcodesearchcontroller, boolean flag)
    {
        barcodesearchcontroller.mMatchedItemsReturned = flag;
        return flag;
    }

*/


/*
    static QueryDescriptor access$702(BarcodeSearchController barcodesearchcontroller, QueryDescriptor querydescriptor)
    {
        barcodesearchcontroller.mQueryDescriptor = querydescriptor;
        return querydescriptor;
    }

*/


/*
    static String access$802(BarcodeSearchController barcodesearchcontroller, String s)
    {
        barcodesearchcontroller.mResultsTitle = s;
        return s;
    }

*/
}
