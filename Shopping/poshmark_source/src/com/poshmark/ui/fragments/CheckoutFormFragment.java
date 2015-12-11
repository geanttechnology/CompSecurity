// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.AddressCheckerResults;
import com.poshmark.data_model.models.PMOffer;
import com.poshmark.data_model.models.PMOfferInfo;
import com.poshmark.data_model.models.PMOrder;
import com.poshmark.data_model.models.inner_models.Address;
import com.poshmark.data_model.models.inner_models.CreditCard;
import com.poshmark.data_model.models.inner_models.LineItem;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.ui.customviews.PMListingImageView;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.ui.model.ActionErrorContext;
import com.poshmark.utils.AddressUtils;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.OfferFlowHandler;
import com.poshmark.utils.ViewUtils;
import com.poshmark.utils.view_holders.CheckoutFormViewHolder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, AddressMatchFragment, MappPageFragment

public class CheckoutFormFragment extends PMFragment
{
    public static final class CHECKOUT_FORM_MODES extends Enum
    {

        private static final CHECKOUT_FORM_MODES $VALUES[];
        public static final CHECKOUT_FORM_MODES CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS;
        public static final CHECKOUT_FORM_MODES CHECKOUT_FORM_MODE_CREDIT_CARD;
        public static final CHECKOUT_FORM_MODES CHECKOUT_FORM_MODE_SHIPPING_ADDRESS;

        public static CHECKOUT_FORM_MODES valueOf(String s)
        {
            return (CHECKOUT_FORM_MODES)Enum.valueOf(com/poshmark/ui/fragments/CheckoutFormFragment$CHECKOUT_FORM_MODES, s);
        }

        public static CHECKOUT_FORM_MODES[] values()
        {
            return (CHECKOUT_FORM_MODES[])$VALUES.clone();
        }

        static 
        {
            CHECKOUT_FORM_MODE_CREDIT_CARD = new CHECKOUT_FORM_MODES("CHECKOUT_FORM_MODE_CREDIT_CARD", 0);
            CHECKOUT_FORM_MODE_SHIPPING_ADDRESS = new CHECKOUT_FORM_MODES("CHECKOUT_FORM_MODE_SHIPPING_ADDRESS", 1);
            CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS = new CHECKOUT_FORM_MODES("CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS", 2);
            $VALUES = (new CHECKOUT_FORM_MODES[] {
                CHECKOUT_FORM_MODE_CREDIT_CARD, CHECKOUT_FORM_MODE_SHIPPING_ADDRESS, CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS
            });
        }

        private CHECKOUT_FORM_MODES(String s, int i)
        {
            super(s, i);
        }
    }

    static final class MODE extends Enum
    {

        private static final MODE $VALUES[];
        public static final MODE BUY_MODE;
        public static final MODE OFFER_MODE;

