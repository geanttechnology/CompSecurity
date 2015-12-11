// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.db.models.StockValue;
import com.groupon.http.NameValuePair;
import com.groupon.models.billingrecord.BillingRecord;
import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownPaymentMethodInstallmentItem;
import com.groupon.models.error.GrouponException;
import com.groupon.models.error.OrderException;
import com.groupon.models.gift.GiftCode;
import com.groupon.models.nst.NewsletterClickExtraInfo;
import com.groupon.models.order.Order;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.models.payment.PaymentMethodFactory;
import com.groupon.network.HttpResponseException;
import com.groupon.provider.KochavaProvider;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.service.ShippingService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.DialogManager;
import com.groupon.util.Function0;
import com.groupon.util.Function1;
import com.groupon.util.GrouponDialogFragment;
import com.groupon.util.IovationBlackboxUtil;
import com.groupon.util.ReturningFunction1;
import com.groupon.util.VolatileBillingInfoProvider;
import com.groupon.view.SpinnerButton;
import com.kochava.android.tracker.Feature;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import roboguice.inject.ContextScopedProvider;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            Purchase, IntentFactory

public class PurchaseEu extends Purchase
{

    private CurrentCountryManager currentCountryManager;
    IovationBlackboxUtil iovationBlackboxUtil;
    private KochavaProvider kochavaProvider;

    public PurchaseEu()
    {
    }

