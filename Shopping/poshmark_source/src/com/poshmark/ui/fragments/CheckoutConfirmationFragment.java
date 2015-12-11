// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobileapptracker.MobileAppTracker;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplication;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.data_model.models.BrainTreeGatewayInfo;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.data_model.models.inner_models.LineItem;
import com.poshmark.data_model.models.inner_models.ShippingAmount;
import com.poshmark.http.BrainTreeHttpResponseHandler;
import com.poshmark.http.PMHttpError;
import com.poshmark.http.PMHttpResponse;
import com.poshmark.http.api.BrainTreeApi;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiError;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.AddressUtils;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.CreditCardUtils;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.view_holders.CheckoutConfirmationFormViewHolder;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.singular.sdk.Singular;
import org.apache.http.Header;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, CheckoutFormFragment

public class CheckoutConfirmationFragment extends PMFragment
{
    protected static final class FLOW_STATE extends Enum
    {

        private static final FLOW_STATE $VALUES[];
        public static final FLOW_STATE CHANGE_CREDIT_CARD_INFO;
        public static final FLOW_STATE CHANGE_SHIPPING_ADDRESS;
        public static final FLOW_STATE CHECKOUT;
        public static final FLOW_STATE GATHER_DETAILS;

        public static FLOW_STATE valueOf(String s)
        {
            return (FLOW_STATE)Enum.valueOf(com/poshmark/ui/fragments/CheckoutConfirmationFragment$FLOW_STATE, s);
        }

        public static FLOW_STATE[] values()
        {
            return (FLOW_STATE[])$VALUES.clone();
        }

        static 
        {
            CHECKOUT = new FLOW_STATE("CHECKOUT", 0);
            GATHER_DETAILS = new FLOW_STATE("GATHER_DETAILS", 1);
            CHANGE_CREDIT_CARD_INFO = new FLOW_STATE("CHANGE_CREDIT_CARD_INFO", 2);
            CHANGE_SHIPPING_ADDRESS = new FLOW_STATE("CHANGE_SHIPPING_ADDRESS", 3);
            $VALUES = (new FLOW_STATE[] {
                CHECKOUT, GATHER_DETAILS, CHANGE_CREDIT_CARD_INFO, CHANGE_SHIPPING_ADDRESS
            });
        }

        private FLOW_STATE(String s, int i)
        {
            super(s, i);
        }
    }


    int CURRENT_REDIRECT_URL_RETRY_COUNT;
    int CURRENT_SUBMIT_ORDER_RETRY_COUNT;
    int CURRENT_TR_DATA_RETRY_COUNT;
    int DEFAULT_REQUEST_CODE;
    int REDIRECT_URL_RETRY_COUNT;
    int SUBMIT_ORDER_RETRY_COUNT;
    int TR_DATA_RETRY_COUNT;
    boolean checkoutFormInitiated;
    protected FLOW_STATE current_state;
    protected CheckoutFlowHandler flowHandler;
    protected CheckoutConfirmationFormViewHolder viewHolder;

    public CheckoutConfirmationFragment()
    {
        DEFAULT_REQUEST_CODE = 1;
        TR_DATA_RETRY_COUNT = 3;
        CURRENT_TR_DATA_RETRY_COUNT = 0;
        REDIRECT_URL_RETRY_COUNT = 3;
        CURRENT_REDIRECT_URL_RETRY_COUNT = 0;
        SUBMIT_ORDER_RETRY_COUNT = 3;
        CURRENT_SUBMIT_ORDER_RETRY_COUNT = 0;
        checkoutFormInitiated = false;
    }

