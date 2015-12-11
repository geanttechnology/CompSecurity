// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.BundleCheckoutConformationFragment;
import com.poshmark.ui.fragments.CheckoutConfirmationFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.utils:
//            CheckoutFlowHandler, MetricsTrackingUtils

public class BundleFlowHandler extends CheckoutFlowHandler
{

    public static int BUY_BUNDLE_REQUEST = 123;
    PMBundle bundle;
    int bundleItemsCount;

    public BundleFlowHandler()
    {
    }

    public BundleFlowHandler(PMFragment pmfragment)
    {
        super(pmfragment);
    }

    private void handleAddProductResponse(PMApiResponse pmapiresponse)
    {
        callingFragment.hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            poshmarkOrder = (PMOrder)pmapiresponse.data;
            if (bundleItemsCount > 1)
            {
                showBundleConfirmationForm();
            } else
            {
                showSingleItemConfirmationForm();
            }
            Analytics.getInstance().trackEvent(null, "bundle", "added_bundle_to_order", poshmarkOrder.getOrderId());
            return;
        } else
        {
            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.ADD_PRODUCT_TO_ORDER, callingFragment.getString(0x7f0600d5), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            return;
        }
    }

    protected void addProductWithId(List list)
    {
        if (list == null || list.size() == 0 || callingFragment == null)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        String s = new String();
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = (new StringBuilder()).append(s).append((String)iterator.next()).toString();
            s = s1;
            if (iterator.hasNext())
            {
                s = (new StringBuilder()).append(s1).append(",").toString();
            }
        } while (true);
        hashmap.put("checkout_type", "bbdl");
        if (list.size() > 1)
        {
            hashmap.put("product_ids", s);
            list = MetricsTrackingUtils.getTrackingJson(callingFragment.getActivity(), "bnd_crt");
        } else
        {
            hashmap.put("product_ids", s);
            list = MetricsTrackingUtils.getTrackingJson(callingFragment.getActivity(), "cart");
        }
        hashmap.put("order_id", "self");
        hashmap.put("user_id", PMApplicationSession.GetPMSession().getUserId());
        callingFragment.showProgressDialogWithMessage(callingFragment.getString(0x7f0601e8));
        PMApi.addProductToOrder(hashmap, list, new PMApiResponseHandler() {

            final BundleFlowHandler this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (callingFragment.isAdded())
                {
                    handleAddProductResponse(pmapiresponse);
                }
            }

            
            {
                this$0 = BundleFlowHandler.this;
                super();
            }
        });
    }

    public void beginCheckoutForBundle(PMBundle pmbundle)
    {
        bundle = pmbundle;
        bundleItemsCount = pmbundle.getList().size();
        listing = (ListingSummary)pmbundle.getList().get(0);
        addProductWithId(pmbundle.getListOfPostsInBundle());
    }

    public ListingSummary getListingDetails()
    {
        return (ListingSummary)bundle.getList().get(0);
    }

    protected void showBundleConfirmationForm()
    {
        Bundle bundle1 = new Bundle();
        bundle1.putInt("CHECKOUT_FORM_MODE", com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
        PMActivity pmactivity = (PMActivity)callingFragment.getActivity();
        if (pmactivity != null)
        {
            pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/BundleCheckoutConformationFragment, this, callingFragment, BUY_BUNDLE_REQUEST);
        }
    }

    protected void showSingleItemConfirmationForm()
    {
        Bundle bundle1 = new Bundle();
        bundle1.putInt("CHECKOUT_FORM_MODE", com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
        PMActivity pmactivity = (PMActivity)callingFragment.getActivity();
        if (pmactivity != null)
        {
            pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/CheckoutConfirmationFragment, this, callingFragment, BUY_BUNDLE_REQUEST);
        }
    }


}
