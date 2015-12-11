// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.braintreegateway.encryption.Braintree;
import com.braintreegateway.encryption.BraintreeEncryptionException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.EncryptedCreditCardInfo;
import com.poshmark.data_model.models.PMOffer;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.data_model.models.inner_models.PaymentInfo;
import com.poshmark.data_model.models.inner_models.ShippingAmount;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.ListingNotificationManager;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.AddressUtils;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.CreditCardUtils;
import com.poshmark.utils.CurrencyUtils;
import com.poshmark.utils.MetricsTrackingUtils;
import com.poshmark.utils.view_holders.CheckoutConfirmationFormViewHolder;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            CheckoutConfirmationFragment

public class CheckoutConfirmationFragment_Offers extends CheckoutConfirmationFragment
{
    static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE EXISTING_OFFER;
        public static final MODE NEW_OFFER;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/ui/fragments/CheckoutConfirmationFragment_Offers$MODE, s);
        }

        public static MODE[] values()
        {
            return (MODE[])$VALUES.clone();
        }

        static 
        {
            EXISTING_OFFER = new MODE("EXISTING_OFFER", 0);
            NEW_OFFER = new MODE("NEW_OFFER", 1);
            $VALUES = (new MODE[] {
                EXISTING_OFFER, NEW_OFFER
            });
        }

        private MODE(String s, int i)
        {
            super(s, i);
        }
    }


    View derivedClassView;
    boolean fixedPaymentFailed;
    MODE mode;

    public CheckoutConfirmationFragment_Offers()
    {
        derivedClassView = null;
        fixedPaymentFailed = false;
    }

    private String encryptFormField(String s)
    {
        Braintree braintree = new Braintree(flowHandler.getEncryptionKey());
        try
        {
            s = braintree.encrypt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private void fireOffer(Map map, String s)
    {
        final PMOrder order = flowHandler.getPoshmarkOrder();
        showProgressDialogWithMessage("Processing...");
        PMApi.postOffer(order.getOrderId(), map, s, new PMApiResponseHandler() {

            final CheckoutConfirmationFragment_Offers this$0;
            final PMOrder val$order;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
label0:
                {
label1:
                    {
                        if (isAdded())
                        {
                            hideProgressDialog();
                            if (pmapiresponse.hasError())
                            {
                                break label0;
                            }
                            if (mode != MODE.EXISTING_OFFER)
                            {
                                break label1;
                            }
                            showAutoHideProgressDialogWithMessage(getString(0x7f0601dd), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                                final _cls4 this$1;

                                public void dialogDismissed()
                                {
                                    ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(order.getOrderListingId());
                                    done(-1);
                                }

            
            {
                this$1 = _cls4.this;
                super();
            }
                            });
                        }
                        return;
                    }
                    showAutoHideProgressDialogWithMessage(getString(0x7f0601de), new com.poshmark.ui.customviews.PMProgressDialog.ProgressDialogAutoDismissListener() {

                        final _cls4 this$1;

                        public void dialogDismissed()
                        {
                            ListingNotificationManager.getListingNotificationManager().fireListingEditedMessage(order.getOrderListingId());
                            done(-1);
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, null, getString(0x7f0600f4), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            }

            
            {
                this$0 = CheckoutConfirmationFragment_Offers.this;
                order = pmorder;
                super();
            }
        });
    }

    private void processOffer()
    {
        PMOrder pmorder = flowHandler.getPoshmarkOrder();
        Object obj = pmorder.getBrainTreeToken();
        if (flowHandler.isCreditCardUpdated())
        {
            Object obj1 = flowHandler.getCreditCard();
            obj = new EncryptedCreditCardInfo();
            obj.cc_number = encryptFormField(((CreditCard) (obj1)).getNumber());
            obj.cc_exp_date = encryptFormField(CreditCardUtils.getFormattedCreditCardExpirationDate(getActivity(), ((CreditCard) (obj1))));
            obj.cc_cvv = encryptFormField(((CreditCard) (obj1)).getSecurityCode());
            obj1 = (new GsonBuilder()).create();
            if (!(obj1 instanceof Gson))
            {
                obj = ((Gson) (obj1)).toJson(obj, com/poshmark/data_model/models/EncryptedCreditCardInfo);
            } else
            {
                obj = GsonInstrumentation.toJson((Gson)obj1, obj, com/poshmark/data_model/models/EncryptedCreditCardInfo);
            }
            obj1 = new HashMap();
            ((Map) (obj1)).put("cc_new_token_response", obj);
            ((Map) (obj1)).put("payment_type", "bt");
            ((Map) (obj1)).put("post_id", pmorder.getOrderListingId());
            fireOffer(((Map) (obj1)), MetricsTrackingUtils.getTrackingJson(getActivity(), "ofr_s"));
        } else
        if (obj != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("cc_token", obj);
            hashmap.put("payment_type", pmorder.getLastPaymentInfo().getPaymentType());
            hashmap.put("post_id", pmorder.getOrderListingId());
            fireOffer(hashmap, MetricsTrackingUtils.getTrackingJson(getActivity(), "ofr_s"));
            return;
        }
    }

    public boolean handleBack()
    {
        flowHandler.setCreditCardUpdated(false);
        return false;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1)
        {
            current_state = CheckoutConfirmationFragment.FLOW_STATE.CHECKOUT;
            fixedPaymentFailed = true;
            updateView();
        } else
        if (current_state == CheckoutConfirmationFragment.FLOW_STATE.GATHER_DETAILS)
        {
            done(0);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030091, viewgroup, false);
        derivedClassView = layoutinflater;
        if (flowHandler != null && flowHandler.getPoshmarkOffer().getStatus().equalsIgnoreCase("pf"))
        {
            mode = MODE.EXISTING_OFFER;
        } else
        {
            mode = MODE.NEW_OFFER;
        }
        setupView(layoutinflater);
        updateView();
        return layoutinflater;
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (flowHandler != null && flowHandler.getPoshmarkOffer().getStatus().equalsIgnoreCase("pf"))
        {
            flowHandler.setCallingFragment(this);
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (mode == MODE.NEW_OFFER)
        {
            setTitle(getString(0x7f0601df));
        }
    }

    protected void setupHandlers()
    {
        viewHolder.changeCreditCardInfoButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutConfirmationFragment_Offers this$0;

            public void onClick(View view)
            {
                current_state = CheckoutConfirmationFragment.FLOW_STATE.CHANGE_CREDIT_CARD_INFO;
                launchCheckoutForm(CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD);
            }

            
            {
                this$0 = CheckoutConfirmationFragment_Offers.this;
                super();
            }
        });
        viewHolder.changeShippingInfoButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutConfirmationFragment_Offers this$0;

            public void onClick(View view)
            {
                current_state = CheckoutConfirmationFragment.FLOW_STATE.CHANGE_SHIPPING_ADDRESS;
                launchCheckoutForm(CheckoutFormFragment.CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS);
            }

            
            {
                this$0 = CheckoutConfirmationFragment_Offers.this;
                super();
            }
        });
        viewHolder.submitOrderButton.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutConfirmationFragment_Offers this$0;

            public void onClick(View view)
            {
                view = flowHandler.getPoshmarkOrder().getOrderId();
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "offer_submit_button_tapped", view);
                processOffer();
            }

            
            {
                this$0 = CheckoutConfirmationFragment_Offers.this;
                super();
            }
        });
    }

    protected void setupView(View view)
    {
        viewHolder = new CheckoutConfirmationFormViewHolder();
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
        if (derivedClassView != null)
        {
            viewHolder.paymentInfoLeftBorder = view.findViewById(0x7f0c0221);
            viewHolder.paymentInfoTopBorder = view.findViewById(0x7f0c021f);
            viewHolder.paymentInfoRightBorder = view.findViewById(0x7f0c0222);
            viewHolder.paymentInfoBottomBorder = view.findViewById(0x7f0c0220);
            viewHolder.offerInfoText = (PMTextView)view.findViewById(0x7f0c0223);
        }
    }

    protected void updateView()
    {
        PMOrder pmorder;
        if (current_state != CheckoutConfirmationFragment.FLOW_STATE.GATHER_DETAILS)
        {
            if ((pmorder = flowHandler.getPoshmarkOrder()).getLineItems().size() > 0 && pmorder.getShippingAmount().size() > 0)
            {
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
                if (obj != null && ((CreditCard) (obj)).getNumber() != null)
                {
                    obj = CreditCardUtils.getStringFromCreditCard(getActivity(), ((CreditCard) (obj)));
                    viewHolder.changeCreditCardInfoButton.setText(((CharSequence) (obj)));
                } else
                if (pmorder.getLastPaymentInfo() != null)
                {
                    String s = CreditCardUtils.getStringFromPaymentInfo(getActivity(), pmorder.getLastPaymentInfo());
                    viewHolder.changeCreditCardInfoButton.setText(s);
                }
                viewHolder.changeShippingInfoButton.setText(AddressUtils.addressStringWithoutPhone(pmorder.getShippingAddress()));
                if (derivedClassView != null)
                {
                    if (mode == MODE.NEW_OFFER)
                    {
                        viewHolder.submitOrderButton.setText(0x7f06028e);
                        viewHolder.paymentInfoLeftBorder.setVisibility(8);
                        viewHolder.paymentInfoTopBorder.setVisibility(8);
                        viewHolder.paymentInfoRightBorder.setVisibility(8);
                        viewHolder.paymentInfoBottomBorder.setVisibility(8);
                        return;
                    }
                    if (viewHolder.offerInfoText != null)
                    {
                        viewHolder.offerInfoText.setVisibility(8);
                    }
                    if (fixedPaymentFailed)
                    {
                        viewHolder.paymentInfoLeftBorder.setVisibility(8);
                        viewHolder.paymentInfoTopBorder.setVisibility(8);
                        viewHolder.paymentInfoRightBorder.setVisibility(8);
                        viewHolder.paymentInfoBottomBorder.setVisibility(8);
                        viewHolder.paymentTextView.setTextColor(getActivity().getResources().getColor(0x7f090038));
                        return;
                    } else
                    {
                        viewHolder.submitOrderButton.setText(0x7f06028f);
                        viewHolder.paymentInfoLeftBorder.setVisibility(0);
                        viewHolder.paymentInfoTopBorder.setVisibility(0);
                        viewHolder.paymentInfoRightBorder.setVisibility(0);
                        viewHolder.paymentInfoBottomBorder.setVisibility(0);
                        viewHolder.paymentTextView.setTextColor(getActivity().getResources().getColor(0x7f09000c));
                        return;
                    }
                }
            }
        }
    }

}