        public static MODE valueOf(String s)
        {
            return (MODE)Enum.valueOf(com/poshmark/ui/fragments/CheckoutFormFragment$MODE, s);
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


    private int PICK_ADDRESS;
    private Address billingAddress;
    CreditCard cc_local;
    private android.widget.CompoundButton.OnCheckedChangeListener checkedChangeListener;
    private android.view.View.OnClickListener checkoutButtonListener;
    private LabelledEditText currentInputEditText;
    private CheckoutFlowHandler flowHandler;
    private android.view.View.OnFocusChangeListener focusChangeListener;
    private CHECKOUT_FORM_MODES formMode;
    MODE mode;
    private android.view.View.OnClickListener nextButtonListener;
    private android.view.View.OnTouchListener otl;
    private Address shippingAddress;
    private com.poshmark.ui.customviews.PMEditText.OnTapListener tapListener;
    private Bundle updatedShippingAddress;
    private CheckoutFormViewHolder viewHolder;

    public CheckoutFormFragment()
    {
        PICK_ADDRESS = 1;
        cc_local = new CreditCard();
        mode = MODE.BUY_MODE;
        shippingAddress = new Address();
        billingAddress = new Address();
        updatedShippingAddress = null;
        checkoutButtonListener = new android.view.View.OnClickListener() {

            final CheckoutFormFragment this$0;

            public void onClick(View view)
            {
                boolean flag = flowHandler.getPoshmarkOrder().isOrderCheckoutTypeBundle();
                flowHandler.getPoshmarkOrder().getOrderId();
                view = flowHandler.getPoshmarkOffer();
                if (flag)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "secure_checkout", null);
                } else
                if (view != null)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "offer_payment_and_shipping_entered_next_tapped", null);
                } else
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "secure_checkout", null);
                }
                if (isValidInput())
                {
                    saveCreditCardInfo();
                    checkAddressValidity();
                }
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        };
        nextButtonListener = new android.view.View.OnClickListener() {

            final CheckoutFormFragment this$0;

            public void onClick(View view)
            {
                if (isValidInput())
                {
                    if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD)
                    {
                        saveCreditCardInfo();
                        view = flowHandler.getPoshmarkOrder().getOrderId();
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "update_credit_card", view);
                        if (viewHolder.billingCheckbox.isChecked())
                        {
                            billingAddress.copy(shippingAddress);
                        } else
                        {
                            populateBillingAddress();
                        }
                        postAddressesToServerAndFinish();
                    } else
                    if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
                    {
                        view = flowHandler.getPoshmarkOrder().getOrderId();
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "update_shipping_address", view);
                        checkAddressValidity();
                        return;
                    }
                }
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        };
        tapListener = new com.poshmark.ui.customviews.PMEditText.OnTapListener() {

            final CheckoutFormFragment this$0;

            public void onTap(View view)
            {
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        };
        otl = new android.view.View.OnTouchListener() {

            final CheckoutFormFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    if (view == viewHolder.expirationEditText)
                    {
                        currentInputEditText = (LabelledEditText)view;
                        showCreditCardExpirationSelectorDialog();
                        return true;
                    }
                    if (view == viewHolder.billingStateEditText || view == viewHolder.shippingStateEditText)
                    {
                        currentInputEditText = (LabelledEditText)view;
                        showStateSelectorDialog();
                        return true;
                    }
                }
                return false;
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        };
        focusChangeListener = new android.view.View.OnFocusChangeListener() {

            final CheckoutFormFragment this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    if (view == viewHolder.expirationEditText)
                    {
                        hideKeyboard();
                        currentInputEditText = (LabelledEditText)view;
                        showCreditCardExpirationSelectorDialog();
                    } else
                    if (view == viewHolder.billingStateEditText || view == viewHolder.shippingStateEditText)
                    {
                        hideKeyboard();
                        currentInputEditText = (LabelledEditText)view;
                        showStateSelectorDialog();
                        return;
                    }
                }
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        };
        checkedChangeListener = new android.widget.CompoundButton.OnCheckedChangeListener() {

            final CheckoutFormFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (flag)
                {
                    viewHolder.billingAddressLayout.setVisibility(8);
                    return;
                } else
                {
                    viewHolder.billingAddressLayout.setVisibility(0);
                    return;
                }
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        };
    }

    private void checkAddressValidity()
    {
        if (formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS) goto _L2; else goto _L1
_L1:
        populateShippingAddress();
        billingAddress = flowHandler.getPoshmarkOrder().billing_address;
_L4:
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getAddressConfirmation(shippingAddress, new PMApiResponseHandler() {

            final CheckoutFormFragment this$0;

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
                            pmapiresponse = (AddressCheckerResults)pmapiresponse.data;
                            if (((AddressCheckerResults) (pmapiresponse)).status.equals("exact_match_found"))
                            {
                                break label1;
                            }
                            fireAddressPickerFragment(pmapiresponse);
                        }
                        return;
                    }
                    postAddressesToServerAndFinish();
                    return;
                }
                showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_ORDER_ADDRESS, getString(0x7f0600d6), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        });
        return;