    private void complete3DSecureTransaction(Intent intent)
    {
        intent = intent.getExtras().getString("payment_res");
        Object obj = currentPaymentMethod.getCompletePurchaseParams(intent);
        boolean flag = false;
        intent = null;
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            NameValuePair namevaluepair = (NameValuePair)((Iterator) (obj)).next();
            if (Strings.equalsIgnoreCase(namevaluepair.name, "success"))
            {
                flag = Boolean.parseBoolean(namevaluepair.value);
            } else
            if (Strings.equalsIgnoreCase(namevaluepair.name, "billingId"))
            {
                intent = namevaluepair.value;
            }
        } while (true);
        if (flag)
        {
            onOrderSuccess(intent);
            return;
        } else
        {
            onRefusedEvent(currentPaymentMethod.getErrorMessage());
            return;
        }
    }

    private void complete3DSecureTransactionOnActivityResult(Intent intent, String s, int i)
    {
        if (i != -1)
        {
            onOrderFailure(new HttpResponseException(900, s));
            return;
        } else
        {
            complete3DSecureTransaction(intent);
            return;
        }
    }

    private void completeEcommerceTransaction(int i, int j, Intent intent)
    {
        switch (i)
        {
        default:
            return;

        case 10113: 
            completeTransactionOnActivityResult(intent, "Paypal Activity returned invalid result", j);
            return;

        case 10138: 
            completeTransactionOnActivityResult(intent, "DotPay Activity returned invalid result", j);
            return;

        case 10133: 
            completeTransactionOnActivityResult(intent, "IPay88 Activity returned invalid result", j);
            return;

        case 10109: 
            completeTransactionOnActivityResult(intent, "Ideal Activity returned invalid result", j);
            return;

        case 10111: 
            complete3DSecureTransactionOnActivityResult(intent, "Maestro Activity returned invalid result", j);
            return;

        case 10123: 
            complete3DSecureTransactionOnActivityResult(intent, "Secure3D Activity returned invalid result", j);
            return;

        case 10127: 
            completeJPAUTransactionOnActivityResult(intent, "JPAUEasyPay Activity returned invalid result ", j);
            return;

        case 10135: 
            completeTransactionOnActivityResult(intent, "OneClickPaymentPurchase Activity returned invalid result", j);
            return;

        case 10136: 
            completeTransactionOnActivityResult(intent, "RedcompraPurchase Activity returned invalid result", j);
            return;

        case 10137: 
            completeTransactionOnActivityResult(intent, "WebPayPurchase Activity returned invalid result", j);
            return;

        case 10139: 
            completeTransactionOnActivityResult(intent, "ExternalPurchase Activity returned invalid result", j);
            return;

        case 10143: 
            completeTransactionOnActivityResult(intent, "VisaPePurchase Activity returned invalid result", j);
            return;

        case 10144: 
            completeTransactionOnActivityResult(intent, "MastercardPePurchase Activity returned invalid result", j);
            return;

        case 10145: 
            completeTransactionOnActivityResult(intent, "PsePurchase Activity returned invalid result", j);
            return;

        case 10150: 
            completeTransactionOnActivityResult(intent, "AlipayPurchase Activity returned invalid result", j);
            break;
        }
    }

    private void completeJPAUTransaction(Intent intent)
    {
        intent = intent.getExtras().getString("payment_res");
        Object obj = currentPaymentMethod.getCompletePurchaseParams(intent);
        boolean flag = false;
        String s = null;
        intent = null;
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            NameValuePair namevaluepair = (NameValuePair)((Iterator) (obj)).next();
            if (Strings.equalsIgnoreCase(namevaluepair.name, "status_code"))
            {
                flag = Strings.equalsIgnoreCase(namevaluepair.value, "2010");
            } else
            if (Strings.equalsIgnoreCase(namevaluepair.name, "order_id"))
            {
                s = namevaluepair.value;
            } else
            if (Strings.equalsIgnoreCase(namevaluepair.name, "errorMessage"))
            {
                intent = namevaluepair.value;
            }
        } while (true);
        if (flag)
        {
            onOrderSuccess(s);
            return;
        }
        if (intent == null)
        {
            intent = getString(currentPaymentMethod.getErrorMessage());
        }
        onRefusedEvent(intent);
    }

    private void completeJPAUTransactionOnActivityResult(Intent intent, String s, int i)
    {
        if (i != -1)
        {
            onOrderFailure(new HttpResponseException(900, s));
            return;
        } else
        {
            completeJPAUTransaction(intent);
            return;
        }
    }

    private void completeTransaction(Intent intent)
    {
        final String paymentResUrl = intent.getExtras().getString("payment_res");
        intent = currentPaymentMethod.getCompletePurchaseParams(intent);
        userManager.updateOrderResult(intent, new Function1() {

            final PurchaseEu this$0;
            final String val$paymentResUrl;

            public void execute(Order order)
                throws RuntimeException
            {
                if (paymentResUrl.contains("authResult=AUTHORISED") || paymentResUrl.contains("authResult=PENDING"))
                {
                    onOrderSuccess(order);
                    return;
                }
                if (paymentResUrl.contains("authResult=CANCELLED"))
                {
                    onCancelEvent(currentPaymentMethod.getCancelMessage());
                    return;
                }
                if (paymentResUrl.contains("authResult=REFUSED"))
                {
                    onRefusedEvent(currentPaymentMethod.getErrorMessage());
                    return;
                } else
                {
                    onRefusedEvent(0x7f08019c);
                    return;
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Order)obj);
            }

            
            {
                this$0 = PurchaseEu.this;
                paymentResUrl = s;
                super();
            }
        }, new ReturningFunction1() {

            final PurchaseEu this$0;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                trackOrderFailureException(exception);
                onOrderFailure(exception);
                return Boolean.valueOf(true);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = PurchaseEu.this;
                super();
            }
        });
    }

    private void completeTransactionOnActivityResult(Intent intent, String s, int i)
    {
        if (i != -1)
        {
            if (currentCountryManager.getCurrentCountry().isRussia() && intent != null && intent.getExtras() != null && Strings.equals(intent.getExtras().getString("payment_res"), "result=False"))
            {
                GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(0x7f08019c)), "generic_error_dialog");
            }
            onOrderFailure(new HttpResponseException(900, s));
            return;
        }
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            logDealPurchaseConfirmation(null);
            showThanksScreen();
            return;
        } else
        {
            completeTransaction(intent);
            return;
        }
    }

    private void handleOrdersException(OrderException orderexception)
    {
        if (orderexception.requiredBillingRecordRevalidation || orderexception.failedBillingRecordRevalidation)
        {
            showConfirmCreditCardDialog(false);
            return;
        }
        if (orderexception.invalidMaxItemQuantity)
        {
            showMaxQuantityReachedDialog(orderexception);
            return;
        } else
        {
            displayOrdersErrorDialog();
            return;
        }
    }

    private void handleRussiaPayment()
    {
        logDealPurchaseInitiation();
        startActivityForResult(intentFactory.newExternalPurchaseIntent(dealId, dealOptionId, Strings.toString(Integer.valueOf(currentlySelectedQuantity))), 10139);
    }

    private boolean needsTwoStepPaymentFlow(Order order)
    {
        return amountChargedToCreditCardInCents > 0 && order.billingRecord != null && Strings.notEmpty(order.billingRecord.formUrl);
    }

    private void onCancelEvent(int i)
    {
        Toast.makeText(getApplicationContext(), i, 0).show();
        onOrderFailure(new HttpResponseException(900, getString(i)));
    }

    private void onOrderFailure(Exception exception)
    {
        logDealPurchaseConfirmation(exception);
        if (exception instanceof OrderException)
        {
            exception = (OrderException)exception;
            if (exception.getStatusCode() != 900)
            {
                handleOrdersException(exception);
            }
        }
        hideProcessingFeedback();
    }

    private void onOrderSuccess(Order order)
    {
        updateOrderId(order.id);
        onOrderSuccessExtra();
    }

    private void onOrderSuccess(String s)
    {
        updateOrderId(s);
        onOrderSuccessExtra();
    }

    private void onOrderSuccessExtra()
    {
        volatileBillingInfoProvider.clear();
        kochavaProvider.get().event("purchase", orderId);
        purchased = true;
        logDealPurchaseConfirmation(null);
        showThanksScreen();
    }

    private void onRefusedEvent(int i)
    {
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(Integer.valueOf(i)), "generic_error_dialog");
        onOrderFailure(new HttpResponseException(900, getString(i)));
    }

    private void onRefusedEvent(String s)
    {
        GrouponDialogFragment.show(getFragmentManager(), dialogManager.getDialogFragment(s), "generic_error_dialog");
        onOrderFailure(new HttpResponseException(900, s));
    }

    private void processTransaction()
    {
        ArrayList arraylist;
        boolean flag;
        showProcessingFeedback(true);
        logDealPurchaseInitiation();
        arraylist = new ArrayList();
        flag = ((LocalizedSharedPreferencesProvider)localizedSharedPreferencesProvider.get(this)).get().getBoolean("eagerlyApplyRewardPoints", true);
        if (amountChargedToCreditCardInCents > 0) goto _L2; else goto _L1
_L1:
        Object obj;
        Iterator iterator;
        java.util.Map.Entry entry;
        String s1;
        if (currentPaymentMethod != null)
        {
            obj = currentPaymentMethod;
        } else
        {
            obj = paymentMethodFactory.createPaymentMethod(deal, option, currentlySelectedQuantity, flag);
        }
        ((AbstractPaymentMethod) (obj)).addDefaultPurchaseParams(arraylist, currentlySelectedQuantity);
_L4:
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible() && customFieldMap != null)
        {
            obj = getCustomFieldMap(true);
            for (iterator = customFieldMap.entrySet().iterator(); iterator.hasNext();)
            {
                entry = (java.util.Map.Entry)iterator.next();
                s1 = (String)entry.getValue();
                if (Strings.notEmpty(s1))
                {
                    arraylist.addAll(Arrays.asList(new String[] {
                        String.format("custom_field[%s]", new Object[] {
                            ((HashMap) (obj)).get(entry.getKey())
                        }), s1
                    }));
                }
            }

        }
        break; /* Loop/switch isn't completed */