    private void fireOrderViaBrainTree_Step1()
    {
        final PMOrder order = flowHandler.getPoshmarkOrder();
        PMApi.getCreditCardGatewayData(order.getOrderId(), new PMApiResponseHandler() {

            final CheckoutConfirmationFragment this$0;
            final PMOrder val$order;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        if (pmapiresponse.hasError())
                        {
                            break label0;
                        }
                        pmapiresponse = (BrainTreeGatewayInfo)pmapiresponse.data;
                        CURRENT_TR_DATA_RETRY_COUNT = 0;
                        fireOrderViaBrainTree_Step2(pmapiresponse);
                    }
                    return;
                }
                if (CURRENT_TR_DATA_RETRY_COUNT <= TR_DATA_RETRY_COUNT)
                {
                    pmapiresponse = CheckoutConfirmationFragment.this;
                    pmapiresponse.CURRENT_TR_DATA_RETRY_COUNT = ((CheckoutConfirmationFragment) (pmapiresponse)).CURRENT_TR_DATA_RETRY_COUNT + 1;
                    PMApi.getCreditCardGatewayData(order.getOrderId(), this);
                    return;
                } else
                {
                    hideProgressDialog();
                    CURRENT_TR_DATA_RETRY_COUNT = 0;
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SUBMIT_CC, getString(0x7f0600f5), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
                    return;
                }
            }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                order = pmorder;
                super();
            }
        });
    }

    private void fireOrderViaBrainTree_Step2(final BrainTreeGatewayInfo info)
    {
        Object obj = flowHandler.getPoshmarkOrder();
        final HashMap map = new HashMap();
        map.put("form_action", info.form_action);
        map.put("tr_data", info.tr_data);
        map.put("transaction[billing][extended_address]", null);
        map.put("transaction[billing][locality]", ((PMOrder) (obj)).billing_address.getCity());
        map.put("transaction[billing][postal_code]", ((PMOrder) (obj)).billing_address.getZip());
        map.put("transaction[billing][region]", ((PMOrder) (obj)).billing_address.getState());
        map.put("transaction[billing][street_address]", ((PMOrder) (obj)).billing_address.getStreet());
        map.put("transaction[credit_card][cardholder_name]", ((PMOrder) (obj)).billing_address.getName());
        obj = flowHandler.getCreditCard();
        if (obj != null && ((CreditCard) (obj)).getNumber() != null)
        {
            map.put("transaction[credit_card][cvv]", ((CreditCard) (obj)).getSecurityCode());
            map.put("transaction[credit_card][expiration_month]", ((CreditCard) (obj)).getExpirationMonth());
            map.put("transaction[credit_card][expiration_year]", ((CreditCard) (obj)).getExpirationYear());
            map.put("transaction[credit_card][number]", ((CreditCard) (obj)).getNumber());
        } else
        {
            map.put("transaction[credit_card][cvv]", flowHandler.getCreditCard().getSecurityCode());
            map.put("transaction[credit_card][expiration_month]", flowHandler.getCreditCard().getExpirationMonth());
            map.put("transaction[credit_card][expiration_year]", flowHandler.getCreditCard().getExpirationYear());
            map.put("transaction[credit_card][number]", flowHandler.getCreditCard().getNumber());
        }
        BrainTreeApi.PostBrainTreeValidation(map, info.form_action, new BrainTreeHttpResponseHandler() {

            final CheckoutConfirmationFragment this$0;
            final BrainTreeGatewayInfo val$info;
            final Map val$map;

            public void handleResponse(PMHttpResponse pmhttpresponse)
            {
label0:
                {
                    if (isAdded())
                    {
                        if (!pmhttpresponse.hasError())
                        {
                            CURRENT_REDIRECT_URL_RETRY_COUNT = 0;
                            for (int i = 0; i < pmhttpresponse.headerArray.length; i++)
                            {
                                Object obj1 = pmhttpresponse.headerArray[i];
                                if (((Header) (obj1)).getName().equals("Location"))
                                {
                                    obj1 = ((Header) (obj1)).getValue();
                                    PMOrder pmorder = flowHandler.getPoshmarkOrder();
                                    HashMap hashmap = new HashMap();
                                    hashmap.put("braintree_return_url", obj1);
                                    hashmap.put("checkout_type", pmorder.getCheckoutType());
                                    hashmap.put("inventory_unit_ids", pmorder.getInventoryUnitIds());
                                    hashmap.put("order_id", pmorder.getOrderId());
                                    hashmap.put("user_id", PMApplicationSession.GetPMSession().getUserId());
                                    fireOrderViaServer(hashmap);
                                }
                            }

                        } else
                        {
                            if (CURRENT_REDIRECT_URL_RETRY_COUNT > REDIRECT_URL_RETRY_COUNT)
                            {
                                break label0;
                            }
                            pmhttpresponse = CheckoutConfirmationFragment.this;
                            pmhttpresponse.CURRENT_REDIRECT_URL_RETRY_COUNT = ((CheckoutConfirmationFragment) (pmhttpresponse)).CURRENT_REDIRECT_URL_RETRY_COUNT + 1;
                            BrainTreeApi.PostBrainTreeValidation(map, info.form_action, this);
                        }
                    }
                    return;
                }
                hideProgressDialog();
                CURRENT_REDIRECT_URL_RETRY_COUNT = 0;
                pmhttpresponse = new PMApiError(null, pmhttpresponse.httpError.exception, pmhttpresponse.httpCode, PMErrorType.UNKNOWN_ERROR);
                showError(new ActionErrorContext(pmhttpresponse, com.poshmark.ui.model.ActionErrorContext.ActionContext.SUBMIT_CC, getString(0x7f0600f5), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                map = map1;
                info = braintreegatewayinfo;
                super();
            }
        });
    }

    private void fireOrderViaServer(final Map map)
    {
        final PMOrder order = flowHandler.getPoshmarkOrder();
        String s = MetricsTrackingUtils.getTrackingJson(getActivity(), "pch");
        PMApi.postOrder(order.getOrderId(), map, s, new PMApiResponseHandler() {

            final CheckoutConfirmationFragment this$0;
            final Map val$map;
            final PMOrder val$order;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                if (isAdded())
                {
                    handlePostOrderResponse(pmapiresponse, order, map);
                }
            }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                order = pmorder;
                map = map1;
                super();
            }
        });
    }

    private void handleNewState()
    {
        if (checkoutFormInitiated) goto _L2; else goto _L1
_L1:
        checkoutFormInitiated = true;
        static class _cls9
        {

            static final int $SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE[];

            static 
            {
                $SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE = new int[FLOW_STATE.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CheckoutConfirmationFragment$FLOW_STATE[FLOW_STATE.GATHER_DETAILS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        _cls9..SwitchMap.com.poshmark.ui.fragments.CheckoutConfirmationFragment.FLOW_STATE[current_state.ordinal()];
        JVM INSTR tableswitch 1 1: default 40
    //                   1 41;
           goto _L2 _L3
_L2:
        return;
_L3:
        launchCheckoutForm(CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS);
        return;
    }

    private void handlePostOrderResponse(PMApiResponse pmapiresponse, final PMOrder order, final Map map)
    {
        if (!pmapiresponse.hasError())
        {
            if (order.isOrderCheckoutTypeBundle())
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "completed_order", null);
            } else
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "completed_order", null);
            }
            trackTransaction();
            hideProgressDialog();
            CURRENT_SUBMIT_ORDER_RETRY_COUNT = 0;
            pmapiresponse = order.getLineItems();
            for (int i = 0; i < pmapiresponse.size(); i++)
            {
                map = (LineItem)pmapiresponse.get(i);
                ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(map.getProductId());
            }

            pmapiresponse = order.getTotal();
            order = PMApplication.getHasOffersObject();
            if (order != null)
            {
                order.measureAction("order", pmapiresponse.doubleValue(), CurrencyUtils.getCurrencyCode());
            }
            FBDPAHelper.trackPurchase(flowHandler, pmapiresponse);
            showConfirmationMessage(getString(0x7f060093), getString(0x7f0601e7), getString(0x7f060097), null, new android.content.DialogInterface.OnClickListener() {

                final CheckoutConfirmationFragment this$0;

                public void onClick(DialogInterface dialoginterface, int j)
                {
                    if (j == -1)
                    {
                        done(-1);
                    }
                }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                super();
            }
            });
            return;
        }
        if (CURRENT_SUBMIT_ORDER_RETRY_COUNT <= SUBMIT_ORDER_RETRY_COUNT && pmapiresponse.apiError.isNetworkDomainError())
        {
            CURRENT_SUBMIT_ORDER_RETRY_COUNT = CURRENT_SUBMIT_ORDER_RETRY_COUNT + 1;
            pmapiresponse = MetricsTrackingUtils.getTrackingJson(getActivity(), "pch");
            PMApi.postOrder(order.getOrderId(), map, pmapiresponse, new PMApiResponseHandler() {

                final CheckoutConfirmationFragment this$0;
                final Map val$map;
                final PMOrder val$order;

                public void handleResponse(PMApiResponse pmapiresponse1)
                {
                    if (isAdded())
                    {
                        handlePostOrderResponse(pmapiresponse1, order, map);
                    }
                }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                order = pmorder;
                map = map1;
                super();
            }
            });
            return;
        } else
        {
            hideProgressDialog();
            CURRENT_SUBMIT_ORDER_RETRY_COUNT = 0;
            showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.SUBMIT_ORDER, getString(0x7f0600f5), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            return;
        }
    }

    private void processOrder()
    {
        showProgressDialogWithMessage(getString(0x7f06021e));
        PMOrder pmorder = flowHandler.getPoshmarkOrder();
        if (flowHandler.isPaymentInfoAvailable() && !flowHandler.isCreditCardUpdated())
        {
            HashMap hashmap = new HashMap();
            hashmap.put("braintree_token", pmorder.getBrainTreeToken());
            hashmap.put("checkout_type", pmorder.getCheckoutType());
            hashmap.put("inventory_unit_ids", pmorder.getInventoryUnitIds());
            hashmap.put("order_id", pmorder.getOrderId());
            hashmap.put("user_id", PMApplicationSession.GetPMSession().getUserId());
            fireOrderViaServer(hashmap);
            return;
        } else
        {
            fireOrderViaBrainTree_Step1();
            return;
        }
    }

    private void trackTransaction()
    {
        PMOrder pmorder = flowHandler.getPoshmarkOrder();
        Analytics.getInstance().trackTransaction(pmorder.getOrderId(), "Poshmark", Double.valueOf(pmorder.getTotal().doubleValue()), Double.valueOf(pmorder.getTotalTax().doubleValue()), Double.valueOf(pmorder.getTotalShippingAmount().doubleValue()), CurrencyUtils.getCurrencyCode());
        for (int i = 0; i < pmorder.getLineItems().size(); i++)
        {
            LineItem lineitem = (LineItem)pmorder.getLineItems().get(i);
            Analytics.getInstance().addItem(pmorder.getOrderId(), lineitem.getTitle(), lineitem.getId(), flowHandler.getListingDetails().getCategoryLabel(), Double.valueOf(lineitem.getPrice().doubleValue()), Long.valueOf(1L), CurrencyUtils.getCurrencyCode());
        }

        Singular.trackEvent("order", String.valueOf(pmorder.getTotal()));
    }

    public void done(int i)
    {
        Object obj = new Bundle();
        PMFragment pmfragment = (PMFragment)getTargetFragment();
        if (pmfragment != null)
        {
            ((Bundle) (obj)).putInt("RESULT_CODE", i);
            pmfragment.onFragmentResult(((Bundle) (obj)), getTargetRequestCode());
            obj = getActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return;
        }
        if (i == 0)
        {
            Object obj1 = flowHandler.getPoshmarkOrder();
            PMApi.releaseOrder(((PMOrder) (obj1)).getOrderListingId(), ((PMOrder) (obj1)).getOrderId(), null);
            obj1 = ((PMOrder) (obj1)).getOrderId();
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "removed_lineitem_from_order", ((String) (obj1)));
        }
        finishActivityWithResult(i, null);
    }

    public boolean handleBack()
    {
        Object obj = flowHandler.getPoshmarkOrder();
        PMApi.releaseOrder(((PMOrder) (obj)).getOrderListingId(), ((PMOrder) (obj)).getOrderId(), null);
        obj = ((PMOrder) (obj)).getOrderId();
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "removed_lineitem_from_order", ((String) (obj)));
        return false;
    }

    protected void launchCheckoutForm(CheckoutFormFragment.CHECKOUT_FORM_MODES checkout_form_modes)
    {
        Bundle bundle = new Bundle();
        bundle.putInt("CHECKOUT_FORM_MODE", checkout_form_modes.ordinal());
        ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/CheckoutFormFragment, flowHandler, this, current_state.ordinal());
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        updateListingSummary();
        setupHandlers();
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            current_state = FLOW_STATE.CHECKOUT;
            updateView();
        } else
        if (current_state == FLOW_STATE.GATHER_DETAILS)
        {
            done(0);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            flowHandler = (CheckoutFlowHandler)getFragmentDataOfType(com/poshmark/utils/CheckoutFlowHandler);
        } else
        {
            checkoutFormInitiated = bundle.getBoolean("NEXT_FORM_INITIATED");
            bundle = (ParcelUuid)bundle.getParcelable("FLOW_HANDLER_OBJECT");
            if (bundle != null)
            {
                flowHandler = (CheckoutFlowHandler)ObjectPickupDropOff.pickupDataObject(bundle.getUuid());
            }
        }
        if (flowHandler != null)
        {
            if (!flowHandler.isPaymentInfoAvailable())
            {
                if (!flowHandler.isCreditCardUpdated())
                {
                    current_state = FLOW_STATE.GATHER_DETAILS;
                }
            } else
            {
                current_state = FLOW_STATE.CHECKOUT;
            }
            handleNewState();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030022, viewgroup, false);
        setupView(layoutinflater);
        updateView();
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
        flowHandler.setCallingFragment(this);
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (flowHandler != null)
        {
            java.util.UUID uuid = ObjectPickupDropOff.getUniqueKey();
            ObjectPickupDropOff.dropOffDataObject(uuid, flowHandler);
            bundle.putParcelable("FLOW_HANDLER_OBJECT", new ParcelUuid(uuid));
        }
        bundle.putBoolean("NEXT_FORM_INITIATED", checkoutFormInitiated);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "checkout_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(getString(0x7f060078));
    }

    protected void setupHandlers()
    {
        viewHolder.changeCreditCardInfoButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutConfirmationFragment this$0;

            public void onClick(View view)
            {
                current_state = FLOW_STATE.CHANGE_CREDIT_CARD_INFO;
                launchCheckoutForm(CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD);
            }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                super();
            }
        });
        viewHolder.changeShippingInfoButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutConfirmationFragment this$0;

            public void onClick(View view)
            {
                current_state = FLOW_STATE.CHANGE_SHIPPING_ADDRESS;
                launchCheckoutForm(CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS);
            }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                super();
            }
        });
        viewHolder.submitOrderButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutConfirmationFragment this$0;

            public void onClick(View view)
            {
                if (flowHandler.getPoshmarkOrder().isOrderCheckoutTypeBundle())
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "submit_order", null);
                } else
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "submit_order", null);
                }
                processOrder();
            }

            
            {
                this$0 = CheckoutConfirmationFragment.this;
                super();
            }
        });
    }

    protected void setupView(View view)
    {
        viewHolder = new CheckoutConfirmationFormViewHolder();
        viewHolder.singleItemSummaryAndPricingContainer = (LinearLayout)view.findViewById(0x7f0c00a2);
        viewHolder.singleItemSummaryAndPricingContainer.setVisibility(0);
        viewHolder.itemSummaryLayout = (LinearLayout)view.findViewById(0x7f0c00a3);
        viewHolder.listingImageView = (PMListingImageView)view.findViewById(0x7f0c00b5);
        viewHolder.listingTitleView = (TextView)view.findViewById(0x7f0c00b7);
        viewHolder.listingSizeView = (TextView)view.findViewById(0x7f0c00b8);
        viewHolder.listingSellerView = (TextView)view.findViewById(0x7f0c00b9);
        viewHolder.priceLabelView = (TextView)view.findViewById(0x7f0c0224);
        viewHolder.priceValueView = (TextView)view.findViewById(0x7f0c0225);
        viewHolder.taxesLabelView = (TextView)view.findViewById(0x7f0c0226);
        viewHolder.taxesValueView = (TextView)view.findViewById(0x7f0c0227);
        viewHolder.shippingLabelView = (TextView)view.findViewById(0x7f0c0228);
        viewHolder.shippingValueView = (TextView)view.findViewById(0x7f0c0229);
        viewHolder.totalLabelView = (TextView)view.findViewById(0x7f0c022a);
        viewHolder.totalValueView = (TextView)view.findViewById(0x7f0c022b);
        viewHolder.poshCreditLayout = (LinearLayout)view.findViewById(0x7f0c022c);
        viewHolder.poshCreditLabelView = (TextView)view.findViewById(0x7f0c022d);
        viewHolder.poshCreditValueView = (TextView)view.findViewById(0x7f0c022e);
        viewHolder.redeemableBalanceLayout = (LinearLayout)view.findViewById(0x7f0c022f);
        viewHolder.redeemableBalanceLabelView = (TextView)view.findViewById(0x7f0c0230);
        viewHolder.redeemableBalanceValueView = (TextView)view.findViewById(0x7f0c0231);
        viewHolder.netChargeLayout = (LinearLayout)view.findViewById(0x7f0c0232);
        viewHolder.netChargeLabelView = (TextView)view.findViewById(0x7f0c0233);
        viewHolder.netChargeValueView = (TextView)view.findViewById(0x7f0c0234);
        viewHolder.paymentTextView = (TextView)view.findViewById(0x7f0c00a7);
        viewHolder.shipToTextView = (TextView)view.findViewById(0x7f0c00a9);
        viewHolder.changeCreditCardInfoButton = (Button)view.findViewById(0x7f0c00a8);
        viewHolder.changeShippingInfoButton = (Button)view.findViewById(0x7f0c00aa);
        viewHolder.submitOrderButton = (Button)view.findViewById(0x7f0c00ac);
    }

    protected void updateListingSummary()
    {
        Object obj = flowHandler.getPoshmarkOrder().getLineItems();
        if (((List) (obj)).size() == 0)
        {
            return;
        } else
        {
            obj = (LineItem)((List) (obj)).get(0);
            viewHolder.listingImageView.loadImage(((LineItem) (obj)).getPictureURL());
            viewHolder.listingTitleView.setText(((LineItem) (obj)).getTitle());
            viewHolder.listingSizeView.setText((new StringBuilder()).append(getString(0x7f060281)).append(((LineItem) (obj)).getSize()).toString());
            viewHolder.listingSellerView.setText((new StringBuilder()).append(getString(0x7f060249)).append(((LineItem) (obj)).getSellerName()).toString());
            return;
        }
    }

    protected void updateView()
    {
        if (current_state != FLOW_STATE.GATHER_DETAILS) goto _L2; else goto _L1
_L1:
        PMOrder pmorder;
        return;
_L2:
        if ((pmorder = flowHandler.getPoshmarkOrder()).getLineItems().size() <= 0 || pmorder.getShippingAmount().size() <= 0) goto _L1; else goto _L3
_L3:
        Object obj = CurrencyUtils.getCurrencySymbol();
        ShippingAmount shippingamount = (ShippingAmount)pmorder.getShippingAmount().get(0);
        viewHolder.priceValueView.setText((new StringBuilder()).append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(pmorder.getBasePrice())).toString());
        viewHolder.taxesValueView.setText((new StringBuilder()).append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(pmorder.getTotalTax())).toString());
        viewHolder.shippingValueView.setText((new StringBuilder()).append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(shippingamount.getAmount())).toString());
        viewHolder.totalValueView.setText((new StringBuilder()).append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(pmorder.getTotal())).toString());
        if (pmorder.getCreditsToApply().compareTo(BigDecimal.ZERO) > 0)
        {
            viewHolder.poshCreditLayout.setVisibility(0);
            viewHolder.poshCreditValueView.setText((new StringBuilder()).append("-").append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(pmorder.getCreditsToApply())).toString());
        } else
        {
            viewHolder.poshCreditLayout.setVisibility(8);
        }
        if (pmorder.getRedeemableToApply().compareTo(BigDecimal.ZERO) > 0)
        {
            viewHolder.redeemableBalanceLayout.setVisibility(0);
            viewHolder.redeemableBalanceValueView.setText((new StringBuilder()).append("-").append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(pmorder.getRedeemableToApply())).toString());
        } else
        {
            viewHolder.redeemableBalanceLayout.setVisibility(8);
        }
        viewHolder.netChargeValueView.setText((new StringBuilder()).append(((String) (obj))).append(CurrencyUtils.getPriceAsFormattedString(pmorder.getNetBalance())).toString());
        obj = flowHandler.getCreditCard();
        if (obj == null || ((CreditCard) (obj)).getNumber() == null) goto _L5; else goto _L4
_L4:
        obj = CreditCardUtils.getStringFromCreditCard(getActivity(), ((CreditCard) (obj)));
        viewHolder.changeCreditCardInfoButton.setText(((CharSequence) (obj)));
_L7:
        viewHolder.changeShippingInfoButton.setText(AddressUtils.addressStringWithoutPhone(pmorder.getShippingAddress()));
        return;
_L5:
        if (pmorder.getLastPaymentInfo() != null)
        {
            String s = CreditCardUtils.getStringFromPaymentInfo(getActivity(), pmorder.getLastPaymentInfo());
            viewHolder.changeCreditCardInfoButton.setText(s);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }




}