_L2:
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS)
        {
            populateShippingAddress();
            if (viewHolder.billingCheckbox.isChecked())
            {
                billingAddress.copy(shippingAddress);
            } else
            {
                populateBillingAddress();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void fireAddressPickerFragment(AddressCheckerResults addresscheckerresults)
    {
        Bundle bundle = new Bundle();
        ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/AddressMatchFragment, addresscheckerresults, this, PICK_ADDRESS);
    }

    private boolean isValidInput()
    {
        String s1 = new String();
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD || formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS)
        {
            s1 = validateCCInfo();
        }
        boolean flag = viewHolder.billingCheckbox.isChecked();
        String s;
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD)
        {
            s = s1;
            if (!flag)
            {
                s = (new StringBuilder()).append(s1).append(validateBillingInfo()).toString();
            }
        } else
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS)
        {
            if (!flag)
            {
                new String();
                String s2 = validateBillingInfo();
                s = s2;
                if (s2.isEmpty())
                {
                    s = (new StringBuilder()).append(s2).append(validateShippingInfo()).toString();
                }
                s = (new StringBuilder()).append(s1).append(s).toString();
            } else
            {
                s = (new StringBuilder()).append(s1).append(validateShippingInfo()).toString();
            }
        } else
        {
            s = s1;
            if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
            {
                s = (new StringBuilder()).append(s1).append(validateShippingInfo()).toString();
            }
        }
        if (!s.isEmpty())
        {
            showAlertMessage(getResources().getString(0x7f060148), s);
            return false;
        } else
        {
            return true;
        }
    }

    private void populateBillingAddress()
    {
        billingAddress.setName(viewHolder.billingNameEditText.getText().toString());
        billingAddress.setStreet(viewHolder.billingStreetEditText.getText().toString());
        billingAddress.setStreet2(viewHolder.billingStreet2EditText.getText().toString());
        billingAddress.setCity(viewHolder.billingCityEditText.getText().toString());
        billingAddress.setState(viewHolder.billingStateEditText.getText().toString());
        billingAddress.setZip(viewHolder.billingZipEditText.getText().toString());
        billingAddress.setPhone(viewHolder.billingPhoneEditText.getText().toString());
    }

    private void populateShippingAddress()
    {
        shippingAddress.setName(viewHolder.shippingNameEditText.getText().toString());
        shippingAddress.setStreet(viewHolder.shippingStreetEditText.getText().toString());
        shippingAddress.setStreet2(viewHolder.shippingStreet2EditText.getText().toString());
        shippingAddress.setCity(viewHolder.shippingCityEditText.getText().toString());
        shippingAddress.setState(viewHolder.shippingStateEditText.getText().toString());
        shippingAddress.setZip(viewHolder.shippingZipEditText.getText().toString());
        shippingAddress.setPhone(viewHolder.shippingPhoneEditText.getText().toString());
    }

    private void postAddressesToServerAndFinish()
    {
        boolean flag = billingAddress.isSameAs(shippingAddress);
        shippingAddress.setType("shipping");
        billingAddress.setType("billing");
        HashMap hashmap = new HashMap();
        hashmap.put("billing", billingAddress.getJsonString());
        if (mode == MODE.BUY_MODE)
        {
            hashmap.put("inventory_unit_ids", flowHandler.getPoshmarkOrder().getInventoryUnitIds());
        }
        hashmap.put("is_same_as_shipping", Boolean.toString(flag));
        hashmap.put("shipping", shippingAddress.getJsonString());
        hashmap.put("validated", "true");
        showProgressDialogWithMessage(getString(0x7f0602b5));
        if (mode == MODE.BUY_MODE)
        {
            PMApi.postOrderAddresses(flowHandler.getPoshmarkOrder().getOrderId(), hashmap, new PMApiResponseHandler() {

                final CheckoutFormFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (!isAdded()) goto _L2; else goto _L1
_L1:
                    hideProgressDialog();
                    if (pmapiresponse.hasError()) goto _L4; else goto _L3
_L3:
                    flowHandler.updatePoshmarkOrder((PMOrder)pmapiresponse.data);
                    pmapiresponse = flowHandler.getPoshmarkOrder().getOrderId();
                    if (formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD && formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS) goto _L6; else goto _L5
_L5:
                    flowHandler.getCreditCard().copy(cc_local);
                    flowHandler.setCreditCardUpdated(true);
_L7:
                    finishActivityWithResult(-1, null);
_L2:
                    return;
_L6:
                    if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "updated_order_address", pmapiresponse);
                    }
                    if (true) goto _L7; else goto _L4
_L4:
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_ORDER_ADDRESS, getString(0x7f0600d6), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
                    return;
                }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
            });
            return;
        } else
        {
            PMApi.postOfferAddresses(flowHandler.getPoshmarkOrder().getOrderId(), hashmap, new PMApiResponseHandler() {

                final CheckoutFormFragment this$0;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    if (!isAdded()) goto _L2; else goto _L1
_L1:
                    hideProgressDialog();
                    if (pmapiresponse.hasError()) goto _L4; else goto _L3
_L3:
                    flowHandler.updatePoshmarkOrder(((PMOfferInfo)pmapiresponse.data).data);
                    pmapiresponse = flowHandler.getPoshmarkOrder().getOrderId();
                    if (formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD && formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS) goto _L6; else goto _L5
_L5:
                    flowHandler.getCreditCard().copy(cc_local);
                    flowHandler.setCreditCardUpdated(true);
_L7:
                    finishActivityWithResult(-1, null);
_L2:
                    return;
_L6:
                    if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
                    {
                        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "updated_order_address", pmapiresponse);
                    }
                    if (true) goto _L7; else goto _L4
_L4:
                    showError(new ActionErrorContext(pmapiresponse.apiError, com.poshmark.ui.model.ActionErrorContext.ActionContext.UPDATE_ORDER_ADDRESS, getString(0x7f0600d6), com.poshmark.ui.model.ActionErrorContext.Severity.HIGH));
                    return;
                }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void saveCreditCardInfo()
    {
        cc_local.setNumber(viewHolder.cardNumberEditText.getText().toString());
        cc_local.setSecurityCode(viewHolder.securityCodeEditText.getText().toString());
        if (viewHolder.billingCheckbox.isChecked())
        {
            cc_local.setUseShippingAddress(true);
            return;
        } else
        {
            cc_local.setUseShippingAddress(false);
            return;
        }
    }

    private void setupCCExpirationView(View view)
    {
        Calendar calendar = Calendar.getInstance();
        int k = calendar.get(1);
        int l = calendar.get(2);
        String as[] = new String[12];
        for (int i = 0; i < as.length; i++)
        {
            as[i] = Integer.toString(i + 1);
        }

        NumberPicker numberpicker = (NumberPicker)view.findViewById(0x7f0c009b);
        numberpicker.setDescendantFocusability(0x60000);
        numberpicker.setMaxValue(12);
        numberpicker.setMinValue(1);
        numberpicker.setWrapSelectorWheel(false);
        numberpicker.setDisplayedValues(as);
        numberpicker.setValue(l + 1);
        as = new String[20];
        for (int j = 0; j < 20; j++)
        {
            as[j] = Integer.toString(k + j);
        }

        view = (NumberPicker)view.findViewById(0x7f0c009c);
        view.setDescendantFocusability(0x60000);
        view.setMaxValue(k + 19);
        view.setMinValue(k);
        view.setWrapSelectorWheel(false);
        view.setDisplayedValues(as);
        view.setValue(k);
    }

    private void setupView(View view)
    {
        PMOffer pmoffer;
        boolean flag;
label0:
        {
            viewHolder = new CheckoutFormViewHolder();
            viewHolder.firstTimeInfoLayout = (RelativeLayout)view.findViewById(0x7f0c00ae);
            viewHolder.offerInfoLink = (PMTextView)view.findViewById(0x7f0c00b1);
            viewHolder.itemSummaryLayout = (LinearLayout)view.findViewById(0x7f0c00a3);
            viewHolder.bundleItemSummaryLayout = (LinearLayout)view.findViewById(0x7f0c00ad);
            boolean flag1 = false;
            pmoffer = flowHandler.getPoshmarkOffer();
            flag = flag1;
            if (pmoffer == null)
            {
                break label0;
            }
            if (pmoffer.shipping_address != null)
            {
                flag = flag1;
                if (pmoffer.shipping_address.isDataAvailable())
                {
                    break label0;
                }
            }
            flag = true;
        }
        if (!flag)
        {
            if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS)
            {
                if (flowHandler.getPoshmarkOrder().isOrderCheckoutTypeBundle())
                {
                    viewHolder.itemSummaryLayout.setVisibility(8);
                    viewHolder.bundleItemSummaryLayout.setVisibility(0);
                } else
                {
                    viewHolder.itemSummaryLayout.setVisibility(0);
                    viewHolder.bundleItemSummaryLayout.setVisibility(8);
                }
            } else
            {
                viewHolder.itemSummaryLayout.setVisibility(8);
                viewHolder.bundleItemSummaryLayout.setVisibility(8);
            }
        } else
        {
            viewHolder.firstTimeInfoLayout.setVisibility(0);
            viewHolder.itemSummaryLayout.setVisibility(8);
            viewHolder.bundleItemSummaryLayout.setVisibility(8);
        }
        viewHolder.listingImageView = (PMListingImageView)view.findViewById(0x7f0c00b5);
        viewHolder.listingTitleView = (TextView)view.findViewById(0x7f0c00b7);
        viewHolder.listingSizeView = (TextView)view.findViewById(0x7f0c00b8);
        viewHolder.listingSellerView = (TextView)view.findViewById(0x7f0c00b9);
        viewHolder.bundleListingImageView = (PMListingImageView)view.findViewById(0x7f0c0074);
        viewHolder.bundleItemsCountIndicator = (PMTextView)view.findViewById(0x7f0c0075);
        viewHolder.bundleTitleView = (PMTextView)view.findViewById(0x7f0c0077);
        viewHolder.bundlePriceView = (PMTextView)view.findViewById(0x7f0c0078);
        viewHolder.bundleItemsCountView = (PMTextView)view.findViewById(0x7f0c0079);
        viewHolder.bundleSellerNameView = (PMTextView)view.findViewById(0x7f0c007a);
        viewHolder.paymentTitleTextView = (TextView)view.findViewById(0x7f0c00a7);
        viewHolder.creditCardInfoLayout = (LinearLayout)view.findViewById(0x7f0c00b2);
        viewHolder.cardNumberEditText = (LabelledEditText)view.findViewById(0x7f0c00de);
        viewHolder.expirationEditText = (LabelledEditText)view.findViewById(0x7f0c00df);
        viewHolder.securityCodeEditText = (LabelledEditText)view.findViewById(0x7f0c00e0);
        viewHolder.billingCheckbox = (CheckBox)view.findViewById(0x7f0c00e1);
        viewHolder.billingAddressLayout = (LinearLayout)view.findViewById(0x7f0c00e2);
        viewHolder.billingNameEditText = (LabelledEditText)view.findViewById(0x7f0c00e3);
        viewHolder.billingStreetEditText = (LabelledEditText)view.findViewById(0x7f0c00e4);
        viewHolder.billingStreet2EditText = (LabelledEditText)view.findViewById(0x7f0c00e5);
        viewHolder.billingCityEditText = (LabelledEditText)view.findViewById(0x7f0c00e6);
        viewHolder.billingStateEditText = (LabelledEditText)view.findViewById(0x7f0c00e7);
        viewHolder.billingZipEditText = (LabelledEditText)view.findViewById(0x7f0c00e8);
        viewHolder.billingPhoneEditText = (LabelledEditText)view.findViewById(0x7f0c00e9);
        viewHolder.shippingTitleTextView = (TextView)view.findViewById(0x7f0c00a9);
        viewHolder.shippingAddressLayout = (LinearLayout)view.findViewById(0x7f0c00b3);
        viewHolder.shippingNameEditText = (LabelledEditText)view.findViewById(0x7f0c02c4);
        viewHolder.shippingStreetEditText = (LabelledEditText)view.findViewById(0x7f0c02c5);
        viewHolder.shippingStreet2EditText = (LabelledEditText)view.findViewById(0x7f0c02c6);
        viewHolder.shippingCityEditText = (LabelledEditText)view.findViewById(0x7f0c02c7);
        viewHolder.shippingStateEditText = (LabelledEditText)view.findViewById(0x7f0c02c8);
        viewHolder.shippingZipEditText = (LabelledEditText)view.findViewById(0x7f0c02c9);
        viewHolder.shippingPhoneEditText = (LabelledEditText)view.findViewById(0x7f0c02ca);
        viewHolder.bottomBarLayout = (LinearLayout)view.findViewById(0x7f0c00ab);
        viewHolder.checkoutButton = (Button)view.findViewById(0x7f0c00b4);
        if (pmoffer != null)
        {
            viewHolder.checkoutButton.setText(getString(0x7f0601cc));
        }
        if (formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS) goto _L2; else goto _L1
_L1:
        if (flowHandler.getPoshmarkOrder().isOrderCheckoutTypeBundle())
        {
            updateBundleSummary();
        } else
        {
            updateListingSummary();
        }
        viewHolder.paymentTitleTextView.setVisibility(0);
        viewHolder.creditCardInfoLayout.setVisibility(0);
        viewHolder.shippingTitleTextView.setVisibility(0);
        viewHolder.shippingAddressLayout.setVisibility(0);
        viewHolder.bottomBarLayout.setVisibility(0);
_L4:
        viewHolder.billingCheckbox.setOnCheckedChangeListener(checkedChangeListener);
        viewHolder.expirationEditText.setOnTouchListener(otl);
        viewHolder.expirationEditText.setOnFocusChangeListener(focusChangeListener);
        viewHolder.billingStateEditText.setOnTouchListener(otl);
        viewHolder.billingStateEditText.setOnFocusChangeListener(focusChangeListener);
        viewHolder.shippingStateEditText.setOnTouchListener(otl);
        viewHolder.shippingStateEditText.setOnFocusChangeListener(focusChangeListener);
        viewHolder.checkoutButton.setOnClickListener(checkoutButtonListener);
        viewHolder.offerInfoLink.setOnClickListener(new android.view.View.OnClickListener() {

            final CheckoutFormFragment this$0;

            public void onClick(View view1)
            {
                view1 = new Bundle();
                view1.putString("URL", "https://www.poshmark.com/mapp/offers_help");
                view1.putString("ANALYTICS_PAGE_NAME", "offers_help_screen");
                ((PMActivity)getActivity()).launchFragmentInNewActivity(view1, com/poshmark/ui/fragments/MappPageFragment, null);
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        });
        return;
_L2:
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD)
        {
            ((android.widget.LinearLayout.LayoutParams)viewHolder.creditCardInfoLayout.getLayoutParams()).setMargins(0, (int)ViewUtils.dipToPixels(getActivity(), 30F), 0, 0);
            viewHolder.paymentTitleTextView.setVisibility(8);
            viewHolder.creditCardInfoLayout.setVisibility(0);
            viewHolder.shippingTitleTextView.setVisibility(8);
            viewHolder.shippingAddressLayout.setVisibility(8);
            viewHolder.bottomBarLayout.setVisibility(8);
            if (!flowHandler.addressesEqual())
            {
                viewHolder.billingAddressLayout.setVisibility(0);
                viewHolder.billingCheckbox.setChecked(false);
            }
        } else
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
        {
            ((android.widget.LinearLayout.LayoutParams)viewHolder.shippingAddressLayout.getLayoutParams()).setMargins(0, (int)ViewUtils.dipToPixels(getActivity(), 30F), 0, 0);
            viewHolder.paymentTitleTextView.setVisibility(8);
            viewHolder.creditCardInfoLayout.setVisibility(8);
            viewHolder.shippingTitleTextView.setVisibility(8);
            viewHolder.shippingAddressLayout.setVisibility(0);
            viewHolder.bottomBarLayout.setVisibility(8);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void showCreditCardExpirationSelectorDialog()
    {
        final View v = getActivity().getLayoutInflater().inflate(0x7f030020, null);
        setupCCExpirationView(v);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(getString(0x7f060104));
        builder.setView(v);
        builder.setPositiveButton(0x7f0600bf, new android.content.DialogInterface.OnClickListener() {

            final CheckoutFormFragment this$0;
            final View val$v;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface = (NumberPicker)v.findViewById(0x7f0c009b);
                NumberPicker numberpicker = (NumberPicker)v.findViewById(0x7f0c009c);
                cc_local.setExpirationMonth(Integer.toString(dialoginterface.getValue()));
                cc_local.setExpirationYear(Integer.toString(numberpicker.getValue()));
                viewHolder.expirationEditText.setText((new StringBuilder()).append(cc_local.getExpirationMonth()).append(" / ").append(cc_local.getExpirationYear()).toString());
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                v = view;
                super();
            }
        });
        builder.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

            final CheckoutFormFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        });
        builder.create().show();
    }

    private void showStateSelectorDialog()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(AddressUtils.statesOfUSA().keySet());
        Collections.sort(arraylist);
        final CharSequence items[] = (CharSequence[])arraylist.toArray(new CharSequence[arraylist.size()]);
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle(getString(0x7f060244));
        builder.setItems(items, new android.content.DialogInterface.OnClickListener() {

            final CheckoutFormFragment this$0;
            final CharSequence val$items[];

            public void onClick(DialogInterface dialoginterface, int i)
            {
                HashMap hashmap = AddressUtils.statesOfUSA();
                currentInputEditText.setText((CharSequence)hashmap.get(items[i]));
                dialoginterface.dismiss();
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                items = acharsequence;
                super();
            }
        });
        builder.setNegativeButton(0x7f06006d, new android.content.DialogInterface.OnClickListener() {

            final CheckoutFormFragment this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = CheckoutFormFragment.this;
                super();
            }
        });
        builder.create().show();
    }

    private void updateBundleSummary()
    {
        PMOrder pmorder = flowHandler.getPoshmarkOrder();
        viewHolder.bundleListingImageView.loadImage(pmorder.getPictureUrl());
        viewHolder.bundleItemsCountIndicator.setText(String.format("%d", new Object[] {
            Integer.valueOf(pmorder.getLineItems().size())
        }));
        viewHolder.bundleTitleView.setText(pmorder.getTitle());
        viewHolder.bundlePriceView.setText(pmorder.getTotalPriceString());
        viewHolder.bundleItemsCountView.setText((new StringBuilder()).append(getString(0x7f06015a)).append(" ").append(String.format("%d", new Object[] {
            Integer.valueOf(pmorder.getLineItems().size())
        })).toString());
        viewHolder.bundleSellerNameView.setText((new StringBuilder()).append(getString(0x7f060249)).append(" ").append(pmorder.getSellerName()).toString());
    }

    private void updateListingSummary()
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

    private String validateBillingInfo()
    {
        String s1 = new String();
        String s = s1;
        if (!viewHolder.billingNameEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.billingNameEditText.getValidatorString()).append("\n").toString();
        }
        s1 = s;
        if (!viewHolder.billingStreetEditText.isValid())
        {
            s1 = (new StringBuilder()).append(s).append(viewHolder.billingStreetEditText.getValidatorString()).append("\n").toString();
        }
        s = s1;
        if (!viewHolder.billingCityEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.billingCityEditText.getValidatorString()).append("\n").toString();
        }
        s1 = s;
        if (!viewHolder.billingStateEditText.isValid())
        {
            s1 = (new StringBuilder()).append(s).append(viewHolder.billingStateEditText.getValidatorString()).append("\n").toString();
        }
        s = s1;
        if (!viewHolder.billingZipEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.billingZipEditText.getValidatorString()).append("\n").toString();
        }
        return s;
    }

    private String validateCCInfo()
    {
        String s1 = new String();
        String s = s1;
        if (!viewHolder.cardNumberEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.cardNumberEditText.getValidatorString()).append("\n").toString();
        }
        s1 = s;
        if (!viewHolder.expirationEditText.isValid())
        {
            s1 = (new StringBuilder()).append(s).append(viewHolder.expirationEditText.getValidatorString()).append("\n").toString();
        }
        s = s1;
        if (!viewHolder.securityCodeEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.securityCodeEditText.getValidatorString()).append("\n").toString();
        }
        return s;
    }

    private String validateShippingInfo()
    {
        String s1 = new String();
        String s = s1;
        if (!viewHolder.shippingNameEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.shippingNameEditText.getValidatorString()).append("\n").toString();
        }
        s1 = s;
        if (!viewHolder.shippingStreetEditText.isValid())
        {
            s1 = (new StringBuilder()).append(s).append(viewHolder.shippingStreetEditText.getValidatorString()).append("\n").toString();
        }
        s = s1;
        if (!viewHolder.shippingCityEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.shippingCityEditText.getValidatorString()).append("\n").toString();
        }
        s1 = s;
        if (!viewHolder.shippingStateEditText.isValid())
        {
            s1 = (new StringBuilder()).append(s).append(viewHolder.shippingStateEditText.getValidatorString()).append("\n").toString();
        }
        s = s1;
        if (!viewHolder.shippingZipEditText.isValid())
        {
            s = (new StringBuilder()).append(s1).append(viewHolder.shippingZipEditText.getValidatorString()).append("\n").toString();
        }
        return s;
    }

    public boolean handleBack()
    {
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (j == -1 && i == PICK_ADDRESS)
        {
            updatedShippingAddress = (Bundle)intent.getExtras().clone();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        formMode = CHECKOUT_FORM_MODES.values()[getArguments().getInt("CHECKOUT_FORM_MODE")];
        if (bundle != null) goto _L2; else goto _L1
_L1:
        flowHandler = (CheckoutFlowHandler)getFragmentDataOfType(com/poshmark/utils/CheckoutFlowHandler);
        cc_local.copy(flowHandler.getCreditCard());
        billingAddress.copy(flowHandler.getPoshmarkOrder().billing_address);
        shippingAddress.copy(flowHandler.getPoshmarkOrder().shipping_address);
_L4:
        if (flowHandler != null && (flowHandler instanceof OfferFlowHandler))
        {
            mode = MODE.OFFER_MODE;
        }
        return;
_L2:
        ParcelUuid parceluuid = (ParcelUuid)bundle.getParcelable("FLOW_HANDLER_OBJECT");
        if (parceluuid != null)
        {
            flowHandler = (CheckoutFlowHandler)ObjectPickupDropOff.pickupDataObject(parceluuid.getUuid());
        }
        parceluuid = (ParcelUuid)bundle.getParcelable("CC_LOCAL");
        if (parceluuid != null)
        {
            cc_local = (CreditCard)ObjectPickupDropOff.pickupDataObject(parceluuid.getUuid());
        }
        parceluuid = (ParcelUuid)bundle.getParcelable("SHIPPING_ADDRESS");
        if (parceluuid != null)
        {
            shippingAddress = (Address)ObjectPickupDropOff.pickupDataObject(parceluuid.getUuid());
        }
        bundle = (ParcelUuid)bundle.getParcelable("BILLING_ADDRESS");
        if (bundle != null)
        {
            billingAddress = (Address)ObjectPickupDropOff.pickupDataObject(bundle.getUuid());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f030023, viewgroup, false);
        setupView(layoutinflater);
        populateViews();
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if (updatedShippingAddress != null)
        {
            Address address = new Address();
            address.setCity(updatedShippingAddress.getString("CITY"));
            address.setName(updatedShippingAddress.getString("NAME"));
            address.setPhone(updatedShippingAddress.getString("PHONE"));
            address.setState(updatedShippingAddress.getString("STATE"));
            address.setStreet(updatedShippingAddress.getString("STREET"));
            address.setStreet2(updatedShippingAddress.getString("STREET2"));
            address.setType(updatedShippingAddress.getString("TYPE"));
            address.setZip(updatedShippingAddress.getString("ZIP"));
            updatedShippingAddress = null;
            shippingAddress.copy(address);
            postAddressesToServerAndFinish();
        }
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
        java.util.UUID uuid1 = ObjectPickupDropOff.getUniqueKey();
        ObjectPickupDropOff.dropOffDataObject(uuid1, cc_local);
        bundle.putParcelable("CC_LOCAL", new ParcelUuid(uuid1));
        uuid1 = ObjectPickupDropOff.getUniqueKey();
        ObjectPickupDropOff.dropOffDataObject(uuid1, shippingAddress);
        bundle.putParcelable("SHIPPING_ADDRESS", new ParcelUuid(uuid1));
        uuid1 = ObjectPickupDropOff.getUniqueKey();
        ObjectPickupDropOff.dropOffDataObject(uuid1, billingAddress);
        bundle.putParcelable("BILLING_ADDRESS", new ParcelUuid(uuid1));
    }

    public void populateViews()
    {
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD)
        {
            if (!flowHandler.addressesEqual())
            {
                viewHolder.billingCityEditText.setText(billingAddress.getCity());
                viewHolder.billingNameEditText.setText(billingAddress.getName());
                viewHolder.billingPhoneEditText.setText(billingAddress.getPhone());
                viewHolder.billingStateEditText.setText(billingAddress.getState());
                viewHolder.billingStreetEditText.setText(billingAddress.getStreet());
                viewHolder.billingStreet2EditText.setText(billingAddress.getStreet2());
                viewHolder.billingZipEditText.setText(billingAddress.getZip());
            }
        } else
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
        {
            viewHolder.shippingCityEditText.setText(shippingAddress.getCity());
            viewHolder.shippingNameEditText.setText(shippingAddress.getName());
            viewHolder.shippingPhoneEditText.setText(shippingAddress.getPhone());
            viewHolder.shippingStateEditText.setText(shippingAddress.getState());
            viewHolder.shippingStreetEditText.setText(shippingAddress.getStreet());
            viewHolder.shippingStreet2EditText.setText(shippingAddress.getStreet2());
            viewHolder.shippingZipEditText.setText(shippingAddress.getZip());
            return;
        }
    }

    public void setViewNameForAnalytics()
    {
        static class _cls15
        {

            static final int $SwitchMap$com$poshmark$ui$fragments$CheckoutFormFragment$CHECKOUT_FORM_MODES[];

            static 
            {
                $SwitchMap$com$poshmark$ui$fragments$CheckoutFormFragment$CHECKOUT_FORM_MODES = new int[CHECKOUT_FORM_MODES.values().length];
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CheckoutFormFragment$CHECKOUT_FORM_MODES[CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CheckoutFormFragment$CHECKOUT_FORM_MODES[CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$poshmark$ui$fragments$CheckoutFormFragment$CHECKOUT_FORM_MODES[CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls15..SwitchMap.com.poshmark.ui.fragments.CheckoutFormFragment.CHECKOUT_FORM_MODES[formMode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            viewNameForAnalytics = "order_edit_credit_card_and_address_screen";
            return;

        case 2: // '\002'
            viewNameForAnalytics = "order_edit_credit_card_screen";
            return;

        case 3: // '\003'
            viewNameForAnalytics = "order_edit_address_screen";
            break;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (formMode != CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CC_AND_SHIPPING_ADDRESS) goto _L2; else goto _L1
_L1:
        if (flowHandler.getPoshmarkOffer() == null) goto _L4; else goto _L3
_L3:
        setTitle(getString(0x7f0601df));
_L6:
        return;
_L4:
        setTitle(getString(0x7f060078));
        return;
_L2:
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_CREDIT_CARD)
        {
            setTitle(getString(0x7f060031));
            setNextActionButton(getString(0x7f0600bf), nextButtonListener);
            return;
        }
        if (formMode == CHECKOUT_FORM_MODES.CHECKOUT_FORM_MODE_SHIPPING_ADDRESS)
        {
            setTitle(getString(0x7f060261));
            setNextActionButton(getString(0x7f0600bf), nextButtonListener);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }






/*
    static LabelledEditText access$1102(CheckoutFormFragment checkoutformfragment, LabelledEditText labellededittext)
    {
        checkoutformfragment.currentInputEditText = labellededittext;
        return labellededittext;
    }

*/










}