_L2:
        if (currentPaymentMethod == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (currentPaymentMethod.isCreditCard() || currentPaymentMethod.isServerSidePayment())
        {
            break; /* Loop/switch isn't completed */
        }
        currentPaymentMethod.addPurchaseParams(arraylist, currentlySelectedQuantity);
_L5:
        if (currentlySelectedInstallmentOption != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "installments", Integer.valueOf(currentlySelectedInstallmentOption.numberOfPayments)
            }));
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (volatileBillingInfoProvider.hasCreditCardDetails())
        {
            volatileBillingInfoProvider.addPaymentDetailsParams(arraylist);
            currentPaymentMethod.addCreditCardPurchaseParams(arraylist, currentlySelectedQuantity);
        } else
        {
            currentPaymentMethod.addPurchaseParams(arraylist, currentlySelectedQuantity);
            if (customFieldMap != null && customFieldMap.containsKey(CVV_STRING))
            {
                String s = (String)customFieldMap.get(CVV_STRING);
                if (Strings.notEmpty(s))
                {
                    arraylist.addAll(Arrays.asList(new String[] {
                        "billing_record_cvv", s
                    }));
                }
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        if (stockValue != null)
        {
            arraylist.addAll(Arrays.asList(new Object[] {
                com.groupon.Constants.Http.STOCK_ID, stockValue.id
            }));
        }
        if (canUseIncentiveTicket && selectedIncentiveTicket != null)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "incentive_ticket_type", selectedIncentiveTicket
            }));
            logger.logClick("", "confirm_purchase_button", "incentive_ticket", dealId);
        } else
        if (canUseGiftPoints && giftCode != null)
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "gift_code_type", giftCode.type, "gift_code_id", giftCode.id
            }));
        }
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            arraylist.addAll(shippingService.getAltHttpParams(userAddress));
            if (deal.shippingAddressRequired)
            {
                arraylist.addAll(shippingService.getMainHttpParams(shippingAddress));
            }
        }
        if (shouldShowSendAsGift())
        {
            addGiftingParameters(arraylist);
        }
        addMultiUsePromoCodeParameterIfNecessary(arraylist);
        iovationBlackboxUtil.addIovationParameterIfNeeded(arraylist);
        if (isCityDealCountry && isNewsletterOptInEnabled)
        {
            boolean flag1;
            if (newsletterOptin.getVisibility() == 8 || newsletterOptin.getVisibility() == 0 && newsletterOptin.isChecked())
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "subscribe_to_newsletter", Boolean.valueOf(flag1)
            }));
        }
        doAddUserPaymentStorageConsentIfNeeded(arraylist);
        processTransactionAPICall(arraylist, currentlySelectedQuantity);
        return;
    }

    private void processTransactionAPICall(List list, final int quantity)
    {
        userManager.saveOrderResult(list, lang, new Function1() {

            final PurchaseEu this$0;
            final int val$quantity;

            public void execute(Order order)
                throws RuntimeException
            {
                if (isCityDealCountry && isNewsletterOptInEnabled && newsletterOptin.getVisibility() == 0)
                {
                    Logger logger = PurchaseEu.this.logger;
                    String s1 = com/groupon/activity/Purchase.getSimpleName();
                    com.groupon.tracking.mobile.EncodedNSTField encodednstfield = Logger.NULL_NST_FIELD;
                    String s;
                    if (newsletterOptin.isChecked())
                    {
                        s = "opt-in";
                    } else
                    {
                        s = "opt-out";
                    }
                    logger.logClick("", "newsletter_opt_check", s1, encodednstfield, new NewsletterClickExtraInfo("newsletter", s));
                }
                setIsOrdersCallInProgress(false);
                if (needsTwoStepPaymentFlow(order))
                {
                    currentPaymentMethod.completePayment(order, quantity);
                    return;
                }
                try
                {
                    validateSuccess(order);
                    onOrderSuccess(order);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Order order)
                {
                    dialogManager.showAlertDialog(order, null);
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Order)obj);
            }

            
            {
                this$0 = PurchaseEu.this;
                quantity = i;
                super();
            }
        }, new ReturningFunction1() {

            final PurchaseEu this$0;

            public Boolean execute(Exception exception)
                throws RuntimeException
            {
                setIsOrdersCallInProgress(false);
                trackOrderFailureException(exception);
                onOrderFailure(exception);
                return handleOrderResultSaveException(exception);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = PurchaseEu.this;
                super();
            }
        });
    }

    private void trackOrderFailureException(Exception exception)
    {
        Ln.e(exception, "Failure during purchase", new Object[0]);
    }

    protected void initializeCountryBasedActions()
    {
        purchaseButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PurchaseEu this$0;

            public void onClick(View view)
            {
                if (currentCountryManager.getCurrentCountry().isRussia())
                {
                    handleRussiaPayment();
                } else
                if (!redirectToAddPaymentMethod() && !redirectToAddShippingAddress() && valid())
                {
                    showProcessingFeedback(true);
                    setIsOrdersCallInProgress(true);
                    if (userManager.hasAcceptedLegalTerms())
                    {
                        processTransaction();
                        return;
                    } else
                    {
                        userManager.acceptLegalTerms(new Function0() {

                            final _cls1 this$1;

                            public void execute()
                            {
                                processTransaction();
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        }, new Function1() {

                            final _cls1 this$1;

                            public void execute(Exception exception)
                            {
                                hideProcessingFeedback();
                            }

                            public volatile void execute(Object obj)
                                throws Exception
                            {
                                execute((Exception)obj);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        }, new Function0() {

                            final _cls1 this$1;

                            public void execute()
                            {
                                purchaseButton.stopSpinning();
                                setIsOrdersCallInProgress(false);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        });
                        return;
                    }
                }
            }

            
            {
                this$0 = PurchaseEu.this;
                super();
            }
        });
        refresh();
    }

    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (10121 == requestCode && resultCode == -1)
        {
            stockValue = (StockValue)data.getSerializableExtra("stockValue");
            return;
        }
        if (deal != null)
        {
            completeEcommerceTransaction(requestCode, resultCode, data);
            return;
        } else
        {
            requestSync(new Function0() {

                final PurchaseEu this$0;
                final Intent val$data;
                final int val$requestCode;
                final int val$resultCode;

                public void execute()
                {
                    completeEcommerceTransaction(requestCode, resultCode, data);
                }

            
            {
                this$0 = PurchaseEu.this;
                requestCode = i;
                resultCode = j;
                data = intent;
                super();
            }
            });
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
    }

    public boolean valid()
    {
        boolean flag3 = true;
        boolean flag2 = true;
        boolean flag4 = true;
        boolean flag = true;
        if (currentCountryManager.getCurrentCountry().isLATAMCompatible() && option.stockManagement && (stockValue == null || Strings.isEmpty(stockValue.id)))
        {
            Toast.makeText(getApplicationContext(), 0x7f080191, 1).show();
            return false;
        }
        if (currentPaymentMethod != null && !currentPaymentMethod.isCreditCard())
        {
            if (deal.shippingAddressRequired && !shippingService.isStored())
            {
                Toast.makeText(getApplicationContext(), 0x7f080192, 1).show();
                return false;
            } else
            {
                return true;
            }
        }
        boolean flag1;
        if (amountChargedToCreditCardInCents > 0)
        {
            BillingRecord billingrecord;
            if (currentPaymentMethod != null)
            {
                billingrecord = currentPaymentMethod.getBillingRecord();
            } else
            {
                billingrecord = null;
            }
            flag1 = flag4;
            if (billingrecord != null)
            {
                flag1 = flag4;
                if (Strings.notEmpty(billingrecord.billingRecordId))
                {
                    flag1 = flag4;
                    if (currentPaymentMethod.isOneClickRecurring())
                    {
                        flag1 = Strings.notEmpty(customFieldMap.get(CVV_STRING));
                    }
                }
            }
            flag2 = flag1;
            if (!flag1)
            {
                Toast.makeText(getApplicationContext(), 0x7f08018f, 1).show();
                flag2 = flag1;
            }
        }
        if (currentlySelectedQuantity == 0)
        {
            flag = false;
        }
        if (super.valid() && flag2 && flag)
        {
            flag1 = flag3;
        } else
        {
            flag1 = false;
        }
        return flag1;
    }

    protected void validateSuccess(Order order)
        throws GrouponException
    {
        if (Strings.isEmpty(order.id))
        {
            throw new GrouponException(getString(0x7f08018d));
        } else
        {
            return;
        }
    }










}
