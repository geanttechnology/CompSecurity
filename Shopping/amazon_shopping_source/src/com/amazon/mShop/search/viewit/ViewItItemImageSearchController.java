// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.res.Resources;
import com.amazon.mShop.control.ServiceController;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.customclientfields.CustomClientFields;
import com.amazon.mShop.customclientfields.RefmarkerClientField;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsRequest;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponse;
import com.amazon.rio.j2me.client.services.mShop.BasicProductsResponseListener;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItUtil, ViewItMetricHelper, ViewItScannedItemAnimationFrame, 
//            ViewItSearchResultWrapper

public class ViewItItemImageSearchController
    implements BasicProductsResponseListener
{

    private ViewItActivity mActivity;
    private ViewItMetricHelper mMetricHelper;
    private String mOriginalScannedOutput;
    private ServiceCall mServiceCall;
    private ViewItScannedItemAnimationFrame mViewItScannedItemAnimationFrame;

    public ViewItItemImageSearchController(ViewItActivity viewitactivity, ViewItScannedItemAnimationFrame viewitscanneditemanimationframe)
    {
        mOriginalScannedOutput = null;
        mActivity = viewitactivity;
        mMetricHelper = mActivity.getViewItMetricHelper();
        mViewItScannedItemAnimationFrame = viewitscanneditemanimationframe;
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

            final ViewItItemImageSearchController this$0;
            final ServiceCall val$sc;

            public void run()
            {
                if (mServiceCall == sc)
                {
                    mViewItScannedItemAnimationFrame.dismissAnimationWindow(true);
                    mServiceCall = null;
                    mMetricHelper.cancelFlowImageSuccessObserver();
                    mMetricHelper.cancelFlowImageFailObserver();
                }
            }

            
            {
                this$0 = ViewItItemImageSearchController.this;
                sc = servicecall;
                super();
            }
        });
    }

    public void completed(final BasicProductsResponse value, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItItemImageSearchController this$0;
            final ServiceCall val$sc;
            final BasicProductsResponse val$value;

            public void run()
            {
                if (mServiceCall == sc)
                {
                    mMetricHelper.cancelFlowImageFailObserver();
                    Object obj = value.getProducts();
                    if (!Util.isEmpty(((java.util.Collection) (obj))))
                    {
                        obj = new ViewItSearchResultWrapper(mOriginalScannedOutput, ((List) (obj)), null, ViewItSearchResultWrapper.getCurrentDate(), true);
                        mViewItScannedItemAnimationFrame.updateToShowItemContentInLoadingWindow(((ViewItSearchResultWrapper) (obj)));
                        mMetricHelper.finishFlowImageSuccessObserver();
                        RefMarkerObserver.logRefMarker("fl_image_success");
                    } else
                    {
                        mViewItScannedItemAnimationFrame.showServiceCallErrorInLoadingWindow(null, mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_no_matched_item_found), ViewItDialogHelper.DialogType.ERROR_NO_MATCHED_ITEM);
                        mMetricHelper.cancelFlowImageSuccessObserver();
                    }
                    mServiceCall = null;
                }
            }

            
            {
                this$0 = ViewItItemImageSearchController.this;
                sc = servicecall;
                value = basicproductsresponse;
                super();
            }
        });
    }

    public void error(final Exception e, final ServiceCall sc)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItItemImageSearchController this$0;
            final Exception val$e;
            final ServiceCall val$sc;

            public void run()
            {
                if (mServiceCall == sc)
                {
                    mViewItScannedItemAnimationFrame.showServiceCallErrorInLoadingWindow(null, UIUtils.getMessageForException(mActivity, e), ViewItDialogHelper.DialogType.ERROR_MSHOP_SERVER);
                    mServiceCall = null;
                    mMetricHelper.cancelFlowImageSuccessObserver();
                    mMetricHelper.finishFlowImageFailObserver();
                }
            }

            
            {
                this$0 = ViewItItemImageSearchController.this;
                sc = servicecall;
                e = exception;
                super();
            }
        });
    }

    public void startBasicProductsRequest(List list)
    {
        Object obj = mActivity.getClickStreamOrigin();
        mOriginalScannedOutput = (new StringBuilder()).append(ResultWrapper.ResultType.IMAGE.getTypeValue()).append(ViewItUtil.getSeriesAsinString(list)).toString();
        if (!Util.isEmpty(((String) (obj))))
        {
            RefmarkerClientField.logServiceMethodNameAndRefmarker("basic_products_v32", ClickStreamTag.createFullClickstreamTag(((String) (obj))));
        }
        obj = new BasicProductsRequest();
        ((BasicProductsRequest) (obj)).setAsins(list);
        CustomClientFields.setCustomHeaderFields("basic_products_v32", false, CustomClientFields.getAmazonRequestId());
        mServiceCall = ServiceController.getMShopService().basicProducts(((BasicProductsRequest) (obj)), this);
        mMetricHelper.startFlowImageSuccessObserver();
        mMetricHelper.startFlowImageFailObserver();
    }



/*
    static ServiceCall access$002(ViewItItemImageSearchController viewititemimagesearchcontroller, ServiceCall servicecall)
    {
        viewititemimagesearchcontroller.mServiceCall = servicecall;
        return servicecall;
    }

*/




}
