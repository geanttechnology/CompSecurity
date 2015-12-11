// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.os.Bundle;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMOffer;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.CheckoutConfirmationFragment;
import com.poshmark.ui.fragments.CheckoutFormFragment;
import com.poshmark.ui.fragments.PMFragment;
import com.poshmark.ui.model.ActionErrorContext;
import java.util.HashMap;

// Referenced classes of package com.poshmark.utils:
//            MetricsTrackingUtils

public class CheckoutFlowHandler
{
    public static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE BUY_MODE;
        public static final MODE OFFER_MODE;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/utils/CheckoutFlowHandler$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            BUY_MODE = new MODE("BUY_MODE", 0);
            OFFER_MODE = new MODE("OFFER_MODE", 1);
            $VALUES = (new MODE[] {
                BUY_MODE, OFFER_MODE
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    protected PMFragment callingFragment;
    protected CreditCard creditCard;
    protected boolean creditCardUpdated;
    protected ListingSummary listing;
    protected PMOrder poshmarkOrder;

    public CheckoutFlowHandler()
    {
        poshmarkOrder = new PMOrder();
        creditCard = new CreditCard();
        creditCardUpdated = false;
    }

    public CheckoutFlowHandler(PMFragment pmfragment)
    {
        poshmarkOrder = new PMOrder();
        creditCard = new CreditCard();
        creditCardUpdated = false;
        callingFragment = pmfragment;
    }

    private void handleAddProductResponse(PMApiResponse pmapiresponse)
    {
        callingFragment.hideProgressDialog();
        if (!pmapiresponse.hasError())
        {
            poshmarkOrder = (PMOrder)pmapiresponse.data;
            showSingleItemConfirmationForm();
            Analytics.getInstance().trackEvent(null, "listing", "added_lineitem_to_order", poshmarkOrder.getOrderId());
            return;
        } else
        {
            callingFragment.showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.ADD_PRODUCT_TO_ORDER, callingFragment.getString(0x7f0600d5), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            return;
        }
    }

    private boolean isAddressInfoAvailable()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (poshmarkOrder != null)
        {
            flag = flag1;
            if (poshmarkOrder.shipping_address.isDataAvailable())
            {
                flag = flag1;
                if (poshmarkOrder.billing_address.isDataAvailable())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    private void showFormToAddPaymentAndShippingInfo()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("CHECKOUT_FORM_MODE", com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
        ((PMActivity)callingFragment.getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CheckoutFormFragment, this);
    }

    protected void addProductWithId(String s)
    {
        if (s == null || callingFragment == null)
        {
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("checkout_type", "bnow");
            hashmap.put("product_ids", s);
            hashmap.put("order_id", "self");
            hashmap.put("user_id", PMApplicationSession.GetPMSession().getUserId());
            callingFragment.showProgressDialogWithMessage(callingFragment.getString(0x7f0601e8));
            PMApi.addProductToOrder(hashmap, MetricsTrackingUtils.getTrackingJson(callingFragment.getActivity(), "cart"), new PMApiResponseHandler() {

                final CheckoutFlowHandler this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (callingFragment.isAdded())
                    {
                        handleAddProductResponse(pmapiresponse);
                    }
                }

            
            {
                this$0 = CheckoutFlowHandler.this;
                super();
            }
            });
            return;
        }
    }

    public boolean addressesEqual()
    {
        return poshmarkOrder.shipping_address.isSameAs(poshmarkOrder.billing_address);
    }

    public void beginCheckoutForListing(ListingSummary listingsummary)
    {
        if (listingsummary == null)
        {
            return;
        } else
        {
            listing = listingsummary;
            addProductWithId(listing.getIdAsString());
            return;
        }
    }

    public CreditCard getCreditCard()
    {
        return creditCard;
    }

    public String getEncryptionKey()
    {
        return null;
    }

    public ListingSummary getListingDetails()
    {
        return listing;
    }

    public PMOffer getPoshmarkOffer()
    {
        if (poshmarkOrder instanceof PMOffer)
        {
            return (PMOffer)poshmarkOrder;
        } else
        {
            return null;
        }
    }

    public PMOrder getPoshmarkOrder()
    {
        return poshmarkOrder;
    }

    public boolean isCreditCardUpdated()
    {
        return creditCardUpdated;
    }

    public boolean isPaymentInfoAvailable()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (poshmarkOrder != null)
        {
            flag = flag1;
            if (poshmarkOrder.isCreditCardInfoValid())
            {
                flag = true;
            }
        }
        return flag;
    }

    public void setCallingFragment(PMFragment pmfragment)
    {
        callingFragment = pmfragment;
    }

    public void setCreditCardUpdated(boolean flag)
    {
        creditCardUpdated = flag;
    }

    protected void showSingleItemConfirmationForm()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("CHECKOUT_FORM_MODE", com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal());
        PMActivity pmactivity = (PMActivity)callingFragment.getActivity();
        if (pmactivity != null)
        {
            pmactivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/CheckoutConfirmationFragment, this);
        }
    }

    public void updatePoshmarkOrder(PMOrder pmorder)
    {
        poshmarkOrder = pmorder;
    }

}
