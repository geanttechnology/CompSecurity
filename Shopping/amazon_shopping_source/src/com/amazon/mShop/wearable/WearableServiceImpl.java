// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.search.AdvSearchResultsBrowser;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.AddListIdeasRequest;
import com.amazon.rio.j2me.client.services.mShop.AddListIdeasResponse;
import com.amazon.rio.j2me.client.services.mShop.AddListIdeasResponseListener;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsRequest;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponse;
import com.amazon.rio.j2me.client.services.mShop.AddListItemsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.BuyAsinRequest;
import com.amazon.rio.j2me.client.services.mShop.BuyAsinResponseListener;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.PurchaseOrderResponse;
import com.amazon.rio.j2me.client.services.mShop.PurchaseStatus;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.RequestListIdea;
import com.amazon.rio.j2me.client.services.mShop.RequestListItem;
import com.amazon.rio.j2me.client.services.mShop.SearchRequest;
import com.amazon.rio.j2me.client.services.mShop.SearchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.SearchResultsCounts;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

// Referenced classes of package com.amazon.mShop.wearable:
//            WearableService, WearableMetricHelper, ResultListener, RioSearchResultTransformer, 
//            SearchResultListener, WearableDeviceType

public class WearableServiceImpl
    implements WearableService
{

    private static final String TAG = com/amazon/mShop/wearable/WearableServiceImpl.getSimpleName();
    private final Context mContext;
    private final WearableDeviceType mDeviceType;
    private final WearableMetricHelper mWearableMetricObserver;

    public WearableServiceImpl(Context context, WearableDeviceType wearabledevicetype)
    {
        mWearableMetricObserver = WearableMetricHelper.getInstance(context);
        mContext = context;
        mDeviceType = wearabledevicetype;
    }

    private String handleErrorMessage(String s, Throwable throwable)
    {
        throwable = ExceptionUtils.getStackTrace(throwable);
        s = (new StringBuilder()).append("Exception on ").append(s).append(" action:").toString();
        if (throwable.contains("User not authenticated"))
        {
            return (new StringBuilder()).append(s).append("User not authenticated").toString();
        }
        if (throwable.contains("Device is not connected to network"))
        {
            return (new StringBuilder()).append(s).append("Device is not connected to network").toString();
        } else
        {
            return (new StringBuilder()).append(s).append(throwable.substring(0, 50)).toString();
        }
    }

    public void addProductToWishList(String s, final ResultListener listener)
    {
        try
        {
            Object obj = new RequestListItem();
            ((RequestListItem) (obj)).setListItemId("");
            ((RequestListItem) (obj)).setListId("");
            ((RequestListItem) (obj)).setAsin(s);
            ((RequestListItem) (obj)).setListType("wishlist");
            s = new AddListItemsRequest();
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(obj);
            s.setItems(arraylist);
            obj = new AddListItemsResponseListener() {

                final WearableServiceImpl this$0;
                final ResultListener val$listener;

                public void cancelled(ServiceCall servicecall)
                {
                }

                public void completed(AddListItemsResponse addlistitemsresponse, ServiceCall servicecall)
                {
                    listener.onSuccess();
                }

                public void error(Exception exception, ServiceCall servicecall)
                {
                    Log.e(WearableServiceImpl.TAG, "Add to wishlist encountered Exception", exception);
                    listener.onError(handleErrorMessage("add to wishlist", exception), exception);
                }

            
            {
                this$0 = WearableServiceImpl.this;
                listener = resultlistener;
                super();
            }
            };
            ServiceController.getMShopService().addListItems(s, ((AddListItemsResponseListener) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            listener.onError("Unable to add product to wishlist", s);
        }
    }

    public void addTextToWishlist(String s, final ResultListener listener)
    {
        try
        {
            Object obj = new RequestListIdea();
            ((RequestListIdea) (obj)).setIdea(s);
            ((RequestListIdea) (obj)).setListId("");
            ((RequestListIdea) (obj)).setListType("wishlist");
            ((RequestListIdea) (obj)).setVendorId("A2D1WRIX2KYSZT");
            s = new AddListIdeasRequest();
            ArrayList arraylist = new ArrayList(1);
            arraylist.add(obj);
            s.setIdeas(arraylist);
            obj = new AddListIdeasResponseListener() {

                final WearableServiceImpl this$0;
                final ResultListener val$listener;

                public void cancelled(ServiceCall servicecall)
                {
                }

                public void completed(AddListIdeasResponse addlistideasresponse, ServiceCall servicecall)
                {
                    listener.onSuccess();
                }

                public void error(Exception exception, ServiceCall servicecall)
                {
                    Log.e(WearableServiceImpl.TAG, "Add to wishlist encountered Exception", exception);
                    listener.onError(handleErrorMessage("add text to wishlist", exception), exception);
                }

            
            {
                this$0 = WearableServiceImpl.this;
                listener = resultlistener;
                super();
            }
            };
            ServiceController.getMShopService().addListIdeas(s, ((AddListIdeasResponseListener) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            listener.onError("Unable to add idea to wishlist", s);
        }
    }

    public void addTimer(String s, String s1, double d)
    {
        mWearableMetricObserver.addLatencyMetric(s, s1, d);
    }

    public void emitClickStream(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, int i)
    {
        mWearableMetricObserver.emitClickStream(s, s1, s2, s3, s4, s5, s6, s7, i);
    }

    public void incrementMetricCounter(String s, String s1, int i)
    {
        mWearableMetricObserver.incrementPMETCounter(s, s1, i);
    }

    public void logRefMarker(String s)
    {
        mWearableMetricObserver.logRefMarker(s);
    }

    public void openLocaleSettings(ResultListener resultlistener)
    {
        try
        {
            ActivityUtils.startLocaleSwitchActivity(mContext, new int[] {
                0x10000000
            });
            resultlistener.onSuccess();
            return;
        }
        catch (Exception exception)
        {
            resultlistener.onError(exception.getMessage(), exception);
        }
    }

    public void openLoginUi(ResultListener resultlistener)
    {
        try
        {
            if (!User.isLoggedIn())
            {
                SSOUtil.getCurrentIdentityType().handleSSOLogin(mContext, "wearable_device", 0x10000000);
            }
            resultlistener.onSuccess();
            return;
        }
        catch (Exception exception)
        {
            resultlistener.onError(exception.getMessage(), exception);
        }
    }

    public void openMShopHome(String s)
    {
        ActivityUtils.startHomeActivity(mContext, Maps.of("ref", s), 0x10000000, false);
    }

    public void openOneClickSettings(ResultListener resultlistener)
    {
        try
        {
            ActivityUtils.startOneClickSettingActivity(mContext, 0x10000000);
            resultlistener.onSuccess();
            return;
        }
        catch (Exception exception)
        {
            resultlistener.onError(exception.getMessage(), exception);
        }
    }

    public void openProductPage(String s, String s1, String s2, ClickStreamTag clickstreamtag, ResultListener resultlistener)
    {
        try
        {
            s = new ProductController(s, clickstreamtag);
            s.setMerchantId(s2);
            s.setOfferId(s1);
            ActivityUtils.launchDetailsPage(mContext, s, new int[] {
                0x10000000
            });
            resultlistener.onSuccess();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            resultlistener.onError(s.getMessage(), s);
        }
    }

    public void openTextSearchResults(String s, ResultListener resultlistener)
    {
        if (StringUtils.isEmpty(s))
        {
            resultlistener.onError("Search query is null", new Throwable("Search query null"));
            return;
        }
        try
        {
            AdvSearchResultsBrowser.validateQuery(s);
            if (!Util.isEmpty(s))
            {
                s = (new SearchIntentBuilder(mContext)).extraFlag(0x10020000).query(s).build();
                mContext.startActivity(s);
            }
            resultlistener.onSuccess();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(TAG, "Openg search results exception", s);
        }
        resultlistener.onError("Exception while opening text search results page ", s);
        return;
    }

    public void purchaseProduct(String s, String s1, ClickStreamTag clickstreamtag, final ResultListener listener)
    {
        try
        {
            BuyAsinRequest buyasinrequest = new BuyAsinRequest();
            buyasinrequest.setAsin(s);
            buyasinrequest.setOfferId(s1);
            buyasinrequest.setClickStreamOrigin(clickstreamtag.toString());
            buyasinrequest.setOneClickShippingSpeed("default");
            s = new BuyAsinResponseListener() {

                final WearableServiceImpl this$0;
                final ResultListener val$listener;

                public void cancelled(ServiceCall servicecall)
                {
                    listener.onError("Cancelled while trying to buy", new Throwable("Call cancelled"));
                }

                public void completed(PurchaseOrderResponse purchaseorderresponse, ServiceCall servicecall)
                {
                    if (purchaseorderresponse.getConfirmedOrderId() != null && purchaseorderresponse.getConfirmedOrderId().size() > 0)
                    {
                        listener.onSuccess();
                        return;
                    }
                    if (purchaseorderresponse.getPurchaseStatus() != null)
                    {
                        listener.onError(purchaseorderresponse.getPurchaseStatus().getNextStep(), new Throwable("BuyNow order not completed"));
                        return;
                    } else
                    {
                        listener.onError("Unknown error", new Throwable("BuyNow order not completed"));
                        return;
                    }
                }

                public void error(Exception exception, ServiceCall servicecall)
                {
                    Log.e(WearableServiceImpl.TAG, "Error while trying to buy ", exception);
                    listener.onError(handleErrorMessage("buyNow", exception), exception);
                }

            
            {
                this$0 = WearableServiceImpl.this;
                listener = resultlistener;
                super();
            }
            };
            ServiceController.getMShopService().buyAsin(buyasinrequest, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            listener.onError("Unable to add product to wishlist", s);
        }
    }

    public void searchByText(String s, final SearchResultListener listener)
    {
        try
        {
            final RioSearchResultTransformer resultTransformer = new RioSearchResultTransformer();
            SearchRequest searchrequest = new SearchRequest();
            searchrequest.setSize(30);
            searchrequest.setPage(1);
            searchrequest.setReturnRefinements(Boolean.FALSE);
            searchrequest.setClickStreamOrigin(ClickStreamTag.ORIGIN_WEARABLES_WEAR.getTag());
            searchrequest.setQuery(s);
            searchrequest.setIncludeAddOnItems(Boolean.TRUE);
            ServiceController.getMShopService().search(searchrequest, new SearchResponseListener() {

                final WearableServiceImpl this$0;
                final SearchResultListener val$listener;
                final RioSearchResultTransformer val$resultTransformer;

                public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
                {
                }

                public void cancelled(ServiceCall servicecall)
                {
                    listener.onError("Failed query", null);
                }

                public void completed(ServiceCall servicecall)
                {
                    listener.onSuccess();
                }

                public void error(Exception exception, ServiceCall servicecall)
                {
                    Log.e(WearableServiceImpl.TAG, "Failed to search", exception);
                    listener.onError("Failed to query", exception);
                }

                public void receivedCategoryResult(CategoryResult categoryresult, int i, ServiceCall servicecall)
                {
                }

                public void receivedCounts(SearchResultsCounts searchresultscounts, ServiceCall servicecall)
                {
                }

                public void receivedImage(byte abyte0[], int i, ServiceCall servicecall)
                {
                }

                public void receivedQueryDescriptor(QueryDescriptor querydescriptor, ServiceCall servicecall)
                {
                }

                public void receivedSearchResult(SearchResult searchresult, int i, ServiceCall servicecall)
                {
                    searchresult = resultTransformer.apply(searchresult);
                    if (searchresult != null)
                    {
                        listener.onFoundProduct(searchresult);
                    }
                }

            
            {
                this$0 = WearableServiceImpl.this;
                listener = searchresultlistener;
                resultTransformer = riosearchresulttransformer;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            listener.onError("Failed query", s);
        }
    }



}
