// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.history;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.home.BasicProductsSubscriber;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsRequest;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.List;
import java.util.Vector;

public class HistoryBrowser extends PagedListingBrowser
    implements BasicProductsResponseListener
{

    private int mAvailableItemCount;
    private BasicProductsSubscriber mBasicProductsSubscriber;
    private int mDeletedCount;
    private List mRecentlyViewedAsins;
    private BasicProductsRequest mRequest;
    private String mRequestId;

    public HistoryBrowser(int i, int j, List list, BasicProductsSubscriber basicproductssubscriber)
    {
        super(i, j);
        mRequest = new BasicProductsRequest();
        mRecentlyViewedAsins = list;
        mAvailableItemCount = list.size();
        mBasicProductsSubscriber = basicproductssubscriber;
    }

    protected int adjustRequestTriggerIndex(int i)
    {
        return mDeletedCount + i;
    }

    public void completed(final BasicProductsResponse response, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HistoryBrowser this$0;
            final BasicProductsResponse val$response;
            final ServiceCall val$sc;

            public void run()
            {
                objectsReceived(response.getProducts(), sc);
                mBasicProductsSubscriber.onBasicProductsReceived(response);
            }

            
            {
                this$0 = HistoryBrowser.this;
                response = basicproductsresponse;
                sc = servicecall;
                super();
            }
        });
    }

    public boolean deleteObject(int i)
    {
        if (listingObjects.remove(i) != null)
        {
            mDeletedCount = mDeletedCount + 1;
            mAvailableItemCount = mAvailableItemCount - 1;
            return true;
        } else
        {
            return false;
        }
    }

    public void error(final Exception exp, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final HistoryBrowser this$0;
            final Exception val$exp;
            final ServiceCall val$sc;

            public void run()
            {
                cancelled(sc);
                mBasicProductsSubscriber.onError(exp, sc);
            }

            
            {
                this$0 = HistoryBrowser.this;
                sc = servicecall;
                exp = exception;
                super();
            }
        });
    }

    public int getAvailableItemCount()
    {
        return mAvailableItemCount;
    }

    public boolean startFirstPageRequest(List list, List list1)
    {
        mRecentlyViewedAsins = list;
        mAvailableItemCount = list.size();
        return super.startFirstPageRequest(list.size(), list1);
    }

    protected ServiceCall startPageRequest(int i)
    {
        int l = i * pageSize;
        int k = l + pageSize;
        int j = k;
        if (k > mRecentlyViewedAsins.size())
        {
            j = mRecentlyViewedAsins.size();
        }
        mRequest.setAsins(new Vector(mRecentlyViewedAsins.subList(l, j)));
        if (i == 0)
        {
            mRequestId = CustomClientFields.getAmazonRequestId();
            CustomClientFields.setCustomHeaderFields("basic_products_v32", false, mRequestId);
        } else
        {
            CustomClientFields.setCustomHeaderFields("basic_products_v32", true, mRequestId);
        }
        return ServiceController.getMShopService().basicProducts(mRequest, this);
    }


}
